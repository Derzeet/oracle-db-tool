package com.oracledb.retrieve.oraclefast.controllers;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.oracledb.retrieve.oraclefast.extractor.ResultFMExtractor;
import com.oracledb.retrieve.oraclefast.models.ResultFM;
import com.oracledb.retrieve.oraclefast.models.request;
import com.oracledb.retrieve.oraclefast.repositories.ResultFMRepository;
import com.oracledb.retrieve.oraclefast.services.ResultFMService;
import com.oracledb.retrieve.oraclefast.tools.PdfGenerator;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3000)
public class BaseController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ResultFMRepository repo;
    @Autowired
    private ResultFMService resultFMService;
    @GetMapping("/get")
    public HashMap<String, Object> getData(@RequestParam HashMap<String, String> req) {
        System.out.println(req);
//        List<ResultFM> r = resultFMService.getResults(req);
        String sql = resultFMService.getResults(req);
        System.out.println(sql);
//        Integer count = jdbcTemplate.queryForObject(sql.replace("*", "COUNT(*)"), Integer.class);
//        System.out.println(count);
        int page = Integer.parseInt(req.get("page")) * 10;
        List<ResultFM> r = jdbcTemplate.query(sql + "OFFSET " + page + " ROWS FETCH NEXT 10 ROWS ONLY", new ResultFMExtractor());
        for (ResultFM re: r) {
            System.out.println(re.getCfmMainCode());
        }
        HashMap<String, Object> res = new HashMap<>();
        res.put("rows", r);
        res.put("count", 3);
        return res;
    }

    @GetMapping("/count")
    public int count(@RequestParam HashMap<String, String> req) {
        System.out.println(req);
//        List<ResultFM> r = resultFMService.getResults(req);
        String sql = resultFMService.getResults(req);
//        System.out.println(sql);
        Integer count = jdbcTemplate.queryForObject(sql.replace("*", "COUNT(*)"), Integer.class);
//        System.out.println(count);
//        int page = Integer.parseInt(req.get("page")) * 10;
        return count;
    }

    @GetMapping(value = "/export-to-pdf/{MID}/{ID}", produces = MediaType.APPLICATION_PDF_VALUE)
    public @ResponseBody byte[] generatePdfFile(HttpServletResponse response, @PathVariable("MID")String MID,@PathVariable("ID") String ID) throws DocumentException, IOException
    {
        System.out.println(MID);
        response.setContentType("application/pdf");
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=student" + ".pdf";
        response.setHeader(headerkey, headervalue);
        List<ResultFM> r = jdbcTemplate.query("SELECT * FROM KFM.RESULT_FM WHERE MESS_OFM_ID  = '" + MID + "' AND MEMBER_ID = " + ID + " FETCH NEXT 10 ROWS ONLY ", new ResultFMExtractor());
        PdfGenerator generator = new PdfGenerator();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        generator.generate(r.get(0), baos);
        return baos.toByteArray();
    }
}

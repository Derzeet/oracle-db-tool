package com.oracledb.retrieve.oraclefast.controllers;

import com.lowagie.text.DocumentException;
import com.oracledb.retrieve.oraclefast.extractor.ResultFMExtractor;
import com.oracledb.retrieve.oraclefast.models.ResultFM;
import com.oracledb.retrieve.oraclefast.models.request;
import com.oracledb.retrieve.oraclefast.repositories.ResultFMRepository;
import com.oracledb.retrieve.oraclefast.services.ResultFMService;
import com.oracledb.retrieve.oraclefast.tools.PdfGenerator;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

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
    public List<ResultFM> getData(@RequestParam HashMap<String, String> req) {
//        System.out.println(req);

//        List<ResultFM> r = resultFMService.getResults(req);
        String sql = resultFMService.getResults(req);
        System.out.println(sql);
        List<ResultFM> r = jdbcTemplate.query(sql + " FETCH NEXT 10 ROWS ONLY", new ResultFMExtractor());
        for (ResultFM re: r) {
            System.out.println(re.getCfmMainCode());
        }
        return r;
    }

    @GetMapping("/export-to-pdf")
    public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException
    {
        response.setContentType("application/pdf");
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=student" + ".pdf";
        response.setHeader(headerkey, headervalue);
        List <ResultFM> listofStudents = resultFMService.findByMessOfmId();
        PdfGenerator generator = new PdfGenerator();
        generator.generate(listofStudents, response);
    }
}

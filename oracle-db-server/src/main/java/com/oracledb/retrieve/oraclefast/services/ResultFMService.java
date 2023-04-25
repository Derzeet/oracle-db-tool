package com.oracledb.retrieve.oraclefast.services;

import com.oracledb.retrieve.oraclefast.models.ResultFM;
import com.oracledb.retrieve.oraclefast.repositories.ResultFMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ResultFMService {
    @Autowired
    private ResultFMRepository resultFMRepository;

    public List<ResultFM> findByMessOfmId(BigDecimal id) {
        List<ResultFM> l = resultFMRepository.findAllByCfmMainCode("940140000385");
        return l;
    }

    public List<ResultFM> getResults(HashMap<String, String> req) {
        if (req.get("filter1").equals("cfmMainCode")) {
            if (req.get("aOr1").equals("none")) {
                return resultFMRepository.findAllByCfmMainCode(req.get("value1"));
            } else if (req.get("aOr1").equals("and")) {
                if (req.get("filter2").equals("messNumber")) {
                    //CFMMAINCODE AND MESSNUMBER
                } else if (req.get("filter2").equals("cfmName")) {
                    //CFMMAINCODE AND cfmName
                } else if (req.get("filter2").equals("operNumber")) {
                    //CFMMAINCODE and opernumber
                } else if (req.get("filter2").equals("memberMaincode")) {
                    //CFMMAINCODE and membermaincode
                }
            } else {
                if (req.get("filter2").equals("cfmMainCode")) {
                    //CFMMAINCODE OR CFMMAINCODE
                } else if (req.get("filter2").equals("messNumber")) {
                    //CFMMAINCODE or MESSNUMBER
                } else if (req.get("filter2").equals("cfmName")) {
                    //CFMMAINCODE or cfmName
                } else if (req.get("filter2").equals("operNumber")) {
                    //CFMMAINCODE or opernumber
                } else if (req.get("filter2").equals("memberMaincode")) {
                    //CFMMAINCODE or memberMaincode
                }
            }
        } else if (req.get("filter1").equals("messNumber")) {
            if (req.get("aOr1").equals("none")) {
                //nessNumberOnly
                BigDecimal messNumber = new BigDecimal(req.get("value1"));
                return resultFMRepository.findAllByMessNumber(messNumber);
            } else if (req.get("aOr1").equals("and")) {
                if (req.get("filter2").equals("cfmMainCode")) {
                    //CFMMAINCODE AND MESSNUMBER
                } else if (req.get("filter2").equals("cfmName")) {
                    //MESSNUMBER AND cfmName
                } else if (req.get("filter2").equals("operNumber")) {
                    //MESSNUMBER AND opernumber
                } else if (req.get("filter2").equals("memberMaincode")) {
                    //MESSNUMBER AND membermaincode
                }
            } else {
                if (req.get("filter2").equals("cfmMainCode")) {
                    //CFMMAINCODE or MESSNUMBER
                } else if (req.get("filter2").equals("messNumber")) {
                    //MESSNUMBER or MESSNUMBER
                } else if (req.get("filter2").equals("cfmName")) {
                    //MESSNUMBER or cfmName
                } else if (req.get("filter2").equals("operNumber")) {
                    //MESSNUMBER or opernumber
                } else if (req.get("filter2").equals("memberMaincode")) {
                    //MESSNUMBER or memberMaincode
                }
            }
        } else if (req.get("filter1").equals("cfmName")) {
            if (req.get("aOr1").equals("none")) {
                //cfmNameOnly
                return resultFMRepository.findAllByCfmName(req.get("value1"));
            } else if (req.get("aOr1").equals("and")) {
                if (req.get("filter2").equals("cfmMainCode")) {
                    //CFMMAINCODE AND cfmName
                } else if (req.get("filter2").equals("messNumber")) {
                    //MESSNUMBER AND cfmName
                } else if (req.get("filter2").equals("operNumber")) {
                    //cfmName AND opernumber
                } else if (req.get("filter2").equals("memberMaincode")) {
                    //cfmName AND membermaincode
                }
            } else {
                if (req.get("filter2").equals("cfmMainCode")) {
                    //CFMMAINCODE or cfmName
                } else if (req.get("filter2").equals("messNumber")) {
                    //MESSNUMBER or cfmName
                } else if (req.get("filter2").equals("cfmName")) {
                    //cfmName or cfmName
                } else if (req.get("filter2").equals("operNumber")) {
                    //cfmName or opernumber
                } else if (req.get("filter2").equals("memberMaincode")) {
                    //cfmName or memberMaincode
                }
            }
        } else if (req.get("filter1").equals("operNumber")) {
            if (req.get("aOr1").equals("none")) {
                //OperNumberOnly
                return resultFMRepository.findAllByOperNumber(req.get("value1"));
            } else if (req.get("aOr1").equals("and")) {
                if (req.get("filter2").equals("cfmMainCode")) {
                    //CFMMAINCODE AND opernumber
                } else if (req.get("filter2").equals("messNumber")) {
                    //MESSNUMBER AND opernumber
                } else if (req.get("filter2").equals("cfmName")) {
                    //cfmName AND opernumber
                } else if (req.get("filter2").equals("memberMaincode")) {
                    //opernumber AND membermaincode
                }
            } else {
                if (req.get("filter2").equals("cfmMainCode")) {
                    //CFMMAINCODE or opernumber
                } else if (req.get("filter2").equals("messNumber")) {
                    //MESSNUMBER or opernumber
                } else if (req.get("filter2").equals("cfmName")) {
                    //cfmName or opernumber
                } else if (req.get("filter2").equals("operNumber")) {
                    //opernumber or opernumber
                } else if (req.get("filter2").equals("memberMaincode")) {
                    //opernumber or memberMaincode
                }
            }
        } else if (req.get("filter1").equals("memberMaincode")) {
            if (req.get("aOr1").equals("none")) {
                //memberMaincodeOnly
                return resultFMRepository.findAllByMemberMaincode(req.get("value1"));
            } else if (req.get("aOr1").equals("and")) {
                if (req.get("filter2").equals("cfmMainCode")) {
                    //CFMMAINCODE AND memberMaincode
                } else if (req.get("filter2").equals("messNumber")) {
                    //MESSNUMBER AND memberMaincode
                } else if (req.get("filter2").equals("cfmName")) {
                    //cfmName AND memberMaincode
                } else if (req.get("filter2").equals("operNumber")) {
                    //opernumber AND membermaincode
                }
            } else {
                if (req.get("filter2").equals("cfmMainCode")) {
                    //CFMMAINCODE or memberMaincode
                } else if (req.get("filter2").equals("messNumber")) {
                    //MESSNUMBER or memberMaincode
                } else if (req.get("filter2").equals("cfmName")) {
                    //cfmName or memberMaincode
                } else if (req.get("filter2").equals("operNumber")) {
                    //opernumber or memberMaincode
                } else if (req.get("filter2").equals("memberMaincode")) {
                    //memberMaincode or memberMaincode
                }
            }
        }
        return new ArrayList<>();
    }
}

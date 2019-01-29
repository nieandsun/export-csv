package com.nrsc.exportcsv.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@RestController
public class ExportCsvFile {

    @GetMapping("/doExport")
    public void doExport(HttpServletResponse response) {


        List<Map<String, Object>> dataList = null;
        String displayColNames = null;
        String matchColNames = null;
        String fileName = null;
        String content = null;


        // 完成数据csv文件的封装
        displayColNames = "手机商品编码,手机类型,运营商,购机送费虚拟编码,存费送机虚拟编码";
        matchColNames = "PHONE_PARTNUM,PHONE_TYPE_NAME,TELECOM_OPR_NAME,GJSF_PARTNUM,CFSJ_PARTNUM";
        fileName = "phone_info_";

        content = CSVUtils2.formatCsvData(dataList, displayColNames, matchColNames);

        try {
            CSVUtils2.exportCsv(fileName, content, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

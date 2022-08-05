package org.deviget.qa.constants;

import lombok.Getter;

@Getter
public class FrameworkPaths {

    private  final String SYSTEMPATH = System.getProperty("user.dir");
    private  final String CONFIGPATH = SYSTEMPATH + "/src/test/java/org/deviget/qa/resources/Config.Properties";
    private  final String REPORTPATH = SYSTEMPATH + "/extent-test-output/index.html";
    private  final String EXCELPATH = SYSTEMPATH + "/src/test/java/org/deviget/qa/resources/data.xlsx";
    private  final String SCHEMAPATHS = SYSTEMPATH +"/src/test/java/org/deviget/qa/schemas/SchemaPhotos.json";

    public String getSYSTEMPATH() {
        return SYSTEMPATH;
    }

    public String getCONFIGPATH() {
        return CONFIGPATH;
    }

    public String getREPORTPATH() {
        return REPORTPATH;
    }

    public String getEXCELPATH() {
        return EXCELPATH;
    }

    public String getSCHEMAPATHS() {
        return SCHEMAPATHS;
    }
}

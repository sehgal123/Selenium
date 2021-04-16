package com.demo.constants;

import java.io.File;

public interface IGlobalConstants {

	/** //src//test//resources//. */
    String GLOBAL_TEST_RESOURCES_FOLDER = File.separator + "src" + File.separator + "test" + File.separator
            + "resources" + File.separator;

    /** //src//test//resources//data//. */
    String GLOBAL_DATA_FOLDER = GLOBAL_TEST_RESOURCES_FOLDER + File.separator + "DataFiles" + File.separator;

    /** //src//test//resources//data//environment.properties. */
    String ENVIRONMENT_PROPERTIES_PATH = GLOBAL_TEST_RESOURCES_FOLDER + "DataFiles" + File.separator
            + "environment.properties";
    
    /** //src//test//resources//drivers//. */
    String GLOBAL_DRIVERS_FOLDER = GLOBAL_TEST_RESOURCES_FOLDER + File.separator + "Drivers" + File.separator;

    /** //src//test//resources//drivers//geckodriver.exe. */
    String GECKO_DRIVER_PATH = GLOBAL_DRIVERS_FOLDER + File.separator + "geckodriver.exe";

    /** //src//test//resources//drivers//chromedriver.exe. */
    String CHROME_DRIVER_PATH = GLOBAL_DRIVERS_FOLDER + File.separator + "chromedriver.exe";
    
    /** //src//test//resources//drivers//IEDriverServer.exe. */
    String IE_DRIVER_PATH = GLOBAL_DRIVERS_FOLDER + File.separator + "IEDriverServer.exe";

    /** //src//test//resources//drivers//MicrosoftWebDriver.exe. */
    String EDGE_DRIVER_PATH = GLOBAL_DRIVERS_FOLDER + File.separator + "MicrosoftWebDriver.exe";
    
    String REPORT_FILE_PATH = File.separator + "Reports" + File.separator;
    
    /** //src//test//resources//ReportConfig. */
    String GLOBAL_REPORT_CONFIG_FOLDER = File.separator + "src" + File.separator + "test" + File.separator
            + "resources" + File.separator + "ReportConfig" + File.separator;
    
    /** TEST ENVIRONMENT USED. */
    String ENVIRONMENT = "QA";
    
    /** //src//test//resources//screenshots//. */
    String GLOBAL_SCREENSHOTS_FOLDER = File.separator + "Screenshots" + File.separator;

}

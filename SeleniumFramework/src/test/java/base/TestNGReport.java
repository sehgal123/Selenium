package base;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.List;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class TestNGReport implements ISuiteListener {
	@Override
	public void onStart(ISuite context) {
		// TODO Auto-generated method stub
	}
	
    @Override
	public void onFinish(ISuite suite) {
		try {
			File jsonfile = new File("target/");
			File reportOutputDirectory = new File("target/test-classes/reports/cucumberreports/");			
			String[] fileNames = jsonfile.list(new FilenameFilter() {
				@Override
				public boolean accept(File dir, String name) {
					if(name.endsWith(".json"))
						return true;
					else
						return false;
				}
			});
			
			List<String> jsonFiles = Arrays.asList(fileNames);

			Configuration configuration = new Configuration(reportOutputDirectory, suite.getName());
			// configuration.setStatusFlags(true, true, true);

			ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
			reportBuilder.generateReports();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
}

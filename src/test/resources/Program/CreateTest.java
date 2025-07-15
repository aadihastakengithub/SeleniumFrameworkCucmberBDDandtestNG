package com.appname.testBuilder;

import java.util.Properties;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appname.pwbase.LocalPageManager;
import com.appname.pwbase.Retry;
import com.appname.pwbase.TestBase;
import com.appname.testBuilderPages.TestBuilderCreate;
import com.appname.testBuilderPages.TestBuilderFooter;
import com.appname.testBuilderPages.TestBuilderList;
import com.appname.testBuilderPages.TestBuilderSourceSelect;
import com.appname.testBuilderPages.TestBuilderWorkflows;

public class CreateTest extends TestBase {
	@Test(dataProvider = "TestDataKeyProvider", retryAnalyzer = Retry.class)
	public void createTest(String testDataRowKey) throws Exception {
		TestBase.setTestData(testDataRowKey);
		TestBuilderWorkflows.testBuilderLoginFromLTI();
		TestBuilderList.clickCreateTestDropdown();
		TestBuilderList.clickCreateNewTestOption();
		TestBuilderCreate.clickAddQuestionButton();
		TestBuilderSourceSelect.clickChapterOneFirstISBN();
		TestBuilderSourceSelect.clickUseSourceButton();
		TestBuilderSourceSelect.clickCheckboxToSelectAll();
		TestBuilderSourceSelect.clickAddToTest();
		TestBuilderSourceSelect.enterTestName();
		TestBuilderFooter.clickFooterContinueButton();
		TestBuilderSourceSelect.selectDocx();
		TestBuilderFooter.clickFooterSubmitButton();
		TestBuilderSourceSelect.clickOkConfirmationModal();
		TestBuilderList.verifyTestPresent();

	}

	@DataProvider(name = "TestDataKeyProvider", parallel = true)
	public Object[][] getData() {
		Properties p = LocalPageManager.getPropertiesFile();
		String env = p.getProperty("appURL");
		Object[][] data = {{env}};
		return data;
	}
}

package com.zephyr_batch_5.stepdefinition;
import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_Search_227 extends LaunchBrowser {
	
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	TestPlanningPage tp;
	TestRepositoryPage tr;
	ExecutionPage ep;
	CreateTestCasePage ctc;
	DefectTracking dt;
	RequirementsPage req;
	boolean[] actual=new boolean[68];
	SoftAssert soft=new SoftAssert();
    String fileName="Defect_Tracking_Search_227";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Normal_Project_1");
    private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT, "Release_1");
	
	@Given("^DEFECTTRACKING is Launched by User$")
	public void defecttracking_is_Launched_by_User() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			lp=new LoginPage(driver);
			bp=new BasePage();
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ep=new ExecutionPage(driver);
			req=new RequirementsPage(driver);
			dt=new DefectTracking(driver);
			actual[0]=pp.selectProject(project);
			actual[1]=pp.selectRelease(release);
			actual[2]=pp.clickOnDefectTracking();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }  
	}

	@When("^user Searches defects by Affected version Contains long name$")
	public void user_Searches_defects_by_Affected_version_Contains_long_name() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 27, 2);
			bp.waitForElement();
		    actual[3]=dt.advancedSearch(jql, value);
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }    
	}

	@Then("^should able to search defects by Affected version consists long name$")
	public void should_able_to_search_defects_by_Affected_version_consists_long_name() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[4]=req.verifySearchRequirementCount();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@When("^User Searches defects by Affected version contains Long Name in TestExecution Page$")
	public void user_Searches_defects_by_Affected_version_contains_Long_Name_in_TestExecution_Page() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 27, 2);
			bp.waitForElement();
			actual[5]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[6]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[7]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[8]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[9]=ep.clickOnDefectButton(testcase1);
		    actual[10]=ep.defectSearch(jql, value);
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
             lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
		}              
	}

	@Then("^In Test Execution Page,Defects should search by Affected version consists long name$")
	public void in_Test_Execution_Page_Defects_should_search_by_Affected_version_consists_long_name() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[11]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[12]=ep.closeLinkedDefectWindow();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }  
	}

	@When("^user Searches defects by Affected version contains number In Defect tracking$")
	public void user_Searches_defects_by_Affected_version_contains_number_In_Defect_tracking() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 28, 2);
			actual[13]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[14]=dt.advancedSearch(jql, value);
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }  
	}

	@Then("^Should able To search defects by Affected version contains Number$")
	public void should_able_To_search_defects_by_Affected_version_contains_Number() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[15]=req.verifySearchRequirementCount();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@When("^User Searches defects by Affected version Contains number in TestExecution Page$")
	public void user_Searches_defects_by_Affected_version_Contains_number_in_TestExecution_Page() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 28, 2);
			actual[16]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[17]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[18]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[19]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[20]=ep.clickOnDefectButton(testcase1);
		    actual[21]=ep.defectSearch(jql, value);
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
             lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
		}               
	}

	@Then("^In Test Execution Page,Defects should search by Affected version contains Number$")
	public void in_Test_Execution_Page_Defects_should_search_by_Affected_version_contains_Number() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[22]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[23]=ep.closeLinkedDefectWindow();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }      
	}

	@When("^user Searches defects by Affected version contains special chars In defectTracking page$")
	public void user_Searches_defects_by_Affected_version_contains_special_chars_In_defectTracking_page() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 29, 2);
			actual[24]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[25]=dt.advancedSearch(jql, value);
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@Then("^Should able to search defects by Affected version contains special characters$")
	public void should_able_to_search_defects_by_Affected_version_contains_special_characters() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[26]=req.verifySearchRequirementCount();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@When("^User Searches defects by Affected version contain special chars in TestExecution Page$")
	public void user_Searches_defects_by_Affected_version_contain_special_chars_in_TestExecution_Page() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 29, 2);
			bp.waitForElement();
			actual[27]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[28]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[29]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[30]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[31]=ep.clickOnDefectButton(testcase1);
		    actual[32]=ep.defectSearch(jql, value);
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
             lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
		}           
	}

	@Then("^In Test Execution Page,Defects should search by Affected version consists special chars$")
	public void in_Test_Execution_Page_Defects_should_search_by_Affected_version_consists_special_chars() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[33]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[34]=ep.closeLinkedDefectWindow();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }  
	}

	@When("^user searches defects by Affected version contain  white spaces in defect tracking$")
	public void user_searches_defects_by_Affected_version_contain_white_spaces_in_defect_tracking() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 30, 2);
			actual[35]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[36]=dt.advancedSearch(jql, value);
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@Then("^To be able to search defects by Affected version contains  white spaces$")
	public void to_be_able_to_search_defects_by_Affected_version_contains_white_spaces() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[37]=req.verifySearchRequirementCount();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@When("^User Searches defects by Affected version contain  white spaces in TestExecution Page$")
	public void user_Searches_defects_by_Affected_version_contain_white_spaces_in_TestExecution_Page() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 30, 2);
			bp.waitForElement();
			actual[38]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[39]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[40]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[41]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[42]=ep.clickOnDefectButton(testcase1);
		    actual[43]=ep.defectSearch(jql, value);
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
             lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
		}        
	}

	@Then("^in Test Execution Page,Defects should search by Affected version contains  white spaces$")
	public void in_Test_Execution_Page_Defects_should_search_by_Affected_version_contains_white_spaces() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[44]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[45]=ep.closeLinkedDefectWindow();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }  
	}

	@When("^In defect Tracking page,user Searches defects by Affected version contain alpha numeric chars$")
	public void in_defect_Tracking_page_user_Searches_defects_by_Affected_version_contain_alpha_numeric_chars() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 31, 2);
			actual[46]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[47]=dt.advancedSearch(jql, value);
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}

	@Then("^should able to search defects by Affected version contains alpha numeric chars$")
	public void should_able_to_search_defects_by_Affected_version_contains_alpha_numeric_chars() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[48]=req.verifySearchRequirementCount();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@When("^user Searches defects by Affected version contain alpha numeric chars in TestExecution Page$")
	public void user_Searches_defects_by_Affected_version_contain_alpha_numeric_chars_in_TestExecution_Page() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 31, 2);
			bp.waitForElement();
			actual[49]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[50]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[51]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[52]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[53]=ep.clickOnDefectButton(testcase1);
		    actual[54]=ep.defectSearch(jql, value);
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
             lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
		}               
	}

	@Then("^In Test Execution Page,Defects should search by affected version consists Alpha numeric chars$")
	public void in_Test_Execution_Page_Defects_should_search_by_affected_version_consists_Alpha_numeric_chars() throws Throwable {
		try
		{
			bp.waitForElement();
			actual[55]=ep.verifySearchedDefectCount();
			bp.waitForElement();
			actual[56]=ep.closeLinkedDefectWindow();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@When("^user Searches defects by Affected version contain international chars in Defect Tracking Page$")
	public void user_Searches_defects_by_Affected_version_contain_international_chars_in_Defect_Tracking_Page() throws Throwable {
		try
		{
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 32, 2);
			actual[57]=pp.clickOnDefectTracking();
			bp.waitForElement();
		    actual[58]=dt.advancedSearch(jql, value);
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@Then("^should able to search defects by Affected version Contains International chars$")
	public void should_able_to_search_defects_by_Affected_version_Contains_International_chars() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[59]=req.verifySearchRequirementCount();
		}
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    } 
	}

	@When("^User Searches Defects by Affected version contain international chars in TestExecution Page$")
	public void user_Searches_Defects_by_Affected_version_contain_international_chars_in_TestExecution_Page() throws Throwable {
		try
		{
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 13, 3);
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 16, 2);
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			int testcase1=Excel_Lib.getNumberData(INPUT_PATH_7, "Excecution", 1, 0);
			String jql=Excel_Lib.getData(INPUT_PATH_7, "Search", 1, 1);
			String value=Excel_Lib.getData(INPUT_PATH_7, "Search", 32, 2);
			bp.waitForElement();
			actual[60]=rp.clickOnTestExecution();
			bp.waitForElement();
			actual[61]=tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[62]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[63]=ep.changeMultiSelectedStatus(status); 
			bp.waitForElement();
			actual[64]=ep.clickOnDefectButton(testcase1);
		    actual[65]=ep.defectSearch(jql, value);
		}
		catch(Exception e)
		{
			 lb=new LaunchBrowser();
             lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
		}           
	}

	@Then("^In Test Execution Page,Defects should search by Affected version Consists International chars$")
	public void in_Test_Execution_Page_Defects_should_search_by_Affected_version_Consists_International_chars() throws Throwable {
		try
		{
		bp.waitForElement();
		actual[66]=req.verifySearchRequirementCount();
		bp.waitForElement();
		actual[67]=ep.clickOnCancelDefectWindow();  
		for(int k=0;k<=actual.length-1;k++)
		{
			soft.assertEquals(actual[k], true);
		}
		soft.assertAll();
		}		
		catch(Exception e)
	    {
			 lb=new LaunchBrowser();
			 lb.getScreenShot(fileName);
			 e.printStackTrace();
			 driver.close();
			 Relogin_TPE rl=new Relogin_TPE();
			 rl.reLogin();
			 throw e;	
	    }
	}



}

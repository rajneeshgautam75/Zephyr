package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_265 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	ExecutionPage exep;
	DefectTracking dt;
	ExternalJiraPage ejp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	String fileName="Defect_Tracking_265";
	
	boolean[] actual=new boolean[35];
	SoftAssert soft=new SoftAssert();
	public String defectID;
	
	@Given("^User is in the page External Jira$")
	public void user_is_in_the_page_External_Jira() throws Throwable {
	try
	{
		 pp=new ProjectPage(driver);
		 rp=new ReleasePage(driver);
		 bp=new BasePage();
		 lp=new LoginPage(driver);
		 dt=new DefectTracking(driver);
		 tr=new TestRepositoryPage(driver);
		 tp=new TestPlanningPage(driver);
		 exep=new ExecutionPage(driver);
	     String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 actual[0]=pp.selectProject(projectName);
		 ejp=new ExternalJiraPage(driver);
		 pp.clickOnLogout(); 
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
	     String jiraUname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Username");
	     String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[1]=ejp.loginToExternalJira(jiraUname,jiraPwd);
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

	@When("^User navigate to the custom field page$")
	public void user_navigate_to_the_custom_field_page() throws Throwable {
	try
	   {
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,40);
		 String jiraPwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 ejp.closeNotificationMsg();
		 actual[2]=ejp.launchJiraAdministration(issueType);
		 actual[3]=ejp.enterAdministratorAccessPassword(jiraPwd);
		 actual[4]=ejp.navigateToCustomfields();
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

	@When("^delete the custom field of type checkbox$")
	public void delete_the_custom_field_of_type_checkbox() throws Throwable {
	try
	   {
		 String customFieldName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,57);
		 String configuration=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,52);
		 boolean res=ejp.checkAvailableCustomFields(customFieldName);
		 if(res==true)
		 {
			ejp.editCustomFieldValue(customFieldName, configuration);
			ejp.confirmDeleteCustomField();
		 }
		 actual[5]=ejp.logOutFromExternal_JIRA();
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

	@When("^launch defect tracking page$")
	public void launch_defect_tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     driver.navigate().to(zephyr_Url);
	     lp.enterUname(lead_Uname);
	     actual[6]=lp.enterPass(lead_Pass);
	     actual[7]=lp.clickOnLogin();
		 actual[8]=pp.selectProject(projectName);
		 actual[9]=pp.selectRelease(releaseName);
		 actual[10]=rp.clickOnDefectTracking();
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

	@When("^create a defect With minimum required fields$")
	public void create_a_defect_With_minimum_required_fields() throws Throwable {
	try
	   {
            String[] fields=new String[11];
            for(int i=0;i<=10;i++)
            {
            	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
            }
            String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
   		    String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		    String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
			String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		    actual[11]=dt.createDefect(project, issuetype);
			actual[12]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
		    actual[13]=dt.saveDefect();
		    defectID=dt.retrieveDefectId();
		    dt.updateDefect();
		    bp.waitForElement();
		    pp.clickOnLogout();
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

	@When("^as a manager,clear the cache$")
	public void as_a_manager_clear_the_cache() throws Throwable {
	try
    {	 
	     String manager_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String manager_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     driver.navigate().to(zephyr_Url);
	     lp.enterUname(manager_Uname);
	     lp.enterPass(manager_Pass);
	     bp.waitForElement();
	     actual[14]=lp.clickOnLogin();
		 actual[15]=pp.launchAdministration();
		 actual[16]=pp.launchDefectAdmin();
		 actual[17]=pp.clearCache();
		 actual[18]=pp.clickOnLogout();
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

	@When("^as a lead,search the created defect ID and edit the defect$")
	public void as_a_lead_search_the_created_defect_ID_and_edit_the_defect() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     lp.enterUname(lead_Uname);
	     lp.enterPass(lead_Pass);
	     actual[19]=lp.clickOnLogin();
		 actual[20]=pp.selectProject(projectName);
		 actual[21]=pp.selectRelease(releaseName);
		 actual[22]=rp.clickOnDefectTracking();
		 int[] defectNo=new int[1];
		 defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16);
		 actual[23]=dt.searchDefect(defectID);
		 actual[24]=dt.selectSingleOrMultipleDefects(defectNo);
		 actual[25]=dt.clickOnEditDefectButton();
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

	@Then("^Should be able to view the changes reflected in Zephyr$")
	public void should_be_able_to_view_the_changes_reflected_in_Zephyr() throws Throwable {
	try
	   {
		 String customFieldName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,57);
		 ejp.verifyCustomFieldInFileNewDefectPage(customFieldName);
		 driver.navigate().refresh();
		 for(int i=0;i<=3;i++)
		 {
			 bp.waitForElement();
		 }
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

	@When("^User launch the test execution and execute the testcase$")
	public void user_launch_the_test_execution_and_execute_the_testcase() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[26]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",16,12 );
		    bp.waitForElement();
			actual[27]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    actual[28]=exep.executeStatus(tcNo1[0], statusType1);
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

	@When("^click on D button and create the defect$")
	public void click_on_D_button_and_create_the_defect() throws Throwable {
	try
	   {
		   int testcase1=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16 );
		   String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,0);
		   String issuetype=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
		   actual[29]=exep.clickOnDefectButton(testcase1);
		   bp.waitForElement();
		   String[] fields=new String[11];
           for(int i=0;i<=10;i++)
           {
           	fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
           }
		    String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
			String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		    actual[30]=dt.createDefect(project, issuetype);
			actual[31]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8],fields[9],fields[10]);
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

	@Then("^should be able to view the changes reflected in zephyr$")
	public void should_be_able_to_view_the_changes_reflected_in_zephyr() throws Throwable {
	try
	   {
		String customFieldName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,57);
		ejp.verifyCustomFieldInFileNewDefectPage(customFieldName); 
		actual[32]=dt.clickOnCancelFileNewDefectButton();
		String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		actual[33]=exep.clickOnCancelDefectWindow();
		bp.waitForElement();
		actual[34]=tp.doubleClickOnCycle(releaseName);
		bp.waitForElement();

		for(int k=0;k<=actual.length-1;k++)
		{
			System.out.println("Actual["+k+"]="+actual[k]);
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

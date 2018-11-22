package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExternalJiraPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_JiraPermission_78 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	BasePage bp;
	TestRepositoryPage tr;
	RequirementsPage req;
	TestPlanningPage tp;
	ExecutionPage exep;
	CreateCustomFieldsPage ccfp;
	ExternalJiraPage ejp;
	DefectTracking dt;
	String fileName="Defect_Tracking_JiraPermission_78";
	
	boolean[] actual=new boolean[54];
	SoftAssert soft=new SoftAssert();
	
	private String[] fields=new String[12];
	{
	   for(int i=0;i<=11;i++)
	   {
	   fields[i]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100 ,100 );
	   }
	}
	 String project=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,0);
	 String defectIssueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,2);
     String defectSubtaskIssueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,31);
	 String summary=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,18);
	 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,64);
	 String desc=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
	 String defectID=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,30);
	@Given("^User Is in the External_Jira page$")
	public void user_Is_in_the_External_Jira_page() throws Throwable {
	try
    {
		 bp=new BasePage();
		 pp=new ProjectPage(driver);
		 dt=new DefectTracking(driver);
		 ccfp=new CreateCustomFieldsPage(driver);
		 ejp=new ExternalJiraPage(driver);
		 tp=new TestPlanningPage(driver);
		 req=new RequirementsPage(driver);
		 rp=new ReleasePage(driver);
		 tr=new TestRepositoryPage(driver);
		 exep=new ExecutionPage(driver);
		 pp.clickOnLogout();
		 lp=new LoginPage(driver);
	 	 
		 String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String Uname=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,64);
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
	     driver.navigate().to(jira_Url);
	     bp.waitForElement();
	     actual[0]=ejp.loginToExternalJira(Uname,Pwd);
	     ejp.closeNotificationMsg();
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

	@When("^Navigate to the Projects page$")
	public void navigate_to_the_Projects_page() throws Throwable {
	try
	   {
		 String issueType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,40);
		 actual[1]=ejp.launchJiraAdministration(issueType);
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

	@When("^change permission to the No Assign Issue$")
	public void change_permission_to_the_No_Assign_Issue() throws Throwable {
	try
	   {
		 String projectName=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",4,0);
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,52);
		 String defectPermissionType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",3,67);
		 ejp.closeNotificationMsg();
		 actual[2]=ejp.selectProjectAdministration(projectName);
		 actual[3]=ejp.changeDefectPermission(permissionValue,defectPermissionType);
		 ejp.closeNotificationMsg();
		 actual[4]=ejp.logOutFromExternal_JIRA();
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

	@When("^As a Manager,launch the Administration Page$")
	public void as_a_Manager_launch_the_Administration_Page() throws Throwable {
	try
    {
		 String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     String manager_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Username_1");
	     String manager_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Manager_Password_1");
	     driver.navigate().to(zephyr_Url);
	     actual[5]=lp.enterUname(manager_Uname);
	     actual[6]=lp.enterPass(manager_Pass);
	     actual[7]=lp.clickOnLogin();
	     actual[8]=pp.launchAdministration();
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

	@When("^launch the Defect Tracking to Set the DTS$")
	public void launch_the_Defect_Tracking_to_Set_the_DTS() throws Throwable {
	try
	   {
		 actual[9]=pp.clickOnDefectTracking();
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

	@When("^Set the DTS To the JIRA$")
	public void set_the_DTS_To_the_JIRA() throws Throwable {
	try
	   {
	     pp=new ProjectPage(driver);
	     String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
	     String jira_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"JIRA_URL");
		 String Uname=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,64);  
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 actual[10]=pp.clickOnDefectTracking();
		 actual[11]=ccfp.editDTS(DTS,jira_Url,Uname,Pwd);
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

	@Then("^Should Be able to Set an DTS to JIRA$")
	public void should_Be_able_to_Set_an_DTS_to_JIRA() throws Throwable {
	try
	   {
		 actual[12]=pp.validateSetDTS();
		 for(int i=0;i<=1;i++)
		 {
			 bp.waitForElement();
		 }
		 actual[13]=pp.launchDefectAdmin();
		 actual[14]=pp.clearCache();
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

	@When("^As a Lead,Launch the Defect_Tracking Page$")
	public void as_a_Lead_Launch_the_Defect_Tracking_Page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 String lead_Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Username_1");
	     String lead_Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Lead_Password_1");
	     String zephyr_Url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"URL");
	     //driver.navigate().to(zephyr_Url);
	     actual[15]=lp.enterUname(lead_Uname);
	     actual[16]=lp.enterPass(lead_Pass);
	     actual[17]=lp.clickOnLogin();
		 actual[18]=pp.selectProject(projectName);
		 actual[19]=pp.selectRelease(releaseName);
		 actual[20]=rp.clickOnDefectTracking();
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

	@Then("^Should Be Able to Launch Defect_Tracking page$")
	public void should_Be_Able_to_Launch_Defect_Tracking_page() throws Throwable {
	try
	   {
		 actual[21]=dt.validateDefectTrackingPage();
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

	@When("^Set the defect user who doesn't have assign issue permission$")
	public void set_the_defect_user_who_doesn_t_have_assign_issue_permission() throws Throwable {
	try
	   {
		 String Username=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,64);  
	     String Pwd=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Jira_Password");
		 actual[22]=req.dtsLoginDetail(Username,Pwd,Pwd);
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

	@When("^attempt to assign issues for defect with assignee in defect tracking app$")
	public void attempt_to_assign_issues_for_defect_with_assignee_in_defect_tracking_app() throws Throwable {
	try
	   {
			actual[23]=dt.createDefect(project,defectIssueType);
			actual[24]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],assignee,fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);
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

	@Then("^Should not be able to search users in assignee field$")
	public void should_not_be_able_to_search_users_in_assignee_field() throws Throwable {
	try
	   {
		 actual[25]=dt.filterCreatorValues();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^attempt to assign issues for subtask with assignee in defect Tracking app$")
	public void attempt_to_assign_issues_for_subtask_with_assignee_in_defect_Tracking_app() throws Throwable {
	try
	   {
			String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,14);
			actual[26]=dt.searchDefect(defectID);
			actual[27]=dt.selectAllDefects();
			actual[28]=dt.defectsOperation(defectValue);
			actual[29]=dt.createDefectSubtask(defectSubtaskIssueType);
			actual[30]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],assignee,fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);
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

	@Then("^should not be able to search users in assignee field in DT app$")
	public void should_not_be_able_to_search_users_in_assignee_field_in_DT_app() throws Throwable {
	try
	   {
		 actual[31]=dt.filterCreatorValues();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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
	
	@When("^attempt to assign issues in search defect view$")
	public void attempt_to_assign_issues_in_search_defect_view() throws Throwable {
	try
	   {
		 int[] defectNo=new int[1];
		 defectNo[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1,16);
		 actual[32]=dt.selectSingleOrMultipleDefects(defectNo);
		 actual[33]=dt.filterDefectAssigneeInSearchGridView(assignee);
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

	@Then("^Should not able to search users in assignee field using search defect view$")
	public void should_not_able_to_search_users_in_assignee_field_using_search_defect_view() throws Throwable {
	try
	   {
		 actual[34]=dt.filterCreatorValues();
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
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

	@When("^attempt to assign issues in change multiple window$")
	public void attempt_to_assign_issues_in_change_multiple_window() throws Throwable {
	try
	{
	     String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,64);
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,9);
		 String value=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,36);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,14);
		 String[] componentValue=new String[2];
		 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 String[] versionValue=new String[2];
		 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String[] fixversionvalue=new String[2];
		 fixversionvalue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 fixversionvalue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 int[] defectNo=new int[8];
		 for(int i=0;i<=defectNo.length-1;i++)
		 {
		 defectNo[i]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",i+1,16);
		 }
		 actual[35]=exep.defectSearch(selectSearch,value);
		 actual[36]=dt.selectSingleOrMultipleDefects(defectNo);
		 actual[37]=dt.defectsOperation(defectValue);
		 actual[38]=dt.changeMultipleDefect(componentValue,versionValue,fixversionvalue,fields[0],fields[1],fields[2],assignee);
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

	@Then("^Should not able to search users in assignee field using change multiple window$")
	public void should_not_able_to_search_users_in_assignee_field_using_change_multiple_window() throws Throwable {
	try
	{
	     String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,64);
		 actual[39]=dt.filterDefectAssigneeInChangeMultiple(assignee);
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

	@When("^Launch the Test_Execution Page$")
	public void launch_the_Test_Execution_Page() throws Throwable {
	try
	   {
		   bp.waitForElement();
		   actual[40]=rp.clickOnTestExecution(); 
           bp.waitForElement();
		   
		    String[] cycleName=new String[2];
		    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		    cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,13 );
		    cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",20,12 );
		    
		    bp.waitForElement();
			actual[41]=tr.navigateToNode(releaseName, cycleName);
			bp.waitForElement();
		
			int[] tcNo1=new int[1];
			tcNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking",1 ,16 );
		    String statusType1=Excel_Lib.getData(INPUT_PATH_3, "TestPlanning",1 ,18 );
		    bp.waitForElement();
		    exep=new ExecutionPage(driver);
		    actual[42]=exep.executeStatus(tcNo1[0], statusType1);
		    actual[43]=exep.clickOnDefectButton(tcNo1[0]);
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

	@When("^attempt to create defect with assignee in Test execution app$")
	public void attempt_to_create_defect_with_assignee_in_Test_execution_app() throws Throwable {
	try
	   {
			actual[44]=dt.createDefect(project,defectIssueType);
			actual[45]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],assignee,fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);
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

	@Then("^should not be able to search users in Assignee field$")
	public void should_not_be_able_to_search_users_in_Assignee_field() throws Throwable {
	try
	   {
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10,42);
		 actual[46]=dt.viewDefectPermissionMsg(permissionValue);
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

	@When("^attempt to create a subtask with assignee in Test execution app$")
	public void attempt_to_create_a_subtask_with_assignee_in_Test_execution_app() throws Throwable {
	try
	   {
			actual[47]=exep.searchDefect(defectID);
			actual[48]=exep.clickOnSubtask();
			actual[49]=dt.createDefectSubtask(defectSubtaskIssueType);
			actual[50]=dt.fileNewDefect(summary,fields[0],fields[1],desc,fields[2],fields[3],assignee,fields[4],fields[5],fields[6],fields[7],fields[8],fields[9]);
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

	@Then("^should not be able to search users in Assignee Field$")
	public void should_not_be_able_to_search_users_in_Assignee_Field() throws Throwable {
	try
	   {
		 String permissionValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",10,42);
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 actual[51]=dt.viewDefectPermissionMsg(permissionValue);
		 driver.navigate().refresh();
		 for(int i=0;i<=1;i++)
		 {
		 bp.waitForElement();
		 }
		 actual[52]=exep.clickOnCancelDefectWindow();
		 actual[53]=tp.doubleClickOnCycle(releaseName);
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

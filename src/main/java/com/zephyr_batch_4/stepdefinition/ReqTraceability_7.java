package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.RequirementsPage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ReqTraceability_7 extends LaunchBrowser {

	ProjectPage pp;
	ReleasePage rp;
	RequirementsPage req;
	TestRepositoryPage tr;
	DashBoardPage db;
	BasePage bp;
	TestPlanningPage tp;
	ExecutionPage exe;
	LaunchBrowser lb=new LaunchBrowser();
	String fileName="RequirementTraceability_7";

	boolean[] actual=new boolean[62];
	 SoftAssert soft=new SoftAssert();
	
	 
@When("^User add a Phase with name and description$")
public void user_add_a_Phase_with_name_and_description() throws Throwable {
	try
	{
	
		pp=new ProjectPage(driver);
		req=new RequirementsPage(driver);
	   tr=new TestRepositoryPage(driver);
	   String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	   String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 3, 1);
		String desc=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 3, 2);
		actual[0]=tr.clickOnRelease(releaseName);
		actual[1]=req.addNode(name, desc);
	   
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
	
}

@Then("^phase should be Created successfully$")
public void phase_should_be_Created_successfully() throws Throwable {
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	 String[] navigation=new String[1];
		navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 3, 1);
		
		actual[2]=tr.navigateToNode(releaseName, navigation);
		tr.clickDetailButton();
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
}

@When("^user Add five requirements to the phase$")
public void user_Add_five_requirements_to_the_phase() throws Throwable {
	try
	{
	for(int i=1;i<=5;i++)
	   {
		 String reqName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",i+5 , 18);
		   String reqDesc=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99 , 199);
		   String altID=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99 , 99);
		   String link=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99, 19);
		   String priority=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability",99 , 19);
		  
		   actual[3]=req.addRequirement();
		   String[] reqNum=new String[1];
			  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",i , 14));
			  actual[4]=req.selectMultipleRequirementFromGrids(reqNum);
				
			  actual[5]=req.enterRequirementDetails(reqName, altID, link, priority, reqDesc);
}
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
}

@Then("^Requirements successfully added to the phase$")
public void requirements_successfully_added_to_the_phase() throws Throwable {

	try
	{
	req.requirementCount();
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
	//req.selectAllRequirementsFormGrid();
}

@When("^user select the first Requirement$")
public void user_select_the_first_Requirement() throws Throwable {
	try
	{
	String[] reqNum=new String[1];
	  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",1 , 14));
	  actual[6]=req.selectMultipleRequirementFromGrids(reqNum);
		
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@When("^Map to testcase executed to status PASS and linked to defect with status In Progress$")
public void map_to_testcase_executed_to_status_PASS_and_linked_to_defect_with_status_In_Progress() throws Throwable {
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	 String[] phase=new String[1];
	 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
	 
   //tr.clickDetailButton();
	 actual[7]=req.MapTestCases();
	 actual[8]=req.ExpandRelease(releaseName);
	
	 actual[9]=tr.navigateNode(phase);
	
  String[] testcaseNo=new String[1];
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 3, 14));
	
	 actual[10]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
	 actual[11]=req.saveRequirement();
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@Then("^first requirement successfully Mapped to the testcase$")
public void first_requirement_successfully_Mapped_to_the_testcase() throws Throwable {
  
	try
	{
		actual[12]=req.validateMapedTestcase();
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@When("^user select the Second requirement$")
public void user_select_the_Second_requirement() throws Throwable {
	try
	{
		bp=new BasePage();
	   String[] reqNum=new String[1];
	  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",2 , 14));
	  actual[13]=req.selectMultipleRequirementFromGrids(reqNum);
	  actual[14]=bp.waitForElement();
		
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@When("^map to testcase executed to status Fail and linked to defect with status In Progress$")
public void map_to_testcase_executed_to_status_Fail_and_linked_to_defect_with_status_In_Progress() throws Throwable {
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	 String[] phase=new String[1];
	 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
	 
	// tr.clickDetailButton();
	 actual[15]=req.MapTestCases();
	 actual[16]=req.ExpandRelease(releaseName);
	
	 actual[17]=tr.navigateNode(phase);
	
  String[] testcaseNo=new String[1];
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 8, 14));
	
	actual[18]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
	actual[19]=req.saveRequirement();
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@Then("^Second requirement successfully mapped to the testcase$")
public void second_requirement_successfully_mapped_to_the_testcase() throws Throwable {
    
	try
	{
		actual[20]=req.validateMapedTestcase();
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@When("^user select the third Requirement$")
public void user_select_the_third_Requirement() throws Throwable {
	try
	{
	String[] reqNum=new String[1];
	  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",3 , 14));
	  actual[21]=req.selectMultipleRequirementFromGrids(reqNum);
		
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@When("^map to testcase executed to status WIP and linked to defect with status In Progress$")
public void map_to_testcase_executed_to_status_WIP_and_linked_to_defect_with_status_In_Progress() throws Throwable {
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	 String[] phase=new String[1];
	 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
	 
	// tr.clickDetailButton();
	 actual[22]=req.MapTestCases();
	 actual[23]=req.ExpandRelease(releaseName);
	
	 actual[24]=tr.navigateNode(phase);
	
   String[] testcaseNo=new String[1];
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 13, 14));
	
	actual[25]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
	actual[26]=req.saveRequirement();
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@Then("^third requirement successfully Mapped to the testcase$")
public void third_requirement_successfully_Mapped_to_the_testcase() throws Throwable {
  
	try
	{
		actual[27]=req.validateMapedTestcase();
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@When("^user select the Fourth requirement$")
public void user_select_the_Fourth_requirement() throws Throwable {
	try
	{
	String[] reqNum=new String[1];
	  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",4 , 14));
	  actual[28]=req.selectMultipleRequirementFromGrids(reqNum);
		
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@When("^Map to testcase executed to status Blocked and linked to defect with In Progress$")
public void map_to_testcase_executed_to_status_Blocked_and_linked_to_defect_with_In_Progress() throws Throwable {
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	 String[] phase=new String[1];
	 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
	 
	 //tr.clickDetailButton();
	 actual[29]=req.MapTestCases();
	 actual[30]=req.ExpandRelease(releaseName);
	
	 actual[31]=tr.navigateNode(phase);
	
   String[] testcaseNo=new String[1];
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 18, 14));
	
	actual[32]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
	actual[33]=req.saveRequirement();
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@Then("^fourth requirement successfully Mapped to the testcase$")
public void fourth_requirement_successfully_Mapped_to_the_testcase() throws Throwable {
   
	try
	{
		actual[34]=req.validateMapedTestcase();
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@When("^user select the Fifth requirement$")
public void user_select_the_Fifth_requirement() throws Throwable {
	try
	{
	String[] reqNum=new String[1];
	  reqNum[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability",5 , 14));
	  actual[35]=req.selectMultipleRequirementFromGrids(reqNum);
		
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@When("^Map to testcase executed to status Custom Status and linked to defect with In Progress$")
public void map_to_testcase_executed_to_status_Custom_Status_and_linked_to_defect_with_In_Progress() throws Throwable {
	try
	{
	String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");
	 String[] phase=new String[1];
	 phase[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 1);
	 
	// tr.clickDetailButton();
	 actual[36]=req.MapTestCases();
	 actual[37]=req.ExpandRelease(releaseName);
	
	 actual[38]=tr.navigateNode(phase);
	
   String[] testcaseNo=new String[1];
	
	testcaseNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 23, 14));
	
	actual[39]=req.mapTestCasesToRequirementsFromGrids(testcaseNo);
	actual[40]=req.saveRequirement();
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@Then("^fifth requirement successfully Mapped to the testcase$")
public void fifth_requirement_successfully_Mapped_to_the_testcase() throws Throwable {
  try
  {
	  actual[41]=req.validateMapedTestcase();
	  tr.clickOnList();
	
  }
  catch(Exception e)
	{

   lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
	Relogin_TPE rl=new Relogin_TPE();
	rl.reLogin();
	throw e;
	}  
  
	   
	
}

@When("^navigate to Manage Dashboard page$")
public void navigate_to_Manage_Dashboard_page() throws Throwable {
	try
	{
	db=new DashBoardPage(driver);
	actual[42]= db.clickOnManageDashboards();
	   
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@Then("^Dash_board page should be displayed$")
public void dash_board_page_should_be_displayed() throws Throwable {
    try
    {
    	actual[43]=db.validateDashboards();
	
    }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@When("^user add a new Dasboard with all details$")
public void user_add_a_new_Dasboard_with_all_details() throws Throwable {
	try
	{
		actual[44]=db.clickOnAddDashBoardSymbol();
	   String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 23, 1);
	   String desc=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 23, 2);
	   String layout=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 23, 3);
	   String shareType=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 23, 4);
	   actual[45]=db.enterDashBoardDetails(dashBoardName, desc, layout, shareType);
	   
	   
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@Then("^new Dashboard should be created successfully$")
public void new_Dashboard_should_be_created_successfully() throws Throwable {
	try
	{
	String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 23, 1);
	actual[46]=db.validateDashBoard(dashBoardName);
		
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@When("^user add Add Traceability Report gadget$")
public void user_add_Add_Traceability_Report_gadget() throws Throwable {
	try
	{
	String dashBoardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 23, 1);
	 String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 23, 5);
	 actual[47]=db.selectDashboard(dashBoardName);
	 actual[48]=db.clickOnAddGadgetSymbol();
	 actual[49]=db.addGadget(gadgetName);
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@Then("^Traceability report gadget added successfully$")
public void traceability_report_gadget_added_successfully() throws Throwable {
	try
	{
	String gadgetName=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 23, 5);
	actual[50]=db.validateGadget(gadgetName);
	
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@When("^user selects the requirements Map to testcases executed to Pass/Fail/WIP/Blocked/Custom Status and linked to defect with status open defect$")
public void user_selects_the_requirements_Map_to_testcases_executed_to_Pass_Fail_WIP_Blocked_Custom_Status_and_linked_to_defect_with_status_open_defect() throws Throwable {
	try
	{
	String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_1");
	   
    String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_1");

 String refreshRate=Excel_Lib.getData(INPUT_PATH_2, "DashBoard", 23, 6);
 actual[51]=db.configureTraceabilityGadget(projectName, releaseName, refreshRate);

for(int i=1;i<=5;i++)
{
	actual[52]=db.manageTraceability();
String searchOption=UNIQUE+Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", i+5, 18);
actual[53]=db.traceabilityQuickSearch(searchOption);
//db.
actual[54]=db.selectAllRequirements();
actual[55]=db.closeTraceabilityTable();

}

actual[56]=db.saveGadget();

	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}

@Then("^Should be able to view Pass/Fail/WIP/Blocked/Custom status with In Progress defect$")
public void should_be_able_to_view_Pass_Fail_WIP_Blocked_Custom_status_with_In_Progress_defect() throws Throwable {

	try
	{
	int reqNo1=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 1, 14);
	String executionStatus1=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 1, 15);
	String defectStatus1=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 2, 17);
	actual[57]=db.validateExecutionsInGadget(reqNo1, executionStatus1, defectStatus1);
	
	
	
	int reqNo2=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 2, 14);
	String executionStatus2=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 6, 15);
	String defectStatus2=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 2, 17);
	actual[58]=db.validateExecutionsInGadget(reqNo2, executionStatus2, defectStatus2);
	
	int reqNo3=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 3, 14);
	String executionStatus3=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 11, 15);
	String defectStatus3=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 2, 17);
	actual[59]=db.validateExecutionsInGadget(reqNo3, executionStatus3, defectStatus3);
	
	int reqNo4=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 4, 14);
	String executionStatus4=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 16, 15);
	String defectStatus4=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 2, 17);
	actual[60]=db.validateExecutionsInGadget(reqNo4, executionStatus4, defectStatus4);
	
	int reqNo5=Excel_Lib.getNumberData(INPUT_PATH_2, "ReqTraceability", 5, 14);
	String executionStatus5=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 21, 15);
	String defectStatus5=Excel_Lib.getData(INPUT_PATH_2, "ReqTraceability", 2, 17);
	actual[61]=db.validateExecutionsInGadget(reqNo5, executionStatus5, defectStatus5);
	
	pp.backToProjectPage();
	 }
    catch(Exception e)
	{
  
     lb.getScreenShot(fileName);
	   e.printStackTrace();
	   driver.close();
  	Relogin_TPE rl=new Relogin_TPE();
  	rl.reLogin();
  	throw e;
	}  
    
	   
}
	
}

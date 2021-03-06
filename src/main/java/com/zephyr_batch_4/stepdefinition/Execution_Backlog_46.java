package com.zephyr_batch_4.stepdefinition;


import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateCustomFieldsPage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Execution_Backlog_46 extends LaunchBrowser {
	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	BasePage bp;
	ReleasePage rp;
	DashBoardPage dp;
	TestRepositoryPage tr;
	TestPlanningPage tp;
	ExecutionPage ep;
	CreateCustomFieldsPage ccp;
	CreateTestCasePage ctc;
	boolean[] actual=new boolean[32];
	SoftAssert soft=new SoftAssert();
    String fileName="Execution_Backlog_46";
    private String project=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_1");
   	private String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Release_1");
@Given("^Test Manager credentials is logged by user$")
public void test_Manager_credentials_is_logged_by_user() throws Throwable {
		try
		{
			pp=new ProjectPage(driver);
			bp=new BasePage();
			lb=new LaunchBrowser();
			lp=new LoginPage(driver);
			dp=new DashBoardPage(driver);
		    bp.waitForElement();
		    pp.clickOnLogout();
			bp.waitForElement();
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
			bp.waitForElement();
			actual[0]=lp.enterUname(uname);
			actual[1]=lp.enterPass(password);
//			System.out.println("UserName is"+uname);
//			System.out.println("Password is"+password);
			lp.clickOnLogin();
			
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

	@When("^User is in custom field and lock the zephyr access$")
	public void user_is_in_custom_field_and_lock_the_zephyr_access() throws Throwable {
		try
	    {
			    ccp=new CreateCustomFieldsPage(driver);
			    ep=new ExecutionPage(driver);
			    actual[2]=bp.waitForElement();
     			ccp.moveToCustomFields();
				
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

	@When("^user creates a custom field Text or Long text or Number with all the mandatory fileds and enable unique feature$")
	public void user_creates_a_custom_field_Text_or_Long_text_or_Number_with_all_the_mandatory_fileds_and_enable_unique_feature() throws Throwable {
		try
	    {
			
			String customfieldName=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 4, 4);
			boolean res=ccp.checkAvailableCustomFields(customfieldName);
				if(res==false)
				{
				String customfieldDescription=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 1, 4);
				String dataType=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 2, 0);
				String piclistValues[]=new String[1];
				piclistValues[0]=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 100, 100);
				String allProject=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 100, 100);
				String projectName=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 1, 3);
				String searchableCheck=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 100, 100);
				String unique=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 2, 2);
				String mandatory=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 100, 100);
				bp.waitForElement();
				ccp.createCustomFields(customfieldName, customfieldDescription, dataType, piclistValues, allProject, projectName, searchableCheck, unique, mandatory);
				bp.waitForElement();
				ccp.closeCustomFieldWindow.click();
				}
				else
				{
					bp.waitForElement();
					ccp.closeCustomFieldWindow.click();
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

	@When("^user creates few Testcase with values for custom fields$")
	public void user_creates_few_Testcase_with_values_for_custom_fields() throws Throwable {
		try
	    {
			tp=new TestPlanningPage(driver);
			rp=new ReleasePage(driver);
			tr=new TestRepositoryPage(driver);
			ep=new ExecutionPage(driver);
			ctc=new CreateTestCasePage(driver);
			String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 10, 0);
			String desc=Excel_Lib.getData(INPUT_PATH_7, "Phase", 10, 1);
			bp.waitForElement();
			pp.clickOnLogout();
			bp.waitForElement();
			bp.waitForElement();
			String uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
			String password=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
			bp.waitForElement();
			actual[3]=lp.enterUname(uname);
			actual[4]=lp.enterPass(password);
			System.out.println("UserName is"+uname);
			System.out.println("Password is"+password);
			lp.clickOnLogin();
			bp.waitForElement();
			actual[5]=pp.selectProject(project);
			actual[6]=pp.selectRelease(release);
			String [] navigation=new String [1];
			navigation[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 10, 0);
			String text=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 1, 5);
			String longText=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 1, 7);
			String number=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CustomFields", 1, 8));
			String date=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 100, 100);
			String pickupList=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 1, 6);
			String checkBox=Excel_Lib.getData(INPUT_PATH_7, "CustomFields", 3, 6);
			bp.waitForElement();
			actual[7]=rp.clickOnTestRep();
			actual[8]=tr.clickOnRelease(release);
			tr.addNode(name, desc);
			bp.waitForElement();
		    tr.navigateToNode(release, navigation);
		    actual[9]=tr.addTestCase();
			bp.waitForElement();
			tr.clickDetailButton();
			bp.waitForElement();
			ctc.customFieldOption.click();
			actual[10]=ctc.enterCustomFields(text, longText, number, checkBox, pickupList, date);
			bp.waitForElement();
			for(int i=0;i<=1;i++)
			{
				actual[11]=tr.selectallTestCase();
				actual[12]=tr.cloneTestCase();
			}

			bp.waitForElement();
			
			tr.clickOnList();
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

	@When("^In Testplanning schedule and assign to anyone$")
	public void in_Testplanning_schedule_and_assign_to_anyone() throws Throwable {
		try
		{
			
			String cycle=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 23, 0);
			String Build=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 1);
			String Environment=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 1, 2);
			String hide=Excel_Lib.getData(INPUT_PATH_7, "Cycle", 100, 100);
			String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 0));
			String smonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 3, 1);
			String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 2));
			String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 3));
			String emonth=Excel_Lib.getData(INPUT_PATH_7, "CycleDate", 1, 4);
			String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_7, "CycleDate", 2, 5));
			String [] cycle1 =new String[1];
			cycle1[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle", 23, 0);
			String Phase=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase", 10,0);
			String Bulk_type=Excel_Lib.getData(INPUT_PATH_7,"BulkAssign", 2, 0);
			bp.waitForElement();
			rp.clickOnTestPlanning();
			actual[13]=tp.clickOnAddTestCycleSymbol();
			bp.waitForElement();
			actual[14]=tp.CreateCycle(cycle, Build, Environment, hide);
			bp.waitForElement();
			actual[15]=tp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
			bp.waitForElement();
			actual[16]=tp.saveTestCycle(); 
			bp.waitForElement(); 
			actual[17]=tp.navigateToCycle(cycle1);
			bp.waitForElement();
			actual[18]=tp.addPhaseToCycle(Phase);
			bp.waitForElement();
			tp.bulkAssignment(Bulk_type);
			tp.goBackToCycle();
			String[] cycleName=new String[2];          
			cycleName[0]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Cycle",23,0 );
			cycleName[1]=UNIQUE+Excel_Lib.getData(INPUT_PATH_7, "Phase",10,0 );
			String status=Excel_Lib.getData(INPUT_PATH_7, "Excecution", 1, 2);
			actual[19]=rp.clickOnTestExecution();
			bp.waitForElement();
			tr.navigateToNode(release, cycleName);
			bp.waitForElement();
			actual[20]=ep.selectAndDeselectAllTestCase();
			bp.waitForElement();
			actual[21]=ep.changeMultiSelectedStatus(status);
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

	@When("^Create dashboard and add execution backlog gadget$")
	public void create_dashboard_and_add_execution_backlog_gadget() throws Throwable {
    try
    {
    	    String name=UNIQUE+Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 7, 2);
		    String description=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 2);
		    String layout=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 4);
		    String shareType=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 3);
		    String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
		    bp.waitForElement();
		    actual[22]=dp.clickOnManageDashboards();
		    actual[23]=dp.clickOnAddDashBoardSymbol();
		    actual[24]=dp.enterDashBoardDetails(name, description, layout, shareType);
		    actual[25]=dp.selectDashboard(name);
			bp.waitForElement();
			actual[26]=dp.clickOnAddGadgetSymbol();
			bp.waitForElement();
			actual[27]=dp.addGadget(gadget);
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

	@Then("^execution backlog gadget should be added$")
	public void execution_backlog_gadget_should_be_added() throws Throwable {
		try
		{
			String gadget=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 2, 6);
			bp.waitForElement();
			actual[28]=dp.validateGadget(gadget);
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

	@When("^Configure filter by custom fields click on manage and search$")
	public void configure_filter_by_custom_fields_click_on_manage_and_search() throws Throwable {
		try
		{
			    String filterByName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 2);
		    	String values[]=new String[1];
		    	values[0]=Excel_Lib.getData(INPUT_PATH_7,"CustomFields", 4, 3);
		    	String refreshrate=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 1, 7);
				bp.waitForElement();
				actual[29]=dp.configureTraceabilityGadget(project, release, refreshrate);
				bp.waitForElement();
				bp.waitForElement();
				actual[30]=dp.filterBy(filterByName, values);
				dp.saveTraceabilityGadget();
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

	@Then("^should show custom fields properly$")
	public void should_show_custom_fields_properly() throws Throwable {
		try
	    {
			String filterByName=Excel_Lib.getData(INPUT_PATH_7,"AddDashboard", 12, 2);
			bp.waitForElement();
			actual[31]=dp.viewMsg(filterByName);
			bp.waitForElement();
			pp.navigateToProjectPage();
			for(int k=0;k<=actual.length-1;k++)
		     {
		      soft.assertEquals(actual[k], true);
		      System.out.println(actual[k]);
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

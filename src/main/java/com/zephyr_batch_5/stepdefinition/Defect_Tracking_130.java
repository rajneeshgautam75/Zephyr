package com.zephyr_batch_5.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.DefectTracking;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Defect_Tracking_130 extends LaunchBrowser{

	LaunchBrowser lb;
	ProjectPage pp;
	LoginPage lp;
	ReleasePage rp;
	BasePage bp;
	DefectTracking dt;
	ExecutionPage exep;
	String fileName="Defect_Tracking_130";
	
	boolean[] actual=new boolean[26];
	SoftAssert soft=new SoftAssert();
	
	String[] defectNo=new String[3];
	{
		defectNo[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16));
		defectNo[1]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 2,16));
		defectNo[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 3,16));
	}
	int[] defectNo1=new int[5];
	{
//		for(int i=1;i<=3;i++)
//		{
			defectNo1[0]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 1,16);
			defectNo1[1]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 2,16);
			defectNo1[2]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 3,16);
			defectNo1[3]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 4,16);
			defectNo1[4]=Excel_Lib.getNumberData(INPUT_PATH_3, "Defect Tracking", 5,16);
		//}
	}
	@Given("^User is in a Defect_Tracking page$")
	public void user_is_in_a_Defect_Tracking_page() throws Throwable {
	try
	   {
		 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Normal_Project_1");
		 String releaseName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DT,"Release_1");
		 pp=new ProjectPage(driver);
		 bp=new BasePage();
		 rp=new ReleasePage(driver);
		 dt=new DefectTracking(driver);
		 exep=new ExecutionPage(driver);
		 pp.selectProject(projectName);
		 pp.selectRelease(releaseName);
		 actual[0]=pp.clickOnDefectTracking();
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

	@When("^User search the defects by JQL$")
	public void user_search_the_defects_by_JQL() throws Throwable {
	try
	   {
		 String selectSearch=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,9);
		 String value=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,15);
		 dt.clickOnDefectAdvancedSearchButton();
		 actual[1]=dt.defectAdvancedSearch(selectSearch, value);
		 actual[2]=dt.selectSingleOrMultipleDefects(defectNo1);
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

	@When("^select the multiple defects and click on change multiple$")
	public void select_the_multiple_defects_and_click_on_change_multiple() throws Throwable {
	try
	   {
		 String[] componentValue=new String[2];
		 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,19);
		 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,19);
		 String[] versionValue=new String[2];
		 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String[] fixversionvalue=new String[2];
		 fixversionvalue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 fixversionvalue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,14);
		 String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 actual[3]=dt.defectsOperation(defectValue);
		 actual[4]=dt.changeMultipleDefect(componentValue, versionValue, fixversionvalue,status,resolution,priority,assignee);
		 bp.waitForElement();
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

	@Then("^Should be able to change values of Component$")
	public void should_be_able_to_change_values_of_Component() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 9,16);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",8,19);
		 actual[5]=dt.validateMultiEditDefect(defectNo, defectType, defectValue);
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

	@When("^select change multiple to change Version value$")
	public void select_change_multiple_to_change_Version_value() throws Throwable {
	try
	   {
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,14);
		 String[] componentValue=new String[2];
		 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String[] versionValue=new String[2];
		 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,20);
		 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,20);
		 String[] fixversionvalue=new String[2];
		 fixversionvalue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 fixversionvalue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 actual[6]=dt.selectSingleOrMultipleDefects(defectNo1);
		 actual[7]=dt.defectsOperation(defectValue);
		 actual[8]=dt.changeMultipleDefect(componentValue, versionValue, fixversionvalue, status, resolution, priority, assignee);
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

	@Then("^Should be able to change values of Version$")
	public void should_be_able_to_change_values_of_Version() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 9,16);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,20);
		 actual[9]=dt.validateMultiEditDefect(defectNo, defectType, defectValue);
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

	@When("^select change multiple to change Status$")
	public void select_change_multiple_to_change_Status() throws Throwable {
	try
	   {
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,14);
		 String[] componentValue=new String[2];
		 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String[] versionValue=new String[2];
		 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 String[] fixversionvalue=new String[2];
		 fixversionvalue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 fixversionvalue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,3);
		 String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 actual[10]=dt.selectSingleOrMultipleDefects(defectNo1);
		 actual[11]=dt.defectsOperation(defectValue);
		 actual[12]=dt.changeMultipleDefect(componentValue, versionValue, fixversionvalue, status, resolution, priority, assignee);
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

	@Then("^Should be able to change values of Status$")
	public void should_be_able_to_change_values_of_Status() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 3,1);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,3);
		 actual[13]=dt.validateMultiEditDefect(defectNo, defectType, defectValue);
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

	@When("^select change multiple to change the FixVersion$")
	public void select_change_multiple_to_change_the_FixVersion() throws Throwable {
	try
	   {
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,14);
		 String[] componentValue=new String[2];
		 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String[] versionValue=new String[2];
		 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 String[] fixversionvalue=new String[2];
		 fixversionvalue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,20);
		 fixversionvalue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,20);
		 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 actual[14]=dt.selectSingleOrMultipleDefects(defectNo1);
		 actual[15]=dt.defectsOperation(defectValue);
		 actual[16]=dt.changeMultipleDefect(componentValue, versionValue, fixversionvalue, status, resolution, priority, assignee);
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

	@Then("^Should be able to change values of the FixVersion$")
	public void should_be_able_to_change_values_of_the_FixVersion() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 9,1);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",7,20);
		 actual[17]=dt.validateMultiEditDefect(defectNo, defectType, defectValue);
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

	@When("^select change multiple to change the Priority$")
	public void select_change_multiple_to_change_the_Priority() throws Throwable {
	try
	   {
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,14);
		 String[] componentValue=new String[2];
		 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String[] versionValue=new String[2];
		 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 String[] fixversionvalue=new String[2];
		 fixversionvalue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 fixversionvalue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 1,6);
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 actual[18]=dt.selectSingleOrMultipleDefects(defectNo1);
		 actual[19]=dt.defectsOperation(defectValue);
		 actual[20]=dt.changeMultipleDefect(componentValue, versionValue, fixversionvalue, status, resolution, priority, assignee);
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

	@Then("^Should be able to change values of the Priority$")
	public void should_be_able_to_change_values_of_the_Priority() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",6,1);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",1,6);
		 actual[21]=dt.validateMultiEditDefect(defectNo, defectType, defectValue);
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

	@When("^select change multiple to change Assignee value$")
	public void select_change_multiple_to_change_Assignee_value() throws Throwable {
	try
	   {
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 2,14);
		 String[] componentValue=new String[2];
		 componentValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 componentValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String[] versionValue=new String[2];
		 versionValue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 versionValue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 String[] fixversionvalue=new String[2];
		 fixversionvalue[0]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 fixversionvalue[1]=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 String status=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",100,100);
		 String resolution=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String priority=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 100,100);
		 String assignee=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,4);
		 actual[22]=dt.selectSingleOrMultipleDefects(defectNo1);
		 actual[23]=dt.defectsOperation(defectValue);
		 actual[24]=dt.changeMultipleDefect(componentValue, versionValue, fixversionvalue, status, resolution, priority, assignee);
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

	@Then("^Should be able to change values of the Assignee$")
	public void should_be_able_to_change_values_of_the_Assignee() throws Throwable {
	try
	   {
		 String defectType=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking", 7,1);
		 String defectValue=Excel_Lib.getData(INPUT_PATH_3, "Defect Tracking",2,4);
		 actual[25]=dt.validateMultiEditDefect(defectNo, defectType, defectValue);
		 
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

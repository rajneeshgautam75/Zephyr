package com.zephyr_batch_4.stepdefinition;

import org.testng.asserts.SoftAssert;

import com.zephyr.common.LaunchBrowser;
import com.zephyr.generic.Excel_Lib;
import com.zephyr.generic.Property_Lib;
import com.zephyr.reusablemethods.BasePage;
import com.zephyr.reusablemethods.CreateTestCasePage;
import com.zephyr.reusablemethods.DashBoardPage;
import com.zephyr.reusablemethods.ExecutionPage;
import com.zephyr.reusablemethods.ExportPage;
import com.zephyr.reusablemethods.LoginPage;
import com.zephyr.reusablemethods.ProjectPage;
import com.zephyr.reusablemethods.ReleasePage;
import com.zephyr.reusablemethods.TestPlanningPage;
import com.zephyr.reusablemethods.TestRepositoryPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Overall_Defect_Gadget_11 extends LaunchBrowser{

	LaunchBrowser lb;
	LoginPage lp;
	ProjectPage pp;
	ReleasePage rp;
	TestRepositoryPage tr;
	ExportPage ep;
	BasePage bp;
	CreateTestCasePage ctc;
	TestPlanningPage tp;
	ExecutionPage exep;
	DashBoardPage dbp;
	String fileName="Overall_Defect_Gadget_11";
	
	boolean[] actual=new boolean[23];
	 SoftAssert soft=new SoftAssert();
	
	@Given("^Log in as manager$")
	public void log_in_as_manager() throws Throwable {
		try
	    {
			bp=new BasePage();
			pp=new ProjectPage(driver);
			pp.clickOnLogout();
			lp=new LoginPage(driver);
			//lb=new LaunchBrowser();
		 	 //lb.preCond();
		 	 //String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE,"URL");
		 	 //lb.getUrl(url);
		 	 
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Manager_Password_1");
		     actual[0]=lp.enterUname(Uname);
		     actual[1]=lp.enterPass(Pass);
		     //lp.clickOnLogin();
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

	@Then("^Manager is Logged in successfully$")
	public void manager_is_Logged_in_successfully() throws Throwable {
		try
		   {
			   actual[2]=lp.clickOnLogin();
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

	@When("^launch administration$")
	public void launch_administration() throws Throwable {
		try
		   {
			   pp=new ProjectPage(driver);
			   actual[3]=pp.launchAdministration();
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

	@When("^navigate to defectTracking to set DTS$")
	public void navigate_to_defectTracking_to_set_DTS() throws Throwable {
		try
		   {
			   pp=new ProjectPage(driver);
			   actual[4]=pp.clickOnDefectTracking();
			   
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

	@Then("^JIRA is set$")
	public void jira_is_set() throws Throwable {
		try
		   {
			 String DTS=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 17);  
			 String url=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 26);
			 String username=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 24);
			 String password=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 25);
			 actual[5]=pp.setDTS(DTS, url, username, password);
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

	@When("^launch manage projects to create a project name containing international char$")
	public void launch_manage_projects_to_create_a_project_name_containing_international_char() throws Throwable {
		try
		{
			  actual[6]=pp.launchAdministration();
	 	 	  bp.waitForElement();
	 	 	  actual[7]=pp.launchManageprojects();
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

	@Then("^international character project is created successfully$")
	public void international_character_project_is_created_successfully() throws Throwable {
		try
		{
 	 	String description=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100, 100);
 		String lead=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Lead_1");
 		String mapDefectProject=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);
 		String shareCheckbox=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 100,100);

 	 	String [] startDate=new String [3];
 	 	{
 	 	startDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 18));
 	 	startDate[1]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 19);
 	 	startDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 20));
 	 	}
 	 	
 	 	String [] endDate=new String [3];
 	 	{
 	 	endDate[0]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 21));
 	 	endDate[1]=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 22);
 	 	endDate[2]=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "DashBoards", 1, 23));
 	 	}
		  //System.out.println(result + " inside step definition");
 	 	String project1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH, "Normal_Project_4");
 	 	boolean result1=pp.validateProject(project1);
		  if(result1==false)
		   {
		  String typeName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1, 27);
		  actual[7]=pp.createProject(project1, description,typeName, lead, mapDefectProject, startDate, endDate, shareCheckbox);
		  bp.waitForElement();
			}
		  pp.clickOnLogout();
		   pp.closeBrowser();
   
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
	
	@When("^As a Lead,User select a project name containing international char and create international character release$")
	public void as_a_Lead_User_select_a_project_name_containing_international_char_and_create_international_character_release() throws Throwable {
		try
	    {
			bp=new BasePage();
			lb=new LaunchBrowser();
		 	 lb.preCond();
		 	 String url=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"URL");
		 	 lb.getUrl(url);
		 	 lp=new LoginPage(driver);
		 	 pp=new ProjectPage(driver);
		     String Uname=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Username_1");
		     String Pass=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Lead_Password_1");
		     lp.enterUname(Uname);
		     lp.enterPass(Pass);
		     lp.clickOnLogin();
		     
		        bp=new BasePage();
			    rp=new ReleasePage(driver);
			    pp=new ProjectPage(driver);
			    String internationalCharProject=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4");
			   //String releaseName4=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 6,0);
				   actual[8]=pp.selectProject(internationalCharProject);
				   rp=new ReleasePage(driver);
				   actual[9]=rp.clickOnManageRelease();
				   bp.waitForElement();
					String releaseName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
					boolean res1=rp.checkAvailableRelease(releaseName1);
					if(res1==false)
					{
			    	//String releaseName=Excel_Lib.getData(INPUT_PATH_3, "Releases", 2,0);
					String Hide=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
			    	String Desc=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
					String MapexternalDefect=Excel_Lib.getData(INPUT_PATH_3, "Requirements", 100,100);
			    	rp.addNewRelease(releaseName1, Desc, Hide, MapexternalDefect);
			    	String syear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 2));
					String smonth=Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 3);
					String sday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 4));
					String eyear=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 5));
					String emonth=Excel_Lib.getData(INPUT_PATH_3, "Projects", 0, 6);
					String eday=Integer.toString(Excel_Lib.getNumberData(INPUT_PATH_3, "Projects", 0, 7));
					rp.enterStartDatAndEndDateForRelease(syear, smonth, sday, eyear, emonth, eday);
					//rp.enterStartDatAndEndDate(syear, smonth, sday, eyear, emonth, eday);
					rp.clickOnAdd();
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


	@Then("^international character release is created$")
	public void international_character_release_is_created() throws Throwable {
		try
		   {
			   String releaseName1=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			   actual[10]=rp.checkAvailableRelease(releaseName1);
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

	@When("^User is in DashBoard page$")
	public void user_is_in_DashBoard_page() throws Throwable {
		try
	    {
	    	dbp=new DashBoardPage(driver);
			bp=new BasePage();
			actual[11]=dbp.clickOnManageDashboards();
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

	@Then("^DashBoard window should be launched$")
	public void dashboard_window_should_be_launched() throws Throwable {
		try
		{
			actual[12]=dbp.validateDashboards();
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

	@When("^User Create a dashBoard$")
	public void user_Create_a_dashBoard() throws Throwable {
		try
		{
		actual[13]=dbp.clickOnAddDashBoardSymbol();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,16);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[14]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@Then("^Created dashBoard is selected successfully$")
	public void created_dashBoard_is_selected_successfully() throws Throwable {
		try
		   {
			   String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 3,16);
			   actual[15]=dbp.validateDashBoard(dashboardName);
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

	@When("^Create a new dashBoard$")
	public void create_a_new_dashBoard() throws Throwable {
		try
		{
		actual[16]=dbp.clickOnAddDashBoardSymbol();
		String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,16);
		String desc=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,3);
		String layout=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 1,4);
		String shareType=Excel_Lib.getData(INPUT_PATH_3, "DashBoards",2,5);
		actual[17]=dbp.enterDashBoardDetails(dashboardName, desc, layout, shareType);
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

	@Then("^should be able to select a added dashboard$")
	public void should_be_able_to_select_a_added_dashboard() throws Throwable {
		try
		   {
			   String dashboardName=UNIQUE+Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 4,16);
			   dbp.searchDashboard(dashboardName)  ; 
			   
			   actual[18]=dbp.validateDashBoard(dashboardName);
			   dbp.selectDashboard(dashboardName);
			   
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

	@When("^Add 'Overall Defects Gadget' by clicking on the plus button$")
	public void add_Overall_Defects_Gadget_by_clicking_on_the_plus_button() throws Throwable {
		try
	    {
	    	actual[19]=dbp.clickOnAddGadgetSymbol();
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

	@Then("^Should be able to save gadget$")
	public void should_be_able_to_save_gadget() throws Throwable {
		try
		{
			 String gadgetName=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,6); 
			 actual[20]=dbp.addGadget(gadgetName);
			 String projectName=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Normal_Project_4"); 
			 String release=Property_Lib.getPropertyValue(CONFIG_PATH+CONFIG_FILE_DASH,"Release_5");
			 String refreshRate=Excel_Lib.getData(INPUT_PATH_3, "DashBoards", 2,8); 
			 actual[21]=dbp.configureTestAutomationStatusGadget(projectName, release, refreshRate);
			 
		     actual[22]=dbp.validateSavedGadget(projectName, release);
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

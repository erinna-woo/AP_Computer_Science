/*==============================================================================

name:       goalMine.java

purpose:    Goal Mine App

history:    

notes:
                    This program was created by Erinna and Denise.
         

==============================================================================*/
                                       // package ----------------------------//
package com.pumaj.gwt.example;
                                       // imports ----------------------------//
import java.awt.BorderLayout;
import java.sql.Date;

import com.allen_sauer.gwt.voices.client.Sound;
import com.allen_sauer.gwt.voices.client.SoundController;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.thirdparty.javascript.jscomp.graph.GraphColoring.Color;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.pumaj.gwt.PjApplicationGWT;

                                       // MyGWTWebApp ========================//
public class MyGWTWebApp extends PjApplicationGWT 
{
                                       // class constants --------------------//
                                       // panel width                         //

                                      // panel height                         //

                                       // public instance variables ----------//
                                       // (none)                              //
                                       // protected instance variables -------//
protected AbsolutePanel MinePanel;     // panel                               //
protected AbsolutePanel CompletedPanel;
protected AbsolutePanel CreatePanel;

protected String GOAL_NAME;


                         

/*------------------------------------------------------------------------------
 * PLAN: 
 * Make a tab panel and add things to that panel. 
 * 
 * Completed panel is the set of station buttons that pop up after you
 * click on a genre (main buttons)
 * 
 * NEED TO DO:
 * make the other panel's stuff go away when another button is clicked 
 */
/*------------------------------------------------------------------------------

@name       MyGWTWebApp - default constructor 
                                                                              */
                                                                             /**
            Default protected constructor to support extensions. 

@return     New MyGWTWebApp instance. 

@history    Thu Mar 22, 2012 13:00:00 (LBM) created.

                                                                              */
//------------------------------------------------------------------------------
public MyGWTWebApp()
{
   super();
}
/*------------------------------------------------------------------------------

@name       main - entry point method
                                                                              */
                                                                             /**
            Entry point method

@return     void

@param      args     always zero length; for signature compatibility

@history    Thu Mar 22, 2012 13:00:00 (LBM) created.

@notes
                                                                              */
//------------------------------------------------------------------------------
public void main(
   String[] args) 
{
	
       
    
     createPanels();
 	 
 
 	
   
   
}



/*-----------------------------------------------------------------------------

name:       Create a place for main Panels

purpose:    Setting a place to do everything! :) 

history:    Thu Mar 22, 2012 13:00:00 (LBM) created.

notes:

------------------------------------------------------------------------------*/
public void createPanels()
{

	//RootLayoutPanel myRootPanel = RootLayoutPanel.get(); should I use a root panel?
	
	/*HorizontalPanel mainbuttonspanel = new HorizontalPanel();
	 mainbuttonspanel.setSpacing(50);		
	  getContentPane().add(mainbuttonspanel);
	//mainbuttonspanel.getElement().getStyle().setBackgroundColor("0,0,0");
	
	  
	 fillMainButtonsPanel(mainbuttonspanel);

	 CompletedPanel = new AbsolutePanel();
     getContentPane().add(CompletedPanel);
     fillCompletedPanel(CompletedPanel);
     CompletedPanel.setVisible(false);
     
     MinePanel = new AbsolutePanel();
     getContentPane().add(MinePanel);
     fillMinePanel(MinePanel);
     MinePanel.setVisible(false);
     
     CreatePanel = new AbsolutePanel();
     getContentPane().add(CreatePanel);
     fillCreatePanel(CreatePanel);
     CreatePanel.setVisible(false);*/

     GoalForm myGoalForm= new GoalForm();
     getContentPane().add(myGoalForm);
     myGoalForm.setVisible(true);
     
     
    
	
}                       

/*-----------------------------------------------------------------------------

name:       fill maintab panel

purpose:    

history:    Thu Mar 22, 2012 13:00:00 (LBM) created.

notes:

------------------------------------------------------------------------------*/
public void fillMainButtonsPanel(final HorizontalPanel mainbuttonspanel)
{

	    Button CompletedButton = new Button("Completed");
	    //CompletedButton.getElement().getStyle().setBackgroundColor("0,0,0");
	     CompletedButton.addClickHandler(
	         new ClickHandler() 
	         {
	            public void onClick(ClickEvent event) 
	            {
	            	 
	            	MinePanel.setVisible(false); 
	            	CreatePanel.setVisible(false);
	            	CompletedPanel.setVisible(true);
	          	
	            }
	          });
	    mainbuttonspanel.add(CompletedButton);
	    
	    Button MineButton = new Button("Mine");
	     MineButton.addClickHandler(
	         new ClickHandler() 
	         {
	            public void onClick(ClickEvent event) 
	            {
	            	CompletedPanel.setVisible(false); 
	            	CreatePanel.setVisible(false);
	            	MinePanel.setVisible(true);	               
	            }
	          });
	    mainbuttonspanel.add(MineButton);
	    
	    Button CreateButton = new Button("Create");
	     CreateButton.addClickHandler(
	         new ClickHandler() 
	         {
	            public void onClick(ClickEvent event) 
	            {
	            	CompletedPanel.setVisible(false); 
	            	MinePanel.setVisible(false); 
	            	CreatePanel.setVisible(true);
	            }
	          });
	    mainbuttonspanel.add(CreateButton);

	    
}



/*-----------------------------------------------------------------------------

name:       fill completed panel

purpose:    

history:    Thu Mar 22, 2012 13:00:00 (LBM) created.

notes:

------------------------------------------------------------------------------*/
public void fillCompletedPanel(AbsolutePanel CompletedPanel)
{
	Label blah = new Label("Here is where Completed Stuff will go");
	CompletedPanel.add(blah);
	
	
}

/*-----------------------------------------------------------------------------

name:       fill mine panel

purpose:    

history:    Thu Mar 22, 2012 13:00:00 (LBM) created.

notes:

------------------------------------------------------------------------------*/
public void fillMinePanel(AbsolutePanel MinePanel)
{
	
	
	
	
}

/*-----------------------------------------------------------------------------

name:       fill mine panel

purpose:    

history:    Thu Mar 22, 2012 13:00:00 (LBM) created.

notes:

------------------------------------------------------------------------------*/
public void fillCreatePanel(AbsolutePanel CreatePanel)
{
	
	makeInputStuff();
	makeDifficultyButtons();
	//makeCalendar();

  
	
}
/*-----------------------------------------------------------------------------

name:       makeDifficulty Buttons

purpose:    It makes the Difficulty Buttons. 


notes:

------------------------------------------------------------------------------*/
public void makeDifficultyButtons()
{
	
	final Label DL = new Label("");
	
	
	
	HorizontalPanel hPanel = new HorizontalPanel();
	    hPanel.setSpacing(5);		
	    CreatePanel.add(hPanel);
	    										// add a button                        //
	    for (int i=1; i<11; i++) {
	    
	    final Button difficultyButton = new Button(""+i);
	      difficultyButton.addClickHandler(
	         new ClickHandler() 
	         {
	            public void onClick(ClickEvent event) 
	            {
	            	
	            	DL.setText(difficultyButton.getText());
	                 
	            }
	          });
	    hPanel.add(difficultyButton);
	    }
	    
	  hPanel.add(DL);


    
	
}
/*-----------------------------------------------------------------------------

name:       makeCalendar

purpose:    It makes the Calendar

history:    

notes:

------------------------------------------------------------------------------*/
/*public void makeCalendar()
{

	DatePicker datePicker = new DatePicker();
	final Label date = new Label();
	
	datePicker.addClickHandler(new ClickHandler() {
	      public void onClick(ValueChangeEvent<Date> event) {
	        Date date = event.getValue();
	        String dateString = DateTimeFormat.getMediumDateFormat().format(date);
	        date.setText(dateString);
	      }

			});

    
	
}*/

/*-----------------------------------------------------------------------------

name:       makeInputStuff

purpose:    It makes the Calendar

history:    

notes:

------------------------------------------------------------------------------*/
public void makeInputStuff()
{
	
	/*final Label NAME = new Label("");
	final Label DES = new Label("");
	final Label REW = new Label("Optional");
	
	CreatePanel.add(NAME);
	CreatePanel.add(DES);
	CreatePanel.add(REW);
	
	/*final TextBox goalTitle = new TextBox();
	final TextBox goalDes = new TextBox();
	final TextBox goalRew = new TextBox();*/ //put into goalForm
	/*
	goalTitle.getElement().setPropertyString("placeholder", "Title");
	goalDes.getElement().setPropertyString("placeholder", "Description");
	goalRew.getElement().setPropertyString("placeholder", "Reward");
	
	goalTitle.addValueChangeHandler(new ValueChangeHandler<String>() {
		public void onValueChange(ValueChangeEvent<String> event) {
			String input = new String();
			input = goalTitle.getValue();
			NAME.setText(input);
			
		}
		
	});

	goalDes.addValueChangeHandler(new ValueChangeHandler<String>() {
		public void onValueChange(ValueChangeEvent<String> event) {
			String input = new String();
			input = goalDes.getValue();
			DES.setText(input);
			
		}
		
	});
	
	goalRew.addValueChangeHandler(new ValueChangeHandler<String>() {
		public void onValueChange(ValueChangeEvent<String> event) {
			String input = new String();
			input = goalRew.getValue();
			REW.setText(input);
			
		}
		
	});

	CreatePanel.add(goalTitle);
	CreatePanel.add(goalDes);
	CreatePanel.add(goalRew);*/
	
}


                                       


}//====================================// end class MyGWTWebApp --------------//






 package com.pumaj.gwt.example; 

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.DateTimeFormat.PredefinedFormat;
import com.pumaj.gwt.example.MineDatabase.Category;
import com.pumaj.gwt.example.MineDatabase.GoalInfo;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;


public class GoalForm extends FlowPanel {

	TextBox goalTitle = new TextBox();
	TextBox goalDes = new TextBox();
	TextBox goalRew = new TextBox();
	DateBox dueDate = new DateBox();
	ListBox stuffHere = new ListBox();
	Button updateButton = new Button();
	Button createButton = new Button();

  private GoalInfo GoalInfo;

  public GoalForm() {
    
	AbsolutePanel inputPanelOnCreate = new AbsolutePanel();
	
    DateTimeFormat dateFormat = DateTimeFormat.getFormat(
        PredefinedFormat.DATE_LONG);
    dueDate.setFormat(new DateBox.DefaultFormat(dateFormat));
    inputPanelOnCreate.add(dueDate);
    this.add(inputPanelOnCreate);
    

    // Add the categories to the category box.
    final Category[] categories = MineDatabase.get().queryCategories();
    for (Category category : categories) {
      stuffHere.addItem(category.getDisplayName());
    }

    // Initialize the contact to null.
    setContact(null);

    // Handle events.
    updateButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        if (GoalInfo == null) {
          return;
        }

        // Update the contact.
        GoalInfo.setgoalTitle(goalTitle.getText());
        GoalInfo.setgoalRew(goalRew.getText());
        GoalInfo.setgoalDes(goalDes.getText());
        GoalInfo.setdueDate(dueDate.getValue());
        int categoryIndex = stuffHere.getSelectedIndex();
        GoalInfo.setCategory(categories[categoryIndex]);

        // Update the views.
        MineDatabase.get().refreshDisplays();
      }
    });
    createButton.addClickHandler(new ClickHandler() {
      public void onClick(ClickEvent event) {
        int categoryIndex = stuffHere.getSelectedIndex();
        Category category = categories[categoryIndex];
        GoalInfo = new GoalInfo(category);
        GoalInfo.setgoalTitle(goalTitle.getText());
        GoalInfo.setgoalRew(goalRew.getText());
        GoalInfo.setgoalDes(goalDes.getText());
        GoalInfo.setdueDate(dueDate.getValue());
        MineDatabase.get().addContact(GoalInfo);
        setContact(GoalInfo);
      }
    });
  }

  public void setContact(GoalInfo contact) {
    this.GoalInfo = contact;
    updateButton.setEnabled(contact != null);
    if (contact != null) {
      goalTitle.setText(contact.getgoalTitle());
      goalRew.setText(contact.getgoalRew());
      goalDes.setText(contact.getgoalDes());
      dueDate.setValue(contact.getdueDate());
      Category category = contact.getCategory();
      Category[] categories = MineDatabase.get().queryCategories();
      for (int i = 0; i < categories.length; i++) {
        if (category == categories[i]) {
          stuffHere.setSelectedIndex(i);
          break;
        }
      }
    }
  }
}
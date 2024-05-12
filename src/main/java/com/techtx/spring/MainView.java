package com.techtx.spring;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("") 
public class MainView extends VerticalLayout { 

  public MainView() {
    VerticalLayout todosList = new VerticalLayout(); 
    TextField taskField = new TextField(); 
    Button addButton = new Button("Add"); 
    addButton.addClickListener(click -> { 
      Checkbox checkbox = new Checkbox(taskField.getValue());
      todosList.add(checkbox);
    });
    addButton.addClickShortcut(Key.ENTER); 

    add( 
      new H1("Vaadin Todo"),
      todosList,
      new HorizontalLayout(
        taskField,
        addButton
      )
    );

    Button button = new Button("I'm a button");
    HorizontalLayout layout = new HorizontalLayout(button, new DatePicker("Pick a date"));
    button.addClickListener(clickEvent ->
            add(new Text("Clicked!")));

    layout.setDefaultVerticalComponentAlignment(Alignment.END);
    add(layout);


  }
}
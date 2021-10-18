package org.vaadin.mprdemo;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

public class LegacyView extends VerticalLayout implements View {
	
	public LegacyView() {
		addComponent(new Label("Here we are!"));
	}

	@Override
	public void detach() {
		System.out.println("UI.getCurrent(): "+UI.getCurrent());
		System.out.println("getUI(): "+getUI());
		super.detach();
	}

	@Override
	public void enter(ViewChangeEvent event) {
		addComponent(new Label("We entered!"));		
	}
}

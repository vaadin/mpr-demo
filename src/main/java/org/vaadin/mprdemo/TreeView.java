package org.vaadin.mprdemo;

import java.io.File;
import java.util.Date;

import org.vaadin.filesystemdataprovider.FileSelect;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.Route;
import com.vaadin.mpr.LegacyWrapper;

@Route(value = TreeView.ROUTE, layout = MyUI.class)
public class TreeView extends VerticalLayout implements HasUrlParameter<String>, AfterNavigationObserver {
    public static final String ROUTE = "tree";
    public static final String TITLE = "Tree";
	private String param;    

	public TreeView() {
		setAlignItems(Alignment.CENTER);
		FileSelect fileSelect = new FileSelect(new File(System.getProperty("user.dir")));
    	fileSelect.addValueChangeListener(event -> {
        	File file = fileSelect.getValue();
    		Date date = new Date(file.lastModified());
        	if (!file.isDirectory()) {
        		Notification.show(file.getPath()+", "+date+", "+file.length());        		
        	} else {
        		Notification.show(file.getPath()+", "+date);
        	}
    	});		
		LegacyWrapper treeWrapper = new LegacyWrapper(fileSelect);
		treeWrapper.setWidth("600px");
		treeWrapper.setHeight("600px");
        add(treeWrapper);
	}

	
	@Override
	public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
		param = parameter;
	}


	@Override
	public void afterNavigation(AfterNavigationEvent event) {
		if (param != null) {
			Notification.show(param);		
		}
	}
	
}

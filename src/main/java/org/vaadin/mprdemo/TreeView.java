package org.vaadin.mprdemo;

import java.io.File;
import java.util.Date;

import org.vaadin.filesystemdataprovider.FileSelect;
import org.vaadin.gwtav.ContentLengthConnectorResource;
import org.vaadin.gwtav.GwtVideo;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.mpr.LegacyWrapper;
import com.vaadin.server.ClassResource;
import com.vaadin.shared.ui.PreloadMode;

@Route(value = TreeView.ROUTE, layout = MyUI.class)
public class TreeView extends VerticalLayout {
    public static final String ROUTE = "tree";
    public static final String TITLE = "Tree";    

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
}

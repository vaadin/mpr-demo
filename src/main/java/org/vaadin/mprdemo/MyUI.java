package org.vaadin.mprdemo;

import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.mpr.core.HasLegacyComponents;
import com.vaadin.mpr.core.MprTheme;
import com.vaadin.ui.TabSheet;

@Route("")
@MprTheme("mytheme")
public class MyUI extends FlexLayout implements HasLegacyComponents {

    public MyUI () {
    	setSizeFull();
        final TabSheet layout = new TabSheet();
        layout.addTab(new SpreadsheetView(),"Spreadsheet");
        layout.addTab(new VideoView(),"Video");
        
        add(layout);
    }

}

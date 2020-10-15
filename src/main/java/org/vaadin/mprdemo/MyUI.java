package org.vaadin.mprdemo;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.mpr.core.MprTheme;

@Route("")
@MprTheme("mytheme")
public class MyUI extends AppLayout implements RouterLayout {

	private FlexLayout childWrapper = new FlexLayout();

    public MyUI () {
        DrawerToggle toggle = new DrawerToggle();
        addToNavbar(toggle);
        VerticalLayout layout = new VerticalLayout();
        layout.add(new RouterLink(SpreadsheetView.TITLE, SpreadsheetView.class));
        layout.add(new RouterLink(TreeView.TITLE, TreeView.class));
        layout.add(new RouterLink(VideoView.TITLE, VideoView.class));
        addToDrawer(layout);
        childWrapper.setSizeFull();
        setContent(childWrapper);
    }

	@Override
	public void showRouterLayoutContent(HasElement content) {
		childWrapper.getElement().appendChild(content.getElement());		
	}    
}

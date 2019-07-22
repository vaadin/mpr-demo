package org.vaadin.mprdemo;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.mpr.core.MprTheme;

@Route("")
@MprTheme("mytheme")
public class MyUI extends AppLayout implements RouterLayout {

	private FlexLayout childWrapper = new FlexLayout();
    private AppLayoutMenu menu = createMenu();

    public MyUI () {
        Image img = new Image("https://vaadin.com/images/vaadin-logo.svg", "Vaadin Logo");
        img.setHeight("35px");
        setBranding(img);

        menu.addMenuItems(
        		new AppLayoutMenuItem(SpreadsheetView.TITLE, SpreadsheetView.ROUTE),
        		new AppLayoutMenuItem(TreeView.TITLE, TreeView.ROUTE),
                new AppLayoutMenuItem(VideoView.TITLE, VideoView.ROUTE));

        childWrapper.setSizeFull();
        setContent(childWrapper);
                       
    }

	@Override
	public void showRouterLayoutContent(HasElement content) {
		childWrapper.getElement().appendChild(content.getElement());		
	}    
}

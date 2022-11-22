package org.vaadin.mprdemo;

import com.vaadin.annotations.Push;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.mpr.core.LegacyUI;
import com.vaadin.mpr.core.MprTheme;
import com.vaadin.server.VaadinSession;

@Push
@Route("")
@MprTheme("mytheme")
@CssImport("custom.css")
@LegacyUI(OldUI.class)
public class MyUI extends AppLayout implements RouterLayout, AppShellConfigurator {

	private static final String VAADIN_THEMES = "/VAADIN/themes/";

	private FlexLayout childWrapper = new FlexLayout();
	private String css;

	@SuppressWarnings("deprecation")
	public MyUI() {
		DrawerToggle toggle = new DrawerToggle();
		addToNavbar(toggle);
		VerticalLayout layout = new VerticalLayout();
		layout.add(new RouterLink(SpreadsheetView.TITLE, SpreadsheetView.class));
		layout.add(new RouterLink(TreeView.TITLE, TreeView.class));
		layout.add(new RouterLink(VideoView.TITLE, VideoView.class));
		layout.add(new RouterLink(LegacyRoute.TITLE, LegacyRoute.class));
		Icon button = VaadinIcon.USER.create();
		button.addClickListener(event -> {
			getUI().ifPresent(ui -> {
				ui.getSession().getSession().invalidate();
				ui.getPage().setLocation("http://localhost:8080/");
			});
		});
		layout.add(button);
		addToDrawer(layout);

		childWrapper.setSizeFull();
		setContent(childWrapper);
		OldUI ui = (OldUI) com.vaadin.ui.UI.getCurrent();
		if (ui != null) {
			Notification.show(ui.getHello());
			ui.getPage().addPopStateListener(e -> {
				String uriFragment = ui.getPage().getUriFragment();
				if (uriFragment != null) {
					uriFragment = uriFragment.substring(1);
					System.out.println("URI:" + uriFragment);
					UI.getCurrent().navigate(uriFragment);
				}
			});
		}
	}

	@Override
	public void onAttach(AttachEvent event) {
		if (event.getSession().getService().getDeploymentConfiguration().isProductionMode()) {
			event.getUI().getPage().executeJs("window.vaadin.debug=false;");
		}
		if (VaadinSession.getCurrent().getService().getDeploymentConfiguration().isProductionMode()) {
			Notification.show("Vaadin 8 runs in prod mode");
		}		
	}

	@Override
	public void showRouterLayoutContent(HasElement content) {
		childWrapper.removeAll();
		childWrapper.getElement().appendChild(content.getElement());
	}

}

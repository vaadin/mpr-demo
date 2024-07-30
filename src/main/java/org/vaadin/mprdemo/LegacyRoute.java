package org.vaadin.mprdemo;

import com.vaadin.flow.router.Route;
import com.vaadin.mpr.MprRouteAdapter;

@Route(value = LegacyRoute.ROUTE, layout = MyUI.class)
public class LegacyRoute extends MprRouteAdapter<LegacyView>{
    public static final String ROUTE = "legacy";
    public static final String TITLE = "Legacy";    

}

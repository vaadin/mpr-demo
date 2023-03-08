package org.vaadin.mprdemo;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.component.page.Push;
import com.vaadin.mpr.core.LegacyUI;
import com.vaadin.mpr.core.MprTheme;

@Push
@MprTheme("mytheme")
@LegacyUI(OldUI.class)
public class ApplicationConfig implements AppShellConfigurator {
}

package de.costache.demo;

import com.google.inject.Injector;
import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;

import javax.inject.Inject;

public class GuiceUIProvider extends UIProvider {
    @Inject
    private Injector injector;
    @Override
    public MyVaadinUI createInstance(UICreateEvent event) {
        return injector.getInstance(MyVaadinUI.class);
    }
    @Override
    public Class<MyVaadinUI> getUIClass(UIClassSelectionEvent event) {
        return MyVaadinUI.class;
    }
}
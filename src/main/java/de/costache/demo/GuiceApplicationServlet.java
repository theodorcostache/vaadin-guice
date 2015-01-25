package de.costache.demo;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.ServiceException;
import com.vaadin.server.SessionInitEvent;
import com.vaadin.server.SessionInitListener;
import com.vaadin.server.VaadinServlet;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@VaadinServletConfiguration(productionMode = false, ui = MyVaadinUI.class, widgetset = "de.costache.AppWidgetSet")
public class GuiceApplicationServlet extends VaadinServlet implements SessionInitListener {
    protected final GuiceUIProvider applicationProvider;
    @Inject
    public GuiceApplicationServlet(GuiceUIProvider applicationProvider) {
        this.applicationProvider = applicationProvider;
    }
    @Override
    protected void servletInitialized() {
        getService().addSessionInitListener(this);
    }
    @Override
    public void sessionInit(SessionInitEvent event) throws ServiceException {
        event.getSession().addUIProvider(applicationProvider);
    }
}
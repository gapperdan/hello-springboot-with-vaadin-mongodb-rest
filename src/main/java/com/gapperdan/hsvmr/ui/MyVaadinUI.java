package com.gapperdan.hsvmr.ui;

import com.gapperdan.hsvmr.view.UIScopedView;
import com.gapperdan.hsvmr.view.ViewScopedView;
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class MyVaadinUI extends UI {

    @Autowired
    private SpringViewProvider viewProvider;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);
        root.setSpacing(true);
        setContent(root);

        final CssLayout navigationBar = new CssLayout();
        navigationBar.addStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        navigationBar.addComponent(createNavigationButton("UI Scoped View",
                UIScopedView.VIEW_NAME));
        navigationBar.addComponent(createNavigationButton("View Scoped View",
                ViewScopedView.VIEW_NAME));
        root.addComponent(navigationBar);

        root.addComponent(new Label("Sample slider"));
        Slider slider = new Slider();
        slider.setMin(0);
        slider.setMax(100);
        root.addComponent(slider);

        final Panel viewContainer = new Panel();
        viewContainer.setSizeFull();
        viewContainer.setCaption("Sample Table");
        root.addComponent(viewContainer);
        root.setExpandRatio(viewContainer, 1.0f);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addProvider(viewProvider);
    }

    private Button createNavigationButton(String caption, final String viewName) {
        Button button = new Button(caption);
        button.addStyleName(ValoTheme.BUTTON_SMALL);
        button.addStyleName(ValoTheme.BUTTON_PRIMARY);

        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                MyVaadinUI.this.getUI().getNavigator().navigateTo(viewName);
            }
        });
        return button;
    }
}

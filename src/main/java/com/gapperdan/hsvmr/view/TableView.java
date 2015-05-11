package com.gapperdan.hsvmr.view;

import com.gapperdan.hsvmr.domain.Country;
import com.gapperdan.hsvmr.service.CountryServiceImpl;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.print.attribute.IntegerSyntax;
import java.util.List;

@SpringView(name = TableView.VIEW_NAME)
public class TableView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "";

    @Autowired
    CountryServiceImpl countryService;

    @PostConstruct
    void init() {
        setMargin(true);
        setSpacing(true);
        //addComponent(new Label("This is the table view"));

        Table table = new Table();

        // Define two columns for the built-in container
        table.addContainerProperty("Country Name", String.class, null);
        table.addContainerProperty("Country Code", String.class, null);
        table.addContainerProperty("Capital", String.class, null);
        table.addContainerProperty("Population",  Integer.class, null);

        // Add a few other rows using shorthand addItem()
        //table.addItem(new Object[]{"Philippines", 100456832}, 1);
        //table.addItem(new Object[]{"Sri Lanka", 83941034}, 2);
        //table.addItem(new Object[]{"United States Of America", 1173094810}, 3);
        //table.addItem(new Object[]{"Vatican City", 442471}, 4);

        List<Country> countries = countryService.getAll();

        for (Country country : countries) {
            table.addItem(
                    new Object[]{country.getName(),
                            country.getCode(),
                            country.getCapital(),
                            country.getPopulation()},
                    countries.indexOf(country));
        }

        //table.addItem(new Object[]{countries.get(0).getName(), countries.get(0).getPopulation()}, 5);

        // Show exactly the currently contained rows (items)
        table.setPageLength(table.size());

        addComponent(table);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // the view is constructed in the init() method()
    }
}

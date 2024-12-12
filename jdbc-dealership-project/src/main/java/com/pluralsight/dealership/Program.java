package com.pluralsight.dealership;

import org.apache.commons.dbcp2.BasicDataSource;

public class Program {

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(args[0]);
        dataSource.setPassword(args[1]);
        dataSource.setUrl("jdbc:mysql://localhost:3306/dealership");

        UserInterface ui = new UserInterface(dataSource);
        ui.display();
    }
}

    // take everyhting in main and put it in ui
// the only thing that should start up is the basicdatasource and ui in main.
    // create basicdatasource that connects to instance.


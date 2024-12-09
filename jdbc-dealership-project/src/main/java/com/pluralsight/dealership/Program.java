package com.pluralsight.dealership;

import com.pluralsight.dealership.dao.DealershipDaoMySqlImpl;
import com.pluralsight.dealership.model.Dealership;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Program {
//    public static void main(String[] args) {
//            // made an instance of userInterface
//            UserInterface ui = new UserInterface();
//            // Calls display method from ui
//            ui.display();
//        }
public static void main(String[] args) {

    String username = "";
    String password = "";
    if (args.length < 2){
        System.out.println("Please provide --username=? and --password=?");
        exit(1);
    }
    for (String s: args){
        String[] parts = s.split("=");
        if (parts[0].equalsIgnoreCase("--username"))
            username = parts[1];
        else if (parts[0].equalsIgnoreCase("--password"))
            password = parts[1];
        System.out.println(s);
    }

    String url = "jdbc:mysql://localhost:3306/dealership";

    BasicDataSource dataSource = initializeDataSource(url, password, username);

    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the integer dealership id: ");
    int dealershipId = scanner.nextInt();
    scanner.nextLine();


    DealershipDaoMySqlImpl dealershipDAO = new DealershipDaoMySqlImpl(dataSource);

    Dealership d = dealershipDAO.findDealershipById(dealershipId);

    System.out.printf("""
                Dealership:
                   id = %d
                   name = %s
                   phone = %s
                   address = %s
                """, d.getId(), d.getName(), d.getPhoneNumber(), d.getAddress());

    try {
        dataSource.close();
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    // made an instance of userInterface
    UserInterface ui = new UserInterface();
    // Calls display method from ui
    ui.display();
}

    private static BasicDataSource initializeDataSource(String url, String password, String username) {
        BasicDataSource dataSource;
        dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setPassword(password);
        dataSource.setUsername(username);
        return dataSource;
    }


    }


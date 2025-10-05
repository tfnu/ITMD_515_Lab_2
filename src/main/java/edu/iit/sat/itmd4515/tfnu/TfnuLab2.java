/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package edu.iit.sat.itmd4515.tfnu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tfnu
 */
public class TfnuLab2 {

    public static void main(String[] args) {

        String jdbcURL = "jdbc:mysql://localhost:3306/sakila?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String userName = "itmd4515";
        String password = "itmd4515";
        String query = "SELECT * FROM customer where last_name = ?";

        try (Connection connection = DriverManager.getConnection(jdbcURL, userName, password); PreparedStatement pst = connection.prepareStatement(query);) {

            ResultSet rs;
            pst.setString(1, "SMITH");
            rs = pst.executeQuery();

            while (rs.next()) {
                int customerId = rs.getInt("customer_id");
                String lastName = rs.getString("last_name");

                System.out.println(customerId + " " + lastName);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TfnuLab2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nathan
 */
public class ReadQuery {
    
    private Connection conn;
    private ResultSet results;
    
    public ReadQuery() {
        
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbconnection.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead() {
        
        try {
            String query = "Select * from CUSTOMERS_T ORDER BY CUSTID ASC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLTable() {
        
        String table = "";
        table += "<table border=1";
        
            table += "<tr>";
            table += "<th>";
            table += "Customer ID";
            table += "</th>";
            
            table += "<th>";
            table += "First Name";
            table += "</th>";
            
            table += "<th>";
            table += "Last Name";
            table += "</th>";
            
            table += "<th>";
            table += "Address 1";
            table += "</th>";
            
            table += "<th>";
            table += "Address 2";
            table += "</th>";
            
            table += "<th>";
            table += "City";
            table += "</th>";
            
            table += "<th>";
            table += "State";
            table += "</th>";
            
            table += "<th>";
            table += "Zip Code";
            table += "</th>";
            
            table += "<th>";
            table += "Email Address";
            table += "</th>";
                  
            
            table += "</tr>";
        
        
        try {
            while(this.results.next()) {
                
                Customers customer = new Customers();
                customer.setCustID(this.results.getInt("CUSTID"));
                customer.setFirstName(this.results.getString("FIRSTNAME"));
                customer.setLastName(this.results.getString("LASTNAME"));
                customer.setAddr1(this.results.getString("ADDR1"));
                customer.setAddr2(this.results.getString("ADDR2"));
                customer.setCity(this.results.getString("CITY"));
                customer.setState(this.results.getString("STATE"));
                customer.setZip(this.results.getString("ZIP"));
                customer.setEmailAddr(this.results.getString("EMAILADDR"));
                
                table += "<br>";
                table += "<td>";
                table += customer.getCustID();
                table += "</td>";
                
                table += "<td>";
                table += customer.getFirstName();
                table += "</td>";
                
                table += "<td>";
                table += customer.getLastName();
                table += "</td>";
                
                table += "<td>";
                table += customer.getAddr1();
                table += "</td>";
                
                table += "<td>";
                table += customer.getAddr2();
                table += "</td>";
                
                table += "<td>";
                table += customer.getCity();
                table += "</td>";
                
                table += "<td>";
                table += customer.getState();
                table += "</td>";
                
                table += "<td>";
                table += customer.getZip();
                table += "</td>";
                
                table += "<td>";
                table += customer.getEmailAddr();
                table += "</td>";
                
                table += "<td>";
                table += "<a href=update?custID=" + customer.getCustID() + "> Update </a>" + "<a href=delete?custID=" + customer.getCustID() + "> Delete </a>";
                table += "</td>";
                
                table += "</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table += "</table>";
        
            return table;
    }
    
}

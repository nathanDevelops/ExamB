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
import model.Customers;

/**
 *
 * @author Nathan
 */
public class ReadRecord {
    
    private Connection conn;
    private ResultSet results;
    
    private Customers customer = new Customers();
    private int custID;
    
    public ReadRecord (int custID){
    
    Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbconnection.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String password = props.getProperty("user.password");
        
        this.custID = custID;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void doRead() {
    
        try {
            String query = "SELECT * FROM CUSTOMER_T WHERE CUSTID = ?";
            
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, custID);
            
            this.results = ps.executeQuery();
            
            this.results.next();
            
            customer.setCustID(this.results.getInt("CUSTID"));
            customer.setFirstName(this.results.getString("FIRSTNAME"));
            customer.setLastName(this.results.getString("LASTNAME"));
            customer.setAddr1(this.results.getString("ADDR1"));
            customer.setAddr2(this.results.getString("ADDR2"));
            customer.setCity(this.results.getString("CITY"));
            customer.setState(this.results.getString("STATE"));
            customer.setZip(this.results.getString("ZIP"));
            customer.setEmailAddr(this.results.getString("EMAILADDR"));
                
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    }
    
    public Customers getCustomer(){
        
        return this.customer;
    }
    
}

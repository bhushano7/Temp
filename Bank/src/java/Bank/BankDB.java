/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class BankDB {

    ResultSet select(BankBean bb) throws Exception {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");//Load Driver
            Connection cn = DriverManager.getConnection("jdbc:odbc:BANK_DSN"); //Connection to Db

            Statement st1 = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String query = "SELECT * FROM customer WHERE id = " + bb.getId();
            ResultSet record = st1.executeQuery(query);
            return record;
        } catch (Exception ex) {
            throw ex;
        } finally {
        }        
    }
}

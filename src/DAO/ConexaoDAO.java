
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {



    private static final String url = "jdbc:mysql://localhost:3306/BeeFood?user=root&password=";

 
    public Connection conectaBD() {
        
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
         
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        return conn;
    }
}

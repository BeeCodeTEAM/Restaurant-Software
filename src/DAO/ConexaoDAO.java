
package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConexaoDAO {

    private static final String url = "jdbc:mysql://localhost:3306/Login";

    public Connection conectaBD() {
            try {
                // Alterar o nome do banco de dados, usuário e senha conforme necessário
                String url = "jdbc:mysql://localhost:3306/Login"; // banco de dados 'login'
                String usuario = "root"; // usuário do banco de dados
                String senha = "root"; // senha do banco de dados

                // Estabelecendo a conexão
                Connection conn = DriverManager.getConnection(url, usuario, senha);
                return conn;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

public class UsuarioDAO {
    Connection conn;

    public ResultSet autenticacaoUsuario(UsuarioDTO objUsuarioDTO) {
        // Chama a conexao com o banco de dados através do metodo "conectBD"
        conn = new ConexaoDAO().conectaBD();

        try {
            // Dentro dessa string esta o comando que sera enviado ao banco de dados 
            String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ?";
            PreparedStatement pspm = conn.prepareStatement(sql);

            // O prmeiro parametro refere se ao primeiro ponto de interrogação 
            // de dentro do comando SQL
            pspm.setString(1, objUsuarioDTO.getNome_usuario());
            pspm.setString(2, objUsuarioDTO.getSenha_usuario());

            // Executa o comando 
            ResultSet rs = pspm.executeQuery();
            // Retorna o ResultSet (A função tem como "Tipo a classe ResultSet")
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "usuario DAO : " + erro);
            return null;
        }

    }

    public Boolean RegistrarUsuario(UsuarioDTO novoUsuarioDTO) {

        Connection conn = null;
        String sql = "INSERT INTO usuario(nome_usuario, senha_usuario) VALUES ( ?, ?)";
        PreparedStatement pstm = null;

        try {
            conn = new ConexaoDAO().conectaBD();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, novoUsuarioDTO.getNomeRegistro_usuario());
            pstm.setString(2, novoUsuarioDTO.getSenhaRegistro_usuario());

            pstm.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Novo usuario DAO : " + e);
            return false;
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection conn;

    // Método para autenticação do usuário - agora retorna um boolean
    public boolean autenticacaoUsuario(UsuarioDTO objUsuarioDTO) {
        conn = new ConexaoDAO().conectaBD();
        PreparedStatement pspm = null;
        ResultSet rs = null;
        boolean autenticado = false;

        try {
            String sql = "SELECT * FROM usuario WHERE nome_usuario = ? AND senha_usuario = ?";
            pspm = conn.prepareStatement(sql);
            pspm.setString(1, objUsuarioDTO.getNome_usuario());  // Usando o getter para acessar o nome
            pspm.setString(2, objUsuarioDTO.getSenha_usuario());  // Usando o getter para acessar a senha

            rs = pspm.executeQuery();

            // Se o ResultSet contiver um registro, significa que a autenticação foi bem-sucedida
            if (rs.next()) {
                autenticado = true; // O usuário foi encontrado no banco de dados
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro no UsuarioDAO: " + erro.getMessage());
        } finally {
            try {
                if (pspm != null) {
                    pspm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return autenticado; // Retorna se o usuário foi autenticado ou não
    }

    // Método para registrar um novo usuário
    public boolean RegistrarUsuario(UsuarioDTO novoUsuarioDTO) {
        Connection conn = null;
        String sql = "INSERT INTO usuario(nome_usuario, senha_usuario) VALUES (?, ?)";
        PreparedStatement pstm = null;

        try {
            conn = new ConexaoDAO().conectaBD();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, novoUsuarioDTO.getNome_usuario());
            pstm.setString(2, novoUsuarioDTO.getSenha_usuario());

            pstm.executeUpdate();
            return true; // Usuário registrado com sucesso
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar usuário: " + e);
            return false; // Caso ocorra erro ao registrar
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
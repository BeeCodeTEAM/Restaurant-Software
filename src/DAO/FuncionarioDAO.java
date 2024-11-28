package DAO;

import DTO.FuncionarioDTO;
import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JOptionPane;

import DTO.UsuarioDTO;

public class FuncionarioDAO {
Connection conn;

    public ResultSet autenticacaoFuncionario(FuncionarioDTO objFuncionarioDTO) {
        // Chama a conexao com o banco de dados através do metodo "conectBD"
        conn = new ConexaoDAO().conectaBD();

        try {
            // Dentro dessa string esta o comando que sera enviado ao banco de dados 
            String sql = "select * from funcionario where nome_funcionario = ? and senha_funcionario = ?";
            PreparedStatement pspm = conn.prepareStatement(sql);

            // O prmeiro parametro refere se ao primeiro ponto de interrogação 
            // de dentro do comando SQL
            pspm.setString(1, objFuncionarioDTO.getNome_funcionario());
            pspm.setString(2, objFuncionarioDTO.getSenha_funcionario());

            // Executa o comando 
            ResultSet rs = pspm.executeQuery();
            // Retorna o ResultSet (A função tem como "Tipo a classe ResultSet")
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioAutenticação DAO : " + erro);
            return null;
        }
    }

    public Boolean RegistrarFuncionario(FuncionarioDTO novoFuncionarioDTO) {

        Connection conn = null;
        String sql = "INSERT INTO funcionario(nome_funcionario, senha_funcionario) VALUES ( ?, ?)";
        PreparedStatement pstm = null;

        try {
            conn = new ConexaoDAO().conectaBD();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, novoFuncionarioDTO.getNome_funcionario());
            pstm.setString(2, novoFuncionarioDTO.getSenha_funcionario());

            pstm.executeUpdate();
            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Novo usuario DAO : " + e);
            return null;
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
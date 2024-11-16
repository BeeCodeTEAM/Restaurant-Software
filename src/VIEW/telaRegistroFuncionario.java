package VIEW;

import DAO.FuncionarioDAO;
import DTO.FuncionarioDTO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaRegistroFuncionario {
    JFrame telaRegistro = new JFrame("Registro");
    JPanel jpnRegistro = new JPanel();

    public telaRegistroFuncionario() {
        telaRegistro.setBounds(500, 500, 800, 550);
        telaRegistro.setUndecorated(true);
        telaRegistro.setLocationRelativeTo(null);
        telaRegistro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaRegistro.setResizable(false);
        telaRegistro.setLayout(null);

        // Usuario do funcionario
        JLabel labelRegistroFuncionario = new JLabel("Usuario: ");
        labelRegistroFuncionario.setFont(new Font("Verdana", Font.BOLD, 25));
        labelRegistroFuncionario.setBounds(35, 50, 250, 40);

        // Input Usuario do Funcionario
        JTextField textRegistroFuncionario = new JTextField();
        textRegistroFuncionario.setBounds(60, 115, 400, 40);

        // Texto senha
        JLabel labelRegistroSenhaFuncionario = new JLabel("Senha: ");
        labelRegistroSenhaFuncionario.setFont(new Font("Verdana", Font.BOLD, 25));
        labelRegistroSenhaFuncionario.setBounds(35, 160, 250, 40);

        // Input Password
        JPasswordField textRegistroSenhaFuncionario = new JPasswordField();
        textRegistroSenhaFuncionario.setBounds(60, 235, 400, 40);

        // Codigo de Funcionario
        JLabel labelFuncionarioCode = new JLabel("Codigo de Funcionario: ");
        labelFuncionarioCode.setFont(new Font("Verdana", Font.BOLD, 25));
        labelFuncionarioCode.setBounds(35, 280, 350, 40);

        JTextField textCodeFuncionario = new JTextField();
        textCodeFuncionario.setBounds(60, 355, 400, 40);

        // Botao Registrar
        JButton botaoRegistro = new JButton("Registrar");
        botaoRegistro.setBounds(150, 455, 150, 60);

        jpnRegistro.setBackground(new Color(94, 100, 165));
        jpnRegistro.setBounds(400, 0, 400, 550);

        telaRegistro.add(textCodeFuncionario);
        telaRegistro.add(labelFuncionarioCode);
        telaRegistro.add(botaoRegistro);
        telaRegistro.add(textRegistroFuncionario);
        telaRegistro.add(textRegistroSenhaFuncionario);
        telaRegistro.add(labelRegistroFuncionario);
        telaRegistro.add(labelRegistroSenhaFuncionario);
        telaRegistro.add(jpnRegistro);

        telaRegistro.setVisible(true);

        // Ação do Botão Registrar
        botaoRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nome_funcionario, senha_funcionario;
                    nome_funcionario = textRegistroFuncionario.getText();
                    senha_funcionario = new String(textRegistroSenhaFuncionario.getPassword());

                    FuncionarioDTO objNovoFuncionarioDTO = new FuncionarioDTO();
                    objNovoFuncionarioDTO.setNome_funcionario(nome_funcionario);
                    objNovoFuncionarioDTO.setSenha_funcionario(senha_funcionario);

                    FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();

                    // Registrar funcionário
                    boolean registradoComSucesso = objFuncionarioDAO.RegistrarFuncionario(objNovoFuncionarioDTO);
                    if (registradoComSucesso) {
                        // Verifica se o código do funcionário é o correto
                        if (textCodeFuncionario.getText().equals("100")) {
                            JOptionPane.showMessageDialog(null, "Funcionario Registrado com Sucesso!");
                            telaRegistro.dispose(); // Fecha a tela de registro
                            new telaLoginInterface(); // Abre a tela de login
                        } else {
                            JOptionPane.showMessageDialog(null, "Codigo de Funcionario Incorreto.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro ao registrar. Tente novamente.");
                    }

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao registrar o funcionário: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        new telaRegistroFuncionario();
    }
}
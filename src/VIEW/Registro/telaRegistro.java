package VIEW.Registro;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaRegistro {
    JFrame telaRegistro = new JFrame("Registro");
    JPanel jpnRegistro = new JPanel();

    /**
     * 
     */
    public telaRegistro() {

        telaRegistro.setBounds(500, 500, 800, 550);
        telaRegistro.setUndecorated(true);

        telaRegistro.setLocationRelativeTo(null);
        telaRegistro.setDefaultCloseOperation(3);
        telaRegistro.setResizable(false);
        telaRegistro.setLayout(null);

        JLabel labelRegistroUsuario = new JLabel();
        labelRegistroUsuario.setText("Usuario: ");
        labelRegistroUsuario.setFont(new Font("Verdana", Font.BOLD, 25));
        labelRegistroUsuario.setBounds(35, 50, 250, 40);

        JTextField textRegistroUsuario = new JTextField();
        textRegistroUsuario.setBounds(60, 115, 400, 40);
        textRegistroUsuario.setEnabled(true);

        JLabel labelRegistroSenha = new JLabel();
        labelRegistroSenha.setText("Senha: ");
        labelRegistroSenha.setFont(new Font("Verdana", Font.BOLD, 25));

        labelRegistroSenha.setBounds(35, 160, 250, 40);

        JPasswordField textRegistroSenha = new JPasswordField();
        textRegistroSenha.setBounds(60, 235, 400, 40);
        textRegistroSenha.setEnabled(true);


        JButton botaoRegistro = new JButton("Registrar");
        botaoRegistro.setBounds(150, 355, 150, 60);

        JButton botaoRegistroFuncionario = new JButton("Registro Funcionario");
        botaoRegistroFuncionario.setBounds(150, 425, 150, 60);

        jpnRegistro.setBackground(new Color(94,100,165));
        jpnRegistro.setBounds(400, 0, 400, 550);


 
        // Register Button NORMAL / FUNCIONARIO
        telaRegistro.add(botaoRegistro);
        telaRegistro.add(botaoRegistroFuncionario);

        //Register Elements User
        telaRegistro.add(labelRegistroUsuario);
        telaRegistro.add(labelRegistroSenha);

        // Register Elements Password
        telaRegistro.add(textRegistroUsuario);
        telaRegistro.add(textRegistroSenha);

        //Design Half Screen other color
        telaRegistro.add(jpnRegistro);

        // Turn  all modifies and Screens Visible
        telaRegistro.setVisible(true);



        botaoRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String nome_usuario, senha_usuario;

                    nome_usuario = textRegistroUsuario.getText();
                    senha_usuario = textRegistroSenha.getText();

                    UsuarioDTO objNovoUsuarioDTO = new UsuarioDTO();

                    objNovoUsuarioDTO.setNomeRegistro_usuario(nome_usuario);
                    objNovoUsuarioDTO.setSenhaRegistro_usuario(senha_usuario);

                    UsuarioDAO objusuarioDAO = new UsuarioDAO();
                    objusuarioDAO.RegistrarUsuario(objNovoUsuarioDTO);

                    if (objusuarioDAO.RegistrarUsuario(objNovoUsuarioDTO)) {
                        JOptionPane.showMessageDialog(null, "REGISTROU");
                        telaLoginInterface telaInicial = new telaLoginInterface();
                        
                        // chamar tela q eu quero abrir
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
                        // enviar mensagem dizendo incorreto
                    }

                } finally {
                    System.out.println("Registro Funcional");
                }
            }
        });

        botaoRegistroFuncionario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            telaRegistroFuncionario telaRegistroFunc = new telaRegistroFuncionario();
            telaRegistro.setVisible(false);


            }
        });
    }

}

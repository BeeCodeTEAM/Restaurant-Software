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

    boolean isFuncionario = true;

    /**
     *
     */
    public telaRegistroFuncionario() {

        telaRegistro.setBounds(500, 500, 800, 550);
        telaRegistro.setUndecorated(true);

        telaRegistro.setLocationRelativeTo(null);
        telaRegistro.setDefaultCloseOperation(3);
        telaRegistro.setResizable(false);
        telaRegistro.setLayout(null);

         // Usuario do funcionario
        JLabel labelRegistroFuncionario = new JLabel();
        labelRegistroFuncionario.setText("Usuario: ");
        labelRegistroFuncionario.setFont(new Font("Verdana", Font.BOLD, 25));
        labelRegistroFuncionario.setBounds(35, 50, 250, 40);

        // INPUT USARIO DO FUNCIONARIO
        JTextField textRegistroFuncionario = new JTextField();
        textRegistroFuncionario.setBounds(60, 115, 400, 40);
        textRegistroFuncionario.setEnabled(true);

        // TEXTO ESCRITO SENHA
        JLabel labelRegistroSenhaFuncionario = new JLabel();
        labelRegistroSenhaFuncionario.setText("Senha: ");
        labelRegistroSenhaFuncionario.setFont(new Font("Verdana", Font.BOLD, 25));
        labelRegistroSenhaFuncionario.setBounds(35, 160, 250, 40);

        // INPUT PASSWORD
        JPasswordField textRegistroSenhaFuncionario = new JPasswordField();
        textRegistroSenhaFuncionario.setBounds(60, 235, 400, 40);
        textRegistroSenhaFuncionario.setEnabled(true);

        // TEXTO CODIGO DE FUNCIONARIO
        JLabel labelFuncionarioCode = new JLabel();
        labelFuncionarioCode.setText("Codigo de Funcionario: ");
        labelFuncionarioCode.setFont(new Font("Verdana", Font.BOLD, 25));
        labelFuncionarioCode.setBounds(35, 280, 350, 40);



        JPasswordField textCodeFuncionario = new JPasswordField();
        textCodeFuncionario.setBounds(60, 355, 400, 40);
        textCodeFuncionario.setEnabled(true);

        JButton botaoRegistro = new JButton("Registrar");
        botaoRegistro.setBounds(150, 455, 150, 60);


        jpnRegistro.setBackground(new Color(94,100,165));
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

        botaoRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String nome_funcionario, senha_funcionario;

                    nome_funcionario = textRegistroFuncionario.getText();
                    senha_funcionario = textRegistroSenhaFuncionario.getText();

                    FuncionarioDTO objNovoFuncionarioDTO = new FuncionarioDTO();

                    objNovoFuncionarioDTO.setNome_funcionario(nome_funcionario);
                    objNovoFuncionarioDTO.setSenha_funcionario(senha_funcionario);

                    FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();
                    objFuncionarioDAO.RegistrarFuncionario(objNovoFuncionarioDTO);

                    if (objFuncionarioDAO.RegistrarFuncionario(objNovoFuncionarioDTO)) {
                        JOptionPane.showMessageDialog(null, "REGISTROU");
                        telaLoginInterface telaInicial = new telaLoginInterface();

                        // chamar tela q eu quero abrir
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
                        // enviar mensagem dizendo incorreto
                    }

                } finally {
                    System.out.println("FINALLY");
                }
            }
        });
    }

}
package VIEW;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.*;



import DAO.FuncionarioDAO;
import DAO.UsuarioDAO;
import DTO.FuncionarioDTO;
import DTO.UsuarioDTO;

public class telaLoginInterface extends JPanel {

    JLabel labelUsuario;
    JLabel labelSenha;
    JPanel jpnLogin = new JPanel();;



    static class Icone {

        Image img;
        Icone(Image img){
            this.img = img;
        }

    }



    Icone icone;
    Image iconeTop;

    public telaLoginInterface()  {

        JFrame tela = new JFrame("LOGIN");
         iconeTop = new ImageIcon(Objects.requireNonNull(getClass().getResource("./IconeUser.png"))).getImage();






        tela.setBounds(500, 500, 800, 550);
        tela.setUndecorated(true);
        tela.setLayout(null);
        tela.setDefaultCloseOperation(3);
        tela.setResizable(false);
        tela.setLocationRelativeTo(null);

        JLabel labelUsuario = new JLabel();
        labelUsuario.setText("Usuario: ");
        labelUsuario.setFont(new Font("Verdana", Font.BOLD, 25));

        labelUsuario.setBounds(35, 50, 250, 40);

        JTextField textUsuario = new JTextField();
        textUsuario.setBounds(60, 115, 400, 40);
        textUsuario.setEnabled(true);

        JLabel labelSenha = new JLabel();
        labelSenha.setText("Senha: ");
        labelSenha.setFont(new Font("Verdana", Font.BOLD, 25));

        labelSenha.setBounds(35, 190, 250, 40);

        JPasswordField textSenha = new JPasswordField();
        textSenha.setBounds(60, 265, 400, 40);
        textSenha.setEnabled(true);

        JButton botaoLogin = new JButton("LOGIN");
        botaoLogin.setBounds(150, 345, 150, 50);

        JButton botaoRegistro = new JButton("REGISTRO");
        botaoRegistro.setBounds(150, 405, 150, 50);

        jpnLogin.setBackground(new Color(94,100,165));
        jpnLogin.setBounds(400, 0, 400, 550);

        JLabel imagemLabel = new JLabel();
        ImageIcon imagemUser = new ImageIcon("\\src\\Imagens\\IconeUser.png");
        imagemUser.setImage(imagemUser.getImage().getScaledInstance(400, 400, 300));


        JCheckBox checkBoxFuncionario = new JCheckBox("Funcionario?");
        checkBoxFuncionario.setBounds(170, 455, 100, 50);



        tela.add(checkBoxFuncionario);
        tela.add(botaoRegistro);
        tela.add(botaoLogin);
        tela.add(labelSenha);
        tela.add(textUsuario);
        tela.add(textSenha);
        tela.add(labelUsuario);
        tela.add(jpnLogin);
        tela.add(imagemLabel);
        icone = new Icone(iconeTop);






        tela.setVisible(true);

        botaoRegistro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               telaRegistro telaDeRegistro = new telaRegistro();
               tela.setVisible(false);

     } });






        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    if (checkBoxFuncionario.isSelected()) {
                        String nome_funcionario, senha_funcionario;

                        nome_funcionario = textUsuario.getText();
                        senha_funcionario = textSenha.getText();



                        FuncionarioDTO objFuncionarioDTO = new FuncionarioDTO();

                        objFuncionarioDTO.setNome_funcionario(nome_funcionario);
                        objFuncionarioDTO.setSenha_funcionario(senha_funcionario);

                        FuncionarioDAO objfuncionarioDAO = new FuncionarioDAO();
                        ResultSet rsFuncionarioDAO = objfuncionarioDAO.autenticacaoFuncionario(objFuncionarioDTO);

                        if (rsFuncionarioDAO.next()) {
                            JOptionPane.showMessageDialog(null, "Entrou no APP como funcionario");
                            // chamar tela q eu quero abrir
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario ou senha dos funcionarios incorretos");
                            //enviar mensagem dizendo incorreto
                        }
                    }
                    else {
                        String nome_usuario, senha_usuario;

                        nome_usuario = textUsuario.getText();
                        senha_usuario = textSenha.getText();

                        UsuarioDTO objUsuarioDTO = new UsuarioDTO();

                        objUsuarioDTO.setNome_usuario(nome_usuario);
                        objUsuarioDTO.setSenha_usuario(senha_usuario);

                        UsuarioDAO objusuarioDAO = new UsuarioDAO();
                        ResultSet rsusuarioDAO = objusuarioDAO.autenticacaoUsuario(objUsuarioDTO);

                        if (rsusuarioDAO.next()) {
                            JOptionPane.showMessageDialog(null, "Entrou no APP");
                            // chamar tela q eu quero abrir
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
                            //enviar mensagem dizendo incorreto
                        }
                    }
                } catch (SQLException erro) {
                   JOptionPane.showMessageDialog( null,"Botao login viwe" + erro);
            }

        }
    }

        );

    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){

        try{

            // Icone user
            g.drawImage(icone.img,  200 , 100, 200, 100, null);

        }catch (Exception e){
            System.out.println("aff");
        }

    }





}

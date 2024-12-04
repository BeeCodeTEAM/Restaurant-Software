package VIEW;

import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TelaConta {
    private static String loggedInUser = "";

    public static void main(String[] args) {
        JFrame tela = new JFrame("Conta BeeFood");
        tela.setSize(1720, 968);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setLayout(null);

        // Barra superior (vermelha)
        JPanel topBar = new JPanel();
        topBar.setBackground(new Color(128, 0, 32));
        topBar.setBounds(0, 0, 1720, 100);
        topBar.setLayout(null);

        // Linhas brancas na barra superior
        int lineWidth = 150;
        int lineHeight = 3;
        int spacing = 400;
        for (int i = 0; i < 4; i++) {
            JLabel separator = new JLabel();
            separator.setBounds(250 + (spacing * i), 78, lineWidth, lineHeight);
            separator.setOpaque(true);
            separator.setBackground(Color.WHITE);
            topBar.add(separator);
        }

        // Botões da barra superior
        JButton botaoCardapio = criarBotao("Cardápio", 217, 35, 210, 40);
        JButton botaoMenu = criarBotao("Contatos", 617, 35, 210, 40);
        JButton botaoPerfil = criarBotao("Conta", 1047, 35, 150, 40);
        JButton botaoCarrinho = criarBotao("Carrinho", 1420, 35, 210, 40);
        topBar.add(botaoCardapio);
        topBar.add(botaoMenu);
        topBar.add(botaoPerfil);
        topBar.add(botaoCarrinho);

        // Barra lateral (verde)
        JPanel sideBar = new JPanel();
        sideBar.setBackground(new Color(0, 64, 0));
        sideBar.setBounds(0, 100, 164, 1868);

        // Imagem BeeFood
        JLabel imagemLabel = new JLabel();
        imagemLabel.setBounds(0, 0, 164, 188);
        tela.add(imagemLabel);
        ImageIcon BeeFoodIcon = new ImageIcon("src/Imagens/BeeFood.png");
        imagemLabel.setIcon(BeeFoodIcon);

        // Painel para o formulário de login e cadastro
        JPanel formPanel = new JPanel();
        formPanel.setBounds(300, 150, 600, 500);
        formPanel.setBackground(new Color(255, 255, 255, 200)); // Transparente
        formPanel.setLayout(null);
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(128, 0, 32), 2));

        // Títulos explicativos
        JLabel labelLogin = new JLabel("Nome de Usuário:");
        labelLogin.setBounds(20, 30, 150, 30);
        formPanel.add(labelLogin);

        JTextField txtLogin = new JTextField();
        txtLogin.setBounds(180, 30, 300, 40);
        formPanel.add(txtLogin);

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(20, 80, 150, 30);
        formPanel.add(labelSenha);

        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setBounds(180, 80, 300, 40);
        formPanel.add(txtSenha);

        JButton btnLogin = new JButton("Entrar");
        btnLogin.setBounds(180, 130, 120, 40);
        btnLogin.setBackground(new Color(128, 0, 32));
        btnLogin.setForeground(Color.WHITE);
        formPanel.add(btnLogin);

        // Campos para Cadastro
        JLabel labelNomeCadastro = new JLabel("Nome de Usuário:");
        labelNomeCadastro.setBounds(20, 200, 150, 30);
        formPanel.add(labelNomeCadastro);

        JTextField txtNomeCadastro = new JTextField();
        txtNomeCadastro.setBounds(180, 200, 300, 40);
        formPanel.add(txtNomeCadastro);

        JLabel labelSenhaCadastro = new JLabel("Senha:");
        labelSenhaCadastro.setBounds(20, 250, 150, 30);
        formPanel.add(labelSenhaCadastro);

        JPasswordField txtSenhaCadastro = new JPasswordField();
        txtSenhaCadastro.setBounds(180, 250, 300, 40);
        formPanel.add(txtSenhaCadastro);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(180, 300, 120, 40);
        btnCadastrar.setBackground(new Color(0, 128, 0));
        btnCadastrar.setForeground(Color.WHITE);
        formPanel.add(btnCadastrar);

        // Adicionando o painel ao JFrame
        tela.add(formPanel);

        // Ação do botão de login
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String login = txtLogin.getText();
                String senha = new String(txtSenha.getPassword());

                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setNome_usuario(login);
                usuarioDTO.setSenha_usuario(senha);

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                if (usuarioDAO.autenticacaoUsuario(usuarioDTO)) {
                    JOptionPane.showMessageDialog(tela, "Login bem-sucedido!");
                    // Redirecionar para outra tela ou ação após login
                } else {
                    JOptionPane.showMessageDialog(tela, "Login ou senha incorretos!");
                }
            }
        });

        // Ação do botão de cadastro
        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = txtNomeCadastro.getText();
                String senha = new String(txtSenhaCadastro.getPassword());

                // Hash da senha
                String senhaHash = hashSenha(senha);

                UsuarioDTO usuarioDTO = new UsuarioDTO();
                usuarioDTO.setNome_usuario(nome);
                usuarioDTO.setSenha_usuario(senhaHash);

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                if (usuarioDAO.RegistrarUsuario(usuarioDTO)) {
                    JOptionPane.showMessageDialog(tela, "Usuário cadastrado com sucesso!");
                } else {
                    JOptionPane.showMessageDialog(tela, "Erro ao cadastrar usuário!");
                }
            }
        });

        tela.add(topBar);
        tela.add(sideBar);
        tela.setVisible(true);
    }

    // Método para criar botões
    private static JButton criarBotao(String texto, int x, int y, int largura, int altura) {
        JButton botao = new JButton(texto);
        botao.setBounds(x, y, largura, altura);
        botao.setFocusPainted(false);
        botao.setBorderPainted(false);
        botao.setContentAreaFilled(false);
        botao.setFont(new Font("Open Sans", Font.BOLD, 40));
        botao.setForeground(Color.WHITE);
        return botao;
    }

    // Método para hash de senha
    public static String hashSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(senha.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
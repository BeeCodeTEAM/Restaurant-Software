package VIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class TelaContatos {
    public void exibirTelaContatos() {
        // Criando a janela de contatos
        JFrame telaContatos = new JFrame("Contatos BeeFood");
        telaContatos.setSize(1720, 968);
        telaContatos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaContatos.setLayout(null);

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

        // Adicionando ações aos botões
        botaoCardapio.addActionListener(e -> {
            telaContatos.dispose(); // Fecha a janela atual
            TelaCardapio.main(null); // Retorna à tela de cardápio
        });

        botaoCarrinho.addActionListener(e -> {
            telaContatos.dispose(); // Fecha a janela atual
            TelaCarrinho.main(null); // Navega para a tela de carrinho
        });

        topBar.add(botaoCardapio);
        topBar.add(botaoMenu);
        topBar.add(botaoPerfil);
        topBar.add(botaoCarrinho);

        // Barra lateral (verde)
        JPanel sideBar = new JPanel();
        sideBar.setBackground(new Color(0, 64, 0));
        sideBar.setBounds(0, 100, 164, 868);

        // Imagem BeeFood
        JLabel imagemLabel = new JLabel();
        imagemLabel.setBounds(0, 0, 164, 188);
        telaContatos.add(imagemLabel);
        ImageIcon BeeFoodIcon = new ImageIcon("src/Imagens/BeeFood.png");
        imagemLabel.setIcon(BeeFoodIcon);

        // Painel com o quadrado e as informações de contato
        JPanel panelContatos = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(246, 212, 159));
                g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40));
            }
        };
        panelContatos.setLayout(null);
        panelContatos.setBounds(300, 200, 1120, 600);

        // Texto "Fale conosco"
        JLabel lblTitulo = new JLabel("Fale conosco");
        lblTitulo.setFont(new Font("Open Sans", Font.BOLD, 60));
        lblTitulo.setBounds(400, 50, 500, 70);
        panelContatos.add(lblTitulo);

        // Texto de endereço - JTextField para ser selecionável
        JTextField txtEndereco = new JTextField("Rua: Logo Ali o Lado, 354 Vila De La, São Paulo - SP");
        configurarTextField(txtEndereco, 100, 200, 1000, 40);
        panelContatos.add(txtEndereco);

        // Texto de e-mail - JTextField para ser selecionável
        JTextField txtEmail = new JTextField("Email: BeeFoodPizzaria@gmail.com");
        configurarTextField(txtEmail, 100, 260, 1000, 40);
        panelContatos.add(txtEmail);

        // Texto de contato - JTextField para ser selecionável
        JTextField txtContato = new JTextField("Contato: +55 (11) 98765-4321");
        configurarTextField(txtContato, 100, 320, 1000, 40);
        panelContatos.add(txtContato);

        telaContatos.add(panelContatos);
        telaContatos.add(topBar);
        telaContatos.add(sideBar);
        telaContatos.setVisible(true);
    }

    // Método para configurar JTextField como readonly e permitir seleção
    private static void configurarTextField(JTextField textField, int x, int y, int largura, int altura) {
        textField.setBounds(x, y, largura, altura);
        textField.setFont(new Font("Open Sans", Font.BOLD, 25));
        textField.setEditable(false); // Não permite edição, mas permite seleção
        textField.setOpaque(false);  // Fundo transparente
        textField.setBorder(null);   // Remove borda
        textField.setForeground(Color.BLACK); // Cor do texto
    }

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

    public static void main(String[] args) {
        new TelaContatos().exibirTelaContatos();
    }
}
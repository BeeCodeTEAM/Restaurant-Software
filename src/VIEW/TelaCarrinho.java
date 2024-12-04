package VIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCarrinho {

    public void exibirTelaCarrinho() {
        JFrame telaCarrinho = new JFrame("Carrinho BeeFood");
        telaCarrinho.setSize(1720, 968);
        telaCarrinho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaCarrinho.setLayout(null);

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

        botaoCardapio.addActionListener(e -> {
            telaCarrinho.dispose(); // Fecha a janela atual
            TelaCardapio.main(null); // Retorna à tela de cardápio
        });

        botaoMenu.addActionListener(e -> {
            telaCarrinho.dispose(); // Fecha a janela atual
            TelaContatos.main(null); // Navega para a tela de contatos
        });

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
        telaCarrinho.add(imagemLabel);
        ImageIcon BeeFoodIcon = new ImageIcon("src/Imagens/BeeFood.png");
        imagemLabel.setIcon(BeeFoodIcon);

        telaCarrinho.add(topBar);
        telaCarrinho.add(sideBar);

        // Exibe a tela
        telaCarrinho.setVisible(true);
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
            new TelaCarrinho().exibirTelaCarrinho();
        }
    }
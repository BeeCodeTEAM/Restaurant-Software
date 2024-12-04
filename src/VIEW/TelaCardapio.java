package VIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.RoundRectangle2D;

public class TelaCardapio {
    public static void main(String[] args) {

        // Criando a janela
        JFrame telaCardapio = new JFrame("Cardápio BeeFood");
        telaCardapio.setSize(1720, 968);
        telaCardapio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaCardapio.setLayout(null);

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
        JButton botaoContatos = criarBotao("Contatos", 617, 35, 210, 40);
        JButton botaoPerfil = criarBotao("Conta", 1047, 35, 150, 40);
        JButton botaoCarrinho = criarBotao("Carrinho", 1420, 35, 210, 40);

        botaoCarrinho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Esconde a tela do cardápio
                telaCardapio.setVisible(false);

                // Abre a tela do carrinho
                TelaCarrinho telaCarrinho = new TelaCarrinho();  // Criando instância de TelaCarrinho
                telaCarrinho.exibirTelaCarrinho();  // Chama o método para tornar a tela visível
            }
        });

        botaoContatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaCardapio.setVisible(false);
                TelaContatos telaContatos = new TelaContatos(); // Criando instância de TelaContatos
                telaContatos.exibirTelaContatos(); // Chama o método para exibir a tela de contatos
            }
        });

        topBar.add(botaoCardapio);
        topBar.add(botaoContatos);
        topBar.add(botaoPerfil);
        topBar.add(botaoCarrinho);


        // Barra lateral (verde)
        JPanel sideBar = new JPanel();
        sideBar.setBackground(new Color(0, 64, 0));
        sideBar.setBounds(0, 100, 164, 1868);

        // Imagem BeeFood
        JLabel imagemLabel = new JLabel();
        imagemLabel.setBounds(0, 0, 164, 188);
        telaCardapio.add(imagemLabel);
        ImageIcon BeeFoodIcon = new ImageIcon("src/Imagens/BeeFood.png");
        imagemLabel.setIcon(BeeFoodIcon);

        // Painel de cartões com layout
        JPanel panelCartoes = new JPanel();
        panelCartoes.setLayout(new BoxLayout(panelCartoes, BoxLayout.Y_AXIS));
        panelCartoes.setPreferredSize(new Dimension(1420, 3700));
        panelCartoes.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));

        // Adicionando seções com espaçamentos ajustados
        addSecao(panelCartoes, "Bebidas", 1); // Primeira sequência
        addSecao(panelCartoes, "Pizzas Salgadas -- R$ 90", 2); // Segunda sequência
        addSecao(panelCartoes, "", 3); // Terceira sequência
        addSecao(panelCartoes, "Pizzas Doces -- R$ 86", 4); // Quarta sequência

        // Scroll
        JScrollPane scrollPane = new JScrollPane(panelCartoes);
        scrollPane.setBounds(164, 100, 1540, 868);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation();
                JScrollBar vertical = scrollPane.getVerticalScrollBar();
                if (notches < 0) {
                    vertical.setValue(vertical.getValue() - 40); // Rolagem para cima
                } else {
                    vertical.setValue(vertical.getValue() + 40); // Rolagem para baixo
                }
            }
        });

        telaCardapio.add(scrollPane);
        telaCardapio.add(topBar);
        telaCardapio.add(sideBar);
        telaCardapio.setVisible(true);
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

    // Função para adicionar seções e seus cartões
    private static void addSecao(JPanel panel, String titulo, int sequencia) {
        panel.add(createLabel(titulo)); // Adiciona o título
        panel.add(criarCartaoLinha(sequencia)); // Adiciona os cartões com base na sequência
    }

    // Função para criar os cartões de cada linha com base na sequência
    private static JPanel criarCartaoLinha(int sequencia) {
        JPanel linha = new JPanel();
        linha.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        linha.setPreferredSize(new Dimension(1420, 20));

        if (sequencia == 1) {
            // Cartões para a sequência 1 com imagens personalizadas
            linha.add(criarCartaoComTitulo(
                    "Refrigerantes",
                    "Coca, Guaraná, Pepsi, Fanta<br> Laranja ou Uva (Normal ou Zero)<br>1L<br>R$ 9,50",
                    "src/Imagens/cocalata.png", // Caminho da imagem
                    250, 50, 100, 200 // Posição e tamanho da imagem
            ));

            linha.add(criarCartaoComTitulo(
                    "Drinks",
                    "R$ 15,00",
                    "src/Imagens/Drink.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Água Mineral",
                    "Apenas 500ml<br>R$ 5,00",
                    "src/Imagens/agua.png",
                    250, 50, 75, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Suco Natural",
                    "Laranja, Uva, Abacaxi, Morango,<br> Melancia, Limão<br>300ml<br>R$ 13,00",
                    "src/Imagens/Suco.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Cervejas",
                    "1L<br>R$ 13,50",
                    "src/Imagens/Cerveja.png",
                    250, 50, 75, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "H2O",
                    "500ml<br>R$ 5,90",
                    "src/Imagens/H2O.png",
                    250, 50, 75, 200
            ));
        } else if (sequencia == 2) {
            // Cartões da sequência 2 (Pizzas Salgadas)
            linha.add(criarCartaoComTitulo(
                    "Frango Especial",
                    "Frango, Catupiry Legitimo,<br> Azeitonas Pretas e Milho",
                    "src/Imagens/FrangoEspecial.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Marguerita",
                    "Mussarela, Parmesão,<br> Rodelas de Tomate<br> e Manjericão",
                    "src/Imagens/Marguerita.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Calabresa",
                    "Calabresa, Cebola<br> e Azeitonas Verdes",
                    "src/Imagens/Calabresa.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Portuguesa",
                    "Presunto, Ovo, Cebola<br> e Azeitonas Verdes",
                    "src/Imagens/Portuguesa.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Vegetariana",
                    "Champignon, Palmito,<br> Brócolis e Azeitonas<br> Verdes",
                    "src/Imagens/Vegetariana.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Bacon",
                    "Mussarela com Bacon<br> e Azeitonas Verdes",
                    "src/Imagens/Bacon.png",
                    250, 50, 100, 200
            ));
        } else if (sequencia == 3) {
            // Cartões da sequência 3 (Pizzas Salgadas)
            linha.add(criarCartaoComTitulo(
                    "4 Queijos",
                    "Catupiry, Parmesão,<br> Gorgonzola e Mussarela",
                    "src/Imagens/4Queijos.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Berinjela",
                    "Berinjela, Mussarela de Búfala,<br> Tomate Cereja e Azeitonas<br> Verdes",
                    "src/Imagens/Berinjela.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Brócolis",
                    "Brócolis, Bacon<br> e Azeitonas Verdes",
                    "src/Imagens/Brocolis.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Napolitana",
                    "Mussarela, Parmesão<br> e Molho de Tomate",
                    "src/Imagens/Napolitana.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Toscana",
                    "Mussarela, Linguiça<br> Calabresa Fatiada e Azeitonas<br> Verdes",
                    "src/Imagens/Toscana.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Palmito",
                    "Palmito, Coberto com<br> Mussarela e<br> Azeitonas Verdes",
                    "src/Imagens/Palmito.png",
                    250, 50, 100, 200
            ));
        } else if (sequencia == 4) {
            // Cartões da sequência 4 (Pizzas Doces)
            linha.add(criarCartaoComTitulo(
                    "Banana",
                    "Banana com Canela e Mel",
                    "src/Imagens/Banana.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Prestigio",
                    "Raspas de Coco<br> e Chocolate",
                    "src/Imagens/Prestigio.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Ovomaltine",
                    "Ovomaltine em Pó<br> e Chocolate",
                    "src/Imagens/Ovomaltine.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Chocolate com Morango",
                    "Morango e Chocolate",
                    "src/Imagens/ChocolateMorango.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Chocolate com Uva",
                    "Uvas Verdes e Chocolate",
                    "src/Imagens/ChocolateUva.png",
                    250, 50, 100, 200
            ));

            linha.add(criarCartaoComTitulo(
                    "Doce de Leite",
                    "Morango, Raspas de Coco<br> e Doce de Leite",
                    "src/Imagens/DoceDeLeite.png",
                    250, 50, 100, 200
            ));
        }
        return linha;
    }

    // Função para criar cartões com título, descrição e imagem flexível
    private static JPanel criarCartaoComTitulo(String titulo, String descricao, String caminhoImagem, int xImagem, int yImagem, int larguraImagem, int alturaImagem) {
        JPanel cartao = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(246, 212, 159)); // Cor de fundo do cartão
                g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40)); // Bordas arredondadas
            }
        };
        cartao.setLayout(null);
        cartao.setPreferredSize(new Dimension(470, 350));
        cartao.setOpaque(false);

        // Título do item
        JLabel tituloLabel = new JLabel(titulo, JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 25));
        tituloLabel.setBounds(10, 10, 450, 40);
        tituloLabel.setForeground(Color.BLACK);
        cartao.add(tituloLabel);

        // Descrição do item
        JLabel descricaoLabel = new JLabel("<html><b>Sobre o Item:</b><br>" + descricao + "</html>");
        descricaoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        descricaoLabel.setBounds(20, 60, 430, 100);
        descricaoLabel.setForeground(Color.BLACK);
        cartao.add(descricaoLabel);

        // Carregar a imagem do caminho especificado
        JLabel imagemLabel = new JLabel();
        imagemLabel.setBounds(xImagem, yImagem, larguraImagem, alturaImagem); // Posição e tamanho configuráveis
        ImageIcon imageIconOriginal = new ImageIcon(caminhoImagem); // Caminho da imagem
        Image image = imageIconOriginal.getImage().getScaledInstance(larguraImagem, alturaImagem, Image.SCALE_SMOOTH); // Redimensionar imagem
        ImageIcon imageIconRedimensionado = new ImageIcon(image);
        imagemLabel.setIcon(imageIconRedimensionado);
        cartao.add(imagemLabel);

        // Botão "Adicionar ao Carrinho"
        JButton botaoCarrinho = new JButton("Adicionar ao Carrinho");
        botaoCarrinho.setBounds(30, 260, 200, 50);
        botaoCarrinho.setBackground(new Color(255, 145, 76));
        botaoCarrinho.setForeground(Color.BLACK);
        botaoCarrinho.setFont(new Font("Open Sans", Font.BOLD, 14));
        cartao.add(botaoCarrinho);

        return cartao;
    }

    // Cartão sem título (para as sequências 2, 3 e 4)
    private static JPanel criarCartaoSemTitulo(String textoCartao) {
        JPanel cartao = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(new Color(246, 212, 159));
                g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40));
            }
        };
        cartao.setLayout(null);
        cartao.setPreferredSize(new Dimension(470, 350));
        cartao.setOpaque(false);

        // Adicionando texto no cartão
        JLabel texto = new JLabel(textoCartao, JLabel.CENTER);
        texto.setFont(new Font("Arial", Font.BOLD, 20));
        texto.setBounds(10, 10, 450, 40);
        texto.setForeground(Color.BLACK);
        cartao.add(texto);

        // Botão "Adicionar ao Carrinho"
        JButton botaoCarrinho = new JButton("Adicionar ao Carrinho");
        botaoCarrinho.setBounds(30, 260, 200, 50);
        botaoCarrinho.setBackground(new Color(255, 145, 76));
        botaoCarrinho.setForeground(Color.BLACK);
        botaoCarrinho.setFont(new Font("Open Sans", Font.BOLD, 14));
        botaoCarrinho.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(255, 145, 76), 2),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));
        cartao.add(botaoCarrinho);

        return cartao;
    }

    private static JLabel createLabel(String texto) {
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Arial", Font.BOLD, 37));
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        label.setForeground(Color.BLACK);
        return label;
    }
}
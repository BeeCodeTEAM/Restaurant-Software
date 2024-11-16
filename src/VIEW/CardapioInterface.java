package VIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class CardapioInterface {

    private JFrame interfaceMenu;
    private final ArrayList<JPanel> produtos;
    private int contadorProdutos;

    public CardapioInterface() {
        // Inicialização da interface
        interfaceMenu = new JFrame("Cardápio");
        interfaceMenu.setBounds(500, 500, 800, 550);
        interfaceMenu.setUndecorated(true);
        interfaceMenu.setLayout(null);
        interfaceMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        interfaceMenu.setResizable(false);
        interfaceMenu.setLocationRelativeTo(null);

        produtos = new ArrayList<>();
        contadorProdutos = 0; // Controlador para a posição dos produtos

        // Texto do título "Cardápio"
        JLabel textCardapio = new JLabel("Cardápio");
        textCardapio.setBounds(340, 4, 250, 100);
        textCardapio.setFont(new Font("Arial", Font.BOLD, 30));

        // Botão de "Registrar Produto"
        JButton botaoRegistrarProduto = new JButton("Registrar");
        botaoRegistrarProduto.setBounds(300, 400, 150, 50);
        botaoRegistrarProduto.setEnabled(true);

        // Painel de produtos
        JPanel painelProdutos = new JPanel();
        painelProdutos.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        painelProdutos.setBounds(30, 100, 730, 250); // Posição e tamanho do painel de produtos

        // Adicionando componentes à interface
        interfaceMenu.add(textCardapio);
        interfaceMenu.add(botaoRegistrarProduto);
        interfaceMenu.add(painelProdutos);

        // Exibir a interface
        interfaceMenu.setVisible(true);

        // Ação do botão para registrar um produto
        botaoRegistrarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cria uma nova tela de registro de produto, passando a referência da interface principal
                new RegistroProdutos(CardapioInterface.this, painelProdutos);
            }
        });
    }

    // Método para adicionar um novo produto ao cardápio
    public void adicionarProdutoAoCardapio(String nome, Icon icone, String descricao) {
        // Criando um novo produto com imagem, nome e descrição
        JPanel painelProduto = new JPanel();
        painelProduto.setPreferredSize(new Dimension(130, 150));
        painelProduto.setLayout(new BorderLayout());
        painelProduto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Ícone do produto
        JLabel labelImagem = new JLabel();
        labelImagem.setIcon(icone);
        painelProduto.add(labelImagem, BorderLayout.CENTER);

        // Nome do produto
        JLabel nomeDoProduto = new JLabel(nome); // Nome passado do registro
        nomeDoProduto.setHorizontalAlignment(SwingConstants.CENTER);
        painelProduto.add(nomeDoProduto, BorderLayout.SOUTH);

        // Adicionando o produto ao painel de produtos
        JPanel painelProdutos = (JPanel) interfaceMenu.getContentPane().getComponent(2);  // Encontrando o painel de produtos
        painelProdutos.add(painelProduto);

        // Atualizando a interface
        interfaceMenu.revalidate();  // Força a atualização da interface
        interfaceMenu.repaint();     // Força o redesenho da interface
    }

    public static void main(String[] args) {
        // Cria a interface do cardápio
        new CardapioInterface();
    }
}

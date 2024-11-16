package VIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CardapioInterface {

    private JFrame interfaceMenu;
    private  final ArrayList<JPanel> produtos;
    private int contadorProdutos;
    private static final int LIMITE_PRODUTOS = 25;

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

        // Botão de "Adicionar Produto"
        JButton botaoAdicionarCardapio = new JButton("Adicionar");
        botaoAdicionarCardapio.setBounds(300, 400, 150, 50);
        botaoAdicionarCardapio.setEnabled(true);

        // Painel de produtos
        JPanel painelProdutos = new JPanel();
        painelProdutos.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 15));
        painelProdutos.setPreferredSize(new Dimension(730, 1500)); // Aumentei a altura do painel para garantir rolagem

        JScrollPane painelScroll = new JScrollPane(painelProdutos);
        // Painel Scroll
        painelScroll.setBounds(5,100, 790,300);
       painelScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        painelScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        painelScroll.setBorder(null);






        // Adicionando componentes à interface

        interfaceMenu.add(painelScroll);

        interfaceMenu.add(textCardapio);
        interfaceMenu.add(botaoAdicionarCardapio);
      //  interfaceMenu.add(painelProdutos);

        // Exibir a interface
        interfaceMenu.setVisible(true);

        // Ação do botão para adicionar um produto
        botaoAdicionarCardapio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              if (contadorProdutos < LIMITE_PRODUTOS) {
                  adicionarProduto(painelProdutos);
              }else{
                  botaoAdicionarCardapio.setEnabled(false);
                  JOptionPane.showMessageDialog(interfaceMenu, "Limite de produtos atingido! Máximo de " + LIMITE_PRODUTOS + " produtos.",
                          "Aviso", JOptionPane.WARNING_MESSAGE);
              }




            }
        });
    }

    // Método para adicionar um novo produto ao cardápio
    private void adicionarProduto(JPanel painelProdutos) {
        // Criando um novo produto com imagem e nome
        JPanel painelProduto = new JPanel();
        painelProduto.setPreferredSize(new Dimension(135, 150));
        painelProduto.setLayout(new BorderLayout());
        painelProduto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        // Ícone do produto
        ImageIcon imgProduto = new ImageIcon("..\\RepositorioJava\\src\\VIEW\\pizzaImagemTeste.jpeg");

        Image img = imgProduto.getImage();
        Image novaImg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH); // Redimensiona para 130x130 pixels
        imgProduto = new ImageIcon(novaImg);

        JLabel labelImagemPizza = new JLabel();
        painelProdutos.add(labelImagemPizza, BorderLayout.CENTER);
        labelImagemPizza.setIcon(imgProduto);
        labelImagemPizza.setBounds(10,10, 130,130);

        painelProduto.add(labelImagemPizza);

        // Nome do produto
        JLabel nomeDoProduto = new JLabel("Produto " + (contadorProdutos + 1)); // Exemplo de nome
        nomeDoProduto.setHorizontalAlignment(SwingConstants.CENTER);
        painelProduto.add(nomeDoProduto, BorderLayout.SOUTH);

        // Adicionando o produto ao painel de produtos
        painelProdutos.add(painelProduto);

        // Atualizando a interface
        interfaceMenu.revalidate();  // Força a atualização da interface
        interfaceMenu.repaint();     // Força o redesenho da interface

        // Incrementa o contador de produtos
        contadorProdutos++;
    }

    public static void main(String[] args) {
        // Cria a interface do cardápio
        new CardapioInterface();
    }

}

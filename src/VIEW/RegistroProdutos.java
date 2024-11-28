package VIEW;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.UIManager;

public class RegistroProdutos {

    private JFrame janelaRegistro;
    private JTextField campoNome;
    private JTextArea campoDescricao;
    private JLabel labelFoto;
    private Icon iconeProduto;

    
    public RegistroProdutos(CardapioInterface cardapioInterface, JPanel painelProdutos) {
        try {
            // Define o Look and Feel para o estilo nativo do sistema operacional
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Inicializa a janela de registro
        janelaRegistro = new JFrame("Registrar Produto");
        janelaRegistro.setBounds(500, 500, 800, 550);
        janelaRegistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Criação de um painel principal com BoxLayout para organizar componentes verticalmente
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        // Campo para o nome do produto
        JLabel nomeLabel = new JLabel("Nome do Produto:");
        campoNome = new JTextField(20);
        campoNome.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        // Campo para a descrição do produto
        JLabel descricaoLabel = new JLabel("Descrição:");
        campoDescricao = new JTextArea(4, 20);
        campoDescricao.setLineWrap(true);
        campoDescricao.setWrapStyleWord(true);
        JScrollPane scrollDescricao = new JScrollPane(campoDescricao);
        scrollDescricao.setMaximumSize(new Dimension(Integer.MAX_VALUE, 80));

        // Botão para selecionar uma foto
        JButton botaoEscolherFoto = new JButton("Escolher Foto");
        labelFoto = new JLabel("Nenhuma foto selecionada", SwingConstants.CENTER);
        labelFoto.setPreferredSize(new Dimension(130, 130));

        // Botão para salvar o produto
        JButton botaoSalvar = new JButton("Salvar Produto");

        // Adiciona componentes ao painel principal
        painelPrincipal.add(nomeLabel);
        painelPrincipal.add(campoNome);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15))); // Espaçamento vertical

        painelPrincipal.add(descricaoLabel);
        painelPrincipal.add(scrollDescricao);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 15))); // Espaçamento vertical

        painelPrincipal.add(botaoEscolherFoto);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 10))); // Espaçamento vertical
        painelPrincipal.add(labelFoto);
        painelPrincipal.add(Box.createRigidArea(new Dimension(0, 20))); // Espaçamento vertical

        painelPrincipal.add(botaoSalvar);

        // Adiciona o painel principal à janela
        janelaRegistro.add(painelPrincipal);

        // Exibe a janela
        janelaRegistro.setVisible(true);

        // Ação para escolher a foto
        botaoEscolherFoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagens", "jpg", "jpeg", "png");
                fileChooser.setFileFilter(filtro);

                int resultado = fileChooser.showOpenDialog(null);
                if (resultado == JFileChooser.APPROVE_OPTION) {
                    File arquivo = fileChooser.getSelectedFile();

                    // Cria um ImageIcon a partir do arquivo
                    ImageIcon imagemOriginal = new ImageIcon(arquivo.getAbsolutePath());

                    // Redimensionando a imagem para um tamanho adequado
                    Image imagemRedimensionada = imagemOriginal.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);

                    // Criando um novo ImageIcon com a imagem redimensionada
                    iconeProduto = new ImageIcon(imagemRedimensionada);

                    // Configura o ícone no JLabel
                    labelFoto.setIcon(iconeProduto);
                    labelFoto.setText(""); // Limpa o texto "Nenhuma foto selecionada"
                }
            }
        });

        // Ação para salvar o produto
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeProduto = campoNome.getText();
                String descricaoProduto = campoDescricao.getText();
                if (nomeProduto.isEmpty() || descricaoProduto.isEmpty() || iconeProduto == null) {
                    JOptionPane.showMessageDialog(janelaRegistro, "Todos os campos devem ser preenchidos!");
                } else {
                    // Chama o método da interface principal para adicionar o produto
                    cardapioInterface.adicionarProdutoAoCardapio(nomeProduto, iconeProduto, descricaoProduto);
                    janelaRegistro.dispose(); // Fecha a janela de registro
                }
            }
        });
    }
}


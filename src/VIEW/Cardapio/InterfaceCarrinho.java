package VIEW.Cardapio;

import javax.swing.*;

public class InterfaceCarrinho {
    JFrame interfaceDoCarrinho;
    public InterfaceCarrinho(){


        // Inicialização da interface
        interfaceDoCarrinho = new JFrame("Cardápio");
        interfaceDoCarrinho.setBounds(500, 500, 800, 550);
        interfaceDoCarrinho.setUndecorated(true);
        interfaceDoCarrinho.setLayout(null);
        interfaceDoCarrinho.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        interfaceDoCarrinho.setResizable(false);
        interfaceDoCarrinho.setLocationRelativeTo(null);

        interfaceDoCarrinho.setVisible(true);

    }
}

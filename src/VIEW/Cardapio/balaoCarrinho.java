package VIEW.Cardapio;

import javax.swing.*;

public class balaoCarrinho {
    JFrame infoCarrinho;
      RegistroProdutos a;

    public balaoCarrinho(){
        infoCarrinho = new JFrame("Informações do Produto");
        infoCarrinho.setBounds(500, 500, 800, 550);
        infoCarrinho.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        infoCarrinho.setLocationRelativeTo(null);

        JLabel label = new JLabel("P");
        String descricao = a.getDescricao();
         label.setText(descricao);
        label.setBounds(200, 100, 200, 200);

        infoCarrinho.add(label);

        infoCarrinho.setVisible(true);
    }
}

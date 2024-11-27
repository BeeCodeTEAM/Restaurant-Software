package VIEW.Cardapio;

import javax.swing.*;
import java.awt.*;

public class Produto {
    int valor;
    String nomeProduto = "produtocraq";
    JPanel novoProduto = new JPanel();

    public Produto(){

        novoProduto.setBounds((30), 100, 130,130);
        novoProduto.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        novoProduto.setVisible(true);

    }
}

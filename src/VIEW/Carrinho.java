package VIEW;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<String> itens;

    public Carrinho() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(String item) {
        itens.add(item);
    }

    public List<String> getItens() {
        return itens;
    }
}

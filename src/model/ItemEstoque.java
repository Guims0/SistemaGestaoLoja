package model;

public class ItemEstoque {

    private Produto produto;
    private int quantidade;

    public ItemEstoque(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    @Override
    public String toString() {
        return """
           | Id: %-20s
           | Produto: %-25s
           | Preço:   R$ %-20.2f
           | Qtd:     %-20d
           +-----------------------------------+
           | VALOR EM ESTOQUE: R$ %-20.2f
           +-----------------------------------+
           """.formatted(produto.getId(),produto.getNome(),
                produto.getPreco(),
                this.quantidade,
                (produto.getPreco() * this.quantidade));
    }
}

public class ItemCarrinho {
    private Produto produto;
    private int quantidade;

    public ItemCarrinho(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return """
           | Produto:  %-24s
           | Preço Un: R$ %-21.2f
           | Qtd:      %-24d
           +-----------------------------------+
           | SUBTOTAL: R$ %-21.2f
           +-----------------------------------+
           """.formatted(
                produto.getNome(),
                produto.getPreco(),
                this.quantidade,
                (produto.getPreco() * this.quantidade)
        );
    }
}

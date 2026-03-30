public class Produto {

    private Long id;
    private String nome;
    private double preco;

    public Produto(Long id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }
    public Produto(){}

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return """
            DETALHES DO PRODUTO
           -----------------------
           - ID:    %d
           - NOME:  %s
           - PREÇO: R$ %.2f
           -----------------------
           """.formatted(id, nome, preco);
    }
}

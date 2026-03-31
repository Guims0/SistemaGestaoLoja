package repository;

import model.ItemCarrinho;
import model.Produto;
import service.Operacoes;

import java.util.ArrayList;

public class Carrinho implements Operacoes {

    private ArrayList<ItemCarrinho> itemCarrinhos ;

    public Carrinho() {
        this.itemCarrinhos =new ArrayList<>();
    }

    @Override
    public void adicionar(Produto p, int quantidade) {
        itemCarrinhos.add(new ItemCarrinho(p,quantidade));
    }

    @Override
    public void excluir(Long id) {
        if (itemCarrinhos.isEmpty()){
            System.out.println("Adicione algo no carrinho, para remover");
            return;
        }

        for (int i = 0 ; i < itemCarrinhos.size();i++){

           ItemCarrinho item = itemCarrinhos.get(i);

           if (item.getProduto().getId().equals(id)){
               itemCarrinhos.remove(item);
               System.out.println("Item removido com sucesso.");
               return;
           }
        }

        System.out.println("Produto com ID "+id+" não encontrado no carrinho. ");
    }

    @Override
    public void exibir() {
        if (itemCarrinhos.isEmpty()) {
            System.out.println("Carrinho vazio, adicione algo para vizualizar.");
            return;
        }
        System.out.println(" PRODUTO(S) NO CARRINHO ");
        System.out.println("-----------------------");
        for (ItemCarrinho item : itemCarrinhos) {
            System.out.println(item.toString());
        }
    }
    public double calcularTotal(){
        double soma = 0;
        for (ItemCarrinho item : itemCarrinhos){
            soma += item.getProduto().getPreco() * item.getQuantidade();
        }
        return soma;
    }
    public void limpar(){
        itemCarrinhos.clear();
    }
    public ArrayList<ItemCarrinho> getItemCarrinhos() {
        return itemCarrinhos;
    }
}

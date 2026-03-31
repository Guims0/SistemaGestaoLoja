package repository;

import model.ItemEstoque;
import model.Produto;
import service.Operacoes;

import java.util.ArrayList;

public class Estoque implements Operacoes {

    private ArrayList<ItemEstoque> listaDeEstoque;

    public Estoque() {
        this.listaDeEstoque = new ArrayList<>();
    }

    public ArrayList<ItemEstoque> getListaDeEstoque() {
        return listaDeEstoque;
    }


    @Override
    public void adicionar(Produto p, int quantidade) {
        listaDeEstoque.add(new ItemEstoque(p,quantidade));
    }

    @Override
    public void excluir(Long id) {

        if (listaDeEstoque.isEmpty()){
            System.out.println("Estoque vazio, adicione algo para remover.");
            return;
        }

        for (int i = 0 ; i < listaDeEstoque.size();i++){

            ItemEstoque item = listaDeEstoque.get(i);

            if (item.getProduto().getId().equals(id)){
                listaDeEstoque.remove(item);
                System.out.println("Item removido com sucesso.");
                return;
            }
        }

        System.out.println("Produto com ID "+id+" não encontrado no estoque. ");
    }

    @Override
    public void exibir() {
        if (listaDeEstoque.isEmpty()){
            System.out.println("Estoque vazio, adicione algo para vizualizar.");
        }else {
            System.out.println(" PRODUTO(S) EM ESTOQUE ");
            System.out.println("-----------------------");
            for (ItemEstoque item : listaDeEstoque){
                System.out.println(item.toString());
            }
        }
    }
    public Produto buscarProduto(Long id){
        for (ItemEstoque item : listaDeEstoque){
            if (item.getProduto().getId().equals(id)){
                return item.getProduto();
            }
        }
        return null;
    }

    public int verificarQuantidade(Long id) {
        for (ItemEstoque item : listaDeEstoque) {
            if (item.getProduto().getId().equals(id)) {
                return item.getQuantidade();
            }
        }
        return 0;
    }

    public void darBaixa(Long id,int quantidadeVendida){
        for (ItemEstoque item : listaDeEstoque){
            if (item.getProduto().getId().equals(id)){
                int quantidadeNova = item.getQuantidade()-quantidadeVendida;
                item.setQuantidade(quantidadeNova);
                return;
            }
        }
    }
}

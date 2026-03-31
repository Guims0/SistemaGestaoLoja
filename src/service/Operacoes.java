package service;

import model.Produto;

public interface Operacoes {

     void adicionar(Produto p , int quantidade);
     void excluir(Long id);
     void exibir();
}

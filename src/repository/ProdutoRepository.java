package repository;

import model.Produto;

import java.util.List;

public interface ProdutoRepository {
    void salvarProduto(Produto produto) throws Exception;
    //List<Produto> listarTodos();
    //Produto buscarPorId(Integer id);
    //void atualizar(Produto produto);
    //void deletar(Integer id);
    //void adicionarEstoque(Integer id, Integer quantidade);
    //void retirarEstoque(Integer id, Integer quantidade);

}

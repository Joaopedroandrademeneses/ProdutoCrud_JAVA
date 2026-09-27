package repository;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryMemory implements ProdutoRepository {
    private List<Produto> listaProduto = new ArrayList<>();

    public void salvarProduto(Produto produto)throws Exception {
        Produto newproduto=new Produto();
        newproduto.setNome(produto.getNome());
        newproduto.setCategoria(produto.getCategoria());
        newproduto.setPreco(produto.getPreco());
        newproduto.setQuantidade(produto.getQuantidade());
        listaProduto.add(newproduto);
    }
}

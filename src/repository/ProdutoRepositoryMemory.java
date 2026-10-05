package repository;

import model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositoryMemory implements ProdutoRepository {
    private List<Produto> listaProduto = new ArrayList<>();
    private int provId = 0;
    public void salvarProduto(Produto produto) throws Exception {

        Produto newproduto = new Produto();
        provId += 1;
        newproduto.setId(provId);
        newproduto.setNome(produto.getNome());
        newproduto.setCategoria(produto.getCategoria());
        newproduto.setPreco(produto.getPreco());
        newproduto.setQuantidade(produto.getQuantidade());
        listaProduto.add(newproduto);
    }

    public List<Produto> listarTodos() throws Exception {
        if (listaProduto.isEmpty()) {
            throw new Exception("Nenhum produto cadastrado");
        } else {
            return listaProduto;
        }
    }

    public Produto buscarPorId(Integer id) throws Exception {
        for (int i = 0; i < listaProduto.size(); i++) {
            if (listaProduto.get(i).getId().equals(id)) {
                return listaProduto.get(i);
            }
        }
        throw new Exception("Produto não existe!!!");


    }
}


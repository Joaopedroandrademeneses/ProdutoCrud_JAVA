package model;

public class Produto {
    private Integer id;
    private String nome;
    private String categoria;
    private double preco;
    private Integer quantidade;
    private static int cont = 0;

    public Produto(String nome, String categoria, double preco, Integer quantidade) {
        this.id = cont;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
        cont++;
    }

    public Produto() {
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        if (nome == null || nome.isBlank()) {
            throw new Exception("Nome do produto não pode ser vazio!!!");
        } else {
            this.nome = nome;
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws Exception {
        if (preco <= 0) {
            throw new Exception("Preco não pode ser menor que 0,00");
        } else {
            this.preco = preco;
        }
    }


    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) throws Exception {
        if (quantidade <= 0) {
            throw new Exception("Quantidade não pode ser menor que 0");
        }else {
            this.quantidade=quantidade;
        }
    }

//Metodo de controle para facilitar a impressao utilizando o toString()
    @Override
    public String toString() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Categoria: " + categoria +
                " | Preco: R$" + preco +
                " | Quantidade: " + quantidade;
    }
}

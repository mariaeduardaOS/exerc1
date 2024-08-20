public class Autor {
    private int idAutor;
    private String nome;
    private String nacionalidade;
    // ... getters e setters
}

public class Livro {
    private int idLivro;
    private String titulo;
    private int anoPublicacao;
    private Autor autor; // Associação com a classe Autor
    // ... getters e setters
}

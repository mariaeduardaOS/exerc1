public class livro {
    private int idlivro;
    private String titulo;
    private int datePublicacao;
    private int idautor;

    public livro(int idlivro, String titulo, int datePublicacao, int idautor) {
        this.idlivro = idlivro;
        this.titulo = titulo;
        this.datePublicacao = datePublicacao;
        this.idautor = idautor;
    }

    public int getIdlivro() {
        return idlivro;
    }

    public void setIdlivro(int idlivro) {
        this.idlivro = idlivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getdatePublicacao() {
        return datePublicacao;
    }

    public void setdatePublicacao(int datePublicacao) {
        this.datePublicacao = datePublicacao;
    }

    public int getIdautor() {
        return idautor;
    }

    public void setIdautor(int idautor) {
        this.idautor = idautor;
    }
}

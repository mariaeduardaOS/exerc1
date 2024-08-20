public class autor {

    private int idautor;
    private String nome;
    private String nacionalidade;

    public autor() {
    }

    public autor(int idautor, String nome, String nacionalidade) {
        this.idautor = idautor;
        this.nome = nome;
        this.nacionalidade = nacionalidade;
    }

    public int getIdautor() {
        return idautor;
    }

    public void setId(int idautor) {
        this.idautor = idautor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        autor autor = (autor) obj;
        return idautor == autor.idautor && nome.equals(autor.nome) && nacionalidade.equals(autor.nacionalidade);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "idautor=" + idautor +
                ", nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                '}';
    }
}

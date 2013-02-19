package model;

public class Foto {
    private String nome;
    private String path;

    public Foto(){

    }

    public Foto(String nome, String path) {
        this.nome = nome;
        this.path = path;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + path.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Foto){
            Foto foto = (Foto) obj;
            return foto.path.equals(path);
        }

        return false;
    }
}
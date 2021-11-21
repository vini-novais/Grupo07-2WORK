package br.com.work.ToWork.Spring.boot.dominio;

public class IteratorUsuario implements Iterator{

    private Usuario[] usuarios;
    private Integer posicao = 0;

    public IteratorUsuario(Usuario[] usuarios) {
        this.usuarios = usuarios;
    }

    public Object next() {
        Usuario usuarios = this.usuarios[posicao];
        posicao++;
        return usuarios;

    }

    public Boolean hasNext() {
        if (posicao >= this.usuarios.length || this.usuarios[posicao] == null){
            return false;
        }else{
            return true;
        }
    }
}

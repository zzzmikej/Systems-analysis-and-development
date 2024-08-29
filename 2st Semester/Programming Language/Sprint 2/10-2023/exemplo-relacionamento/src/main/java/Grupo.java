import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nome;

    private List<Contato> contatos;

    public Grupo(String nome) {
        this.nome = nome;
        contatos = new ArrayList<>();
    }

    public void adicionar(Contato c){
        contatos.add(c);
    }

    public void remover(Contato c){
        for (int i = 0; i < contatos.size(); i++){
            if (contatos.get(i).getNome().equals(c.getNome())){
                contatos.remove(i);
                i--;
            }
        }
    }

    public List<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contato> contatos) {
        this.contatos = contatos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "nome='" + nome + '\'' +
                ", contatos=" + contatos +
                '}';
    }
}

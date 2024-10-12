import java.util.LinkedList;


public class Tabela_Hash {
    private final int tamanhoTabela;
    private final LinkedList<Entry<Integer, Integer>>[] tabela;

    // Construtor
    @SuppressWarnings("unchecked")
    public Tabela_Hash(int tamanhoTabela){
        this.tamanhoTabela = 10;
        this.tabela = new LinkedList[tamanhoTabela];
        for (int i = 0; i < tamanhoTabela; i++){
            this.tabela[i] = new LinkedList<>();
        }
    }

    // Método de Calculo
    private int calculaIndice(int chave){
        return  chave % tamanhoTabela;
    }

    // Método de Inserir
    public void inserir(int chave){
        int indice = calculaIndice(chave);
        LinkedList<Entry<Integer, Integer>> bucket = tabela[indice];
        for (Entry<Integer, Integer> entry : bucket){
            if(entry.chave.equals(chave)){
                entry.valor = chave;
                return;
            }
        }
        bucket.add(new Entry<>(chave, chave));
    }

    // Método de Busca
    public boolean buscar(int chave){
        int indice = calculaIndice(chave);
        LinkedList<Entry<Integer, Integer>> bucket = tabela[indice];
        for (Entry<Integer, Integer> entry : bucket){
            if(entry.chave.equals(chave)){
                return true;
            }
        }
        return false;
    }

    // Método de Remover
    public void remover(int chave){
        int indice = calculaIndice(chave);
        LinkedList<Entry<Integer, Integer>> bucket = tabela[indice];
        for (Entry<Integer, Integer> entry : bucket){
            if(entry.chave.equals(chave)){
                entry.valor = 0;
                return;
            }
        }
    }

    // Exibir Tabela
    public void exibirTabela(){
        for (int i = 0; i < tamanhoTabela; i++){
            System.out.println("Bucket " + i + ": ");
            for (Entry<Integer, Integer> entry : tabela[i]){
                System.out.println("[" + entry.chave + "=" + entry.valor + "]");
            }
            System.out.println();
        }
    }
}

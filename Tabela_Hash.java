import java.util.LinkedList;

public class Tabela_Hash<K, V> {
    private final int tamanhoTabela;
    private final LinkedList<Entry<K, V>>[] tabela;

    // Construtor
    @SuppressWarnings("unchecked")
    public Tabela_Hash() {
        this.tamanhoTabela = 18; // Definindo tamanho da tabela
        tabela = new LinkedList[tamanhoTabela];
        for (int i = 0; i < tamanhoTabela; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    // Método para calcular o índice do bucket
    private int calcularIndice(K chave, int tamanhoTabela) {
        return Math.abs(chave.hashCode()) % tamanhoTabela;
    }

    // Método de Inserir
    public void inserir(K chave, V valor) {
        int indice = calcularIndice(chave, tamanhoTabela);
        LinkedList<Entry<K, V>> bucket = tabela[indice];

        for (Entry<K, V> entry : bucket) {
            if (entry.chave.equals(chave)) {
                entry.valor = valor;
                return;
            }
        }
        bucket.add(new Entry<>(chave, valor));
    }

    // Método de Busca
    public V buscar(K chave) {
        int indice = calcularIndice(chave, tamanhoTabela);
        LinkedList<Entry<K, V>> bucket = tabela[indice];

        for (Entry<K, V> entry : bucket) {
            if (entry.chave.equals(chave)) {
                return entry.valor;
            }
        }
        return null;
    }

    // Método de Remover
    public void remover(K chave) {
        int indice = calcularIndice(chave, tamanhoTabela);
        LinkedList<Entry<K, V>> bucket = tabela[indice];

        bucket.removeIf(entry -> entry.chave.equals(chave));
    }

    // Exibir Tabela
    public void exibir() {
        for (int i = 0; i < tamanhoTabela; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Entry<K, V> entry : tabela[i]) {
                System.out.print("[" + entry.chave + " = " + entry.valor + "] ");
            }
            System.out.println();
        }
    }
}

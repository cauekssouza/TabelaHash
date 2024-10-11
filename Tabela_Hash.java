import java.util.LinkedList;

public class Tabela_Hash {
    private final int tamanhoTabela;
    private final LinkedList<Entry<Integer, Integer>>[] tabela;

    // Construtor
    @SuppressWarnings("unchecked")
    public Tabela_Hash() {
        this.tamanhoTabela = 10; // Tamanho da tabela ajustado para 10
        tabela = new LinkedList[tamanhoTabela];
        for (int i = 0; i < tamanhoTabela; i++) {
            tabela[i] = new LinkedList<>();
        }
    }

    // Método para calcular o índice do bucket (Função Hash)
    private int calcularIndice(int chave) {
        return chave % tamanhoTabela; // Simples hash function para evitar colisões
    }

    // Método de Inserir
    public void inserir(int chave) {
        int indice = calcularIndice(chave);
        LinkedList<Entry<Integer, Integer>> bucket = tabela[indice];

        for (Entry<Integer, Integer> entry : bucket) {
            if (entry.chave.equals(chave)) {
                entry.valor = chave; // Atualiza o valor se a chave já existir
                return;
            }
        }
        bucket.add(new Entry<>(chave, chave)); // Adiciona novo par chave-valor
    }

    // Método de Busca (Ajustado para retornar booleano)
    public boolean buscar(int chave) {
        int indice = calcularIndice(chave);
        LinkedList<Entry<Integer, Integer>> bucket = tabela[indice];

        for (Entry<Integer, Integer> entry : bucket) {
            if (entry.chave.equals(chave)) {
                return true; // Chave encontrada
            }
        }
        return false; // Chave não encontrada
    }

    // Método de Remover (Ajustado para definir valor como 0)
    public void remover(int chave) {
        int indice = calcularIndice(chave);
        LinkedList<Entry<Integer, Integer>> bucket = tabela[indice];

        for (Entry<Integer, Integer> entry : bucket) {
            if (entry.chave.equals(chave)) {
                entry.valor = 0; // Define valor como 0 ao invés de remover
                return;
            }
        }
    }

    // Exibir Tabela
    public void exibir() {
        for (int i = 0; i < tamanhoTabela; i++) {
            System.out.print("Bucket " + i + ": ");
            for (Entry<Integer, Integer> entry : tabela[i]) {
                System.out.print("[" + entry.chave + " = " + entry.valor + "] ");
            }
            System.out.println();
        }
    }
}

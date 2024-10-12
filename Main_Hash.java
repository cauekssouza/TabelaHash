public class Main_Hash {
    public static void main(String[] args) {
        Tabela_Hash tabela_Hash = new Tabela_Hash(10);
        int[] valores = {12, 25, 37, 41, 53, 64, 78, 89};

        // Inserir os valores
        for (int valor : valores) {
            tabela_Hash.inserir(valor);
        }

        // Exibir tabela após inserções
        tabela_Hash.exibirTabela();

        // Buscar alguns valores
        System.out.println("Buscar 25: " + tabela_Hash.buscar(25)); // true
        System.out.println("Buscar 100: " + tabela_Hash.buscar(100)); // false

        // Remover um valor
        tabela_Hash.remover(25);
        tabela_Hash.exibirTabela();
    }
}


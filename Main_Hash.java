public class Main_Hash {
    public static void main(String[] args) {
        Tabela_Hash tabelaHash = new Tabela_Hash();
        int[] valores = {12, 25, 37, 41, 53, 64, 78, 89};

        // Inserir os valores
        for (int valor : valores) {
            tabelaHash.inserir(valor);
        }

        // Exibir tabela após inserções
        tabelaHash.exibir();

        // Buscar alguns valores
        System.out.println("Buscar 25: " + tabelaHash.buscar(25)); // true
        System.out.println("Buscar 100: " + tabelaHash.buscar(100)); // false

        // Remover um valor
        tabelaHash.remover(25);
        tabelaHash.exibir();       
}
}

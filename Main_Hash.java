public class Main_Hash {
    public static void main(String[] args) {
        Tabela_Hash<String, Integer> tabelaHash = new Tabela_Hash<>();

        // Inserindo elementos
        tabelaHash.inserir("Cauê", 20);
        tabelaHash.inserir("Marina", 25);
        tabelaHash.inserir("Daniel", 19);

        // Buscando valor associado a uma chave
        System.out.println("Idade de Cauê: " + tabelaHash.buscar("Cauê"));

        // Removendo um elemento
        tabelaHash.remover("Marina");

        // Exibindo a tabela hash
        tabelaHash.exibir();
    }
}

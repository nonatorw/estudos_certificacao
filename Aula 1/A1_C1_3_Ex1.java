class Pessoa {
    static int id = 10;
}

public class A1_C1_3_Ex1 {
    public static void main(String[] args) {
        // Acessando a variável através de uma instância da classe
        Pessoa p = new Pessoa();
        System.out.println("Referência por instância: " + p.id);

        // Acessando a variável através de referência direta à classe
        System.out.println("Referência direta.......: " + Pessoa.id);
    }
}
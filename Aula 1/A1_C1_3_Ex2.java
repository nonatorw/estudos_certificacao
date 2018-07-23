class Pessoa {
    static int id = 10;
    static void metodo(){
        System.out.println(id);
    }
}

public class A1_C1_3_Ex2 {
    public static void main(String[] args) {
        // Acessando a variável através de método estático
        Pessoa.metodo();
    }
}
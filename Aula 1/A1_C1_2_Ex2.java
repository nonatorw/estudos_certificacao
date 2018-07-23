public class A1_C1_2_Ex2 {

    String nome = "nonato";

    // Variáveis de instância podem acessar outras variáveis de instância
    String nomeCompleto = "Rodrigo " + nome;

    // A variável de intância é acessível dentro do(s) construtor(es) da classe.
    public A1_C1_2_Ex2(){
        System.out.println(nome);
    }

    // A variável de intância também é acessível dentro do(s) método(s) da classe.
    public void m1(){
        System.out.println(nomeCompleto);
    }

    public static void main(String[] args) {
        A1_C1_2_Ex2 t = new A1_C1_2_Ex2();
        t.m1();
    }
}
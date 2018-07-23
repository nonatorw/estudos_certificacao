public class A1_C1_2_Ex1 {

    String nome = "nonato";

    // A variável de intância é acessível dentro do(s) construtor(es) da classe.
    public A1_C1_2_Ex1(){
        System.out.println(nome);
    }

    // A variável de intância também é acessível dentro do(s) método(s) da classe.
    public void m1(){
        System.out.println(nome);
    }

    public static void main(String[] args) {
        A1_C1_2_Ex1 t = new A1_C1_2_Ex1();
        t.m1();
    }
}
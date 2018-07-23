public class A1_C1_1_Ex5 {

    public static void main(String[] args) {
        A1_C1_1_Ex5 t = new A1_C1_1_Ex5("nonato - construtor");
        t.m1("nonato - m1");
        //t.m2();
    }

    public A1_C1_1_Ex5(String nome) {
        System.out.println(nome);
    }

    public void m1(String nome) {
        System.out.println(nome);
        /* Mesmo que chamemos o método m2 dentro de um construtor 
         * (que possui nome em seu escopo), não seria possível usar 
         * *nome* dentro de m4.
         * 
         * m2();
         */
    }

    /* m2 não tem acesso a variável/parâmetro nome, pois a mesma não está 
     * em seu escopo.
     * 
     * public void m2() {
     *      System.out.println(nome);
     * }
     */
}
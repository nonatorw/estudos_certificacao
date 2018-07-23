public class A1_C1_1_Ex3 {

    public static void main(String[] args) {
        A1_C1_1_Ex3 t = new A1_C1_1_Ex3();
        t.m1();
    }

    public void m1() {
        for (int i = 0, j = 0; i <= 10 && j <= 10; i++) {
            System.out.println(i + " - " + j);
            j++;
        }
        /* Por conta das variáveis i, j serem declaradas no escopo do *for*,
         * os comandos abaixo resultam em erro.
         *
         * System.out.println(i + " - " + j);
         */
    }
}
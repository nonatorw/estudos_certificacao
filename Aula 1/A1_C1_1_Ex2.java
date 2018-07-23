public class A1_C1_1_Ex2 {

    public static void main(String[] args) {
        A1_C1_1_Ex2 t = new A1_C1_1_Ex2();
        t.m1();
    }

    public void m1() {
        int x = 10;
        if (x >= 10) {
            int y = 50;
            System.out.println(y);
        }
        /* A linha abaixo gera erro de compilação, pois y pertence ao escopo do if.
         *
         * System.out.println(y);
         */
        System.out.println(x);
    }
}
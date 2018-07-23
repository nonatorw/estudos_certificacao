class Bla{
    // Variável estática e parâmetro de método estático com o mesmo nome
    static int x = 0;
    public static void setX(int x){
        Bla.x = x;
    }

    // Atributo e parãmetro com o mesmo nome
    int y = 0;
    public void setY(int y){
        this.y = y;
    }
}

class X {
    int a = 10;

    public void m1() {
        int a = 20;
        // aplicando shadowing (escopo mais baixo)
        System.out.println("Variável local (c/ shadowing): " + a);

        // Referenciando o atributo (escopo mais alto)
        System.out.println("Atributo (s/ shadowing)......: " + this.a);
    }
}

public class A1_C1_4_Ex4 {
    public static void main(String[] args) {
        new X().m1();
    }
}
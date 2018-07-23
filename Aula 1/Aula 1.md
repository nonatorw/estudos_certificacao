#ALURA - Certificação Java SE 7 Programmer

##Aula 1: Define the scope of variables

###__Variável local:__ pertencente ao bloco (delimitado por chaves "{}") onde foi criada, seja um bloco anônimo, método ou construtor. Além disso, o ciclo de vida de uma variável é restrito ao bloco ao qual ela pertence.

```Java
void metodo() {
    // variaveis locais
}

construtor() {
    // variáveis locais
}
```

####Exemplo 1: Declaração de variáveis no escopo do método só pode ser usado dentro do mesmo escopo
```Java
public class Cap1_1_ex1 {

    public static void main(String[] args) {
        Cap1_1_ex1 t = new Cap1_1_ex1();
        t.m1();
    }

    public void m1() {
        int x = 10;
        System.out.println(x);
    }
}
```
#####Log:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_1_ex1.java && java Cap1_1_ex1
10

[Done] exited with code=0 in 0.95 seconds
```

####Exemplo 2: Variáveis declaradas em escopo de if seguem a mesma regra - um erro será exibido se uma variável declarada num if for chamada fora do mesmo.
```Java
public class Cap1_1_ex2 {

    public static void main(String[] args) {
        Cap1_1_ex1 t = new Cap1_1_ex1();
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
```
#####Log 1:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_1_ex2.java && java Cap1_1_ex2
50
10

[Done] exited with code=0 in 0.98 seconds
```

#####Log 2:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_1_ex2.java && java Cap1_1_ex2
Cap1_1_ex2.java:17: error: cannot find symbol
        System.out.println(y);
                           ^
  symbol:   variable y
  location: class Cap1_1_ex2
1 error

[Done] exited with code=1 in 0.889 seconds
```

####Exemplo 3: O *for* também segue a regra do escopo: variáveis declarada no cabeçalho do for só podem ser usadas dentro do escopo do for.
```Java
public class Cap1_1_ex3 {

    public static void main(String[] args) {
        Cap1_1_ex3 t = new Cap1_1_ex3();
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
```
#####Log 1:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_1_ex3.java && java Cap1_1_ex3
0 - 0
1 - 1
2 - 2
3 - 3
4 - 4
5 - 5
6 - 6
7 - 7
8 - 8
9 - 9
10 - 10

[Done] exited with code=0 in 1.02 seconds
```

#####Log 2:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_1_ex3.java && java Cap1_1_ex3
Cap1_1_ex3.java:17: error: cannot find symbol
         System.out.println(i + " - " + j);
                            ^
  symbol:   variable i
  location: class Cap1_1_ex3
Cap1_1_ex3.java:17: error: cannot find symbol
         System.out.println(i + " - " + j);
                                        ^
  symbol:   variable j
  location: class Cap1_1_ex3
2 errors

[Done] exited with code=1 in 0.77 seconds
```

####Exemplo 4: Tentativa de usar um parâmetro no escopo de outro método, mesmo que este seja invocado dentro do método ao qual pertence o parâmetro. Se o parâmetro não for repassado, um erro de execução será exibido.
```Java
public class Cap1_1_ex4 {

    public static void main(String[] args) {
        Cap1_1_ex4 t = new Cap1_1_ex4();
        t.m1("nonato");
        //t.m2();
    }

    public void m1(String nome) {
        System.out.println(nome);
        /* Mesmo que chamemos o método m4 dentro de m3 (que possui nome em seu escopo),
         * não seria possível usar *nome* dentro de m4.
         * m2();
         */
    }

    /* 
     * public void m2() {
     *      System.out.println(nome);
     * }
     */
}
```
#####Log 1:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_1_ex4.java && java Cap1_1_ex4
nonato - m1

[Done] exited with code=0 in 0.973 seconds
```

#####Log 2: m2 não tem acesso a variável/parâmetro nome, pois a mesma não está em seu escopo.
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_1_ex4.java && java Cap1_1_ex4
Cap1_1_ex4.java:23: error: cannot find symbol
        System.out.println(nome);
                           ^
  symbol:   variable nome
  location: class Cap1_1_ex4
1 error

[Done] exited with code=1 in 0.826 seconds
```

#####Log 3: Mesmo que invoquemos o método m2 dentro de m1 (que possui nome em seu escopo), não seria possível usar *nome* dentro de m2.
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_1_ex4.java && java Cap1_1_ex4
Cap1_1_ex4.java:23: error: cannot find symbol
        System.out.println(nome);
                           ^
  symbol:   variable nome
  location: class Cap1_1_ex4
1 error

[Done] exited with code=1 in 0.811 seconds

```

####Exemplo 5: Os *construtores* se comportam da mesma maneira aos métodos em relação ao comportamento relacionado aos seus parâmetros.
```Java
public class Cap1_1_ex5 {

    public static void main(String[] args) {
        Cap1_1_ex5 t = new Cap1_1_ex5("nonato - construtor");
        t.m1("nonato - m1");
        //t.m2();
    }

    public Cap1_1_ex5(String nome) {
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
```
#####Log 1:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_1_ex5.java && java Cap1_1_ex5
nonato - construtor
nonato - m1

[Done] exited with code=0 in 0.976 seconds
```

#####Log 2: m2 não tem acesso a variável/parâmetro nome, pois a mesma não está em seu escopo.
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_1_ex5.java && java Cap1_1_ex5
Cap1_1_ex5.java:27: error: cannot find symbol
        System.out.println(nome);
                           ^
  symbol:   variable nome
  location: class Cap1_1_ex5
1 error

[Done] exited with code=1 in 0.78 seconds
```

#####Log 3: Mesmo que chamemos o método m2 dentro de um construtor (que possui nome em seu escopo), não seria possível usar *nome* dentro de m2.
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_1_ex5.java && java Cap1_1_ex5
Cap1_1_ex5.java:27: error: cannot find symbol
        System.out.println(nome);
                           ^
  symbol:   variable nome
  location: class Cap1_1_ex5
1 error

[Done] exited with code=1 in 0.784 seconds
```
###__Variável de Instância:__ também conhecidas como __Variável de Objeto__, __Atributo de Classe/Objeto/Instância__ ou __Variável-membro__, são variáveis declaradas dentro da classe. Esse tipo de variável pode ser acessada em qualquer lugar dentro da minha classe (construtores, métodos e blocos pertencentes a classe).

####Exemplo 1: Variáveis de instância podem ser acessadas por todos os blocos pertencentes a classe.
```Java
public class Cap1_2_ex1 {

    String nome = "nonato";

    // A variável de intância é acessível dentro do(s) construtor(es) da classe.
    public Cap1_2_ex1(){
        System.out.println(nome);
    }

    // A variável de intância também é acessível dentro do(s) método(s) da classe.
    public void m1(){
        System.out.println(nome);
    }

    public static void main(String[] args) {
        Cap1_2_ex1 t = new Cap1_2_ex1();
        t.m1();
    }
}
```

#####Log 1:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_2_ex1.java && java Cap1_2_ex1
nonato
nonato

[Done] exited with code=0 in 1.137 seconds
```

####Exemplo 2:
```Java
public class Cap1_2_ex2 {

    String nome = "nonato";

    // Variáveis de instância podem acessar outras variáveis de instância
    String nomeCompleto = "Rodrigo " + nome;

    // A variável de intância é acessível dentro do(s) construtor(es) da classe.
    public Cap1_2_ex2(){
        System.out.println(nome);
    }

    // A variável de intância também é acessível dentro do(s) método(s) da classe.
    public void m1(){
        System.out.println(nomeCompleto);
    }

    public static void main(String[] args) {
        Cap1_2_ex2 t = new Cap1_2_ex2();
        t.m1();
    }
}
```

#####Log 1:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_2_ex2.java && java Cap1_2_ex2
nonato
Rodrigo nonato

[Done] exited with code=0 in 1.158 seconds
```

####Exemplo 3: Variáveis de instância podem ser acessadas diretamente pela instância.
```Java
public class Cap1_2_ex3 {

    String nome = "nonato";

    // Variáveis de instância podem acessar outras variáveis de instância
    String nomeCompleto = "Rodrigo " + nome;

    // A variável de intância é acessível dentro do(s) construtor(es) da classe.
    public Cap1_2_ex3(){
        System.out.println(nome);
    }

    // A variável de intância também é acessível dentro do(s) método(s) da classe.
    public void m1(){
        System.out.println(nomeCompleto);
    }

    public static void main(String[] args) {
        Cap1_2_ex3 t = new Cap1_2_ex3();
        t.m1();
        // Variáveis de instância podem ser acessadas diretamente pela instância:
        t.nome = "Jão";
        t.nomeCompleto = t.nome + " da Silva";
        t.m1();
    }
}
```
#####Log 1:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_2_ex3.java && java Cap1_2_ex3
nonato
Rodrigo nonato
Jão da Silva

[Done] exited with code=0 in 1.121 seconds
```

###__Variáveis Estáticas___: variável em que que o valor de uma variável estática é o mesmo (compartilhado) por todas as instâncias da mesma classe dentro da VM. Em suma, pode ser acessada através de qualquer escopo.

####Exemplo 1: É criada em uma classe e pode ser acessada por referência a instância desta classe, ou por referência direta a classe a qual pertence.
```Java
class Pessoa {
    static int id = 10;
}

public class Cap1_3_ex1 {
    public static void main(String[] args) {
        // Acessando a variável através de uma instância da classe
        Pessoa p = new Pessoa();
        System.out.println("Referência por instância: " + p.id);

        // Acessando a variável através de referência direta à classe
        System.out.println("Referência direta: " + Pessoa.id);
    }
}
```

#####Log 1:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_3_ex1.java && java Cap1_3_ex1
Referência por instância: 10
Referência direta: 10

[Done] exited with code=0 in 1.059 seconds
```
####Exemplo 2: Variáveis estáticas podem ser acessadas por meio de um método estático.
```Java
class Pessoa {
    static int id = 10;
    // método estático
    static void metodo(){
        System.out.println(id);
    }
}

public class Cap1_3_ex2 {
    public static void main(String[] args) {
        // Acessando a variável através de método estático
        Pessoa.metodo();
    }
}
```

#####Log 1:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_3_ex2.java && java Cap1_3_ex2
10

[Done] exited with code=0 in 1.01 seconds
```
###__Cuidados com a declaração de variáveis:__

####1) Não é permitido criar mais de uma variável com o mesmo nome no mesmo escopo.
```Java
public class Cap1_4_ex1 {
    public static void main(String[] args) {
        int a = 1;
        int a = 10;
    }
}
```

#####Log 1:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_4_ex1.java && java Cap1_4_ex1
Cap1_4_ex1.java:4: error: variable a is already defined in method main(String[])
        int a = 10;
            ^
1 error

[Done] exited with code=1 in 0.782 seconds
```

####2) Não é permitido criar uma variável com o mesmo nome de um parâmetro.
```Java
public class Cap1_4_ex2 {
    public static void main(String[] args) {
        int a = 1;
        int args = 10;
    }
}
```

#####Log 1:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_4_ex2.java && java Cap1_4_ex2
Cap1_4_ex2.java:4: error: variable args is already defined in method main(String[])
        int args = 10;
            ^
1 error

[Done] exited with code=1 in 0.776 seconds
```

####3) Não é permitido criar uma variável com o mesmo nome de uma variável estática.
```Java
class Bla{
    static int a;
    int a;
}

public class Cap1_4_ex3 {
    public static void main(String[] args) {
    }
}
```

#####Log 1:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_4_ex3.java && java Cap1_4_ex3
Cap1_4_ex3.java:3: error: variable a is already defined in class Bla
    int a;
        ^
1 error

[Done] exited with code=1 in 0.81 seconds
```

####4) É possível: chamamos de __shadowing__
 a) criar uma variável estática e um parâmetro de método/construtor com o mesmo nome;
 b) criar um atributo e um parâmetro de método/construtor com o mesmo nome;
 C) criar um atributo e uma variável de escopo local (em construtor/método/bloco) com o mesmo nome;
```Java
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

public class Cap1_4_ex4 {
    public static void main(String[] args) {
        new X().m1();
    }
}
```

#####Log 1:
```
[Running] cd "c:\Users\wellington.r.nonato\OneDrive - Accenture\0 - Personal\Estudos\alura_java_certificacao\" && javac Cap1_4_ex4.java && java Cap1_4_ex4
Variável local (c/ shadowing): 20
Atributo (s/ shadowing)......: 10
10

[Done] exited with code=0 in 0.981 seconds
```


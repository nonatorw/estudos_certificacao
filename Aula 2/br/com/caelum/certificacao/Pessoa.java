// [Opcional] Declaração do pacote
package br.com.caelum.certificacao;

/*
 * [Opcional] Imports: caso necessários, devem ser declarados após a 
 * declaração da package
 import java.util.Date; // Comentário de linha
 import java.io.*;
 */

/*
 * Classe hipotética, fora dos paradigmas de programação Java, onde todos os 
 * seus componentes possuem nomes semelhantes, a fim de comprovar que o Java
 * consegue discernir do que se trata cada um dos componentes desta classe.
 */
class B {
    // Atributo Membro com o mesmo nome da classe
    int B;

    /*
     * Construtor.
     * Atenção: pode ser uma pegadinha de certificação dar um construtor 
     * dizendo que é um método (ou o contrário)
     */
    B(){
    }

    // Método com o mesmo nome da Classe, Atributo Membro e Construtor
    void B() {
    }
}

/** Javadoc
 * 
 */
class /* nome da classe */ Pessoa {
    // Atributo membro
    String nome;

    // Variável estática:
    static int totalDePessoas = 0;

    /*
     * Construtores: não possui retorno declarado, pois sempre retorna o objeto 
     * ao qual referencia. Pode-se incluir um return vazio.
     */
    Pessoa(String nome) {
        if (nome == null) {
            nome = "Rodrigo";
            return;
        }

        this.nome = nome;
    }

    /*
     * Construtor padrão: sem parâmetros na assinatura, e não necessáriamente 
     * precisa de implementação, pois o seu retorno é exatamente o objeto ao 
     * qual referencia.
     */
    Pessoa(){
        // Return vazio (no construtor) = retorna objeto do construtor.
        return;
    }

    // Método
    public String getNome(){
        String sobrenome = "Nonato";
        return this.nome + sobrenome;
    }

    /* Método estático: pertencente a classe */
    public static void main(String[] args) {
        /*
         * tudo o que estiver aqui 
         *  - Aqui também
         */
    }
}

/* 
 * Interfaces: podem ter variáveis, constantes e métodos. 
 * Todas as variáveis, constantes e métodos de uma interface são public static
 * por default;
 * Todos os métodos são public abstract por default.
 * 
 */
interface Figura {
    // Constantes de Interface: por default, são públicos e estáticos.
    // public static final int TAMANHO = 5;
    int TAMANHO = 5;

    // Métodos de Interface: por default, são públicos e estáticos.
    // public abstract void autentica(String nome, String senha);
    void autentica(String nome, String senha);
}

/*
 * Observações: em um arquivo java, pode haver uma classe/interface/Enum/etc
 * público, ou nenhum deles. Caso haja, o arquivo deverá ter o mesmo nome que a
 * classe/interface/Enum/etc.
 */
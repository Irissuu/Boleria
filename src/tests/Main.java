package tests;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        System.out.println("\uD83C\uDF70Bem-vindo a Doce Magia! Nossa Boleria\uD83C\uDF82 \nVeja o menu abaixo:");
        System.out.println("[Menu]" +
                "\n0- Sair" +
                "\n1- Cadastrar" +
                "\n2- Listar" +
                "\n3- Consultar por codigo" +
                "\n4- Consultar por sabores" +
                "\n5- Alterar" +
                "\n6- Excluir" +
                "\nDigite a operação desejada: ");
        int op = leitor.nextInt();
    }
}

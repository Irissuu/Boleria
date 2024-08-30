package tests;

import models.Bolos;
import repository.GuardarBolosRepository;
import repository.BolosRepository;
import enums.TipoBolo;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static BolosRepository repository = new GuardarBolosRepository();
    private static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\uD83C\uDF70Bem-vindo à Doce Magia! Nossa Boleria\uD83C\uDF82 \nVeja o menu abaixo:");
            System.out.println("[Menu]" +
                    "\n0- Sair" +
                    "\n1- Cadastrar" +
                    "\n2- Listar" +
                    "\n3- Consultar por código" +
                    "\n4- Consultar por sabor" +
                    "\n5- Alterar" +
                    "\n6- Excluir" +
                    "\nDigite a operação desejada: ");
            int op = leitor.nextInt();
            leitor.nextLine();

            switch (op) {
                case 0:
                    System.out.println("Saindo...");
                    return;
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    consultarPorCodigo();
                    break;
                case 4:
                    consultarPorSabor();
                    break;
                case 5:
                    alterar();
                    break;
                case 6:
                    excluir();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrar() {
        System.out.println("Escolha o sabor do bolo:");
        System.out.println("1 - BOLO_DE_CENOURA");
        System.out.println("2 - BOLO_DE_CHOCOLATE");
        System.out.println("3 - BOLO_DE_BAUNILHA");
        System.out.println("4 - BOLO_DE_LARANJA");
        System.out.println("5 - BOLO_DE_FESTA");
        System.out.print("Digite o número correspondente ao sabor: ");
        int saborEscolhido = leitor.nextInt();
        leitor.nextLine();

        TipoBolo sabor;
        switch (saborEscolhido) {
            case 1:
                sabor = TipoBolo.BOLO_DE_CENOURA;
                break;
            case 2:
                sabor = TipoBolo.BOLO_DE_CHOCOLATE;
                break;
            case 3:
                sabor = TipoBolo.BOLO_DE_BAUNILHA;
                break;
            case 4:
                sabor = TipoBolo.BOLO_DE_LARANJA;
                break;
            case 5:
                sabor = TipoBolo.BOLO_DE_FESTA;
                break;
            default:
                System.out.println("Opção inválida. Sabor definido como BOLO_DE_CENOURA.");
                sabor = TipoBolo.BOLO_DE_CENOURA;
                break;
        }

        System.out.print("Digite o nome do bolo: ");
        String nome = leitor.nextLine();
        System.out.print("Digite a data de fabricação (no formato DD-MM-AAAA): ");
        String fabricacao = leitor.nextLine();
        System.out.print("Digite a data de validade (no formato DD-MM-AAAA): ");
        String validade = leitor.nextLine();
        System.out.print("Digite o preço: ");
        double preco = leitor.nextDouble();
        leitor.nextLine();
        System.out.print("Digite o código do bolo: ");
        String codigo = leitor.nextLine();

        Bolos bolo = new Bolos();
        bolo.setSabor(sabor);
        bolo.setNome(nome);
        bolo.setFabricacao(fabricacao);
        bolo.setValidade(validade);
        bolo.setPreco(preco);
        bolo.setCodigo(codigo);

        repository.adicionar(bolo);
        System.out.println("Bolo cadastrado com sucesso!");
    }

    private static void listar() {
        List<Bolos> bolosList = repository.listar();
        if (bolosList.isEmpty()) {
            System.out.println("Nenhum bolo cadastrado.");
        } else {
            for (Bolos bolo : bolosList) {
                bolo.exibirFichaTecnica();
                System.out.println();
            }
        }
    }

    private static void consultarPorCodigo() {
        System.out.print("Digite o código do bolo para consulta: ");
        String codigo = leitor.nextLine();
        Bolos bolo = repository.consultarPorCodigo(codigo);
        if (bolo != null) {
            bolo.exibirFichaTecnica();
        } else {
            System.out.println("Bolo não encontrado.");
        }
    }

    private static void consultarPorSabor() {
        System.out.println("Escolha o sabor do bolo para consulta:");
        System.out.println("1 - BOLO_DE_CENOURA");
        System.out.println("2 - BOLO_DE_CHOCOLATE");
        System.out.println("3 - BOLO_DE_BAUNILHA");
        System.out.println("4 - BOLO_DE_LARANJA");
        System.out.println("5 - BOLO_DE_FESTA");
        System.out.print("Digite o número correspondente ao sabor: ");
        int saborEscolhido = leitor.nextInt();
        leitor.nextLine();

        TipoBolo sabor;
        switch (saborEscolhido) {
            case 1:
                sabor = TipoBolo.BOLO_DE_CENOURA;
                break;
            case 2:
                sabor = TipoBolo.BOLO_DE_CHOCOLATE;
                break;
            case 3:
                sabor = TipoBolo.BOLO_DE_BAUNILHA;
                break;
            case 4:
                sabor = TipoBolo.BOLO_DE_LARANJA;
                break;
            case 5:
                sabor = TipoBolo.BOLO_DE_FESTA;
                break;
            default:
                System.out.println("Opção inválida. Consulta cancelada.");
                return;
        }

        List<Bolos> bolosList = repository.listar();
        boolean encontrado = false;
        for (Bolos bolo : bolosList) {
            if (bolo.getSabor() == sabor) {
                bolo.exibirFichaTecnica();
                System.out.println();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhum bolo com o sabor especificado foi encontrado.");
        }
    }

    private static void alterar() {
        System.out.print("Digite o código do bolo para alteração: ");
        String codigo = leitor.nextLine();
        Bolos bolo = repository.consultarPorCodigo(codigo);
        if (bolo != null) {
            System.out.println("Escolha o novo sabor do bolo:");
            System.out.println("1 - BOLO_DE_CENOURA");
            System.out.println("2 - BOLO_DE_CHOCOLATE");
            System.out.println("3 - BOLO_DE_BAUNILHA");
            System.out.println("4 - BOLO_DE_LARANJA");
            System.out.println("5 - BOLO_DE_FESTA");
            System.out.print("Digite o número correspondente ao novo sabor: ");
            int saborEscolhido = leitor.nextInt();
            leitor.nextLine();

            TipoBolo sabor;
            switch (saborEscolhido) {
                case 1:
                    sabor = TipoBolo.BOLO_DE_CENOURA;
                    break;
                case 2:
                    sabor = TipoBolo.BOLO_DE_CHOCOLATE;
                    break;
                case 3:
                    sabor = TipoBolo.BOLO_DE_BAUNILHA;
                    break;
                case 4:
                    sabor = TipoBolo.BOLO_DE_LARANJA;
                    break;
                case 5:
                    sabor = TipoBolo.BOLO_DE_FESTA;
                    break;
                default:
                    System.out.println("Opção inválida. Sabor definido como BOLO_DE_CENOURA.");
                    sabor = TipoBolo.BOLO_DE_CENOURA;
                    break;
            }
            bolo.setSabor(sabor);

            System.out.print("Digite o novo nome do bolo: ");
            bolo.setNome(leitor.nextLine());
            System.out.print("Digite a nova data de fabricação (no formato DD-MM-AAAA): ");
            bolo.setFabricacao(leitor.nextLine());
            System.out.print("Digite a nova data de validade (no formato DD-MM-AAAA): ");
            bolo.setValidade(leitor.nextLine());
            System.out.print("Digite o novo preço: ");
            bolo.setPreco(leitor.nextDouble());
            leitor.nextLine();
            repository.alterar(bolo);
            System.out.println("Bolo alterado com sucesso!");
        } else {
            System.out.println("Bolo não encontrado.");
        }
    }

    private static void excluir() {
        System.out.print("Digite o código do bolo para exclusão: ");
        String codigo = leitor.nextLine();
        repository.excluir(codigo);
        System.out.println("Bolo excluído com sucesso!");
    }
}
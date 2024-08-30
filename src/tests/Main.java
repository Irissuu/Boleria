package tests;
import models.Bolos;
import repository.BolosRepository;
import repository.GuardarBolosRepository;
import enums.TipoBolo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static BolosRepository repository = new GuardarBolosRepository();
    private static Scanner leitor = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nVeja o menu abaixo:");
            System.out.println("=====Menu=====" +
                    "\n0- Sair" +
                    "\n1- Cadastrar" +
                    "\n2- Listar" +
                    "\n3- Consultar por código" +
                    "\n4- Alterar" +
                    "\n5- Excluir" +
                    "\n6- Buscar sabor com forEach" +
                    "\n7- Buscar sabor com collect" +
                    "\n8- Consultar bolos em ambas as listas" +
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
                    alterar();
                    break;
                case 5:
                    excluir();
                    break;
                case 6:
                    buscarSaborForEach();
                    break;
                case 7:
                    buscarSaborCollect();
                    break;
                case 8:
                    consultarBolosListas();
                    break;
                default:
                    System.out.println("Opção inválida. Por favor tente novamente.");
            }
        }
    }

    private static void cadastrar() {
        System.out.println("Escolha o sabor do bolo: ");
        System.out.println("1 - BOLO_DE_CENOURA");
        System.out.println("2 - BOLO_DE_CHOCOLATE");
        System.out.println("3 - BOLO_DE_BAUNILHA");
        System.out.println("4 - BOLO_DE_LARANJA");
        System.out.println("5 - BOLO_DE_FESTA");
        System.out.print("Digite o número correspondente ao sabor: ");
        int saborEscolhido = leitor.nextInt();
        leitor.nextLine();

        TipoBolo sabor = obterTipoBolo(saborEscolhido);

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

            TipoBolo sabor = obterTipoBolo(saborEscolhido);
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

    private static void buscarSaborForEach() {
        System.out.println("Escolha o sabor do bolo para busca:");
        System.out.println("1 - BOLO_DE_CENOURA");
        System.out.println("2 - BOLO_DE_CHOCOLATE");
        System.out.println("3 - BOLO_DE_BAUNILHA");
        System.out.println("4 - BOLO_DE_LARANJA");
        System.out.println("5 - BOLO_DE_FESTA");
        System.out.print("Digite o número correspondente ao sabor: ");
        int saborEscolhido = leitor.nextInt();
        leitor.nextLine();

        TipoBolo sabor = obterTipoBolo(saborEscolhido);

        ((GuardarBolosRepository) repository).buscarPorSaborComForEach(sabor);
    }

    private static void buscarSaborCollect() {
        System.out.println("Escolha o sabor do bolo para busca:");
        System.out.println("1 - BOLO_DE_CENOURA");
        System.out.println("2 - BOLO_DE_CHOCOLATE");
        System.out.println("3 - BOLO_DE_BAUNILHA");
        System.out.println("4 - BOLO_DE_LARANJA");
        System.out.println("5 - BOLO_DE_FESTA");
        System.out.print("Digite o número correspondente ao sabor: ");
        int saborEscolhido = leitor.nextInt();
        leitor.nextLine();

        TipoBolo sabor = obterTipoBolo(saborEscolhido);

        List<Bolos> bolos = ((GuardarBolosRepository) repository).buscarSaborCollect(sabor);
        if (bolos.isEmpty()) {
            System.out.println("Nenhum bolo com o sabor indicado foi encontrado.");
        } else {
            bolos.forEach(Bolos::exibirFichaTecnica);
        }
    }

    private static void consultarBolosListas() {
        System.out.println("Consultando bolos em ambas listas");
        List<Bolos> outraLista = new ArrayList<>(repository.listar());

        outraLista.addAll(repository.listar());

        List<Bolos> bolosAmbasListas = ((GuardarBolosRepository) repository).consultarBolosListas(outraLista);
        if (bolosAmbasListas.isEmpty()) {
            System.out.println("Nenhum bolo encontrado em ambas listas.");
        } else {
            bolosAmbasListas.forEach(Bolos::exibirFichaTecnica);
        }
    }

    private static TipoBolo obterTipoBolo(int saborEscolhido) {
        switch (saborEscolhido) {
            case 1:
                return TipoBolo.BOLO_DE_CENOURA;
            case 2:
                return TipoBolo.BOLO_DE_CHOCOLATE;
            case 3:
                return TipoBolo.BOLO_DE_BAUNILHA;
            case 4:
                return TipoBolo.BOLO_DE_LARANJA;
            case 5:
                return TipoBolo.BOLO_DE_FESTA;
            default:
                System.out.println("Opção inválida. Sabor definido como BOLO_DE_CENOURA.");
                return TipoBolo.BOLO_DE_CENOURA;
        }
    }
}
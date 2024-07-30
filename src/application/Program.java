package application;

import model.entities.Product;
import model.entities.AindaVouNomear;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        String path = "C:\\Users\\marco\\OneDrive\\Desktop\\Cursos Programming\\Java " +
                "projects\\Registros\\Registros\\src\\storage\\datastorage.txt";
        boolean exit = false;

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        List<Product> list = new ArrayList<>();
        AindaVouNomear aindaVouNomear = new AindaVouNomear();


        while (!exit) {
            System.out.println("Olá! Seja bem vindo ao registro de produto.");
            System.out.println("1. Criar produto");
            System.out.println("2. Deletar produto");
            System.out.println("3. Mostrar produtos");
            System.out.println("4. Detalhes");
            System.out.println("5. Sair");
            System.out.print("Escolha a opção desejada: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    sc.nextLine();
                    System.out.print("Quantidade de produtos a registrar: ");
                    int n = sc.nextInt();
                    sc.nextLine();

                    for (int i = 1; i <= n; i++) {
                        System.out.println();
                        System.out.print("Nome do produto #" + i + ": ");
                        String name = sc.nextLine();
                        System.out.print("Categoria do produto: ");
                        String category = sc.nextLine();
                        System.out.print("Preço do produto: ");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        LocalDateTime registerTime = LocalDateTime.now();
                        list.add(new Product(name, category, price, registerTime));
                        System.out.println();
                    }

                    // Exibe os produtos enumerados
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ") " + list.get(i));
                    }
                    System.out.println();

                    System.out.print("Deseja alterar algum produto? (s/n): ");
                    char ch = sc.next().charAt(0);
                    if (ch == 's') {

                        System.out.print("Quantidade de produtos a editar: ");
                        int n2 = sc.nextInt();
                        sc.nextLine();
                        System.out.println();

                        for (int o = 0; o < list.size(); o++) {
                            System.out.println((o + 1) + ") " + list.get(o));
                        }

                        for (int i = 0; i <= n2; i++) {


                            System.out.println();
                            System.out.print("Qual produto deseja editar? ");
                            int productEditIndex = sc.nextInt() - 1;
                            sc.nextLine();
                            aindaVouNomear.editProduct(list, productEditIndex, sc);
                            System.out.println();
                            System.out.println(i + ") " + list.get(i));



                        }

//                        System.out.println();

                    }

                    break;

                case 5:
                    System.out.println("Finalizando...");
                    exit = true;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        sc.close();
    }
}


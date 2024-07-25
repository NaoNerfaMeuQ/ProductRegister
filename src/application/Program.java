package application;

import entities.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        String path = "C:\\Users\\marco\\OneDrive\\Desktop\\Cursos Programming\\Java " +
                "projects\\Registros\\Registros\\src\\storage\\datastorage.json";
        boolean exit = false;
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        List<Product> list = new ArrayList<>();


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

                    for (int i = 1; i <= n; i++) {
                        sc.nextLine();
                        System.out.print("Nome do produto: ");
                        String name = sc.nextLine();
                        System.out.print("Categoria do produto: ");
                        String category = sc.nextLine();
                        System.out.print("Preço do produto: ");
                        double price = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Data de entrada (dd/MM/yyyy HH:mm): ");
                        String registerTimeStr = sc.nextLine();
                        LocalDateTime registerTime = LocalDateTime.parse(registerTimeStr, dtf);
                        list.add(new Product(name, category, price, registerTime));
                    }
                    System.out.println();

                    for (int j = 0; j < list.size(); j++) {
                        System.out.println(list.get(j).toString(j + 1));
                    }
                    System.out.println();
                    System.out.print("Deseja sobrescrever o arquivo existente? (s/n): ");
                    char ch = sc.nextLine().charAt(0);
                    boolean fileOption = ch == 's';

                    try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, !fileOption))) {
                        bw.write("[\n"); // Começar o array JSON
                        for (int i = 0; i < list.size(); i++) {
                            Product product = list.get(i);
                            String json = toJsonString(product);
                            bw.write(json);
                            if (i < list.size() - 1) {
                                bw.write(",\n"); // Adicionar vírgula entre os objetos JSON
                            } else {
                                bw.write("\n"); // Não adicionar vírgula após o último objeto JSON
                            }
                        }
                    } catch (IOException e) {
                        String err = "ERROR: " + e.getMessage();
                    }
                    System.out.println();
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

    private static String toJsonString(Product product) {
        return "{\n" +
                "  \"Nome\": \"" + product.getName() + "\",\n" +
                "  \"Categoria\": \"" + product.getCategory() + "\",\n" +
                "  \"Preço\": " + product.getPrice() + ",\n" +
                "  \"Hora de Registro\": \"" + product.getRegisterTime().toString() + "\"\n" +
                "}";
    }
}

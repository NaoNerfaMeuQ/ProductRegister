package ãpplication;

import entities.Product;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        //TODO CRIAR STRING PATH "\\C:\\CAMINHOARQUIVO"


       /* String path = "C:\\Users\\marco\\out.txt"; //Caminho para criar a pasta

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){ //sem o true, ele recria o arquivo
            for (List line : Product?){ //Para cada String line contido em lines, faça: bw.write(line) e bw.newLine
            (para espaço)
                bw.write(line);
                bw.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        */

        List<Product> list = new ArrayList<>();

        System.out.println("Olá! Seja bem vindo ao registro de produto.");
        System.out.println("1. Criar produto");
        System.out.println("2. Deletar produto");
        System.out.println("3. Mostrar produtos");
        System.out.println("4. Detalhes");
        System.out.print("Qual opção deseja? ");
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
                    sc.next();
                    list.add(new Product(name, category, price, registerTime));
                }
                System.out.println();

                for (int j = 0; j < list.size(); j++) {
                    System.out.println(list.get(j).toString(j + 1));
                }
                break;

            default:
                System.out.println("Opção inválida.");
                break;

        }


        sc.close();

    }
}

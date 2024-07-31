package application;

import model.entities.Product;
import model.entities.ProductManager;

import java.io.*;
import java.lang.invoke.SwitchPoint;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        boolean exit = false;

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        List<Product> list = new ArrayList<>();
        ProductManager productManager = new ProductManager();


        while (!exit) {
            System.out.println("Olá! Seja bem vindo ao registro de produto.");
            System.out.println();
            System.out.println("Quantidade de produtos registrados até o momento: " + list.size());
            System.out.println("1. Criar produto");
            System.out.println("2. Deletar produto");
            System.out.println("3. Mostrar produtos");
            System.out.println("4. Salvar produtos");
            System.out.println("5. Importar produtos");
            System.out.println("6. Sair");
            System.out.print("Escolha a opção desejada: ");
            int option = sc.nextInt();

            switch (option) {
                case 1: //Criar produto
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
                        System.out.print("Quantidade em estoque: ");
                        double quantity = sc.nextDouble();
                        sc.nextLine();
                        LocalDateTime registerTime = LocalDateTime.now();
                        list.add(new Product(name, category, price, quantity, registerTime));
                        System.out.println();
                    }

                    // Exibe os produtos enumerados
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println((i + 1) + ") " + list.get(i));
                    }
                    System.out.println();

                    //Caso user digite 's', ele entra no if
                    System.out.print("Deseja alterar algum produto? (s/n): ");
                    char ch = sc.next().charAt(0);
                    if (ch == 's') {
                        System.out.println();
                        if (list.size() > 0) {
                            System.out.println();
                            System.out.print("Quantidade de produtos a editar: ");
                            int n2 = sc.nextInt();
                            sc.nextLine();
                            System.out.println();
                         /*Pergunta quantos produtos que o user quer editar,
                        então o número que ele digitar vai ser o número de vezes que o loop roda */
                            for (int o = 0; o < list.size(); o++) {
                                System.out.println((o + 1) + ") " + list.get(o));
                            }
                            for (int i = 0; i < n2; i++) {
                                System.out.println();
                                System.out.print("Qual produto deseja editar? ");
                                int productEditIndex = sc.nextInt() - 1;
                                sc.nextLine();
                                productManager.editProduct(list, productEditIndex, sc);
                                System.out.println();
//                          System.out.println(i + ") " + list.get(i + 1));
                                for (int o = 0; o < list.size(); o++) {
                                    System.out.println((o + 1) + ") " + list.get(o));
                                    System.out.println();
                                }
                            }
                        } else {
                            System.out.println("Não há produtos para deletar!");
                            System.out.println("Por favor, adicione pelo menu ou pelo arquivo.");
                        }
                    }
                    break;

                case 2: //Deletar produto
                    System.out.println();
                    for (int p = 0; p < list.size(); p++) {
                        System.out.println((p + 1) + ") " + list.get(p));
                        System.out.println();
                    }

                    System.out.print("Deseja deletar algum produto? (s/n): ");
                    char ch1 = sc.next().charAt(0);
                    System.out.println();
                    if (ch1 == 's') {
                        System.out.print("Quantidade de produtos a deletar: ");
                        int n3 = sc.nextInt();
                        sc.nextLine();

                        if (n3 <= list.size()) {
                            System.out.println();
                            for (int p = 0; p < list.size(); p++) {
                                System.out.println((p + 1) + ") " + list.get(p));
                            }
                            for (int i = 0; i < n3; i++) {
                                System.out.println();
                                System.out.print("Qual produto deseja deletar? ");
                                int productDeleteIndex = sc.nextInt() - 1;
                                sc.nextLine();
                                productManager.deleteProduct(list, productDeleteIndex, sc);
                                System.out.println();
                                for (int o = 0; o < list.size(); o++) {
                                    System.out.println((o + 1) + ") " + list.get(o));
                                }
                            }

                        } else {
                            System.out.println("Quantidade acima do número de produtos!");
                            System.out.println();
                        }
                    }
                    break;


                case 3: //Mostrar os produtos criados
                    if (list.isEmpty()) {
                        System.out.println();
                        System.out.println("Lista vazia, crie produtos para acessar essa opção");
                        System.out.println();
                    } else {
                        System.out.println();
                        for (int q = 0; q < list.size(); q++) {
                            System.out.println((q + 1) + ") " + list.get(q));
                        }
                    }

                    break;

                case 4: //Salvar produtos
                    String path = "C:\\Users\\marco\\OneDrive\\Desktop\\Cursos Programming\\Java " +
                            "projects\\Registros\\Registros\\src\\storage\\datastorage.txt";
                    for (int q = 0; q < list.size(); q++) {
                        System.out.println((q + 1) + ") " + list.get(q));
                    }
                    System.out.println();
                    System.out.print("Deseja salvar os produtos em um arquivo? (s/n): ");
                    char ch3 = sc.next().charAt(0);
                    if (ch3 == 's') {
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
                            bw.write("Nome, Categoria, Preço, Quantidade, Data do Registro\n\n");
                            for (Product product : list) {
                                bw.write(product.toCSV());
                                bw.newLine();
                            }
                            System.out.println();
                            System.out.println("Salvo com sucesso!");
                        } catch (IOException e) {
                            System.out.println("Erro ao exportar para o arquivo csv: " + e.getMessage());
                        }
                        System.out.println();
                    } else {
                        System.out.println("Arquivo não salvo!");
                        System.out.println();
                    }

                    break;


                case 5:
                    String alternativePath = "null";
                    System.out.println("A importação de arquivo só será aceita caso esteja no formato correto!");
                    System.out.print("Ex: Ração,Alimento,249.00,25.0,31/07/2024 18:07\n");
                    System.out.print("Ex: Alpiste,Passáros,15.59,10.0,31/07/2024 19:03\n\n");
                    System.out.print("Deseja exportar o arquivo de um outro caminho? (s/n)? ");
                    char ch4 = sc.next().charAt(0);
                    if (ch4 == 's') {
                        System.out.println("Digite o caminho do arquivo (com o nome do arquivo no fim:");
                        alternativePath = sc.nextLine();
                        sc.nextLine();

                        try (BufferedReader br = new BufferedReader(new FileReader(alternativePath))) {
                            String productCsv = br.readLine();
                            while ((productCsv = br.readLine()) != null) {
                                String[] fields = productCsv.split(",");
                                if (fields.length == 5) {
                                    String name = fields[0];
                                    String category = fields[1];
                                    double price = Double.parseDouble(fields[2]);
                                    double quantity = Double.parseDouble(fields[3]);
                                    LocalDateTime registerTime = LocalDateTime.parse(fields[4], dtf);
                                    list.add(new Product(name, category, price, quantity, registerTime));
                                } else {
                                    System.out.println("Linha inválida encontrada no arquivo CSV: " + productCsv);
                                }

                            }
                            System.out.println("Dados importados do arquivo CSV com sucesso.");
                        } catch (IOException e) {
                            System.out.println("Erro ao importar do arquivo CSV: " + e.getMessage());
                        }


                    } else {
                        path = "C:\\Users\\marco\\OneDrive\\Desktop\\Cursos Programming\\Java " +
                                "projects\\Registros\\Registros\\src\\storage\\datastorage.txt";
                        System.out.println("O arquivo será salvo em: " + path);

                        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                            String productCsv = br.readLine();
                            while ((productCsv = br.readLine()) != null) {
                                String[] fields = productCsv.split(",");
                                if (fields.length == 5) {
                                    String name = fields[0];
                                    String category = fields[1];
                                    double price = Double.parseDouble(fields[2]);
                                    double quantity = Double.parseDouble(fields[3]);
                                    LocalDateTime registerTime = LocalDateTime.parse(fields[4], dtf);
                                    list.add(new Product(name, category, price, quantity, registerTime));
                                } else {
                                    System.out.println("Linha inválida encontrada no arquivo CSV: " + productCsv);
                                }

                            }
                            System.out.println("Dados importados do arquivo CSV com sucesso.");
                        } catch (IOException e) {
                            System.out.println("Erro ao importar do arquivo CSV: " + e.getMessage());
                        }

                    }


                    break;

                case 6:
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


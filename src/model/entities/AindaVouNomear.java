package model.entities;

import java.util.List;
import java.util.Scanner;

public class AindaVouNomear {



    public void editProduct(List<Product> list, int productEditIndex, Scanner sc) {
        if (productEditIndex >= 0 && productEditIndex < list.size()) {
            Product productToEdit = list.get(productEditIndex);

            System.out.print("Novo nome do produto (ou deixe em branco para manter): ");
            String newName = sc.nextLine();
            if (!newName.isEmpty()) {
                productToEdit.setName(newName);
            }
            System.out.println();

            System.out.print("Nova categoria do produto (ou deixe em branco para manter): ");
            String newCategory = sc.nextLine();
            if (!newCategory.isEmpty()) {
                productToEdit.setCategory(newCategory);
            }
            System.out.println();

            System.out.print("Novo preço do produto (ou deixe em branco para manter): ");
            String newPrice = sc.nextLine();
            if (!newPrice.isEmpty()) {
                productToEdit.setPrice(Double.parseDouble(newPrice));
            }
            System.out.println();

            System.out.println("Lista atualizada!");
            System.out.println("Produto atualizado: " + productToEdit);
        } else {
            System.out.println("número de produto inválido");
            System.out.println();
        }
    }

}

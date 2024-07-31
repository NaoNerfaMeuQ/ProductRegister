package model.entities;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Product implements Comparable<Product> {

    private String name;
    private String category;
    private Double price;
    private Double quantity;
    private LocalDateTime registerTime;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Product(String name, String category, Double price, Double quantity, LocalDateTime registerTime) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.registerTime = registerTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public String toString() {
        return STR."Nome: \{name},\n   Categoria: \{category},\n   Preço: R$\{String.format("%.2f", price)},\n   Quantidade em estoque: \{quantity},\n   Data do registro: \{registerTime.format(dtf)}\n";
    }

    public String toCSV() {
        return String.format("%s,%s,%.2f,%.1f,%s", name, category, price, quantity, registerTime.format(dtf));
    }
    @Override
    public int compareTo(Product other) {

        int nameComparison = this.name.compareTo(other.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        int categoryComparison = this.category.compareTo(other.category);
        if (categoryComparison != 0) {
            return categoryComparison;
        }

        int priceComparison = Double.compare(this.price, other.price);
        if (priceComparison != 0) {
            return priceComparison;
        }

        int quantityComparison = Double.compare(this.quantity, other.quantity);
        if (quantityComparison != 0) {
            return quantityComparison;
        }

        return this.registerTime.compareTo(other.registerTime);

    }
}

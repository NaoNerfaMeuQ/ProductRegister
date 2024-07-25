package entities;

import java.time.LocalDateTime;

public class Product {

    private String name;
    private String category;
    private Double price;
    private LocalDateTime registerTime;

    public Product(String name, String category, Double price, LocalDateTime registerTime) {
        this.name = name;
        this.category = category;
        this.price = price;
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

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(LocalDateTime registerTime) {
        this.registerTime = registerTime;
    }

    public String toString(int i) {
        return "PRODUTO REGISTRADO:\n" +
                i + ". " +
                "Nome: " +
                name +
                ", Categoria: " +
                category +
                ", Preço: $ " +
                price +
                ", Data do registro: " +
                registerTime +
                "\n";
    }
}

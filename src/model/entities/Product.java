package model.entities;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Product {

    private String name;
    private String category;
    private Double price;
    private LocalDateTime registerTime;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

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

    @Override
    public String toString() {
        return STR."Nome: \{name}, Categoria: \{category}, Preço: R$\{String.format("%.2f", price)}, Data do registro: \{registerTime.format(dtf)}";
    }
}

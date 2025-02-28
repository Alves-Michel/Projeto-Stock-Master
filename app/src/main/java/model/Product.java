package model;


import java.text.NumberFormat;
import java.util.Locale;

public class Product {
    Locale localeBR = new Locale("pt", "BR");
    NumberFormat currencyFormat;
    public String NameProduct;
    public double Price;
    public int Amount;
    public int Codigo;
    public String Descricao;

    public Product() {
        this.currencyFormat = NumberFormat.getCurrencyInstance(this.localeBR);
    }

    public Product(String nameProduct, double price, int amount, int codigo, String descricao) {
        this.currencyFormat = NumberFormat.getCurrencyInstance(this.localeBR);
        this.NameProduct = nameProduct;
        this.Price = price;
        this.Amount = amount;
        this.Codigo = codigo;
        this.Descricao = descricao;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public String getNameProduct() {
        return this.NameProduct;
    }

    public double getPrice() {
        return this.Price;
    }

    public int getAmount() {
        return this.Amount;
    }

    public int getCodigo() {
        return this.Codigo;
    }

    public void setNameProduct(String nameProduct) {
        this.NameProduct = nameProduct;
    }

    public void setPrice(double price) {
        this.Price = price;
    }

    public void setAmount(int amount) {
        this.Amount = amount;
    }

    public void setCodigo(int codigo) {
        this.Codigo = codigo;
    }

    public double ValorEmEstoque() {
        return this.Price * (double)this.Amount;
    }

    public double CalcularTotalEmEstoque() {
        return this.Price * (double)this.Amount;
    }

    public String toString() {

        return "        Código-" + this.Codigo +
                "- Produto: " + this.NameProduct + ", " +
                this.currencyFormat.format(this.Price) +
                ", Quantidade: " + this.Amount +
                ", Descrição: " + this.Descricao;
    }
}

package minhquan.com.entity.impl.drink;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
public class Drink implements Serializable {
    @Serial
    private static final long serialVersionUID = 2222222L;
    private int id;
    private String name;
    private BigDecimal price;
    private boolean carbonated;

    public Drink() {
    }

    public Drink(String name, BigDecimal price, boolean carbonated) {
        this.name = name;
        this.price = price;
        this.carbonated = carbonated;
    }

    public Drink(int id, String name, BigDecimal price, boolean carbonated) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.carbonated = carbonated;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCarbonated(boolean carbonated) {
        this.carbonated = carbonated;
    }

    @Override
    public String toString() {
        return "Drink{" +
                "id= " + this.id +
                "name='" + name + '\'' +
                ", price=" + price +
                ", carbonated=" + carbonated +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }
}

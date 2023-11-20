package minhquan.com.entity.impl.food;

import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Getter
public class Food implements Serializable {
    @Serial
    private static final long serialVersionUID = 33333333L;

    private int id;
    private String name;
    private BigDecimal price;
    private int calories;

    private EFoodType type;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(EFoodType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", calories=" + calories +
                '}';
    }

    public Food(int id, String name, BigDecimal price, int calories, EFoodType type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.type = type;
    }

    public Food() {}
}

package minhquan.com.entity.impl.foodMenu;

import lombok.*;
import minhquan.com.entity.impl.food.Food;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class FoodMenu implements Serializable {
    @Serial
    private static final long serialVersionUID = 555555L;
    private int id;
    private List<Food> foodList;

    private EFoodMenuType menuType;

    public FoodMenu(List<Food> foodList) {
        this.foodList = foodList;
    }

    public FoodMenu(EFoodMenuType menuType) {
        foodList = new ArrayList<>();
        this.menuType = menuType;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal("0");
        for (Food food : this.getFoodList()) {
            totalPrice = totalPrice.add(food.getPrice());
        }
        return totalPrice;
    }
}

package minhquan.com.entity.impl.drinkMenu;

import lombok.Getter;
import lombok.Setter;
import minhquan.com.entity.impl.drink.Drink;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class DrinkMenu implements Serializable {

    @Serial
    private static final long serialVersionUID = 4444444444L;

    private int id;

    private List<Drink> drinkList;
    private EDrinkMenuType menuType;


    public DrinkMenu(EDrinkMenuType menuType) {
        this.drinkList = new ArrayList<>();
        this.menuType = menuType;
    }

    public void setDrinkList(List<Drink> drinkList) {
        this.drinkList = drinkList;
    }

    @Override
    public String toString() {
        return "DrinkMenu{" +
                "id=" + id +
                ", drinkList=" + drinkList +
                '}';
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal("0");
        for (Drink drink : this.drinkList) {
            totalPrice = totalPrice.add(drink.getPrice());
        }
        return totalPrice;
    }
}

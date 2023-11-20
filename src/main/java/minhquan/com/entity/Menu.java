package minhquan.com.entity;

import minhquan.com.entity.impl.drinkMenu.DrinkMenu;
import minhquan.com.entity.impl.foodMenu.FoodMenu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    private int id;
    private List<FoodMenu> foodMenus;
    private List<DrinkMenu> drinkMenus;

    private Menu() {
        foodMenus = new ArrayList<>();
        drinkMenus = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<FoodMenu> getFoodMenus() {
        return foodMenus;
    }

    public void setFoodMenus(List<FoodMenu> foodMenus) {
        this.foodMenus = foodMenus;
    }

    public List<DrinkMenu> getDrinkMenus() {
        return drinkMenus;
    }

    public void setDrinkMenus(List<DrinkMenu> drinkMenus) {
        this.drinkMenus = drinkMenus;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", foodMenus=" + foodMenus +
                ", drinkMenus=" + drinkMenus +
                '}';
    }

    public static Menu getInstance() {
        return new Menu();
    }

//    public BigDecimal getTotalPrice() {
//        foreach
//    }

//    public BigDecimal getFoodMenuPrice
}

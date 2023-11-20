package minhquan.com.repository;

import minhquan.com.entity.impl.drink.Drink;
import minhquan.com.entity.impl.drinkMenu.DrinkMenu;
import minhquan.com.entity.impl.food.Food;
import minhquan.com.entity.impl.foodMenu.FoodMenu;

import java.util.List;

public interface IDrinkMenuRepository {
    void saveItem(DrinkMenu menu);
    void addItem(int id, Drink drink);

    DrinkMenu getById(int id);

    List<DrinkMenu> getMenus();

    void updateItemMenuList(int id, int drinkId, Drink drink);
    void deleteItemMenuList(int id, int drinkId);

    void deleteMenu(int id);
}

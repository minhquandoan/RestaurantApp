package minhquan.com.repository;

import minhquan.com.entity.Menu;
import minhquan.com.entity.impl.drinkMenu.DrinkMenu;
import minhquan.com.entity.impl.foodMenu.FoodMenu;

import java.util.List;

public interface IMenuRepository {
    void saveItem(Menu menu);
    void deleteItem(int id);
    List<Menu> getAllMenus();

    Menu getById(int id);

    void addFoodMenu(int id, FoodMenu menu);
    void addDrinkMenu(int id, DrinkMenu menu);

    void updateFoodMenuItem(int id, int foodMenuId, FoodMenu foodMenu);
    void updateDrinkMenuItem(int id, int drinkMenuId, DrinkMenu drinkMenu);
}

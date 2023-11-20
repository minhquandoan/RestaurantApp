package minhquan.com.service;

import minhquan.com.entity.Menu;
import minhquan.com.entity.impl.drinkMenu.DrinkMenu;
import minhquan.com.entity.impl.foodMenu.FoodMenu;

import java.util.List;

public interface IMenuService {
    void saveItem(Menu menu);
    void deleteItem(int id);
    List<Menu> getAllMenus();

    Menu getById(int id);

    void updateFoodMenuItem(int id, int foodMenuId, int newFoodMenuId);
    void updateDrinkMenuItem(int id, int drinkMenuId, int newDrinkMenuId);

    void addFoodMenu(int id, int foodMenu);
    void addDrinkMenu(int id, int drinkMenu);
}

package minhquan.com.service;

import minhquan.com.entity.impl.food.Food;
import minhquan.com.entity.impl.foodMenu.FoodMenu;

import java.util.List;

public interface IFoodMenuService {
    void createNewMenu(FoodMenu menu);

    void addItem(int id, int foodId);

    FoodMenu getById(int id);

    List<FoodMenu> getAllMenus();

    void updateItemMenuList(int id, int foodId, int newFoodId);
    void deleteItemMenuList(int id, int foodId);

    void deleteMenu(int id);
}

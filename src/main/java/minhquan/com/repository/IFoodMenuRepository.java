package minhquan.com.repository;

import minhquan.com.entity.impl.food.Food;
import minhquan.com.entity.impl.foodMenu.FoodMenu;

import java.util.List;

public interface IFoodMenuRepository {
    void saveItem(FoodMenu menu);
    void addItem(int id, Food food);

    FoodMenu getById(int id);

    List<FoodMenu> getMenus();

    void updateItemMenuList(int id, int foodId, Food food);
    void deleteItemMenuList(int id, int foodId);

    void deleteMenu(int id);
}

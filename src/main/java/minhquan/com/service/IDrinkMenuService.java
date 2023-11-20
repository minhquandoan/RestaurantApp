package minhquan.com.service;

import minhquan.com.entity.impl.drinkMenu.DrinkMenu;

import java.util.List;

public interface IDrinkMenuService {

    void createNewMenu(DrinkMenu menu);

    void addItem(int id, int drinkId);

    DrinkMenu getById(int id);

    List<DrinkMenu> getAllMenus();

    void updateItemMenuList(int id, int drinkId, int newDrinkId);
    void deleteItemMenuList(int id, int drinkId);

    void deleteMenu(int id);
}

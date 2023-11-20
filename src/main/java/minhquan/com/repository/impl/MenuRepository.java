package minhquan.com.repository.impl;

import minhquan.com.db.MenuDB;
import minhquan.com.entity.Menu;
import minhquan.com.entity.impl.drinkMenu.DrinkMenu;
import minhquan.com.entity.impl.foodMenu.FoodMenu;
import minhquan.com.repository.IMenuRepository;

import java.util.List;

public class MenuRepository implements IMenuRepository {
    private static MenuDB menuDB;

    public MenuRepository() {
        menuDB = MenuDB.getInstance();
    }

    @Override
    public void saveItem(Menu menu) {
        menu.setId(menuDB.getSize() + 1);
        menuDB.getStorage().add(menu);
    }

    @Override
    public void deleteItem(int id) {
        for (Menu menu : menuDB.getStorage()) {
            if (menu.getId() == id) {
                menuDB.getStorage().remove(menu);
                return;
            }
        }
    }

    @Override
    public List<Menu> getAllMenus() {
        return menuDB.getStorage();
    }

    @Override
    public Menu getById(int id) {
        for (Menu menu : menuDB.getStorage()) {
            if (menu.getId() == id) {
                return menu;
            }
        }
        return null;
    }

    @Override
    public void addFoodMenu(int id, FoodMenu menu) {
        for (Menu m : menuDB.getStorage()) {
            if (m.getId() == id) {
                m.getFoodMenus().add(menu);
            }
        }
    }

    @Override
    public void addDrinkMenu(int id, DrinkMenu menu) {
        for (Menu m : menuDB.getStorage()) {
            if (m.getId() == id) {
                m.getDrinkMenus().add(menu);
            }
        }
    }

    @Override
    public void updateFoodMenuItem(int id, int foodMenuId, FoodMenu foodMenu) {
        for (Menu m : menuDB.getStorage()) {
            if (m.getId() == id) {
                for (int i = 0; i < m.getFoodMenus().size(); i++) {
                    if (m.getFoodMenus().get(i).getId() == foodMenuId) {
                        m.getFoodMenus().set(i, foodMenu);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void updateDrinkMenuItem(int id, int drinkMenuId, DrinkMenu drinkMenu) {
        for (Menu m : menuDB.getStorage()) {
            if (m.getId() == id) {
                for (int i = 0; i < m.getDrinkMenus().size(); i++) {
                    if (m.getDrinkMenus().get(i).getId() == drinkMenuId) {
                        m.getDrinkMenus().set(i, drinkMenu);
                        return;
                    }
                }
            }
        }
    }
}

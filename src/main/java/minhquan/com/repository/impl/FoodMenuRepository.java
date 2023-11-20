package minhquan.com.repository.impl;

import minhquan.com.db.FoodMenuDB;
import minhquan.com.entity.impl.drinkMenu.DrinkMenu;
import minhquan.com.entity.impl.food.Food;
import minhquan.com.entity.impl.foodMenu.FoodMenu;
import minhquan.com.repository.IFoodMenuRepository;

import java.util.List;

public class FoodMenuRepository implements IFoodMenuRepository {

    private FoodMenuDB db;

    public FoodMenuRepository(FoodMenuDB db) {
        this.db = db;
    }

    @Override
    public void saveItem(FoodMenu menu) {
        menu.setId(this.db.getSize() + 1);
        this.db.getStorage().add(menu);
    }

    @Override
    public void addItem(int id, Food food) {
        for (FoodMenu menu : this.db.getStorage()) {
            if (menu.getId() == id) {
                menu.getFoodList().add(food);
            }
        }
    }

    @Override
    public FoodMenu getById(int id) {
        for (FoodMenu menu : this.db.getStorage()) {
            if (menu.getId() == id) {
                return menu;
            }
        }
        return null;
    }

    @Override
    public List<FoodMenu> getMenus() {
        return this.db.getStorage();
    }

    @Override
    public void updateItemMenuList(int id, int foodId, Food food) {
        for (FoodMenu menu : this.db.getStorage()) {
            if (id == menu.getId()) {
                for (int i = 0; i < menu.getFoodList().size(); i++) {
                    if (foodId == menu.getFoodList().get(i).getId()) {
                         menu.getFoodList().set(i, food);
                         return;
                    }
                }
            }
        }
    }

    @Override
    public void deleteItemMenuList(int id, int foodId) {
        for (FoodMenu menu : this.db.getStorage()) {
            if (id == menu.getId()) {
                for (Food f : menu.getFoodList()) {
                    if (foodId == f.getId()) {
                        menu.getFoodList().remove(f);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void deleteMenu(int id) {
        for (FoodMenu menu : this.db.getStorage()) {
            if (id == menu.getId()) {
                this.db.getStorage().remove(menu);
                return;
            }
        }
    }
}

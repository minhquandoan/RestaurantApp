package minhquan.com.repository.impl;

import minhquan.com.db.DrinkMenuDB;
import minhquan.com.entity.impl.drink.Drink;
import minhquan.com.entity.impl.drinkMenu.DrinkMenu;
import minhquan.com.repository.IDrinkMenuRepository;

import java.util.List;

public class DrinkMenuRepository implements IDrinkMenuRepository {
    private DrinkMenuDB db;

    public DrinkMenuRepository(DrinkMenuDB db) {
        this.db = db;
    }

    @Override
    public void saveItem(DrinkMenu menu) {
        menu.setId(this.db.getSize() + 1);
        this.db.getStorage().add(menu);
    }

    @Override
    public void addItem(int id, Drink drink) {
        for (DrinkMenu menu : this.db.getStorage()) {
            if (menu.getId() == id) {
                menu.getDrinkList().add(drink);
            }
        }
    }

    @Override
    public DrinkMenu getById(int id) {
        for (DrinkMenu menu : this.db.getStorage()) {
            if (menu.getId() == id) {
                return menu;
            }
        }
        return null;
    }

    @Override
    public List<DrinkMenu> getMenus() {
        return this.db.getStorage();
    }

    @Override
    public void updateItemMenuList(int id, int drinkId, Drink drink) {
        for (DrinkMenu menu : this.db.getStorage()) {
            if (id == menu.getId()) {
                for (int i = 0; i < menu.getDrinkList().size(); i++) {
                    if (drinkId == menu.getDrinkList().get(i).getId()) {
                        menu.getDrinkList().set(i, drink);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void deleteItemMenuList(int id, int drinkId) {
        for (DrinkMenu menu : this.db.getStorage()) {
            if (id == menu.getId()) {
                for (Drink d : menu.getDrinkList()) {
                    if (drinkId == d.getId()) {
                        menu.getDrinkList().remove(d);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void deleteMenu(int id) {
        for (DrinkMenu menu : this.db.getStorage()) {
            if (id == menu.getId()) {
                this.db.getStorage().remove(menu);
                return;
            }
        }
    }
}

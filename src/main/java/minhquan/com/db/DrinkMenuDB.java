package minhquan.com.db;

import minhquan.com.entity.impl.drink.Drink;
import minhquan.com.entity.impl.drinkMenu.DrinkMenu;

import java.util.ArrayList;
import java.util.List;

public final class DrinkMenuDB {
    private List<DrinkMenu> storage;

    private static DrinkMenuDB instance;

    private DrinkMenuDB() {
        storage = new ArrayList<>();
    }

    public static DrinkMenuDB getInstance() {
        if (instance == null) {
            instance = new DrinkMenuDB();
        }
        return instance;
    }

    public int getSize() {
        return this.storage.size();
    }

    public List<DrinkMenu> getStorage() {
        return this.storage;
    }

    public String toDataString() {
        StringBuilder builder = new StringBuilder();
        for (DrinkMenu menu : this.storage) {
            builder.append(menu.getId()).append(",");
            builder.append(menu.getMenuType()).append(",");
            for (Drink drink : menu.getDrinkList()) {
                builder.append(drink.getName()).append(",");
            }
            builder.deleteCharAt(builder.length()-1).append("\n");
        }
        return builder.toString();
    }
}

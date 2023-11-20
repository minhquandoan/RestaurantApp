package minhquan.com.db;

import minhquan.com.entity.impl.food.Food;
import minhquan.com.entity.impl.foodMenu.FoodMenu;

import java.util.ArrayList;
import java.util.List;

public class FoodMenuDB {
    private List<FoodMenu> storage;

    private static FoodMenuDB instance;

    private FoodMenuDB() {
        storage = new ArrayList<>();
    }

    public static FoodMenuDB getInstance() {
        if (instance == null) {
            instance = new FoodMenuDB();
        }
        return instance;
    }

    public int getSize() {
        return this.storage.size();
    }

    public List<FoodMenu> getStorage() {
        return this.storage;
    }

    public String toDataString() {
        StringBuilder builder = new StringBuilder();
        for (FoodMenu menu : this.storage) {
            builder.append(menu.getId()).append(",");
            builder.append(menu.getMenuType()).append(",");
            for (Food food : menu.getFoodList()) {
                builder.append(food.getName()).append(",");
            }
            builder.deleteCharAt(builder.length()-1).append("\n");
        }
        return builder.toString();
    }
}

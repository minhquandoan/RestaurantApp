package minhquan.com.db;

import minhquan.com.entity.impl.food.EFoodType;
import minhquan.com.entity.impl.food.Food;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class FoodDB {
    private final List<Food> storage;

    private static FoodDB instance;

    public List<Food> getFoodStorage() {
        return this.storage;
    }


    private FoodDB() {
        this.storage = new ArrayList<>(Arrays.asList(
                new Food(1, "Pho", new BigDecimal("50000"), 61, EFoodType.BREAKFAST),
                new Food(2, "Bun Bo", new BigDecimal("55000"), 61, EFoodType.BREAKFAST),
                new Food(3, "Bun Rieu", new BigDecimal("56000"), 61, EFoodType.BREAKFAST)
        ));
    }

    public static FoodDB getFoodDBInstance() {
        if (instance == null) {
            instance = new FoodDB();
        }
        return instance;
    }

    public int getSize() {
        return this.storage.size();
    }
}

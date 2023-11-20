package minhquan.com.db;

import minhquan.com.entity.impl.drink.Drink;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class DrinkDB {
    private List<Drink> storage;
    private static DrinkDB instance;

    public List<Drink> getDrinkStorage() {
        return this.storage;
    }


    private DrinkDB() {
        this.storage = new ArrayList<>(Arrays.asList(
                new Drink(1, "Coca", new BigDecimal(15000), true),
                new Drink(2, "Pepsi", new BigDecimal(10000), true)
        ));
    }

    public static DrinkDB getDrinkDBInstance() {
        if (instance == null) {
            instance = new DrinkDB();
        }
        return instance;
    }

    public int getSize() {
        return this.storage.size();
    }
}

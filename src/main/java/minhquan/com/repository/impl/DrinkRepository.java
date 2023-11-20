package minhquan.com.repository.impl;

import minhquan.com.db.DrinkDB;
import minhquan.com.entity.impl.drink.Drink;
import minhquan.com.repository.IDrinkRepository;

import java.util.List;

public class DrinkRepository implements IDrinkRepository {
    private final DrinkDB drinkDB;

    public DrinkRepository(DrinkDB drinkDb) {
        this.drinkDB = drinkDb;
    }
    @Override
    public void save(Drink drink) {
        try {
            drink.setId(this.drinkDB.getSize() + 1);
            this.drinkDB.getDrinkStorage().add(drink);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        for (Drink drink : this.drinkDB.getDrinkStorage()) {
            if (drink.getId() == id) {
                this.drinkDB.getDrinkStorage().remove(drink);
            }
        }
    }

    @Override
    public Drink getById(int id) {
        for (Drink drink : this.drinkDB.getDrinkStorage()) {
            if (drink.getId() == id) {
                return drink;
            }
        }
        return null;
    }

    @Override
    public List<Drink> getDrinks() {
        return this.drinkDB.getDrinkStorage();
    }
}

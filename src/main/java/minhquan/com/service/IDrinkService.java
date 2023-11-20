package minhquan.com.service;

import minhquan.com.entity.impl.drink.Drink;

import java.util.List;

public interface IDrinkService {
    boolean createDrink(Drink drink);
    Drink getDrinkById(int id);

    List<Drink> getAllDrinks();
}

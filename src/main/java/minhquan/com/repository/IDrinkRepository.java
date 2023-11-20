package minhquan.com.repository;

import minhquan.com.entity.impl.drink.Drink;

import java.util.List;

public interface IDrinkRepository {
    void save(Drink drink);
    void delete(int id);
    Drink getById(int id);
    List<Drink> getDrinks();
}

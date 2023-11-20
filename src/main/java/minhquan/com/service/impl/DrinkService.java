package minhquan.com.service.impl;

import minhquan.com.entity.impl.drink.Drink;
import minhquan.com.repository.IDrinkRepository;
import minhquan.com.service.IDrinkService;

import java.util.List;

public class DrinkService implements IDrinkService {
    private final IDrinkRepository repository;

    public DrinkService(IDrinkRepository repository) {
        this.repository = repository;
    }


    @Override
    public boolean createDrink(Drink drink) {
        this.repository.save(drink);
        return true;
    }

    @Override
    public Drink getDrinkById(int id) {
        return this.repository.getById(id);
    }

    @Override
    public List<Drink> getAllDrinks() {
        return this.repository.getDrinks();
    }
}

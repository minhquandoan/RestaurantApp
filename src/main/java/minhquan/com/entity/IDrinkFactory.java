package minhquan.com.entity;

import minhquan.com.entity.impl.drink.Drink;

public interface IDrinkFactory {
    Drink makeDrink(String drinkType);
}

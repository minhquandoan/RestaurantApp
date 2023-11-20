package minhquan.com.entity;

import minhquan.com.entity.impl.drink.AlcoholDrink;
import minhquan.com.entity.impl.drink.Drink;
import minhquan.com.entity.impl.drink.SoftDrink;

public class DrinkFactory implements IDrinkFactory{
    private static DrinkFactory instance;

    private DrinkFactory(){}
    @Override
    public Drink makeDrink(String drinkType) {
        if (drinkType.equalsIgnoreCase("soft")) {
            return new SoftDrink();
        } else if (drinkType.equalsIgnoreCase("alcohol")) {
            return new AlcoholDrink();
        }
        return null;
    }

    public static DrinkFactory getInstance() {
        if (instance == null) {
            instance = new DrinkFactory();
        }
        return instance;
    }
}

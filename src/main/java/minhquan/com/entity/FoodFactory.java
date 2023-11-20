package minhquan.com.entity;

import minhquan.com.entity.impl.food.BreakfastFood;
import minhquan.com.entity.impl.food.DinnerFood;
import minhquan.com.entity.impl.food.Food;
import minhquan.com.entity.impl.food.LunchFood;

public class FoodFactory implements IFoodFactory {
    private static FoodFactory instance;

    private FoodFactory() {}

    @Override
    public Food makeFood(String foodType) {
        if (foodType.equalsIgnoreCase("breakfast")) {
            return new BreakfastFood();
        } else if (foodType.equalsIgnoreCase("lunch")) {
            return new LunchFood();
        } else if (foodType.equalsIgnoreCase("dinner")) {
            return new DinnerFood();
        }
        return null;
    }

    public static FoodFactory getInstance() {
        if (instance == null) {
            instance = new FoodFactory();
        }
        return instance;
    }

}

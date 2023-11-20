package minhquan.com.entity;

import minhquan.com.entity.impl.food.Food;

public interface IFoodFactory {
    Food makeFood(String foodType);
}

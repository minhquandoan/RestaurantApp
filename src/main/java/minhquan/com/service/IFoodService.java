package minhquan.com.service;

import minhquan.com.entity.impl.food.Food;

import java.util.List;

public interface IFoodService {
    boolean createFood(Food food);
    Food getFoodById(int id);

    List<Food> getAllFoods();
}

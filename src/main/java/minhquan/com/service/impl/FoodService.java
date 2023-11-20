package minhquan.com.service.impl;

import minhquan.com.entity.impl.food.Food;
import minhquan.com.repository.IFoodRepository;
import minhquan.com.service.IFoodService;

import java.util.List;

public class FoodService implements IFoodService {
    private final IFoodRepository repository;

    public FoodService(IFoodRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean createFood(Food food) {
        this.repository.save(food);
        return true;
    }

    @Override
    public Food getFoodById(int id) {
        return this.repository.getById(id);
    }

    @Override
    public List<Food> getAllFoods() {
        return this.repository.getList();
    }
}

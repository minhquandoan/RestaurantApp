package minhquan.com.repository;

import minhquan.com.entity.impl.food.Food;

import java.util.List;

public interface IFoodRepository {
    void save(Food food);
    void delete(int id);
    Food getById(int id);
    List<Food> getList();

}

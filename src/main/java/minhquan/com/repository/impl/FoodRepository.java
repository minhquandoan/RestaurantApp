package minhquan.com.repository.impl;

import minhquan.com.db.FoodDB;
import minhquan.com.entity.impl.food.Food;
import minhquan.com.exception.ErrorType;
import minhquan.com.exception.impl.BadRequestException;
import minhquan.com.repository.IFoodRepository;

import java.util.List;

public final class FoodRepository implements IFoodRepository {
    private final FoodDB foodDB;

    public FoodRepository(FoodDB foodDB) {
        this.foodDB = foodDB;
    }

    @Override
    public void save(Food food) {
        try {
            food.setId(this.foodDB.getSize() + 1);
            this.foodDB.getFoodStorage().add(food);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        for (Food food : this.foodDB.getFoodStorage()) {
            if (food.getId() == id) {
                this.foodDB.getFoodStorage().remove(food);
            }
        }
    }

    @Override
    public Food getById(int id) {
        for (Food food : this.foodDB.getFoodStorage()) {
            if (food.getId() == id) {
                return food;
            }
        }
        throw new BadRequestException(ErrorType.BAD_REQUEST_EXCEPTION.getErrorCode(), String.format("Can not found Food with id: %d", id));
    }

    @Override
    public List<Food> getList() {
        return this.foodDB.getFoodStorage();
    }

}

package minhquan.com.service.impl;

import minhquan.com.entity.impl.food.Food;
import minhquan.com.entity.impl.foodMenu.FoodMenu;
import minhquan.com.repository.IFoodMenuRepository;
import minhquan.com.service.IFoodMenuService;
import minhquan.com.service.IFoodService;

import java.util.List;

public class FoodMenuService implements IFoodMenuService {
    private IFoodMenuRepository repository;

    private IFoodService foodService;

    public FoodMenuService(IFoodMenuRepository repo, IFoodService foodService) {
        this.repository = repo;
        this.foodService = foodService;
    }
    @Override
    public void createNewMenu(FoodMenu menu) {
        this.repository.saveItem(menu);
    }

    @Override
    public void addItem(int id, int foodId) {
        Food food = foodService.getFoodById(foodId);
        this.repository.addItem(id, food);
    }

    @Override
    public FoodMenu getById(int id) {
        return this.repository.getById(id);
    }

    @Override
    public List<FoodMenu> getAllMenus() {
        return this.repository.getMenus();
    }

    @Override
    public void updateItemMenuList(int id, int foodId, int newFoodId) {
        Food food = this.foodService.getFoodById(newFoodId);
        this.repository.updateItemMenuList(id, foodId, food);
    }

    @Override
    public void deleteItemMenuList(int id, int foodId) {
        this.repository.deleteItemMenuList(id, foodId);
    }

    @Override
    public void deleteMenu(int id) {
        this.repository.deleteMenu(id);
    }
}

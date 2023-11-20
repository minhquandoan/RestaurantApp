package minhquan.com.service.impl;

import minhquan.com.entity.Menu;
import minhquan.com.entity.impl.drinkMenu.DrinkMenu;
import minhquan.com.entity.impl.foodMenu.FoodMenu;
import minhquan.com.repository.IMenuRepository;
import minhquan.com.service.IDrinkMenuService;
import minhquan.com.service.IFoodMenuService;
import minhquan.com.service.IMenuService;

import java.util.List;

public class MenuService implements IMenuService {
    private IMenuRepository menuRepository;

    private IFoodMenuService foodMenuService;
    private IDrinkMenuService drinkMenuService;

    public MenuService(IMenuRepository repository) {
        this.menuRepository = repository;
    }

    public MenuService(IMenuRepository menuRepository, IFoodMenuService foodMenuService, IDrinkMenuService drinkMenuService) {
        this.menuRepository = menuRepository;
        this.foodMenuService = foodMenuService;
        this.drinkMenuService = drinkMenuService;
    }

    @Override
    public void saveItem(Menu menu) {
        this.menuRepository.saveItem(menu);
    }

    @Override
    public void deleteItem(int id) {
        this.menuRepository.deleteItem(id);
    }

    @Override
    public List<Menu> getAllMenus() {
        return this.menuRepository.getAllMenus();
    }

    @Override
    public Menu getById(int id) {
        return this.menuRepository.getById(id);
    }

    @Override
    public void updateFoodMenuItem(int id, int foodMenuId, int newFoodMenuId) {

    }

    @Override
    public void updateDrinkMenuItem(int id, int drinkMenuId, int newDrinkMenuId) {

    }

    @Override
    public void addFoodMenu(int id, int foodMenu) {
        FoodMenu menu = this.foodMenuService.getById(foodMenu);
        this.menuRepository.addFoodMenu(id, menu);
    }

    @Override
    public void addDrinkMenu(int id, int drinkMenu) {
        DrinkMenu menu = this.drinkMenuService.getById(drinkMenu);
        this.menuRepository.addDrinkMenu(id, menu);
    }
}

package minhquan.com.service.impl;

import minhquan.com.entity.impl.drink.Drink;
import minhquan.com.entity.impl.drinkMenu.DrinkMenu;
import minhquan.com.repository.IDrinkMenuRepository;
import minhquan.com.service.IDrinkMenuService;
import minhquan.com.service.IDrinkService;

import java.util.List;

public class DrinkMenuService implements IDrinkMenuService {
    private IDrinkMenuRepository repository;
    private IDrinkService drinkService;

    public DrinkMenuService(IDrinkMenuRepository repository, IDrinkService drinkService) {
        this.repository = repository;
        this.drinkService = drinkService;
    }

    @Override
    public void createNewMenu(DrinkMenu menu) {
        this.repository.saveItem(menu);
    }

    @Override
    public void addItem(int id, int drinkId) {
        Drink drink = drinkService.getDrinkById(drinkId);
        this.repository.addItem(id, drink);
    }

    @Override
    public DrinkMenu getById(int id) {
        return this.repository.getById(id);
    }

    @Override
    public List<DrinkMenu> getAllMenus() {
        return this.repository.getMenus();
    }

    @Override
    public void updateItemMenuList(int id, int drinkId, int newDrinkId) {
        Drink drink = this.drinkService.getDrinkById(newDrinkId);
        this.repository.updateItemMenuList(id, drinkId, drink);
    }

    @Override
    public void deleteItemMenuList(int id, int drinkId) {
        this.repository.deleteItemMenuList(id, drinkId);
    }

    @Override
    public void deleteMenu(int id) {
        this.repository.deleteMenu(id);
    }
}

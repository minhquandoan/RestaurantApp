package minhquan.com.container;

import minhquan.com.entity.impl.foodMenu.FoodMenu;
import minhquan.com.repository.*;
import minhquan.com.service.*;
import minhquan.com.service.impl.*;

public class IOCService {
    private static FoodService foodService;
    private static DrinkService drinkService;

    private static DrinkMenuService drinkMenuService;
    private static FoodMenuService foodMenuService;

    private static MenuService menuService;

    private static BillService billService;

    public static IFoodService getInstanceFoodService(IFoodRepository repo) {
        if (foodService == null) {
            foodService = new FoodService(repo);
        }
        return foodService;
    }

    public static IDrinkService getInstanceDrinkService(IDrinkRepository repo) {
        if (drinkService == null) {
            drinkService = new DrinkService(repo);
        }
        return drinkService;
    }

    public static IDrinkMenuService getInstanceDrinkMenuService(IDrinkMenuRepository repo) {
        if (drinkMenuService == null) {
            drinkMenuService = new DrinkMenuService(repo,
                    getInstanceDrinkService(IOCRepository.getInstanceDrinkRepository()));
        }
        return drinkMenuService;
    }

    public static IFoodMenuService getInstanceFoodMenuService(IFoodMenuRepository repo) {
        if (foodMenuService == null) {
            foodMenuService = new FoodMenuService(repo,
                    getInstanceFoodService(IOCRepository.getInstanceFoodRepository()));
        }
        return foodMenuService;
    }

    public static IMenuService getInstanceMenuService(IMenuRepository repo) {
        if (menuService == null) {
            menuService = new MenuService(IOCRepository.getInstanceMenuRepository(),
                    IOCService.getInstanceFoodMenuService(IOCRepository.getInstanceFoodMenuRepository()),
                    IOCService.getInstanceDrinkMenuService(IOCRepository.getInstanceDrinkMenuRepository()));
        }
        return menuService;
    }

    public static IBillService getInstanceBillService(IBillRepository repo) {
        if (billService == null) {
            billService = new BillService(IOCRepository.getInstanceBillRepository());
        }
        return billService;
    }
}

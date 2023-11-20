package minhquan.com.container;

import minhquan.com.db.*;
import minhquan.com.repository.*;
import minhquan.com.repository.impl.*;

public class IOCRepository {
    private static FoodRepository foodRepository;
    private static DrinkRepository drinkRepository;

    private static FoodMenuRepository foodMenuRepository;
    private static DrinkMenuRepository drinkMenuRepository;

    private static MenuRepository menuRepository;
    private static BillRepository billRepository;

    public static IFoodRepository getInstanceFoodRepository() {
        if (foodRepository == null) {
            foodRepository = new FoodRepository(FoodDB.getFoodDBInstance());
        }
        return foodRepository;
    }

    public static IDrinkRepository getInstanceDrinkRepository() {
        if (drinkRepository == null) {
            drinkRepository = new DrinkRepository(DrinkDB.getDrinkDBInstance());
        }
        return drinkRepository;
    }

    public static IFoodMenuRepository getInstanceFoodMenuRepository() {
        if (foodMenuRepository == null) {
            foodMenuRepository = new FoodMenuRepository(FoodMenuDB.getInstance());
        }
        return foodMenuRepository;
    }

    public static IDrinkMenuRepository getInstanceDrinkMenuRepository() {
        if (drinkMenuRepository == null) {
            drinkMenuRepository = new DrinkMenuRepository(DrinkMenuDB.getInstance());
        }
        return drinkMenuRepository;
    }

    public static IMenuRepository getInstanceMenuRepository() {
        if (menuRepository == null) {
            menuRepository = new MenuRepository();
        }
        return menuRepository;
    }

    public static IBillRepository getInstanceBillRepository() {
        if (billRepository == null) {
            billRepository = new BillRepository(BillDB.getInstance());
        }
        return billRepository;
    }
}

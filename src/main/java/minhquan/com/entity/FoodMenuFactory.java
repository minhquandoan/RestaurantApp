package minhquan.com.entity;

import minhquan.com.entity.impl.foodMenu.*;

public class FoodMenuFactory {
    private static FoodMenuFactory instance;

    private FoodMenuFactory() {}

    public FoodMenuFactory getInstance() {
        if (instance == null) {
            instance = new FoodMenuFactory();
        }
        return instance;
    }

    public static FoodMenu getMenu(EFoodMenuType menuType) {
        if (menuType == null) {
            throw new NullPointerException("Please input a menu type!!");
        }
        switch (menuType) {
            case BREAKFAST_MENU -> {return new BreakfastMenu(menuType);}
            case LUNCH_MENU -> {return new LunchMenu(menuType);}
            case DINNER_MENU -> {return new DinnerMenu(menuType);}
        }
        throw new NullPointerException("Can not create any menu");
    }
}

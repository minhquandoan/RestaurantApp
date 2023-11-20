package minhquan.com.entity;

import minhquan.com.entity.impl.drinkMenu.AlcoholMenu;
import minhquan.com.entity.impl.drinkMenu.DrinkMenu;
import minhquan.com.entity.impl.drinkMenu.EDrinkMenuType;
import minhquan.com.entity.impl.drinkMenu.SoftDrinkMenu;
import minhquan.com.entity.impl.foodMenu.BreakfastMenu;
import minhquan.com.entity.impl.foodMenu.DinnerMenu;
import minhquan.com.entity.impl.foodMenu.LunchMenu;

public class DrinkMenuFactory {
    private static DrinkMenuFactory instance;

    private DrinkMenuFactory() {}

    public DrinkMenuFactory getInstance() {
        if (instance == null) {
            instance = new DrinkMenuFactory();
        }
        return instance;
    }

    public static DrinkMenu getMenu(EDrinkMenuType menuType) {
        if (menuType == null) {
            throw new NullPointerException("Please input a menu type!!");
        }
        switch (menuType) {
            case SOFTDRINK_MENU -> {return new SoftDrinkMenu(menuType);}
            case ALCOHOL_MENU -> {return new AlcoholMenu(menuType);}
        }
        throw new NullPointerException("Can not create any menu");
    }
}

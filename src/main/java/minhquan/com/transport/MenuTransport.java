package minhquan.com.transport;

import minhquan.com.container.IOCRepository;
import minhquan.com.container.IOCService;
import minhquan.com.entity.Menu;
import minhquan.com.entity.impl.bill.Bill;
import minhquan.com.entity.impl.foodMenu.BreakfastMenu;
import minhquan.com.entity.impl.foodMenu.DinnerMenu;
import minhquan.com.entity.impl.foodMenu.FoodMenu;
import minhquan.com.entity.impl.foodMenu.LunchMenu;
import minhquan.com.service.IBillService;
import minhquan.com.service.IMenuService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class MenuTransport {
    private IMenuService service;

    private Scanner sc;

    private IBillService billService;

    public MenuTransport() {
        this.service = IOCService.getInstanceMenuService(IOCRepository.getInstanceMenuRepository());
        this.billService = IOCService.getInstanceBillService(IOCRepository.getInstanceBillRepository());
        this.sc = new Scanner(System.in);
    }

    public void createMenu() {
        System.out.println("====== 1. Create Menu ======");

        Menu menu = Menu.getInstance();
        this.service.saveItem(menu);
        System.out.println("Added!!");
    }

    public void getAllMenus() {
        System.out.println("====== 3. Get All Menus ======");

        List<Menu> menuList = this.service.getAllMenus();
        menuList.forEach(System.out::println);
    }

    public void addFoodMenu() {
        System.out.println("====== 4. Add FoodMenu to Menu ======");

        System.out.print("Menu ID: ");
        int menuId = sc.nextInt();
        System.out.println(menuId);

        System.out.print("Food Menu ID: ");
        int foodId = sc.nextInt();
        System.out.println(foodId);

        this.service.addFoodMenu(menuId, foodId);
    }

    public void addDrinkMenu() {
        System.out.println("====== 5. Add DrinkMenu to Menu ======");

        System.out.print("Menu ID: ");
        int menuId = sc.nextInt();
        System.out.println(menuId);

        System.out.print("Drink Menu ID: ");
        int drinkId = sc.nextInt();
        System.out.println(drinkId);

        this.service.addDrinkMenu(menuId, drinkId);
    }

    public void getMenuById() {
        System.out.println("====== 2. Get Menu ======");

        System.out.print("Menu ID: ");
        int menuId = sc.nextInt();
        System.out.println(menuId);

        Menu menu = this.service.getById(menuId);
        if (menu == null) {
            System.out.println("There is no menu matching with this ID");
            return;
        }
        System.out.println(menu);
    }

    public void updateFoodMenuList() {
        System.out.println("====== 6. Update Food Menu ======");

        System.out.print("Menu ID: ");
        int menuId = sc.nextInt();
        System.out.println(menuId);

        System.out.print("Old Food menu ID: ");
        int foodId = sc.nextInt();
        System.out.println(foodId);

        System.out.println("New Food menu ID: ");
        int newFoodId = sc.nextInt();
        System.out.println(newFoodId);

        this.service.updateFoodMenuItem(menuId, foodId, newFoodId);
    }

    public void updateDrinkMenuList() {
        System.out.println("====== 7. Update Drink Menu ======");

        System.out.print("Menu ID: ");
        int menuId = sc.nextInt();
        System.out.println(menuId);

        System.out.print("Old Drink menu ID: ");
        int drinkId = sc.nextInt();
        System.out.println(drinkId);

        System.out.println("New Drink menu ID: ");
        int newDrinkId = sc.nextInt();
        System.out.println(newDrinkId);

        this.service.updateDrinkMenuItem(menuId, drinkId, newDrinkId);
    }

    public void deleteMenu() {
        System.out.println("====== 8. Delete Menu ======");

        System.out.print("Menu ID: ");
        int menuId = sc.nextInt();
        System.out.println(menuId);

        this.service.deleteItem(menuId);
    }


}

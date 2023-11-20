package minhquan.com.transport;

import minhquan.com.common.IFileHandling;
import minhquan.com.common.impl.FileHandling;
import minhquan.com.container.IOCRepository;
import minhquan.com.container.IOCService;
import minhquan.com.entity.FoodMenuFactory;
import minhquan.com.entity.impl.bill.Bill;
import minhquan.com.entity.impl.foodMenu.EFoodMenuType;
import minhquan.com.entity.impl.foodMenu.FoodMenu;
import minhquan.com.exception.impl.BadRequestException;
import minhquan.com.service.IBillService;
import minhquan.com.service.IFoodMenuService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class FoodMenuTransport {
    private IFoodMenuService service;
    private Scanner sc;

    private IBillService billService;
    private IFileHandling fileHandling;

    public FoodMenuTransport() {
        this.service = IOCService.getInstanceFoodMenuService(IOCRepository.getInstanceFoodMenuRepository());
        this.billService = IOCService.getInstanceBillService(IOCRepository.getInstanceBillRepository());
        this.sc = new Scanner(System.in);
        this.fileHandling = new FileHandling();
    }

    public void createFoodMenu() {
        System.out.println("====== 1. Create Food Menu ======");

        System.out.print("Type of menu: ");
        String type = sc.nextLine();
        System.out.println(type);

        EFoodMenuType typeMenu = null;
        if (type.equalsIgnoreCase("breakfast")) {
            typeMenu = EFoodMenuType.BREAKFAST_MENU;
        } else if (type.equalsIgnoreCase("dinner")) {
            typeMenu = EFoodMenuType.DINNER_MENU;
        } else if (type.equalsIgnoreCase("lunch")) {
            typeMenu = EFoodMenuType.LUNCH_MENU;
        }

        try {
            FoodMenu menu = FoodMenuFactory.getMenu(typeMenu);
            this.service.createNewMenu(menu);
            System.out.println("Added!!");
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void getAllMenus() {
        System.out.println("====== 3. Get All Food Menus ======");

        List<FoodMenu> menuList = this.service.getAllMenus();
        menuList.forEach(System.out::println);
    }

    public void addItemToMenu() {
        System.out.println("====== 4. Add Food to Menu ======");

        System.out.print("Menu ID: ");
        int menuId = sc.nextInt();
        System.out.println(menuId);

        System.out.print("Food ID: ");
        int foodId = sc.nextInt();
        System.out.println(foodId);

        this.service.addItem(menuId, foodId);
    }

    public void getMenuById() {
        System.out.println("====== 2. Get Menu ======");

        System.out.print("Menu ID: ");
        int menuId = sc.nextInt();
        System.out.println(menuId);

        FoodMenu menu = this.service.getById(menuId);
        if (menu == null) {
            System.out.println("There is no menu matching with this ID");
            return;
        }
        System.out.println(menu);
    }

    public void updateMenuList() {
        System.out.println("====== 5. Update Food to Menu ======");

        System.out.print("Menu ID: ");
        int menuId = sc.nextInt();
        System.out.println(menuId);

        System.out.print("Old Food ID: ");
        int foodId = sc.nextInt();
        System.out.println(foodId);

        System.out.println("New Food ID: ");
        int newFoodId = sc.nextInt();
        System.out.println(newFoodId);

        this.service.updateItemMenuList(menuId, foodId, newFoodId);
    }

    public void deleteMenu() {
        System.out.println("====== 6. Delete Menu ======");

        System.out.print("Menu ID: ");
        int menuId = sc.nextInt();
        System.out.println(menuId);

        this.service.deleteMenu(menuId);
    }

    public void exportBill() {
        System.out.println("====== 7. Export Bill ======");

        System.out.print("Please choose Menu to export Bill: ");
        int id = sc.nextInt();

        FoodMenu menu = this.service.getById(id);

        Bill bill = Bill.getInstance();
        bill.setMenuId(id);
        bill.setPrice(menu.getTotalPrice());
        bill.setOrderedTime(LocalDateTime.now());

        this.billService.addBill(bill);
    }

    public void exportObject() {
        System.out.println("====== 8. Export FoodMenu ======");

        System.out.print("Food Menu Id: ");
        int id = sc.nextInt();
        System.out.println(id);

        try {
            FoodMenu menu = this.service.getById(id);
            System.out.println(String.format("Food Menu ID %d", id));
            System.out.println(menu);

            this.fileHandling.writeObject("/Users/quandoan/Documents/m2_java_projects/RestaurantApp/src/main/resources/object/" + "FoodMenu" + String.valueOf(id) + ".ser",
                    menu);
        } catch (BadRequestException exception) {
            System.out.println("Code Error: " + exception.getCode());
            System.out.println("Code Error: " + exception.getDescription());
        }
        System.out.println("Exported Successfully!!!");
    }

    public void importObject() {
        System.out.println("====== 9. Import FoodMenu ======");

        System.out.print("Path to import: ");
        String path = sc.nextLine();
        System.out.println(path);

        try {
            FoodMenu menu = (FoodMenu) this.fileHandling.readObject(path);
            this.service.createNewMenu(menu);
        } catch (BadRequestException exception) {
            System.out.println("Code Error: " + exception.getCode());
            System.out.println("Code Error: " + exception.getDescription());
        }
        System.out.println("Imported Successfully!!!");
    }
}

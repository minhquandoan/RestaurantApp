package minhquan.com.transport;

import minhquan.com.common.IFileHandling;
import minhquan.com.common.impl.FileHandling;
import minhquan.com.container.IOCRepository;
import minhquan.com.container.IOCService;
import minhquan.com.entity.DrinkMenuFactory;
import minhquan.com.entity.impl.bill.Bill;
import minhquan.com.entity.impl.drinkMenu.DrinkMenu;
import minhquan.com.entity.impl.drinkMenu.EDrinkMenuType;
import minhquan.com.exception.impl.BadRequestException;
import minhquan.com.service.IBillService;
import minhquan.com.service.IDrinkMenuService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class DrinkMenuTransport {
    private IDrinkMenuService service;

    private Scanner sc;
    private IBillService billService;
    private IFileHandling fileHandling;

    public DrinkMenuTransport() {
        this.service = IOCService.getInstanceDrinkMenuService(IOCRepository.getInstanceDrinkMenuRepository());
        this.billService = IOCService.getInstanceBillService(IOCRepository.getInstanceBillRepository());
        this.sc = new Scanner(System.in);
        this.fileHandling = new FileHandling();
    }

    public void createDrinkMenu() {
        System.out.println("====== 1. Create Drink Menu ======");

        System.out.print("Type of menu: ");
        String type = sc.nextLine();
        System.out.println(type);

        EDrinkMenuType menuType = null;
        if (type.equalsIgnoreCase("soft")) {
            menuType = EDrinkMenuType.SOFTDRINK_MENU;
        } else if (type.equalsIgnoreCase("alcohol")) {
            menuType = EDrinkMenuType.ALCOHOL_MENU;
        }

        try {
            DrinkMenu menu = DrinkMenuFactory.getMenu(menuType);
            this.service.createNewMenu(menu);
            System.out.println("Added!!");
        } catch (NullPointerException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void addItemToMenu() {
        System.out.println("====== 4. Add Drink to Menu ======");

        System.out.print("Menu ID: ");
        int menuId = sc.nextInt();
        System.out.println(menuId);

        System.out.print("Drink ID: ");
        int drinkId = sc.nextInt();
        System.out.println(drinkId);

        this.service.addItem(menuId, drinkId);
    }

    public void getAllMenus() {
        System.out.println("====== 3. Get All Drink Menus ======");

        List<DrinkMenu> menuList = this.service.getAllMenus();
        menuList.forEach(System.out::println);
    }

    public void getMenuById() {
        System.out.println("====== 2. Get Menu ======");

        System.out.print("Menu ID: ");
        int menuId = sc.nextInt();
        System.out.println(menuId);

        DrinkMenu menu = this.service.getById(menuId);
        if (menu == null) {
            System.out.println("There is no menu matching with this ID");
            return;
        }
        System.out.println(menu);
    }

    public void updateMenuList() {
        System.out.println("====== 5. Update Drink to Menu ======");

        System.out.print("Menu ID: ");
        int menuId = sc.nextInt();
        System.out.println(menuId);

        System.out.print("Old Drink ID: ");
        int drinkId = sc.nextInt();
        System.out.println(drinkId);

        System.out.println("New Drink ID: ");
        int newDrinkId = sc.nextInt();
        System.out.println(newDrinkId);

        this.service.updateItemMenuList(menuId, drinkId, newDrinkId);
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

        DrinkMenu menu = this.service.getById(id);

        Bill bill = Bill.getInstance();
        bill.setMenuId(id);
        bill.setPrice(menu.getTotalPrice());
        bill.setOrderedTime(LocalDateTime.now());

        this.billService.addBill(bill);
    }

    public void exportObject() {
        System.out.println("====== 8. Export DrinkMenu ======");

        System.out.print("Drink Menu Id: ");
        int id = sc.nextInt();
        System.out.println(id);

        try {
            DrinkMenu menu = this.service.getById(id);
            System.out.println(String.format("Drink Menu ID %d", id));
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
        System.out.println("====== 9. Import DrinkMenu ======");

        System.out.print("Path to import: ");
        String path = sc.nextLine();
        System.out.println(path);

        try {
            DrinkMenu menu = (DrinkMenu) this.fileHandling.readObject(path);
            this.service.createNewMenu(menu);
        } catch (BadRequestException exception) {
            System.out.println("Code Error: " + exception.getCode());
            System.out.println("Code Error: " + exception.getDescription());
        }
        System.out.println("Imported Successfully!!!");
    }
}

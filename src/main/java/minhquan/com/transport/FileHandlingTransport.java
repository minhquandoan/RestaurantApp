package minhquan.com.transport;

import minhquan.com.common.IFileHandling;
import minhquan.com.container.IOCRepository;
import minhquan.com.container.IOCService;
import minhquan.com.db.DrinkMenuDB;
import minhquan.com.db.FoodMenuDB;
import minhquan.com.entity.impl.foodMenu.FoodMenu;
import minhquan.com.service.IFoodMenuService;

import java.util.Scanner;

public class FileHandlingTransport {
    private IFileHandling fileHandling;
    private Scanner sc;
    private IFoodMenuService menuService;

    public FileHandlingTransport(IFileHandling fileHandling) {
        this.fileHandling = fileHandling;
        this.menuService = IOCService.getInstanceFoodMenuService(IOCRepository.getInstanceFoodMenuRepository());
    }

    public void storeFoodMenu() {
        System.out.println("=====Export FoodMenu to file=====");
        System.out.print("Please select ID: ");
        int id = sc.nextInt();

        FoodMenu menu = menuService.getById(id);
    }

    public void storeAllFoodMenus() {
        System.out.println("=====Export FoodMenus to file=====");
        fileHandling.writeFile("/Users/quandoan/Documents/m2_java_projects/RestaurantApp/src/main/resources/test.csv", FoodMenuDB.getInstance().toDataString());
    }

    public void storeAllDrinkMenus() {
        System.out.println("=====Export DrinkMenus to file=====");
        fileHandling.writeFile("/Users/quandoan/Documents/m2_java_projects/RestaurantApp/src/main/resources/test1.csv", DrinkMenuDB.getInstance().toDataString());
    }
}

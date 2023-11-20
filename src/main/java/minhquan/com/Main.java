package minhquan.com;

import minhquan.com.common.impl.FileHandling;
import minhquan.com.db.*;
import minhquan.com.transport.*;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        runServices();
    }

    public static boolean runServices() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== Menu Management Services =====");
            System.out.println("1. Food Service");
            System.out.println("2. Drink Service");
            System.out.println("3. Food Menu Service");
            System.out.println("4. Drink Menu Service");
            System.out.println("5. Menu Service");
            System.out.println("6. Bill Services");
            System.out.println("7. File I/O");

            System.out.print("Your Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    runFoodServices();
                    break;
                case 2:
                    runDrinkServices();
                    break;
                case 3:
                    runFoodMenuServices();
                    break;
                case 4:
                    runDrinkMenuServices();
                    break;
                case 5:
                    runMenu();
                    break;
                case 6:
                    runBillService();
                    break;
                case 7:
                    runFileService();
                    break;
                default:
                    System.out.println("The choice must be in 1 -> 5");
            }

        }
    }

    private static void runFileService() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== File I/O =====");
            System.out.println("1. Export All FoodMenus");
            System.out.println("2. Export All DrinkMenus");

            System.out.print("Your Choice: ");
            int choice = sc.nextInt();

            FileHandlingTransport transport = new FileHandlingTransport(new FileHandling());
            switch (choice) {
                case 1:
                    transport.storeAllFoodMenus();
                    break;
                case 2:
                    transport.storeAllDrinkMenus();
                default:
                    System.out.println("The choice must be in 1 -> 4");
            }
        }
    }

    public static void runFoodServices() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== Food Services =====");
            System.out.println("1. Create Food");
            System.out.println("2. Get Food By Id");
            System.out.println("3. Get Food List");
            System.out.println("4. Export Food");
            System.out.println("5. Import Food");
            System.out.print("Your Choice: ");
            int choice = sc.nextInt();
            FoodTransport transport = new FoodTransport(new FileHandling());
            switch (choice) {
                case 1:
                    transport.createFood();
                    System.out.println(FoodDB.getFoodDBInstance().getFoodStorage());
                    break;
                case 2:
                    transport.getFood();
                    break;
                case 3:
                    transport.getFoods();
                    break;
                case 4:
                    transport.exportObject();
                    break;
                case 5:
                    transport.importObject();
                    break;
                default:
                    System.out.println("The choice must be in 1 -> 5");
                    return;
            }
        }
    }

    public static void runDrinkServices() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== Drink Services =====");
            System.out.println("1. Create drink");
            System.out.println("2. Get drink By Id");
            System.out.println("3. Get drink List");
            System.out.println("4. Update drink");
            System.out.println("5. Delete drink");
            System.out.print("Your Choice: ");
            int choice = sc.nextInt();
            DrinkTransport transport = new DrinkTransport();
            switch (choice) {
                case 1:
                    transport.createDrink();
                    System.out.println(DrinkDB.getDrinkDBInstance().getDrinkStorage());
                    break;
                case 2:
                    transport.getDrink();
                    break;
                case 3:
                    transport.getDrinks();
                    break;
                case 4:
                    /*Code is here*/
                    break;
                case 5:
                    /*Code is here*/
                    break;
                default:
                    System.out.println("The choice must be in 1 -> 5");
                    return;
            }
        }
    }

    public static void runFoodMenuServices() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== Food Menu Services =====");
            System.out.println("1. Create Menu");
            System.out.println("2. Get Menu By Id");
            System.out.println("3. Get All Menus");
            System.out.println("4. Add Food to Menu");
            System.out.println("5. Update Menu");
            System.out.println("6. Delete Menu");
            System.out.println("7. Export Bill");
            System.out.println("8. Export FoodMenu");
            System.out.println("9. Import Menu");
            System.out.print("Your Choice: ");
            try {
                int choice = sc.nextInt();
                FoodMenuTransport transport = new FoodMenuTransport();
                switch (choice) {
                    case 1:
                        transport.createFoodMenu();
                        System.out.println(FoodMenuDB.getInstance().getStorage());
                        break;
                    case 2:
                        transport.getMenuById();
                        break;
                    case 3:
                        transport.getAllMenus();
                        break;
                    case 4:
                        transport.addItemToMenu();
                        break;
                    case 5:
                        transport.updateMenuList();
                        break;
                    case 6:
                        transport.deleteMenu();
                        break;
                    case 7:
                        transport.exportBill();
                        break;
                    case 8:
                        transport.exportObject();
                        break;
                    case 9:
                        transport.importObject();
                        break;
                    default:
                        System.out.println("The choice must be in 1 -> 9");
                        return;
                }
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void runDrinkMenuServices() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== Drink Menu Services =====");
            System.out.println("1. Create Menu");
            System.out.println("2. Get Menu By Id");
            System.out.println("3. Get Menu List");
            System.out.println("4. Add Drink to Menu");
            System.out.println("5. Update Menu");
            System.out.println("6. Delete Menu");
            System.out.println("7. Export Bill");
            System.out.println("8. Export DrinkMenu");
            System.out.println("9. Import Menu");
            System.out.print("Your Choice: ");
            try{
                int choice = sc.nextInt();
                DrinkMenuTransport transport = new DrinkMenuTransport();
                switch (choice) {
                    case 1:
                        transport.createDrinkMenu();
                        System.out.println(DrinkMenuDB.getInstance().getStorage());
                        break;
                    case 2:
                        transport.getMenuById();
                        break;
                    case 3:
                        transport.getAllMenus();
                        break;
                    case 4:
                        transport.addItemToMenu();
                        break;
                    case 5:
                        transport.updateMenuList();
                        break;
                    case 6:
                        transport.deleteMenu();
                        break;
                    case 7:
                        transport.exportBill();
                        break;
                    case 8:
                        transport.exportObject();
                        break;
                    case 9:
                        transport.importObject();
                        break;
                    default:
                        System.out.println("The choice must be in 1 -> 9");
                        return;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void runMenu() {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            System.out.println("===== Food Menu Services =====");
//            System.out.println("1. Create Menu");
//            System.out.println("2. Get Menu By Id");
//            System.out.println("3. Get All Menus");
//            System.out.println("4. Add Food Menu");
//            System.out.println("5. Add Drink Menu");
//            System.out.println("6. Update Food Menu");
//            System.out.println("7. Update Drink Menu");
//            System.out.println("8. Delete Menu");
//            System.out.println("9. Export Bill");
//            System.out.print("Your Choice: ");
//            try {
//                int choice = sc.nextInt();
//                MenuTransport transport = new MenuTransport();
//                switch (choice) {
//                    case 1:
//                        transport.createMenu();
//                        System.out.println(MenuDB.getInstance().getStorage());
//                        break;
//                    case 2:
//                        transport.getMenuById();
//                        break;
//                    case 3:
//                        transport.getAllMenus();
//                        break;
//                    case 4:
//                        transport.addFoodMenu();
//                        break;
//                    case 5:
//                        transport.addDrinkMenu();
//                        break;
//                    case 6:
//                        transport.updateFoodMenuList();
//                        break;
//                    case 7:
//                        transport.updateDrinkMenuList();
//                        break;
//                    case 8:
//                        transport.deleteMenu();
//                        break;
//                    case 9:
//                        transport.exportBill();
//                        break;
//                    default:
//                        System.out.println("The choice must be in 1 -> 6");
//                        return;
//                }
//            }catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
    }

    public static void runBillService() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===== Bill Services =====");
            System.out.println("1. Get Bill By Id");
            System.out.println("2. Get All Bills");
            System.out.println("3. Delete Bill");
            System.out.print("Your Choice: ");
            try {
                int choice = sc.nextInt();
                BillTransport transport = new BillTransport();
                switch (choice) {
                    case 1:
                        transport.getBillById();
                        System.out.println(MenuDB.getInstance().getStorage());
                        break;
                    case 2:
                        transport.getAllBills();
                        break;
                    case 3:
                        transport.deleteBill();
                        break;
                    default:
                        System.out.println("The choice must be in 1 -> 3");
                        return;
                }
            }catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
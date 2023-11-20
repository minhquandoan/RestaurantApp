package minhquan.com.transport;

import minhquan.com.container.IOCRepository;
import minhquan.com.container.IOCService;
import minhquan.com.entity.DrinkFactory;
import minhquan.com.entity.IDrinkFactory;
import minhquan.com.entity.impl.drink.Drink;
import minhquan.com.repository.IDrinkRepository;
import minhquan.com.service.IDrinkService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class DrinkTransport {
    private IDrinkService service;
    private Scanner sc;

    private IDrinkFactory factory;

    public DrinkTransport() {
        IDrinkRepository repository = IOCRepository.getInstanceDrinkRepository();
        this.service = IOCService.getInstanceDrinkService(repository);
        sc = new Scanner(System.in);
        this.factory = DrinkFactory.getInstance();
    }

    public void createDrink() {
        System.out.println("====== 1. Create Drink ======");

        sc.nextLine();
        System.out.print("Type of drink: ");
        String type = sc.nextLine();
        System.out.println(type);

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.println(name);

        System.out.print("Price: ");
        BigDecimal price = sc.nextBigDecimal();
        System.out.println(price);

        System.out.print("Carbonated: ");
        boolean carbonated = sc.nextBoolean();
        System.out.println(carbonated);

        Drink drink1 = factory.makeDrink(type);
        drink1.setName(name);
        drink1.setPrice(price);
        drink1.setCarbonated(carbonated);

        this.service.createDrink(drink1);
        System.out.println("Added!!");
    }

    public void getDrink() {
        System.out.println("====== 2. Get Drink By Id ======");

        System.out.print("Drink Id: ");
        int id = sc.nextInt();
        System.out.println(id);

        Drink drink = this.service.getDrinkById(id);

        if (drink == null) {
            System.out.println("There is no Drink matching with this ID");
            return;
        }
        System.out.println(String.format("Drink ID %d", id));
        System.out.println(drink);
    }

    public void getDrinks() {
        System.out.println("====== 2. Get All Drinks ======");

        System.out.println("All the drink in DB: ");

        List<Drink> drinkList = this.service.getAllDrinks();
        drinkList.forEach(System.out::println);
    }
}

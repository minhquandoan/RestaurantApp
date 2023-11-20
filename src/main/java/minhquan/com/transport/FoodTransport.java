package minhquan.com.transport;

import minhquan.com.common.IFileHandling;
import minhquan.com.container.IOCRepository;
import minhquan.com.container.IOCService;
import minhquan.com.entity.FoodFactory;
import minhquan.com.entity.IFoodFactory;
import minhquan.com.entity.impl.food.Food;
import minhquan.com.exception.impl.BadRequestException;
import minhquan.com.repository.IFoodRepository;
import minhquan.com.service.IFoodService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class FoodTransport {
    private IFoodService service;
    private Scanner sc;

    private IFoodFactory factory;

    private IFileHandling fileHandling;

    public FoodTransport(IFileHandling fileHandling) {
        IFoodRepository repository = IOCRepository.getInstanceFoodRepository();
        this.service = IOCService.getInstanceFoodService(repository);
        sc = new Scanner(System.in);
        this.factory = FoodFactory.getInstance();
        this.fileHandling = fileHandling;
    }

    public void createFood() {
        System.out.println("====== 1. Create Food ======");

        System.out.print("Type of Food: ");
        String type = sc.nextLine(); // Modify to enum
        System.out.println(type);

        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.println(name);

        System.out.print("Price: ");
        BigDecimal price = sc.nextBigDecimal();
        System.out.println(price);

        System.out.print("Calories: ");
        int calories = sc.nextInt();
        System.out.println(calories);

        Food food1 = factory.makeFood(type);
        if (food1 == null) {
            System.out.println("Food Type is not Valid");
            return;
        }

        food1.setName(name);
        food1.setPrice(price);
        food1.setCalories(calories);

        this.service.createFood(food1);
        System.out.println("Added!!");
    }

    public void getFood() {
        System.out.println("====== 2. Get Food By Id ======");

        System.out.print("Food Id: ");
        int id = sc.nextInt();
        System.out.println(id);

        try {
            Food food = this.service.getFoodById(id);
            System.out.println(String.format("Food ID %d", id));
            System.out.println(food);
        } catch (BadRequestException exception) {
            System.out.println("Code Error: " + exception.getCode());
            System.out.println("Code Error: " + exception.getDescription());
        }
    }

    public void getFoods() {
        System.out.println("====== 3. Get All Foods ======");

        System.out.println("All the food in DB: ");

        List<Food> foodList = this.service.getAllFoods();
        foodList.forEach(System.out::println);
    }

    public void exportObject() {
        System.out.println("====== 4. Export Food ======");

        System.out.print("Food Id: ");
        int id = sc.nextInt();
        System.out.println(id);

        try {
            Food food = this.service.getFoodById(id);
            System.out.println(String.format("Food ID %d", id));
            System.out.println(food);

            this.fileHandling.writeObject("/Users/quandoan/Documents/m2_java_projects/RestaurantApp/src/main/resources/object/" + "Food" + String.valueOf(id) + ".ser",
                                            food);
        } catch (BadRequestException exception) {
            System.out.println("Code Error: " + exception.getCode());
            System.out.println("Code Error: " + exception.getDescription());
        }
        System.out.println("Exported Successfully!!!");
    }

    public void importObject() {
        System.out.println("====== 5. Import Food ======");

        System.out.print("Path to import: ");
        String path = sc.nextLine();
        System.out.println(path);

        try {
            Food food = (Food) this.fileHandling.readObject(path);
            this.service.createFood(food);
        } catch (BadRequestException exception) {
            System.out.println("Code Error: " + exception.getCode());
            System.out.println("Code Error: " + exception.getDescription());
        }
        System.out.println("Imported Successfully!!!");
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SliceOHeaven {
    // 店铺基本信息
    private String ostoreName;
    private String storeAddress;
    private String storeEmail;
    private String storePhone;
    
    // 菜单相关属性
    private List<String> storeMenu;
    private List<String> pizzaIngredients;
    private double pizzaPrice;
    private List<String> sides;
    private List<String> drinks;
    
    // 订单相关属性
    private String orderID;
    private double orderTotal;

    public SliceOHeaven() {
        initializeStoreInfo();
        initializeMenu();
    }

    private void initializeStoreInfo() {
        ostoreName = "Slice-o-Heaven";
        storeAddress = "456 Heavenly Pizza Ave, Food City";
        storeEmail = "heavenly.slice@email.com";
        storePhone = "(555) 123-4567";
    }

    private void initializeMenu() {
        // 初始化披萨菜单
        storeMenu = new ArrayList<>(Arrays.asList(
            "Classic Cheese", 
            "Pepperoni Passion", 
            "Veggie Delight"
        ));
        
        // 初始化配菜和饮料选项
        sides = new ArrayList<>(Arrays.asList(
            "Garlic Bread", 
            "Chicken Wings", 
            "Cheesy Fries"
        ));
        
        drinks = new ArrayList<>(Arrays.asList(
            "Soda Can", 
            "Bottled Water", 
            "Fresh Lemonade"
        ));
        
        pizzaIngredients = new ArrayList<>();
    }

    public void otakeOrder() {
        generateOrderID();
        selectPizza("Pepperoni Passion");  // 模拟选择披萨
        addSideItem("Garlic Bread");       // 模拟添加配菜
        addDrink("Fresh Lemonade");        // 模拟添加饮料
        calculateTotal();
    }

    private void generateOrderID() {
        orderID = "PIZ-" + System.currentTimeMillis();
    }

    private void selectPizza(String pizzaType) {
        switch (pizzaType) {
            case "Classic Cheese":
                pizzaIngredients = Arrays.asList("Tomato Sauce", "Mozzarella");
                pizzaPrice = 12.99;
                break;
            case "Pepperoni Passion":
                pizzaIngredients = Arrays.asList("Tomato Sauce", "Mozzarella", "Pepperoni");
                pizzaPrice = 14.99;
                break;
            case "Veggie Delight":
                pizzaIngredients = Arrays.asList("Tomato Sauce", "Mozzarella", "Mushrooms", "Bell Peppers");
                pizzaPrice = 13.99;
                break;
            default:
                System.out.println("Invalid pizza selection");
        }
    }

    private void addSideItem(String side) {
        sides.add(side);
    }

    private void addDrink(String drink) {
        drinks.add(drink);
    }

    private void calculateTotal() {
        double sideCost = 4.99;  // 配菜统一价格
        double drinkCost = 2.99; // 饮料统一价格
        
        orderTotal = pizzaPrice;
        orderTotal += sides.size() * sideCost;
        orderTotal += drinks.size() * drinkCost;
    }

    public void makePizza() {
        System.out.println("\n正在制作披萨 🍕");
        System.out.println("使用的配料：");
        pizzaIngredients.forEach(ingredient -> 
            System.out.println(" - " + ingredient)
        );
        System.out.println("披萨制作完成！");
    }

    public void printReceipt() {
        System.out.println("\n=== 天堂披萨店收据 ===");
        System.out.println("订单号: " + orderID);
        System.out.println("\n店铺信息：");
        System.out.println("名称: " + ostoreName);
        System.out.println("地址: " + storeAddress);
        System.out.println("邮箱: " + storeEmail);
        System.out.println("电话: " + storePhone);
        
        System.out.println("\n订单详情：");
        System.out.printf("主披萨: $%.2f%n", pizzaPrice);
        System.out.println("配菜 (" + sides.size() + "):");
        sides.forEach(side -> 
            System.out.println(" - " + side)
        );
        System.out.println("饮料 (" + drinks.size() + "):");
        drinks.forEach(drink -> 
            System.out.println(" - " + drink)
        );
        
        System.out.printf("%n总计: $%.2f%n", orderTotal);
        System.out.println("感谢惠顾！😊");
        System.out.println("========================");
    }

    public static void main(String[] args) {
        SliceOHeaven order = new SliceOHeaven();
        order.otakeOrder();
        order.makePizza();
        order.printReceipt();
    }
}
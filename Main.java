import java.util.*;

public class Main {
    static Thread thread = new Thread();
    public static final String ANSI_RESET = "\u001B[0m"; 
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";  
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Stack<String> basket = new Stack<>();
        int price = 0;
        System.out.println(ANSI_YELLOW+"Welcome to the PEREZ Grocery Store\nThis Interface has an Artificial Intelligent Bot that is ready to assist you"+ANSI_RESET);
        System.out.print("Click y if you're ready. Click otherwise if not: ");
        char resp = input.next().charAt(0);

        while (resp == 'y'){
            try {
                // thread.start();
                initializing();
                System.out.println();
                System.out.println(ANSI_GREEN+"The chat bot is now Ready!!"+ANSI_RESET);
                char resp1 = 'y';
                input.nextLine();
                while (resp1 == 'y'){
                    System.out.print("Hello customer! What would you like to order: ");
                    String order = input.nextLine().toLowerCase();
                    System.out.print(ANSI_YELLOW+"Checking if it is available"+ANSI_RESET);
                    loading();
                    System.out.println();
                    if (checkProduct(order) != null){
                        System.out.println(ANSI_GREEN+"Good News! We have this product"+ANSI_RESET);
                        System.out.printf("The price of the product %s is Php %d\n", checkProduct(order)[0].toString(), (int) checkProduct(order)[1]);
                        System.out.print("Would you like to add to your cart: ");
                        char resp2 = input.next().charAt(0);
                        if (resp2 == 'y'){
                            basket.add(checkProduct(order)[0].toString());
                            price += (int) checkProduct(order)[1];
                            System.out.println(ANSI_GREEN+"The current total price is Php "+price+ANSI_RESET);
                            System.out.print("Would you like to add another: ");
                            resp1 = input.next().charAt(0);
                            input.nextLine();
                        } else {
                            System.out.print("Would you like to add another: ");
                            resp1 = input.next().charAt(0);
                            input.nextLine();
                        }
                    } else {
                        System.out.println(ANSI_RED+"Sorry the product is unavailable\nPlease Try Again"+ANSI_RESET);
                    }
                }
                boolean flag = true;
                while (flag){
                    System.out.println(ANSI_GREEN+"The total price is Php "+price+ANSI_RESET);
                    System.out.print("Enter amount: ");
                    int amount = input.nextInt();
                    if (amount < price){
                        System.out.println(ANSI_RED+"Insufficient Amount Please Try Again"+ANSI_RESET);
                    } else {
                        System.out.println(ANSI_GREEN+"Payment Successful!!"+ANSI_RESET);
                        System.out.println("Change: Php "+(amount - price));
                        flag = false;
                    }
                }
                resp = 'n';
                // thread.stop();
            } catch (Exception e){
                System.out.println(e);
            }
        }
        System.out.println(ANSI_GREEN+"Thank you for using our Chat Bot!!"+ANSI_RESET);
    }

    public static Object[] checkProduct(String product){
        Map<String, Integer> products = new HashMap<>();
        products.put("water", 20);
        products.put("milk", 25);
        products.put("kopiko blanca", 12);
        products.put("pancit canton", 20);
        products.put("coca-cola", 25);
        products.put("diaper", 20);
        products.put("candy", 50);
        products.put("royal", 24);
        products.put("vcut", 30);
        products.put("piatos", 30);
        products.put("pretzel", 20);
        products.put("red horse", 150);
        products.put("ginebra", 150);
        products.put("ulam", 30);
        products.put("ligo", 30);
        products.put("selecta", 50);
        products.put("cheese wiz", 25);
        products.put("bread", 50);
        products.put("reno", 25);

        Object[] orders = new Object[2];
        if (products.containsKey(product)){
            orders[0] = product;
            orders[1] = products.get(product);
            return orders;
        } else {
            return null;
        }
    }

    public static void initializing(){
        Main main = new Main();
        try {
            System.out.print(ANSI_YELLOW+"Initializing Chat Bot");
            for (int i = 0; i < 20; i++){
                System.out.print(".");
                thread.sleep(100);
            }
            for (int i = 0; i <= 100; i++){
                if (i < 10){
                    System.out.print(i+"%");
                    System.out.print("\b\b");
                } else if (i >= 10 && i < 100){
                    System.out.print(i+"%");
                    System.out.print("\b\b\b");
                } else {
                    System.out.print(i+"%");
                    System.out.print("\b\b\b\b");
                }
                thread.sleep(100);
            }
            System.out.print(ANSI_RESET);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void loading(){
        System.out.print(ANSI_YELLOW);
        try {
            for (int i = 0; i < 20; i++){
                System.out.print(".");
                thread.sleep(100);
            }
            for (int i = 0; i < 10; i++){
                System.out.print("/");
                System.out.print("\b");
                thread.sleep(200);
                System.out.print("|");
                System.out.print("\b");
                thread.sleep(200);
                System.out.print("\\");
                System.out.print("\b");
                thread.sleep(200);
            }
        } catch (Exception e){
            System.out.println(e);        
        }
        System.out.print(ANSI_RESET);
    }
}

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

class product {
    private String productName;
    private double productPrice;
    private int productQuantity;
    private double totalPrice;
    product() {
        this.productName = null;
        this.productPrice = 0;
        this.productQuantity = 0;
        this.totalPrice = 0;
    }
    product (String productName, int productQuantity, double productPrice, double totalPrice) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
    }
    public static void displayFormat() {
        System.out.println("\n Name         Price       Quantity        TotalPrice\n");
    }
    public void display() {
        System.out.format("%-9s |%8d| %16.2f |%16.2f\n", productName,productQuantity,productPrice,totalPrice);
    }
}
public class billmachine {
    public static void main(String[] args) throws InterruptedException {
        product ap = new product();

        String productName;
        int quantity;
        double price;
        double totalPrice;
        double overAllprice =0;
        String choice;


        Scanner sc = new Scanner(System.in);
        ArrayList<product> Products = new ArrayList<product>();
        System.out.println("---------------------Enter the product details------------------------");
while(true) {
        System.out.println("Enter the name of product");
        productName = sc.nextLine();
        System.out.println("Enter the price of product(per item)");
        price = sc.nextFloat();
        System.out.println("Enter Quantity of the product");
        quantity = sc.nextInt();
        totalPrice = price * quantity;
        overAllprice += totalPrice;
//        System.out.printf("your total is ----%10.2f", overAllprice);
        Products.add(new product(productName,quantity, price, totalPrice));
        System.out.println("Do you want to add more items ");
        choice = sc.next();
        if(choice.equalsIgnoreCase("N") || choice.equalsIgnoreCase("no"))
            break;
        sc.nextLine();
}
        System.out.println("please wait your bill is being caluclated and printed soon");
        int i = 0;
        while (i <= 6) {
            System.out.print(".");
            Thread.sleep(500);
            i++;
        }
        System.out.println(".");
//        Thread.sleep(2000);
        product.displayFormat();
        for (product p : Products) {
            p.display();
        }

        System.out.println("\n Overall price is = " + overAllprice);

    }
}

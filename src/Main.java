import entity.Product;
import handle.ProductHandle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductHandle productHandle = new ProductHandle();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập số lượng sản phẩm muốn tạo ra: ");
        int n = Integer.parseInt(scanner.nextLine());
        Product[] products = new Product[n];

        // Create products and add to array
        for (int i = 0; i < n; i++) {
            Product product = productHandle.createProduct(scanner, i);
            products[i] = product;
        }

        //Select task
        String continues;
        do {
            productHandle.selectTask(products, scanner);
            System.out.println("Bạn muốn làm gì tiếp không (Y: có /N: không): ");
            continues = scanner.nextLine();
        } while (continues.equalsIgnoreCase("y"));
    }
}

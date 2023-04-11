import entity.Product;
import handle.ProductHandle;
import view.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductHandle productHandle = new ProductHandle();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời b nhập số lượng sản phẩm muốn tạo ra: ");
        int n = Integer.parseInt(scanner.nextLine());
        Product[] products = new Product[n];

        // Create products and add to array
        for (int i = 0; i < n; i++) {
            Product product = productHandle.createProduct(scanner, i);
            products[i] = product;
        }
        //Display all products
        productHandle.displayAllProducts(products);
        //find Product By Name
        System.out.println("Mời bạn nhập tên sản phẩm muốn tìm: ");
        String name = scanner.nextLine();
        productHandle.findProductByName(products, name);

        System.out.println("Mời bạn nhập ID sản phẩm muốn tìm: ");
        int id = Integer.parseInt(scanner.nextLine());
        productHandle.findById(products, id);
        Menu menu = new Menu();
        productHandle.filterByPrice(products,menu.menuSelectByPrice(scanner));
        // sort by price
        productHandle.sortByPrice(products);
    }
}

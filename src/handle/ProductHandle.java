package handle;

import entity.Product;
import view.Menu;

import java.util.Scanner;

public class ProductHandle {

    public Product createProduct(Scanner scanner, int i){
        System.out.println("Mời bạn nhập vào tên sp thứ "+(i+1));
        String name = scanner.nextLine();
        System.out.println("Mời bạn nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        return new Product(name, price);
    }

    public void displayAllProducts(Product[] products){
        for (Product p: products
             ) {
            System.out.println(p);
        }
    }

    public String findProductByName(Product[] products,Scanner scanner){
        System.out.println("Mời bạn nhập tên sản phẩm muốn tìm: ");
        String name = scanner.nextLine();
        for (Product product: products) {
            if (product.getName().equalsIgnoreCase(name)){
                System.out.println(product);
                return "Đã tìm thấy";
            }
        }
        return ("Không tìm thấy sản phẩm có tên là: "+name);
    }

    public Product findById(Product[] products, Scanner scanner){
        System.out.println("Mời bạn nhập ID sản phẩm muốn tìm: ");
        int id = Integer.parseInt(scanner.nextLine());
        findById(products, scanner);
        for (Product product: products) {
            if (product.getId() == id){
                return product;
            }
        }
        return null;
    }

    public boolean updateProductById(Product product, String name){
        if(product == null) return false;
        else {
            product.setName(name);
            return true;
        }
    }
    public void filterByPrice(Product[] products, int option){
        for (Product p: products) {
            if(p.getPrice()<50000 && option==1) System.out.println(p);
            else if (p.getPrice()<100000 && p.getPrice()>50000 && option==2) System.out.println(p);
            else if (p.getPrice()>100000 && option==3) System.out.println(p);
        }
    }

    public void sortByPrice(Product[] products){
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < products.length -1; j++) {
                if(products[j].getPrice()> products[j+1].getPrice()){
                    Product temp =  products[j];
                    //a[0] = 0
                    products[j] = products[j+1];
                    //a[1] = 1
                    products[j+1] = temp;
                }
            }
        }
        System.out.println("After Sorting: ");
        for (Product p : products
             ) {
            System.out.println(p);
        }
    }

    public void selectTask(Product[] products, Scanner scanner){
        Menu menu = new Menu();
        int select = menu.menuSelect(scanner);
            if (select==1) displayAllProducts(products);
            else if (select==2) findProductByName(products, scanner);
            else if (select==3) findById(products, scanner);
            else if (select==4) filterByPrice(products, menu.menuSelectByPrice(scanner));
            else if (select==5) sortByPrice(products);
    }

}

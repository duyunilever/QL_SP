package handle;

import entity.Product;

import java.util.Scanner;

public class ProductHandle {

    public Product createProduct(Scanner scanner, int i){
        System.out.println("Mời b nhập vào tên sp thứ "+(i+1));
        String name = scanner.nextLine();
        System.out.println("Nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        return new Product(name, price);
    }

    public void displayAllProducts(Product[] products){
        for (Product p: products
             ) {
            System.out.println(p);
        }
    }

    public void findProductByName(Product[] products, String name){
        boolean check = false;
        for (Product product: products) {
            if (product.getName().equalsIgnoreCase(name)){
                System.out.println(product);
                check= true;
            }
        }
        if(!check){
            System.out.println("Không tìm thấy sản phẩm có tên là: "+name);
        }
    }

    public Product findById(Product[] products, int id){
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
}

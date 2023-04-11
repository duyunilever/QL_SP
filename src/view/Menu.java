package view;

import entity.Product;
import handle.ProductHandle;

import java.util.Scanner;

public class Menu {

    public int menuSelect(Scanner scanner) {
            System.out.println("Bạn muốn làm gì? ");
            System.out.println("1: In danh sách sản phẩm\n" +
                    "2: Tìm sản phẩm theo tên\n" +
                    "3: Tìm sản phẩm theo ID\n" +
                    "4: Lọc sản phẩm theo giá tiền\n" +
                    "5: Sắp xếp sản phẩm theo giá tiền");
            System.out.println("Mời bạn chọn:");
            int select = Integer.parseInt(scanner.nextLine());
            return select;
    }

    public int menuSelectByPrice(Scanner scanner){
        System.out.println("Bạn muốn tìm sản phẩm theo mức giá nào? ");
        System.out.println("1: Dưới 50.000\n" +
                "2: Từ 50.000 đến dưới 100.000\n" +
                "3: Từ 100.000 trở lên");
        System.out.println("Mời b chọn");
        int option = Integer.parseInt(scanner.nextLine());
        return option;
    }
}

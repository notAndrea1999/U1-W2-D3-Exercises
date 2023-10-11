import shop.CategoryFilter;
import shop.Customer;
import shop.Order;
import shop.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        CategoryFilter categoryFilter = (book, str) -> book.getCategory().equals(str);


        List<Product> productList = new ArrayList<>();
        List<Order> orderList = new ArrayList<>();

        Product product1 = new Product("book1", "Books");
        Product product2 = new Product("book2", "Books");
        Product product3 = new Product("book3", "Books");
        Product product4 = new Product("book4", "Books");
        Product product5 = new Product("book5", "Books");
        Product product6 = new Product("book5", "Books");
        Product product7 = new Product("babyToy1", "Baby");
        Product product8 = new Product("babyToy2", "Baby");
        Product product9 = new Product("boyItem1", "Boy");
        Product product10 = new Product("boyItem2", "Boy");

        Customer customer1 = new Customer("Giancarlo", 2);
        Customer customer2 = new Customer("Alfonso", 1);
        Customer customer3 = new Customer("Alessio", 3);
        Customer customer4 = new Customer("Francesco", 2);
        Customer customer5 = new Customer("Aldo", 2);

        LocalDate day1 = LocalDate.of(2021, 02, 15);
        LocalDate day2 = LocalDate.of(2023, 10, 11);
        LocalDate day3 = LocalDate.of(2021, 03, 30);
        LocalDate day4 = LocalDate.of(2023, 10, 16);
        LocalDate day5 = LocalDate.of(2023, 10, 20);

        Order order1 = new Order("In Transito", day1, day2, productList, customer1);
        Order order2 = new Order("Consegnato", day5, day5, productList, customer2);
        Order order3 = new Order("Spedito", day3, day2, productList, customer3);
        Order order4 = new Order("Consegnato", day3, day2, productList, customer4);
        Order order5 = new Order("In Transito", day2, day4, productList, customer5);


        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        productList.add(product10);

        orderList.add(order1);
        orderList.add(order2);
        orderList.add(order3);
        orderList.add(order4);
        orderList.add(order5);

        // EXERCISE 1
        System.out.println("************************* EXERCISE 1 ***************************");
        Predicate<Product> isMoreThenOneHundred = price -> price.getPrice() > 100;
        //Predicate<Product> isItABook = category -> category.getCategory().equals("Books");
        List<Product> bookProduct = productList.stream().filter(isMoreThenOneHundred).filter(p -> categoryFilter.categoryFilter(p, "Books")).toList();
        bookProduct.forEach(System.out::println);

        // EXERCISE 2
        System.out.println("************************* EXERCISE 2 ***************************");
        Predicate<Product> isItBaby = category -> category.getCategory().equals("Baby");
        List<Product> babyProduct = productList.stream().filter(p -> categoryFilter.categoryFilter(p, "Baby")).toList();
        babyProduct.forEach(System.out::println);

        // EXERCISE 3
        System.out.println("************************* EXERCISE 3 ***************************");
        Predicate<Product> isItBoy = category -> category.getCategory().equals("Boy");
        List<Product> boyProduct = productList.stream().filter(p -> categoryFilter.categoryFilter(p, "Boy")).toList();
        boyProduct.forEach(product -> {
            product.discount();
            System.out.println(product);
        });

        // EXERCISE 4
        System.out.println("************************* EXERCISE 4 ***************************");
        LocalDate firstDate = LocalDate.of(2021, 2, 1);
        LocalDate secondDate = LocalDate.of(2021, 4, 1);
        Predicate<Order> isItTier2 = tier -> tier.getCustomer().getTier() == 2;
        Predicate<Order> isDateRight = date -> date.getOrderDate().isAfter(firstDate) && date.getOrderDate().isBefore(secondDate);
        List<Order> orderedProducts = orderList.stream().filter(isItTier2.and(isDateRight)).toList();
        orderedProducts.forEach(System.out::println);
    }
}
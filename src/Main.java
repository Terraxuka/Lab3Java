import ObjectClasses.*;
import Services.MarketService;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class Main {
    public static void main(final String[] args) throws InterruptedException {

        MarketService service = new MarketService();

        //service.getInfoFromFile("Service data", "Service data");

        final Item meatItem = new Item("Chicken meat", ProductCategory.MEAT, StorageType.KILOGRAM);
        final Item potatoItem = new Item("Potato", ProductCategory.VEGETABLES, StorageType.KILOGRAM);
        final Item coffeeItem = new Item("Coffee", ProductCategory.COFFEE_TEA, StorageType.PIECE);

        final Customer customer = new Customer("Vadym", "Horn");
        final ProductInfo meat = new ProductInfo(meatItem, 10, 1000, 360.);
        final ProductInfo potato = new ProductInfo(potatoItem, 1, 100., 18.);
        final ProductInfo coffee = new ProductInfo(coffeeItem, 190, 0.8, 235.);

        System.out.println(service.getStorageItems().stream().map(Item::toString).collect(Collectors.toList()));

        Order testOrder = service.createOrder(
                new ProductInfo(meatItem, 1, 5, 10.)
                , new ProductInfo(potatoItem, 1, 10, 12.)
                , new ProductInfo(coffeeItem, 1, 1., 1.));
        service.payOrder(testOrder, customer);
        Thread.sleep(3000);
        Order testOrder2 = service.createOrder(new ProductInfo(potatoItem, 12, 11.,1.));
        System.out.println(testOrder.toString());
        System.out.println(testOrder2.toString());
        service.payOrder(testOrder2, customer);

        System.out.println("Adjusting order");
        service.changeItem(meatItem, "Pork meat", null, null);
        System.out.println(service.getStorageItems().stream().map(Item::toString).collect(Collectors.toList()));


        System.out.println("Saving user purchase history");
        System.out.println(service.statisticByCustomer(customer));

        System.out.println("\nSorting by price");
        System.out.println(service.getSortedAndFilterByPriceStorageGoods(5., 50.));

        System.out.println("Average price of products");
        System.out.println(service.middlePrice());

        System.out.println("Write a method to determine all expenses of a specified user for a given time period");
        System.out.println(service.ordersByCustomerAndTime(customer, LocalDateTime.now().minusDays(1), LocalDateTime.now().plusDays(1)));

        System.out.println("Data on the total quantity of each purchased product");
        System.out.println(service.statisticByCustomer(customer));

        System.out.println("The most popular product");
        System.out.println(service.mostPopularItem());

        System.out.println("Biggest profit per day");
        System.out.println(service.maxProfitDayToString());

    }
}

package Strategy;

import ObjectClasses.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MarketStrategy {
    void addCustomer(Customer customer);

    void addProductsToStorage(List<ProductInfo> products);

    Order sellItems(Customer customer, List<ProductInfo> products);

    void payOrder(Order order);

    List<Order> getOrdersFromCustomer(Customer customer);

    double middlePrice();

    Item mostPopularItem();

    Map<LocalDate, Double> dayWithMaxProfit();

    String maxProfitDayToString();

    Map<LocalDate, Double> profitPerDay();

    Map<Item, Double> itemsByCustomer(Customer customer);

    List<Order> ordersByCustomerAndTime(Customer customer, LocalDateTime startTime, LocalDateTime endTime);

    double moneyByCustomerAndTime(Customer customer, LocalDateTime startTime, LocalDateTime endTime);

    List<ProductInfo> getSortedAndFilterByPriceStorageGoods(Double minPrice, Double maxPrice);

}

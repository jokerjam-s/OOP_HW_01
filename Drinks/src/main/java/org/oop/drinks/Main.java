package org.oop.drinks;

/**
 * Создать наследника реализованного класса ГорячийНапиток с дополнительным полем int температура.
 * Создать класс ГорячихНапитковАвтомат реализующий интерфейс ТорговыйАвтомат и реализовать перегруженный метод
 * getProduct(int name, int volume, int temperature) выдающий продукт соответствующий имени, объему и температуре
 * В main проинициализировать несколько ГорячихНапитков и ГорячихНапитковАвтомат и воспроизвести логику заложенную в программе
 *
 * При продаже автомат ищет затребованный напиток, если не найден - возвращает серчисное сообщение о требуемом напитке.
 * Если найден, количество реализуемого напитка уменьшается и выводится информация о проданном напитке
 * Если напиток найден, но его недостаточно, отобразит сервисное сообщение и информацию оналичии нужного напитка
 */

import org.oop.drinks.drink.NewHotDrink;
import org.oop.drinks.vendor.HotDrinkVendor;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        // напитки
        NewHotDrink americano = new NewHotDrink("Американо", 90, 60);
        NewHotDrink latte = new NewHotDrink("Латте", 500, 55);
        NewHotDrink greenTea = new NewHotDrink("Чай зеленый", 500, 60);

        // загрузка в автомат
        HotDrinkVendor vendor = new HotDrinkVendor();
        vendor.addProduct(americano);
        vendor.addProduct(latte);
        vendor.addProduct(greenTea);

        Logger logger = Logger.getAnonymousLogger();

        // продажа
        logger.info(vendor.getProduct("Чай черный", 50, 60));
        logger.info(vendor.getProduct("Американо", 50, 60));
        logger.info(vendor.getProduct("Латте", 50, 60));
        logger.info(vendor.getProduct("Латте", 50, 55));
        logger.info(vendor.getProduct("Американо", 50, 60));

    }
}
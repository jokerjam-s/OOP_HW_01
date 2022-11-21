package org.oop.drinks.vendor;

import org.oop.drinks.drink.HotDrink;

/**
 * Интерфейс автомата горячих напитков
 */
public interface IHotDrinkVendor {

    /**
     * Выдача напитка из автомата
     *
     * @param name        - название напитка
     * @param volume      - требуемый объем
     * @param temperature - необходимая температура
     * @return - true - если напиток выдан успешно, false - если напитка нет
     */
    String getProduct(String name, int volume, int temperature);

    /**
     * Загрузка нужного напитка в автомат
     * @param product   - экземпляр загруэаемого продукта
     */
    void addProduct(HotDrink product);
}

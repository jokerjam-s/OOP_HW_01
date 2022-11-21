package org.oop.drinks.vendor;

import org.oop.drinks.drink.HotDrink;
import org.oop.drinks.drink.NewHotDrink;

import java.util.*;

/**
 * Класс автомата по продаже горячих напитков
 */
public class HotDrinkVendor implements IHotDrinkVendor {
    private Set<HotDrink> hotDrinks;

    /**
     * Конструктор с параметром списка напитков
     *
     * @param hotDrinks - Список напитков, загруженных в автомат
     */
    public HotDrinkVendor(Set<HotDrink> hotDrinks) {
        this.hotDrinks = hotDrinks;
    }

    /**
     * Конструктор с пустым списком
     */
    public HotDrinkVendor() {
        this(new HashSet<>());
    }

    /**
     * Полученеи напитка из автомата
     *
     * @param name          - название напитка
     * @param volume        - требуемый объем
     * @param temperature   - необходимая температура
     * @return              - информацию о проданном напитке,
     *                        если напитка недостаточно для реализации - информацию о напитке а автомате,
     *                        если запрошен напиток с неверными параметрами - сервисное сообщение об отсутствии нужного напитка
     */
    @Override
    public String getProduct(String name, int volume, int temperature) {
        NewHotDrink findDrink = new NewHotDrink(name, volume, temperature);
        Optional<HotDrink> drinkOpt = hotDrinks.stream()
                .filter(d -> d.equals(findDrink))
                .findFirst();

        if (drinkOpt.isPresent()) {
            NewHotDrink drink = (NewHotDrink) drinkOpt.get();
            if (drink.saleDrink(volume)) {
                return String.format("Выдан: %s", findDrink.toString());
            }else {
                return String.format("Недостаточно, в наличии: %s. Требуется %d", drink.toString(), findDrink.getVolume());
            }
        }
        return String.format("Не найден: %s", findDrink.toString());
    }

    /**
     * Загрузка напитка в автомат
     *
     * @param product - экземпляр загруэаемого продукта
     */
    @Override
    public void addProduct(HotDrink product) {
        hotDrinks.add(product);
    }
}

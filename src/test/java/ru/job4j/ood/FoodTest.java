package ru.job4j.ood;

import org.junit.Test;
import ru.job4j.ood.lsp.food.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FoodTest {

    List<Food> listOfFoods =  List.of(new Fruit("orange",
                    LocalDate.of(2022, 4, 22),
                    LocalDate.of(2022, 4, 1),
                    2.0, 0.0),
            new Fruit("banana",
                    LocalDate.of(22, 5, 4),
                    LocalDate.of(22, 4, 10), 5.0, 0.0),
            new Vegetables("potato",
                    LocalDate.of(22, 4, 4),
                    LocalDate.of(22, 3, 10), 1.0, 0.0),
            new Vegetables("tomato",
                    LocalDate.of(22, 4, 14),
                    LocalDate.of(22, 3, 30), 3.0, 0.0),
            new Meat("chicken",
                    LocalDate.of(22, 4, 11),
                    LocalDate.of(22, 4, 3), 7.0, 0.0),
            new Meat("beef",
                    LocalDate.of(22, 4, 22),
                    LocalDate.of(22, 4, 7), 50.0, 0.0)
    );

        @Test
        public void whenWarehouse() {
            ControlQuality controlQuality = new ControlQuality(new Warehouse(new ArrayList<>()));
            for (Food food : listOfFoods) {
                if (controlQuality.executeStrategyStorageFirst(food)) {
                    controlQuality.executeStrategyStorageSecond(food);
                }
            }
            List<Food> rsl = controlQuality.executeStrategyStorageThird();
            List<Food> expected = List.of(new Fruit("banana",
                    LocalDate.of(22, 5, 4),
                    LocalDate.of(22, 4, 10), 5.0, 0.0));
            assertThat(rsl, is(expected));
        }

    @Test
    public void whenShop() {
        ControlQuality controlQuality = new ControlQuality(new Shop(new ArrayList<>(), 50.0));
        for (Food food : listOfFoods) {
            if (controlQuality.executeStrategyStorageFirst(food)) {
                controlQuality.executeStrategyStorageSecond(food);
            }
        }
        List<Food> rsl = controlQuality.executeStrategyStorageThird();
        List<Food> expected = List.of(new Fruit("orange",
                LocalDate.of(2022, 4, 22),
                LocalDate.of(2022, 4, 1),
                2.0, 0.0),
                new Vegetables("tomato",
                        LocalDate.of(22, 4, 14),
                        LocalDate.of(22, 3, 30), 3.0, 50.0),
                new Meat("beef",
                        LocalDate.of(22, 4, 22),
                        LocalDate.of(22, 4, 7), 50.0, 0.0));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenTrash() {
        ControlQuality controlQuality = new ControlQuality(new Trash(new ArrayList<>()));
        for (Food food : listOfFoods) {
            if (controlQuality.executeStrategyStorageFirst(food)) {
                controlQuality.executeStrategyStorageSecond(food);
            }
        }
        List<Food> rsl = controlQuality.executeStrategyStorageThird();
        List<Food> expected = List.of(
                new Vegetables("potato",
                        LocalDate.of(22, 4, 4),
                        LocalDate.of(22, 3, 10), 1.0, 0.0),
                new Meat("chicken",
                        LocalDate.of(22, 4, 11),
                        LocalDate.of(22, 4, 3), 7.0, 0.0)
        );
        assertThat(rsl, is(expected));
    }

}

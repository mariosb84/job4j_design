package ru.job4j.ood;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.ood.lsp.food.*;
import java.time.LocalDate;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FoodTest {

    List<Storage> storageList;

    @Before
    public void setup() {
         storageList = List.of(
                new Warehouse(),
                new Shop(),
                new Trash()
        );
    }

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
                    LocalDate.of(22, 4, 15),
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
            ControlQuality controlQuality = new ControlQuality(storageList);
            for (Food food : listOfFoods) {
                controlQuality.distribute(food);
            }
            List<Food> expected = List.of(new Fruit("banana",
                    LocalDate.of(22, 5, 4),
                    LocalDate.of(22, 4, 10), 5.0, 0.0));
            List<Food> rsl = storageList.get(0).findAll();
            assertThat(rsl, is(expected));
        }

    @Test
    public void whenShop() {
        ControlQuality controlQuality = new ControlQuality(storageList);
        for (Food food : listOfFoods) {
            controlQuality.distribute(food);
        }
        List<Food> expected = List.of(new Fruit("orange",
                LocalDate.of(2022, 4, 22),
                LocalDate.of(2022, 4, 1),
                2.0, 0.0),
                new Vegetables("tomato",
                        LocalDate.of(22, 4, 15),
                        LocalDate.of(22, 3, 30), 3.0, 50.0),
                new Meat("beef",
                        LocalDate.of(22, 4, 22),
                        LocalDate.of(22, 4, 7), 50.0, 0.0));
        List<Food> rsl = storageList.get(1).findAll();
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenTrash() {
        ControlQuality controlQuality = new ControlQuality(storageList);
        for (Food food : listOfFoods) {
            controlQuality.distribute(food);
        }
        List<Food> expected = List.of(
                new Vegetables("potato",
                        LocalDate.of(22, 4, 4),
                        LocalDate.of(22, 3, 10), 1.0, 0.0),
                new Meat("chicken",
                        LocalDate.of(22, 4, 11),
                        LocalDate.of(22, 4, 3), 7.0, 0.0)
        );
        List<Food> rsl = storageList.get(2).findAll();
        assertThat(rsl, is(expected));
    }

}

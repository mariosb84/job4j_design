package ru.job4j.ood.lsp.food;

import java.time.LocalDate;

public class Freshness {
        public static int getFreshnessOfFood(Food food) {
            int currentNumber = food.getExpiryDate().getDayOfYear() - LocalDate.now().getDayOfYear();
            int shelfLife = food.getExpiryDate().getDayOfYear() - food.getCreateDate().getDayOfYear();
            return ((currentNumber * 100) / shelfLife);
        }
}

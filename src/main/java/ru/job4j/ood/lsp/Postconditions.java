package ru.job4j.ood.lsp;

class Postconditions {

    public int  getInterest(int sum, int month, int rate) {
    /* предусловие*/
    if (sum < 0 || month > 12 || month < 1 || rate < 0) {
        throw new IllegalArgumentException("Некорректные данные");
    }
    int result = sum;
    for (int i = 0; i < month; i++) {
        result += result * rate / 100;
    }
    /* постусловие*/
    if (sum >= 1000) {
        /* добавляем бонус*/
        result += 100;
    }
    return result;
    }
}

class MicroAccount extends Postconditions {

public int getInterest(int sum, int month, int rate) {
        if (sum < 0 || month > 12 || month < 1 || rate < 0) {
            throw new IllegalArgumentException("Некорректные данные");
        }
        int result = sum;
        for (int i = 0; i < month; i++) {
            result += result * rate / 100;
        }
        return result;
          }

    static class Program {
        public static void calculateInterest(Postconditions account) {
            /* 1000 + 1000 * 10 / 100 + 100 (бонус)*/
            int sum = account.getInterest(1000, 1, 10);
            /* ожидаем 1200*/
            if (sum != 1200) {
                throw new IllegalArgumentException("Неожиданная сумма при вычислениях");
            }
        }

        public static void main(String[] args) {
            Postconditions acc = new MicroAccount();
            /* получаем 1100 без бонуса 100
            Ожидаем мы одно поведение,
            а получаем другое,
            так как условие ослаблено*/
            calculateInterest(acc);
        }

    }

}

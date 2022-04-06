package ru.job4j.ood.lsp;

class Preconditions {

    protected int price;

    public Preconditions(int price) {
        this.price = price;
    }

    public void pay(int money) {
        if (money <= 1) {
            throw new IllegalArgumentException("Too little money!");
        }
        /* <= предусловие*/
        if (price > money) {
            throw new IllegalArgumentException("Need more money!");
        }
    }

}

class Buyer extends Preconditions {

    public Buyer(int price) {
        super(price);
    }

    public void pay(int money) {
        if (money <= 1) {
            throw new IllegalArgumentException("Too little money!");
        }
        /*условие усилено*/
        if (price >= money) {
            throw new IllegalArgumentException("Need more money!");
        }
    }

}

class FirstRule {
    public static void main(String[] args) {
        Preconditions buyer = new Buyer(3);
        /*Ожидаем мы одно поведение,
         а получаем другое,
          так как условие усилено*/
        buyer.pay(3);
    }

}

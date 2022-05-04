package ru.job4j.ood.dip.example;

public class Ticket {

private final String ticket;

    public Ticket(String ticket) {
        this.ticket = ticket;
    }
    /*
      Класс Ticket, представляющий продажу билетов, использует для продажи класс BuyForCash.
      При подобном определении класс Ticket зависит от класса BuyForCash. Более того
      мы жестко определили, что продать билет можно только за наличные деньги с помощью класса BuyForCash.
      Другие же варианты, например, покупка онлайн или по карте - все это в данном случае исключено.
      Абстракция продажи билетов не отделена от деталей класса BuyForCash.
      Все это является нарушением принципа инверсии зависимостей.
    * */
    public boolean buy(BuyForCash buy) {
    return buy.buyForCash(ticket, 1000);
}

}

class BuyForCash {

    public boolean buyForCash(String ticket, int cash) {
        return ticket != null && cash > 1000;
    }
}

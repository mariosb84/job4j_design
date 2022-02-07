package ru.job4j.gc;

public class GCOnAuto {
/*-Xmx4m -Xms4m*/
    public static void main(String[] args) {
        GCDemo.info();
        for (int i = 0; i < 4000; i++) {
            /*new User(i, "User_N_");*/
            new User();
            System.out.println(i);
        }
        GCDemo.info();
    }
}
/* User user = new User(1, "Ivan") и User user = new User(1, "IvanIvanovich") (расписать расчет)

User содержит 2 поля и занимает в памяти (12байт заголовок + int 4 байта + ссылка на String 4 байта. Итого 20 + округление к кратности 8 = 24байта :

оба объекта занимают одинаковое количество байт.


После создания объектов в цикле, они попадают в eden, когда eden заполнится,

будет происходить minor GC, для очищения young generation, так как объекты без ссылок .
*/

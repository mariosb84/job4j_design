package ru.job4j.ood.lsp;

 class Invariants {

        protected int capital;

        public Invariants(int sum) {
            if (sum < 100) {
                throw new IllegalArgumentException("Некорректная сумма");
            }
                this.capital = sum;
        }

        public int getCapital() {
             return capital;
        }

        public void setCapital(int value) {
                if (value < 100) {
                    throw new IllegalArgumentException("Некорректная сумма");
                }
                capital = value;
            }

        }


    class MicroInvariants extends Invariants {

    public MicroInvariants(int sum) {
            super(sum);
        }

        public  int getCapital() {
            return capital;
        }

        public void setCapital(int value) {

            /* С точки зрения класса "Invariants" поле не может быть меньше 100,
             и в обоих случаях, где идет присвоение - в конструкторе
             и свойстве это гарантируется. А вот производный класс "MicroInvariants",
              переопределяя свойство "capital", этого уже не гарантирует.
               Поэтому инвариант класса "Invariants" нарушается */

            capital = value;

            }

        }





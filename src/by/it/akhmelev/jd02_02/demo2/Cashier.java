package by.it.akhmelev.jd02_02.demo2;

class Cashier implements Runnable {
    private int number;

    Cashier(int number) {
        this.number=number;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Buyer buyer;
                synchronized (Queues.buyers) {
                    //Проблема №1.
                    //проверку на размер очереди нужно делать ДО извлечения элемента из очереди
                    //Так будет правильнее. Сначала проверка, а уже потом извлечение.
                    //вторую проблему смотрите в классе Queues
                    if (Queues.buyers.size() == 0)
                        break;
                    buyer = Queues.buyers.getFirst();
                }
                System.out.println(buyer + "обслуживается в "+this);
                Thread.sleep(2500);
                //service
                System.out.println(buyer + "обслужен в "+this);

                //обслужен, извлекаем и отпускаем его
                synchronized (buyer = Queues.buyers.pollFirst()) {
                    buyer.notify();
                }
            }
            System.out.println(this+" закрылась");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Runner.countCashiers--;
    }

    @Override
    public String toString() {
        return "Касса №" + number;
    }
}

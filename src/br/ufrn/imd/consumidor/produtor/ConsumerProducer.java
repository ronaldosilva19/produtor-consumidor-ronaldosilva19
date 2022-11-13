package br.ufrn.imd.consumidor.produtor;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ConsumerProducer {
    int capacity = 4;
    BlockingQueue<Integer> numbers = new ArrayBlockingQueue<>(capacity);

    public void Producer() throws InterruptedException{
        int elem = 1;
        while (true)
        {
            synchronized (this)
            {
                while (numbers.size() == capacity){
                    System.out.println("Produtor Dormindo...");
                    wait();
                }
                elem = (int) (Math.random() * 1000);
                this.numbers.add(elem);
                System.out.println("Elemento " + elem + " produzido...");
                notify();
                Thread.sleep(500);
            }
        }
    }

    public void Consumer() throws InterruptedException {
        int elem;
        while(true)
        {
            synchronized (this)
            {
                while (numbers.isEmpty())
                {
                    System.out.println("Consumidor Dormindo...");
                    wait();
                }
                elem = this.numbers.remove();
                System.out.println("Elemento " + elem * 2+ " removido");
                notify();
                Thread.sleep(500);
            }
        }
    }
}


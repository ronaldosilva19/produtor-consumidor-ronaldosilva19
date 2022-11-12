package br.ufrn.imd.consumidor.produtor;
import java.util.concurrent.BlockingQueue;
//import java.util.concurrent.ArrayBlockingQueue;

public class ConsumerProducer {

    public static void Producer(BlockingQueue<Integer> numbers, int size){
        for(int i = 0; i < size; i++){
            int value = (int) (Math.random() * 100);
            numbers.add(value);
        }
        System.out.println(numbers);
    }

    public static void Consumer(BlockingQueue<Integer> numbers){
        System.out.println("Tamanho da fila antes de remover: " + numbers.size());
        while(!numbers.isEmpty()){
            System.out.println("Elemento removido: " + numbers.remove() * 2);
            System.out.println(numbers.size());
        }
    }
}

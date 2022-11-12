package br.ufrn.imd.consumidor.produtor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args){
        int size = 10;
        BlockingQueue<Integer> numbers = new ArrayBlockingQueue<>(size);
        ConsumerProducer.Producer(numbers, size);
        ConsumerProducer.Consumer(numbers);
    }
}

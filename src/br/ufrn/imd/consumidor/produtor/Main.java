package br.ufrn.imd.consumidor.produtor;
public class Main {
    public static void main(String[] args) throws InterruptedException{

        final ConsumerProducer consumerProducer = new ConsumerProducer();
        Thread producer = new Thread(
                () ->
                {
                    try{
                        consumerProducer.Producer();
                    }catch (InterruptedException exception){
                        exception.printStackTrace();
                    }
                }
        );

        Thread consumer = new Thread(
                () ->
                {
                    try{
                        consumerProducer.Consumer();
                    }catch (InterruptedException exception){
                        exception.printStackTrace();
                    }
                }
        );

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}

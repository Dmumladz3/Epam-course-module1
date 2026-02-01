package com.epam.contest.taskThree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class MessageBus {
    private final Queue<Message> queue = new LinkedList<>();
    private final int LIMIT = 10;

    public synchronized void post(Message message) {
        while (queue.size() == LIMIT) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        queue.add(message);
        System.out.println("Bus: Posted to topic [" + message.topic + "]");
        notifyAll(); // Notify consumers that a message is available
    }

    public synchronized Message consume(String interestedTopic) throws InterruptedException {
        while (true) {
            while (queue.isEmpty()) {
                wait(); // Wait if no messages are available
            }

            // Check if the head of the queue matches the consumer's topic
            if (queue.peek().topic.equals(interestedTopic)) {
                Message msg = queue.poll();
                notifyAll(); // Notify producers that space is available
                return msg;
            } else {
                // If it's not the right topic, wait briefly or let others try
                wait(10);
            }
        }
    }
}

class Message {
    String topic;
    String payload;

    Message(String topic, String payload) {
        this.topic = topic;
        this.payload = payload;
    }
}

// 2. Producer Implementation
class Producer implements Runnable {
    private final MessageBus bus;
    private final String[] topics = {"News", "Sports", "Weather"};
    private final Random random = new Random();

    Producer(MessageBus bus) { this.bus = bus; }

    @Override
    public void run() {
        while (true) {
            String topic = topics[random.nextInt(topics.length)];
            String payload = "Data-" + random.nextInt(1000);
            bus.post(new Message(topic, payload));
            try { Thread.sleep(500); } catch (InterruptedException e) { break; }
        }
    }
}

// 3. Consumer Implementation
class Consumer implements Runnable {
    private final MessageBus bus;
    private final String topic;

    Consumer(MessageBus bus, String topic) {
        this.bus = bus;
        this.topic = topic;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Message msg = bus.consume(topic);
                System.out.println("Consumer [" + topic + "] received: " + msg.payload);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MessageBus bus = new MessageBus();

        new Thread(new Producer(bus)).start();
        new Thread(new Consumer(bus, "News")).start();
        new Thread(new Consumer(bus, "Weather")).start();
    }
}
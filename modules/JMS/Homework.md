JMS task

Create demo applications that implements the following order processing flow.

First application read the following order details from console and send it to the order queue (orders):

- User who makes the order

- Type of goods for the order – liquids or countable item

- Volume of order for liquids

- Number of items for countable items

- Order total

Second application should process orders with the following rules:

- If order total greater than some threshold – order should be rejected

- If already ordered more than N litres – order should be rejected

- Summary information for accepted and rejected logs should be passed to another queues or topics.

Third application to log summary about accepted and rejected orders into some file.

Tasks to be implemented

1. Implement the full flow described above – 5 points.

2. Use message selectors to split orders for liquids and countable items – 2 points.

3. Use topics to implement message exchange – 1 points.

4. Show transactions in message processing – 2 points.

5. Show usage of durable topics – extra 2 point.
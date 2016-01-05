package com.som;

import com.som.repository.*;
import com.som.repository.blockdevice.FileDataBlockImpl;
import com.som.service.OrderServiceImpl;
import com.som.service.Service;
import com.som.service.queue.WorkQueue;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Service<Order> orderService = new OrderServiceImpl();
        orderService.setRepository(
            new OrderRepositoryImpl(
                new FileDataBlockImpl(
                    Configuration.databaseLocation)));
        orderService.setQueue( new WorkQueue<Order>() );


        Scanner stdin = new Scanner(System.in);
        String query;


        System.out.println(Configuration.helpMessage);
        while( true ){
            System.out.print(Configuration.commandCharacter);
            query = stdin.nextLine();

            String [] queryTokens = query.split(Configuration.commandDelimiter);
            int queryTokensLength = queryTokens.length;

            System.out.println( "["+queryTokens.length+"]"+"Your input :" + query);
            if ( "add".equalsIgnoreCase(queryTokens[0]) && queryTokensLength > 1 )
            {
                Order order = OrderUtils.convertToUserOrder(queryTokens[1]);
                orderService.addToWorkingQueue(order);
            }
            if ( "delivery".equalsIgnoreCase(queryTokens[0]) )
            {
                System.out.println("all orders have been delivered");
                orderService.processAllOrders();
            }
            if ( "find".equalsIgnoreCase(queryTokens[0]) && queryTokensLength > 1 )
            {
                System.out.println("show order by id");
                System.out.println("================");
                for( Order order : orderService.showOrderID(queryTokens[1]) )
                    System.out.println(order);
            }
            if ( "show".equalsIgnoreCase(queryTokens[0]) )
            {
                System.out.println("Show all orders");
                System.out.println("============");
                for( Order order : orderService.showAll() )
                    System.out.println(order);

            }
            if ( "help".equalsIgnoreCase (queryTokens[0]) ) System.out.println(Configuration.helpMessage);
            if ( "exit".equalsIgnoreCase (queryTokens[0]) ) break;

        }
    }
}

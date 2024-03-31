package command.main;

import model.Order;
import ui.Parser;

import java.util.ArrayList;

public class MainReceiptOrderCommand {
    public static void execute(ArrayList<Order> ordersList, String inputText) {
        String[] indexString = Parser.splitInput(Parser.analyzeInput(inputText), inputText);
        String orderID = indexString[0];
        ordersList.stream()
                .filter(order -> order.getID().equals(orderID))
                .findAny()
                .ifPresentOrElse(x -> {
                    System.out.println(x.getReceipt()); },
                        () -> System.out.println("Order not found"));
    }
}
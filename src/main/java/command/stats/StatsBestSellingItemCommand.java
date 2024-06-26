package command.stats;

import model.Item;
import stats.OrderStatistics;

import java.util.List;

public class StatsBestSellingItemCommand implements StatsCommand {
    /**
     * Prints the best-selling item in the order statistics
     *
     * @param stats OrderStatistics object containing the statistics
     */
    public static void execute(OrderStatistics stats) {
        List<Item> bestSellingItems = stats.getBestSellingItems();
        if (bestSellingItems.isEmpty()) {
            System.out.println("Make some orders to see the best selling items!");
            return;
        }

        System.out.println("Best selling item(s):");
        for (int i = 0; i < bestSellingItems.size(); i++) {
            System.out.println((i + 1) + ". " + bestSellingItems.get(i).getName());
            if (i > 3) {
                System.out.println("Displaying top 3 best selling items...");
                //System.out.println("To view more, please refer to the statistics file");
                break;
            }
        }
    }
}

import java.util.*;

public class OrderPricing {
    private final Map<String, MenuItem> menu;

    public OrderPricing(Map<String, MenuItem> menu) {
        this.menu = menu;
    }

    public SubtotalAndLines compute(List<OrderLine> lines) {
        double subtotal = 0.0;
        List<LineItemView> items = new ArrayList<>();
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            items.add(new LineItemView(item.name, l.qty, lineTotal));
        }
        return new SubtotalAndLines(subtotal, items);
    }

    public static class SubtotalAndLines {
        public final double subtotal;
        public final List<LineItemView> lineItems;

        public SubtotalAndLines(double subtotal, List<LineItemView> lineItems) {
            this.subtotal = subtotal;
            this.lineItems = lineItems;
        }
    }
}

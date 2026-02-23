// Code style adjusted (minor refactor for readability)
import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceStore store;
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;
    private final InvoiceFormatter formatter;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(InvoiceStore store) {
        this.store = store;
        this.taxPolicy = new TaxRules();
        this.discountPolicy = new DiscountRules();
        this.formatter = new InvoiceFormatter();
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        OrderPricing pricing = new OrderPricing(menu);
        OrderPricing.SubtotalAndLines pricingResult = pricing.compute(lines);
        double subtotal = pricingResult.subtotal;
        double taxPct= taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);
        double discount = discountPolicy.discountAmount(customerType, subtotal, lines.size());
        double total = subtotal + tax - discount;
        InvoiceData data = new InvoiceData(invId, pricingResult.lineItems, subtotal, taxPct, tax, discount, total);
        String printable = formatter.format(data);
        System.out.print(printable);
        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}

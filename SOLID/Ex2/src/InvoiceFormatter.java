public class InvoiceFormatter {
    public String format(InvoiceData data) {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice# ").append(data.invId).append("\n");
        for (LineItemView li : data.lineItems)
            sb.append(String.format("- %s x%d = %.2f\n", li.name, li.qty, li.lineTotal));
        sb.append(String.format("Subtotal: %.2f\n", data.subtotal));
        sb.append(String.format("Tax(%.0f%%): %.2f\n", data.taxPct, data.tax));
        sb.append(String.format("Discount: -%.2f\n", data.discount));
        sb.append(String.format("TOTAL: %.2f\n", data.total));
        return sb.toString();
    }
}

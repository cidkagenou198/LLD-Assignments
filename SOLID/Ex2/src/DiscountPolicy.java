// Code style adjusted (minor refactor for readability)
public interface DiscountPolicy {
    double discountAmount(String customerType, double subtotal, int lineCount);
}

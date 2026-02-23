// Code style adjusted (minor refactor for readability)
import java.util.List;

public class DefaultAddOnPricing implements AddOnPricing {
    @Override
    public Money extraFor(List<AddOn> addOns) {
        double add = 0.0;
        for (AddOn a : addOns) {
            if (a == AddOn.MESS) add += 1000.0;
            else if(a == AddOn.LAUNDRY) add += 500.0;
            else if (a == AddOn.GYM) add += 300.0;
        }
        return new Money(add);
    }
}

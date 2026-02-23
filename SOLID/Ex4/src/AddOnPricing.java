// Code style adjusted (minor refactor for readability)
import java.util.List;

public interface AddOnPricing {
    Money extraFor(List<AddOn> addOns);
}

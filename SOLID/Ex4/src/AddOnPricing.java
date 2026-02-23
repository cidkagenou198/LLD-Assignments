import java.util.List;

public interface AddOnPricing {
    Money extraFor(List<AddOn> addOns);
}

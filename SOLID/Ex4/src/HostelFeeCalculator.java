import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final RoomPricing roomPricing;
    private final AddOnPricing addOnPricing;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
        this.roomPricing = new LegacyRoomPricing();
        this.addOnPricing = new DefaultAddOnPricing();
    }

    public void process(BookingRequest req) {
        Money monthly = roomPricing.baseMonthly(req.roomType).plus(addOnPricing.extraFor(req.addOns));
        Money deposit = new Money(5000.00);
        ReceiptPrinter.print(req, monthly, deposit);
        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }
}

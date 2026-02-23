public class LegacyRoomPricing implements RoomPricing {
    @Override
    public Money baseMonthly(int roomType) {
        switch (roomType) {
            case LegacyRoomTypes.SINGLE: return new Money(14000.0);
            case LegacyRoomTypes.DOUBLE: return new Money(15000.0);
            case LegacyRoomTypes.TRIPLE: return new Money(12000.0);
            default: return new Money(16000.0);
        }
    }
}

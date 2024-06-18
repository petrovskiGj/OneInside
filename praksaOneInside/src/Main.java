public class Main {
    public static void main(String[] args) {
        ParkingSlot parkingSlot = new ParkingSlot(2);

        PrepaidRequest prepaidMonthly = new PrepaidRequest(1, "SK200AB", "month");
        PrepaidRequest prepaidYearly = new PrepaidRequest(1, "SK840BT", "year");
        HourlyRequest hourly1 = new HourlyRequest(1, "SK2000CT", 1);
        HourlyRequest hourly2 = new HourlyRequest(1, "BT1000MN", 1);

        parkingSlot.processRequest(prepaidMonthly);
        parkingSlot.processRequest(prepaidYearly);
        parkingSlot.processRequest(hourly1);
        parkingSlot.processRequest(hourly2);

        System.out.println("Total Earnings for the Parking Slot: " + parkingSlot.calculateTotalEarnings());

        ParkingSpace spaceToFree = parkingSlot.findAvailableSpace();
        if (spaceToFree != null) {
            spaceToFree.freeSpace();
        }
        HourlyRequest hourly3 = new HourlyRequest(5, "SK5432BD", 1);
        parkingSlot.processRequest(hourly3);

        System.out.println("Total Earnings for the Parking Slot: " + parkingSlot.calculateTotalEarnings());
    }
}
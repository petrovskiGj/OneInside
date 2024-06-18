import java.util.ArrayList;
import java.util.List;

// Base class for Parking Request
abstract class ParkingRequest {
    private int id;
    private String plateNumber;
    protected double totalCost;

    public ParkingRequest(int id, String plateNumber) {
        this.id = id;
        this.plateNumber = plateNumber;
    }

    public int getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public abstract void calculateTotalCost();
}
//nasleduva od request
class PrepaidRequest extends ParkingRequest {
    private final String categorization;

    public PrepaidRequest(int id, String plateNumber, String categorization) {
        super(id, plateNumber);
        this.categorization = categorization;
        calculateTotalCost();
    }

    @Override
    public void calculateTotalCost() {
        if (categorization.equals("month")) {
            totalCost = 3000.0;
        } else if (categorization.equals("year")) {
            totalCost = 36000.0;
        } else {
            throw new IllegalArgumentException("Invalid categorization: " + categorization);
        }
    }
}

class HourlyRequest extends ParkingRequest {
    private int hours;

    public HourlyRequest(int id, String plateNumber, int hours) {
        super(id, plateNumber);
        this.hours = hours;
        calculateTotalCost();
    }

    @Override
    public void calculateTotalCost() {
        totalCost = hours * 35.0;
    }
}

class ParkingSpace {
    private int parkingId;
    private boolean available;
    private double totalEarnings;

    public ParkingSpace(int parkingId) {
        this.parkingId = parkingId;
        this.available = true;
        this.totalEarnings = 0.0;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void addRequest(ParkingRequest request) {
        if (!available) {
            System.out.println("Parking space " + parkingId + " is not available.");
            return;
        }
        totalEarnings += request.getTotalCost();
        setAvailable(false);
    }

    public void freeSpace() {
        setAvailable(true);
    }
}

class ParkingSlot {
    private List<ParkingSpace> parkingSpaces;

    public ParkingSlot(int numberOfSpaces) {
        parkingSpaces = new ArrayList<>();
        for (int i = 1; i <= numberOfSpaces; i++) {
            parkingSpaces.add(new ParkingSpace(i));
        }
    }

    public ParkingSpace findAvailableSpace() {
        for (ParkingSpace space : parkingSpaces) {
            if (space.isAvailable()) {
                return space;
            }
        }
        return null;
    }

    public void processRequest(ParkingRequest request) {
        ParkingSpace space = findAvailableSpace();
        if (space != null) {
            space.addRequest(request);
        } else {
            System.out.println("No available parking spaces" + request);
        }
    }

    public double calculateTotalEarnings() {
        double totalEarnings = 0.0;
        for (ParkingSpace space : parkingSpaces) {
            totalEarnings += space.getTotalEarnings();
        }
        return totalEarnings;
    }
}



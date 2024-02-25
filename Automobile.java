import java.util.ArrayList;
import java.util.List;

public class Automobile {
    private class MaintenanceRecord {
        private String owner;
        private String time_dd_mm_yyyy;
        private int mileage;
        private String shopName = "vehicle's owner";
        private String[] tasksPerformed;

        public MaintenanceRecord(String owner, String time, int miles, String[] tasks) {
            this.owner = owner;
            this.time_dd_mm_yyyy = time;
            this.mileage = miles;
            this.tasksPerformed = new String[tasks.length];
            // The following is a deep copy just in case Java doesn't automatically
            for (int x = 0; x < tasks.length; x++){this.tasksPerformed[x] = tasks[x];}
        }
        public MaintenanceRecord(String owner, String time, int miles, String shopName, String[] tasks) {
            // overload to make "shopName" an optional argument
            this.owner = owner;
            this.time_dd_mm_yyyy = time;
            this.mileage = miles;
            this.shopName = shopName;
            this.tasksPerformed = new String[tasks.length];
            for (int x = 0; x < tasks.length; x++){this.tasksPerformed[x] = tasks[x];}
        }

        public String getOwner() {return this.owner;}
        public String getDate() {return this.time_dd_mm_yyyy;}
        public int getMiles() {return this.mileage;}
        public String getShop() {return this.shopName;}
        public String[] getTasks() {return this.tasksPerformed;}
        public String getTask(int index) {return this.tasksPerformed[index];}

        @Override
        public String toString() {
            String output = 
                  "Date of maintenance: " + this.time_dd_mm_yyyy + "\n"
                + "Owned by: " + this.owner + "\n"
                + "Vehicle's mileage: " + this.mileage + "\n"
                + "Tasks performed by " + this.shopName + ":\n";
            for (int y = 0; y < this.tasksPerformed.length; y++) {
                String nextTask = 1 + this.tasksPerformed[y] + ";\n";
                output.concat(nextTask);
            }
            output.concat("\n"); // just a little extra visual margin
            return output;
        }
    }

    private String auto_titleStatus;
    private String auto_titleJurisdiction; // which US state title was issued in
    private String auto_currOwner;
    private String auto_currLicenseNum;
    private String auto_dateOfPurchase; // DD_MM_YYYY
    private String[] auto_prevOwners;
    private String[] auto_datesOfPrevPurch; // DD_MM_YYYY
    private String auto_VIN;
    private String auto_make;
    private String auto_model;
    private String auto_modelYear;
    private String auto_color;
    private List<MaintenanceRecord> record = new ArrayList<>();

    public Automobile(String vin, String make, String model, String year, String color) {
        this.auto_VIN = vin; this.auto_make = make; this.auto_model = model;
        this.auto_modelYear = year; this.auto_color = color;
    }
    public Automobile(String make, String model, String year, String color) {
        this.auto_VIN = "N/A"; this.auto_make = make; this.auto_model = model;
        this.auto_modelYear = year; this.auto_color = color;
    }

    public MaintenanceRecord addMaintenanceRecord(
        String owner, String time, int miles, String shopName, String[] tasks
    ){
        this.record.add(new MaintenanceRecord(owner, time, miles, shopName, tasks));
    }
    public MaintenanceRecord addMaintenanceRecord(
        String owner, String time, int miles, String[] tasks
    ){
        this.record.add(new MaintenanceRecord(owner, time, miles, tasks));
    }
}

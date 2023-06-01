public class AddOn {
    private String name;
    private double price;
    private boolean requiresInstallation;

    public AddOn(String name, double price, boolean requiresInstallation) {
        this.name = name;
        this.price = price;
        this.requiresInstallation = requiresInstallation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        // Add validation check for the name (e.g., length, format, etc.)
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // Add validation check for the price (e.g., non-negative, maximum value, etc.)
        this.price = price;
    }

    public boolean requiresInstallation() {
        return requiresInstallation;
    }

    public void setRequiresInstallation(boolean requiresInstallation) {
        this.requiresInstallation = requiresInstallation;
    }

    // Custom calculation method specific to the add-on
    public double calculateTotalPrice(int quantity) {
        // Add custom logic to calculate the total price based on the quantity
        return price * quantity;
    }

    // Custom method to check if the add-on is eligible for a discount
    public boolean isEligibleForDiscount() {
        // Add custom logic to determine if the add-on is eligible for a discount
        // Example: Check if the add-on is a certain type that qualifies for a discount
        return name.equalsIgnoreCase("Window Tinting");
    }
}

package Auth;

public class User {
    private String Name, tableNo;
    private Double totalCost;
    private int userID, quantity, burgerQty, pizzaQty;
    private Boolean auth = false;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTableNo() {
        return tableNo;
    }

    public void setTableNo(String tableNo) {
        this.tableNo = tableNo;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBurgerQty() {
        return burgerQty;
    }

    public void setBurgerQty(int burgerQty) {
        this.burgerQty = burgerQty;
    }

    public int getPizzaQty() {
        return pizzaQty;
    }

    public void setPizzaQty(int pizzaQty) {
        this.pizzaQty = pizzaQty;
    }

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }
}

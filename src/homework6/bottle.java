package homework6;

public class bottle {

    private int availableLiquid;
    private int totalCapacity;
    private boolean open;


    private boolean hasMoreLiquid(){
        return availableLiquid > 0;
    }

    public int getAvailableLiquid(){
        return availableLiquid;
    }

    public int getEmptyCapacity(){
        return totalCapacity-availableLiquid;

    }

    public String open(){
        if(open){
            return "Bottle is already opened";
        }
        open=true;
        return "Bottle is opened";
    }

    public String close(){
        if(!open){
            return "Bottle is already closed";
        }
        open = false;
        return "Bottle is closed";
    }

    public String drink(int liquidToDrink){
        if(liquidToDrink<0){
            return "Quantity to drink must be positive";
        }

        if(!open){
            return "Bottle is not opened";
        }
        if (liquidToDrink > availableLiquid){
            return "Not enough liquid";
        }
        availableLiquid -= liquidToDrink;
        return liquidToDrink + " has been drank";
    }

    public String refill(int liquidToAdd){
        if(liquidToAdd<0){
            return "Quantity to refill must be positive";
        }
        availableLiquid = Math.min(totalCapacity,availableLiquid + liquidToAdd);
        return liquidToAdd + " was added";
    }

    public String refill(){
        int addedLiquid = getEmptyCapacity();
        refill(addedLiquid);
        return "Bottle was filled with " + addedLiquid;
    }
}

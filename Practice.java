interface Car{
    public void park(int locationID);
}
class Practice{
    public static void main(String args[]){
        Car c1=(locationID)->{
            System.out.println("Parkin lot : "+locationID);
        };
        c1.park(1001);
    }
}

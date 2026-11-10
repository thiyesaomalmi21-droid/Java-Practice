interface Car{
   public void park(); 
}
class Practice{
    public static void main(String args[]){
        Car c1=()->{
            System.out.println("Car Parking...");
        };
        
        c1.park();
    }
}

interface Car{
    public void accellerate();
}
class Practice{
    public static void main(String args[]){
        Car c1=()->{
            System.out.println("80kmh-1");
        };
        c1.accellerate();
    }
    
}

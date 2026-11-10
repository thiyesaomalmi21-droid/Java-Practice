interface Car{
    public boolean park();
}
class Practice{
    public static void main(String args[]){
        Car c1=()->{
            return true;
        };
        
        System.out.println(c1.park());
        
        Car c2=()->true;
        System.out.println(c1.park());
    }
}

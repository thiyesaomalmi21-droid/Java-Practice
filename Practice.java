interface Vehicle{
    public void park();
}
class Practice{
    public static void main(String args[]){
       /* Vehicle v1=()->{
            System.out.println("Park 1");
            System.out.println("Park 1");
            System.out.println("Park 1");
        } illegal without the semicolon at the end
        v1.park();*/
        
        Vehicle v1=()->{
            System.out.println("Bus Parking");
        };
        v1.park();
        
        
    }
}

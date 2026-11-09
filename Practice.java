interface Vehicle{
    public void park(int id);
}
class Practice {
    public static void main(String args[]){
        Vehicle v1=(int id)->{
                System.out.println("Car Park id : "+id);
        }; 
        v1.park(1001);
    }
}

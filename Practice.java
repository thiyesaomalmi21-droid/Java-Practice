interface Car{
    public void park(int locationID,String name);
}
class Practice{
    public static void main(String args[]){
        Car c1=(locationID,name)->{
            System.out.println(name+" - Car Park "+locationID);
            
        };
        c1.park(1001,"Stuards");
    }
}

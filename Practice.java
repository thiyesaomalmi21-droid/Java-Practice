interface Vehicle{
    public void park();
}
class Practice{
    public static void main(String args[]){
        Vehicle v1=()->{
            System.out.println("Park 1");
            System.out.println("Park 1");
            System.out.println("Park 1");
        };
        v1.park();
    }
}

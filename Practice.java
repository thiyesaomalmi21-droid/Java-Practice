interface Vehicle{
    public void park();//a abstract method(The only method type that a interface can have) 
}

class Practice{
    public static void main(String args[]){
        Vehicle v1=new Vehicle(){
            public void park(){
                System.out.println("Running the anonymous inner");
            }
        };
        
        v1.park();
    }
    
}

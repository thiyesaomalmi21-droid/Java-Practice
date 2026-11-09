interface Lion{
    public void roar();
}
class Practice{
    public static void main(String args[]){
        Lion l1=new Lion(){
            public void roar(){
                System.out.println("First ROARRRRRR!");
            }
        };
        
        l1.roar();
        
        Lion l2=()->{
                
                System.out.println("Second ROARRRRRR!");
        };
        
        l2.roar();
    }
}

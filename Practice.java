interface Animal{
    public void eat();
}

class Practice{
    public static void main(String args[]){
        Animal a1=new Animal(){
            public void eat(){
                    System.out.println("Dog Eat");
            };
        };
        
        a1.eat();
    }
    
}

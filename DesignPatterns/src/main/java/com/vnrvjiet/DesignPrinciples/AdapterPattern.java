package com.vnrvjiet.DesignPrinciples;
interface Bird 
{  
    public void fly(); 
    public void makeSound(); 
} 
  
class Sparrow implements Bird 
{ 
      public void fly() 
    { 
        System.out.println("Flying"); 
    } 
    public void makeSound() 
    { 
        System.out.println("Chirping"); 
    } 
}  
interface ToyDuck 
{ 
    public void squeak(); 
}  
class PlasticToyDuck implements ToyDuck 
{ 
    public void squeak() 
    { 
        System.out.println("Squeaking"); 
    } 
} 
class BirdAdapter implements ToyDuck 
{  
    Bird bird; 
    public BirdAdapter(Bird bird) 
    { 
        this.bird = bird; 
    } 
  
    public void squeak() 
    {
      bird.makeSound(); 
    } 
} 
class AdapterPattern 
{ 
    public static void main(String args[]) 
    { 
        Sparrow sparrow = new Sparrow(); 
        ToyDuck toyDuck = new PlasticToyDuck(); 
        ToyDuck birdAdapter = new BirdAdapter(sparrow); 
        System.out.println("Sparrow..."); 
        sparrow.fly(); 
        sparrow.makeSound(); 
        System.out.println("Duck..."); 
        toyDuck.squeak(); 
        System.out.println("BirdAdapter..."); 
        birdAdapter.squeak(); 
    } 
}


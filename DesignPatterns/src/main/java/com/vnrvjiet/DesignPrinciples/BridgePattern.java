package com.vnrvjiet.DesignPrinciples;
abstract class Vehicle 
{ 
    protected Workshop workShop1; 
    protected Workshop workShop2; 
    protected Vehicle(Workshop workShop1, Workshop workShop2) 
    { 
        this.workShop1 = workShop1; 
        this.workShop2 = workShop2; 
    } 
    abstract public void manufacture(); 
}
class Cycle extends Vehicle
{ 
    public Cycle(Workshop workShop1, Workshop workShop2) 
    { 
        super(workShop1, workShop2); 
    }
    public void manufacture() 
    { 
        System.out.print("Cycle "); 
        workShop1.work(); 
        workShop2.work(); 
    } 
} 
class Machine extends Vehicle
{ 
    public Machine(Workshop workShop1, Workshop workShop2) 
    { 
        super(workShop1, workShop2); 
    }
    public void manufacture() 
    { 
        System.out.print("Machine "); 
        workShop1.work(); 
        workShop2.work(); 
    } 
}
interface Workshop 
{ 
    abstract public void work(); 
}  
class Produce implements Workshop { 
    @Override
    public void work() 
    { 
        System.out.print("Produced"); 
    } 
} 
class Assemble implements Workshop 
{ 
    public void work() 
    { 
        System.out.print(" And"); 
        System.out.println(" Manufactured."); 
    } 
} 
public class BridgePattern {
	public static void main(String[] args) 
    { 
        Vehicle vehicle1 = new Cycle(new Produce(), new Assemble()); 
        vehicle1.manufacture(); 
        Vehicle vehicle2 = new Machine(new Produce(), new Assemble()); 
        vehicle2.manufacture(); 
    } 

}

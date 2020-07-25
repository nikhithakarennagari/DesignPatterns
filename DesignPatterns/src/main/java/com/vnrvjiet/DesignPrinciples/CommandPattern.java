package com.vnrvjiet.DesignPrinciples;

interface Command 
{ 
    public void execute(); 
}
 class Dog 
{ 
    public void run() 
    { 
        System.out.println("Dog runs"); 
    } 
    public void stop() 
    { 
        System.out.println("Dog stops"); 
    } 
} 
class DogOnCommand implements Command 
{ 
    Dog dog; 
    public DogOnCommand(Dog dog) 
    { 
       this.dog = dog; 
    } 
    public void execute() 
    { 
       dog.run(); 
    } 
} 
class DogOffCommand implements Command 
{ 
	Dog dog; 
    public DogOffCommand(Dog dog)
    { 
        this.dog = dog; 
    } 
    public void execute() 
    { 
         dog.stop(); 
    } 
}
class Stereo 
{ 
    public void on() 
    { 
        System.out.println("Stereo went on"); 
    } 
    public void off() 
    { 
        System.out.println("Stereo went off"); 
    } 
    public void setCD() 
    { 
        System.out.println("Stereo is set " + " for CD input"); 
    } 
    public void setDVD()
    { 
        System.out.println("Stereo is set "+ " for DVD input"); 
    } 
    public void setRadio() 
    { 
        System.out.println("Stereo is set" + " for Radio"); 
    } 
    public void setVolume(int volume) 
    {
       System.out.println("Stereo volume set"+ " to " + volume); 
    } 
} 
class StereoOffCommand implements Command 
{ 
    Stereo stereo; 
    public StereoOffCommand(Stereo stereo) 
    { 
        this.stereo = stereo; 
    } 
    public void execute() 
    { 
       stereo.off(); 
    } 
} 
class StereoOnWithCDCommand implements Command 
{ 
     Stereo stereo; 
     public StereoOnWithCDCommand(Stereo stereo) 
     { 
         this.stereo = stereo; 
     } 
     public void execute() 
     { 
         stereo.on(); 
         stereo.setCD(); 
         stereo.setVolume(100); 
     } 
} 
class SimpleRemoteControl 
{ 
    Command slot;   
    public SimpleRemoteControl() 
    { 
    } 
  public void setCommand(Command command) 
    { 
        slot = command; 
    } 
     public void buttonWasPressed() 
    { 
        slot.execute(); 
    } 
}
class CommandPattern
{ 
    public static void main(String[] args) 
    { 
        SimpleRemoteControl remote = new SimpleRemoteControl(); 
        Dog dog = new Dog(); 
        Stereo stereo = new Stereo(); 
        remote.setCommand(new DogOnCommand(dog)); 
        remote.buttonWasPressed(); 
        remote.setCommand(new StereoOnWithCDCommand(stereo)); 
        remote.buttonWasPressed(); 
        remote.setCommand(new StereoOffCommand(stereo)); 
        remote.buttonWasPressed(); 
     } 
  }
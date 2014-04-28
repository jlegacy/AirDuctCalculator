package pkg.example.airductcalculator;

public class ImperialFriction {
	private static ImperialFriction instance;
	 
	   // Global variable
	   private double data;
	 
	   // Restrict the constructor from being instantiated
	   private ImperialFriction(){}
	 
	   public void setData(double d){
	     this.data=d;
	   }
	   public double getData(){
	     return this.data;
	   }
	 
	   public static synchronized ImperialFriction getInstance(){
	     if(instance==null){
	       instance=new ImperialFriction();
	     }
	     return instance;
	   }

}

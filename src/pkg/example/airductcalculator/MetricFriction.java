package pkg.example.airductcalculator;

public class MetricFriction {
	private static MetricFriction instance;
	 
	   // Global variable
	   private int data;
	 
	   // Restrict the constructor from being instantiated
	   private MetricFriction(){}
	 
	   public void setData(int d){
	     this.data=d;
	   }
	   public int getData(){
	     return this.data;
	   }
	 
	   public static synchronized MetricFriction getInstance(){
	     if(instance==null){
	       instance=new MetricFriction();
	     }
	     return instance;
	   }

}

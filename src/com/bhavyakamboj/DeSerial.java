import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public	class DeSerial implements Serializable, Cloneable
	{ 
	    private String name; 
	    DeSerial(String name) 
	    { 
	        this.name = name; 
	    } 
	    
	    public String getName() {
	    	return this.name;
	    }
	    
	    @Override
	    protected Object clone() throws CloneNotSupportedException
	    {
			return super.clone();
	    	
	    }
	  
	    public static void main(String[] args) 
	    { 
	        try
	        { 
	        	DeSerial d = 
	                    new DeSerial("GeeksForGeeks"); 
	            FileOutputStream f = new FileOutputStream("file.txt"); 
	            ObjectOutputStream oos = new ObjectOutputStream(f); 
	            oos.writeObject(d); 
	            oos.close(); 
	            f.close(); 
	            DeSerial cloned = (DeSerial) d.clone();
	            System.out.println("Cloned object:"+cloned.getName());
	            
	        } 
	        catch (Exception e) 
	        { 
	            e.printStackTrace(); 
	        } 
	    } 
	} 

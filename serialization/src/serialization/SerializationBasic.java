package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class SerializationBasic {
	/* Serialization is the mechanism of converting the state of object into byte stream.
	 * Deserialization is the reverse process where the byte stream is used to recreate the actual java
	 * object. this mechanism is used to persists the java object.  
	 * 
	 * Byte stream created is platform independent. So, the object serialized on one platform can be 
	 * deserialized on different platform.
	 * 
	 * To make a java serializable we implement java.io.Serializable interface.
	 * 
	 * The ObjectOutputStream class contains writeObject() to serialize an object.
	 * 
	 * The ObjectInputStream contains readObject() to de-serialize an object.
	 * 
	 * Serializable is a marker interface (has no data member and method). It is used to “mark” java classes
	 *  so that objects of these classes may get certain capability*/
	
	public static void main(String[] args) {
		Demo object = new Demo(1,"rakib");
		String fileName = "file.ser";
		
		// Serializaton
		try {
			FileOutputStream file = new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(object);
			out.close();
			file.close();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		System.out.println("the object is serialized");
		
		Demo object1 = null;
		
		try {
			FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in =new ObjectInputStream(file);
			
			object1 = (Demo)in.readObject();
			in.close();
			file.close();
			
			System.out.println(object1.a);
			System.out.println(object1.b);
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	
}


class Demo implements Serializable{
	int a;
	String b;
	
	Demo(int a, String b){
		this.a=a;
		this.b=b;
		
	}
}
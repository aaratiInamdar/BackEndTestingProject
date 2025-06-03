package com.Practice.Serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Run2_DeSerialization {
	
	
	
public static void main(String[] args) throws Throwable {
	
	
	FileInputStream fis=new FileInputStream("./file.text");
	
	ObjectInputStream objIn=new ObjectInputStream(fis);
	
//	 we have to downcast the objIn bcz it is a supermost class so in order to read the file we have to downcast
	NFSGame user1Obj= (NFSGame) objIn.readObject();
	
	System.out.println(user1Obj.name);
	System.out.println(user1Obj.level);
	System.out.println(user1Obj.score);
	System.out.println(user1Obj.life);
}
	
}

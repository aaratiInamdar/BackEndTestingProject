package com.Practice.Serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class NFSGame implements Serializable{
	
	String name;
	int level;
	long score;
	int life;
	
	public NFSGame(String name, int level, long score, int life)
	{
		super();
		this.name=name;
		this.level=level;
		this.score=score;
		this.life=life;
	}	
}

public class Run_Serialization {
	
	public static void main(String[] args) throws Throwable {
		
		NFSGame user1=new NFSGame("Aarati", 30, 50600, 9);
		FileOutputStream fos=new FileOutputStream("./file.text");
		
		ObjectOutputStream objOut=new ObjectOutputStream(fos);
		objOut.writeObject(user1);
		System.out.println("===END==");
		
	}
}

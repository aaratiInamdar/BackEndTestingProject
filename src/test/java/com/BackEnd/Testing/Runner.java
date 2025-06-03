package com.BackEnd.Testing;

import org.testng.annotations.Test;

import Pack.Demo;


public class Runner {

	@Test
	public void sampelTest()
	{
		Demo d1=new Demo();
		d1.a().b().c().d();
		
	}
}

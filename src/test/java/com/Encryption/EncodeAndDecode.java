package com.Encryption;

import java.util.Base64;
import org.testng.annotations.Test;

public class EncodeAndDecode {

	@Test
	public void sampleTest()
	{
		String encodedData=new String(Base64.getEncoder().encode("AARATI".getBytes()));
		System.out.println(encodedData);
		
		String decodedData=new String(Base64.getDecoder().decode(encodedData.getBytes()));
		System.out.println(decodedData);
		
	}
}

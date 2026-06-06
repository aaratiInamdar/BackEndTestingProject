package com.Encryption;

import org.testng.annotations.Test;
import com.EncryptAndDecriptUtility.EncryptAndDecriptUtility;

public class AESEnpTest {
//	Symmetric encryption 
	@Test
	public void sampleTest() throws Exception
	{
		String privateKey="Ac03tEam@j!tu_#1";
		String data="Aarati";
		String data2="{\"name\": \"aarati\", \"id\" : \"tp01\"}";
		
		EncryptAndDecriptUtility ed=new EncryptAndDecriptUtility();
		System.out.println(ed.encrypt(data, privateKey));
		System.out.println(ed.encrypt(data2, privateKey));
		
		System.out.println(ed.decrypt("18CD65O8vfBmM7Z6ppT+YQ==", privateKey));
		System.out.println(ed.decrypt("Fi4cyY/N0obQq/wK/E+YJETxN4IF2iFvPQhoJ7hNFkQe0Neyn200ATV2lvnP3VT2", privateKey));
	}
}

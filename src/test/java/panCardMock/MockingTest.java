package panCardMock;
import org.mockito.Mockito;

class PANCard {
	public String isValid(String panCard) {
//		pan card having 5 capitals letters and 4 numbers and one letter at the end so we put this condition 
		if (panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]") == true) {
			return "is valid pan";
		} else {
			return "is not valid pan";
		}
	}

//	            stub method or we can say STUB 
	public static PANCard getMockObject() {
		PANCard mockObj = Mockito.mock(PANCard.class);

//		using when()method will provide dummy data to the method 
		Mockito.when(mockObj.isValid("ABCDE1234A")).thenReturn("Valid PAN Card");
		Mockito.when(mockObj.isValid("FGHIJ4567B")).thenReturn("Valid PAN Card");
		Mockito.when(mockObj.isValid("ABCDE123467A")).thenReturn("InValid PAN Card");
		return mockObj;
	}
}

public class MockingTest {
	public static void main(String[] args) {
//		System.out.println(PANCard.isValid("ABCDE1234A"));
		PANCard obj = PANCard.getMockObject();
		System.out.println(obj.isValid("ABCDE1234A"));
	}
}

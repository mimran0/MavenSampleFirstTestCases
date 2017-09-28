import org.testng.annotations.Test;

public class Priotization {
	@Test(priority = 0)
	public void A() {
		System.out.println("This is sub-procudure/method A");
	}

	@Test(enabled = false)
	public void B() {
		System.out.println("This is sub-procudure/method B");
	}

	@Test(priority = 5)
	public void C() {
		System.out.println("This is sub-procudure/method C");
	}

	@Test(priority = 2)
	public void D() {
		System.out.println("This is sub-procudure/method D");
	}

	@Test(priority = 3)
	public void E() {
		System.out.println("This is sub-procudure/method E");
	}

	@Test(priority = 1)
	public void F() {
		System.out.println("This is sub-procedure/method F");

	}

	@Test(priority = 6)
	public void G() {
		System.out.println("This is sub-procudure/method G");

	}

}

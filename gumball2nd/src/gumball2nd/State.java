package gumball2nd;

public interface State {
	
	public void insertCoin(int i);

	public void ejectCoin();

	public void turnCrank();

	public void dispense();

}
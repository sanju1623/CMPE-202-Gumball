package gumball2nd;

public class HasCoinState implements State {
	GumballMachine gumballMachine;
	int amount=0;
	int machine=0;
	public HasCoinState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
		}
	public void insertCoin(int i) {
	
		this.amount=i;
		this.machine++;
		gumballMachine.setState(gumballMachine.getHasQuarterState()); 
		
	}
	public void ejectCoin() {
		if(this.amount<25 || ( this.amount==25 && this.machine>0))
			System.out.println("Please collect back your coins, amount not sufficient");
			
		if(this.amount>50 || this.amount<50 && this.amount>25)
		{
			int balance=0;
			if(this.amount>50)
		balance=this.amount-50;
			else 
		balance=this.amount;		
		if(balance==5)
		System.out.println("Inserted extra amount. Please collect back one Nickel");
		else if(balance==10)
			System.out.println("Inserted extra amount. Please collect one Dime");
		else if(balance==25)
			System.out.println("Inserted extra . Please collect one Quarter");
		else 
			System.out.println("Please collect back your " +balance+" cents, Not Sufficient");
		}
		else
		gumballMachine.setState(gumballMachine.getNoCoinState());
	}
	public void turnCrank() {
		
		if(this.amount>=50)
	{
		
		System.out.println("You turned...");
		gumballMachine.ejectCoin();
		gumballMachine.setState(gumballMachine.getSoldState());
	}
	else if(this.machine==0 && gumballMachine.amount==25)
	{
		System.out.println("You turned....");
		gumballMachine.setState(gumballMachine.getSoldState());	
	}
//	else if(this.amount==25)
//	{
//		System.out.println("You turned....");
//		gumballMachine.setState(gumballMachine.getSoldState());	
//    }
	else if(this.amount<25  || (this.amount>25 && this.amount<50) || (this.amount<=25 && this.machine>0))
	{
		gumballMachine.ejectCoin();
		gumballMachine.setState(gumballMachine.getNoCoinState());	
	}  	
//		else if(this.amount<50 && this.amount>25 && this.machine>1)
//	{
//		
//		gumballMachine.setState(gumballMachine.getSoldState());
//		
//	}
//		
		this.machine=0;
	this.amount=0;
	}
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
	public String toString() {
		return "waiting for turn of crank";
	}
}
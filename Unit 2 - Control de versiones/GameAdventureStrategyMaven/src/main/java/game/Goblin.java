package game;

public class Goblin extends Character
{

    public Goblin(WeaponBehaviour w)
    {
	super(w);
    }

    @Override
    public void display()
    {
	// TODO Auto-generated method stub
	System.out.println("You are a nasty evil goblin.");
    }
}

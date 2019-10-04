package game;

public class Paladin extends Character
{

    public Paladin(WeaponBehaviour w)
    {
	super(w);
    }

    @Override
    public void display()
    {
	// TODO Auto-generated method stub
	System.out.println("You are a holy paladin, slayer of evil.");
    }
}

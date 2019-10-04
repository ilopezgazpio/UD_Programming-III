package game;

public class Sword implements WeaponBehaviour
{

    @Override
    public void display()
    {
	// TODO Auto-generated method stub
	System.out.println ("A very dull knife.");
    }

    @Override
    public void useWeapon()
    {
	// TODO Auto-generated method stub
	System.out.println("You slash madly with your sword.");
    }
}


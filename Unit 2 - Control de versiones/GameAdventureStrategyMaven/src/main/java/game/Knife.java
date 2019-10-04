package game;

public class Knife implements WeaponBehaviour
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
	System.out.println("You stab wildly with your knife.");
    }
}


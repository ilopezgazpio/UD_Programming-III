package game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Character
{
    final Logger logger = LoggerFactory.getLogger(Character.class);
    private WeaponBehaviour weapon;

    /**
     * Constructor of Character thar receives as argument a WeaponBehaviour.
     *
     * @param w Weapon with which the Character will fight
     */
    public Character(WeaponBehaviour w)
    {
	weapon = w;
    }

    /**
     * Returns the weapon associated to a Character
     *
     * @return            the Weapon associated to a Character
     */
    public WeaponBehaviour getWeapon()
    {
	return weapon;
    }

    /**
     * Assigns a WeaponBehaviour to a Character
     *
     * @param w Weapon with which the Character will fight
     */
    public void setWeapon(WeaponBehaviour w)
    {
	logger.info("Let´s change our weapons ...");
	weapon = w;
    }

    public void fight()
    {
	weapon.useWeapon();
    }

    public abstract void display();
}

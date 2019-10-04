package game;

import org.junit.Before;
import org.junit.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author
 * @version
 * @since
 * <p> This program tests all the functionality of a GameStrategy Game, where there are different Character types (e.g. Barbarian, Gobling, King or Paladin) which can use several types of Weapon (e.g. Crossbow, Knife, Sword), where a weapon can have distinct WeaponBehaviour. </p>
 *
 */
public class GameTest
{
    private Character character;
    final Logger logger = LoggerFactory.getLogger(GameTest.class);
    static int iteration = 0;

    /**
     * Sets up the test by instantiating a new Character of type Paladin with WeaponBehaviour Sword.
     */
    @Before public void setUp()
    {
	logger.info("Entering setUp: {}", iteration++);
	this.character = new Paladin(new Sword());
	logger.info("Leaving setUp");
    }

    /**
     * Tests all the operations that can be executed over a Character, e.g. Character.flight(), Character.display() or Character.setWeapon()
     */
    @Test public void testGame()
    {
	this.character.display();
	this.character.fight();

	// Change the Paladin's weapon at run-time.
	this.character.setWeapon(new Crossbow());
	this.character.fight();

	// Another Character
	this.character = new Goblin(new Knife());
	this.character.display();
	this.character.fight();

	// Change the Goblin's weapon at run-time.
	this.character.setWeapon(new Sword());
	this.character.fight();
    }

}

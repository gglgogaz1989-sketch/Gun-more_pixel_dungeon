package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import java.util.ArrayList;

// Имя класса теперь Bullet, чтобы совпадать с именем файла и запросами из Catalog/Generator
public class Bullet extends Item {

	{
		image = 125;
		stackable = true;
	}
	
	@Override
	public ArrayList<String> actions( Hero hero ) {
		return super.actions( hero );
	}
	
	@Override
	public void execute( Hero hero, String action ) {
		super.execute( hero, action );
	}
	
	@Override
	public boolean isUpgradable() {
		return false;
	}
	
	@Override
	public boolean isIdentified() {
		return true;
	}
	
	@Override
	public int value() {
		return 10 * quantity;
	}
}

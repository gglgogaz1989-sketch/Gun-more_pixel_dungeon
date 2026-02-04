package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class IronShield extends MeleeWeapon {

	{
		// Текстура ростового щита
		image = ItemSpriteSheet.GREATSHIELD;
		tier = 5;
	}

	@Override
	public int max(int lvl) {
		return  Math.round(3f*(tier+1)) + lvl*(tier-1);
	}

	@Override
	public int defenseFactor( Char owner ) {
		return DRMax();
	}

	public int DRMax(){
		return DRMax(buffedLvl());
	}

	public int DRMax(int lvl){
		return 8 + 2*lvl;
	}

	@Override
	protected void duelistAbility(Hero hero, Integer target) {
		RoundShield.guardAbility(hero, 4+buffedLvl(), this);
	}

	@Override
	public int value() {
		return 500;
	}
}

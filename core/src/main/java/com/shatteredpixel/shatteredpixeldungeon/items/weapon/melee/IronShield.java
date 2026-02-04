package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class IronShield extends MeleeWeapon {

	{
		// Используем текстуру ростового щита, как ты и хотел
		image = ItemSpriteSheet.GREATSHIELD;

		tier = 5;
	}

	@Override
	public int max(int lvl) {
		// Характеристики урона как у топового щита
		return  Math.round(3f*(tier+1)) + lvl*(tier-1);
	}

	@Override
	public int defenseFactor( Char owner ) {
		return DRMax();
	}

	public int DRMax(){
		return DRMax(buffedLvl());
	}

	// Повышенная защита (8 базы вместо 6 у обычного щита)
	public int DRMax(int lvl){
		return 8 + 2*lvl;
	}

	@Override
	protected void duelistAbility(Hero hero, Integer target) {
		// Способность дуэлянта (блок)
		RoundShield.guardAbility(hero, 4+buffedLvl(), this);
	}

	@Override
	public boolean isUpgradable() {
		return true;
	}

	@Override
	public int value() {
		return 500; // Цена в магазине
	}
}

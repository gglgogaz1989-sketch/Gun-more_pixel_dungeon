package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;

public class IronShield extends MeleeWeapon {

	{
		image = 101; 
		tier = 5;
	}

	public IronShield() {
		super(); // Теперь без аргументов
	}

	@Override
	public int max(int lvl) {
		// Чтобы получить около 60 урона на 5 тире:
		return 70 + lvl * tier;
	}

	// Убираем @Override, если движок ругается. 
	// В SPD min обычно вычисляется сам, но можно оставить так:
	public int min(int lvl) {
		return 60 + lvl * 2;
	}

	@Override
	public int defenseFactor( Char owner ) {
		return DRMax();
	}

	public int DRMax(){
		return DRMax(buffedLvl());
	}

	public int DRMax(int lvl){
		return 10 + 4*lvl;
	}

	@Override
	public String name() {
		return "Железный щит";
	}

	@Override
	public String desc() {
		return "Огромный щит из литого железа. Он поглощает урон.";
	}
}

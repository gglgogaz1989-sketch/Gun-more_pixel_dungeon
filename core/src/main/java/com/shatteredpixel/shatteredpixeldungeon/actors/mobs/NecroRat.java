package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Charm;
import com.shatteredpixel.shatteredpixeldungeon.sprites.NecroRatSprite;
import com.watabou.utils.Random;

public class NecroRat extends Rat {

	{
		// Привязываем спрайт
		spriteClass = NecroRatSprite.class;

		HP = HT = 16;
		defenseSkill = 4;
		EXP = 3;
	}

	@Override
	public int attackProc( Char enemy, int damage ) {
		int actualDamage = super.attackProc( enemy, damage );
		
		// Если урон > 0, с шансом 50% накладываем Charm
		if (actualDamage > 0 && Random.Int( 2 ) == 0) {
			// Накладываем бафф Charm на врага. Источник — эта крыса (this)
			Buff.affect( enemy, Charm.class ).set( Random.NormalFloat(3, 5) );
		}
		
		return actualDamage;
	}
}

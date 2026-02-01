package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.sprites.NecroRatSprite;

public class NecroRat extends Rat {

	{
		// Привязываем наш розовоглазый спрайт
		spriteClass = NecroRatSprite.class;

		// Характеристики (сильнее обычной крысы)
		HP = HT = 18;
		defenseSkill = 4;
		EXP = 3;
	}
}

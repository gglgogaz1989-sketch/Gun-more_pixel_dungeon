package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.sprites.BallonSprite;

public class Ballon extends Mob {

	{
		// Привязываем спрайт
		spriteClass = BallonSprite.class;

		// Характеристики
		HP = HT = 1;
		EXP = 0;
		
		// Обычное поведение: он будет ходить и преследовать игрока, если увидит
		state = WANDERING;
	}

	@Override
	public String name() {
		return "Ballon";
	}

	@Override
	public String description() {
		return "A festive red balloon. It looks harmless.";
	}

	// Точность атаки (0 - почти всегда промахивается, 1 - попадает часто)
	@Override
	public int attackSkill(com.shatteredpixel.shatteredpixeldungeon.actors.Char target) {
		return 0;
	}

	// Урон 0-0
	@Override
	public int damageRoll() {
		return 0;
	}

	// Защита (уклонение)
	@Override
	public int defenseSkill(com.shatteredpixel.shatteredpixeldungeon.actors.Char enemy) {
		return 0;
	}

	// Скорость передвижения (1f - стандарт)
	@Override
	public float speed() {
		return 1f;
	}
}

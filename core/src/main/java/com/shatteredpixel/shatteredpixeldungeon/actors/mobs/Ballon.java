package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.sprites.BallonSprite;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfExperience;
import com.watabou.utils.Random;

// Наследуемся от Mob — это база для всех врагов
public class Ballon extends Mob {

	{
		// Привязываем твой спрайт
		spriteClass = BallonSprite.class;

		// Устанавливаем здоровье
		HP = HT = 1;
		
		// Опыт (0, чтобы не качаться на шариках бесконечно)
		EXP = 0;
        
        // Описание и имя для журнала (бестиария)
        // Если этого не будет, игра может вылететь при попытке посмотреть на моба
        state = PASSIVE;
	}

	@Override
	public String name() {
		return "Праздничный Шарик";
	}

	@Override
	public String description() {
		return "Яркий красный шарик. Кажется, если его лопнуть, внутри будет подарок!";
	}

	// Делаем так, чтобы он вообще не мог атаковать
	@Override
	public int attackSkill(com.shatteredpixel.shatteredpixeldungeon.actors.Char target) {
		return 0;
	}

	@Override
	public int damageRoll() {
		return 0;
	}

	// Шарик не должен двигаться сам по себе
	@Override
	public boolean act() {
		spend( TICK );
		return true;
	}

	@Override
	public void die(Object cause) {
		// Вызываем стандартную смерть (чтобы сработала анимация BallonSprite)
		super.die(cause);

		// Дроп подарков с твоими правильными названиями классов
		if (Random.Int(2) == 0) {
			Dungeon.level.drop(new PotionOfHealing(), pos).sprite.drop();
		} else {
			Dungeon.level.drop(new PotionOfExperience(), pos).sprite.drop();
		}
	}
}

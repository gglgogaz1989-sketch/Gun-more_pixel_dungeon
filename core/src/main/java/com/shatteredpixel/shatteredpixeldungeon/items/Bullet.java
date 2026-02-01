package com.shatteredpixel.shatteredpixeldungeon.items;

import com.watabou.utils.Random;

public class Bullet extends Item {

	public Bullet() {
		// В Shattered PD имя часто задается так:
		image = 100;
		stackable = true;
	}

	@Override
	public Item random() {
		quantity = Random.IntRange(30, 60);
		return this;
	}

	@Override
	public String info() {
		return "Тяжелый золотой патрон. Стакается в инвентаре и ждет своего часа.";
	}
}

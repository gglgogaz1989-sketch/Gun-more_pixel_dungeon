package com.shatteredpixel.shatteredpixeldungeon.items;

import com.watabou.utils.Random;

public class Bullet extends Item {

	public Bullet() {
		name = "Золотой патрон";
		image = 100; // Если иконка будет "невидимой", попробуй поставить 100
		stackable = true;
	}

	@Override
	public Item random() {
		quantity = Random.IntRange(30, 60);
		return this;
	}

	@Override
	public String info() {
		return "Тяжелый золотой патрон. Пока что просто занимает место, но скоро пригодится для стрельбы.";
	}
}

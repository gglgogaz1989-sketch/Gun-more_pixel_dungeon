package com.shatteredpixel.shatteredpixeldungeon.items;

import com.watabou.utils.Random;

public class Bullet extends Item {

	public Bullet() {
		// Мы не присваиваем напрямую, а вызываем свойства
		stackable = true;
		image = 120;
	}
	
	@Override
	public String Name() {
		return "Золотой патрон";
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

package com.shatteredpixel.shatteredpixeldungeon.items;

import com.watabou.utils.Random;

public class Bullet extends Item {

	public Bullet() {
		super(); // Вызываем конструктор родителя на всякий случай
		this.name = "Золотой патрон";
		this.image = 100; 
		this.stackable = true;
	}

	@Override
	public Item random() {
		this.quantity = Random.IntRange(30, 60);
		return this;
	}

	@Override
	public String info() {
		return "Тяжелый золотой патрон. Стакается в инвентаре и ждет своего часа.";
	}
}

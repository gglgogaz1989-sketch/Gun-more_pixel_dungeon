package com.shatteredpixel.shatteredpixeldungeon.items;

import com.watabou.utils.Random;

// Обязательно наследуем Item
public class Bullet extends Item {

    // Это конструктор - он ОБЯЗАТЕЛЕН
    public Bullet() {
        name = "Золотой патрон";
        image = 120; 
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

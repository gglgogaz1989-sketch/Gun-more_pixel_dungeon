package com.shatteredpixel.shatteredpixeldungeon.items;

import com.watabou.utils.Random;

public class Bullet extends Item {
    {
        name = "Золотой патрон";
        image = 127; // Твой индекс из атласа
        stackable = true;
    }

    @Override
    public Item random() {
        quantity = Random.IntRange(30, 60); // Случайное число от 30 до 60
        return this;
    }

    @Override
    public String info() {
        return "Тяжелый золотой патрон. Выглядит слишком ценным, чтобы просто им выстрелить, но выбора нет.";
    }
}

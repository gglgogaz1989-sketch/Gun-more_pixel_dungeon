package com.shatteredpixel.shatteredpixeldungeon.items;

import com.watabou.utils.Random;

// Мы ДОЛЖНЫ написать "extends Item", чтобы игра поняла, что это предмет
public class Bullet extends Item {

    public Bullet() {
        // Устанавливаем свойства внутри конструктора
        name = "Золотой патрон";
        image = 127; 
        stackable = true;
    }

    @Override
    public Item random() {
        quantity = Random.IntRange(30, 60);
        return this;
    }

    @Override
    public String info() {
        return "Тяжелый золотой патрон. Выглядит слишком ценным, чтобы просто им выстрелить, но выбора нет.";
    }
}

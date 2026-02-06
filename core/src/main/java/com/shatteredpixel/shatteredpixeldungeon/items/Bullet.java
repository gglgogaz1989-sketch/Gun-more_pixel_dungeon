package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;

public class Bullet extends Item {

    {
        // Текстура на координатах 209x17
        image = 29; 
        stackable = true;
    }

    @Override
    public String name() {
        return "Пуля";
    }

    // Используем механику урона как в кунае
    @Override
    public int damageRoll(Char owner) {
        // Рандом от 10 до 20 через встроенный метод героя
        return Hero.heroDamageIntRange(10, 20);
    }

    @Override
    public String desc() {
        return "Тяжелый металлический снаряд. Наносит 10-20 урона при броске.";
    }
}

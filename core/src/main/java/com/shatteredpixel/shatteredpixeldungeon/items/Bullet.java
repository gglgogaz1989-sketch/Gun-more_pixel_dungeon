package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;

public class Bullet extends Item {

    {
        // Индекс для координат 209x17
        image = 29; 
        stackable = true;
    }

    @Override
    public String name() {
        return "Пуля";
    }

    // Для обычных предметов (Item) урон при броске задается этим методом
    @Override
    public int thrownDamage(Hero hero, Char target) {
        return Hero.heroDamageIntRange(10, 20);
    }

    @Override
    public String desc() {
        return "Тяжелый металлический снаряд. Наносит 10-20 урона при броске.";
    }
}

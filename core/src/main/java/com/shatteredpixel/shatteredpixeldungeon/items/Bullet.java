package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.utils.Random;

public class Bullet extends Item {

    public Bullet() {
        super();
        image = 29; // Твоя текстура
        stackable = true;
    }

    @Override
    public String name() {
        return "Пуля";
    }

    // Этот метод отвечает за урон при броске во врага
    @Override
    public int damageRoll(Char shooter, Char target) {
        // Рандом от 10 до 20
        return Random.Int(10, 20);
    }

    @Override
    public String desc() {
        return "Тяжелый металлический снаряд. При броске наносит 10-20 урона.";
    }
}

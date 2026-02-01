package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class Bullet extends Item {
    {
        // Имя и описание
        name = "Золотой патрон";
        // Номер иконки в атласе (нужно посчитать точный индекс в твоем файле)
        image = 127; 
        stackable = true;
    }

    @Override
    public String info() {
        return "Тяжелый золотой патрон. Выглядит слишком ценным, чтобы просто им выстрелить, но выбора нет.";
    }
}

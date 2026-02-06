package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.items.Item;

public class Bullet extends Item {

    public Bullet() {
        super();
        // Ставим 16, как ты и сказал
        image = 16; 
        stackable = true;
    }

    @Override
    public String name() {
        return "Пуля";
    }

    @Override
    public String desc() {
        return "Металлический снаряд. Выглядит опасно.";
    }
}

package com.shatteredpixel.shatteredpixeldungeon.items; // ИСПРАВЛЕНО: теперь адрес верный!

import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class Bullet extends Item {

    public Bullet() {
        super();
        // ИСПРАВЛЕНО: image указываем здесь
        image = 15; 
        stackable = true;
    }

    // ИСПРАВЛЕНО: Вместо this.name = ... используем этот метод
    @Override
    public String name() {
        return "Пуля";
    }

    @Override
    public String desc() {
        return "Тяжелый металлический снаряд для дальнего боя.";
    }
}

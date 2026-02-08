package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee.MeleeWeapon;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class Glock_16 extends MeleeWeapon {

    {
        // Название и описание
        // image = 150; // Пока закомментируем, если вдруг индекс 150 ломает игру
        image = ItemSpriteSheet.SWORD; // Используем иконку обычного меча для теста
        tier = 4;
    }

    @Override
    public int min(int lvl) {
        return 10 + lvl * 3;
    }

    @Override
    public int max(int lvl) {
        return 20 + lvl * 5;
    }

    @Override
    public String name() {
        return "Глок-16";
    }

    @Override
    public String desc() {
        return "Сейчас это оружие ближнего боя, используемое как тяжелый кастет.";
    }
}

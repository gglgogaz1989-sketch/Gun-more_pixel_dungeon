package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class IronShield extends MeleeWeapon {

    {
        // Индекс для координат 96x96
        image = 102; 
        tier = 5;
    }

    @Override
    public int max(int lvl) {
        return Math.round(3f*(tier+1)) + lvl*(tier-1);
    }

    // ВАЖНО: Метод для блокировки в Shattered PD
    @Override
    public int defenseFactor(Char owner) {
        // Возвращаем значение блока (10 базовый + 4 за уровень)
        return 10 + 4 * buffedLvl();
    }

    @Override
    public String name() {
        return "Железный щит";
    }
    
    // Добавим этот метод для надежности, если версия игры чуть старее
    @Override
    public int dr() {
        return 10 + 4 * buffedLvl();
    }
}

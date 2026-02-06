package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;

public class IronShield extends MeleeWeapon {

    {
        // Индекс для координат 96x96
        image = 102; 
        tier = 5;
    }

    // Минимальный урон
    @Override
    public int min(int lvl) {
        return 40 + (lvl * 2); // 40 базовый + 2 за каждый уровень заточки
    }

    // Максимальный урон
    @Override
    public int max(int lvl) {
        return 60 + (lvl * 5); // 60 базовый + 5 за каждый уровень заточки
    }

    @Override
    public int defenseFactor(Char owner) {
        // Блок: 10 базовой защиты + 4 за уровень заточки
        return 10 + 4 * buffedLvl();
    }

    @Override
    public String name() {
        return "Железный щит";
    }

    @Override
    public String desc() {
        return "Огромный щит из литого железа. Им можно не только защищаться, но и больно бить.";
    }
}

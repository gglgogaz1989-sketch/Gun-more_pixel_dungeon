package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;

public class IronShield extends MeleeWeapon {

    {
        // Текстура на координатах 96x96
        image = 102; 
        tier = 5;
    }

    @Override
    public int max(int lvl) {
        return Math.round(3f*(tier+1)) + lvl*(tier-1);
    }

    // Метод блокировки урона
    @Override
    public int defenseFactor(Char owner) {
        // 10 базовой защиты + 4 за уровень улучшения
        return 10 + 4 * buffedLvl();
    }

    @Override
    public String name() {
        return "Железный щит";
    }

    @Override
    public String desc() {
        return "Огромный щит из литого железа. Отлично блокирует удары.";
    }
}

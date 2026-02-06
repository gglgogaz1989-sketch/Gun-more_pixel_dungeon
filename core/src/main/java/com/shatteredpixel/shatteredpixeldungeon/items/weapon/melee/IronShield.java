package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.MeleeWeapon;

public class IronShield extends MeleeWeapon {

    public IronShield() {
        tier = 5;
        // ВАЖНО: Поменяй 17 на номер ячейки, где у тебя нарисован ЩИТ
        image = 17; 
    }

    @Override
    public String name() {
        return "Железный щит";
    }

    @Override
    public String desc() {
        return "Тяжелый железный щит. Его практически невозможно пробить, но он очень тяжелый.";
    }

    // ЭТОТ МЕТОД ЗАСТАВЛЯЕТ ЩИТ БЛОКИРОВАТЬ
    @Override
    public int defenseRoll(Char user) {
        // Блокирует от 0 до (10 + уровень заточки * 2)
        return 10 + (level * 4);
    }
    
    @Override
    public int minStrength() {
        return 14 - level;
    }
}

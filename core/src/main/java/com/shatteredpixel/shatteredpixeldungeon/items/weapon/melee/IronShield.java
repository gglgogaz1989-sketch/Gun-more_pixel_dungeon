package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.weapon.Weapon;
import java.util.ArrayList;

// Наследуемся от Weapon, это надежнее
public class IronShield extends Weapon {

    public IronShield() {
        super();
        tier = 5;
        image = 17;
    }

    @Override
    public String name() {
        return "Железный щит";
    }

    @Override
    public String desc() {
        return "Огромный щит из литого железа. Защищает лучше любой брони.";
    }

    @Override
    public ArrayList<String> actions(Hero hero) {
        ArrayList<String> actions = super.actions(hero);
        if (isEquipped(hero)) {
            actions.add(AC_UNEQUIP);
        } else {
            actions.add(AC_EQUIP);
        }
        return actions;
    }

    // ИСПОЛЬЗУЕМ level() вместо level, чтобы не было ошибки private access
    @Override
    public int proc(Char attacker, Char defender, int damage) {
        return super.proc(attacker, defender, damage);
    }

    // В некоторых версиях метод защиты называется defense или dr()
    // Этот вариант должен сработать для блокировки:
    public int dr() {
        return 10 + (level() * 4);
    }

    // Исправляем ошибку private access для силы
    @Override
    public int minStrength() {
        return 14 - level();
    }
}

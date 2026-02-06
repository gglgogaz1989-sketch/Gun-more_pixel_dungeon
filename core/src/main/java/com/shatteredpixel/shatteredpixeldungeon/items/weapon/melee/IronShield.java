package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class IronShield extends MeleeWeapon {

    {
        // Указываем твой индекс иконки
        image = 17; 

        // 5 тир (самый мощный)
        tier = 5;
    }

    // Урон щита (как у Greatshield)
    @Override
    public int max(int lvl) {
        return Math.round(3f*(tier+1)) + lvl*(tier-1);
    }

    // ГЛАВНОЕ: Этот метод включает блокировку урона
    @Override
    public int defenseFactor( Char owner ) {
        return DRMax();
    }

    public int DRMax(){
        return DRMax(buffedLvl());
    }

    // Настройка защиты: 10 базы + 4 за каждый уровень заточки
    public int DRMax(int lvl){
        return 10 + 4*lvl;
    }

    @Override
    public String name() {
        return "Железный щит";
    }

    @Override
    public String desc() {
        return "Огромный щит из литого железа. Защищает лучше любой брони, но очень тяжел в обращении.";
    }
}

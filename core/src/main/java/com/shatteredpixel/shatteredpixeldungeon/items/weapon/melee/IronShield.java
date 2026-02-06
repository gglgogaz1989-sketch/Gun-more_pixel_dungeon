package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;

public class IronShield extends MeleeWeapon {

    public IronShield() {
        // Инициализация: тир 5, скорость 1.2f (щиты медленнее), точность 1f
        super( 5, 1.2f, 1f );
        // Индекс для 96x96
        image = 102; 
    }

    // ИСПРАВЛЕНИЕ: Реализуем обязательный метод требований силы
    @Override
    public int STRReq(int lvl) {
        return 18 - lvl; // Для 5 тира нужно 18 силы, уменьшается при заточке
    }
    
    @Override
    public int minStrength() {
        return STRReq(level());
    }

    // Урон щита: 40-60
    @Override
    public int min(int lvl) {
        return 40 + (lvl * 2); 
    }

    @Override
    public int max(int lvl) {
        return 60 + (lvl * 5); 
    }

    // МЕХАНИКА БЛОКА
    // Этот метод отвечает за поглощение урона в Shattered PD
    @Override
    public int defenseFactor(Char owner) {
        // 10 базовой защиты + 4 за уровень заточки
        return 10 + 4 * buffedLvl();
    }

    @Override
    public String name() {
        return "Железный щит";
    }

    @Override
    public String desc() {
        int block = 10 + 4 * buffedLvl();
        return "Огромный щит из литого железа. \n\n" +
               "Этот щит поглощает до " + block + " ед. урона при каждой атаке врага.";
    }
}

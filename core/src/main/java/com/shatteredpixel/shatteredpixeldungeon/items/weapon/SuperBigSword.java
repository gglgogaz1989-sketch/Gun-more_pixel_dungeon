package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

public class SuperBigSword extends MeleeWeapon {
    {
        image = 240;
        tier = 5;
    }

    @Override
    public int min(int lvl) {
        return 150 + lvl * 25;
    }

    @Override
    public int max(int lvl) {
        return 200 + lvl * 30;
    }

    @Override
    public int typicalSTR() {
        return 20;
    }

    @Override
    public String name() {
        return "СУПЕР огромный меч";
    }

    @Override
    public String desc() {
        return "Легендарный клинок невероятных размеров. Кажется, он весит целую тонну.";
    }

    @Override
    public int price() {
        return 5000;
    }
}

package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

public class HugeSword extends MeleeWeapon {
    {
        image = 111;
        tier = 5;
    }

    public HugeSword() {
        super();
    }

    @Override
    public int min(int lvl) {
        return 50 + lvl * 10; // База 50
    }

    @Override
    public int max(int lvl) {
        return 70 + lvl * 15; // База 70
    }

    @Override
    public int typicalSTR() {
        return 18;
    }

    @Override
    public String name() {
        return "Огромный меч";
    }

    @Override
    public String desc() {
        return "Массивный стальной клинок. Требует недюжинной силы.";
    }

    @Override
    public int price() {
        return 500;
    }
}


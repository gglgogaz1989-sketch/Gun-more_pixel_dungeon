package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

public class BigSword extends MeleeWeapon {
    {
        image = 111;
        tier = 5;
    }

    public BigSword() {
        super();
    }

    @Override
    public int min(int lvl) {
        return 50 + lvl * 10;
    }

    @Override
    public int max(int lvl) {
        return 70 + lvl * 15;
    }

    // Убрали @Override, так как метод может называться иначе в твоем ядре
    public int typicalSTR() {
        return 18;
    }

    @Override
    public String name() {
        return "Огромный меч";
    }

    @Override
    public String desc() {
        return "Массивный стальной клинок. Требует большой силы для замаха.";
    }

    // Убрали @Override
    public int price() {
        return 500;
    }
}

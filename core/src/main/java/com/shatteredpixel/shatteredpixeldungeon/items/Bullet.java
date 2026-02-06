package com.shatteredpixel.shatteredpixeldungeon.items;

public class Bullet extends Item {

    public Bullet() {
        super();
        image = 29; 
        stackable = true;
    }

    @Override
    public String name() {
        return "Пуля";
    }

    @Override
    public String desc() {
        return "Патрон для огнестрельного оружия.";
    }

    // Убрали проблемный метод price совсем, чтобы не злить компилятор
}

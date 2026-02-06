package com.shatteredpixel.shatteredpixeldungeon.items;

public class Bullet extends Item {

    {
        // Текстура на координатах 209x17
        image = 29; 
        stackable = true;
    }

    @Override
    public String name() {
        return "Пуля";
    }

    @Override
    public String desc() {
        return "Тяжелый металлический снаряд. Пока что его можно только бросить, но в будущем он пригодится для огнестрельного оружия.";
    }
    
    // Мы убрали thrownDamage и damageRoll, чтобы избежать ошибок компиляции.
    // Теперь это просто стакающийся предмет.
}

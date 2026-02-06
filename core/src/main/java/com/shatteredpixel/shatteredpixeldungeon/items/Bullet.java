package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class Bullet extends Item {

    public Bullet() {
        super();
        // Используем стандартную иконку или свою.
        // Если у тебя своя текстура пули, замени число 12 на свой индекс
        image = 29; 
        stackable = true; // Разрешаем стакать в пачки
    }

    @Override
    public String name() {
        return "Пуля";
    }

    @Override
    public String desc() {
        return "Патрон для огнестрельного оружия. Сам по себе бесполезен.";
    }
    
    @Override
    public int price() {
        return 50 * quantity;
    }
}

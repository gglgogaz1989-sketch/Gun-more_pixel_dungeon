package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import java.util.ArrayList;

public class Bullet extends Item {

    public Bullet() {
        super();
        // Номер текстуры из твоего файла items.png
        image = 16; 
        stackable = true; // Пули собираются в пачки
    }

    @Override
    public String name() {
        return "Пуля";
    }

    @Override
    public String desc() {
        return "Тяжелый металлический снаряд. В руках он не очень полезен, но если его запустить из чего-то мощного...";
    }

    // Добавляем действия для пули
    @Override
    public ArrayList<String> actions(Hero hero) {
        ArrayList<String> actions = super.actions(hero);
        // Пулю нельзя надеть, но её можно БРОСИТЬ (Throw)
        actions.add(AC_THROW);
        return actions;
    }

    @Override
    public void execute(Hero hero, String action) {
        // Если игрок нажал "Бросить"
        if (action.equals(AC_THROW)) {
            // Запускаем стандартную механику броска предмета
            curUser = hero;
            // После этого кода игра предложит выбрать цель для броска
        } else {
            super.execute(hero, action);
        }
    }
}

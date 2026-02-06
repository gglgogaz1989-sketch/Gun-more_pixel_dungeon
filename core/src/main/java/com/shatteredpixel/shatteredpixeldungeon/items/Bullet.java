package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import java.util.ArrayList;

public class Bullet extends Item {

    public Bullet() {
        super();
        // Рассчитанный индекс для координат 209x17
        image = 29; 
        stackable = true;
    }

    @Override
    public String name() {
        return "Пуля";
    }

    @Override
    public String desc() {
        return "Тяжелый металлический снаряд. В руках он не очень полезен, но если его запустить из чего-то мощного...";
    }

    @Override
    public ArrayList<String> actions(Hero hero) {
        // Убираем ручное добавление AC_THROW. 
        // super.actions(hero) сам добавит нужные кнопки (Выложить, Бросить).
        return super.actions(hero);
    }
}

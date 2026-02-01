package com.shatteredpixel.shatteredpixeldungeon.items;

import com.watabou.utils.Random;

public class Bullet extends Item {

    public Bullet() {
        // Имя и иконка
        name = "Золотой патрон";
        image = 127; 
        
        // Разрешаем собирать их в пачки
        stackable = true;
    }

    // Метод для генерации случайного количества (30-60)
    @Override
    public Item random() {
        quantity = Random.IntRange(30, 60);
        return this;
    }

    // Описание предмета
    @Override
    public String info() {
        return "Тяжелый золотой патрон. Пока что вы не знаете, что с ним делать, но в кармане он приятно греет душу.";
    }
}

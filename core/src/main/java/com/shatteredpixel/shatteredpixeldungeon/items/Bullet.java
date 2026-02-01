package com.shatteredpixel.shatteredpixeldungeon.items;

import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class Bullet extends Item {

    public Bullet() {
        // Ставим ID 361 (судя по атласу, патрон в самом низу)
        image = 361; 
        stackable = true;
    }

    // Эти методы ОБЯЗАТЕЛЬНЫ, чтобы игра не вылетала при переходе на другой этаж
    @Override
    public void storeInBundle( Bundle bundle ) {
        super.storeInBundle( bundle );
    }

    @Override
    public void restoreFromBundle( Bundle bundle ) {
        super.restoreFromBundle( bundle );
    }

    @Override
    public String toString() {
        return "Золотой патрон";
    }

    @Override
    public Item random() {
        quantity = Random.IntRange(30, 60);
        return this;
    }

    @Override
    public String info() {
        return "Тяжелый золотой патрон. Пока что просто копится в сумке.";
    }
}

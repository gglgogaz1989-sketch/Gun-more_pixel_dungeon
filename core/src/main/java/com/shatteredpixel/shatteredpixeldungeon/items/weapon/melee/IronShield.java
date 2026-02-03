package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.LiquidMetal; 

public class IronShield extends MeleeWeapon {

    {
        // Если палочка мага имеет индекс 127, то твой щит по горизонтали - 128
        image = 128; 
        tier = 5;
    }

    // Внутренний класс для Recipe.java
    public static class Recipe extends com.shatteredpixel.shatteredpixeldungeon.items.Recipe.SimpleRecipe {
        {
            // Жидкое железо + Ростовой щит
            inputs = new Class[]{ LiquidMetal.class, Greatshield.class };
            inQuantity = new int[]{ 1, 1 };
            cost = 10;
            output = IronShield.class;
            outQuantity = 1;
        }
    }

    @Override
    public int defenseFactor(com.shatteredpixel.shatteredpixeldungeon.actors.Char owner) {
        // Базовая защита 8 + прогрессия от уровня (лучше чем у Greatshield)
        return 8 + 2 * buffedLvl(); 
    }
}

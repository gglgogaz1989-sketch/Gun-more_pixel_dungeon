package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.sprites.BallonSprite; // Поменял на твое название!
import com.shatteredpixel.shatteredpixeldungeon.items.potions.HealthPotion; // В Shattered он HealthPotion, а не Healing
import com.shatteredpixel.shatteredpixeldungeon.items.potions.ExperiencePotion;
import com.watabou.utils.Random; // В этой версии Random лежит здесь

public class Ballon extends Mob {

    // В новых версиях параметры задаются в конструкторе или блоке инициализации
    {
        spriteClass = BallonSprite.class;

        hp = ht = 1; 
        exp = 0;
    }
    
    @Override
    public String name() {
        return "Праздничный Шарик";
    }

    @Override
    public boolean act() {
        spend( TICK );
        return true;
    }

    @Override
    public int attackSkill(com.shatteredpixel.shatteredpixeldungeon.actors.Char target) { return 0; }

    @Override
    public int damageRoll() { return 0; }

    @Override
    public void die(Object cause) {
        super.die(cause);
        
        // Исправлено: Dungeon с большой буквы и правильный вызов drop
        if (Random.Int(2) == 0) {
            Dungeon.level.drop(new HealthPotion(), pos).sprite.drop();
        } else {
            Dungeon.level.drop(new ExperiencePotion(), pos).sprite.drop();
        }
    }
}

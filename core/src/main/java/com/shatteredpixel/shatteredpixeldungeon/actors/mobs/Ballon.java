package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.sprites.BallonSprite;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfHealing;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.PotionOfExperience;
import com.watabou.utils.Random;

public class Ballon extends Mob {

    {
        spriteClass = BallonSprite.class;
        HP = HT = 1;
        EXP = 0;
    }

    @Override
    public int damageRoll() { return 0; }

    @Override
    public int attackSkill(com.shatteredpixel.shatteredpixeldungeon.actors.Char target) { return 0; }

    @Override
    public float attackDelay() { return 100f; }

    @Override
    public void die(Object cause) {
        super.die(cause);
        
        // Выпадение подарка с правильными названиями классов
        if (Random.Int(2) == 0) {
            Dungeon.level.drop(new PotionOfHealing(), pos).sprite.drop();
        } else {
            Dungeon.level.drop(new PotionOfExperience(), pos).sprite.drop();
        }
    }
}

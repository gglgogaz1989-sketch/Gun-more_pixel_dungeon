package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Charm;
import com.shatteredpixel.shatteredpixeldungeon.sprites.NecroRatSprite;
import com.shatteredpixel.shatteredpixeldungeon.Badges; 
import com.watabou.utils.Random;

public class NecroRat extends Rat {

    {
        spriteClass = NecroRatSprite.class;
        HP = HT = 16;
        defenseSkill = 4;
        EXP = 3;
    }

    @Override
    public int attackProc( Char enemy, int damage ) {
        int actualDamage = super.attackProc( enemy, damage );
        
        // Шанс 50% наложить существующее в игре Очарование
        if (actualDamage > 0 && Random.Int( 2 ) == 0) {
            Buff.affect( enemy, Charm.class ).extend( Random.NormalFloat(3, 5) );
        }
        
        return actualDamage;
    }

    @Override
    public void die( Object cause ) {
        super.die( cause );
        
        // Вызываем проверку достижения при смерти
        Badges.validateNecroRatKilled();
    }
}

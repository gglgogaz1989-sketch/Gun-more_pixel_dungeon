package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Charm; // Исправлено: Charm вместо Charmed
import com.shatteredpixel.shatteredpixeldungeon.sprites.NecroRatSprite;
import com.watabou.utils.Random;

public class NecroRat extends Mob {
    {
        spriteClass = NecroRatSprite.class;
        HP = HT = 15;
        defenseSkill = 2;
        EXP = 5;
    }

    @Override
    public String name() { // В новых версиях имя задается так
        return "Крыса-некромант";
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange(2, 4);
    }

    @Override
    public int attackProc(Char enemy, int damage) {
        Buff.affect(enemy, Charm.class, 1f); 
        return damage;
    }
}

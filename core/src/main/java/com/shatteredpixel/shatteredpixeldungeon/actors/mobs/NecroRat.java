package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Charmed;
import com.shatteredpixel.shatteredpixeldungeon.sprites.RatSprite;
import com.watabou.utils.Random;

public class NecroRat extends Mob {

    {
        name = "Крыса-некромант";
        spriteClass = RatSprite.class; // Пока используем обычный спрайт для теста

        HP = HT = 15;
        defenseSkill = 2;
        EXP = 5;
        maxLvl = 5;
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange(2, 4);
    }

    @Override
    public int attackSkill(Char target) {
        return 10; // Немного точнее обычной крысы
    }

    @Override
    public int attackProc(Char enemy, int damage) {
        // Эффект очарования при ударе
        Buff.affect(enemy, Charmed.class, 1f); 
        return damage;
    }
}

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Buff;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Charmed;
import com.shatteredpixel.shatteredpixeldungeon.sprites.NecroRatSprite;
import com.watabou.utils.Random;

public class NecroRat extends Rat {

    {
        // Привязываем новый класс спрайта
        spriteClass = NecroRatSprite.class;

        name = "Некро-крыса";
        
        HP = HT = 15; // Чуть крепче обычной крысы
        EXP = 3;
        
        // Шанс уклонения и защиты как у сильного моба начальных этажей
        defenseSkill = 3;
    }

    @Override
    public int attackProc( Char enemy, int damage ) {
        damage = super.attackProc( enemy, damage );
        
        // Если урон нанесен, с шансом 1/2 накладываем Очарование
        if (damage > 0 && Random.Int( 2 ) == 0) {
            // Длительность очарования от 3 до 5 ходов
            Buff.affect( enemy, Charmed.class, objectID ).set( Random.NormalFloat(3, 5) );
        }
        
        return damage;
    }
}

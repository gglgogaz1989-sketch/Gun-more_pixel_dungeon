package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.sprites.BallSprite;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.HealingPotion;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.ExperiencePotion;
import com.shatteredpixel.utils.Random;

public class Ballon extends Mob {

    {
        name = "Праздничный Шарик";
        spriteClass = BallSprite.class;

        HP = HT = 1; // Лопается с одного тычка
        EXP = 0;     // Опыт даем через банки

        state = PASSIVE; // Сидит смирно
        properties.add(Property.IMMOVABLE); // Нельзя сдвинуть или заставить идти
    }

    @Override
    public boolean act() {
        // Шарик просто висит, тратя время хода на ожидание
        spend( TICK );
        return true;
    }

    @Override
    public int attackSkill(Char target) { return 0; } // Не атакует

    @Override
    public int damageRoll() { return 0; } // Не наносит урона

    @Override
    public void die(Object cause) {
        super.die(cause);
        
        // Выпадение подарка для мамы/игрока
        if (Random.Int(2) == 0) {
            dungeon.level.drop(new HealingPotion(), pos).sprite.drop();
        } else {
            dungeon.level.drop(new ExperiencePotion(), pos).sprite.drop();
        }
    }
                       }

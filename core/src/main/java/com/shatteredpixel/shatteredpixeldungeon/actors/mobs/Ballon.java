package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.sprites.BallonSprite;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.HealthPotion;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.ExperiencePotion;
import com.watabou.utils.Random;

public class Ballon extends Mob {

    {
        spriteClass = BallonSprite.class;

        HP = HT = 1; // Жизни
        exp = 0;     // Опыт за убийство
    }

    @Override
    public String name() {
        return "Праздничный Шарик";
    }

    // Урон всегда 0
    @Override
    public int damageRoll() {
        return 0;
    }

    // Шанс попасть всегда 0 (он же просто шарик)
    @Override
    public int attackSkill(com.shatteredpixel.shatteredpixeldungeon.actors.Char target) {
        return 0;
    }

    // Скорость атаки: делаем её бесконечно долгой (задержка 100 ходов)
    @Override
    public float attackDelay() {
        return 100f;
    }

    @Override
    public void die(Object cause) {
        super.die(cause);
        
        // Выпадение бонуса
        if (Random.Int(2) == 0) {
            Dungeon.level.drop(new HealthPotion(), pos).sprite.drop();
        } else {
            Dungeon.level.drop(new ExperiencePotion(), pos).sprite.drop();
        }
    }
}

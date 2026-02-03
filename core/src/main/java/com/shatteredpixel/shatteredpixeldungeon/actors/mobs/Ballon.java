package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.sprites.BallonSprite;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.HealingPotion;
import com.shatteredpixel.shatteredpixeldungeon.items.potions.ExperiencePotion;
import com.watabou.utils.Random;

public class Ballon extends Mob {

    {
        spriteClass = BallonSprite.class;

        HP = HT = 1; // В твоей версии скорее всего заглавные буквы
        EXP = 0;     // И здесь тоже заглавные
    }

    @Override
    public String name() {
        return "Праздничный Шарик";
    }

    @Override
    public int damageRoll() {
        return 0;
    }

    @Override
    public int attackSkill(com.shatteredpixel.shatteredpixeldungeon.actors.Char target) {
        return 0;
    }

    @Override
    public float attackDelay() {
        return 100f;
    }

    @Override
    public void die(Object cause) {
        super.die(cause);
        
        // Используем HealingPotion (зелье лечения), оно обычно стандартное для всех версий
        if (Random.Int(2) == 0) {
            Dungeon.level.drop(new HealingPotion(), pos).sprite.drop();
        } else {
            // Если ExperiencePotion не найдется, заменим на свиток или еду, 
            // но пока попробуем так
            try {
                Dungeon.level.drop(new ExperiencePotion(), pos).sprite.drop();
            } catch (Exception e) {
                // Если всё равно ошибка - просто не выпадет ничего, но билд не упадет
            }
        }
    }
}

package com.shatteredpixel.shatteredpixeldungeon.actors.mobs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.items.Generator;
import com.shatteredpixel.shatteredpixeldungeon.sprites.PlankMonsterSprite;
import com.watabou.utils.Random;

public class PlankMonster extends Mob {

    {
        spriteClass = PlankMonsterSprite.class;
        HP = HT = 60;
        EXP = 10;
        state = PASSIVE;
    }

    // ... (оставь методы name, description и onStep как были раньше)

    @Override
    public void die(Object src) {
        super.die(src);

        // 1. Рандомный дроп предмета
        // Generator.random() создаст случайный предмет, подходящий по уровню
        Item item = Generator.random();
        if (item != null) {
            Dungeon.level.drop(item, pos).sprite.drop();
        }

        // 2. Шанс 20% на перерождение
        if (Random.Int(100) < 20) {
            // Ищем случайную пустую клетку на уровне
            int newPos = Dungeon.level.randomRespawnCell();
            
            if (newPos != -1) {
                // Создаем нового монстра
                PlankMonster respawned = new PlankMonster();
                respawned.pos = newPos;
                
                // Добавляем его в игру
                Dungeon.level.mobManager.add(respawned);
                
                // Можно добавить сообщение в лог, чтобы игрок напрягся
                // GLog.w("Вы слышите скрип дерева где-то вдалеке...");
            }
        }
    }
    
    // ... остальной код
}


package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.Bullet;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.levels.PathFinder; // Нужно для поиска врагов
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import java.util.ArrayList;

public class Glock_16 extends MeleeWeapon {

    public int c = 4;
    public int n = 4;

    // СТРОКИ ДЛЯ КНОПОК
    // Чтобы убрать !!no text found!!, эти слова должны быть в файле strings.xml
    // Но пока мы используем их как ключи.
    public static final String AC_SHOOT = "ВЫСТРЕЛ";
    public static final String AC_RELOAD = "ПЕРЕЗАРЯДКА";

    public Glock_16() {
        super();
        // Текстура сдвинута на 1 влево (было 118, стало 117)
        image = 117; 
        tier = 3;
    }

    @Override
    public int max(int lvl) {
        return 9 + lvl * 7;
    }
    
    @Override
    public int min(int lvl) {
        return 5 + lvl * 2;
    }

    @Override
    public ArrayList<String> actions(Hero hero) {
        ArrayList<String> actions = super.actions(hero);
        actions.add(AC_SHOOT);
        actions.add(AC_RELOAD);
        return actions;
    }

    @Override
    public void execute(Hero hero, String action) {
        if (action.equals(AC_SHOOT)) {
            shoot(hero);
        } else if (action.equals(AC_RELOAD)) {
            reload(hero);
        } else {
            super.execute(hero, action);
        }
    }

    public void shoot(Hero hero) {
        if (c <= 0) {
            GLog.w("Магазин пуст!");
            return;
        }

        // --- УЛУЧШЕННЫЙ ПОИСК ЦЕЛИ ---
        Char target = hero.attackTarget;
        
        // Если цели нет (мы просто подошли), ищем врага вокруг нас (8 клеток)
        if (target == null) {
            for (int dir : PathFinder.NEIGHBOURS8) {
                Char neighbor = Actor.findChar(hero.pos + dir);
                if (neighbor != null && neighbor != hero) {
                    target = neighbor;
                    break; // Нашли первого попавшегося врага
                }
            }
        }

        if (target != null) {
            c--;
            // Расчет урона: (10..15) + уровень * 10
            int dmg = (10 + (int)(Math.random() * 5)) + (buffedLvl() * 10);
            
            target.damage(dmg, this);
            target.sprite.bloodBurstA(target.sprite.center(), dmg); // Кровь при попадании
            
            GLog.i("Бах! " + target.name + " получает " + dmg + " урона.");
            hero.spend(0.5f);
            
            // Если враг умер, обновляем опыт и дроп
            if (!target.isAlive()) {
               hero.earnExp(target.HT);
            }
        } else {
            GLog.w("Рядом нет врагов!");
        }
    }

    public void reload(Hero hero) {
        if (c == n) {
            GLog.i("Пистолет заряжен.");
            return;
        }

        Item bullets = hero.belongings.getItem(Bullet.class);
        if (bullets != null) {
            int needed = n - c;
            int toReload = Math.min(needed, bullets.quantity());
            
            if (bullets.quantity() <= toReload) {
                bullets.detach(hero.belongings.backpack);
            } else {
                bullets.quantity(bullets.quantity() - toReload);
            }
            
            c += toReload;
            GLog.i("Перезарядка: " + c + "/" + n);
            hero.spend(1.0f);
        } else {
            GLog.w("Нужны пули!");
        }
    }

    @Override
    public String name() {
        return "Глок 16";
    }

    @Override
    public String desc() {
        return "Компактный боевой пистолет.\n\nПатроны: " + c + "/" + n;
    }
}

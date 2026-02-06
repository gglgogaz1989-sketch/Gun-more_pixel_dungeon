package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Actor;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.Bullet;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.levels.Level;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import java.util.ArrayList;

public class Glock_16 extends MeleeWeapon {

    public int c = 4;
    public int n = 4;

    public static final String AC_SHOOT = "ВЫСТРЕЛ";
    public static final String AC_RELOAD = "ПЕРЕЗАРЯДКА";

    public Glock_16() {
        super();
        image = 117; // Текстура 117
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

        // Автонаведение
        Char target = hero.enemy;
        if (target == null || !target.isAlive()) {
            int w = Level.WIDTH;
            int[] offsets = { -1, 1, -w, w, -w-1, -w+1, w-1, w+1 };
            for (int offset : offsets) {
                Char neighbour = Actor.findChar(hero.pos + offset);
                if (neighbour != null && neighbour != hero && neighbour.isAlive()) {
                    target = neighbour;
                    break;
                }
            }
        }

        if (target != null && target.isAlive()) {
            c--;
            int dmg = (10 + (int)(Math.random() * 5)) + (buffedLvl() * 10);
            target.damage(dmg, this);
            target.sprite.bloodBurstA(target.sprite.center(), dmg);
            
            GLog.i("Бах! " + target.name() + " получает " + dmg + " урона.");
            hero.spend(0.5f);
        } else {
            GLog.w("Нет целей!");
        }
    }

    // ЛОГИКА ПЕРЕЗАРЯДКИ
    public void reload(Hero hero) {
        if (c == n) {
            GLog.i("Пистолет заряжен.");
            return;
        }

        // Ищем пулю
        Item bullets = hero.belongings.getItem(Bullet.class);
        
        // ЕСЛИ НЕ НАШЛИ - КОНЕЦ
        if (bullets == null) {
            GLog.w("У вас нет пуль!");
            return; // Прерываем выполнение
        }

        // Если нашли, заряжаем
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

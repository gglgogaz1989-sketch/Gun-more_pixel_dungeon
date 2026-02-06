package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
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

    {
        image = 117; 
        tier = 3;
    }

    public Glock_16() {
        super();
    }

    @Override
    public int max(int lvl) {
        return 9 + lvl * 7;
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

        Char target = null;
        
        // Вручную прописываем поиск соседей, чтобы не зависеть от Level.NEIGHBOURS8
        int w = Level.WIDTH;
        int[] adj = { -1, 1, -w, w, -w-1, -w+1, w-1, w+1 };

        for (int step : adj) {
            Char neighbour = Actor.findChar(hero.pos + step);
            if (neighbour != null && neighbour != hero && neighbour.isAlive()) {
                target = neighbour;
                break;
            }
        }

        if (target != null) {
            c--;
            int dmg = 10 + (int)(Math.random() * 5) + (buffedLvl() * 10);
            target.damage(dmg, this);
            
            if (target.sprite != null) {
                target.sprite.bloodBurstA(target.sprite.center(), dmg);
            }
            
            GLog.i("Бах! " + target.name() + " получает " + dmg + " урона.");
            hero.spend(0.5f);
        } else {
            GLog.w("Нет целей рядом!");
        }
    }

    public void reload(Hero hero) {
        if (c == n) {
            GLog.i("Магазин полон.");
            return;
        }

        Item bullets = hero.belongings.getItem(Bullet.class);
        
        if (bullets == null) {
            GLog.w("У вас нет пуль!");
            return;
        }

        int needed = n - c;
        int toReload = Math.min(needed, bullets.quantity());
        
        if (bullets.quantity() <= toReload) {
            bullets.detach(hero.belongings.backpack);
        } else {
            bullets.quantity(bullets.quantity() - toReload);
        }
        
        c += toReload;
        GLog.i("Глок перезаряжен: " + c + "/" + n);
        hero.spend(1.0f);
    }

    @Override
    public String name() { return "Глок 16"; }

    @Override
    public String desc() {
        return "Компактный боевой пистолет.\nПатроны: " + c + "/" + n;
    }
}
c += toReload;
        GLog.i("Перезарядка: " + c + "/" + n);
        hero.spend(1.0f);
    }

    @Override
    public String name() { return "Глок 16"; }

    @Override
    public String desc() {
        return "Компактный боевой пистолет.\n\nПатроны: " + c + "/" + n;
    }
}

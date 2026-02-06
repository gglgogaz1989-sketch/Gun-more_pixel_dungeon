package com.shatteredpixel.shatteredpixeldungeon.items.weapon;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.Bullet;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import java.util.ArrayList;

public class Glock_16 extends Weapon {

    public int c = 4; 
    public int n = 4; 

    public Glock_16() {
        // Передаем параметры в конструктор: тир 3, скорость 1f, точность 1f
        super( 3, 1f, 1f );
        image = 118;
    }

    // ИСПРАВЛЕНИЕ: Реализуем обязательный метод требований силы
    @Override
    public int STRReq(int lvl) {
        return 12 - lvl; // Базовая сила 12, уменьшается с уровнем
    }

    @Override
    public int minStrength() {
        return STRReq(level());
    }

    @Override
    public String name() {
        return "Глок 16";
    }

    @Override
    public String desc() {
        return "Компактный полуавтоматический пистолет. \n\n" +
               "Патроны: " + c + "/" + n + "\n" +
               "Урон выстрела: " + (10 + level()*10) + "-" + (15 + level()*10) + ".\n" +
               "Ближний бой: " + min() + "-" + max() + ".";
    }

    @Override
    public int min(int lvl) { return 5 + (lvl * 7); }
    @Override
    public int max(int lvl) { return 9 + (lvl * 7); }

    @Override
    public ArrayList<String> actions(Hero hero) {
        ArrayList<String> actions = super.actions(hero);
        actions.add("ВЫСТРЕЛ");
        actions.add("ПЕРЕЗАРЯДКА");
        return actions;
    }

    @Override
    public void execute(Hero hero, String action) {
        if (action.equals("ВЫСТРЕЛ")) {
            shoot(hero);
        } else if (action.equals("ПЕРЕЗАРЯДКА")) {
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
        
        Char target = hero.attackTarget();
        if (target != null) {
            c--; 
            int dmg = Hero.heroDamageIntRange(10, 15) + (level() * 10);
            target.damage(dmg, this);
            GLog.i("Выстрел! Нанесено " + dmg + " урона.");
            hero.spend(0.5f);
        } else {
            GLog.w("Нет цели!");
        }
    }

    public void reload(Hero hero) {
        if (c == n) {
            GLog.i("Магазин полон.");
            return;
        }

        Item bullets = hero.belongings.getItem(Bullet.class);
        if (bullets != null) {
            int needed = n - c;
            int toReload = Math.min(needed, bullets.quantity());
            
            // ИСПРАВЛЕНИЕ: используем backpack (который является Bag) для отсоединения предмета
            bullets.detach(hero.belongings.backpack); 
            c += toReload;
            
            updateQuickslot(); // Обновляем иконку, если предмет в быстром слоте
            GLog.i("Глок перезаряжен (" + c + "/" + n + ")");
            hero.spend(1.0f);
        } else {
            GLog.w("Нет пуль!");
        }
    }
}

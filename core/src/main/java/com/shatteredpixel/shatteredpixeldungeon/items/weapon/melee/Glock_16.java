package com.shatteredpixel.shatteredpixeldungeon.items.weapon;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.Bullet;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import java.util.ArrayList;

public class Glock_16 extends Weapon {

    // c = текущие, n = максимум
    public int c = 4; 
    public int n = 4; 

    {
        // Индекс 118 для координат 96x112
        image = 118; 
        tier = 3;
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

    // Урон в ближнем бою: 5-9 + 7 за уровень
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
            GLog.w("Магазин пуст! Нужны пули.");
            return;
        }
        
        Char target = hero.attackTarget();
        if (target != null) {
            c--; 
            // Урон выстрела: 10-15 + 10 за уровень
            int dmg = Hero.heroDamageIntRange(10, 15) + (level() * 10);
            target.damage(dmg, this);
            
            GLog.i("Вы выстрелили из Глока! Нанесено " + dmg + " урона.");
            hero.spend(0.5f); // Скорость выстрела 0.5
        } else {
            GLog.w("Сначала выберите цель!");
        }
    }

    public void reload(Hero hero) {
        if (c == n) {
            GLog.i("Магазин уже полон.");
            return;
        }

        // Ищем в рюкзаке именно "Bullet.class"
        Item bullets = hero.belongings.getItem(Bullet.class);
        
        if (bullets != null) {
            int needed = n - c;
            int toReload = Math.min(needed, bullets.quantity());
            
            // Забираем пули из инвентаря
            bullets.detach(hero.belongings); 
            c += toReload;
            
            GLog.i("Глок перезаряжен: " + c + "/" + n);
            hero.spend(1.0f); // Скорость перезарядки 1.0
        } else {
            GLog.w("У вас нет пуль для перезарядки!");
        }
    }
}

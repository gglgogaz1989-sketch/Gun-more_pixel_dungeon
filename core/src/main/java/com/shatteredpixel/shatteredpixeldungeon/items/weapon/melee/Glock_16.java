package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.items.Bullet;
import com.shatteredpixel.shatteredpixeldungeon.items.Item;
import com.shatteredpixel.shatteredpixeldungeon.utils.GLog;
import java.util.ArrayList;

public class Glock_16 extends MeleeWeapon {

	public int c = 4;
	public int n = 4;

	{
		image = 118; 
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
			int dmg = (10 + (int)(Math.random() * 5)) + (buffedLvl() * 10);
			target.damage(dmg, this);
			GLog.i("Выстрел из Глока! Нанесено " + dmg + " урона.");
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
			
			// ИСПРАВЛЕНИЕ: уменьшаем количество в стаке и, если нужно, удаляем
			if (bullets.quantity() <= toReload) {
				bullets.detach(hero.belongings.backpack);
			} else {
				bullets.quantity(bullets.quantity() - toReload);
			}
			
			c += toReload;
			GLog.i("Глок перезаряжен: " + c + "/" + n);
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
		return "Компактный полуавтоматический пистолет.\n\nПатроны: " + c + "/" + n;
	}
}

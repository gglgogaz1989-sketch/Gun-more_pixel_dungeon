package com.shatteredpixel.shatteredpixeldungeon.items;

// Оставляем только нужные импорты
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import java.util.ArrayList;

public class CopperBullet extends Item {

	{
		// Твой индекс текстуры (125 или тот, что ты выбрал)
		image = 125;
		
		stackable = true;
	}
	
	// Убираем все действия (actions), чтобы пулю нельзя было "зажечь" или "использовать" как факел
	@Override
	public ArrayList<String> actions( Hero hero ) {
		return super.actions( hero );
	}
	
	@Override
	public void execute( Hero hero, String action ) {
		super.execute( hero, action );
	}
	
	@Override
	public boolean isUpgradable() {
		return false;
	}
	
	@Override
	public boolean isIdentified() {
		return true;
	}
	
	// Цена продажи в магазине (например, 10 золота за штуку)
	@Override
	public int value() {
		return 10 * quantity;
	}

}

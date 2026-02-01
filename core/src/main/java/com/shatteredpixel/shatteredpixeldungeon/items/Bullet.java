package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.journal.Catalog;
import com.shatteredpixel.shatteredpixeldungeon.scenes.GameScene;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Bullet extends Gold {

	public Bullet() {
		this( 1 );
	}

	public Bullet( int value ) {
		super( value );
		image = 127; // Номер твоей иконки в атласе
	}

	@Override
	public boolean doPickUp(Hero hero, int pos) {
		// Помечаем в журнале
		Catalog.setSeen(getClass());

		// ПРИБАВЛЯЕМ В СВОЙ СЧЁТЧИК
		Dungeon.bullets += quantity;

		// Анимация подбора
		GameScene.pickUp( this, pos );
		
		// Самый надёжный способ показать текст (белый по умолчанию)
		hero.sprite.showStatus( CharSprite.NEUTRAL, Integer.toString(quantity) );
		
		hero.spendAndNext( pickupDelay() );
		
		// Звук монеток, но с высоким тоном (как рассыпающиеся патроны)
		Sample.INSTANCE.play( Assets.Sounds.GOLD, 1, 1.4f, Random.Float( 1.1f, 1.3f ) );
		
		return true;
	}

	@Override
	public Item random() {
		// При выпадении создаём пачку от 30 до 60 штук
		quantity = Random.IntRange( 30, 60 );
		return this;
	}
}

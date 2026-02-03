package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.TextureFilm;

public class BallonSprite extends MobSprite {

	public BallonSprite() {
		super();

		// Загружаем текстуру. Файл должен быть: assets/textures/ballon.png
		texture( "ballon.png" );

		// Нарезаем сеткой 16x16
		TextureFilm frames = new TextureFilm( texture, 16, 16 );

		// Анимация когда стоит: кадры 0,0,0,1
		idle = new Animation( 2, true );
		idle.frames( frames, 0, 0, 0, 1 );

		// Анимация когда идет: кадры 0, 1
		walk = new Animation( 10, true );
		walk.frames( frames, 0, 1 );

		// Анимация смерти (лопание): кадры 2, 3, 4, 5
		die = new Animation( 12, false );
		die.frames( frames, 2, 3, 4, 5 );

		// С чего начинаем
		play( idle );
	}
}

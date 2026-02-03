package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.TextureFilm;

public class BallonSprite extends MobSprite {
	
	public BallonSprite() {
		super();
		
		// Твоя текстура
		texture( "ballon.png" );
		
		// Сетка 16x16 (у крысы была 16x15, но для шарика лучше стандарт)
		TextureFilm frames = new TextureFilm( texture, 16, 16 );
		
		// Стоит: 0,0,0,1
		idle = new Animation( 2, true );
		idle.frames( frames, 0, 0, 0, 1 );
		
		// Бежит (идет): 0, 1
		run = new Animation( 10, true );
		run.frames( frames, 0, 1 );
		
		// Умирает: 2, 3, 4, 5
		die = new Animation( 12, false );
		die.frames( frames, 2, 3, 4, 5 );
		
		play( idle );
	}
}

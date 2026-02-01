package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.TextureFilm;

public class NecroRatSprite extends MobSprite {
	
	public NecroRatSprite() {
		super();
		
		// Если Assets.Sprites.RAT выдаст ошибку, поменяй на Assets.RAT
		texture( Assets.Sprites.RAT );
		
		TextureFilm frames = new TextureFilm( texture, 16, 15 );
		
		// Кадры покоя (48, 48, 48, 49)
		idle = new Animation( 2, true );
		idle.frames( frames, 48, 48, 48, 49 );
		
		// Кадры бега (54, 55, 56, 57, 58)
		run = new Animation( 10, true );
		run.frames( frames, 54, 55, 56, 57, 58 );
		
		// Кадры атаки (50, 51, 52, 53, 48)
		attack = new Animation( 15, false );
		attack.frames( frames, 50, 51, 52, 53, 48 );
		
		// Кадры смерти (59, 60, 61, 62)
		die = new Animation( 10, false );
		die.frames( frames, 59, 60, 61, 62 );
		
		play( idle );
	}
}

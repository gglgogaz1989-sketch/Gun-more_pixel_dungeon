package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;

public class NecroRatSprite extends RatSprite {
    public NecroRatSprite() {
        super();
        // Берем твой файл с розовоглазой крысой
        texture = Assets.RAT; 
    }

    @Override
    public void update() {
        super.update();
        // offset(0, 3) заставляет игру брать 4-й ряд в картинке (розовые глаза)
        offset( 0, 3 ); 
    }
}

package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.TextureFilm;

public class BallonSprite extends MobSprite {
    
    public BallonSprite() {
        super();
        
        // 1. Загружаем твою текстуру. 
        // Если ты не добавлял её в Assets.java, можно временно написать: texture("ballon.png");
        texture( "ballon.png" ); 
        
        // 2. Нарезаем кадры. У тебя шаг 16 пикселей.
        // TextureFilm(текстура, ширина_кадра, высота_кадра)
        TextureFilm frames = new TextureFilm( texture, 16, 16 );
        
        // 3. Состояние покоя (кадр 0 - 0x0)
        idle = new Animation( 1, true );
        idle.frames( frames, 0 );
        
        // 4. Анимация лопания (твои координаты 32, 48, 64, 80)
        // Это кадры № 2, 3, 4, 5 в твоей ленте
        die = new Animation( 12, false );
        die.frames( frames, 2, 3, 4, 5 );
        
        play( idle );
    }
}

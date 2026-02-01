package com.shatteredpixel.shatteredpixeldungeon.sprites;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.watabou.noosa.TextureFilm;

public class NecroRatSprite extends MobSprite {
    
    public NecroRatSprite() {
        super();
        
        // Используем стандартный ассет крысы
        texture( Assets.Sprites.RAT );
        // Нарезаем файл на кадры 16x16
        TextureFilm film = new TextureFilm( texture, 16, 16 );
        
        // Твой 4-й ряд (Некромант) начинается с 24-го кадра (если в ряду 8 кадров)
        int ROW = 24; 
        
        idle = new Animation( 10, true );
        idle.frames( film, ROW + 0, ROW + 1 );
        
        run = new Animation( 15, true );
        run.frames( film, ROW + 2, ROW + 3, ROW + 4, ROW + 5 );
        
        die = new Animation( 12, false );
        die.frames( film, ROW + 8, ROW + 9 );
        
        attack = new Animation( 15, false );
        attack.frames( film, ROW + 6, ROW + 7 );
        
        idle();
    }
}

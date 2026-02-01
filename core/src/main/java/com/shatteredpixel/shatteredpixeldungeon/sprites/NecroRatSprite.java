package com.shatteredpixel.shatteredpixeldungeon.sprites;

public class NecroRatSprite extends MobSprite {
    
    // Определяем смещение кадров для 4-го ряда (Некромант)
    private static final int ROW = 24; 

    public NecroRatSprite() {
        super();
        texture = Assets.RAT; // Используем стандартный файл, который ты дополнил
        
        // Настраиваем анимации, прибавляя смещение ROW к номерам кадров
        idle = new Animation( 10, true );
        idle.frames( ROW + 0, ROW + 1 ); // Кадры покоя

        run = new Animation( 15, true );
        run.frames( ROW + 2, ROW + 3, ROW + 4, ROW + 5 ); // Кадры бега

        attack = new Animation( 15, false );
        attack.frames( ROW + 6, ROW + 7 ); // Кадры атаки

        die = new Animation( 12, false );
        die.frames( ROW + 8, ROW + 9 ); // Кадры смерти
    }
          }

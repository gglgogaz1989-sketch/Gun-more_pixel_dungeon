package com.shatteredpixel.shatteredpixeldungeon.items;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.effects.FloatingText; // Убедись, что импорт есть
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
        image = 127; 
    }

    @Override
    public boolean doPickUp(Hero hero, int pos) {
        Catalog.setSeen(getClass());

        // Прибавляем в наш новый счетчик (если ты его уже создал в Dungeon.java)
        // Если еще не создал Dungeon.bullets, временно замени на Dungeon.gold
        Dungeon.bullets += quantity;

        GameScene.pickUp( this, pos );
        
        // ИСПРАВЛЕНО: Заменили FloatingText.ITEM на FloatingText.NEUTRAL
        hero.sprite.showStatusWithIcon( CharSprite.NEUTRAL, Integer.toString(quantity), FloatingText.NEUTRAL );
        
        hero.spendAndNext( pickupDelay() );
        
        // Оставляем крутой звук
        Sample.INSTANCE.play( Assets.Sounds.GOLD, 1, 1.4f, Random.Float( 1.1f, 1.3f ) );
        
        return true;
    }

    @Override
    public Item random() {
        quantity = Random.IntRange( 30, 60 );
        return this;
    }
}

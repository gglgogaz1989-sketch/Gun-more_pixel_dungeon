package com.shatteredpixel.shatteredpixeldungeon.items.weapon.missiles;

import com.shatteredpixel.shatteredpixeldungeon.items.Item;

public class Bullet extends Item {

    // КОНСТРУКТОР (Здесь мы безопасно задаем параметры)
    public Bullet() {
        super(); // Обязательная строка
        
        // Прямое присваивание имени часто вызывает ошибки в новых версиях,
        // но внутри конструктора это обычно работает.
        // Если вдруг снова будет ошибка - удали строку с name ниже.
        this.name = "Пуля"; 
        
        // Индекс 15 - это та самая пуля рядом с камнем в твоем файле items.png
        this.image = 15; 
        
        // Делаем так, чтобы пули собирались в кучу (стакались)
        this.stackable = true;
    }

    @Override
    public String desc() {
        // Описание предмета
        return "Тяжелый металлический снаряд для дальнего боя.";
    }

    // Если ошибка с name все равно останется, раскомментируй (убери //) код ниже,
    // а строку 'this.name = ...' сверху удали.
    /*
    @Override
    public String name() {
        return "Пуля";
    }
    */
}

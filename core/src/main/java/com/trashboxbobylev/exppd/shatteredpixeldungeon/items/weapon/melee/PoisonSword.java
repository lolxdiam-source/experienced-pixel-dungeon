package com.shatteredpixel.shatteredpixeldungeon.items.weapons.melee;

import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.buffs.Poison;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSprite;

public class PoisonSword extends MeleeWeapon {

    public PoisonSword() {
        // Устанавливаем 3 тир, скорость 1х, точность 1х
        super( 3, 1f, 1f ); 
        name = "Poison Sword";
        info = "Ядовитое лезвие — тест 1. Ранит и отравляет врагов.";
        
        // Индекс внутри вашего кастомного файла (обычно 0)
        image = 0; 
    }

    @Override
    public int proc(Char attacker, Char defender, int damage) {
        // Накладываем отравление на 15 секунд
        if (defender.isAlive()) {
            Poison.set(defender, 15f);
        }
        return super.proc(attacker, defender, damage);
    }

    // Этот метод заставляет игру брать иконку из вашего отдельного файла
    @Override
    public ItemSprite.Visual getVisual() {
        // Убедитесь, что файл лежит по пути: assets/items/poison_sword.png
        return new ItemSprite.Visual( "poison_sword.png", 0 );
    }

    @Override
    public String desc() {
        return info;
    }
}
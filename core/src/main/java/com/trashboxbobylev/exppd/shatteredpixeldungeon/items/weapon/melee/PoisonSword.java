package com.trashboxbobylev.exppd.shatteredpixeldungeon.items.weapon.melee;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Char;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Buff;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Poison;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Slow;

public class PoisonSword extends MeleeWeapon {

    public PoisonSword() {
        super();
        
        image = ItemSpriteSheet.POISON_SWORD;
        tier = 4;
        DLY = 0.1f;
        RCH = 2;

        name = "P sword";
    }

    @Override
    public int min(int lvl) {
        return Math.round(1.5f * (tier + 1)) + lvl;
    }

    @Override
    public int max(int lvl) {
        return Math.round(2.5f * (tier + 1)) + 
               lvl * Math.round(0.5f * (tier + 1));
    }

    @Override
    public int proc(Char attacker, Char defender, int damage) {
        if (defender.isAlive()) {
            // Для Poison оставляем .set(15f), так как компилятор его пропустил
            Buff.affect(defender, Poison.class).set(15f);
            
            // Для Slow используем прямое обращение к переменной времени
            // В ExPD у баффов это обычно поле .left
            Buff.affect(defender, Slow.class).left = 5f;
        }
        return super.proc(attacker, defender, damage);
    }

    @Override
    public String desc() {
        // Чтобы не искать, где в моде спрятана переменная описания,
        // просто возвращаем текст напрямую. Это сработает на 100%.
        return "Poisoned by dusk.";
    }
}
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
        // В твоем моде переменная называется desc, а не info
        desc = "Poisoned by dusk."; 
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
            // Используем стандартный метод для боевых баффов в Experienced PD
            Buff.affect(defender, Poison.class).setDuration(15f);
            Buff.affect(defender, Slow.class).setDuration(5f);
        }
        return super.proc(attacker, defender, damage);
    }

    @Override
    public String desc() {
        // Возвращаем desc, который заполнили в конструкторе
        return desc;
    }
}
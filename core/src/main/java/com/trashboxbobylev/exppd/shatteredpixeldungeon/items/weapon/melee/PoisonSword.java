package com.trashboxbobylev.exppd.shatteredpixeldungeon.items.weapon.melee;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Char;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Poison;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class PoisonSword extends MeleeWeapon {

    public PoisonSword() {
        // Конструктор: задаем минимальный урон, максимальный и название
        super(20, 28); 
        name = "poison sword";
        // Временно используем иконку обычного меча, чтобы билд прошел
        image = ItemSpriteSheet.SWORD; 
    }

    @Override
    public void proc(Char attacker, Char defender) {
        Poison p = new Poison();
        p.set(15f);
        defender.add(p);
    }

    @Override
    public String desc() {
        return "ядовитое лезвие-тест-1";
    }
}
package com.trashboxbobylev.exppd.shatteredpixeldungeon.items.weapon.melee;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Char;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Poison;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.sprites.ItemSprite;
import com.watabou.noosa.TextureFilm;

public class PoisonSword extends MeleeWeapon {

    {
        name = "poison sword";
    }

    @Override
    public int damageRoll() {
        return 28;
    }

    @Override
    public void proc(Char attacker, Char defender) {
        // В Experienced PD часто используется такой синтаксис для баффов
        defender.add(new Poison().set(15f));
    }

    // В исходнике TrashboxBobylev для кастомных картинок 
    // используется переопределение метода sprite() или прямое указание TextureFilm
    @Override
    public ItemSprite.Visual visual() {
        return new ItemSprite.Visual(0, new TextureFilm("PoisonSword.png", 32, 32));
    }

    @Override
    public String desc() {
        return "ядовитое лезвие-тест-1";
    }
}
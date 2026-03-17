package com.trashboxbobylev.exppd.shatteredpixeldungeon.items.weapon.melee;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Char;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Poison;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.sprites.ItemSprite;
import com.watabou.noosa.TextureFilm;

public class PoisonSword extends MeleeWeapon {

    {
        name = "poison sword";
    }

    // Убираем @Override, если он ругается, и используем стандартные переменные урона
    {
        min = 20;
        max = 28;
    }

    @Override
    public void proc(Char attacker, Char defender) {
        Poison p = new Poison();
        p.set(15f);
        defender.add(p);
    }

    // Если Visual не работает, попробуем переопределить создание самого спрайта
    @Override
    public ItemSprite sprite() {
        ItemSprite s = super.sprite();
        s.link(new TextureFilm("PoisonSword.png", 32, 32));
        s.frame(0);
        return s;
    }

    @Override
    public String desc() {
        return "ядовитое лезвие-тест-1";
    }
}
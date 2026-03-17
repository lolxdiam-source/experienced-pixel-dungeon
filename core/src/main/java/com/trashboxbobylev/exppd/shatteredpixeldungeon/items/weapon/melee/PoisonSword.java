package com.trashboxbobylev.exppd.shatteredpixeldungeon.items.weapon.melee;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Char;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Poison;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.sprites.ItemSprite;
import com.watabou.noosa.TextureFilm;

public class PoisonSword extends MeleeWeapon {
    {
        name = "poison sword";
        image = 0;
    }
    @Override 
    public int damageRoll() {
      return 28;
    }
    public void proc(Char attacker, Char defender) {
        defender.add(Poison.factory(defender, 15f));
    }
    @Override
    public ItemSprite.Visual getVisual() {
        return new ItemSprite.Visual(0, new TextureFilm("PoisonSword.png", 32, 32));
    }
    @Override
    public String desc() {
        return "ядовитое лезвие-тест-1";
    }
}
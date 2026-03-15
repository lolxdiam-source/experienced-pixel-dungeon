package com.trashboxbobylev.exppd.shatteredpixeldungeon.items.weapon.melee;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.items.Item;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Char;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.sprites.ItemSprite;

public class Dagger extends MeleeWeapon {
    {
        image = ItemSprite.DAGGER;
        tier = 5;
    }

    @Override
    public int max(int lvl) {
        return 100000000;
    }

    @Override
    public int damageRoll(Char owner) {
        return 100000000;
    }

    public int color() {
        return 0xFF0000;
    }
}
package com.trashboxbobylev.exppd.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixeldungeon.items.Item;
import com.shatteredpixeldungeon.actors.Char;
import com.shatteredpixeldungeon.items.spritesheet.ItemSpriteSheet;

public class Dagger extends MeleeWeapon {
    {
        image = ItemSpriteSheet.DAGGER;
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

    @Override
    public int color() {
    return com.shatteredpixeldungeon.items.Item.RED;
    }
}
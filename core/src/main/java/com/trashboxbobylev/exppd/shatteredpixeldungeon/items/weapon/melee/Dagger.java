package com.trashboxbobylev.exppd.shatteredpixeldungeon.items.weapon.melee;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Char;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.hero.Hero;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.mobs.Mob;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.Random;

public class Dagger extends MeleeWeapon {
    {
        image = ItemSpriteSheet.Dagger; 
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
}
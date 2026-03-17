package com.trashboxbobylev.exppd.shatteredpixeldungeon.items.weapon.melee;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Char;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Buff;
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
        // Накладываем яд через стандартный класс Buff
        Buff.affect(defender, Poison.class).set(15f);
    }

    @Override
    public void execute(Char user, String action) {
        super.execute(user, action);
    }

    // В EPD часто используется такой способ подгрузки отдельной иконки
    @Override
    public ItemSprite.Visual visual() {
        return new ItemSprite.Visual(0, new TextureFilm("PoisonSword.png", 32, 32));
    }

    @Override
    public String desc() {
        return "ядовитое лезвие-тест-1";
    }
}
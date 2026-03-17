package com.trashboxbobylev.exppd.shatteredpixeldungeon.items.weapon.melee;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Char;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Poison;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.sprites.ItemSprite;
import com.watabou.noosa.Image;

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
        // Пробуем наложить яд через стандартный метод, если .set не сработает
        Poison p = new Poison();
        p.set(15f);
        defender.add(p);
    }

    @Override
    public Image sprite() {
        // Мы просто создаем объект изображения напрямую из вашего файла
        Image img = new Image("PoisonSword.png");
        // Обрезаем его до размера 32x32, если файл больше
        img.scale.set(1, 1); 
        return img;
    }

    @Override
    public String desc() {
        return "ядовитое лезвие-тест-1";
    }
}
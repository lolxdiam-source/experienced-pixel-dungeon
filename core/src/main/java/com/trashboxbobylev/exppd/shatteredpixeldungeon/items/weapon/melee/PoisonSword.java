Да, лог подтверждает, что в этой версии движка у баффа Slow нет ни метода .set(), ни переменной .left. Это частое явление в разработке модов, когда разные баффы наследуются от разных классов.

Удаление проблемного кода — сейчас самое правильное решение, чтобы наконец-то получить рабочий билд и проверить сам меч (его скорость, урон и спрайт).

Финальный код PoisonSword.java (только с ядом):
Скопируй этот вариант, в нем нет ничего, что могло бы вызвать ошибку компиляции:

Java
package com.trashboxbobylev.exppd.shatteredpixeldungeon.items.weapon.melee;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Char;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Buff;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Poison;

public class PoisonSword extends MeleeWeapon {

    public PoisonSword() {
        super();
        
        image = ItemSpriteSheet.POISON_SWORD;
        tier = 4;
        DLY = 0.1f;
        RCH = 2;

        name = "P sword";
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
            // Оставляем только Poison, так как на него компилятор не ругался
            Buff.affect(defender, Poison.class).set(15f);
        }
        return super.proc(attacker, defender, damage);
    }

    @Override
    public String desc() {
        // Прямой возврат строки — самый безопасный метод
        return "Poisoned by dusk.";
    }
}
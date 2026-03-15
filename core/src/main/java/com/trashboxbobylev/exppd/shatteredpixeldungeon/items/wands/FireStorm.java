package com.trashboxbobylev.exppd.shatteredpixeldungeon.items.wands;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.Dungeon;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Actor;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Char;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.blobs.Fire;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Buff;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Burning;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.FireImmunity; // Иммунитет
import com.trashboxbobylev.exppd.shatteredpixeldungeon.effects.CellEmitter;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.effects.particles.FlameParticle;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.mechanics.Ballistica;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.PathFinder;

public class FireStorm extends WandOfFireblast {

    {
        // Оставляем ту же иконку или меняем на свою
        image = ItemSpriteSheet.WAND_FIREBOLT; 
    }

    @Override
    public int min(int lvl) { return 1000000; } // Миллион урона

    @Override
    public int max(int lvl) { return 1000000; }

    @Override
    protected void onZap(Ballistica bolt) {
        // 1. ЗАЩИТА: Перед взрывом даем игроку иммунитет к огню
        // Чтобы он не погиб от собственного шторма
        Buff.affect(curUser, FireImmunity.class).set(50f); 

        // 2. ШТОРМ: Создаем огонь во всех 8 клетках вокруг игрока
        for (int i = 0; i < PathFinder.CIRCLE8.length; i++) {
            int cell = curUser.pos + PathFinder.CIRCLE8[i];
            if (Dungeon.level.passable[cell]) {
                // Спавним густой огонь
                Fire fire = Dungeon.level.blobs.get(Fire.class);
                fire.seed(cell, 10); 
                
                // Визуальные искры
                CellEmitter.get(cell).burst(FlameParticle.FACTORY, 4);
                
                // Наносим урон врагам в радиусе шторма
                Char ch = Actor.findChar(cell);
                if (ch != null && ch != curUser) {
                    ch.damage(damageRoll(), this);
                    Buff.affect(ch, Burning.class).reignite(ch);
                }
            }
        }

        // 3. СТАНДАРТНЫЙ ВЫСТРЕЛ: Вызываем базовый конус огня из оригинала
        super.onZap(bolt);
    }

    @Override
    public String desc() {
        return "Этот посох излучает невыносимый жар. При использовании он окружает владельца " +
               "защитной аурой и вызывает сокрушительный огненный шторм.";
    }
}
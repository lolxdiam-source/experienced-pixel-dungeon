package com.trashboxbobylev.exppd.shatteredpixeldungeon.items.wands;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.Dungeon;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Actor;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.Char;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.blobs.Fire;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Buff;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.buffs.Burning;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.effects.CellEmitter;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.effects.particles.FlameParticle;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.mechanics.Ballistica;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.sprites.ItemSpriteSheet;
import com.watabou.utils.PathFinder;
import com.watabou.noosa.Camera; // Импорт для камеры (тряски)

public class FireStorm extends WandOfFireblast {

    {
        image = ItemSpriteSheet.WAND_FIREBOLT; 
    }

    @Override
    public int min(int lvl) { return 1000000; } 

    @Override
    public int max(int lvl) { return 1000000; }

    @Override
    protected void onZap(Ballistica bolt) {
        // Защищаем игрока от собственного огня
        Buff.detach(curUser, Burning.class);

        // Ищем или создаем объект огня на уровне
        Fire fire = (Fire)Dungeon.level.blobs.get(Fire.class);
        if (fire == null) {
            fire = new Fire();
            Dungeon.level.blobs.put(Fire.class, fire);
        }

        // Шторм вокруг героя
        for (int i = 0; i < PathFinder.CIRCLE8.length; i++) {
            int cell = curUser.pos + PathFinder.CIRCLE8[i];
            
            if (Dungeon.level.passable[cell]) {
                fire.seed(cell, 10, Fire.class, Dungeon.level);
                CellEmitter.get(cell).burst(FlameParticle.FACTORY, 4);
                
                Char ch = Actor.findChar(cell);
                if (ch != null && ch != curUser) {
                    ch.damage(damageRoll(), this);
                    Buff.affect(ch, Burning.class).reignite(ch);
                }
            }
        }

        // Добавляем немного «сочности»
        Camera.main.shake(4, 0.2f);
        
        super.onZap(bolt);
    }

    @Override
    public String desc() {
        return "Этот посох излучает невыносимый жар. При использовании он вызывает сокрушительный огненный шторм.";
    }
}
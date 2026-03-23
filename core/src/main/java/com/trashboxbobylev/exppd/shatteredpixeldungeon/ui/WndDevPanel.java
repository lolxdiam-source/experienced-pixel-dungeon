package com.trashboxbobylev.exppd.shatteredpixeldungeon.ui;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.Dungeon;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.hero.Hero;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.items.Generator;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.items.weapon.melee.PoisonSword;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.scenes.GameScene;

public class WndDevPanel extends WndOptions {

    public WndDevPanel() {
        super("CHEATS", "Select Dev Action:", 
            "Give Poison Sword", "Random T4 Weapon", "Level Up", "Reveal Map");
    }

    @Override
    public void onSelect(int index) {
        Hero hero = Dungeon.hero;
        switch (index) {
            case 0: // Выдать конкретно твой меч
                hero.collect(new PoisonSword());
                break;
            case 1: // Выдать случайное оружие 4 тира (включая твой меч)
                // randomWeapon(3) соответствует floorSet 3, который в таблице floorSetTierProbs 
                // дает высокие шансы на 4-й тир
                hero.collect(Generator.randomWeapon(3));
                break;
            case 2:
                hero.earnExp(hero.maxExp(), getClass());
                break;
            case 3:
                Dungeon.level.visualize();
                GameScene.flash(0xFFFFFF);
                break;
        }
    }
}
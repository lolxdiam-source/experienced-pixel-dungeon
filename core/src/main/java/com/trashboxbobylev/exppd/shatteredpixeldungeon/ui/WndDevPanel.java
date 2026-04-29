package com.trashboxbobylev.exppd.shatteredpixeldungeon.ui;

import com.trashboxbobylev.exppd.shatteredpixeldungeon.Dungeon;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.actors.hero.Hero;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.items.weapon.melee.PoisonSword;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.scenes.GameScene;
import com.trashboxbobylev.exppd.shatteredpixeldungeon.utils.GLog;

public class WndDevPanel extends Window {

    private static final int WIDTH = 120;
    private static final int BTN_HEIGHT = 20;

    public WndDevPanel() {
        super();

        Hero hero = Dungeon.hero;

        // Заголовок
        IconTitle title = new IconTitle();
        title.label("Dev Panel");
        title.setRect(0, 0, WIDTH, 20);
        add(title);

        // Кнопка: Выдать Poison Sword
        add(new RedButton("GET SWORD", WIDTH) {
            @Override
            protected void onClick() {
                hero.collect(new PoisonSword());
                GLog.i("Poison Sword added!");
            }
        }.setRect(0, 25, WIDTH, BTN_HEIGHT));

        // Кнопка: Уровень +1
        add(new RedButton("LEVEL UP", WIDTH) {
            @Override
            protected void onClick() {
                hero.earnExp(hero.maxExp() - hero.exp, getClass());
                GLog.p("Level Up!");
            }
        }.setRect(0, 50, WIDTH, BTN_HEIGHT));

        // Кнопка: Исцеление
        add(new RedButton("HEAL ME", WIDTH) {
            @Override
            protected void onClick() {
                hero.hp = hero.ht();
                hero.updateSpriteState();
                GLog.i("Health restored.");
            }
        }.setRect(0, 75, WIDTH, BTN_HEIGHT));

        // Кнопка: Открыть карту
        add(new RedButton("REVEAL MAP", WIDTH) {
            @Override
            protected void onClick() {
                Dungeon.level.visualize();
                GameScene.flash(0xFFFFFF);
                GLog.w("Map revealed!");
            }
        }.setRect(0, 100, WIDTH, BTN_HEIGHT));

        resize(WIDTH, 125);
    }
}
package net.bestwebart.game.level.tiles;

import net.bestwebart.game.gfx.Screen;
import net.bestwebart.game.gfx.Sprite;
import net.bestwebart.game.level.tiles.animated_tiles.MobTile;
import net.bestwebart.game.level.tiles.animated_tiles.Water;
import net.bestwebart.game.level.tiles.animated_tiles.Waves;
import net.bestwebart.game.level.tiles.static_tiles.Grass;
import net.bestwebart.game.level.tiles.static_tiles.Tree;
import net.bestwebart.game.level.tiles.static_tiles.Wall;

public abstract class Tile {

    protected int id;
    public Sprite sprite;

    protected boolean solid, destroyable, mob;
    protected int maxDamage = 0;
    
    public static Tile tiles[] = new Tile[100];

   
    public static final Tile VOID = new StaticTile(0, Sprite.VOID);
    
    public static final Tile GRASS = new Grass(1, Sprite.GRASS);
    public static final Tile WALL = new Wall(2, Sprite.WALL);
    public static final Tile TREE = new Tree(3, Sprite.TREE);
    public static final Tile WATER = new Water(4, Sprite.WATER, false, 500, 3);
    public static final Tile WAVES = new Waves(5, Sprite.WAVES, false, 400, 3);

    public static final Tile PLAYER_UP = new MobTile(20, Sprite.PLAYER_UP, true, 120, 3);
    public static final Tile PLAYER_DOWN = new MobTile(21, Sprite.PLAYER_DOWN, true, 120, 3);
    public static final Tile PLAYER_SIDE = new MobTile(22, Sprite.PLAYER_SIDE, true, 120, 3);

    public static final Tile TONNY_UP = new MobTile(23, Sprite.TONNY_UP, true, 120, 3);
    public static final Tile TONNY_DOWN = new MobTile(24, Sprite.TONNY_DOWN, true, 120, 3);
    public static final Tile TONNY_SIDE = new MobTile(25, Sprite.TONNY_SIDE, true, 120, 3);

    public static final Tile BAD_TONNY_UP = new MobTile(26, Sprite.BAD_TONNY_UP, true, 120, 3);
    public static final Tile BAD_TONNY_DOWN = new MobTile(27, Sprite.BAD_TONNY_DOWN, true, 120, 3);
    public static final Tile BAD_TONNY_SIDE = new MobTile(28, Sprite.BAD_TONNY_SIDE, true, 120, 3);

    public static final Tile SIMPLE_PROJECTILE = new StaticTile(50, Sprite.SIMPLE_PROJECTILE);

    public static final Tile PARTICLE = new StaticTile(70, Sprite.PARTICLE);
    public static final Tile BLOOD = new StaticTile(71, Sprite.BLOOD);
    public static final Tile SPARK = new StaticTile(72, Sprite.SPARK);
    
    public static final Tile HEART = new Wall(90, Sprite.HEART);

    public static final int GRASS_COL = 0xff00ff00;
    public static final int WALL_COL = 0xff151f25;
    public static final int WATER_COL = 0xff1c85fa;
    public static final int SPAWN_COL = 0xfff8f8f8;

    public Tile(int id, Sprite sprite, boolean solid) {
	this.id = id;
	
	if (id != -1) {
	    if (tiles[id] != null) {
		throw new RuntimeException("Duplicated tile: " + this + " at position:" + id);
	    }
	    tiles[id] = this;
	}
	
	this.sprite = sprite;
	this.solid = solid;
	
    }

    public int getID() {
	return id;
    }

    public abstract void update();

    public abstract void render(int x, int y, Screen screen);

    public boolean isSolid() {
	return solid;
    }

    public boolean canBeDamaged() {
	return destroyable;
    }

    public void changeSpriteTo(Sprite sprite) {
	this.sprite = sprite;
    }

    public int getMaxDamage() {
	return maxDamage;
    }
    
}

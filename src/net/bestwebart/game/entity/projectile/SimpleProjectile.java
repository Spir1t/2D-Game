package net.bestwebart.game.entity.projectile;

import net.bestwebart.game.entity.mob.Mob;
import net.bestwebart.game.gfx.Screen;
import net.bestwebart.game.level.tiles.Tile;

public class SimpleProjectile extends Projectile {

    public SimpleProjectile(double x, double y, double angle, Mob source) {
	super(x, y, source);
	this.angle = angle;
	this.tile = Tile.SIMPLE_PROJECTILE;
	
	range = 200;
	speed = 4;
	rate = 20;
	power = 10;

	size = 8;
	xOffset = yOffset = 8;

	nx = speed * Math.cos(angle);
	ny = speed * Math.sin(angle);

    }

    public void update() {
	super.update();
    }

    public void move() {
	if (getFlownDistance() < range) {
	    x += nx;
	    y += ny;
	} else {
	    remove();
	}
    }

    public void render(Screen screen) {
	screen.render((int) x, (int) y, tile, false);
    }
}

package net.bestwebart.game.entity.particle;

import net.bestwebart.game.gfx.Screen;
import net.bestwebart.game.level.tiles.Tile;

public class Pieces extends Particle {

    protected double xd, yd;
    protected double z, zd;

    public Pieces(double x, double y) {
	super(x, y, Tile.PARTICLE);
	this.life = 300 + rand.nextDouble() * 20;
	lastTime = System.currentTimeMillis();
	xd = rand.nextGaussian();
	yd = rand.nextGaussian();
	z = rand.nextFloat();
    }

    public void update() {
	if ((System.currentTimeMillis() - lastTime) > life) {
	    remove();
	} else {
	    zd -= 0.1;
	    if (z < 0) {
		z = -0.5;
		zd *= 0.5;
		xd *= 0.7;
		yd *= 0.7;
	    }
	    move((x + xd), (y + yd) + (z + zd));
	}
    }

    public void move(double nx, double ny) {
	if (isCollision(nx, ny)) {
	    xd *= -0.5;
	    yd *= -0.5;
	    zd *= -0.5;
	} else {
	    x += xd;
	    y += yd;
	    z += zd;
	}
    }

    public void render(Screen screen) {
	screen.render((int) x, (int) y - (int) z, tile, false);
    }

}

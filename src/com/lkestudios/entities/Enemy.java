package com.lkestudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lkestudios.main.Game;
import com.lkestudios.world.AStar;
import com.lkestudios.world.Vector2i;
import com.lkestudios.world.World;

public class Enemy extends Entity{

	private int framesAnimation = 0;
	private int maxFrames = 15;
	
	private int maxSprite = 2;
	private int curSprite = 0;
	
	public boolean right = true, left = false;
	public int lastdir = 1;
	
	public double vida = 30;
	
	public Enemy(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		path = AStar.findPath(Game.world, new Vector2i(World.xINITIAL, World.yINITIAL), new Vector2i(World.xFINAL, World.yFINAL));
	}

	public void tick() {	
		followPath(path);
		if(x >= Game.WIDTH) {
			//perdemos vida aqui
			Game.vida-= Entity.rand.nextDouble();
			Game.entities.remove(this);
			return;
		}
		
		if(vida <=0 ) {
			Game.entities.remove(this);
			Game.dinheiro++;
			return;
		}
	}
	
	public void render(Graphics g) {
		super.render(g);
		g.setColor(Color.red);
		g.fillRect((int)x,(int)(y-5), 30, 6);
		
		g.setColor(Color.green);
		g.fillRect((int)x,(int)(y-5),(int)((vida/30)*30), 6);
	}
	
}


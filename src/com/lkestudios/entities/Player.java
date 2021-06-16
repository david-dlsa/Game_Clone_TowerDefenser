package com.lkestudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.lkestudios.main.Game;
import com.lkestudios.world.Camera;
import com.lkestudios.world.World;

public class Player extends Entity{

	public int xTarget, yTarget;
	public boolean atacando;
	
	public Player(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);

	
	}
	
	public void tick() {
		Enemy enemy = null;
		for(int i = 0; i< Game.entities.size(); i++) {
			Entity e = Game.entities.get(i);
			if(e instanceof Enemy) {
				int xEnemy = e.getX();
				int yEnemy = e.getY();
				if(Entity.calculateDistance(this.getX(), this.getY(), xEnemy, yEnemy) < 40) {
					enemy = (Enemy)e;
				}
			}
		}
		
		if(enemy != null) {
			atacando = true;
			xTarget = enemy.getX();
			yTarget = enemy.getY();
			if(Entity.rand.nextInt(100) < 20) {
				enemy.vida-=Entity.rand.nextDouble();
			}
		}
		else{
			atacando = false;
		}
	}
	
	public void render(Graphics g) {
		super.render(g);
		//mostrar ataque as torres
		if(atacando) {
			g.setColor(Color.red);
			g.drawLine((int)x+6, (int)y+6, xTarget+6, yTarget+6);
		}
	}
	
}
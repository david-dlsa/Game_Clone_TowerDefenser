package com.lkestudios.entities;

import java.awt.image.BufferedImage;

import com.lkestudios.main.Game;
import com.lkestudios.world.World;

public class TowerController extends Entity{

	public boolean isPressed = false;
	public int xTarget, yTarget;
	
	public TowerController(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
		// TODO Auto-generated constructor stub
	}

	
	public void tick() {
		if(isPressed) {
			isPressed = false;
			boolean liberado = true;
			//criar torre no mapa
			int xx = (xTarget/16) * 16;
			int yy = (yTarget/16) * 16;
			Player player = new Player(xx,yy,16,16,0,Game.spritesheet.getSprite(32, 0, 16, 16));
			for(int i = 0; i < Game.entities.size(); i++) {
				Entity e = Game.entities.get(i);
				if(e instanceof Player) {
					if(Entity.isColidding(e, player)) {
						liberado = false;
						System.out.println("n posso add, ja tem torre");
					}
				}
			}
			
		if(World.isFree(xx, yy)){
			liberado = false;
			System.out.println("posicao ocupado pelo mapa");
		}
			
			if(liberado) {
				if(Game.dinheiro >= 2) {
					Game.entities.add(player);
					Game.dinheiro -= 20;
				}
				else {
					System.out.println("Sem dinheiro");
				}
			}
		}
		if(Game.vida <= 0) {
			//game over
			System.exit(1);
		}
	}
}

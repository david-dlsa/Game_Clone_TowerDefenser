package com.lkestudios.graficos;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

import com.lkestudios.entities.Player;
import com.lkestudios.main.Game;

public class UI {
	
	public static BufferedImage HEART = Game.spritesheet.getSprite(0, 32, 8, 8);
	
	public void render(Graphics g) {
		for(int i = 0; i < (int)(Game.vida); i++) {
			g.drawImage(HEART, 15 + (i*40), 10, 36, 36, null);
		}
		
		g.setFont((new Font("arial", Font.BOLD, 24)));
		g.setColor(Color.white);
		g.drawString("$" + Game.dinheiro, (Game.WIDTH * Game.SCALE) - 60, 24);
	}
}
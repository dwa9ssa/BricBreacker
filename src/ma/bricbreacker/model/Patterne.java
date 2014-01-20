package ma.bricbreacker.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Texture;

public class Patterne {
	
	private float borderMarging;
	private int margeBrique = 150 ;
	private int nbrBrique = 15;

	// TODO 
	private Texture briqueTexture = new Texture("data/brique.png");
	private Texture blockTexture = new Texture("data/block.png");
	
	private List<Brique> listImageBrique = new ArrayList<Brique>();
	private List<Block> listImageBlock = new ArrayList<Block>();

	public Patterne(float w, float h, int margeBrique, int nbrBrique) {
		this.margeBrique = margeBrique;
		this.nbrBrique = nbrBrique;
		
		int nbrCols;
		nbrCols = (int) w / (briqueTexture.getWidth() + margeBrique);
		
		int currentCols = 0;
		
//		for (int i = 0; i < nbrBrique; i++) {
//			
//			if ((i % nbrCols) == 0) {
//				currentCols++;
//			}
//			
//			Brique brique = new Brique(briqueTexture);
//			brique.setX(margeBrique + ((i % nbrCols) * (brique.getWidth() + margeBrique)));
//			brique.setY(h - (currentCols * (brique.getHeight() + margeBrique)));
//
//			brique.makeLines();
//			
//			listImageBrique.add(brique);
//		}
		
		for (int i = 0; i < nbrBrique; i++) {
			
			if ((i % nbrCols) == 0) {
				currentCols++;
			}

			if (i % 2 == 0) {
				Brique brique = new Brique(briqueTexture);
				brique.setX(margeBrique + ((i % nbrCols) * (brique.getWidth() + margeBrique)));
				brique.setY(h - (currentCols * (brique.getHeight() + margeBrique)));
	
				brique.makeLines();
				
				this.getListImageBrique().add(brique);
			} else {
				Block block = new Block(blockTexture);
				block.setX(margeBrique + ((i % nbrCols) * (block.getWidth() + margeBrique)));
				block.setY(h - (currentCols * (block.getHeight() + margeBrique)));
	
				block.makeLines();
				
				this.getListImageBlock().add(block);
			}
		}
		
	}
	
	public List<Image> getListImage() {
		List<Image> list = new ArrayList<Image>();

		list.addAll(this.getListImageBlock());
		list.addAll(this.getListImageBrique());
		
		return list;
	}
	
	public List<Brique> getListImageBrique() {
		return listImageBrique;
	}
	public void setListImageBrique(List<Brique> listImageBrique) {
		this.listImageBrique = listImageBrique;
	}
	public List<Block> getListImageBlock() {
		return listImageBlock;
	}
	public void setListImageBlock(List<Block> listImageBlock) {
		this.listImageBlock = listImageBlock;
	}
}

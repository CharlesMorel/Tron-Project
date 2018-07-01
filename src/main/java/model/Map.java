package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;

import contract.model.IElement;
import contract.model.IMap;
import model.element.motionless.MotionlessElementFactory;

public class Map extends Observable implements IMap {
	
	private int width = 600;
	
	private int height = 400;
	
	private IElement[][] onTheMap;
	
    Map(final int MapFile) throws IOException {
        super();
        try {
        	this.loadFile(MapFile);
        } catch(SQLException e) {
        	e.printStackTrace();
        }
        
    }
    
    private void loadFile(final String fileName) throws IOException {
        final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        int y = 0;
        line = buffer.readLine();
        this.setWidth(Integer.parseInt(line));
        line = buffer.readLine();
        this.setHeight(Integer.parseInt(line));
        this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
        line = buffer.readLine();
        while (line != null) {
            for (int x = 0; x < line.toCharArray().length; x++) {
                this.setOnTheMapXY(MotionlessElementFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
            }
            line = buffer.readLine();
            y++;
        }
        buffer.close();
    }
	
	
	

	public IElement[][] getOnTheMapXY() {
		return onTheMap;
	}

	public void setOnTheMapXY(IElement[][] element, final int x, final int y) {
		this.onTheMap[x][y] = element;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	//@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public IElement getOnTheMapXY(int x, int y) {
		// TODO Auto-generated method stub
		return this.onTheMap[x][y];
	}

	//@Override
	public void setMobileHasChanged() {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public Observable getObservable() {
		// TODO Auto-generated method stub
		return null;
	}

}

package model.element.mobile;

import java.awt.Point;

import contract.model.IMap;
import contract.model.IMobile;
import contract.model.Permeability;
import model.elements.Element;
import model.elements.Sprite;
import showboard.IBoard;

public class Mobile extends Element implements IMobile {
	
	private Point position;
	
	protected Boolean player1Alive;
	
	protected Boolean player2Alive;
	
	private IMap map;
	
	protected static Boolean win = false;
	
	public static int startXPlayer1;
	
	public static int startYPlayer1;
	
	public static int startXPlayer2;
	
	public static int startYPlayer2;
	
	public static int startXLightWall1;
	
	public static int startYLightWall1;
	
	public static int startXLightWall2;
	
	public static int startYLightWall2;
	
	Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
		this.position = new Point();
	}
	
	protected Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
		this(sprite, map, permeability);
		this.setX(x);
		this.setY(y);
	}
	
	//@Override
	public void doNothing() {
		this.setHasMoved();
	}
	
	private void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}
	
	//@Override
	public int getX() {
		return this.getPosition().x;
	}
	
	public final void setX(final int x) {
		this.getPosition().x = x;
	}
	
	//@Override
	public int getY() {
		return this.getPosition().y;
	}
	
	public final void setY(final int y) {
		this.getPosition().y = y;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}
	
	//@Override
    public Boolean player1IsAlive() {
        return this.player1Alive;
    }
    
    //@Override
    public void player1Alive() {
    	this.player1Alive = true;
    }
    
    //@Override
    public Boolean player2IsAlive() {
        return this.player2Alive;
    }
    
    //@Override
    public void player2Alive() {
    	this.player2Alive = true;
    }
    
    //@Override
    public Boolean isCrashed() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }
    
    
    protected IBoard getBoard() {
        return this.board;
    }
    
	public void player1Die(){
		if(this.getX() == LightWall1.getX() && this.getY() == LightWall1.getPosition().y) {
			this.player1Alive = false;
			this.setHasMoved();
		}
	}
	
	public void player2Die(){
		if(this.getX() == LightWall2.getPosition().x && this.getY() == LightWall2.getPosition().y) {
			this.player1Alive = false;
			this.setHasMoved();
		}
	}
    
	//@Override
	public Boolean player1Win() {
		//if (this.getX() == lightWall1 && this.getY() == StartyGate && DoorOpened == true) {
		if(this.player2IsAlive() == false) {
			return true;
		}
		return false;
	}
	
	//@Override
	public Boolean player2Win() {
		if (this.player1IsAlive() == false) {
			return true;
		}
		return false;
	}
	

	public void setPlayer1Alive(Boolean player1Alive) {
		this.player1Alive = player1Alive;
	}
	
	public Boolean getPLayer2Alive() {
		return player2Alive;
	}

	public void setPlayer2Alive(Boolean player2Alive) {
		this.player2Alive = player2Alive;
	}

	public IMap getMap() {
		return map;
	}

	public void setMap(IMap map) {
		this.map = map;
	}

	public static Boolean getWin() {
		return win;
	}

	public static void setWin(Boolean win) {
		Mobile.win = win;
	}

	public static int getStartXPlayer1() {
		return startXPlayer1;
	}

	public static void setStartXPlayer1(int startXPlayer1) {
		Mobile.startXPlayer1 = startXPlayer1;
	}

	public static int getStartYPlayer1() {
		return startYPlayer1;
	}

	public static void setStartYPlayer1(int startYPlayer1) {
		Mobile.startYPlayer1 = startYPlayer1;
	}

	public static int getStartXPlayer2() {
		return startXPlayer2;
	}

	public static void setStartXPlayer2(int startXPlayer2) {
		Mobile.startXPlayer2 = startXPlayer2;
	}

	public static int getStartYPlayer2() {
		return startYPlayer2;
	}

	public static void setStartYPlayer2(int startYPlayer2) {
		Mobile.startYPlayer2 = startYPlayer2;
	}

	//@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public void sameDirection() {
		// TODO Auto-generated method stub
		
	}

	//@Override
	public int getStartxPlayer1() {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public int getStartyPlayer1() {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public int getStartxPlayer2() {
		// TODO Auto-generated method stub
		return 0;
	}

	//@Override
	public int getStartyPlayer2() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int getStartXLightWall1() {
		return startXLightWall1;
	}

	public static void setStartXLightWall1(int startXLightWall1) {
		Mobile.startXLightWall1 = startXLightWall1;
	}

	public static int getStartYLightWall1() {
		return startYLightWall1;
	}

	public static void setStartYLightWall1(int startYLightWall1) {
		Mobile.startYLightWall1 = startYLightWall1;
	}

	public static int getStartXLightWall2() {
		return startXLightWall2;
	}

	public static void setStartXLightWall2(int startXLightWall2) {
		Mobile.startXLightWall2 = startXLightWall2;
	}

	public static int getStartYLightWall2() {
		return startYLightWall2;
	}

	public static void setStartYLightWall2(int startYLightWall2) {
		Mobile.startYLightWall2 = startYLightWall2;
	}

	//@Override
	public Boolean player1IsFacingLightWall() {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public Boolean player2IsFacingLightWall() {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
	public void playerIsFacingSomething() {
		// TODO Auto-generated method stub
		
	}

	

}

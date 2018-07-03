package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import contract.model.IMap;
import contract.model.IMobile;
import contract.model.ISprite;
import contract.model.Permeability;
import model.elements.Element;
import showboard.IBoard;

public abstract class Mobile extends Element implements IMobile {
    /**
     * The x.
     */
    private Point   position;


    /** The alive. */
    protected Boolean alive;

    /** The road. */
    private IMap  map;

    /** The board. */
    private IBoard  board;


	public static int StartXLightWall1;
    
    public static int StartYLightWall1;
    
    public static int StartXLightWall2;
    
    public static int StartYLightWall2;
    
    
    

    public static int getStartXLightWall2() {
		return StartXLightWall2;
	}

	public static void setStartXLightWall2(int startXLightWall2) {
		StartXLightWall2 = startXLightWall2;
	}

	public static int getStartYLightWall2() {
		return StartYLightWall2;
	}

	public static void setStartYLightWall2(int startYLightWall2) {
		StartYLightWall2 = startYLightWall2;
	}

	public static int getStartYLightWall1() {
		return StartYLightWall1;
	}

	public static void setStartYLightWall1(int startYLightWall1) {
		StartYLightWall1 = startYLightWall1;
	}

	public static int getStartXLightWall1() {
		return StartXLightWall1;
	}

	public static void setStartXLightWall1(int startXLightWall1) {
		StartXLightWall1 = startXLightWall1;
	}

	/**
     * Instantiates a new mobile.
     *
     * @param sprite
     *            the sprite
     * @param road
     *            the road
     * @param permeability
     *            the permeability
     */
    Mobile(final ISprite sprite, final IMap map, final Permeability permeability) {
        super(sprite, permeability);
        this.setMap(map);
        this.position = new Point();
    }

    /**
     * Instantiates a new mobile.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param sprite
     *            the sprite
     * @param road
     *            the road
     * @param permeability
     *            the permeability
     */
    Mobile(final int x, final int y, final ISprite sprite, final IMap map, final Permeability permeability) {
        this(sprite, map, permeability);
        this.setX(x);
        this.setY(y);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveUp()
     */
    @Override
    public void moveUp() throws IOException {
        this.setY(this.getY() - 1);
        this.setLightWall1(new LightWall1(this.getPosition().x, this.getPosition().y, this.getMap()));
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveLeft()
     */
    @Override
    public void moveLeft() throws IOException {
        this.setX(this.getX() - 1);
        this.setLightWall1(new LightWall1(this.getPosition().x, this.getPosition().y, this.getMap()));
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveDown()
     */
    @Override
    public void moveDown() throws IOException {
        this.setY(this.getY() + 1);
        this.setLightWall1(new LightWall1(this.getPosition().x, this.getPosition().y, this.getMap()));
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveRight()
     */
    @Override
    public void moveRight() throws IOException {
        this.setX(this.getX() + 1);
        this.setLightWall1(new LightWall1(this.getPosition().x, this.getPosition().y, this.getMap()));
        this.setHasMoved();
    }
	public void setLightWall1(IMobile lightWall1) {
	}
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#doNothing()
     */
    @Override
    public void doNothing() {
        this.setHasMoved();
    }

    /**
     * Sets the has moved.
     */
    private void setHasMoved() {
        this.getMap().setMobileHasChanged();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getX()
     */
    @Override
    public final int getX() {
        return this.getPosition().x;
    }

    /**
     * Sets the x.
     *
     * @param x
     *            the new x
     */
    public final void setX(final int x) {
        this.getPosition().x = x;
        if (this.isCrashed()) {
            this.die();
        }
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getY()
     */
    @Override
    public final int getY() {
        return this.getPosition().y;
    }

    /**
     * Sets the y.
     *
     * @param y
     * 
     */
    public final void setY(final int y) {
        this.getPosition().y = y;
        if (this.isCrashed()) {
            this.die();
        }
    }

    /**
     * Gets the road.
     *
     * @return the road
     */
    public IMap getMap() {
        return this.map;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the new road
     */
    private void setMap(final IMap map) {
        this.map = map;
    }

    public void alive() {
    	this.alive = true;
    }
    
    @Override
    public Boolean isAlive() {
        return this.alive;
    }
    /**
     * Dies.
     */
    protected void die() {
        this.alive = false;
        this.setHasMoved();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isCrashed()
     */
    @Override
    public Boolean isCrashed() {
    	return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getPosition()
     */
    @Override
    public Point getPosition() {
        return this.position;
    }

    /**
     * Sets the position.
     *
     * @param position
     *            the position to set
     */
    public void setPosition(final Point position) {
        this.position = position;
    }

    /**
     * Gets the board.
     *
     * @return the board
     */
    protected IBoard getBoard() {
        return this.board;
    }

}

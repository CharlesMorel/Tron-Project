package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import contract.controller.IOrderPerformer;
import contract.controller.UserOrder;
import contract.model.IMap;
import contract.model.IMobile;
import contract.view.IView;
import showboard.BoardFrame;


public class View implements IView, Runnable, KeyListener {

    /** The Constant squareSize. */
    private static final int squareNumberWidth = 60;
    
    /** The Constant squareSize. */
    private static final int squareNumberHeight = 40;
    
    /** The Constant squareSize. */
    private static final int squareSize = 50;

    /** The Constant closeView. */
    private Rectangle        closeView;

    /** The level. */
    private IMap           map;

    /** The lorann. */
    private IMobile          player1;
    
    private IMobile          player2;

    /** The order performer. */
    private IOrderPerformer  orderPerformer;
    
   // /** The square of the window with a black background" */
   // private Tile tile = new Tile("BlackTile.jpg");

    /**
     * Instantiates a new View.
     * @param model 
     * @param model 
     *
     * @param road
     *            the road
     * @param myVehicle
     *            the my vehicle
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public View(final IMap map, final IMobile player1, final IMobile player2) throws IOException {
        this.setMap(map);
        this.setPlayer1(player1);
        this.setPlayer2(player2);
        this.getPlayer1().getSprite().loadImage();
        this.getPlayer2().getSprite().loadImage();
        this.setCloseView(new Rectangle(0, 0, squareNumberWidth, squareNumberHeight));
        SwingUtilities.invokeLater(this);
    }

/**
    * Display a message in a popup
    */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

   /**
    * Thread that run the window
    */
	@Override
    public final void run() {
        final BoardFrame boardFrame = new BoardFrame("Tron");
        boardFrame.setDimension(new Dimension(squareNumberWidth, squareNumberHeight));
        boardFrame.setDisplayFrame(this.getCloseView());
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);

        for (int x = 0; x < squareNumberWidth; x++) {
            for (int y = 0; y < squareNumberHeight; y++) {
                boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y); //not sure (tile ?)
            }
        }
        
        
        boardFrame.addPawn(this.getPlayer1());
        
        boardFrame.addPawn(this.getPlayer2());

        this.getMap().getObservable().addObserver(boardFrame.getObserver());
        
        boardFrame.setVisible(true);
    }

    /**
     * Key code to user order.
     *
     * @param keyCode
     *            the key code
     * @return the user order
     */
    private static UserOrder keyCodeToUserOrder(final int keyCode) {
        UserOrder userOrder;
                
        switch (keyCode) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
            	userOrder = UserOrder.RIGHT;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_Q:
                userOrder = UserOrder.LEFT;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_Z:
                userOrder = UserOrder.UP;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                userOrder = UserOrder.DOWN;
                break;
            default:
                userOrder = UserOrder.NOP;
                break;
        }
        return userOrder;
    }

    /**
     * Not used
     */
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        // Not used
    }

    /**
     * Catch the user keyPressed and send it to the userOrderPerformer
     */
    @Override
    public final void keyPressed(final KeyEvent keyEvent) {
        try {
            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Not used
     */
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
        // Not used
    }

    /**
     * Gets the level.
     *
     * @return the level
     */
    private IMap getMap() {
        return this.map;
    }

    /**
     * Sets the level.
     *
     * @param level
     *            the new level
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void setMap(final IMap map) throws IOException {
        this.map = map;
        for (int x = 0; x < View.squareNumberWidth; x++) {
            for (int y = 0; y < View.squareNumberHeight; y++) {
                this.getMap().getOnTheMapXY(x, y).getSprite().loadImage(); //not sure
            }
        }
    }

    /**
     * Gets my vehicle.
     *
     * @return my vehicle
     */
    private IMobile getPlayer1() {
        return this.player1;
    }
    
    private IMobile getPlayer2() {
        return this.player2;
    }

    /**
     * Sets my vehicle.
     *
     * @param myVehicle
     *            my new vehicle
     */
    private void setPlayer1(final IMobile player1) {
        this.player1 = player1;
    }
    
    private void setPlayer2(final IMobile player2) {
        this.player2 = player2;
    }


    /**
     * Gets the close view.
     *
     * @return the close view
     */
    private Rectangle getCloseView() {
        return this.closeView;
    }

    /**
     * Sets the close view.
     *
     * @param closeView
     *            the new close view
     */
    private void setCloseView(final Rectangle closeView) {
        this.closeView = closeView;
    }

    /**
     * Gets the order performer.
     *
     * @return the order performer
     */
    private IOrderPerformer getOrderPerformer() {
        return this.orderPerformer;
    }

    /**
     * Sets the order performer.
     *
     * @param orderPerformer
     *            the new order performer
     */
    public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }
}

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
import contract.model.IModel;
import contract.view.IView;
import showboard.BoardFrame;

public class View implements IView, Runnable, KeyListener {
	
	private static final int squareNumberWidth = 600;
	
	private static final int squareNumberHeight = 400;
	
    private static final int squareSize = 50;
	
	private Rectangle closeView;
	
	private IMap map;
	
	private IMobile player1;
	
	private IMobile player2;
	
    private IOrderPerformer orderPerformer;
	
	
    public View(final IMap map, final IMobile player1, final IMobile player2, IModel Model) throws IOException {
    	
        this.setMap(map);
        
        this.setPlayer1(player1);
        this.getPlayer1().getSprite().loadImage();
        
        this.setPlayer2(player2);
        this.getPlayer1().getSprite().loadImage();
        
        this.setCloseView(new Rectangle(0, 0, squareNumberWidth, squareNumberHeight));
        SwingUtilities.invokeLater(this);
    }
	

	//@Override
    public final void run() {
        final BoardFrame boardFrame = new BoardFrame("Lorann");
        boardFrame.setDimension(new Dimension(squareNumberWidth, squareNumberHeight));
        boardFrame.setDisplayFrame(this.getCloseView());
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);
        boardFrame.setLocationRelativeTo(null);

        for (int x = 0; x < squareNumberWidth; x++) {
            for (int y = 0; y < squareNumberHeight; y++) {
                boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
            }
        }
        
        boardFrame.addPawn(this.getPlayer1());
        
        boardFrame.addPawn(this.getPlayer2());

        this.getMap().getObservable().addObserver(boardFrame.getObserver());
        
        boardFrame.setVisible(true);
    }
	
	
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
                
        }
        return userOrder;
    }
    

	public Rectangle getCloseView() {
		return closeView;
	}



	public void setCloseView(Rectangle closeView) {
		this.closeView = closeView;
	}



	public IMap getMap() {
		return map;
	}

	

	public void setMap(IMap map) throws IOException {
		this.map = map;
		
        for (int x = 0; x < View.squareNumberWidth; x++) {
            for (int y = 0; y < View.squareNumberHeight; y++) {
                this.getMap().getOnTheMapXY(x, y).getSprite().loadImage(); //not sure
            }
        }
	}



	private IMobile getPlayer1() {
		return player1;
	}



	private void setPlayer1(IMobile player1) {
		this.player1 = player1;
	}



	private IMobile getPlayer2() {
		return player2;
	}



	private void setPlayer2(IMobile player2) {
		this.player2 = player2;
	}



	public static int getSquarenumberwidth() {
		return squareNumberWidth;
	}



	public static int getSquarenumberheight() {
		return squareNumberHeight;
	}



	public static int getSquaresize() {
		return squareSize;
	}


	public IOrderPerformer getOrderPerformer() {
		return orderPerformer;
	}
	

	//@Override
	public void keyPressed(KeyEvent arg0) {
        try {
            this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
        } catch (final IOException exception) {
            exception.printStackTrace();
        }
	}

	//@Override
	public void keyReleased(KeyEvent arg0) {
		// not used
		
	}

	//@Override
	public void keyTyped(KeyEvent arg0) {
		// not used
		
	}


	//@Override
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
		
	}

	//@Override
	public void setOrderPerformer(IOrderPerformer orderPerformer) {
		// TODO Auto-generated method stub
		
	}

}

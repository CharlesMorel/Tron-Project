package controller;

import java.io.IOException;

import contract.controller.IController;
import contract.controller.IOrderPerformer;
import contract.controller.UserOrder1;
import contract.controller.UserOrder2;
import contract.model.IModel;
import contract.view.IView;

public class Controller implements IController, IOrderPerformer {

    /** The Constant speed of the thread. */
    private static final int speed = 150;

    /** The view. */
    private IView view;

    /** The model. */
    private IModel model;

    /** The stack order. */
    private UserOrder1 stackOrder1;
    
    private UserOrder2 stackOrder2;
    
    String dirPlayer1 = "right";
    
    String dirPlayer2 = "left";
    

	
    public UserOrder1 getStackOrder1() {
		return stackOrder1;
	}

	public void setStackOrder1(UserOrder1 stackOrder1) {
		this.stackOrder1 = stackOrder1;
	}

	public UserOrder2 getStackOrder2() {
		return stackOrder2;
	}

	public void setStackOrder2(UserOrder2 stackOrder2) {
		this.stackOrder2 = stackOrder2;
	}

	/**
     * Instantiates a new Lorann controller.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
	    this.setModel(model);
	    this.clearStackOrder1();
	    this.clearStackOrder2();
	}

	/**
	 * Drive the game, player movement and threading
	 * @throws IOException 
	 */
	@Override
	public void play() throws InterruptedException, IOException {
		getModel().getPlayer1().alive();
		
		getModel().getPlayer2().alive();
		while (this.getModel().getPlayer1().isAlive() && this.getModel().getPlayer2().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder1()) {
                case RIGHT1:
                	switch(dirPlayer1) {
                		case "right":
                			this.getModel().getPlayer1().moveDown();
                			dirPlayer1 = "down";
                		break;
                		case "left":
                			this.getModel().getPlayer1().moveUp();
                			dirPlayer1 = "up";
                		break;
                		case "up":
                			this.getModel().getPlayer1().moveRight();
                			dirPlayer1 = "right";
                		break;
                		case "down":
                			this.getModel().getPlayer1().moveLeft();
                			dirPlayer1 = "left";
                		break;
                	}
                    break;
                case LEFT1:
                	switch(dirPlayer1) {
	            		case "right":
	            			this.getModel().getPlayer1().moveUp();
	            			dirPlayer1 = "up";
	            		break;
	            		case "left":
	            			this.getModel().getPlayer1().moveDown();
	            			dirPlayer1 = "down";
	            		break;
	            		case "up":
	            			this.getModel().getPlayer1().moveLeft();
	            			dirPlayer1 = "left";
	            		break;
	            		case "down":
	            			this.getModel().getPlayer1().moveRight();
	            			dirPlayer1 = "right";
	            		break;
                	}
                    break;
                case NOP1:
                	default:
                    	switch(dirPlayer1) {
    	            		case "right":
    	            			this.getModel().getPlayer1().moveRight();
    	            			dirPlayer1 = "right";
    	            		break;
    	            		case "left":
    	            			this.getModel().getPlayer1().moveLeft();
    	            			dirPlayer1 = "left";
    	            		break;
    	            		case "up":
    	            			this.getModel().getPlayer1().moveUp();
    	            			dirPlayer1 = "up";
    	            		break;
    	            		case "down":
    	            			this.getModel().getPlayer1().moveDown();
    	            			dirPlayer1 = "down";
    	            		break;
                    	}
                	break;
            }
            this.clearStackOrder1();
            
            switch (this.getStackOrder2()) {
	            case RIGHT2:
	            	switch(dirPlayer2) {
	            		case "right":
	            			this.getModel().getPlayer2().moveDown();
	            			dirPlayer2 = "down";
	            		break;
	            		case "left":
	            			this.getModel().getPlayer2().moveUp();
	            			dirPlayer2 = "up";
	            		break;
	            		case "up":
	            			this.getModel().getPlayer2().moveRight();
	            			dirPlayer2 = "right";
	            		break;
	            		case "down":
	            			this.getModel().getPlayer2().moveLeft();
	            			dirPlayer2 = "left";
	            		break;
	            	}
                break;
            case LEFT2:
            	switch(dirPlayer2) {
            		case "right":
            			this.getModel().getPlayer2().moveUp();
            			dirPlayer2 = "up";
            		break;
            		case "left":
            			this.getModel().getPlayer2().moveDown();
            			dirPlayer2 = "down";
            		break;
            		case "up":
            			this.getModel().getPlayer2().moveLeft();
            			dirPlayer2 = "left";
            		break;
            		case "down":
            			this.getModel().getPlayer2().moveRight();
            			dirPlayer2 = "right";
            		break;
            	}
                break;
            case NOP2:
            	default:
                	switch(dirPlayer2) {
	            		case "right":
	            			this.getModel().getPlayer2().moveRight();
	            			dirPlayer2 = "right";
	            		break;
	            		case "left":
	            			this.getModel().getPlayer2().moveLeft();
	            			dirPlayer2 = "left";
	            		break;
	            		case "up":
	            			this.getModel().getPlayer2().moveUp();
	            			dirPlayer2 = "up";
	            		break;
	            		case "down":
	            			this.getModel().getPlayer2().moveDown();
	            			dirPlayer2 = "down";
	            		break;
                	}
            	break;
	        }
	        this.clearStackOrder2();

        }
		if(this.getModel().getPlayer1().isAlive() == false) {
			this.getView().displayMessage("Player 1 is dead ... Congratulations to Player 2 !");
		}
		if(this.getModel().getPlayer2().isAlive() == false) {
			this.getView().displayMessage("Player 2 is dead ... Congratulations to Player 1 !");
		}
	}
	
    /**
     * Write the UserOrder in the stack of order (stackOrder)
     */
	@Override
	public void orderPerform1(UserOrder1 userOrder1) throws IOException {
		this.setStackOrder1(userOrder1);
	}
	@Override
	public void orderPerform2(UserOrder2 userOrder2) throws IOException {
		this.setStackOrder2(userOrder2);
	}
	
    /**
     * Gets the view.
     *
     * @return the view
     */
    private IView getView() {
        return this.view;
    }
    
    /**
     * Sets the view.
     *
     * @param view
     *            the view to set
     */
    private void setView(final IView view) {
        this.view = view;
    }
    
    /**
     * Gets the model.
     *
     * @return the model
     */
    private IModel getModel() {
        return this.model;
    }
    
    /**
     * Sets the model.
     *
     * @param model
     *            the model to set
     */
    private void setModel(final IModel model) {
        this.model = model;
    }

    /**
     * Clear stack order.
     */
    private void clearStackOrder1() {
        this.stackOrder1 = UserOrder1.NOP1;
    }
    
    private void clearStackOrder2() {
        this.stackOrder2 = UserOrder2.NOP2;
    }

   /**
    * Get the order to perform
    */
    @Override
    public IOrderPerformer getOrderPeformer1() {
        return this;
    }
    
    @Override
    public IOrderPerformer getOrderPeformer2() {
        return this;
    }

}

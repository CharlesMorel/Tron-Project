package controller;

import java.io.IOException;

import contract.controller.IController;
import contract.controller.IOrderPerformer;
import contract.controller.UserOrder;
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
    private UserOrder stackOrder;
    

	
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
	    this.clearStackOrder();
	}

	/**
	 * Drive the game, player movement and threading
	 */
	@Override
	public void play() throws InterruptedException {
		getModel().getPlayer1().alive();
		
		getModel().getPlayer2().alive();
		while (this.getModel().getPlayer1().isAlive() && this.getModel().getPlayer2().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getPlayer1().moveRight();
                    //ADD PLAYER 2
                    break;
                case LEFT:
                    this.getModel().getPlayer1().moveLeft();
                    break;
                case UP:
                    this.getModel().getPlayer1().moveUp();
                    break;
                case DOWN:
                    this.getModel().getPlayer1().moveDown();
                    break;
                case NOP:
                	this.getModel().getPlayer1().doNothing();
                	break;
                    
            }
            this.clearStackOrder();

        }
        this.getView().displayMessage("You died");
	}
	
    /**
     * Write the UserOrder in the stack of order (stackOrder)
     */
	@Override
	public void orderPerform(UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
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
     * Gets the stack order.
     *
     * @return the stack order
     */
    private UserOrder getStackOrder() {
        return this.stackOrder;
    }

    /**
     * Sets the stack order.
     *
     * @param stackOrder
     *            the new stack order
     */
    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    /**
     * Clear stack order.
     */
    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

   /**
    * Get the order to perform
    */
    @Override
    public IOrderPerformer getOrderPeformer() {
        return this;
    }

}

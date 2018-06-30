package controller;

import java.io.IOException;

import contract.controller.IController;
import contract.controller.IOrderPerformer;
import contract.controller.UserOrder;
import contract.model.IModel;
import contract.view.IView;

public class Controller implements IController, IOrderPerformer {
	
    private static final int speed = 250;
	
	int i = 0;
	int j = 0;
	String dir = "right";
	
	private IView view;

    private static IModel model;
    
    private UserOrder stackOrder;
    
    
    public Controller(final IView view, final IModel model) {
    	this.setView(view);
    	this.setModel(model);
    	this.clearStackOrder();
    }
    
	
	@Override
	public void play() throws InterruptedException {
		
		getModel().getPlayer1().alive();
		getModel().getPlayer2().alive();
		
		while (!this.getModel().getPlayer1().Win() || !this.getModel().getPlayer2().Win()) {
			Thread.sleep(speed);
			// TODO : DO THIS METHOD BEFORE CONTINUE THE REST OF THE CONTROLLER CLASS
			if(this.getModel().getPlayer1().isAlive()) {
				switch(this.getStackOrder()) {
					case RIGHT:
						this.getModel().getPlayer1().moveRight();
						break;
					
					case LEFT:
						this.getModel().getPlayer1().moveLeft();
						break;
					
					case DOWN:
						this.getModel().getPlayer1().moveDown();
						break;
					
					case UP:
						this.getModel().getPlayer1().moveUp();
						break;
						
					case NOP:
						this.getModel().getPlayer1().doNothing();
				}
				this.clearStackOrder();
			}
			
			if(this.getModel().getPlayer2().isAlive()) {
				switch(this.getStackOrder()) {
				case RIGHT:
					this.getModel().getPlayer2().moveRight();
					break;
				
				case LEFT:
					this.getModel().getPlayer2().moveLeft();
					break;
				
				case DOWN:
					this.getModel().getPlayer2().moveDown();
					break;
				
				case UP:
					this.getModel().getPlayer2().moveUp();
					break;
					
				case NOP:
					this.getModel().getPlayer2().doNothing();
				}
				this.clearStackOrder();
			}
			
		}
		
		if(!getModel().getPlayer1().isAlive()) {
			this.getView().displayMessage("Player 1 is dead... Victory for player 2!");
		}
		
		if(!getModel().getPlayer2().isAlive() && getModel().getPlayer1().isAlive()) {
			this.getView().displayMessage("Player 2 is dead... Victory for player1!");
		}
		
	}
	
	public Boolean isFacingLightWall1() {
		return getModel().getPlayer2().getX() == getModel().getPlayer1().getX() 
			&& getModel().getPlayer2().getY() == getModel().getPlayer1().getY();
		
	}
	
	public Boolean isFacingLightWall2() {
		return getModel().getPlayer1().getX() == getModel().getPlayer2().getX() 
				&& getModel().getPlayer1().getY() == getModel().getPlayer2().getY();
			
	}
	
	public void playerIsFacingSomething() {
		if(this.isFacingLightWall1()) {
			this.getModel().getPlayer2().die();
		}
		if(this.isFacingLightWall2()) {
			this.getModel().getPlayer1().die();
		}
	}

	@Override
	public IOrderPerformer getOrderPeformer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IModel getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void orderPerform(UserOrder userOrder) throws IOException {
		// TODO Auto-generated method stub
		
	}


	public IView getView() {
		return view;
	}


	public void setView(IView view) {
		this.view = view;
	}


	public static void setModel(IModel model) {
		Controller.model = model;
	}


	private UserOrder getStackOrder() {
		return stackOrder;
	}


	private void setStackOrder(UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}
	
	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}
}

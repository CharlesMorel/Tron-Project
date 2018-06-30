package contract.view;

import contract.controller.IOrderPerformer;

public interface IView {
	
	void displayMessage(String message);
	
	void setOrderPerformer(IOrderPerformer orderPerformer);

}

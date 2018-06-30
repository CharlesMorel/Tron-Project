package contract.controller;

import java.io.IOException;

public interface IOrderPerformer {
	
	void play() throws InterruptedException;
	
	void orderPerform(UserOrder userOrder) throws IOException;

}

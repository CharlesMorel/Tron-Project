package contract.controller;

import java.io.IOException;

public interface IController {

    /**
     * Play.
     *
     * @throws InterruptedException
     *             the interrupted exception
     * @throws IOException 
     */
    void play() throws InterruptedException, IOException;

    /**
     * Gets the order peformer.
     *
     * @return the order peformer
     */
    IOrderPerformer getOrderPeformer1();
    IOrderPerformer getOrderPeformer2();

}

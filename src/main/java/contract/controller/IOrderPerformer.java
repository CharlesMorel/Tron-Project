package contract.controller;

import java.io.IOException;



public interface IOrderPerformer {

    /**
     * Order perform.
     *
     * @param userOrder
     *            the user order
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    void orderPerform1(UserOrder1 userOrder1) throws IOException;
    
    void orderPerform2(UserOrder2 userOrder2) throws IOException;
}

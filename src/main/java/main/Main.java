package main;

import java.io.IOException;

import contract.controller.IController;
import contract.model.IModel;
import contract.view.IView;
import controller.Controller;
import model.Model;
import view.View;

public class Main {
   
	public static void main(final String[] args) throws IOException, InterruptedException {
        final IModel model = new Model("D:/Tron/map.txt");
        final IView view = (IView) new View(model.getMap(), model.getPlayer1(), model.getPlayer2());
        final IController controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        controller.play();
    }
}

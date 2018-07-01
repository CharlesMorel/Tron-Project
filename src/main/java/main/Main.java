package main;

import java.io.IOException;

import contract.controller.IController;
import contract.model.IModel;
import contract.view.IView;
import controller.Controller;
import model.Model;
import view.View;

public class Main {

	public static void main(String[] args) throws InterruptedException, IOException {
        final IModel model = new Model("map.txt");
        final IView view = new View(model.getMap(), model.getPlayer1(), model.getPlayer2(), model);
        final IController controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());
        controller.play();
	}

}

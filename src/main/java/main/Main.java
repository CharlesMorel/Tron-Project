package main;

import contract.controller.IController;
import contract.model.IModel;
import contract.view.IView;
import controller.Controller;
import model.Model;
import view.View;

public class Main {

	public static void main(String[] args) {
        final IModel model = new Model(1);
        final IView view = new View(model.getMap(), model.getPlayer1(), model.getPlayer2(), model);
        final IController controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());
        controller.play();
	}

}
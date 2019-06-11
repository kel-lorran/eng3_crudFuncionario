package command;

import fachada.Fachada;

public abstract class AbstractCommand implements ICommand {

	protected Fachada fachada = new Fachada();
}

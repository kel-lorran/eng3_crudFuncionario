package command;

import controle.Fachada;

public abstract class AbstractCommand implements ICommand {

	protected Fachada fachada = new Fachada();
}

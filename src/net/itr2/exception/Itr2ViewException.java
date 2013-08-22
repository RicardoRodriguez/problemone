/**
 * 
 */
package net.itr2.exception;

/**
 * @author ricardorodriguez
 *
 */
public class Itr2ViewException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6301859603994385289L;

	/**
	 * 
	 */
	public Itr2ViewException() {
		super("Viewer não está implementada. Verifique se sua opção está correta");
	}

	/**
	 * @param arg0
	 */
	public Itr2ViewException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public Itr2ViewException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public Itr2ViewException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}

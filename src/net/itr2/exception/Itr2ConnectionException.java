package net.itr2.exception;

public class Itr2ConnectionException extends Exception {

	public Itr2ConnectionException() {
		super("Conexao nao pode ser estabelecida. Verifique parametrizacao para obter dados (database ou XML)");
	}

	public Itr2ConnectionException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Itr2ConnectionException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public Itr2ConnectionException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}

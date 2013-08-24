package net.itr2.util;

import net.itr2.exception.Itr2ParameterException;
import net.itr2.exception.Itr2ViewException;
import net.itr2.model.Station;

public class Util {

	private Util() {
		// Esta Classe Ž totalmente est‡tica.
	}

	public static boolean isEmpty(Station value){
		return (value == null || value.getIdStation().isEmpty());
	}

	public static void logger(String message){
		System.out.println(message);
	}
	
	public static int toInteger(String value) throws Itr2ViewException{
		try {
			return Integer.parseInt(value);
		}catch (NumberFormatException e) {
			throw new Itr2ViewException("Opcao Invalida. Tente de novo");
		}
	}
	
	public static int checkParameter(String [] args) throws Itr2ParameterException{

		String field="";
		int result=0;
		try {
			for (String string: args){
				field += string;
			}
			result = Integer.parseInt(field);
			return result;
		} catch (NumberFormatException e){
			return 0;
		} catch (Exception e) {
			throw new Itr2ParameterException("N‹o foi possivel ler parametros. Utilize java main 0");
		}
	}
	
	public static void printLine(String value){
		if (System.console() != null){
			System.console().writer().println(value);
		} else {
			System.out.println(value);
		}
	}
}

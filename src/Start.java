import net.itr2.exception.Itr2ParameterException;
import net.itr2.exception.Itr2ViewException;
import net.itr2.util.Util;
import net.itr2.view.ConsoleView;
import net.itr2.view.ViewFactoryInterface;

/**
 * 
 */

/**
 * @author ricardorodriguez
 *
 */
public class Start {

	/**
	 * @param args
	 */
	public Start(){

	}
	
	public static void main(final String[] args) {
		
		try{ 
			
			int viewerType= Util.checkParameter(args);
			
			ViewFactoryInterface viewer;
			
			switch (viewerType){
			case 0:
			    viewer = ConsoleView.getInstance();
				break;
			default:
				throw new Itr2ViewException();
			}
			viewer.showScreen();
			
		} catch (Itr2ViewException e){
			Util.printLine(e.getMessage());
			
		} catch (Itr2ParameterException e){
			Util.printLine(e.getMessage());
		}

	}

}

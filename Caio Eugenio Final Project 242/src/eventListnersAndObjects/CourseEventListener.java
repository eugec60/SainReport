package eventListnersAndObjects;

import java.util.EventListener;
/**
 *Interface for a CourseEventListener
 * @author Caio Eugenio
 *@version
 */
public interface CourseEventListener extends EventListener {
	public void ButtonClicked(CourseEventObjs ev);

}

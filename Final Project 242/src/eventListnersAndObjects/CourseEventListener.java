package eventListnersAndObjects;

import java.util.EventListener;

public interface CourseEventListener extends EventListener {
	public void ButtonClicked(CourseEventObjs ev);

}

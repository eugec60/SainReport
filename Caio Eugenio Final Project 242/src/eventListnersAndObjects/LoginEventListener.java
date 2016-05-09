package eventListnersAndObjects;

import java.util.EventListener;

public interface LoginEventListener extends EventListener {
	public void ButtonClicked(LoginEventObj ev);

}

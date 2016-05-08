package eventListnersAndObjects;

import java.util.EventListener;

public interface MajorEventListener extends EventListener {
	public void ButtonClicked(MajorEventObj ev);
}

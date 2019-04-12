package org.vaadin.mprdemo;

import org.vaadin.gwtav.ContentLengthConnectorResource;
import org.vaadin.gwtav.GwtVideo;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.mpr.LegacyWrapper;
import com.vaadin.server.ClassResource;
import com.vaadin.shared.ui.PreloadMode;

@Route(value = VideoView.ROUTE, layout = MyUI.class)
public class VideoView extends VerticalLayout {
    public static final String ROUTE = "video";
    public static final String TITLE = "Video";    

	public VideoView() {
		setAlignItems(Alignment.CENTER);
		final GwtVideo video = new GwtVideo("A Video");
		video.setPreload(PreloadMode.NONE);
		video.setWidth("800px");
		LegacyWrapper videoWrapper = new LegacyWrapper(video);
        add(videoWrapper);
       	ClassResource videoResource = new ClassResource("/big_buck_bunny.mp4");
       	long length = 5510872;
       	video.setSource(new ContentLengthConnectorResource(videoResource,length));		
	}
}

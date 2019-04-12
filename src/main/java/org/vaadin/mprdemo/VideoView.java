package org.vaadin.mprdemo;

import org.vaadin.gwtav.ContentLengthConnectorResource;
import org.vaadin.gwtav.GwtVideo;

import com.vaadin.server.ClassResource;
import com.vaadin.shared.ui.PreloadMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

public class VideoView extends VerticalLayout {

	public VideoView() {
		final GwtVideo video = new GwtVideo("A Video");
		video.setPreload(PreloadMode.NONE);
		video.setWidth("800px");
        addComponent(video);
        setComponentAlignment(video, Alignment.MIDDLE_CENTER);
       	ClassResource videoResource = new ClassResource("/big_buck_bunny.mp4");
       	long length = 5510872;
       	video.setSource(new ContentLengthConnectorResource(videoResource,length));		
	}
}

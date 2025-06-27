package org.vaadin.mprdemo;

import org.vaadin.gwtav.ContentLengthConnectorResource;
import org.vaadin.gwtav.GwtVideo;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.mpr.LegacyWrapper;
import com.vaadin.server.ClassResource;
import com.vaadin.shared.ui.PreloadMode;
import com.vaadin.ui.Button;

@Route(value = VideoView.ROUTE, layout = MyUI.class)
public class VideoView extends VerticalLayout {
    public static final String ROUTE = "video";
    public static final String TITLE = "Video";

    public VideoView() {
        setAlignItems(Alignment.CENTER);
        final GwtVideo video = new GwtVideo("A Video");
        video.setPreload(PreloadMode.NONE);
        video.addMediaPausedListener(e -> {
            Notification.show("Paused");
        });
        LegacyWrapper videoWrapper = new LegacyWrapper(video);

        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Video");
        dialog.add(videoWrapper);
        dialog.setCloseOnEsc(false);
        dialog.setCloseOnOutsideClick(false);
        LegacyWrapper wrapper = new LegacyWrapper(new Button("Close", e -> {
            dialog.close();
        }));
        dialog.addOpenedChangeListener(e -> {
            if (e.isOpened()) {
                // Disable the server side modality to enable legacy component
                // events pass when they are used in modal Dialog, otherwise
                // server modal curtain stops them.
                UI.getCurrent().setChildComponentModal(dialog, false);
            } else {
                video.stop();
            }
        });
        dialog.getFooter().add(wrapper);

        // Dialog needs to be added to parent
        add(dialog);
        dialog.open();

        ClassResource videoResource = new ClassResource("/big_buck_bunny.mp4");
        long length = 5510872;
        video.setSource(
                new ContentLengthConnectorResource(videoResource, length));
    }
}

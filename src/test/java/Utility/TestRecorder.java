package Utility;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;

public class TestRecorder {

    public static ScreenRecorder screenRecorder;

    public static void startRecording(String fileName) throws Exception {
        GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();

        File file = new File(fileName);
        Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());

        screenRecorder = new ScreenRecorder(gc, captureSize,
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        DepthKey, (int) 24, FrameRateKey, Rational.valueOf(15)),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "H264",
                        CompressorNameKey, "libx264",
                        DepthKey, 24, FrameRateKey, Rational.valueOf(30)),
                null, file);
        screenRecorder.start();
    }

    public static void stopRecording() throws Exception {
        screenRecorder.stop();
    }

}

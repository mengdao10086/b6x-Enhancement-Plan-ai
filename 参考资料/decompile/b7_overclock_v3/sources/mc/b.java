package mc;

import android.media.MediaFormat;
import com.google.android.exoplayer2.Format;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41162a = "android.media.mediaparser.inBandCryptoInfo";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f41163b = "android.media.mediaparser.includeSupplementalData";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f41164c = "android.media.mediaparser.eagerlyExposeTrackType";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f41165d = "android.media.mediaparser.exposeDummySeekMap";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f41166e = "android.media.mediaParser.exposeChunkIndexAsMediaFormat";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f41167f = "android.media.mediaParser.overrideInBandCaptionDeclarations";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f41168g = "android.media.mediaParser.exposeCaptionFormats";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f41169h = "android.media.mediaparser.ignoreTimestampOffset";

    public static MediaFormat a(Format format) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", format.f16699l);
        int i10 = format.D;
        if (i10 != -1) {
            mediaFormat.setInteger("caption-service-number", i10);
        }
        return mediaFormat;
    }
}

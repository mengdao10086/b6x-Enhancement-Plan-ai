package tb;

import android.media.MediaFormat;
import com.google.android.exoplayer2.video.ColorInfo;
import g.p0;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public static void a(MediaFormat mediaFormat, String str, @p0 byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void b(MediaFormat mediaFormat, @p0 ColorInfo colorInfo) {
        if (colorInfo != null) {
            d(mediaFormat, "color-transfer", colorInfo.f19301c);
            d(mediaFormat, "color-standard", colorInfo.f19299a);
            d(mediaFormat, "color-range", colorInfo.f19300b);
            a(mediaFormat, "hdr-static-info", colorInfo.f19302d);
        }
    }

    public static void c(MediaFormat mediaFormat, String str, float f10) {
        if (f10 != -1.0f) {
            mediaFormat.setFloat(str, f10);
        }
    }

    public static void d(MediaFormat mediaFormat, String str, int i10) {
        if (i10 != -1) {
            mediaFormat.setInteger(str, i10);
        }
    }

    public static void e(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            mediaFormat.setByteBuffer("csd-" + i10, ByteBuffer.wrap(list.get(i10)));
        }
    }

    public static void f(MediaFormat mediaFormat, String str, String str2) {
        mediaFormat.setString(str, str2);
    }
}

package bd;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.ParcelFileDescriptor;
import bd.d;
import com.google.android.exoplayer2.Format;
import g.p0;
import g.v0;
import hd.u0;
import hd.w;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MediaMuxer f9282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MediaCodec.BufferInfo f9284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9285d;

    /* JADX INFO: renamed from: bd.b$b, reason: collision with other inner class name */
    public static final class C0096b implements d.a {
        @Override // bd.d.a
        public boolean b(String str) {
            try {
                b.f(str);
                return true;
            } catch (IllegalStateException unused) {
                return false;
            }
        }

        @Override // bd.d.a
        @v0(26)
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
            return new b(new MediaMuxer(parcelFileDescriptor.getFileDescriptor(), b.f(str)), str);
        }

        @Override // bd.d.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public b c(String str, String str2) throws IOException {
            return new b(new MediaMuxer(str, b.f(str2)), str2);
        }
    }

    public static int f(String str) {
        if (str.equals(w.f31182f)) {
            return 0;
        }
        if (u0.f31154a >= 21 && str.equals(w.f31186h)) {
            return 1;
        }
        throw new IllegalArgumentException("Unsupported output MIME type: " + str);
    }

    @Override // bd.d
    public int a(Format format) {
        MediaFormat mediaFormatCreateVideoFormat;
        String str = (String) hd.a.g(format.f16699l);
        if (w.p(str)) {
            mediaFormatCreateVideoFormat = MediaFormat.createAudioFormat((String) u0.k(str), format.f16713z, format.f16712y);
        } else {
            mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat((String) u0.k(str), format.f16704q, format.f16705r);
            this.f9282a.setOrientationHint(format.f16707t);
        }
        tb.o.e(mediaFormatCreateVideoFormat, format.f16701n);
        return this.f9282a.addTrack(mediaFormatCreateVideoFormat);
    }

    @Override // bd.d
    public void b(int i10, ByteBuffer byteBuffer, boolean z10, long j10) {
        if (!this.f9285d) {
            this.f9285d = true;
            this.f9282a.start();
        }
        int iPosition = byteBuffer.position();
        this.f9284c.set(iPosition, byteBuffer.limit() - iPosition, j10, z10 ? 1 : 0);
        this.f9282a.writeSampleData(i10, byteBuffer, this.f9284c);
    }

    @Override // bd.d
    public void c(boolean z10) {
        if (this.f9285d) {
            this.f9285d = false;
            try {
                try {
                    this.f9282a.stop();
                } finally {
                    this.f9282a.release();
                }
            } catch (IllegalStateException e10) {
                if (u0.f31154a < 30) {
                    try {
                        Field declaredField = MediaMuxer.class.getDeclaredField("MUXER_STATE_STOPPED");
                        declaredField.setAccessible(true);
                        int iIntValue = ((Integer) u0.k((Integer) declaredField.get(this.f9282a))).intValue();
                        Field declaredField2 = MediaMuxer.class.getDeclaredField("mState");
                        declaredField2.setAccessible(true);
                        declaredField2.set(this.f9282a, Integer.valueOf(iIntValue));
                    } catch (Exception unused) {
                    }
                }
                if (!z10) {
                    throw e10;
                }
            }
        }
    }

    @Override // bd.d
    public boolean d(@p0 String str) {
        int i10;
        boolean zP = w.p(str);
        boolean zS = w.s(str);
        if (this.f9283b.equals(w.f31182f)) {
            if (zS) {
                if (w.f31188i.equals(str) || w.f31190j.equals(str) || w.f31202p.equals(str)) {
                    return true;
                }
                return u0.f31154a >= 24 && w.f31192k.equals(str);
            }
            if (zP) {
                return w.A.equals(str) || w.U.equals(str) || w.V.equals(str);
            }
        } else if (this.f9283b.equals(w.f31186h) && (i10 = u0.f31154a) >= 21) {
            if (zS) {
                if (w.f31194l.equals(str)) {
                    return true;
                }
                return i10 >= 24 && w.f31196m.equals(str);
            }
            if (zP) {
                return w.R.equals(str);
            }
        }
        return false;
    }

    public b(MediaMuxer mediaMuxer, String str) {
        this.f9282a = mediaMuxer;
        this.f9283b = str;
        this.f9284c = new MediaCodec.BufferInfo();
    }
}

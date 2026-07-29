package tb;

import ab.x;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import hd.t;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long f51049d = 529;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f51050e = "C2Mp3TimestampTracker";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f51051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f51052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f51053c;

    public final long a(Format format) {
        return (this.f51051a * 1000000) / ((long) format.f16713z);
    }

    public void b() {
        this.f51051a = 0L;
        this.f51052b = 0L;
        this.f51053c = false;
    }

    public long c(Format format, DecoderInputBuffer decoderInputBuffer) {
        if (this.f51053c) {
            return decoderInputBuffer.f16962e;
        }
        ByteBuffer byteBuffer = (ByteBuffer) hd.a.g(decoderInputBuffer.f16960c);
        int i10 = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            i10 = (i10 << 8) | (byteBuffer.get(i11) & 255);
        }
        int iM = x.m(i10);
        if (iM == -1) {
            this.f51053c = true;
            t.n(f51050e, "MPEG audio header is invalid.");
            return decoderInputBuffer.f16962e;
        }
        if (this.f51051a != 0) {
            long jA = a(format);
            this.f51051a += (long) iM;
            return this.f51052b + jA;
        }
        long j10 = decoderInputBuffer.f16962e;
        this.f51052b = j10;
        this.f51051a = ((long) iM) - 529;
        return j10;
    }
}

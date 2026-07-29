package mc;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import ed.h;
import g.p0;
import g.v0;
import hd.u0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"Override"})
@v0(30)
public final class a implements MediaParser.SeekableInputReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public h f41158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f41159b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f41160c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f41161d;

    public long a() {
        long j10 = this.f41161d;
        this.f41161d = -1L;
        return j10;
    }

    public void b(long j10) {
        this.f41160c = j10;
    }

    public void c(h hVar, long j10) {
        this.f41158a = hVar;
        this.f41159b = j10;
        this.f41161d = -1L;
    }

    @Override // android.media.MediaParser.InputReader
    public long getLength() {
        return this.f41159b;
    }

    @Override // android.media.MediaParser.InputReader
    public long getPosition() {
        return this.f41160c;
    }

    @Override // android.media.MediaParser.InputReader
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = ((h) u0.k(this.f41158a)).read(bArr, i10, i11);
        this.f41160c += (long) i12;
        return i12;
    }

    @Override // android.media.MediaParser.SeekableInputReader
    public void seekToPosition(long j10) {
        this.f41161d = j10;
    }
}

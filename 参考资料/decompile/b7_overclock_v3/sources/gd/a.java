package gd;

import ed.j;
import g.p0;
import hd.u0;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f29231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f29232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final byte[] f29233c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public c f29234d;

    public a(byte[] bArr, j jVar) {
        this(bArr, jVar, null);
    }

    @Override // ed.j
    public void a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        this.f29231a.a(bVar);
        long jA = d.a(bVar.f19100i);
        this.f29234d = new c(1, this.f29232b, jA, bVar.f19098g + bVar.f19093b);
    }

    @Override // ed.j
    public void close() throws IOException {
        this.f29234d = null;
        this.f29231a.close();
    }

    @Override // ed.j
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        if (this.f29233c == null) {
            ((c) u0.k(this.f29234d)).d(bArr, i10, i11);
            this.f29231a.write(bArr, i10, i11);
            return;
        }
        int i12 = 0;
        while (i12 < i11) {
            int iMin = Math.min(i11 - i12, this.f29233c.length);
            ((c) u0.k(this.f29234d)).c(bArr, i10 + i12, iMin, this.f29233c, 0);
            this.f29231a.write(this.f29233c, 0, iMin);
            i12 += iMin;
        }
    }

    public a(byte[] bArr, j jVar, @p0 byte[] bArr2) {
        this.f29231a = jVar;
        this.f29232b = bArr;
        this.f29233c = bArr2;
    }
}

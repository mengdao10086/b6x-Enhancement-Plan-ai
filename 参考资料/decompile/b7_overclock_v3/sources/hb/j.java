package hb;

import com.google.android.exoplayer2.Format;
import g.p0;
import hb.d0;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f30888d = new byte[4096];

    @Override // hb.d0
    public void a(long j10, int i10, int i11, int i12, @p0 d0.a aVar) {
    }

    @Override // hb.d0
    public int b(ed.h hVar, int i10, boolean z10, int i11) throws IOException {
        int i12 = hVar.read(this.f30888d, 0, Math.min(this.f30888d.length, i10));
        if (i12 != -1) {
            return i12;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // hb.d0
    public void c(hd.c0 c0Var, int i10, int i11) {
        c0Var.T(i10);
    }

    @Override // hb.d0
    public /* synthetic */ void d(hd.c0 c0Var, int i10) {
        c0.b(this, c0Var, i10);
    }

    @Override // hb.d0
    public /* synthetic */ int e(ed.h hVar, int i10, boolean z10) {
        return c0.a(this, hVar, i10, z10);
    }

    @Override // hb.d0
    public void f(Format format) {
    }
}

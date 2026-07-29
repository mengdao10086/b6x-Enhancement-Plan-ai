package bd;

import android.util.SparseIntArray;
import android.util.SparseLongArray;
import com.google.android.exoplayer2.Format;
import g.p0;
import g.v0;
import hd.u0;
import hd.w;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public final class e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final long f9295i = ya.g.c(500);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f9296a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9299d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9300e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9301f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f9303h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseIntArray f9297b = new SparseIntArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SparseLongArray f9298c = new SparseLongArray();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f9302g = 7;

    public e(d dVar) {
        this.f9296a = dVar;
    }

    public void a(Format format) {
        hd.a.j(this.f9299d > 0, "All tracks should be registered before the formats are added.");
        hd.a.j(this.f9300e < this.f9299d, "All track formats have already been added.");
        String str = format.f16699l;
        hd.a.j(w.p(str) || w.s(str), "Unsupported track format: " + str);
        int iL = w.l(str);
        hd.a.j(this.f9297b.get(iL, -1) == -1, "There is already a track of type " + iL);
        this.f9297b.put(iL, this.f9296a.a(format));
        this.f9298c.put(iL, 0L);
        int i10 = this.f9300e + 1;
        this.f9300e = i10;
        if (i10 == this.f9299d) {
            this.f9301f = true;
        }
    }

    public final boolean b(int i10) {
        long j10 = this.f9298c.get(i10, ya.g.f56663b);
        hd.a.i(j10 != ya.g.f56663b);
        if (!this.f9301f) {
            return false;
        }
        if (this.f9298c.size() == 1) {
            return true;
        }
        if (i10 != this.f9302g) {
            this.f9303h = u0.P0(this.f9298c);
        }
        return j10 - this.f9303h <= f9295i;
    }

    public void c(int i10) {
        this.f9297b.delete(i10);
        this.f9298c.delete(i10);
    }

    public int d() {
        return this.f9299d;
    }

    public void e() {
        hd.a.j(this.f9300e == 0, "Tracks cannot be registered after track formats have been added.");
        this.f9299d++;
    }

    public void f(boolean z10) {
        this.f9301f = false;
        this.f9296a.c(z10);
    }

    public boolean g(@p0 String str) {
        return this.f9296a.d(str);
    }

    public boolean h(int i10, @p0 ByteBuffer byteBuffer, boolean z10, long j10) {
        int i11 = this.f9297b.get(i10, -1);
        hd.a.j(i11 != -1, "Could not write sample because there is no track of type " + i10);
        if (!b(i10)) {
            return false;
        }
        if (byteBuffer == null) {
            return true;
        }
        this.f9296a.b(i11, byteBuffer, z10, j10);
        this.f9298c.put(i10, j10);
        this.f9302g = i10;
        return true;
    }
}

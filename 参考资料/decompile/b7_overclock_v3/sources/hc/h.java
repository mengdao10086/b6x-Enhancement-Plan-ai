package hc;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import ec.d0;
import hd.u0;
import java.io.IOException;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Format f30942a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long[] f30944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f30945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ic.e f30946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f30947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f30948g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wb.b f30943b = new wb.b();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f30949h = ya.g.f56663b;

    public h(ic.e eVar, Format format, boolean z10) {
        this.f30942a = format;
        this.f30946e = eVar;
        this.f30944c = eVar.f32062b;
        e(eVar, z10);
    }

    @Override // ec.d0
    public void a() throws IOException {
    }

    public String b() {
        return this.f30946e.a();
    }

    public void c(long j10) {
        int iF = u0.f(this.f30944c, j10, true, false);
        this.f30948g = iF;
        if (!(this.f30945d && iF == this.f30944c.length)) {
            j10 = ya.g.f56663b;
        }
        this.f30949h = j10;
    }

    @Override // ec.d0
    public boolean d() {
        return true;
    }

    public void e(ic.e eVar, boolean z10) {
        int i10 = this.f30948g;
        long j10 = i10 == 0 ? -9223372036854775807L : this.f30944c[i10 - 1];
        this.f30945d = z10;
        this.f30946e = eVar;
        long[] jArr = eVar.f32062b;
        this.f30944c = jArr;
        long j11 = this.f30949h;
        if (j11 != ya.g.f56663b) {
            c(j11);
        } else if (j10 != ya.g.f56663b) {
            this.f30948g = u0.f(jArr, j10, false, false);
        }
    }

    @Override // ec.d0
    public int k(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10) {
        if (z10 || !this.f30947f) {
            s0Var.f57068b = this.f30942a;
            this.f30947f = true;
            return -5;
        }
        int i10 = this.f30948g;
        if (i10 == this.f30944c.length) {
            if (this.f30945d) {
                return -3;
            }
            decoderInputBuffer.o(4);
            return -4;
        }
        this.f30948g = i10 + 1;
        byte[] bArrA = this.f30943b.a(this.f30946e.f32061a[i10]);
        decoderInputBuffer.q(bArrA.length);
        decoderInputBuffer.f16960c.put(bArrA);
        decoderInputBuffer.f16962e = this.f30944c[i10];
        decoderInputBuffer.o(1);
        return -4;
    }

    @Override // ec.d0
    public int o(long j10) {
        int iMax = Math.max(this.f30948g, u0.f(this.f30944c, j10, true, false));
        int i10 = iMax - this.f30948g;
        this.f30948g = iMax;
        return i10;
    }
}

package bd;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import g.p0;
import g.v0;
import java.nio.ByteBuffer;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public final class q extends o {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String f9381v = "TransformerVideoRenderer";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final DecoderInputBuffer f9382q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @p0
    public g f9383r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f9384s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f9385t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f9386u;

    public q(e eVar, p pVar, k kVar) {
        super(2, eVar, pVar, kVar);
        this.f9382q = new DecoderInputBuffer(2);
    }

    public final boolean P() {
        this.f9382q.h();
        int iN = N(B(), this.f9382q, false);
        if (iN == -5) {
            throw new IllegalStateException("Format changes are not supported.");
        }
        if (iN == -3) {
            return false;
        }
        if (this.f9382q.m()) {
            this.f9386u = true;
            this.f9375m.c(h());
            return false;
        }
        this.f9376n.a(h(), this.f9382q.f16962e);
        ((ByteBuffer) hd.a.g(this.f9382q.f16960c)).flip();
        g gVar = this.f9383r;
        if (gVar != null) {
            gVar.a(this.f9382q);
        }
        return true;
    }

    @Override // ya.o1
    public boolean b() {
        return this.f9386u;
    }

    @Override // ya.o1, ya.q1
    public String getName() {
        return f9381v;
    }

    @Override // ya.o1
    public void q(long j10, long j11) {
        boolean z10;
        if (!this.f9378p || b()) {
            return;
        }
        if (!this.f9384s) {
            s0 s0VarB = B();
            if (N(s0VarB, this.f9382q, true) != -5) {
                return;
            }
            Format format = (Format) hd.a.g(s0VarB.f57068b);
            this.f9384s = true;
            if (this.f9377o.f9331c) {
                this.f9383r = new h(format);
            }
            this.f9375m.a(format);
        }
        do {
            if (!this.f9385t && !P()) {
                return;
            }
            e eVar = this.f9375m;
            int iH = h();
            DecoderInputBuffer decoderInputBuffer = this.f9382q;
            z10 = !eVar.h(iH, decoderInputBuffer.f16960c, decoderInputBuffer.n(), this.f9382q.f16962e);
            this.f9385t = z10;
        } while (!z10);
    }
}

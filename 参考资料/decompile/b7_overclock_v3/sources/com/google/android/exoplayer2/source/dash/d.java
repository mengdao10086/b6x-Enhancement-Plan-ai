package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.r;
import ed.h;
import g.p0;
import gc.e;
import hb.d0;
import hd.c0;
import hd.u0;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import ya.g;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Handler.Callback {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f17723k = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ed.b f17724a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f17725b;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ic.b f17729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f17730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f17731h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f17732i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f17733j;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TreeMap<Long, Long> f17728e = new TreeMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f17727d = u0.A(this);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wb.a f17726c = new wb.a();

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f17734a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f17735b;

        public a(long j10, long j11) {
            this.f17734a = j10;
            this.f17735b = j11;
        }
    }

    public interface b {
        void a();

        void b(long j10);
    }

    public final class c implements d0 {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final r f17736d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final s0 f17737e = new s0();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ub.d f17738f = new ub.d();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f17739g = g.f56663b;

        public c(ed.b bVar) {
            this.f17736d = r.k(bVar);
        }

        @Override // hb.d0
        public void a(long j10, int i10, int i11, int i12, @p0 d0.a aVar) {
            this.f17736d.a(j10, i10, i11, i12, aVar);
            l();
        }

        @Override // hb.d0
        public int b(h hVar, int i10, boolean z10, int i11) throws IOException {
            return this.f17736d.e(hVar, i10, z10);
        }

        @Override // hb.d0
        public void c(c0 c0Var, int i10, int i11) {
            this.f17736d.d(c0Var, i10);
        }

        @Override // hb.d0
        public /* synthetic */ void d(c0 c0Var, int i10) {
            hb.c0.b(this, c0Var, i10);
        }

        @Override // hb.d0
        public /* synthetic */ int e(h hVar, int i10, boolean z10) {
            return hb.c0.a(this, hVar, i10, z10);
        }

        @Override // hb.d0
        public void f(Format format) {
            this.f17736d.f(format);
        }

        @p0
        public final ub.d g() {
            this.f17738f.h();
            if (this.f17736d.S(this.f17737e, this.f17738f, false, false) != -4) {
                return null;
            }
            this.f17738f.r();
            return this.f17738f;
        }

        public boolean h(long j10) {
            return d.this.j(j10);
        }

        public void i(e eVar) {
            long j10 = this.f17739g;
            if (j10 == g.f56663b || eVar.f29170h > j10) {
                this.f17739g = eVar.f29170h;
            }
            d.this.m(eVar);
        }

        public boolean j(e eVar) {
            long j10 = this.f17739g;
            return d.this.n(j10 != g.f56663b && j10 < eVar.f29169g);
        }

        public final void k(long j10, long j11) {
            d.this.f17727d.sendMessage(d.this.f17727d.obtainMessage(1, new a(j10, j11)));
        }

        public final void l() {
            while (this.f17736d.K(false)) {
                ub.d dVarG = g();
                if (dVarG != null) {
                    long j10 = dVarG.f16962e;
                    Metadata metadataA = d.this.f17726c.a(dVarG);
                    if (metadataA != null) {
                        EventMessage eventMessage = (EventMessage) metadataA.e(0);
                        if (d.h(eventMessage.f17242a, eventMessage.f17243b)) {
                            m(j10, eventMessage);
                        }
                    }
                }
            }
            this.f17736d.r();
        }

        public final void m(long j10, EventMessage eventMessage) {
            long jF = d.f(eventMessage);
            if (jF == g.f56663b) {
                return;
            }
            k(j10, jF);
        }

        public void n() {
            this.f17736d.T();
        }
    }

    public d(ic.b bVar, b bVar2, ed.b bVar3) {
        this.f17729f = bVar;
        this.f17725b = bVar2;
        this.f17724a = bVar3;
    }

    public static long f(EventMessage eventMessage) {
        try {
            return u0.Y0(u0.J(eventMessage.f17246e));
        } catch (ParserException unused) {
            return g.f56663b;
        }
    }

    public static boolean h(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    @p0
    public final Map.Entry<Long, Long> e(long j10) {
        return this.f17728e.ceilingEntry(Long.valueOf(j10));
    }

    public final void g(long j10, long j11) {
        Long l10 = this.f17728e.get(Long.valueOf(j11));
        if (l10 == null) {
            this.f17728e.put(Long.valueOf(j11), Long.valueOf(j10));
        } else if (l10.longValue() > j10) {
            this.f17728e.put(Long.valueOf(j11), Long.valueOf(j10));
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f17733j) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        g(aVar.f17734a, aVar.f17735b);
        return true;
    }

    public final void i() {
        if (this.f17731h) {
            this.f17732i = true;
            this.f17731h = false;
            this.f17725b.a();
        }
    }

    public boolean j(long j10) {
        ic.b bVar = this.f17729f;
        boolean z10 = false;
        if (!bVar.f32035d) {
            return false;
        }
        if (this.f17732i) {
            return true;
        }
        Map.Entry<Long, Long> entryE = e(bVar.f32039h);
        if (entryE != null && entryE.getValue().longValue() < j10) {
            this.f17730g = entryE.getKey().longValue();
            l();
            z10 = true;
        }
        if (z10) {
            i();
        }
        return z10;
    }

    public c k() {
        return new c(this.f17724a);
    }

    public final void l() {
        this.f17725b.b(this.f17730g);
    }

    public void m(e eVar) {
        this.f17731h = true;
    }

    public boolean n(boolean z10) {
        if (!this.f17729f.f32035d) {
            return false;
        }
        if (this.f17732i) {
            return true;
        }
        if (!z10) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.f17733j = true;
        this.f17727d.removeCallbacksAndMessages(null);
    }

    public final void p() {
        Iterator<Map.Entry<Long, Long>> it2 = this.f17728e.entrySet().iterator();
        while (it2.hasNext()) {
            if (it2.next().getKey().longValue() < this.f17729f.f32039h) {
                it2.remove();
            }
        }
    }

    public void q(ic.b bVar) {
        this.f17732i = false;
        this.f17730g = g.f56663b;
        this.f17729f = bVar;
        p();
    }
}

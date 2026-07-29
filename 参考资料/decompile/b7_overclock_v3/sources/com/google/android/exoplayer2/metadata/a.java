package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.metadata.Metadata;
import g.p0;
import hd.u0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ub.b;
import ub.c;
import ub.d;
import ub.e;
import ya.p1;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends com.google.android.exoplayer2.a implements Handler.Callback {
    public static final int A = 5;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final String f17219y = "MetadataRenderer";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f17220z = 0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final c f17221m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final e f17222n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @p0
    public final Handler f17223o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final d f17224p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Metadata[] f17225q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final long[] f17226r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f17227s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f17228t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @p0
    public b f17229u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f17230v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f17231w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f17232x;

    public a(e eVar, @p0 Looper looper) {
        this(eVar, looper, c.f51972a);
    }

    @Override // com.google.android.exoplayer2.a
    public void G() {
        Q();
        this.f17229u = null;
    }

    @Override // com.google.android.exoplayer2.a
    public void I(long j10, boolean z10) {
        Q();
        this.f17230v = false;
        this.f17231w = false;
    }

    @Override // com.google.android.exoplayer2.a
    public void M(Format[] formatArr, long j10, long j11) {
        this.f17229u = this.f17221m.b(formatArr[0]);
    }

    public final void P(Metadata metadata, List<Metadata.Entry> list) {
        for (int i10 = 0; i10 < metadata.g(); i10++) {
            Format formatN = metadata.e(i10).n();
            if (formatN == null || !this.f17221m.a(formatN)) {
                list.add(metadata.e(i10));
            } else {
                b bVarB = this.f17221m.b(formatN);
                byte[] bArr = (byte[]) hd.a.g(metadata.e(i10).O());
                this.f17224p.h();
                this.f17224p.q(bArr.length);
                ((ByteBuffer) u0.k(this.f17224p.f16960c)).put(bArr);
                this.f17224p.r();
                Metadata metadataA = bVarB.a(this.f17224p);
                if (metadataA != null) {
                    P(metadataA, list);
                }
            }
        }
    }

    public final void Q() {
        Arrays.fill(this.f17225q, (Object) null);
        this.f17227s = 0;
        this.f17228t = 0;
    }

    public final void R(Metadata metadata) {
        Handler handler = this.f17223o;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            S(metadata);
        }
    }

    public final void S(Metadata metadata) {
        this.f17222n.t(metadata);
    }

    @Override // ya.q1
    public int a(Format format) {
        if (this.f17221m.a(format)) {
            return p1.a(format.f16698k0 == null ? 4 : 2);
        }
        return p1.a(0);
    }

    @Override // ya.o1
    public boolean b() {
        return this.f17231w;
    }

    @Override // ya.o1
    public boolean d() {
        return true;
    }

    @Override // ya.o1, ya.q1
    public String getName() {
        return f17219y;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            throw new IllegalStateException();
        }
        S((Metadata) message.obj);
        return true;
    }

    @Override // ya.o1
    public void q(long j10, long j11) {
        if (!this.f17230v && this.f17228t < 5) {
            this.f17224p.h();
            s0 s0VarB = B();
            int iN = N(s0VarB, this.f17224p, false);
            if (iN == -4) {
                if (this.f17224p.m()) {
                    this.f17230v = true;
                } else {
                    d dVar = this.f17224p;
                    dVar.f51973l = this.f17232x;
                    dVar.r();
                    Metadata metadataA = ((b) u0.k(this.f17229u)).a(this.f17224p);
                    if (metadataA != null) {
                        ArrayList arrayList = new ArrayList(metadataA.g());
                        P(metadataA, arrayList);
                        if (!arrayList.isEmpty()) {
                            Metadata metadata = new Metadata(arrayList);
                            int i10 = this.f17227s;
                            int i11 = this.f17228t;
                            int i12 = (i10 + i11) % 5;
                            this.f17225q[i12] = metadata;
                            this.f17226r[i12] = this.f17224p.f16962e;
                            this.f17228t = i11 + 1;
                        }
                    }
                }
            } else if (iN == -5) {
                this.f17232x = ((Format) hd.a.g(s0VarB.f57068b)).f16703p;
            }
        }
        if (this.f17228t > 0) {
            long[] jArr = this.f17226r;
            int i13 = this.f17227s;
            if (jArr[i13] <= j10) {
                R((Metadata) u0.k(this.f17225q[i13]));
                Metadata[] metadataArr = this.f17225q;
                int i14 = this.f17227s;
                metadataArr[i14] = null;
                this.f17227s = (i14 + 1) % 5;
                this.f17228t--;
            }
        }
        if (this.f17230v && this.f17228t == 0) {
            this.f17231w = true;
        }
    }

    public a(e eVar, @p0 Looper looper, c cVar) {
        super(5);
        this.f17222n = (e) hd.a.g(eVar);
        this.f17223o = looper == null ? null : u0.y(looper, this);
        this.f17221m = (c) hd.a.g(cVar);
        this.f17224p = new d();
        this.f17225q = new Metadata[5];
        this.f17226r = new long[5];
    }
}

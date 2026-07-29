package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import ec.d0;
import java.io.IOException;
import ya.s0;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f17910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f17911c = -1;

    public n(s sVar, int i10) {
        this.f17910b = sVar;
        this.f17909a = i10;
    }

    @Override // ec.d0
    public void a() throws IOException {
        int i10 = this.f17911c;
        if (i10 == -2) {
            throw new SampleQueueMappingException(this.f17910b.r().a(this.f17909a).a(0).f16699l);
        }
        if (i10 == -1) {
            this.f17910b.U();
        } else if (i10 != -3) {
            this.f17910b.V(i10);
        }
    }

    public void b() {
        hd.a.a(this.f17911c == -1);
        this.f17911c = this.f17910b.y(this.f17909a);
    }

    public final boolean c() {
        int i10 = this.f17911c;
        return (i10 == -1 || i10 == -3 || i10 == -2) ? false : true;
    }

    @Override // ec.d0
    public boolean d() {
        return this.f17911c == -3 || (c() && this.f17910b.R(this.f17911c));
    }

    public void e() {
        if (this.f17911c != -1) {
            this.f17910b.p0(this.f17909a);
            this.f17911c = -1;
        }
    }

    @Override // ec.d0
    public int k(s0 s0Var, DecoderInputBuffer decoderInputBuffer, boolean z10) {
        if (this.f17911c == -3) {
            decoderInputBuffer.g(4);
            return -4;
        }
        if (c()) {
            return this.f17910b.e0(this.f17911c, s0Var, decoderInputBuffer, z10);
        }
        return -3;
    }

    @Override // ec.d0
    public int o(long j10) {
        if (c()) {
            return this.f17910b.o0(this.f17911c, j10);
        }
        return 0;
    }
}

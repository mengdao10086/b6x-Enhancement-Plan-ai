package com.flydigi.api.download;

import java.io.IOException;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import okhttp3.e0;
import okhttp3.w;
import okio.j;
import okio.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nDownloadProgressResponseBody.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DownloadProgressResponseBody.kt\ncom/flydigi/api/download/DownloadProgressResponseBody\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,48:1\n1#2:49\n*E\n"})
public final class e extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final e0 f13307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final d f13308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public okio.l f13309c;

    public static final class a extends u {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f13310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f13311c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(okio.t0 t0Var, e eVar) {
            super(t0Var);
            this.f13311c = eVar;
        }

        @Override // okio.u, okio.t0
        public long F1(@k j sink, long j10) throws IOException {
            f0.p(sink, "sink");
            long jF1 = super.F1(sink, j10);
            this.f13310b += jF1 != -1 ? jF1 : 0L;
            this.f13311c.f13308b.a(this.f13310b, this.f13311c.contentLength(), jF1 == -1);
            return jF1;
        }

        public final long d() {
            return this.f13310b;
        }

        public final void f(long j10) {
            this.f13310b = j10;
        }
    }

    public e(@l e0 e0Var, @k d progressListener) {
        f0.p(progressListener, "progressListener");
        this.f13307a = e0Var;
        this.f13308b = progressListener;
    }

    public final okio.t0 c(okio.t0 t0Var) {
        return new a(t0Var, this);
    }

    @Override // okhttp3.e0
    public long contentLength() {
        e0 e0Var = this.f13307a;
        if (e0Var != null) {
            return e0Var.contentLength();
        }
        return 0L;
    }

    @Override // okhttp3.e0
    @l
    public w contentType() {
        e0 e0Var = this.f13307a;
        if (e0Var != null) {
            return e0Var.contentType();
        }
        return null;
    }

    @Override // okhttp3.e0
    @k
    public okio.l source() {
        okio.l lVarSource;
        if (this.f13309c == null) {
            e0 e0Var = this.f13307a;
            this.f13309c = (e0Var == null || (lVarSource = e0Var.source()) == null) ? null : okio.f0.e(c(lVarSource));
        }
        okio.l lVar = this.f13309c;
        f0.n(lVar, "null cannot be cast to non-null type okio.BufferedSource");
        return lVar;
    }
}

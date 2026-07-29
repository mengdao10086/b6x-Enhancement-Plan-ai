package okio;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0000\u0018\u0000 \u001e2\u00020\u0001:\u0001\u000bB\t\b\u0016¢\u0006\u0004\b\u001b\u0010\u001cB1\b\u0016\u0012\u0006\u0010\u0010\u001a\u00020\u000e\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001dJ\u0006\u0010\u0002\u001a\u00020\u0000J\u0006\u0010\u0003\u001a\u00020\u0000J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0000J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\u0010\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0002\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0018¨\u0006\u001f"}, d2 = {"Lokio/p0;", "", "d", "f", "b", "segment", "c", "", "byteCount", "e", "Lkotlin/z1;", "a", "sink", "g", "", "[B", "data", "I", "pos", "limit", "", "Z", "shared", "owner", "Lokio/p0;", "next", "prev", "<init>", "()V", "([BIIZZ)V", "h", "okio"}, k = 1, mv = {1, 5, 1})
public final class p0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @yt.k
    public static final a f44171h = new a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f44172i = 8192;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f44173j = 1024;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final byte[] f44174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    public int f44175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    public int f44176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    public boolean f44177d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    public boolean f44178e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hk.e
    @yt.l
    public p0 f44179f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @hk.e
    @yt.l
    public p0 f44180g;

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lokio/p0$a;", "", "", "SHARE_MINIMUM", "I", "SIZE", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public p0() {
        this.f44174a = new byte[8192];
        this.f44178e = true;
        this.f44177d = false;
    }

    public final void a() {
        p0 p0Var = this.f44180g;
        int i10 = 0;
        if (!(p0Var != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        kotlin.jvm.internal.f0.m(p0Var);
        if (p0Var.f44178e) {
            int i11 = this.f44176c - this.f44175b;
            p0 p0Var2 = this.f44180g;
            kotlin.jvm.internal.f0.m(p0Var2);
            int i12 = 8192 - p0Var2.f44176c;
            p0 p0Var3 = this.f44180g;
            kotlin.jvm.internal.f0.m(p0Var3);
            if (!p0Var3.f44177d) {
                p0 p0Var4 = this.f44180g;
                kotlin.jvm.internal.f0.m(p0Var4);
                i10 = p0Var4.f44175b;
            }
            if (i11 > i12 + i10) {
                return;
            }
            p0 p0Var5 = this.f44180g;
            kotlin.jvm.internal.f0.m(p0Var5);
            g(p0Var5, i11);
            b();
            q0.d(this);
        }
    }

    @yt.l
    public final p0 b() {
        p0 p0Var = this.f44179f;
        if (p0Var == this) {
            p0Var = null;
        }
        p0 p0Var2 = this.f44180g;
        kotlin.jvm.internal.f0.m(p0Var2);
        p0Var2.f44179f = this.f44179f;
        p0 p0Var3 = this.f44179f;
        kotlin.jvm.internal.f0.m(p0Var3);
        p0Var3.f44180g = this.f44180g;
        this.f44179f = null;
        this.f44180g = null;
        return p0Var;
    }

    @yt.k
    public final p0 c(@yt.k p0 segment) {
        kotlin.jvm.internal.f0.p(segment, "segment");
        segment.f44180g = this;
        segment.f44179f = this.f44179f;
        p0 p0Var = this.f44179f;
        kotlin.jvm.internal.f0.m(p0Var);
        p0Var.f44180g = segment;
        this.f44179f = segment;
        return segment;
    }

    @yt.k
    public final p0 d() {
        this.f44177d = true;
        return new p0(this.f44174a, this.f44175b, this.f44176c, true, false);
    }

    @yt.k
    public final p0 e(int i10) {
        p0 p0VarE;
        if (!(i10 > 0 && i10 <= this.f44176c - this.f44175b)) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (i10 >= 1024) {
            p0VarE = d();
        } else {
            p0VarE = q0.e();
            byte[] bArr = this.f44174a;
            byte[] bArr2 = p0VarE.f44174a;
            int i11 = this.f44175b;
            kotlin.collections.m.f1(bArr, bArr2, 0, i11, i11 + i10, 2, null);
        }
        p0VarE.f44176c = p0VarE.f44175b + i10;
        this.f44175b += i10;
        p0 p0Var = this.f44180g;
        kotlin.jvm.internal.f0.m(p0Var);
        p0Var.c(p0VarE);
        return p0VarE;
    }

    @yt.k
    public final p0 f() {
        byte[] bArr = this.f44174a;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        kotlin.jvm.internal.f0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new p0(bArrCopyOf, this.f44175b, this.f44176c, false, true);
    }

    public final void g(@yt.k p0 sink, int i10) {
        kotlin.jvm.internal.f0.p(sink, "sink");
        if (!sink.f44178e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i11 = sink.f44176c;
        if (i11 + i10 > 8192) {
            if (sink.f44177d) {
                throw new IllegalArgumentException();
            }
            int i12 = sink.f44175b;
            if ((i11 + i10) - i12 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.f44174a;
            kotlin.collections.m.f1(bArr, bArr, 0, i12, i11, 2, null);
            sink.f44176c -= sink.f44175b;
            sink.f44175b = 0;
        }
        byte[] bArr2 = this.f44174a;
        byte[] bArr3 = sink.f44174a;
        int i13 = sink.f44176c;
        int i14 = this.f44175b;
        kotlin.collections.m.W0(bArr2, bArr3, i13, i14, i14 + i10);
        sink.f44176c += i10;
        this.f44175b += i10;
    }

    public p0(@yt.k byte[] data, int i10, int i11, boolean z10, boolean z11) {
        kotlin.jvm.internal.f0.p(data, "data");
        this.f44174a = data;
        this.f44175b = i10;
        this.f44176c = i11;
        this.f44177d = z10;
        this.f44178e = z11;
    }
}

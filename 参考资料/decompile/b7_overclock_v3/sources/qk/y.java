package qk;

import kotlin.c2;
import kotlin.l1;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@c2(markerClass = {kotlin.s.class})
@v0(version = "1.5")
public final class y extends w implements h<l1>, s<l1> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final a f47437e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final y f47438f;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final y a() {
            return y.f47438f;
        }
    }

    static {
        kotlin.jvm.internal.u uVar = null;
        f47437e = new a(uVar);
        f47438f = new y(-1, 0, uVar);
    }

    public y(int i10, int i11) {
        super(i10, i11, 1, null);
    }

    public /* synthetic */ y(int i10, int i11, kotlin.jvm.internal.u uVar) {
        this(i10, i11);
    }

    @kotlin.k(message = "Can throw an exception when it's impossible to represent the value with UInt type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @v0(version = "1.7")
    @kotlin.q
    public static /* synthetic */ void q() {
    }

    @Override // qk.h
    public /* bridge */ /* synthetic */ Comparable a() {
        return l1.d(s());
    }

    @Override // qk.h
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return o(((l1) comparable).l0());
    }

    @Override // qk.s
    public /* bridge */ /* synthetic */ Comparable d() {
        return l1.d(p());
    }

    @Override // qk.h
    public /* bridge */ /* synthetic */ Comparable e() {
        return l1.d(r());
    }

    @Override // qk.w
    public boolean equals(@yt.l Object obj) {
        if (obj instanceof y) {
            if (!isEmpty() || !((y) obj).isEmpty()) {
                y yVar = (y) obj;
                if (g() != yVar.g() || j() != yVar.j()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // qk.w
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + j();
    }

    @Override // qk.w, qk.h
    public boolean isEmpty() {
        return Integer.compare(g() ^ Integer.MIN_VALUE, j() ^ Integer.MIN_VALUE) > 0;
    }

    public boolean o(int i10) {
        return Integer.compare(g() ^ Integer.MIN_VALUE, i10 ^ Integer.MIN_VALUE) <= 0 && Integer.compare(i10 ^ Integer.MIN_VALUE, j() ^ Integer.MIN_VALUE) <= 0;
    }

    public int p() {
        if (j() != -1) {
            return l1.j(j() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    public int r() {
        return j();
    }

    public int s() {
        return g();
    }

    @Override // qk.w
    @yt.k
    public String toString() {
        return ((Object) l1.g0(g())) + ".." + ((Object) l1.g0(j()));
    }
}

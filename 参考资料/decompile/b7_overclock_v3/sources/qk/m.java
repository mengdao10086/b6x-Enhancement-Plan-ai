package qk;

import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
public final class m extends k implements h<Integer>, s<Integer> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final a f47413e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final m f47414f = new m(1, 0);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @yt.k
        public final m a() {
            return m.f47414f;
        }
    }

    public m(int i10, int i11) {
        super(i10, i11, 1);
    }

    @kotlin.k(message = "Can throw an exception when it's impossible to represent the value with Int type, for example, when the range includes MAX_VALUE. It's recommended to use 'endInclusive' property that doesn't throw.")
    @v0(version = "1.7")
    @kotlin.q
    public static /* synthetic */ void r() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // qk.h
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return p(((Number) comparable).intValue());
    }

    @Override // qk.k
    public boolean equals(@yt.l Object obj) {
        if (obj instanceof m) {
            if (!isEmpty() || !((m) obj).isEmpty()) {
                m mVar = (m) obj;
                if (g() != mVar.g() || j() != mVar.j()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // qk.k
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + j();
    }

    @Override // qk.k, qk.h
    public boolean isEmpty() {
        return g() > j();
    }

    public boolean p(int i10) {
        return g() <= i10 && i10 <= j();
    }

    @Override // qk.s
    @yt.k
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public Integer d() {
        if (j() != Integer.MAX_VALUE) {
            return Integer.valueOf(j() + 1);
        }
        throw new IllegalStateException("Cannot return the exclusive upper bound of a range that includes MAX_VALUE.".toString());
    }

    @Override // qk.h
    @yt.k
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public Integer e() {
        return Integer.valueOf(j());
    }

    @Override // qk.h
    @yt.k
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public Integer a() {
        return Integer.valueOf(g());
    }

    @Override // qk.k
    @yt.k
    public String toString() {
        return g() + ".." + j();
    }
}

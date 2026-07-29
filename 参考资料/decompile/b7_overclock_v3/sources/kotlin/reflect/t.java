package kotlin.reflect;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.f0;
import kotlin.s0;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.1")
public final class t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final a f38020c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final t f38021d = new t(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public final KVariance f38022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public final r f38023b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @s0
        public static /* synthetic */ void d() {
        }

        @hk.m
        @yt.k
        public final t a(@yt.k r type) {
            f0.p(type, "type");
            return new t(KVariance.IN, type);
        }

        @hk.m
        @yt.k
        public final t b(@yt.k r type) {
            f0.p(type, "type");
            return new t(KVariance.OUT, type);
        }

        @yt.k
        public final t c() {
            return t.f38021d;
        }

        @hk.m
        @yt.k
        public final t e(@yt.k r type) {
            f0.p(type, "type");
            return new t(KVariance.INVARIANT, type);
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38024a;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f38024a = iArr;
        }
    }

    public t(@yt.l KVariance kVariance, @yt.l r rVar) {
        String str;
        this.f38022a = kVariance;
        this.f38023b = rVar;
        if ((kVariance == null) == (rVar == null)) {
            return;
        }
        if (kVariance == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + kVariance + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    @hk.m
    @yt.k
    public static final t c(@yt.k r rVar) {
        return f38020c.a(rVar);
    }

    public static /* synthetic */ t e(t tVar, KVariance kVariance, r rVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            kVariance = tVar.f38022a;
        }
        if ((i10 & 2) != 0) {
            rVar = tVar.f38023b;
        }
        return tVar.d(kVariance, rVar);
    }

    @hk.m
    @yt.k
    public static final t f(@yt.k r rVar) {
        return f38020c.b(rVar);
    }

    @hk.m
    @yt.k
    public static final t i(@yt.k r rVar) {
        return f38020c.e(rVar);
    }

    @yt.l
    public final KVariance a() {
        return this.f38022a;
    }

    @yt.l
    public final r b() {
        return this.f38023b;
    }

    @yt.k
    public final t d(@yt.l KVariance kVariance, @yt.l r rVar) {
        return new t(kVariance, rVar);
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f38022a == tVar.f38022a && f0.g(this.f38023b, tVar.f38023b);
    }

    @yt.l
    public final r g() {
        return this.f38023b;
    }

    @yt.l
    public final KVariance h() {
        return this.f38022a;
    }

    public int hashCode() {
        KVariance kVariance = this.f38022a;
        int iHashCode = (kVariance == null ? 0 : kVariance.hashCode()) * 31;
        r rVar = this.f38023b;
        return iHashCode + (rVar != null ? rVar.hashCode() : 0);
    }

    @yt.k
    public String toString() {
        KVariance kVariance = this.f38022a;
        int i10 = kVariance == null ? -1 : b.f38024a[kVariance.ordinal()];
        if (i10 == -1) {
            return "*";
        }
        if (i10 == 1) {
            return String.valueOf(this.f38023b);
        }
        if (i10 == 2) {
            return "in " + this.f38023b;
        }
        if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + this.f38023b;
    }
}

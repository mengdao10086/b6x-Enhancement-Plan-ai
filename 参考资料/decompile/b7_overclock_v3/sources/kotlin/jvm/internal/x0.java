package kotlin.jvm.internal;

import java.util.List;
import kotlin.reflect.KVariance;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nTypeParameterReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypeParameterReference.kt\nkotlin/jvm/internal/TypeParameterReference\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,58:1\n1#2:59\n*E\n"})
@kotlin.v0(version = "1.4")
public final class x0 implements kotlin.reflect.s {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public static final a f37967f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public final Object f37968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final String f37969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final KVariance f37970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f37971d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public volatile List<? extends kotlin.reflect.r> f37972e;

    public static final class a {

        /* JADX INFO: renamed from: kotlin.jvm.internal.x0$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0434a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f37973a;

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
                f37973a = iArr;
            }
        }

        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.k
        public final String a(@yt.k kotlin.reflect.s typeParameter) {
            f0.p(typeParameter, "typeParameter");
            StringBuilder sb2 = new StringBuilder();
            int i10 = C0434a.f37973a[typeParameter.g().ordinal()];
            if (i10 == 2) {
                sb2.append("in ");
            } else if (i10 == 3) {
                sb2.append("out ");
            }
            sb2.append(typeParameter.getName());
            String string = sb2.toString();
            f0.o(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    public x0(@yt.l Object obj, @yt.k String name, @yt.k KVariance variance, boolean z10) {
        f0.p(name, "name");
        f0.p(variance, "variance");
        this.f37968a = obj;
        this.f37969b = name;
        this.f37970c = variance;
        this.f37971d = z10;
    }

    public static /* synthetic */ void a() {
    }

    public final void b(@yt.k List<? extends kotlin.reflect.r> upperBounds) {
        f0.p(upperBounds, "upperBounds");
        if (this.f37972e == null) {
            this.f37972e = upperBounds;
            return;
        }
        throw new IllegalStateException(("Upper bounds of type parameter '" + this + "' have already been initialized.").toString());
    }

    @Override // kotlin.reflect.s
    public boolean e() {
        return this.f37971d;
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof x0) {
            x0 x0Var = (x0) obj;
            if (f0.g(this.f37968a, x0Var.f37968a) && f0.g(getName(), x0Var.getName())) {
                return true;
            }
        }
        return false;
    }

    @Override // kotlin.reflect.s
    @yt.k
    public KVariance g() {
        return this.f37970c;
    }

    @Override // kotlin.reflect.s
    @yt.k
    public String getName() {
        return this.f37969b;
    }

    @Override // kotlin.reflect.s
    @yt.k
    public List<kotlin.reflect.r> getUpperBounds() {
        List list = this.f37972e;
        if (list != null) {
            return list;
        }
        List<kotlin.reflect.r> listK = kotlin.collections.s.k(n0.n(Object.class));
        this.f37972e = listK;
        return listK;
    }

    public int hashCode() {
        Object obj = this.f37968a;
        return ((obj != null ? obj.hashCode() : 0) * 31) + getName().hashCode();
    }

    @yt.k
    public String toString() {
        return f37967f.a(this);
    }
}

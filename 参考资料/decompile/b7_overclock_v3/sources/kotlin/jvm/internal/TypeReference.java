package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.KVariance;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.v0(version = "1.4")
public final class TypeReference implements kotlin.reflect.r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public static final a f37872e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f37873f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f37874g = 2;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f37875h = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final kotlin.reflect.g f37876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final List<kotlin.reflect.t> f37877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public final kotlin.reflect.r f37878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f37879d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37880a;

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
            f37880a = iArr;
        }
    }

    @kotlin.v0(version = "1.6")
    public TypeReference(@yt.k kotlin.reflect.g classifier, @yt.k List<kotlin.reflect.t> arguments, @yt.l kotlin.reflect.r rVar, int i10) {
        f0.p(classifier, "classifier");
        f0.p(arguments, "arguments");
        this.f37876a = classifier;
        this.f37877b = arguments;
        this.f37878c = rVar;
        this.f37879d = i10;
    }

    @kotlin.v0(version = "1.6")
    public static /* synthetic */ void o() {
    }

    @kotlin.v0(version = "1.6")
    public static /* synthetic */ void s() {
    }

    @Override // kotlin.reflect.r
    public boolean B() {
        return (this.f37879d & 1) != 0;
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) obj;
            if (f0.g(v0(), typeReference.v0()) && f0.g(u0(), typeReference.u0()) && f0.g(this.f37878c, typeReference.f37878c) && this.f37879d == typeReference.f37879d) {
                return true;
            }
        }
        return false;
    }

    public final String g(kotlin.reflect.t tVar) {
        String strValueOf;
        if (tVar.h() == null) {
            return "*";
        }
        kotlin.reflect.r rVarG = tVar.g();
        TypeReference typeReference = rVarG instanceof TypeReference ? (TypeReference) rVarG : null;
        if (typeReference == null || (strValueOf = typeReference.h(true)) == null) {
            strValueOf = String.valueOf(tVar.g());
        }
        int i10 = b.f37880a[tVar.h().ordinal()];
        if (i10 == 1) {
            return strValueOf;
        }
        if (i10 == 2) {
            return "in " + strValueOf;
        }
        if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return "out " + strValueOf;
    }

    @Override // kotlin.reflect.b
    @yt.k
    public List<Annotation> getAnnotations() {
        return CollectionsKt__CollectionsKt.E();
    }

    public final String h(boolean z10) {
        String name;
        kotlin.reflect.g gVarV0 = v0();
        kotlin.reflect.d dVar = gVarV0 instanceof kotlin.reflect.d ? (kotlin.reflect.d) gVarV0 : null;
        Class<?> clsE = dVar != null ? hk.a.e(dVar) : null;
        if (clsE == null) {
            name = v0().toString();
        } else if ((this.f37879d & 4) != 0) {
            name = "kotlin.Nothing";
        } else if (clsE.isArray()) {
            name = i(clsE);
        } else if (z10 && clsE.isPrimitive()) {
            kotlin.reflect.g gVarV02 = v0();
            f0.n(gVarV02, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
            name = hk.a.g((kotlin.reflect.d) gVarV02).getName();
        } else {
            name = clsE.getName();
        }
        String str = name + (u0().isEmpty() ? "" : CollectionsKt___CollectionsKt.h3(u0(), ", ", "<", ">", 0, null, new ik.l<kotlin.reflect.t, CharSequence>() { // from class: kotlin.jvm.internal.TypeReference$asString$args$1
            {
                super(1);
            }

            @Override // ik.l
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CharSequence i(@yt.k kotlin.reflect.t it2) {
                f0.p(it2, "it");
                return this.this$0.g(it2);
            }
        }, 24, null)) + (B() ? "?" : "");
        kotlin.reflect.r rVar = this.f37878c;
        if (!(rVar instanceof TypeReference)) {
            return str;
        }
        String strH = ((TypeReference) rVar).h(true);
        if (f0.g(strH, str)) {
            return str;
        }
        if (f0.g(strH, str + '?')) {
            return str + PublicSuffixDatabase.f43873i;
        }
        return '(' + str + ".." + strH + ')';
    }

    public int hashCode() {
        return (((v0().hashCode() * 31) + u0().hashCode()) * 31) + this.f37879d;
    }

    public final String i(Class<?> cls) {
        return f0.g(cls, boolean[].class) ? "kotlin.BooleanArray" : f0.g(cls, char[].class) ? "kotlin.CharArray" : f0.g(cls, byte[].class) ? "kotlin.ByteArray" : f0.g(cls, short[].class) ? "kotlin.ShortArray" : f0.g(cls, int[].class) ? "kotlin.IntArray" : f0.g(cls, float[].class) ? "kotlin.FloatArray" : f0.g(cls, long[].class) ? "kotlin.LongArray" : f0.g(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    public final int j() {
        return this.f37879d;
    }

    @yt.l
    public final kotlin.reflect.r q() {
        return this.f37878c;
    }

    @yt.k
    public String toString() {
        return h(false) + n0.f37924b;
    }

    @Override // kotlin.reflect.r
    @yt.k
    public List<kotlin.reflect.t> u0() {
        return this.f37877b;
    }

    @Override // kotlin.reflect.r
    @yt.k
    public kotlin.reflect.g v0() {
        return this.f37876a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeReference(@yt.k kotlin.reflect.g classifier, @yt.k List<kotlin.reflect.t> arguments, boolean z10) {
        this(classifier, arguments, null, z10 ? 1 : 0);
        f0.p(classifier, "classifier");
        f0.p(arguments, "arguments");
    }
}

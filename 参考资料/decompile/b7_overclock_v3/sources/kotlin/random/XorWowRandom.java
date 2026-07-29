package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nXorWowRandom.kt\nKotlin\n*S Kotlin\n*F\n+ 1 XorWowRandom.kt\nkotlin/random/XorWowRandom\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,60:1\n1#2:61\n*E\n"})
public final class XorWowRandom extends Random implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final a f38006c = new a(null);
    private static final long serialVersionUID = 0;
    private int addend;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f38007v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f38008w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f38009x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f38010y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private int f38011z;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public XorWowRandom(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f38009x = i10;
        this.f38010y = i11;
        this.f38011z = i12;
        this.f38008w = i13;
        this.f38007v = i14;
        this.addend = i15;
        int i16 = i10 | i11 | i12 | i13 | i14;
        if (!(i16 != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i17 = 0; i17 < 64; i17++) {
            o();
        }
    }

    @Override // kotlin.random.Random
    public int b(int i10) {
        return d.j(o(), i10);
    }

    @Override // kotlin.random.Random
    public int o() {
        int i10 = this.f38009x;
        int i11 = i10 ^ (i10 >>> 2);
        this.f38009x = this.f38010y;
        this.f38010y = this.f38011z;
        this.f38011z = this.f38008w;
        int i12 = this.f38007v;
        this.f38008w = i12;
        int i13 = ((i11 ^ (i11 << 1)) ^ i12) ^ (i12 << 4);
        this.f38007v = i13;
        int i14 = this.addend + 362437;
        this.addend = i14;
        return i13 + i14;
    }

    public XorWowRandom(int i10, int i11) {
        this(i10, i11, 0, 0, ~i10, (i10 << 10) ^ (i11 >>> 4));
    }
}

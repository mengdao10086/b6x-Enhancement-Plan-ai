package k6;

import com.flydigi.cyberfox.h1.models.equalizer.parameters.Filter;
import com.flydigi.cyberfox.h1.models.equalizer.parameters.ParameterType;

/* JADX INFO: loaded from: classes7.dex */
public class b extends k6.a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final boolean f36995m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f36996n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f36997o = 1;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f36998p = 1;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f36999q = 5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f37000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final InterfaceC0420b f37001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f37002l;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37003a;

        static {
            int[] iArr = new int[ParameterType.values().length];
            f37003a = iArr;
            try {
                iArr[ParameterType.FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37003a[ParameterType.FREQUENCY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37003a[ParameterType.GAIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37003a[ParameterType.QUALITY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: k6.b$b, reason: collision with other inner class name */
    public interface InterfaceC0420b {
        boolean a(byte[] bArr);

        void b(int i10, int i11);

        void c(int i10, int i11);

        void d(int i10, Filter filter);

        void e(int i10, int i11);

        void f();

        void g();

        void h(int i10);
    }

    public b(InterfaceC0420b interfaceC0420b, int i10) {
        super(i10);
        this.f37000j = "CustomEQGaiaManager";
        this.f37002l = false;
        this.f37001k = interfaceC0420b;
    }

    public final int E(int i10, int i11) {
        return (i10 << 4) | i11;
    }

    public void F(int i10, int i11) {
        l(D(gg.b.G0, new byte[]{1, (byte) E(i10, i11)}));
    }

    public void G() {
        F(0, 1);
    }

    public void H() {
        l(C(660));
    }

    public final void I(hg.a aVar) {
        byte[] bArrH = aVar.h();
        if (bArrH.length >= 2) {
            this.f37002l = bArrH[1] == 1;
        }
    }

    public final void J(hg.a aVar) {
        byte[] bArrH = aVar.h();
        if (bArrH.length < 5) {
            return;
        }
        int i10 = (bArrH[2] & 240) >>> 4;
        int i11 = bArrH[2] & 15;
        if (i10 == 0 && i11 == 1) {
            this.f37001k.h(i6.b.c(bArrH, 3, 2, false));
            return;
        }
        ParameterType parameterTypeValueOf = ParameterType.valueOf(i11);
        if (parameterTypeValueOf == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Received \"COMMAND_GET_EQ_PARAMETER\" packet with an unknown parameter type: ");
            sb2.append(i11);
            return;
        }
        int i12 = a.f37003a[parameterTypeValueOf.ordinal()];
        if (i12 == 1) {
            int iB = i6.b.b(bArrH, 3, 2, false);
            Filter filterValueOf = Filter.valueOf(iB);
            if (filterValueOf != null) {
                this.f37001k.d(i10, filterValueOf);
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Received \"COMMAND_GET_EQ_PARAMETER\" packet with an unknown filter type: ");
            sb3.append(iB);
            return;
        }
        if (i12 == 2) {
            this.f37001k.b(i10, i6.b.b(bArrH, 3, 2, false));
        } else if (i12 == 3) {
            this.f37001k.e(i10, i6.b.b(bArrH, 3, 2, false));
        } else {
            if (i12 != 4) {
                return;
            }
            this.f37001k.c(i10, i6.b.b(bArrH, 3, 2, false));
        }
    }

    public void K(int i10, int i11, int i12) {
        byte[] bArr = {1, (byte) E(i10, i11), 0, 0, this.f37002l};
        i6.b.a(i12, bArr, 2, 2, false);
        l(D(gg.b.F0, bArr));
    }

    @Override // gg.c
    public void o(hg.a aVar) {
    }

    @Override // gg.c
    public boolean p(hg.a aVar) {
        return false;
    }

    @Override // gg.c
    public void r(hg.a aVar) {
    }

    @Override // gg.c
    public void t(hg.a aVar) {
        int iE = aVar.e();
        if (iE == 660) {
            I(aVar);
        } else {
            if (iE != 666) {
                return;
            }
            J(aVar);
        }
    }

    @Override // gg.c
    public void u(hg.a aVar) {
        if (aVar.j() == 6) {
            this.f37001k.f();
        } else {
            this.f37001k.g();
        }
    }

    @Override // gg.c
    public boolean y(byte[] bArr) {
        return this.f37001k.a(bArr);
    }
}

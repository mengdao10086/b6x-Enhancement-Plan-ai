package w;

import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class u {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f53616m = 4;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f53617n = 10;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f53618o = 10;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f53619p = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f53620a = new int[10];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f53621b = new int[10];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f53622c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f53623d = new int[10];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float[] f53624e = new float[10];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f53625f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int[] f53626g = new int[5];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String[] f53627h = new String[5];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f53628i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int[] f53629j = new int[4];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean[] f53630k = new boolean[4];

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f53631l = 0;

    public void a(int i10, float f10) {
        int i11 = this.f53625f;
        int[] iArr = this.f53623d;
        if (i11 >= iArr.length) {
            this.f53623d = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f53624e;
            this.f53624e = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f53623d;
        int i12 = this.f53625f;
        iArr2[i12] = i10;
        float[] fArr2 = this.f53624e;
        this.f53625f = i12 + 1;
        fArr2[i12] = f10;
    }

    public void b(int i10, int i11) {
        int i12 = this.f53622c;
        int[] iArr = this.f53620a;
        if (i12 >= iArr.length) {
            this.f53620a = Arrays.copyOf(iArr, iArr.length * 2);
            int[] iArr2 = this.f53621b;
            this.f53621b = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f53620a;
        int i13 = this.f53622c;
        iArr3[i13] = i10;
        int[] iArr4 = this.f53621b;
        this.f53622c = i13 + 1;
        iArr4[i13] = i11;
    }

    public void c(int i10, String str) {
        int i11 = this.f53628i;
        int[] iArr = this.f53626g;
        if (i11 >= iArr.length) {
            this.f53626g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f53627h;
            this.f53627h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        }
        int[] iArr2 = this.f53626g;
        int i12 = this.f53628i;
        iArr2[i12] = i10;
        String[] strArr2 = this.f53627h;
        this.f53628i = i12 + 1;
        strArr2[i12] = str;
    }

    public void d(int i10, boolean z10) {
        int i11 = this.f53631l;
        int[] iArr = this.f53629j;
        if (i11 >= iArr.length) {
            this.f53629j = Arrays.copyOf(iArr, iArr.length * 2);
            boolean[] zArr = this.f53630k;
            this.f53630k = Arrays.copyOf(zArr, zArr.length * 2);
        }
        int[] iArr2 = this.f53629j;
        int i12 = this.f53631l;
        iArr2[i12] = i10;
        boolean[] zArr2 = this.f53630k;
        this.f53631l = i12 + 1;
        zArr2[i12] = z10;
    }

    public void e(int i10, String str) {
        if (str != null) {
            c(i10, str);
        }
    }

    public void f(u uVar) {
        for (int i10 = 0; i10 < this.f53622c; i10++) {
            uVar.b(this.f53620a[i10], this.f53621b[i10]);
        }
        for (int i11 = 0; i11 < this.f53625f; i11++) {
            uVar.a(this.f53623d[i11], this.f53624e[i11]);
        }
        for (int i12 = 0; i12 < this.f53628i; i12++) {
            uVar.c(this.f53626g[i12], this.f53627h[i12]);
        }
        for (int i13 = 0; i13 < this.f53631l; i13++) {
            uVar.d(this.f53629j[i13], this.f53630k[i13]);
        }
    }

    public void g(w wVar) {
        for (int i10 = 0; i10 < this.f53622c; i10++) {
            wVar.a(this.f53620a[i10], this.f53621b[i10]);
        }
        for (int i11 = 0; i11 < this.f53625f; i11++) {
            wVar.b(this.f53623d[i11], this.f53624e[i11]);
        }
        for (int i12 = 0; i12 < this.f53628i; i12++) {
            wVar.c(this.f53626g[i12], this.f53627h[i12]);
        }
        for (int i13 = 0; i13 < this.f53631l; i13++) {
            wVar.d(this.f53629j[i13], this.f53630k[i13]);
        }
    }

    public void h() {
        this.f53631l = 0;
        this.f53628i = 0;
        this.f53625f = 0;
        this.f53622c = 0;
    }

    public int i(int i10) {
        for (int i11 = 0; i11 < this.f53622c; i11++) {
            if (this.f53620a[i11] == i10) {
                return this.f53621b[i11];
            }
        }
        return -1;
    }
}

package ir;

/* JADX INFO: loaded from: classes6.dex */
public class a0 implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile int f35623a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f35624b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public i[] f35625c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i[] f35626d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public i f35627e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f35628f = -1;

    public int a() {
        int i10 = this.f35623a;
        if (i10 <= 0) {
            return i10;
        }
        int i11 = i10 - 1;
        this.f35623a = i11;
        return i11;
    }

    public int b() {
        return this.f35624b;
    }

    public i[] c() {
        return this.f35625c;
    }

    public i[] d() {
        return this.f35626d;
    }

    public int e() {
        return this.f35623a;
    }

    public i f() {
        return this.f35627e;
    }

    public int g() {
        return this.f35628f;
    }

    public boolean h() {
        return this.f35623a <= 0;
    }

    public void i(int i10) {
        this.f35624b = i10;
    }

    public void j(i[] iVarArr) {
        this.f35625c = iVarArr;
    }

    public void k(i[] iVarArr) {
        this.f35626d = iVarArr;
    }

    public void l(int i10) {
        this.f35623a = i10;
    }

    public void m(i iVar) {
        this.f35627e = iVar;
    }

    public void n(int i10) {
        this.f35628f = i10;
    }
}

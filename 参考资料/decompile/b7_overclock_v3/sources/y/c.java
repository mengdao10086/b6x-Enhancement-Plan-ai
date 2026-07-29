package y;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f56139a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56140b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f56141c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f56142d;

    public boolean a(int i10, int i11) {
        int i12;
        int i13 = this.f56139a;
        return i10 >= i13 && i10 < i13 + this.f56141c && i11 >= (i12 = this.f56140b) && i11 < i12 + this.f56142d;
    }

    public int b() {
        return (this.f56139a + this.f56141c) / 2;
    }

    public int c() {
        return (this.f56140b + this.f56142d) / 2;
    }

    public void d(int i10, int i11) {
        this.f56139a -= i10;
        this.f56140b -= i11;
        this.f56141c += i10 * 2;
        this.f56142d += i11 * 2;
    }

    public boolean e(c cVar) {
        int i10;
        int i11;
        int i12 = this.f56139a;
        int i13 = cVar.f56139a;
        return i12 >= i13 && i12 < i13 + cVar.f56141c && (i10 = this.f56140b) >= (i11 = cVar.f56140b) && i10 < i11 + cVar.f56142d;
    }

    public void f(int i10, int i11, int i12, int i13) {
        this.f56139a = i10;
        this.f56140b = i11;
        this.f56141c = i12;
        this.f56142d = i13;
    }
}

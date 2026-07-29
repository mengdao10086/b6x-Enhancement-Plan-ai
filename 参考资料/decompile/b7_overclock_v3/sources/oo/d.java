package oo;

/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f44378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f44379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f44380c;

    public c a(int i10) {
        return new c(i10, this.f44378a, this.f44379b, this.f44380c);
    }

    public c b(no.a aVar) {
        return a(aVar.d());
    }

    public void c(boolean z10) {
        this.f44379b = z10;
    }

    public void d(boolean z10) {
        this.f44378a = z10;
    }

    public void e(boolean z10) {
        this.f44380c = z10;
    }
}

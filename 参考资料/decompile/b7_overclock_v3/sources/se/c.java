package se;

/* JADX INFO: loaded from: classes7.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f49694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f49695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f49696c;

    public c(int i10, int i11, boolean z10) {
        this.f49694a = i10;
        this.f49695b = i11;
        this.f49696c = z10;
    }

    public static c a(int i10, int i11) {
        return new c(i10, i11, true);
    }

    public static c b(int i10, int i11) {
        return new c(i10, i11, false);
    }
}

package ut;

import tt.f;
import tt.g;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f52441c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f52442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f52443b;

    static {
        f52441c = b.c() ? b.b() : null;
    }

    public a(f fVar, g gVar) {
        this.f52442a = fVar;
        this.f52443b = gVar;
    }

    public static boolean a() {
        return f52441c != null;
    }

    public static a b() {
        return f52441c;
    }
}

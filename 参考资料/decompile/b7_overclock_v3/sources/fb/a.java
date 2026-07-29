package fb;

import g.p0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f28016d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f28017e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f28018f = new a(0, 0, 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f28019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f28020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f28021c;

    /* JADX INFO: renamed from: fb.a$a, reason: collision with other inner class name */
    @Target({ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface InterfaceC0329a {
    }

    public a(int i10, int i11, int i12) {
        this.f28019a = i10;
        this.f28020b = i11;
        this.f28021c = i12;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f28019a == aVar.f28019a && this.f28020b == aVar.f28020b && this.f28021c == aVar.f28021c;
    }

    public int hashCode() {
        return ((((527 + this.f28019a) * 31) + this.f28020b) * 31) + this.f28021c;
    }
}

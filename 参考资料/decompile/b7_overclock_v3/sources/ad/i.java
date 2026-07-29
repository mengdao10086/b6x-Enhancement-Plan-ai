package ad;

import g.p0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f566a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h[] f567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f568c;

    public i(h... hVarArr) {
        this.f567b = hVarArr;
        this.f566a = hVarArr.length;
    }

    @p0
    public h a(int i10) {
        return this.f567b[i10];
    }

    public h[] b() {
        return (h[]) this.f567b.clone();
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f567b, ((i) obj).f567b);
    }

    public int hashCode() {
        if (this.f568c == 0) {
            this.f568c = 527 + Arrays.hashCode(this.f567b);
        }
        return this.f568c;
    }
}

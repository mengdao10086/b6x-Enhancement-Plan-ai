package sp;

import zn.t;

/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f50376a;

    public k(t tVar) {
        this.f50376a = tVar;
    }

    public t a() {
        return this.f50376a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            return this.f50376a.equals(((k) obj).f50376a);
        }
        return false;
    }

    public int hashCode() {
        return this.f50376a.hashCode();
    }
}

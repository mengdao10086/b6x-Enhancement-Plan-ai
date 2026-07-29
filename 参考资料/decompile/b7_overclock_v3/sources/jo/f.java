package jo;

import org.bouncycastle.util.q;

/* JADX INFO: loaded from: classes5.dex */
public class f implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f36535a;

    public f(String str) {
        this.f36535a = str;
    }

    @Override // org.bouncycastle.util.q
    public boolean M(Object obj) {
        return ((b) obj).b().equals(this.f36535a);
    }

    public String a() {
        return this.f36535a;
    }

    @Override // org.bouncycastle.util.q
    public Object clone() {
        return this;
    }
}

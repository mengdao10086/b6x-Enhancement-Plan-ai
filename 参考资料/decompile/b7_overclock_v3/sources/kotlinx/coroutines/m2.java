package kotlinx.coroutines;

/* JADX INFO: loaded from: classes5.dex */
public abstract class m2 extends CoroutineDispatcher {
    @Override // kotlinx.coroutines.CoroutineDispatcher
    @yt.k
    public CoroutineDispatcher k2(int i10) {
        kotlinx.coroutines.internal.r.a(i10);
        return this;
    }

    @yt.k
    public abstract m2 m2();

    @yt.l
    @y1
    public final String n2() {
        m2 m2VarM2;
        m2 m2VarE = d1.e();
        if (this == m2VarE) {
            return "Dispatchers.Main";
        }
        try {
            m2VarM2 = m2VarE.m2();
        } catch (UnsupportedOperationException unused) {
            m2VarM2 = null;
        }
        if (this == m2VarM2) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @yt.k
    public String toString() {
        String strN2 = n2();
        if (strN2 != null) {
            return strN2;
        }
        return r0.a(this) + '@' + r0.b(this);
    }
}

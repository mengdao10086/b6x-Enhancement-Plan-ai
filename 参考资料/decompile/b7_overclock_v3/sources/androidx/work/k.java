package androidx.work;

import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class k {

    public class a extends k {
        @Override // androidx.work.k
        @p0
        public j a(@n0 String className) {
            return null;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static k c() {
        return new a();
    }

    @p0
    public abstract j a(@n0 String className);

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public final j b(@n0 String className) {
        j jVarA = a(className);
        return jVarA == null ? j.a(className) : jVarA;
    }
}

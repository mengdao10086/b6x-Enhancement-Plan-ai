package sm;

import gm.f0;
import gm.w;
import gm.y;

/* JADX INFO: loaded from: classes5.dex */
public abstract class l extends w {
    public static l x(Object obj) {
        if (obj instanceof l) {
            return (l) obj;
        }
        if (obj == null) {
            return null;
        }
        f0 f0VarJ = f0.J(obj);
        return y.N(f0VarJ.K(0)).Q(g.f49917r) ? new i(f0VarJ) : new m(f0VarJ);
    }

    public abstract y y();
}

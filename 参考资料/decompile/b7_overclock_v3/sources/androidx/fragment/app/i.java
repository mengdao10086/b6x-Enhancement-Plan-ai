package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i {
    @g.n0
    @Deprecated
    public Fragment b(@g.n0 Context context, @g.n0 String str, @p0 Bundle bundle) {
        return Fragment.r3(context, str, bundle);
    }

    @p0
    public abstract View c(@g.d0 int i10);

    public abstract boolean d();
}

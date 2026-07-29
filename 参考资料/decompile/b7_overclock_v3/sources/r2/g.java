package r2;

import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import g.n0;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
public class g extends c<q2.b> {
    public g(@n0 Context context, @n0 w2.a taskExecutor) {
        super(s2.g.c(context, taskExecutor).d());
    }

    @Override // r2.c
    public boolean b(@n0 r workSpec) {
        return workSpec.f51850j.b() == NetworkType.UNMETERED || (Build.VERSION.SDK_INT >= 30 && workSpec.f51850j.b() == NetworkType.TEMPORARILY_UNMETERED);
    }

    @Override // r2.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(@n0 q2.b state) {
        return !state.a() || state.b();
    }
}

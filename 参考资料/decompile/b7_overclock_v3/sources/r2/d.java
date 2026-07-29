package r2;

import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import g.n0;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
public class d extends c<q2.b> {
    public d(Context context, w2.a taskExecutor) {
        super(s2.g.c(context, taskExecutor).d());
    }

    @Override // r2.c
    public boolean b(@n0 r workSpec) {
        return workSpec.f51850j.b() == NetworkType.CONNECTED;
    }

    @Override // r2.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(@n0 q2.b state) {
        return Build.VERSION.SDK_INT >= 26 ? (state.a() && state.d()) ? false : true : !state.a();
    }
}

package r2;

import android.content.Context;
import android.os.Build;
import androidx.work.NetworkType;
import androidx.work.l;
import g.n0;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
public class e extends c<q2.b> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f47722e = l.f("NetworkMeteredCtrlr");

    public e(Context context, w2.a taskExecutor) {
        super(s2.g.c(context, taskExecutor).d());
    }

    @Override // r2.c
    public boolean b(@n0 r workSpec) {
        return workSpec.f51850j.b() == NetworkType.METERED;
    }

    @Override // r2.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(@n0 q2.b state) {
        if (Build.VERSION.SDK_INT >= 26) {
            return (state.a() && state.b()) ? false : true;
        }
        l.c().a(f47722e, "Metered network constraint is not supported before API 26, only checking for connected state.", new Throwable[0]);
        return !state.a();
    }
}

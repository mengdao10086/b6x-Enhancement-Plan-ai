package r2;

import android.content.Context;
import g.n0;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
public class a extends c<Boolean> {
    public a(Context context, w2.a taskExecutor) {
        super(s2.g.c(context, taskExecutor).a());
    }

    @Override // r2.c
    public boolean b(@n0 r workSpec) {
        return workSpec.f51850j.g();
    }

    @Override // r2.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(@n0 Boolean isBatteryCharging) {
        return !isBatteryCharging.booleanValue();
    }
}

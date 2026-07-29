package r2;

import android.content.Context;
import g.n0;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
public class b extends c<Boolean> {
    public b(Context context, w2.a taskExecutor) {
        super(s2.g.c(context, taskExecutor).b());
    }

    @Override // r2.c
    public boolean b(@n0 r workSpec) {
        return workSpec.f51850j.f();
    }

    @Override // r2.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(@n0 Boolean isBatteryNotLow) {
        return !isBatteryNotLow.booleanValue();
    }
}

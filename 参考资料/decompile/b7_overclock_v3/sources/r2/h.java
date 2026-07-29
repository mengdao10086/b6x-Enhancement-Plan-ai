package r2;

import android.content.Context;
import g.n0;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
public class h extends c<Boolean> {
    public h(@n0 Context context, @n0 w2.a taskExecutor) {
        super(s2.g.c(context, taskExecutor).e());
    }

    @Override // r2.c
    public boolean b(@n0 r workSpec) {
        return workSpec.f51850j.i();
    }

    @Override // r2.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(@n0 Boolean isStorageNotLow) {
        return !isStorageNotLow.booleanValue();
    }
}

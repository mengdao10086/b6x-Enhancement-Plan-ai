package a;

import android.content.Intent;
import com.omarea.vtools.activities.ActivityAppConfig2;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vu1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ wu1 f7726a;

    public vu1(wu1 wu1Var) {
        this.f7726a = wu1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f7726a.f7824a.s1(new Intent(this.f7726a.f7824a.p(), (Class<?>) ActivityAppConfig2.class));
    }
}

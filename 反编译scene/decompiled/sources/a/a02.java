package a;

import android.content.Context;
import android.view.View;
import com.omarea.Scene;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class a02 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5555a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ l02 f2a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Context f3a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Runnable f4a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f5a;
    public final /* synthetic */ Runnable b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f6b;

    public a02(boolean z, int i, l02 l02Var, boolean z2, boolean z3, boolean z4, List list, Runnable runnable, String str, Context context, Runnable runnable2) {
        this.f6b = z;
        this.f5555a = i;
        this.f2a = l02Var;
        this.f4a = runnable;
        this.f5a = str;
        this.f3a = context;
        this.b = runnable2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f4a.run();
        if (this.f6b) {
            ez0 ez0Var = this.f2a.f1703a;
            ez0Var.m(this.f5a, null, Integer.valueOf(this.f5555a));
            ez0Var.l();
        } else {
            Scene.c cVar = Scene.f4798a;
            String string = this.f3a.getString(u61.detail_refresh_rate_keep);
            f92.c(string, "context.getString(R.stri…detail_refresh_rate_keep)");
            Scene.c.p(cVar, string, 0, 2, null);
        }
        qc2.d(xd2.a(qe2.b()), null, null, new zz1(this, null), 3, null);
    }
}

package a;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class v02 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f7646a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f3227a;

    public v02(View view, float f) {
        this.f3227a = view;
        this.f7646a = f;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        float f;
        Context context = this.f3227a.getContext();
        f92.c(context, "context");
        az1 az1Var = new az1(context);
        if (f92.a(az1.f5657a.a(), Boolean.TRUE)) {
            az1Var.v(true);
            f92.c(view, "it");
            f = this.f7646a;
        } else {
            az1Var.z();
            f92.c(view, "it");
            f = 1.0f;
        }
        view.setAlpha(f);
    }
}

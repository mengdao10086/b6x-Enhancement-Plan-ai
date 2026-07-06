package a;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pz1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f7162a;

    public pz1(View view) {
        this.f7162a = view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        float f;
        if (f92.a(ox1.f7064a.a(), Boolean.TRUE)) {
            Context context = this.f7162a.getContext();
            f92.c(context, "context");
            new ox1(context).r(true);
            f92.c(view, "it");
            f = 0.15f;
        } else {
            Context context2 = this.f7162a.getContext();
            f92.c(context2, "context");
            new ox1(context2).u();
            f92.c(view, "it");
            f = 1.0f;
        }
        view.setAlpha(f);
    }
}

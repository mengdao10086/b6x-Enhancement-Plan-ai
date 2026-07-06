package a;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class r02 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f7260a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f2681a;

    public r02(View view, float f) {
        this.f2681a = view;
        this.f7260a = f;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        float f;
        if (f92.a(ox1.f7064a.a(), Boolean.TRUE)) {
            Context context = this.f2681a.getContext();
            f92.c(context, "context");
            new ox1(context).r(true);
            f92.c(view, "it");
            f = this.f7260a;
        } else {
            Context context2 = this.f2681a.getContext();
            f92.c(context2, "context");
            new ox1(context2).u();
            f92.c(view, "it");
            f = 1.0f;
        }
        view.setAlpha(f);
    }
}

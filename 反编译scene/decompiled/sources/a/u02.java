package a;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class u02 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ float f7552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f3092a;

    public u02(View view, float f) {
        this.f3092a = view;
        this.f7552a = f;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        float f;
        if (f92.a(py1.f7160a.a(), Boolean.TRUE)) {
            Context context = this.f3092a.getContext();
            f92.c(context, "context");
            new py1(context).y(true);
            f92.c(view, "it");
            f = this.f7552a;
        } else {
            Context context2 = this.f3092a.getContext();
            f92.c(context2, "context");
            new py1(context2).C();
            f92.c(view, "it");
            f = 1.0f;
        }
        view.setAlpha(f);
    }
}

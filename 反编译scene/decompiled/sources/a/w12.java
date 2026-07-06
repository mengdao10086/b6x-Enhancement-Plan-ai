package a;

import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class w12 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d22 f7745a;

    public w12(d22 d22Var) {
        this.f7745a = d22Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            View viewFindViewById = view.findViewById(t61.fw_chart_list);
            f92.c(viewFindViewById, "it.findViewById<LinearLayout>(R.id.fw_chart_list)");
            ((LinearLayout) viewFindViewById).setOrientation(this.f7745a.f465a ? 0 : 1);
            View view2 = d22.b;
            if (view2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
            }
            ((LinearLayout) view2).setOrientation(this.f7745a.f465a ? 1 : 0);
        } catch (Exception unused) {
        }
    }
}

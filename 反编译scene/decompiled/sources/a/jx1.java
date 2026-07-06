package a;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jx1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m92 f6552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ox1 f1582a;

    public jx1(m92 m92Var, ox1 ox1Var) {
        this.f6552a = m92Var;
        this.f1582a = ox1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        try {
            TextView textView = this.f1582a.f2341e;
            if (textView != null) {
                textView.setVisibility(this.f1582a.f2337b ? 8 : 0);
            }
            View viewFindViewById = view.findViewById(t61.fw_chart_list);
            f92.c(viewFindViewById, "it.findViewById<LinearLayout>(R.id.fw_chart_list)");
            ((LinearLayout) viewFindViewById).setOrientation(this.f1582a.f2337b ? 0 : 1);
            view2 = ox1.b;
        } catch (Exception unused) {
        }
        if (view2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        ((LinearLayout) view2).setOrientation(this.f1582a.f2337b ? 1 : 0);
        this.f1582a.f2337b = this.f1582a.f2337b ? false : true;
        try {
            if (System.currentTimeMillis() - this.f6552a.f6785a < 300) {
                this.f1582a.r(true);
            } else {
                this.f6552a.f6785a = System.currentTimeMillis();
            }
        } catch (Exception unused2) {
        }
    }
}

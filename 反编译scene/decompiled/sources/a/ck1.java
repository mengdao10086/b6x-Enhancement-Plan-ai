package a;

import a.p80;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ck1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final vj1 f5803a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Activity f421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f422a;

    public ck1(Activity activity, String str, vj1 vj1Var) {
        f92.d(activity, "context");
        f92.d(vj1Var, "iResultCallback");
        this.f421a = activity;
        this.f422a = str;
        this.f5803a = vj1Var;
    }

    public static /* synthetic */ void d(ck1 ck1Var, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        ck1Var.c(z, z2);
    }

    public final void b(String str) {
        if (!f92.a(str, this.f422a)) {
            this.f5803a.a(str);
        }
    }

    public final void c(boolean z, boolean z2) {
        View viewInflate = this.f421a.getLayoutInflater().inflate(2131558540, (ViewGroup) null);
        p80.a aVar = p80.f2403a;
        Activity activity = this.f421a;
        f92.c(viewInflate, "view");
        p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
        viewInflate.findViewById(t61.mode_powersave).setOnClickListener(new yj1(this, bVarT));
        viewInflate.findViewById(t61.mode_balance).setOnClickListener(new zj1(this, bVarT));
        viewInflate.findViewById(t61.mode_performance).setOnClickListener(new ak1(this, bVarT));
        viewInflate.findViewById(t61.mode_fast).setOnClickListener(new bk1(this, bVarT));
        View viewFindViewById = viewInflate.findViewById(t61.mode_empty);
        if (z) {
            viewFindViewById.setOnClickListener(new wj1(this, z, bVarT));
        } else {
            viewFindViewById.setVisibility(8);
        }
        View viewFindViewById2 = viewInflate.findViewById(t61.mode_keep);
        if (z2) {
            viewFindViewById2.setOnClickListener(new xj1(this, z2, bVarT));
        } else {
            viewFindViewById2.setVisibility(8);
        }
    }
}

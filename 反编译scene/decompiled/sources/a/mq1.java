package a;

import a.p80;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mq1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f6835a;

    public mq1(Activity activity) {
        f92.d(activity, "context");
        this.f6835a = activity;
    }

    public final Activity b() {
        return this.f6835a;
    }

    public final void c(iz0 iz0Var) {
        jz0 jz0VarF = iz0Var.f();
        if (jz0VarF != null) {
            View viewInflate = this.f6835a.getLayoutInflater().inflate(2131558549, (ViewGroup) null);
            p80.a aVar = p80.f2403a;
            Activity activity = this.f6835a;
            f92.c(viewInflate, "view");
            p80.b bVarT = p80.a.t(aVar, activity, viewInflate, false, 4, null);
            CompoundButton compoundButton = (CompoundButton) viewInflate.findViewById(t61.xposed_android_scroll);
            compoundButton.setChecked(jz0VarF.a());
            CompoundButton compoundButton2 = (CompoundButton) viewInflate.findViewById(t61.xposed_root_icon_hide);
            compoundButton2.setChecked(jz0VarF.c());
            CompoundButton compoundButton3 = (CompoundButton) viewInflate.findViewById(t61.xposed_foreground_disable);
            compoundButton3.setChecked(jz0VarF.b());
            CompoundButton compoundButton4 = (CompoundButton) viewInflate.findViewById(t61.xposed_reverse_optimizer);
            compoundButton4.setChecked(jz0VarF.d());
            viewInflate.findViewById(2131362069).setOnClickListener(new jq1(bVarT, iz0Var));
            viewInflate.findViewById(2131362070).setOnClickListener(new kq1(this, bVarT, jz0VarF, compoundButton, compoundButton2, compoundButton3, compoundButton4, iz0Var));
        }
    }

    public final void d() {
        iz0 iz0Var = new iz0(this.f6835a);
        iz0Var.b(new lq1(this, iz0Var));
    }
}

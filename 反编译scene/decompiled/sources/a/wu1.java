package a;

import a.p80;
import android.content.Intent;
import android.view.View;
import android.widget.Switch;
import com.omarea.vtools.activities.ActivityAppConfig2;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wu1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f7824a;

    public wu1(kv1 kv1Var) {
        this.f7824a = kv1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent;
        if (this.f7824a.T1() && f92.a(wu0.f3480a.d(), wu0.f3480a.b())) {
            intent = new Intent(this.f7824a.p(), (Class<?>) ActivityAppConfig2.class);
        } else {
            Switch r10 = (Switch) this.f7824a.w1(t61.dynamic_control);
            f92.c(r10, "dynamic_control");
            if (!r10.isChecked()) {
                p80.a aVar = p80.f2403a;
                cl clVarJ = this.f7824a.j();
                f92.b(clVarJ);
                f92.c(clVarJ, "activity!!");
                String strJ = this.f7824a.J(u61.please_notice);
                f92.c(strJ, "getString(R.string.please_notice)");
                String strJ2 = this.f7824a.J(u61.schedule_dynamic_off);
                f92.c(strJ2, "getString(R.string.schedule_dynamic_off)");
                aVar.M(clVarJ, (16 & 2) != 0 ? "" : strJ, (16 & 4) != 0 ? "" : strJ2, (16 & 8) != 0 ? null : new vu1(this), (16 & 16) != 0 ? null : null);
                return;
            }
            intent = new Intent(this.f7824a.p(), (Class<?>) ActivityAppConfig2.class);
        }
        this.f7824a.s1(intent);
    }
}

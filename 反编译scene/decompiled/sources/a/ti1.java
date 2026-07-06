package a;

import a.p80;
import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ti1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fj0 f7505a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f3033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pj1 f3034a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f3035a;

    public ti1(pj1 pj1Var, p80.b bVar, fj0 fj0Var, CompoundButton compoundButton) {
        this.f3034a = pj1Var;
        this.f3033a = bVar;
        this.f7505a = fj0Var;
        this.f3035a = compoundButton;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        pj1 pj1Var;
        boolean zIsChecked;
        String str;
        this.f3033a.c();
        int iG = this.f7505a.g();
        if (iG == 0) {
            pj1Var = this.f3034a;
            CompoundButton compoundButton = this.f3035a;
            f92.c(compoundButton, "switchForce");
            zIsChecked = compoundButton.isChecked();
            str = "speed";
        } else if (iG != 1) {
            if (iG != 2) {
                return;
            }
            this.f3034a.z();
            return;
        } else {
            pj1Var = this.f3034a;
            CompoundButton compoundButton2 = this.f3035a;
            f92.c(compoundButton2, "switchForce");
            zIsChecked = compoundButton2.isChecked();
            str = "everything";
        }
        pj1Var.y(str, zIsChecked);
    }
}

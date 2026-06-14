package a;

import a.p80;
import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bp1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ dp1 f5723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f293a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f294a;
    public final /* synthetic */ CompoundButton b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final /* synthetic */ boolean f295b;

    public bp1(dp1 dp1Var, p80.b bVar, boolean z, CompoundButton compoundButton, CompoundButton compoundButton2) {
        this.f5723a = dp1Var;
        this.f293a = bVar;
        this.f295b = z;
        this.f294a = compoundButton;
        this.b = compoundButton2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f293a.c();
        if (this.f295b) {
            rx0 rx0Var = new rx0(this.f5723a.g(), this.f5723a.f591a);
            CompoundButton compoundButton = this.f294a;
            f92.c(compoundButton, "refreshRate");
            rx0Var.j("enable", compoundButton.isChecked());
        }
        rx0 rx0Var2 = new rx0(this.f5723a.g(), this.f5723a.b);
        CompoundButton compoundButton2 = this.b;
        f92.c(compoundButton2, "bypass");
        rx0Var2.k("enable", compoundButton2.isChecked() ? "1" : "0");
    }
}

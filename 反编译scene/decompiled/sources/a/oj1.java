package a;

import a.p80;
import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oj1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f7029a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pj1 f2256a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f2257a;
    public final /* synthetic */ CompoundButton b;

    public oj1(pj1 pj1Var, p80.b bVar, CompoundButton compoundButton, CompoundButton compoundButton2) {
        this.f2256a = pj1Var;
        this.f7029a = bVar;
        this.f2257a = compoundButton;
        this.b = compoundButton2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7029a.c();
        pj1 pj1Var = this.f2256a;
        CompoundButton compoundButton = this.f2257a;
        f92.c(compoundButton, "userOnly");
        boolean zIsChecked = compoundButton.isChecked();
        CompoundButton compoundButton2 = this.b;
        f92.c(compoundButton2, "keepData");
        pj1Var.g(zIsChecked, compoundButton2.isChecked());
    }
}

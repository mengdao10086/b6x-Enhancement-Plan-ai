package a;

import a.p80;
import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mj1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6815a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pj1 f1938a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f1939a;
    public final /* synthetic */ CompoundButton b;

    public mj1(pj1 pj1Var, p80.b bVar, CompoundButton compoundButton, CompoundButton compoundButton2) {
        this.f1938a = pj1Var;
        this.f6815a = bVar;
        this.f1939a = compoundButton;
        this.b = compoundButton2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6815a.c();
        pj1 pj1Var = this.f1938a;
        CompoundButton compoundButton = this.f1939a;
        f92.c(compoundButton, "userOnly");
        boolean zIsChecked = compoundButton.isChecked();
        CompoundButton compoundButton2 = this.b;
        f92.c(compoundButton2, "keepData");
        pj1Var.g(zIsChecked, compoundButton2.isChecked());
    }
}

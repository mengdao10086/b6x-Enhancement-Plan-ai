package a;

import a.p80;
import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ui1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f7601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pj1 f3177a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f3178a;
    public final /* synthetic */ CompoundButton b;
    public final /* synthetic */ CompoundButton c;

    public ui1(pj1 pj1Var, p80.b bVar, CompoundButton compoundButton, CompoundButton compoundButton2, CompoundButton compoundButton3) {
        this.f3177a = pj1Var;
        this.f7601a = bVar;
        this.f3178a = compoundButton;
        this.b = compoundButton2;
        this.c = compoundButton3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7601a.c();
        CompoundButton compoundButton = this.f3178a;
        f92.c(compoundButton, "switchSuspend");
        boolean zIsChecked = compoundButton.isChecked();
        CompoundButton compoundButton2 = this.b;
        f92.c(compoundButton2, "switchFreeze");
        boolean zIsChecked2 = compoundButton2.isChecked();
        CompoundButton compoundButton3 = this.c;
        f92.c(compoundButton3, "switchHide");
        this.f3177a.e(zIsChecked, zIsChecked2, compoundButton3.isChecked());
    }
}

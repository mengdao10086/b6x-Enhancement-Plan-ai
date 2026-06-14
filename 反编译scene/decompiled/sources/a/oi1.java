package a;

import a.p80;
import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oi1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f7026a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pj1 f2251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f2252a;

    public oi1(pj1 pj1Var, p80.b bVar, CompoundButton compoundButton) {
        this.f2251a = pj1Var;
        this.f7026a = bVar;
        this.f2252a = compoundButton;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f7026a.c();
        pj1 pj1Var = this.f2251a;
        CompoundButton compoundButton = this.f2252a;
        f92.c(compoundButton, "userOnly");
        pj1Var.b(compoundButton.isChecked());
    }
}

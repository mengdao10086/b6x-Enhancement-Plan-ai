package a;

import a.p80;
import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class mi1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p80.b f6812a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ pj1 f1933a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f1934a;

    public mi1(pj1 pj1Var, p80.b bVar, CompoundButton compoundButton) {
        this.f1933a = pj1Var;
        this.f6812a = bVar;
        this.f1934a = compoundButton;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f6812a.c();
        pj1 pj1Var = this.f1933a;
        CompoundButton compoundButton = this.f1934a;
        f92.c(compoundButton, "permissions");
        pj1Var.a(compoundButton.isChecked());
    }
}

package a;

import a.p80;
import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jl1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i92 f6523a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ l92 f1552a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f1553a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ nl1 f1554a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f1555a;

    public jl1(nl1 nl1Var, i92 i92Var, CompoundButton compoundButton, l92 l92Var, n92 n92Var) {
        this.f1554a = nl1Var;
        this.f6523a = i92Var;
        this.f1555a = compoundButton;
        this.f1552a = l92Var;
        this.f1553a = n92Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        i92 i92Var = this.f6523a;
        CompoundButton compoundButton = this.f1555a;
        f92.c(compoundButton, "electricity_double");
        i92Var.b = compoundButton.isChecked();
        this.f1554a.f2111a.edit().putInt(m61.f6775a.c(), this.f1552a.f6687a).putBoolean(m61.f6775a.a(), this.f6523a.b).putBoolean(m61.f6775a.d(), true).apply();
        p80.b bVar = (p80.b) this.f1553a.f6891a;
        if (bVar != null) {
            bVar.c();
        }
    }
}

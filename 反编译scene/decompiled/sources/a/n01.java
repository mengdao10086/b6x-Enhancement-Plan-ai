package a;

import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class n01 implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6858a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p01 f1983a;

    public n01(p01 p01Var, int i) {
        this.f1983a = p01Var;
        this.f6858a = i;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f1983a.f().put(Integer.valueOf(this.f6858a), Boolean.valueOf(z));
    }
}

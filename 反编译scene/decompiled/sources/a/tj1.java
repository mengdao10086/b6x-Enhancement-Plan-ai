package a;

import a.p80;
import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tj1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fj0 f7509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ p80.b f3038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ uj1 f3039a;

    public tj1(uj1 uj1Var, p80.b bVar, fj0 fj0Var) {
        this.f3039a = uj1Var;
        this.f3038a = bVar;
        this.f7509a = fj0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3038a.c();
        CompoundButton compoundButtonF = this.f7509a.f();
        Integer num = (Integer) (compoundButtonF != null ? compoundButtonF.getTag() : null);
        if (num != null) {
            this.f3039a.a().a(num.intValue(), this.f3039a.b(num));
        } else {
            this.f3039a.a().a(-1, this.f3039a.b(-1));
        }
    }
}

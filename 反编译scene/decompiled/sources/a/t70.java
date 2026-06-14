package a;

import android.view.View;
import android.widget.CompoundButton;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t70 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n30 f7473a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ r70 f2998a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ u70 f2999a;

    public t70(u70 u70Var, n30 n30Var, r70 r70Var) {
        this.f2999a = u70Var;
        this.f7473a = n30Var;
        this.f2998a = r70Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        CompoundButton compoundButtonA;
        boolean z;
        if (this.f2999a.b.contains(this.f7473a)) {
            if (this.f2999a.f3152b) {
                this.f2999a.b.remove(this.f7473a);
                compoundButtonA = this.f2998a.a();
                if (compoundButtonA != null) {
                    z = false;
                    compoundButtonA.setChecked(z);
                }
            }
        } else if (this.f2999a.f3152b) {
            this.f2999a.b.add(this.f7473a);
            compoundButtonA = this.f2998a.a();
            if (compoundButtonA != null) {
                z = true;
                compoundButtonA.setChecked(z);
            }
        } else {
            this.f2999a.b.clear();
            this.f2999a.b.add(this.f7473a);
            this.f2999a.notifyDataSetChanged();
        }
        if (this.f2999a.f3152b) {
            return;
        }
        this.f2999a.f().f(this.f7473a);
    }
}

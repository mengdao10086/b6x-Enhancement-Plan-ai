package a;

import android.view.View;
import android.widget.CompoundButton;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class p70 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m70 f7092a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n30 f2401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ v70 f2402a;

    public p70(v70 v70Var, n30 n30Var, m70 m70Var) {
        this.f2402a = v70Var;
        this.f2401a = n30Var;
        this.f7092a = m70Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object next;
        l70 l70Var;
        boolean z = true;
        if (this.f2402a.f3258b) {
            this.f2401a.h(!r5.c());
            CompoundButton compoundButtonA = this.f7092a.a();
            if (compoundButtonA != null) {
                compoundButtonA.setChecked(this.f2401a.c());
            }
        } else {
            if (this.f2401a.c()) {
                z = false;
            } else {
                Iterator it = this.f2402a.f3257b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (((n30) next).c()) {
                            break;
                        }
                    }
                }
                n30 n30Var = (n30) next;
                if (n30Var != null) {
                    n30Var.h(false);
                }
                this.f2401a.h(true);
                this.f2402a.notifyDataSetChanged();
            }
            this.f2402a.g().f(this.f2401a);
        }
        if (!z || (l70Var = this.f2402a.f3252a) == null) {
            return;
        }
        l70Var.a(this.f2402a.j());
    }
}

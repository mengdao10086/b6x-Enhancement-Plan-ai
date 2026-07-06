package a;

import a.d70;
import android.view.View;
import android.widget.CompoundButton;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class j70 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d70.a f6482a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ d70 f1509a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ g70 f1510a;

    public j70(d70 d70Var, d70.a aVar, g70 g70Var) {
        this.f1509a = d70Var;
        this.f6482a = aVar;
        this.f1510a = g70Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object next;
        if (!this.f1509a.f502b && !this.f6482a.getSelected()) {
            Iterator it = this.f1509a.b.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (((d70.a) next).getSelected()) {
                        break;
                    }
                }
            }
            d70.a aVar = (d70.a) next;
            if (aVar != null) {
                aVar.setSelected(false);
            }
            this.f6482a.setSelected(true);
            this.f1509a.notifyDataSetChanged();
        } else if (this.f1509a.f502b) {
            d70.a aVar2 = this.f6482a;
            aVar2.setSelected(true ^ aVar2.getSelected());
            CompoundButton compoundButtonA = this.f1510a.a();
            if (compoundButtonA != null) {
                compoundButtonA.setChecked(this.f6482a.getSelected());
            }
        }
        f70 f70Var = this.f1509a.f5867a;
        if (f70Var != null) {
            f70Var.a(this.f1509a.g());
        }
    }
}

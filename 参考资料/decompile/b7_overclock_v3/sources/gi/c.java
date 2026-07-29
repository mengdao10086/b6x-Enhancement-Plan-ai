package gi;

import android.view.View;
import g.i;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c extends d {
    public c(View view, eu.davidea.flexibleadapter.b bVar) {
        super(view, bVar);
    }

    @Override // gi.d, di.a.b
    @i
    public void e(int i10, int i11) {
        if (this.f29556c.X2(i())) {
            r(i10);
        }
        super.e(i10, i11);
    }

    @Override // gi.d, android.view.View.OnClickListener
    @i
    public void onClick(View view) {
        if (this.f29556c.c3(i())) {
            x();
        }
        super.onClick(view);
    }

    @Override // gi.d, android.view.View.OnLongClickListener
    @i
    public boolean onLongClick(View view) {
        int i10 = i();
        if (this.f29556c.c3(i10) && u()) {
            r(i10);
        }
        return super.onLongClick(view);
    }

    public void r(int i10) {
        this.f29556c.collapse(i10, w());
        if (this.itemView.getX() < 0.0f || this.itemView.getY() < 0.0f) {
            this.f29556c.getRecyclerView().D1(i10);
        }
    }

    public void s(int i10) {
        this.f29556c.expand(i10, w());
    }

    public boolean t() {
        return true;
    }

    public boolean u() {
        return true;
    }

    public boolean v() {
        return true;
    }

    public boolean w() {
        return false;
    }

    public void x() {
        int i10 = i();
        if (t() && this.f29556c.X2(i10)) {
            r(i10);
        } else {
            if (!v() || this.f29556c.B(i10)) {
                return;
            }
            s(i10);
        }
    }

    public c(View view, eu.davidea.flexibleadapter.b bVar, boolean z10) {
        super(view, bVar, z10);
    }
}

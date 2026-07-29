package gi;

import android.animation.Animator;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.u0;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import di.a;
import ei.h;
import eu.davidea.flexibleadapter.b;
import g.i;
import g.n0;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class d extends b implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, a.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final eu.davidea.flexibleadapter.b f29556c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f29557d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f29558e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f29559f;

    public d(View view, eu.davidea.flexibleadapter.b bVar) {
        this(view, bVar, false);
    }

    @Override // di.a.b
    public final boolean a() {
        h hVarG2 = this.f29556c.g2(i());
        return hVarG2 != null && hVarG2.a();
    }

    @Override // di.a.b
    public final boolean b() {
        h hVarG2 = this.f29556c.g2(i());
        return hVarG2 != null && hVarG2.b();
    }

    @Override // di.a.b
    public View c() {
        return null;
    }

    @Override // di.a.b
    public View d() {
        return this.itemView;
    }

    @i
    public void e(int i10, int i11) {
        this.f29559f = i11;
        this.f29558e = this.f29556c.B(i10);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i10);
        objArr[1] = fi.a.f(this.f29556c.t());
        objArr[2] = i11 == 1 ? "Swipe(1)" : "Drag(2)";
        fi.b.q("onActionStateChanged position=%s mode=%s actionState=%s", objArr);
        if (i11 != 2) {
            if (i11 == 1 && o() && !this.f29558e) {
                this.f29556c.M(i10);
                q();
                return;
            }
            return;
        }
        if (!this.f29558e) {
            if ((this.f29557d || this.f29556c.t() == 2) && (p() || this.f29556c.t() != 2)) {
                eu.davidea.flexibleadapter.b bVar = this.f29556c;
                if (bVar.E0 != null && bVar.A(i10)) {
                    fi.b.q("onLongClick on position %s mode=%s", Integer.valueOf(i10), Integer.valueOf(this.f29556c.t()));
                    this.f29556c.E0.S(i10);
                    this.f29558e = true;
                }
            }
            if (!this.f29558e) {
                this.f29556c.M(i10);
            }
        }
        if (h().isActivated()) {
            return;
        }
        q();
    }

    @Override // di.a.b
    @i
    public void f(int i10) {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i10);
        objArr[1] = fi.a.f(this.f29556c.t());
        objArr[2] = this.f29559f == 1 ? "Swipe(1)" : "Drag(2)";
        fi.b.q("onItemReleased position=%s mode=%s actionState=%s", objArr);
        if (!this.f29558e) {
            if (p() && this.f29556c.t() == 2) {
                fi.b.q("onLongClick for ActionMode on position %s mode=%s", Integer.valueOf(i10), Integer.valueOf(this.f29556c.t()));
                b.a0 a0Var = this.f29556c.E0;
                if (a0Var != null) {
                    a0Var.S(i10);
                }
                if (this.f29556c.B(i10)) {
                    q();
                }
            } else if (o() && h().isActivated()) {
                this.f29556c.M(i10);
                q();
            } else if (this.f29559f == 2) {
                this.f29556c.M(i10);
                if (h().isActivated()) {
                    q();
                }
            }
        }
        this.f29557d = false;
        this.f29559f = 0;
    }

    @Override // di.a.b
    public View g() {
        return null;
    }

    public float k() {
        return 0.0f;
    }

    public void l(@n0 List<Animator> list, int i10, boolean z10) {
    }

    @i
    public void m(@n0 View view) {
        if (view != null) {
            view.setOnTouchListener(this);
        }
    }

    public void n(boolean z10) {
        if (this.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.c) {
            ((StaggeredGridLayoutManager.c) this.itemView.getLayoutParams()).M(z10);
        }
    }

    public boolean o() {
        return false;
    }

    @i
    public void onClick(View view) {
        int i10 = i();
        if (this.f29556c.c3(i10) && this.f29556c.D0 != null && this.f29559f == 0) {
            fi.b.q("onClick on position %s mode=%s", Integer.valueOf(i10), fi.a.f(this.f29556c.t()));
            if (this.f29556c.D0.M(view, i10)) {
                q();
            }
        }
    }

    @i
    public boolean onLongClick(View view) {
        int i10 = i();
        if (!this.f29556c.c3(i10)) {
            return false;
        }
        eu.davidea.flexibleadapter.b bVar = this.f29556c;
        if (bVar.E0 == null || bVar.d3()) {
            this.f29557d = true;
            return false;
        }
        fi.b.q("onLongClick on position %s mode=%s", Integer.valueOf(i10), fi.a.f(this.f29556c.t()));
        this.f29556c.E0.S(i10);
        q();
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i10 = i();
        if (!this.f29556c.c3(i10) || !b()) {
            fi.b.r("Can't start drag: Item is not enabled or draggable!", new Object[0]);
            return false;
        }
        fi.b.q("onTouch with DragHandleView on position %s mode=%s", Integer.valueOf(i10), fi.a.f(this.f29556c.t()));
        if (motionEvent.getActionMasked() == 0 && this.f29556c.a3()) {
            this.f29556c.j2().E(this);
        }
        return false;
    }

    public boolean p() {
        return false;
    }

    @i
    public void q() {
        int i10 = i();
        if (this.f29556c.A(i10)) {
            boolean zB = this.f29556c.B(i10);
            if ((!h().isActivated() || zB) && (h().isActivated() || !zB)) {
                return;
            }
            h().setActivated(zB);
            if (this.f29556c.x2() == i10) {
                this.f29556c.w1();
            }
            if (h().isActivated() && k() > 0.0f) {
                u0.N1(this.itemView, k());
            } else if (k() > 0.0f) {
                u0.N1(this.itemView, 0.0f);
            }
        }
    }

    public d(View view, eu.davidea.flexibleadapter.b bVar, boolean z10) {
        super(view, bVar, z10);
        this.f29557d = false;
        this.f29558e = false;
        this.f29559f = 0;
        this.f29556c = bVar;
        if (bVar.D0 != null) {
            h().setOnClickListener(this);
        }
        if (bVar.E0 != null) {
            h().setOnLongClickListener(this);
        }
    }
}

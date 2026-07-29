package rg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import g.l;
import g.n0;
import g.p0;
import mg.f;
import mg.g;
import mg.h;
import mg.i;
import mg.j;

/* JADX INFO: loaded from: classes5.dex */
public abstract class b extends RelativeLayout implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f48754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ng.b f48755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f48756c;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@n0 View view) {
        this(view, view instanceof h ? (h) view : null);
    }

    @SuppressLint({"RestrictedApi"})
    public boolean a(boolean z10) {
        h hVar = this.f48756c;
        return (hVar instanceof f) && ((f) hVar).a(z10);
    }

    public void b(@n0 j jVar, int i10, int i11) {
        h hVar = this.f48756c;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.b(jVar, i10, i11);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof h) && getView() == ((h) obj).getView();
    }

    public void f(float f10, int i10, int i11) {
        h hVar = this.f48756c;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.f(f10, i10, i11);
    }

    @Override // mg.h
    @n0
    public ng.b getSpinnerStyle() {
        int i10;
        ng.b bVar = this.f48755b;
        if (bVar != null) {
            return bVar;
        }
        h hVar = this.f48756c;
        if (hVar != null && hVar != this) {
            return hVar.getSpinnerStyle();
        }
        View view = this.f48754a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.m) {
                ng.b bVar2 = ((SmartRefreshLayout.m) layoutParams).f22293b;
                this.f48755b = bVar2;
                if (bVar2 != null) {
                    return bVar2;
                }
            }
            if (layoutParams != null && ((i10 = layoutParams.height) == 0 || i10 == -1)) {
                for (ng.b bVar3 : ng.b.f42148i) {
                    if (bVar3.f42151c) {
                        this.f48755b = bVar3;
                        return bVar3;
                    }
                }
            }
        }
        ng.b bVar4 = ng.b.f42143d;
        this.f48755b = bVar4;
        return bVar4;
    }

    @Override // mg.h
    @n0
    public View getView() {
        View view = this.f48754a;
        return view == null ? this : view;
    }

    public void h(@n0 j jVar, @n0 RefreshState refreshState, @n0 RefreshState refreshState2) {
        h hVar = this.f48756c;
        if (hVar == null || hVar == this) {
            return;
        }
        if ((this instanceof qg.b) && (hVar instanceof g)) {
            if (refreshState.isFooter) {
                refreshState = refreshState.toHeader();
            }
            if (refreshState2.isFooter) {
                refreshState2 = refreshState2.toHeader();
            }
        } else if ((this instanceof qg.c) && (hVar instanceof f)) {
            if (refreshState.isHeader) {
                refreshState = refreshState.toFooter();
            }
            if (refreshState2.isHeader) {
                refreshState2 = refreshState2.toFooter();
            }
        }
        h hVar2 = this.f48756c;
        if (hVar2 != null) {
            hVar2.h(jVar, refreshState, refreshState2);
        }
    }

    public void i(@n0 j jVar, int i10, int i11) {
        h hVar = this.f48756c;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.i(jVar, i10, i11);
    }

    public boolean j() {
        h hVar = this.f48756c;
        return (hVar == null || hVar == this || !hVar.j()) ? false : true;
    }

    public int l(@n0 j jVar, boolean z10) {
        h hVar = this.f48756c;
        if (hVar == null || hVar == this) {
            return 0;
        }
        return hVar.l(jVar, z10);
    }

    public void n(@n0 i iVar, int i10, int i11) {
        h hVar = this.f48756c;
        if (hVar != null && hVar != this) {
            hVar.n(iVar, i10, i11);
            return;
        }
        View view = this.f48754a;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof SmartRefreshLayout.m) {
                iVar.g(this, ((SmartRefreshLayout.m) layoutParams).f22292a);
            }
        }
    }

    public void r(boolean z10, float f10, int i10, int i11, int i12) {
        h hVar = this.f48756c;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.r(z10, f10, i10, i11, i12);
    }

    public void setPrimaryColors(@l int... iArr) {
        h hVar = this.f48756c;
        if (hVar == null || hVar == this) {
            return;
        }
        hVar.setPrimaryColors(iArr);
    }

    public b(@n0 View view, @p0 h hVar) {
        super(view.getContext(), null, 0);
        this.f48754a = view;
        this.f48756c = hVar;
        if ((this instanceof qg.b) && (hVar instanceof g) && hVar.getSpinnerStyle() == ng.b.f42147h) {
            hVar.getView().setScaleY(-1.0f);
            return;
        }
        if (this instanceof qg.c) {
            h hVar2 = this.f48756c;
            if ((hVar2 instanceof f) && hVar2.getSpinnerStyle() == ng.b.f42147h) {
                hVar.getView().setScaleY(-1.0f);
            }
        }
    }

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}

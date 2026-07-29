package ei;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public abstract class c<VH extends RecyclerView.e0> implements h<VH> {
    public boolean mEnabled = true;
    public boolean mHidden = false;
    public boolean mSelectable = true;
    public boolean mDraggable = true;
    public boolean mSwipeable = true;

    @Override // ei.h
    public boolean a() {
        return this.mSwipeable;
    }

    @Override // ei.h
    public boolean b() {
        return this.mDraggable;
    }

    @Override // ei.h
    public abstract int c();

    @Override // ei.h
    public boolean d() {
        return this.mHidden;
    }

    public abstract boolean equals(Object obj);

    @Override // ei.h
    public void f(boolean z10) {
        this.mHidden = z10;
    }

    @Override // ei.h
    public void h(boolean z10) {
        this.mDraggable = z10;
    }

    @Override // ei.h
    public abstract VH i(View view, eu.davidea.flexibleadapter.b<h> bVar);

    @Override // ei.h
    public boolean isEnabled() {
        return this.mEnabled;
    }

    @Override // ei.h
    public boolean k() {
        return this.mSelectable;
    }

    @Override // ei.h
    public boolean m(h hVar) {
        return true;
    }

    @Override // ei.h
    public void n(eu.davidea.flexibleadapter.b<h> bVar, VH vh2, int i10) {
    }

    @Override // ei.h
    public abstract void o(eu.davidea.flexibleadapter.b<h> bVar, VH vh2, int i10, List<Object> list);

    @Override // ei.h
    public String p(int i10) {
        return String.valueOf(i10 + 1);
    }

    @Override // ei.h
    public int q() {
        return c();
    }

    @Override // ei.h
    public void r(boolean z10) {
        this.mSwipeable = z10;
    }

    @Override // ei.h
    public void setEnabled(boolean z10) {
        this.mEnabled = z10;
    }

    @Override // ei.h
    public void v(boolean z10) {
        this.mSelectable = z10;
    }

    @Override // ei.h
    public void w(eu.davidea.flexibleadapter.b<h> bVar, VH vh2, int i10) {
    }

    @Override // ei.h
    public void x(eu.davidea.flexibleadapter.b<h> bVar, VH vh2, int i10) {
    }

    @Override // ei.h
    public int y(int i10, int i11) {
        return 1;
    }
}

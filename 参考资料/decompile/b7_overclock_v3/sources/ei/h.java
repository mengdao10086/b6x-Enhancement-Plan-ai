package ei;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import g.f0;
import g.i0;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface h<VH extends RecyclerView.e0> {
    boolean a();

    boolean b();

    @i0
    int c();

    boolean d();

    void f(boolean z10);

    void h(boolean z10);

    VH i(View view, eu.davidea.flexibleadapter.b<h> bVar);

    boolean isEnabled();

    boolean k();

    boolean m(h hVar);

    void n(eu.davidea.flexibleadapter.b<h> bVar, VH vh2, int i10);

    void o(eu.davidea.flexibleadapter.b<h> bVar, VH vh2, int i10, List<Object> list);

    String p(int i10);

    int q();

    void r(boolean z10);

    void setEnabled(boolean z10);

    void v(boolean z10);

    void w(eu.davidea.flexibleadapter.b<h> bVar, VH vh2, int i10);

    void x(eu.davidea.flexibleadapter.b<h> bVar, VH vh2, int i10);

    @f0(from = 1)
    int y(int i10, int i11);
}

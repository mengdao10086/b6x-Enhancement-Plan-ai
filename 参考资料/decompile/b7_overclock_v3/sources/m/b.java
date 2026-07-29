package m;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Context f40498l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l<r0.c, MenuItem> f40499m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public l<r0.d, SubMenu> f40500n;

    public b(Context context) {
        this.f40498l = context;
    }

    public final MenuItem e(MenuItem menuItem) {
        if (!(menuItem instanceof r0.c)) {
            return menuItem;
        }
        r0.c cVar = (r0.c) menuItem;
        if (this.f40499m == null) {
            this.f40499m = new l<>();
        }
        MenuItem menuItem2 = this.f40499m.get(cVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        c cVar2 = new c(this.f40498l, cVar);
        this.f40499m.put(cVar, cVar2);
        return cVar2;
    }

    public final SubMenu f(SubMenu subMenu) {
        if (!(subMenu instanceof r0.d)) {
            return subMenu;
        }
        r0.d dVar = (r0.d) subMenu;
        if (this.f40500n == null) {
            this.f40500n = new l<>();
        }
        SubMenu subMenu2 = this.f40500n.get(dVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        g gVar = new g(this.f40498l, dVar);
        this.f40500n.put(dVar, gVar);
        return gVar;
    }

    public final void g() {
        l<r0.c, MenuItem> lVar = this.f40499m;
        if (lVar != null) {
            lVar.clear();
        }
        l<r0.d, SubMenu> lVar2 = this.f40500n;
        if (lVar2 != null) {
            lVar2.clear();
        }
    }

    public final void h(int i10) {
        if (this.f40499m == null) {
            return;
        }
        int i11 = 0;
        while (i11 < this.f40499m.size()) {
            if (this.f40499m.k(i11).getGroupId() == i10) {
                this.f40499m.m(i11);
                i11--;
            }
            i11++;
        }
    }

    public final void i(int i10) {
        if (this.f40499m == null) {
            return;
        }
        for (int i11 = 0; i11 < this.f40499m.size(); i11++) {
            if (this.f40499m.k(i11).getItemId() == i10) {
                this.f40499m.m(i11);
                return;
            }
        }
    }
}

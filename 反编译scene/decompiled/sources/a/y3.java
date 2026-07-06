package a;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ia<rd, MenuItem> f7944a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3652a;
    public ia<Object, SubMenu> b;

    public y3(Context context) {
        this.f3652a = context;
    }

    public final MenuItem e(MenuItem menuItem) {
        if (!(menuItem instanceof rd)) {
            return menuItem;
        }
        rd rdVar = (rd) menuItem;
        if (this.f7944a == null) {
            this.f7944a = new ia<>();
        }
        MenuItem menuItem2 = this.f7944a.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        r4 r4Var = new r4(this.f3652a, rdVar);
        this.f7944a.put(rdVar, r4Var);
        return r4Var;
    }

    public final SubMenu f(SubMenu subMenu) {
        return subMenu;
    }

    public final void g() {
        ia<rd, MenuItem> iaVar = this.f7944a;
        if (iaVar != null) {
            iaVar.clear();
        }
        ia<Object, SubMenu> iaVar2 = this.b;
        if (iaVar2 != null) {
            iaVar2.clear();
        }
    }

    public final void h(int i) {
        if (this.f7944a == null) {
            return;
        }
        int i2 = 0;
        while (i2 < this.f7944a.size()) {
            if (this.f7944a.i(i2).getGroupId() == i) {
                this.f7944a.k(i2);
                i2--;
            }
            i2++;
        }
    }

    public final void i(int i) {
        if (this.f7944a == null) {
            return;
        }
        for (int i2 = 0; i2 < this.f7944a.size(); i2++) {
            if (this.f7944a.i(i2).getItemId() == i) {
                this.f7944a.k(i2);
                return;
            }
        }
    }
}

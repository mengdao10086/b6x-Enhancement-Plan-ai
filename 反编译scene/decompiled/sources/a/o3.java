package a;

import a.k3;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class o3 implements k3.a {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ActionMode.Callback f2193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<p3> f2194a = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ia<Menu, Menu> f6975a = new ia<>();

    public o3(Context context, ActionMode.Callback callback) {
        this.f2192a = context;
        this.f2193a = callback;
    }

    @Override // a.k3.a
    public boolean a(k3 k3Var, MenuItem menuItem) {
        return this.f2193a.onActionItemClicked(e(k3Var), new r4(this.f2192a, (rd) menuItem));
    }

    @Override // a.k3.a
    public boolean b(k3 k3Var, Menu menu) {
        return this.f2193a.onCreateActionMode(e(k3Var), f(menu));
    }

    @Override // a.k3.a
    public void c(k3 k3Var) {
        this.f2193a.onDestroyActionMode(e(k3Var));
    }

    @Override // a.k3.a
    public boolean d(k3 k3Var, Menu menu) {
        return this.f2193a.onPrepareActionMode(e(k3Var), f(menu));
    }

    public ActionMode e(k3 k3Var) {
        int size = this.f2194a.size();
        for (int i = 0; i < size; i++) {
            p3 p3Var = this.f2194a.get(i);
            if (p3Var != null && p3Var.f7078a == k3Var) {
                return p3Var;
            }
        }
        p3 p3Var2 = new p3(this.f2192a, k3Var);
        this.f2194a.add(p3Var2);
        return p3Var2;
    }

    public final Menu f(Menu menu) {
        Menu menu2 = this.f6975a.get(menu);
        if (menu2 != null) {
            return menu2;
        }
        x4 x4Var = new x4(this.f2192a, (qd) menu);
        this.f6975a.put(menu, x4Var);
        return x4Var;
    }
}

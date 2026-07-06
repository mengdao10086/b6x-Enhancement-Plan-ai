package a;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class uf {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tf f7590a;

    public uf(Context context) {
    }

    public abstract boolean a();

    public boolean b() {
        return true;
    }

    public abstract View c();

    public View d(MenuItem menuItem) {
        return c();
    }

    public abstract boolean e();

    public abstract void f(SubMenu subMenu);

    public boolean g() {
        return false;
    }

    public void h() {
        this.f7590a = null;
    }

    public void i(sf sfVar) {
    }

    public void j(tf tfVar) {
        if (this.f7590a != null && tfVar != null) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f7590a = tfVar;
    }
}

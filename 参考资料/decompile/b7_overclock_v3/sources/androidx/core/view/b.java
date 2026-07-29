package androidx.core.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f4801d = "ActionProvider(support)";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f4802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f4803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public InterfaceC0042b f4804c;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface a {
        void a(boolean z10);
    }

    /* JADX INFO: renamed from: androidx.core.view.b$b, reason: collision with other inner class name */
    public interface InterfaceC0042b {
        void onActionProviderVisibilityChanged(boolean z10);
    }

    public b(@g.n0 Context context) {
        this.f4802a = context;
    }

    @g.n0
    public Context a() {
        return this.f4802a;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return true;
    }

    @g.n0
    public abstract View d();

    @g.n0
    public View e(@g.n0 MenuItem menuItem) {
        return d();
    }

    public boolean f() {
        return false;
    }

    public void g(@g.n0 SubMenu subMenu) {
    }

    public boolean h() {
        return false;
    }

    public void i() {
        if (this.f4804c == null || !h()) {
            return;
        }
        this.f4804c.onActionProviderVisibilityChanged(c());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void j() {
        this.f4804c = null;
        this.f4803b = null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void k(@g.p0 a aVar) {
        this.f4803b = aVar;
    }

    public void l(@g.p0 InterfaceC0042b interfaceC0042b) {
        if (this.f4804c != null && interfaceC0042b != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            sb2.append(getClass().getSimpleName());
            sb2.append(" instance while it is still in use somewhere else?");
        }
        this.f4804c = interfaceC0042b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void m(boolean z10) {
        a aVar = this.f4803b;
        if (aVar != null) {
            aVar.a(z10);
        }
    }
}

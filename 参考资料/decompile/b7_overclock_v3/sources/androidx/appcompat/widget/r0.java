package androidx.appcompat.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.widget.c;

/* JADX INFO: loaded from: classes2.dex */
public class r0 extends androidx.core.view.b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f2665k = 4;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f2666l = "share_history.xml";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2667e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c f2668f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Context f2669g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f2670h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f2671i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public c.f f2672j;

    public interface a {
        boolean a(r0 r0Var, Intent intent);
    }

    public class b implements c.f {
        public b() {
        }

        @Override // androidx.appcompat.widget.c.f
        public boolean a(androidx.appcompat.widget.c cVar, Intent intent) {
            r0 r0Var = r0.this;
            a aVar = r0Var.f2671i;
            if (aVar == null) {
                return false;
            }
            aVar.a(r0Var, intent);
            return false;
        }
    }

    public class c implements MenuItem.OnMenuItemClickListener {
        public c() {
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            r0 r0Var = r0.this;
            Intent intentB = androidx.appcompat.widget.c.d(r0Var.f2669g, r0Var.f2670h).b(menuItem.getItemId());
            if (intentB == null) {
                return true;
            }
            String action = intentB.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                r0.this.r(intentB);
            }
            r0.this.f2669g.startActivity(intentB);
            return true;
        }
    }

    public r0(Context context) {
        super(context);
        this.f2667e = 4;
        this.f2668f = new c();
        this.f2670h = f2666l;
        this.f2669g = context;
    }

    @Override // androidx.core.view.b
    public boolean b() {
        return true;
    }

    @Override // androidx.core.view.b
    public View d() {
        ActivityChooserView activityChooserView = new ActivityChooserView(this.f2669g);
        if (!activityChooserView.isInEditMode()) {
            activityChooserView.setActivityChooserModel(androidx.appcompat.widget.c.d(this.f2669g, this.f2670h));
        }
        TypedValue typedValue = new TypedValue();
        this.f2669g.getTheme().resolveAttribute(R.attr.actionModeShareDrawable, typedValue, true);
        activityChooserView.setExpandActivityOverflowButtonDrawable(i.a.b(this.f2669g, typedValue.resourceId));
        activityChooserView.setProvider(this);
        activityChooserView.setDefaultActionButtonContentDescription(R.string.abc_shareactionprovider_share_with_application);
        activityChooserView.setExpandActivityOverflowButtonContentDescription(R.string.abc_shareactionprovider_share_with);
        return activityChooserView;
    }

    @Override // androidx.core.view.b
    public void g(SubMenu subMenu) {
        subMenu.clear();
        androidx.appcompat.widget.c cVarD = androidx.appcompat.widget.c.d(this.f2669g, this.f2670h);
        PackageManager packageManager = this.f2669g.getPackageManager();
        int iF = cVarD.f();
        int iMin = Math.min(iF, this.f2667e);
        for (int i10 = 0; i10 < iMin; i10++) {
            ResolveInfo resolveInfoE = cVarD.e(i10);
            subMenu.add(0, i10, i10, resolveInfoE.loadLabel(packageManager)).setIcon(resolveInfoE.loadIcon(packageManager)).setOnMenuItemClickListener(this.f2668f);
        }
        if (iMin < iF) {
            SubMenu subMenuAddSubMenu = subMenu.addSubMenu(0, iMin, iMin, this.f2669g.getString(R.string.abc_activity_chooser_view_see_all));
            for (int i11 = 0; i11 < iF; i11++) {
                ResolveInfo resolveInfoE2 = cVarD.e(i11);
                subMenuAddSubMenu.add(0, i11, i11, resolveInfoE2.loadLabel(packageManager)).setIcon(resolveInfoE2.loadIcon(packageManager)).setOnMenuItemClickListener(this.f2668f);
            }
        }
    }

    public final void n() {
        if (this.f2671i == null) {
            return;
        }
        if (this.f2672j == null) {
            this.f2672j = new b();
        }
        androidx.appcompat.widget.c.d(this.f2669g, this.f2670h).u(this.f2672j);
    }

    public void o(a aVar) {
        this.f2671i = aVar;
        n();
    }

    public void p(String str) {
        this.f2670h = str;
        n();
    }

    public void q(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("android.intent.action.SEND".equals(action) || "android.intent.action.SEND_MULTIPLE".equals(action)) {
                r(intent);
            }
        }
        androidx.appcompat.widget.c.d(this.f2669g, this.f2670h).t(intent);
    }

    public void r(Intent intent) {
        intent.addFlags(134742016);
    }
}

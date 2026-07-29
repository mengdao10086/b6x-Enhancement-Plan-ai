package eg;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import bg.c;
import com.permissionx.guolindev.R;
import com.permissionx.guolindev.request.u;
import com.permissionx.guolindev.request.v;
import com.permissionx.guolindev.request.x;
import com.permissionx.guolindev.request.y;
import com.umeng.analytics.pro.d;
import java.util.HashSet;
import java.util.List;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u0016\u001a\u00020\n\u0012\u0006\u0010\u0017\u001a\u00020\n\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u000f\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0004H\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0011\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\fH\u0002¨\u0006\u001e"}, d2 = {"Leg/a;", "Leg/c;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/z1;", "onCreate", "Landroid/view/View;", "c", "a", "", "", "b", "", "f", "()Z", "g", "d", "h", "e", "Landroid/content/Context;", d.R, "permissions", "message", "positiveText", "negativeText", "", "lightColor", "darkColor", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "permissionx_release"}, k = 1, mv = {1, 7, 1})
public final class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final List<String> f26982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final String f26983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public final String f26984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final String f26985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f26986e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f26987f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public dg.a f26988g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@k Context context, @k List<String> permissions, @k String message, @k String positiveText, @l String str, int i10, int i11) {
        super(context, R.style.PermissionXDefaultDialog);
        f0.p(context, "context");
        f0.p(permissions, "permissions");
        f0.p(message, "message");
        f0.p(positiveText, "positiveText");
        this.f26982a = permissions;
        this.f26983b = message;
        this.f26984c = positiveText;
        this.f26985d = str;
        this.f26986e = i10;
        this.f26987f = i11;
    }

    @Override // eg.c
    @l
    public View a() {
        dg.a aVar = null;
        if (this.f26985d == null) {
            return null;
        }
        dg.a aVar2 = this.f26988g;
        if (aVar2 == null) {
            f0.S("binding");
        } else {
            aVar = aVar2;
        }
        return aVar.f26249c;
    }

    @Override // eg.c
    @k
    public List<String> b() {
        return this.f26982a;
    }

    @Override // eg.c
    @k
    public View c() {
        dg.a aVar = this.f26988g;
        if (aVar == null) {
            f0.S("binding");
            aVar = null;
        }
        Button button = aVar.f26252f;
        f0.o(button, "binding.positiveBtn");
        return button;
    }

    public final void d() {
        String str;
        HashSet hashSet = new HashSet();
        int i10 = Build.VERSION.SDK_INT;
        for (String str2 : this.f26982a) {
            dg.a aVar = null;
            if (i10 < 29) {
                try {
                    str = getContext().getPackageManager().getPermissionInfo(str2, 0).group;
                } catch (PackageManager.NameNotFoundException e10) {
                    e10.printStackTrace();
                    str = null;
                }
            } else {
                str = i10 == 29 ? b.b().get(str2) : i10 == 30 ? b.c().get(str2) : i10 == 31 ? b.d().get(str2) : i10 == 33 ? b.e().get(str2) : b.e().get(str2);
            }
            if ((b.a().contains(str2) && !hashSet.contains(str2)) || (str != null && !hashSet.contains(str))) {
                LayoutInflater layoutInflater = getLayoutInflater();
                dg.a aVar2 = this.f26988g;
                if (aVar2 == null) {
                    f0.S("binding");
                    aVar2 = null;
                }
                dg.b bVarD = dg.b.d(layoutInflater, aVar2.f26251e, false);
                f0.o(bVarD, "inflate(layoutInflater, …permissionsLayout, false)");
                if (f0.g(str2, u.f22155f)) {
                    bVarD.f26256c.setText(getContext().getString(R.string.permissionx_access_background_location));
                    ImageView imageView = bVarD.f26255b;
                    PackageManager packageManager = getContext().getPackageManager();
                    f0.m(str);
                    imageView.setImageResource(packageManager.getPermissionGroupInfo(str, 0).icon);
                } else if (f0.g(str2, "android.permission.SYSTEM_ALERT_WINDOW")) {
                    bVarD.f26256c.setText(getContext().getString(R.string.permissionx_system_alert_window));
                    bVarD.f26255b.setImageResource(R.drawable.permissionx_ic_alert);
                } else if (f0.g(str2, "android.permission.WRITE_SETTINGS")) {
                    bVarD.f26256c.setText(getContext().getString(R.string.permissionx_write_settings));
                    bVarD.f26255b.setImageResource(R.drawable.permissionx_ic_setting);
                } else if (f0.g(str2, y.f22163f)) {
                    bVarD.f26256c.setText(getContext().getString(R.string.permissionx_manage_external_storage));
                    ImageView imageView2 = bVarD.f26255b;
                    PackageManager packageManager2 = getContext().getPackageManager();
                    f0.m(str);
                    imageView2.setImageResource(packageManager2.getPermissionGroupInfo(str, 0).icon);
                } else if (f0.g(str2, x.f22161f)) {
                    bVarD.f26256c.setText(getContext().getString(R.string.permissionx_request_install_packages));
                    bVarD.f26255b.setImageResource(R.drawable.permissionx_ic_install);
                } else if (f0.g(str2, c.a.f9430a) && Build.VERSION.SDK_INT < 33) {
                    bVarD.f26256c.setText(getContext().getString(R.string.permissionx_post_notification));
                    bVarD.f26255b.setImageResource(R.drawable.permissionx_ic_notification);
                } else if (f0.g(str2, v.f22157f)) {
                    bVarD.f26256c.setText(getContext().getString(R.string.permissionx_body_sensor_background));
                    ImageView imageView3 = bVarD.f26255b;
                    PackageManager packageManager3 = getContext().getPackageManager();
                    f0.m(str);
                    imageView3.setImageResource(packageManager3.getPermissionGroupInfo(str, 0).icon);
                } else {
                    TextView textView = bVarD.f26256c;
                    Context context = getContext();
                    PackageManager packageManager4 = getContext().getPackageManager();
                    f0.m(str);
                    textView.setText(context.getString(packageManager4.getPermissionGroupInfo(str, 0).labelRes));
                    bVarD.f26255b.setImageResource(getContext().getPackageManager().getPermissionGroupInfo(str, 0).icon);
                }
                if (e()) {
                    int i11 = this.f26987f;
                    if (i11 != -1) {
                        bVarD.f26255b.setColorFilter(i11, PorterDuff.Mode.SRC_ATOP);
                    }
                } else {
                    int i12 = this.f26986e;
                    if (i12 != -1) {
                        bVarD.f26255b.setColorFilter(i12, PorterDuff.Mode.SRC_ATOP);
                    }
                }
                dg.a aVar3 = this.f26988g;
                if (aVar3 == null) {
                    f0.S("binding");
                } else {
                    aVar = aVar3;
                }
                aVar.f26251e.addView(bVarD.getRoot());
                if (str != null) {
                    str2 = str;
                }
                hashSet.add(str2);
            }
        }
    }

    public final boolean e() {
        return (getContext().getResources().getConfiguration().uiMode & 48) == 32;
    }

    public final boolean f() {
        dg.a aVar = this.f26988g;
        if (aVar == null) {
            f0.S("binding");
            aVar = null;
        }
        return aVar.f26251e.getChildCount() == 0;
    }

    public final void g() {
        dg.a aVar = this.f26988g;
        dg.a aVar2 = null;
        if (aVar == null) {
            f0.S("binding");
            aVar = null;
        }
        aVar.f26248b.setText(this.f26983b);
        dg.a aVar3 = this.f26988g;
        if (aVar3 == null) {
            f0.S("binding");
            aVar3 = null;
        }
        aVar3.f26252f.setText(this.f26984c);
        if (this.f26985d != null) {
            dg.a aVar4 = this.f26988g;
            if (aVar4 == null) {
                f0.S("binding");
                aVar4 = null;
            }
            aVar4.f26250d.setVisibility(0);
            dg.a aVar5 = this.f26988g;
            if (aVar5 == null) {
                f0.S("binding");
                aVar5 = null;
            }
            aVar5.f26249c.setText(this.f26985d);
        } else {
            dg.a aVar6 = this.f26988g;
            if (aVar6 == null) {
                f0.S("binding");
                aVar6 = null;
            }
            aVar6.f26250d.setVisibility(8);
        }
        if (e()) {
            if (this.f26987f != -1) {
                dg.a aVar7 = this.f26988g;
                if (aVar7 == null) {
                    f0.S("binding");
                    aVar7 = null;
                }
                aVar7.f26252f.setTextColor(this.f26987f);
                dg.a aVar8 = this.f26988g;
                if (aVar8 == null) {
                    f0.S("binding");
                } else {
                    aVar2 = aVar8;
                }
                aVar2.f26249c.setTextColor(this.f26987f);
                return;
            }
            return;
        }
        if (this.f26986e != -1) {
            dg.a aVar9 = this.f26988g;
            if (aVar9 == null) {
                f0.S("binding");
                aVar9 = null;
            }
            aVar9.f26252f.setTextColor(this.f26986e);
            dg.a aVar10 = this.f26988g;
            if (aVar10 == null) {
                f0.S("binding");
            } else {
                aVar2 = aVar10;
            }
            aVar2.f26249c.setTextColor(this.f26986e);
        }
    }

    public final void h() {
        int i10 = getContext().getResources().getDisplayMetrics().widthPixels;
        if (i10 < getContext().getResources().getDisplayMetrics().heightPixels) {
            Window window = getWindow();
            if (window != null) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                window.setGravity(17);
                attributes.width = (int) (((double) i10) * 0.86d);
                window.setAttributes(attributes);
                return;
            }
            return;
        }
        Window window2 = getWindow();
        if (window2 != null) {
            WindowManager.LayoutParams attributes2 = window2.getAttributes();
            window2.setGravity(17);
            attributes2.width = (int) (((double) i10) * 0.6d);
            window2.setAttributes(attributes2);
        }
    }

    @Override // android.app.Dialog
    public void onCreate(@l Bundle bundle) {
        super.onCreate(bundle);
        dg.a aVarC = dg.a.c(getLayoutInflater());
        f0.o(aVarC, "inflate(layoutInflater)");
        this.f26988g = aVarC;
        if (aVarC == null) {
            f0.S("binding");
            aVarC = null;
        }
        setContentView(aVarC.getRoot());
        g();
        d();
        h();
    }
}

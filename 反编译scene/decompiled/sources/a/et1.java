package a;

import a.p80;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.omarea.xposed.XposedCheck;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class et1 extends Fragment implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final at1 f6040a = new at1(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public x90 f790a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f792a;
    public final String d = e50.f677a.y0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<String> f791a = y42.c("basic", "adb", "root");

    public final void A1(Runnable runnable) {
        boolean z = false;
        try {
            Context contextP = p();
            f92.b(contextP);
            f92.c(contextP, "context!!");
            if (contextP.getPackageManager().getPackageInfo("com.omarea.vaddin", 0) != null) {
                z = true;
            }
        } catch (Exception unused) {
        }
        if (!z) {
            z1();
        } else if (XposedCheck.xposedIsRunning()) {
            runnable.run();
        } else {
            Toast.makeText(p(), J(u61.scene_addin_disabled), 1).show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    @Override // androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void D0(android.view.View r8, android.os.Bundle r9) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.et1.D0(android.view.View, android.os.Bundle):void");
    }

    @Override // androidx.fragment.app.Fragment
    public View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f92.d(layoutInflater, "inflater");
        String strY0 = e50.f677a.y0();
        int iHashCode = strY0.hashCode();
        int i = 2131558556;
        if (iHashCode != 96415) {
            if (iHashCode != 3506402) {
                if (iHashCode == 93508654) {
                    strY0.equals("basic");
                }
            } else if (strY0.equals("root")) {
                i = 2131558554;
            }
        } else if (strY0.equals("adb")) {
            i = 2131558555;
        }
        return layoutInflater.inflate(i, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void l0() {
        super.l0();
        v1();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0047  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r9) {
        /*
            Method dump skipped, instruction units count: 870
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.et1.onClick(android.view.View):void");
    }

    public void v1() {
        HashMap map = this.f792a;
        if (map != null) {
            map.clear();
        }
    }

    public View w1(int i) {
        if (this.f792a == null) {
            this.f792a = new HashMap();
        }
        View view = (View) this.f792a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewM = M();
        if (viewM == null) {
            return null;
        }
        View viewFindViewById = viewM.findViewById(i);
        this.f792a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y1(android.view.View r5) {
        /*
            r4 = this;
            r5.setOnClickListener(r4)
            java.lang.Object r0 = r5.getTag()
            if (r0 == 0) goto Le
            java.lang.String r0 = r0.toString()
            goto Lf
        Le:
            r0 = 0
        Lf:
            r1 = 0
            if (r0 != 0) goto L13
            goto L45
        L13:
            int r2 = r0.hashCode()
            r3 = 96415(0x1789f, float:1.35106E-40)
            if (r2 == r3) goto L3b
            r3 = 3506402(0x3580e2, float:4.913516E-39)
            if (r2 == r3) goto L31
            r3 = 93508654(0x592d42e, float:1.3807717E-35)
            if (r2 == r3) goto L27
            goto L45
        L27:
            java.lang.String r2 = "basic"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L45
            r0 = r1
            goto L46
        L31:
            java.lang.String r2 = "root"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L45
            r0 = 2
            goto L46
        L3b:
            java.lang.String r2 = "adb"
            boolean r0 = r0.equals(r2)
            if (r0 == 0) goto L45
            r0 = 1
            goto L46
        L45:
            r0 = -1
        L46:
            java.util.ArrayList<java.lang.String> r2 = r4.f791a
            java.lang.String r3 = r4.d
            int r2 = r2.indexOf(r3)
            if (r0 <= r2) goto L53
            r5.setEnabled(r1)
        L53:
            int r0 = r5.getId()
            r2 = 2131362706(0x7f0a0392, float:1.83452E38)
            if (r0 != r2) goto L65
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 24
            if (r0 >= r2) goto L65
            r5.setEnabled(r1)
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.et1.y1(android.view.View):void");
    }

    @Override // androidx.fragment.app.Fragment
    public void z0() {
        super.z0();
        if (R()) {
            return;
        }
        cl clVarJ = j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        clVarJ.setTitle(J(u61.app_name));
    }

    public final void z1() {
        p80.a aVar = p80.f2403a;
        Context contextP = p();
        f92.b(contextP);
        f92.c(contextP, "context!!");
        String strJ = J(u61.scene_addin_miss);
        f92.c(strJ, "getString(R.string.scene_addin_miss)");
        String strJ2 = J(u61.scene_addin_miss_desc);
        f92.c(strJ2, "getString(R.string.scene_addin_miss_desc)");
        aVar.M(contextP, (16 & 2) != 0 ? "" : strJ, (16 & 4) != 0 ? "" : strJ2, (16 & 8) != 0 ? null : new bt1(this), (16 & 16) != 0 ? null : null);
    }
}

package a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.omarea.Scene;
import com.omarea.model.AppInfo;
import com.omarea.vtools.activities.ActivityApplications;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class rr1 extends Fragment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ir1 f7326a = new ir1(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final hr1[] f2768a = {hr1.All, hr1.Disabled, hr1.Updated, hr1.Enabled, hr1.Suspended};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public kh0 f2770a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u90 f2771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActivityApplications.a f2772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<AppInfo> f2773a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f2774a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public hr1 f2769a = hr1.All;
    public String d = "";

    public static final /* synthetic */ ActivityApplications.a A1(rr1 rr1Var) {
        ActivityApplications.a aVar = rr1Var.f2772a;
        if (aVar != null) {
            return aVar;
        }
        f92.m("myHandler");
        throw null;
    }

    public static final /* synthetic */ u90 B1(rr1 rr1Var) {
        u90 u90Var = rr1Var.f2771a;
        if (u90Var != null) {
            return u90Var;
        }
        f92.m("processBarDialog");
        throw null;
    }

    public static final /* synthetic */ kh0 y1(rr1 rr1Var) {
        kh0 kh0Var = rr1Var.f2770a;
        if (kh0Var != null) {
            return kh0Var;
        }
        f92.m("appListHelper");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void D0(View view, Bundle bundle) {
        f92.d(view, "view");
        super.D0(view, bundle);
        cl clVarJ = j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        this.f2771a = new u90(clVarJ, "FragmentAppUser");
        mr1 mr1Var = new mr1(this);
        ListView listView = (ListView) w1(t61.app_list);
        f92.c(listView, "app_list");
        listView.setOnItemLongClickListener(mr1Var);
        ((FloatingActionButton) w1(t61.fab_apps)).setOnClickListener(new kr1(this));
        ((CheckBox) w1(t61.select_state_all)).setOnClickListener(new lr1(this));
        if (f92.a(e50.f677a.y0(), "basic")) {
            LinearLayout linearLayout = (LinearLayout) w1(t61.select_all);
            f92.c(linearLayout, "select_all");
            linearLayout.setVisibility(8);
        }
        L1();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.omarea.model.AppInfo> G1() {
        /*
            r8 = this;
            a.hr1 r0 = r8.f2769a
            int[] r1 = a.jr1.f6539a
            int r0 = r0.ordinal()
            r0 = r1[r0]
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 == r3) goto L7c
            r4 = 2
            if (r0 == r4) goto L51
            r4 = 3
            if (r0 == r4) goto L19
            java.util.ArrayList<com.omarea.model.AppInfo> r2 = r8.f2773a
            goto Lb5
        L19:
            java.util.ArrayList<com.omarea.model.AppInfo> r0 = r8.f2773a
            if (r0 == 0) goto Lb5
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L26:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto Lb5
            java.lang.Object r4 = r0.next()
            r5 = r4
            com.omarea.model.AppInfo r5 = (com.omarea.model.AppInfo) r5
            java.lang.Boolean r6 = r5.enabled
            java.lang.String r7 = "it.enabled"
            a.f92.c(r6, r7)
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L4a
            java.lang.Boolean r5 = r5.suspended
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L4a
            r5 = r3
            goto L4b
        L4a:
            r5 = r1
        L4b:
            if (r5 == 0) goto L26
            r2.add(r4)
            goto L26
        L51:
            java.util.ArrayList<com.omarea.model.AppInfo> r0 = r8.f2773a
            if (r0 == 0) goto Lb5
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L5e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lb5
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.omarea.model.AppInfo r3 = (com.omarea.model.AppInfo) r3
            java.lang.Boolean r3 = r3.updated
            java.lang.String r4 = "it.updated"
            a.f92.c(r3, r4)
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L5e
            r2.add(r1)
            goto L5e
        L7c:
            java.util.ArrayList<com.omarea.model.AppInfo> r0 = r8.f2773a
            if (r0 == 0) goto Lb5
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L89:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto Lb5
            java.lang.Object r4 = r0.next()
            r5 = r4
            com.omarea.model.AppInfo r5 = (com.omarea.model.AppInfo) r5
            java.lang.Boolean r6 = r5.enabled
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto Lae
            java.lang.Boolean r5 = r5.suspended
            java.lang.String r6 = "it.suspended"
            a.f92.c(r5, r6)
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto Lac
            goto Lae
        Lac:
            r5 = r1
            goto Laf
        Lae:
            r5 = r3
        Laf:
            if (r5 == 0) goto L89
            r2.add(r4)
            goto L89
        Lb5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a.rr1.G1():java.util.List");
    }

    public final String H1() {
        return this.d;
    }

    public final void I1(Activity activity) {
        ListView listView = (ListView) w1(t61.app_list);
        f92.c(listView, "app_list");
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterAppList");
        }
        ArrayList<AppInfo> arrayListE = ((p01) adapter).e();
        if (arrayListE.size() == 0) {
            Scene.f4798a.n(u61.app_selected_none, 0);
            return;
        }
        if (arrayListE.size() != 1) {
            ActivityApplications.a aVar = this.f2772a;
            if (aVar != null) {
                new pj1(activity, arrayListE, aVar).I();
                return;
            } else {
                f92.m("myHandler");
                throw null;
            }
        }
        AppInfo appInfo = (AppInfo) i52.A(arrayListE);
        ActivityApplications.a aVar2 = this.f2772a;
        if (aVar2 != null) {
            new iq1(activity, appInfo, aVar2).c0();
        } else {
            f92.m("myHandler");
            throw null;
        }
    }

    public final void J1() {
        L1();
    }

    public final void K1(hr1 hr1Var) {
        f92.d(hr1Var, "value");
        if (this.f2769a != hr1Var) {
            this.f2769a = hr1Var;
            ListView listView = (ListView) w1(t61.app_list);
            if (listView != null) {
                M1(G1(), listView);
            }
        }
    }

    public final void L1() {
        u90 u90Var = this.f2771a;
        if (u90Var == null) {
            f92.m("processBarDialog");
            throw null;
        }
        u90.e(u90Var, null, 1, null);
        qc2.d(hf2.f6309a, qe2.b(), null, new or1(this, null), 2, null);
    }

    public final void M1(List<? extends AppInfo> list, ListView listView) {
        if (list == null) {
            return;
        }
        Scene.f4798a.i(new qr1(this, list, listView));
    }

    public final void N1(String str) {
        f92.d(str, "value");
        if (!f92.a(this.d, str)) {
            this.d = str;
            ListView listView = (ListView) w1(t61.app_list);
            if (listView != null) {
                M1(G1(), listView);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View i0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        f92.d(layoutInflater, "inflater");
        Context contextP = p();
        f92.b(contextP);
        f92.c(contextP, "context!!");
        this.f2770a = new kh0(contextP, false, 2, null);
        return layoutInflater.inflate(2131558551, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void l0() {
        super.l0();
        v1();
    }

    public void v1() {
        HashMap map = this.f2774a;
        if (map != null) {
            map.clear();
        }
    }

    public View w1(int i) {
        if (this.f2774a == null) {
            this.f2774a = new HashMap();
        }
        View view = (View) this.f2774a.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewM = M();
        if (viewM == null) {
            return null;
        }
        View viewFindViewById = viewM.findViewById(i);
        this.f2774a.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }
}

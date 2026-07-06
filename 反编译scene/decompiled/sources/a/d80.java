package a;

import a.d70;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class d80 extends e80 {
    public final boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public w70 f5871a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<d70.a> f512a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f513a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String[] f514a;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d80(boolean z, ArrayList<d70.a> arrayList, boolean z2, w70 w70Var) {
        super(y20.dialog_app_chooser, z);
        f92.d(arrayList, "packages");
        this.f512a = arrayList;
        this.A = z2;
        this.f5871a = w70Var;
        this.z = true;
        this.f514a = new String[0];
    }

    @Override // a.e80
    public void C1() {
        HashMap map = this.f513a;
        if (map != null) {
            map.clear();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x009b  */
    @Override // a.e80, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void D0(android.view.View r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.d80.D0(android.view.View, android.os.Bundle):void");
    }

    public final void F1(AbsListView absListView) {
        ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
        if (listAdapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.common.ui.AdapterAppChooser");
        }
        List<d70.a> listG = ((d70) listAdapter).g();
        w70 w70Var = this.f5871a;
        if (w70Var != null) {
            w70Var.a(listG);
        }
        v1();
    }

    public final d80 G1(boolean z) {
        CompoundButton compoundButton;
        this.z = z;
        View viewM = M();
        if (viewM != null && (compoundButton = (CompoundButton) viewM.findViewById(x20.select_all)) != null) {
            compoundButton.setVisibility(z ? 0 : 8);
        }
        return this;
    }

    public final d80 H1(String[] strArr) {
        f92.d(strArr, "apps");
        this.f514a = strArr;
        if (M() != null) {
            Log.e("@DialogAppChooser", "Unable to set the exclusion list, The list has been loaded");
        }
        return this;
    }

    public final void I1(AbsListView absListView) {
        ArrayList<d70.a> arrayList = this.f512a;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (!u42.k(this.f514a, ((d70.a) obj).getPackageName())) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(arrayList2);
        Context context = absListView.getContext();
        f92.c(context, "listVIew.context");
        absListView.setAdapter((ListAdapter) new d70(context, arrayList3, this.A));
    }

    @Override // a.e80, a.wk, androidx.fragment.app.Fragment
    public /* synthetic */ void l0() {
        super.l0();
        C1();
    }
}

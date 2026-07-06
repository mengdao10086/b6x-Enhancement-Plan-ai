package a;

import a.d70;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.omarea.krscript.model.ActionParamInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class sf0 implements w70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cl f7391a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f2886a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActionParamInfo f2887a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Integer f2888a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<d70.a> f2889a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2890a;
    public TextView b;

    public sf0(ActionParamInfo actionParamInfo, cl clVar) {
        View decorView;
        f92.d(actionParamInfo, "actionParamInfo");
        f92.d(clVar, "context");
        this.f2887a = actionParamInfo;
        this.f7391a = clVar;
        Window window = clVar.getWindow();
        Integer numValueOf = (window == null || (decorView = window.getDecorView()) == null) ? null : Integer.valueOf(decorView.getSystemUiVisibility());
        this.f2888a = numValueOf;
        this.f2890a = numValueOf != null && (numValueOf.intValue() & 8192) == 0;
    }

    @Override // a.w70
    public void a(List<? extends d70.a> list) {
        TextView textView;
        String appName;
        f92.d(list, "apps");
        if (this.f2887a.getMultiple()) {
            ArrayList arrayList = new ArrayList(z42.m(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((d70.a) it.next()).getPackageName());
            }
            String strH = i52.H(arrayList, this.f2887a.getSeparator(), null, null, 0, null, null, 62, null);
            ArrayList arrayList2 = new ArrayList(z42.m(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(((d70.a) it2.next()).getAppName());
            }
            appName = i52.H(arrayList2, "，", null, null, 0, null, null, 62, null);
            TextView textView2 = this.f2886a;
            if (textView2 == null) {
                f92.m("valueView");
                throw null;
            }
            textView2.setText(strH);
            textView = this.b;
            if (textView == null) {
                f92.m("nameView");
                throw null;
            }
        } else {
            d70.a aVar = (d70.a) i52.C(list);
            if (aVar == null) {
                TextView textView3 = this.f2886a;
                if (textView3 == null) {
                    f92.m("valueView");
                    throw null;
                }
                textView3.setText("");
                TextView textView4 = this.b;
                if (textView4 != null) {
                    textView4.setText("");
                    return;
                } else {
                    f92.m("nameView");
                    throw null;
                }
            }
            TextView textView5 = this.f2886a;
            if (textView5 == null) {
                f92.m("valueView");
                throw null;
            }
            textView5.setText(aVar.getPackageName());
            textView = this.b;
            if (textView == null) {
                f92.m("nameView");
                throw null;
            }
            appName = aVar.getAppName();
        }
        textView.setText(appName);
    }

    public final List<d70.a> c(boolean z) {
        ArrayList arrayList;
        PackageManager packageManager = this.f7391a.getPackageManager();
        ArrayList<n30> optionsFromShell = this.f2887a.getOptionsFromShell();
        if (optionsFromShell != null) {
            arrayList = new ArrayList(z42.m(optionsFromShell, 10));
            Iterator<T> it = optionsFromShell.iterator();
            while (it.hasNext()) {
                arrayList.add(((n30) it.next()).e());
            }
        } else {
            arrayList = null;
        }
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(8192);
        f92.c(installedPackages, "pm.getInstalledPackages(…GET_UNINSTALLED_PACKAGES)");
        ArrayList<PackageInfo> arrayList2 = new ArrayList();
        for (Object obj : installedPackages) {
            if (arrayList == null || arrayList.contains(((PackageInfo) obj).packageName)) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList(z42.m(arrayList2, 10));
        for (PackageInfo packageInfo : arrayList2) {
            d70.a aVar = new d70.a();
            aVar.setAppName("" + packageInfo.applicationInfo.loadLabel(packageManager));
            String str = packageInfo.packageName;
            f92.c(str, "it.packageName");
            aVar.setPackageName(str);
            arrayList3.add(aVar);
        }
        ArrayList arrayList4 = new ArrayList(arrayList3);
        if (z && this.f2887a.getOptionsFromShell() != null) {
            ArrayList<n30> optionsFromShell2 = this.f2887a.getOptionsFromShell();
            f92.b(optionsFromShell2);
            for (n30 n30Var : optionsFromShell2) {
                ArrayList arrayList5 = new ArrayList();
                for (Object obj2 : arrayList4) {
                    if (f92.a(((d70.a) obj2).getPackageName(), n30Var.e())) {
                        arrayList5.add(obj2);
                    }
                }
                if (arrayList5.isEmpty()) {
                    d70.a aVar2 = new d70.a();
                    aVar2.setAppName("" + n30Var.d());
                    aVar2.setPackageName("" + n30Var.e());
                    m42 m42Var = m42.f6769a;
                    arrayList4.add(aVar2);
                }
            }
        }
        return arrayList4;
    }

    public final void d() {
        f();
        boolean z = this.f2890a;
        ArrayList<d70.a> arrayList = this.f2889a;
        if (arrayList != null) {
            new d80(z, arrayList, this.f2887a.getMultiple(), this).B1(this.f7391a.getSupportFragmentManager(), "app-chooser");
        } else {
            f92.m("packages");
            throw null;
        }
    }

    public final View e() {
        View viewInflate = LayoutInflater.from(this.f7391a).inflate(nb0.kr_param_app, (ViewGroup) null);
        View viewFindViewById = viewInflate.findViewById(mb0.kr_param_app_package);
        f92.c(viewFindViewById, "layout.findViewById(R.id.kr_param_app_package)");
        this.f2886a = (TextView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(mb0.kr_param_app_name);
        f92.c(viewFindViewById2, "layout.findViewById(R.id.kr_param_app_name)");
        this.b = (TextView) viewFindViewById2;
        g();
        viewInflate.findViewById(mb0.kr_param_app_btn).setOnClickListener(new qf0(this));
        TextView textView = this.b;
        if (textView == null) {
            f92.m("nameView");
            throw null;
        }
        textView.setOnClickListener(new rf0(this));
        TextView textView2 = this.f2886a;
        if (textView2 == null) {
            f92.m("valueView");
            throw null;
        }
        textView2.setTag(this.f2887a.getName());
        f92.c(viewInflate, "layout");
        return viewInflate;
    }

    public final void f() {
        Object next;
        int iIndexOf;
        Object next2;
        ArrayList<d70.a> arrayList = this.f2889a;
        if (arrayList == null) {
            f92.m("packages");
            throw null;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            ((d70.a) it.next()).setSelected(false);
        }
        TextView textView = this.f2886a;
        if (textView == null) {
            f92.m("valueView");
            throw null;
        }
        CharSequence text = textView.getText();
        if (this.f2887a.getMultiple()) {
            f92.c(text, "currentValue");
            for (String str : ec2.d0(text, new String[]{this.f2887a.getSeparator()}, false, 0, 6, null)) {
                ArrayList<d70.a> arrayList2 = this.f2889a;
                if (arrayList2 == null) {
                    f92.m("packages");
                    throw null;
                }
                Iterator<T> it2 = arrayList2.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        next2 = it2.next();
                        if (f92.a(((d70.a) next2).getPackageName(), str)) {
                            break;
                        }
                    } else {
                        next2 = null;
                        break;
                    }
                }
                d70.a aVar = (d70.a) next2;
                if (aVar != null) {
                    aVar.setSelected(true);
                }
            }
            return;
        }
        ArrayList<d70.a> arrayList3 = this.f2889a;
        if (arrayList3 == null) {
            f92.m("packages");
            throw null;
        }
        Iterator<T> it3 = arrayList3.iterator();
        while (true) {
            if (it3.hasNext()) {
                next = it3.next();
                if (f92.a(((d70.a) next).getPackageName(), text)) {
                    break;
                }
            } else {
                next = null;
                break;
            }
        }
        d70.a aVar2 = (d70.a) next;
        if (aVar2 != null) {
            ArrayList<d70.a> arrayList4 = this.f2889a;
            if (arrayList4 == null) {
                f92.m("packages");
                throw null;
            }
            iIndexOf = arrayList4.indexOf(aVar2);
        } else {
            iIndexOf = -1;
        }
        if (iIndexOf > -1) {
            ArrayList<d70.a> arrayList5 = this.f2889a;
            if (arrayList5 == null) {
                f92.m("packages");
                throw null;
            }
            arrayList5.get(iIndexOf).setSelected(true);
        }
    }

    public final void g() {
        Object next;
        ArrayList<d70.a> arrayList = new ArrayList<>(c(f92.a(this.f2887a.getType(), "packages")));
        this.f2889a = arrayList;
        if (arrayList == null) {
            f92.m("packages");
            throw null;
        }
        ArrayList arrayList2 = new ArrayList(z42.m(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((d70.a) it.next()).getAppName());
        }
        Object[] array = arrayList2.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) array;
        ArrayList arrayList3 = new ArrayList(z42.m(arrayList, 10));
        Iterator<T> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((d70.a) it2.next()).getPackageName());
        }
        Object[] array2 = arrayList3.toArray(new String[0]);
        if (array2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr2 = (String[]) array2;
        if (this.f2887a.getMultiple()) {
            List<String> listC = he0.f6306a.c(this.f2887a);
            if (listC != null) {
                for (String str : listC) {
                    ArrayList<d70.a> arrayList4 = this.f2889a;
                    if (arrayList4 == null) {
                        f92.m("packages");
                        throw null;
                    }
                    Iterator<T> it3 = arrayList4.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            next = it3.next();
                            if (f92.a(((d70.a) next).getPackageName(), str)) {
                                break;
                            }
                        } else {
                            next = null;
                            break;
                        }
                    }
                    d70.a aVar = (d70.a) next;
                    if (aVar != null) {
                        aVar.setSelected(true);
                    }
                }
            }
            ArrayList<d70.a> arrayList5 = this.f2889a;
            if (arrayList5 == null) {
                f92.m("packages");
                throw null;
            }
            ArrayList arrayList6 = new ArrayList();
            for (Object obj : arrayList5) {
                if (((d70.a) obj).getSelected()) {
                    arrayList6.add(obj);
                }
            }
            a(arrayList6);
            return;
        }
        ArrayList<d70.a> arrayList7 = this.f2889a;
        if (arrayList7 == null) {
            f92.m("packages");
            throw null;
        }
        ArrayList arrayList8 = new ArrayList(z42.m(arrayList7, 10));
        for (d70.a aVar2 : arrayList7) {
            n30 n30Var = new n30();
            n30Var.i(aVar2.getAppName());
            n30Var.j(aVar2.getPackageName());
            arrayList8.add(n30Var);
        }
        int iA = he0.f6306a.a(this.f2887a, new ArrayList<>(i52.Y(arrayList8)));
        if (iA > -1) {
            TextView textView = this.f2886a;
            if (textView == null) {
                f92.m("valueView");
                throw null;
            }
            textView.setText(strArr2[iA]);
            TextView textView2 = this.b;
            if (textView2 != null) {
                textView2.setText(strArr[iA]);
                return;
            } else {
                f92.m("nameView");
                throw null;
            }
        }
        TextView textView3 = this.f2886a;
        if (textView3 == null) {
            f92.m("valueView");
            throw null;
        }
        textView3.setText("");
        TextView textView4 = this.b;
        if (textView4 == null) {
            f92.m("nameView");
            throw null;
        }
        textView4.setText("");
    }
}

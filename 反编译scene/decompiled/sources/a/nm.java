package a;

import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class nm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wm f6931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f2113a = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    public static final wm b;

    static {
        f6931a = Build.VERSION.SDK_INT >= 21 ? new sm() : null;
        b = x();
    }

    public static void A(wm wmVar, Object obj, Object obj2, ba<String, View> baVar, boolean z, sk skVar) {
        ArrayList<String> arrayList = ((hm) skVar).f1190b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        View view = baVar.get((z ? ((hm) skVar).f1192c : ((hm) skVar).f1190b).get(0));
        wmVar.v(obj, view);
        if (obj2 != null) {
            wmVar.v(obj2, view);
        }
    }

    public static void B(ArrayList<View> arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i);
        }
    }

    public static void C(yl ylVar, ArrayList<sk> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, boolean z) {
        if (ylVar.f3734b < 1) {
            return;
        }
        SparseArray sparseArray = new SparseArray();
        for (int i3 = i; i3 < i2; i3++) {
            sk skVar = arrayList.get(i3);
            if (arrayList2.get(i3).booleanValue()) {
                e(skVar, sparseArray, z);
            } else {
                c(skVar, sparseArray, z);
            }
        }
        if (sparseArray.size() != 0) {
            View view = new View(ylVar.f3724a.e());
            int size = sparseArray.size();
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = sparseArray.keyAt(i4);
                ba<String, String> baVarD = d(iKeyAt, arrayList, arrayList2, i, i2);
                mm mmVar = (mm) sparseArray.valueAt(i4);
                if (z) {
                    o(ylVar, iKeyAt, mmVar, view, baVarD);
                } else {
                    n(ylVar, iKeyAt, mmVar, view, baVarD);
                }
            }
        }
    }

    public static void a(ArrayList<View> arrayList, ba<String, View> baVar, Collection<String> collection) {
        for (int size = baVar.size() - 1; size >= 0; size--) {
            View viewM = baVar.m(size);
            if (collection.contains(eh.H(viewM))) {
                arrayList.add(viewM);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(a.sk r16, a.gm r17, android.util.SparseArray<a.mm> r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instruction units count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.nm.b(a.sk, a.gm, android.util.SparseArray, boolean, boolean):void");
    }

    public static void c(sk skVar, SparseArray<mm> sparseArray, boolean z) {
        int size = ((hm) skVar).f1187a.size();
        for (int i = 0; i < size; i++) {
            b(skVar, ((hm) skVar).f1187a.get(i), sparseArray, false, z);
        }
    }

    public static ba<String, String> d(int i, ArrayList<sk> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ArrayList<String> arrayList3;
        ArrayList<String> arrayList4;
        ba<String, String> baVar = new ba<>();
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            sk skVar = arrayList.get(i4);
            if (skVar.x(i)) {
                boolean zBooleanValue = arrayList2.get(i4).booleanValue();
                ArrayList<String> arrayList5 = ((hm) skVar).f1190b;
                if (arrayList5 != null) {
                    int size = arrayList5.size();
                    if (zBooleanValue) {
                        arrayList3 = ((hm) skVar).f1190b;
                        arrayList4 = ((hm) skVar).f1192c;
                    } else {
                        ArrayList<String> arrayList6 = ((hm) skVar).f1190b;
                        arrayList3 = ((hm) skVar).f1192c;
                        arrayList4 = arrayList6;
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        String str = arrayList4.get(i5);
                        String str2 = arrayList3.get(i5);
                        String strRemove = baVar.remove(str2);
                        if (strRemove != null) {
                            baVar.put(str, strRemove);
                        } else {
                            baVar.put(str, str2);
                        }
                    }
                }
            }
        }
        return baVar;
    }

    public static void e(sk skVar, SparseArray<mm> sparseArray, boolean z) {
        if (skVar.f7407a.f3723a.c()) {
            for (int size = ((hm) skVar).f1187a.size() - 1; size >= 0; size--) {
                b(skVar, ((hm) skVar).f1187a.get(size), sparseArray, true, z);
            }
        }
    }

    public static void f(Fragment fragment, Fragment fragment2, boolean z, ba<String, View> baVar, boolean z2) {
        wb wbVarR = z ? fragment2.r() : fragment.r();
        if (wbVarR != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = baVar == null ? 0 : baVar.size();
            for (int i = 0; i < size; i++) {
                arrayList2.add(baVar.i(i));
                arrayList.add(baVar.m(i));
            }
            if (z2) {
                wbVarR.f(arrayList2, arrayList, null);
            } else {
                wbVarR.e(arrayList2, arrayList, null);
            }
        }
    }

    public static boolean g(wm wmVar, List<Object> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (!wmVar.e(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static ba<String, View> h(wm wmVar, ba<String, String> baVar, Object obj, mm mmVar) {
        wb wbVarR;
        ArrayList<String> arrayList;
        String strQ;
        Fragment fragment = mmVar.f1951a;
        View viewM = fragment.M();
        if (baVar.isEmpty() || obj == null || viewM == null) {
            baVar.clear();
            return null;
        }
        ba<String, View> baVar2 = new ba<>();
        wmVar.j(baVar2, viewM);
        sk skVar = mmVar.f6821a;
        if (mmVar.f1952a) {
            wbVarR = fragment.t();
            arrayList = ((hm) skVar).f1190b;
        } else {
            wbVarR = fragment.r();
            arrayList = ((hm) skVar).f1192c;
        }
        if (arrayList != null) {
            baVar2.o(arrayList);
            baVar2.o(baVar.values());
        }
        if (wbVarR != null) {
            wbVarR.c(arrayList, baVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = baVar2.get(str);
                if (view == null) {
                    String strQ2 = q(baVar, str);
                    if (strQ2 != null) {
                        baVar.remove(strQ2);
                    }
                } else if (!str.equals(eh.H(view)) && (strQ = q(baVar, str)) != null) {
                    baVar.put(strQ, eh.H(view));
                }
            }
        } else {
            y(baVar, baVar2);
        }
        return baVar2;
    }

    public static ba<String, View> i(wm wmVar, ba<String, String> baVar, Object obj, mm mmVar) {
        wb wbVarT;
        ArrayList<String> arrayList;
        if (baVar.isEmpty() || obj == null) {
            baVar.clear();
            return null;
        }
        Fragment fragment = mmVar.f1953b;
        ba<String, View> baVar2 = new ba<>();
        wmVar.j(baVar2, fragment.f1());
        sk skVar = mmVar.b;
        if (mmVar.f1954b) {
            wbVarT = fragment.r();
            arrayList = ((hm) skVar).f1192c;
        } else {
            wbVarT = fragment.t();
            arrayList = ((hm) skVar).f1190b;
        }
        baVar2.o(arrayList);
        if (wbVarT != null) {
            wbVarT.c(arrayList, baVar2);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                String str = arrayList.get(size);
                View view = baVar2.get(str);
                if (view == null) {
                    baVar.remove(str);
                } else if (!str.equals(eh.H(view))) {
                    baVar.put(eh.H(view), baVar.remove(str));
                }
            }
        } else {
            baVar.o(baVar2.keySet());
        }
        return baVar2;
    }

    public static wm j(Fragment fragment, Fragment fragment2) {
        ArrayList arrayList = new ArrayList();
        if (fragment != null) {
            Object objS = fragment.s();
            if (objS != null) {
                arrayList.add(objS);
            }
            Object objF = fragment.F();
            if (objF != null) {
                arrayList.add(objF);
            }
            Object objH = fragment.H();
            if (objH != null) {
                arrayList.add(objH);
            }
        }
        if (fragment2 != null) {
            Object objQ = fragment2.q();
            if (objQ != null) {
                arrayList.add(objQ);
            }
            Object objC = fragment2.C();
            if (objC != null) {
                arrayList.add(objC);
            }
            Object objG = fragment2.G();
            if (objG != null) {
                arrayList.add(objG);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        wm wmVar = f6931a;
        if (wmVar != null && g(wmVar, arrayList)) {
            return f6931a;
        }
        wm wmVar2 = b;
        if (wmVar2 != null && g(wmVar2, arrayList)) {
            return b;
        }
        if (f6931a == null && b == null) {
            return null;
        }
        throw new IllegalArgumentException("Invalid Transition types");
    }

    public static ArrayList<View> k(wm wmVar, Object obj, Fragment fragment, ArrayList<View> arrayList, View view) {
        if (obj == null) {
            return null;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        View viewM = fragment.M();
        if (viewM != null) {
            wmVar.f(arrayList2, viewM);
        }
        if (arrayList != null) {
            arrayList2.removeAll(arrayList);
        }
        if (arrayList2.isEmpty()) {
            return arrayList2;
        }
        arrayList2.add(view);
        wmVar.b(obj, arrayList2);
        return arrayList2;
    }

    public static Object l(wm wmVar, ViewGroup viewGroup, View view, ba<String, String> baVar, mm mmVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object objU;
        ba<String, String> baVar2;
        Object obj3;
        Rect rect;
        Fragment fragment = mmVar.f1951a;
        Fragment fragment2 = mmVar.f1953b;
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = mmVar.f1952a;
        if (baVar.isEmpty()) {
            baVar2 = baVar;
            objU = null;
        } else {
            objU = u(wmVar, fragment, fragment2, z);
            baVar2 = baVar;
        }
        ba<String, View> baVarI = i(wmVar, baVar2, objU, mmVar);
        if (baVar.isEmpty()) {
            obj3 = null;
        } else {
            arrayList.addAll(baVarI.values());
            obj3 = objU;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, baVarI, true);
        if (obj3 != null) {
            rect = new Rect();
            wmVar.y(obj3, view, arrayList);
            A(wmVar, obj3, obj2, baVarI, mmVar.f1954b, mmVar.b);
            if (obj != null) {
                wmVar.u(obj, rect);
            }
        } else {
            rect = null;
        }
        og.a(viewGroup, new lm(wmVar, baVar, obj3, mmVar, arrayList2, view, fragment, fragment2, z, arrayList, obj, rect));
        return obj3;
    }

    public static Object m(wm wmVar, ViewGroup viewGroup, View view, ba<String, String> baVar, mm mmVar, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object obj, Object obj2) {
        Object obj3;
        View view2;
        Rect rect;
        Fragment fragment = mmVar.f1951a;
        Fragment fragment2 = mmVar.f1953b;
        if (fragment != null) {
            fragment.f1().setVisibility(0);
        }
        if (fragment == null || fragment2 == null) {
            return null;
        }
        boolean z = mmVar.f1952a;
        Object objU = baVar.isEmpty() ? null : u(wmVar, fragment, fragment2, z);
        ba<String, View> baVarI = i(wmVar, baVar, objU, mmVar);
        ba<String, View> baVarH = h(wmVar, baVar, objU, mmVar);
        if (baVar.isEmpty()) {
            if (baVarI != null) {
                baVarI.clear();
            }
            if (baVarH != null) {
                baVarH.clear();
            }
            obj3 = null;
        } else {
            a(arrayList, baVarI, baVar.keySet());
            a(arrayList2, baVarH, baVar.values());
            obj3 = objU;
        }
        if (obj == null && obj2 == null && obj3 == null) {
            return null;
        }
        f(fragment, fragment2, z, baVarI, true);
        if (obj3 != null) {
            arrayList2.add(view);
            wmVar.y(obj3, view, arrayList);
            A(wmVar, obj3, obj2, baVarI, mmVar.f1954b, mmVar.b);
            Rect rect2 = new Rect();
            View viewT = t(baVarH, mmVar, obj, z);
            if (viewT != null) {
                wmVar.u(obj, rect2);
            }
            rect = rect2;
            view2 = viewT;
        } else {
            view2 = null;
            rect = null;
        }
        og.a(viewGroup, new km(fragment, fragment2, z, baVarH, view2, wmVar, rect));
        return obj3;
    }

    public static void n(yl ylVar, int i, mm mmVar, View view, ba<String, String> baVar) {
        Fragment fragment;
        Fragment fragment2;
        wm wmVarJ;
        Object obj;
        ViewGroup viewGroup = ylVar.f3723a.c() ? (ViewGroup) ylVar.f3723a.b(i) : null;
        if (viewGroup == null || (wmVarJ = j((fragment2 = mmVar.f1953b), (fragment = mmVar.f1951a))) == null) {
            return;
        }
        boolean z = mmVar.f1952a;
        boolean z2 = mmVar.f1954b;
        Object objR = r(wmVarJ, fragment, z);
        Object objS = s(wmVarJ, fragment2, z2);
        ArrayList arrayList = new ArrayList();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objL = l(wmVarJ, viewGroup, view, baVar, mmVar, arrayList, arrayList2, objR, objS);
        if (objR == null && objL == null) {
            obj = objS;
            if (obj == null) {
                return;
            }
        } else {
            obj = objS;
        }
        ArrayList<View> arrayListK = k(wmVarJ, obj, fragment2, arrayList, view);
        Object obj2 = (arrayListK == null || arrayListK.isEmpty()) ? null : obj;
        wmVarJ.a(objR, view);
        Object objV = v(wmVarJ, objR, obj2, objL, fragment, mmVar.f1952a);
        if (objV != null) {
            ArrayList<View> arrayList3 = new ArrayList<>();
            wmVarJ.t(objV, objR, arrayList3, obj2, arrayListK, objL, arrayList2);
            z(wmVarJ, viewGroup, fragment, view, arrayList2, objR, arrayList3, obj2, arrayListK);
            wmVarJ.w(viewGroup, arrayList2, baVar);
            wmVarJ.c(viewGroup, objV);
            wmVarJ.s(viewGroup, arrayList2, baVar);
        }
    }

    public static void o(yl ylVar, int i, mm mmVar, View view, ba<String, String> baVar) {
        Fragment fragment;
        Fragment fragment2;
        wm wmVarJ;
        Object obj;
        ViewGroup viewGroup = ylVar.f3723a.c() ? (ViewGroup) ylVar.f3723a.b(i) : null;
        if (viewGroup == null || (wmVarJ = j((fragment2 = mmVar.f1953b), (fragment = mmVar.f1951a))) == null) {
            return;
        }
        boolean z = mmVar.f1952a;
        boolean z2 = mmVar.f1954b;
        ArrayList<View> arrayList = new ArrayList<>();
        ArrayList<View> arrayList2 = new ArrayList<>();
        Object objR = r(wmVarJ, fragment, z);
        Object objS = s(wmVarJ, fragment2, z2);
        Object objM = m(wmVarJ, viewGroup, view, baVar, mmVar, arrayList2, arrayList, objR, objS);
        if (objR == null && objM == null) {
            obj = objS;
            if (obj == null) {
                return;
            }
        } else {
            obj = objS;
        }
        ArrayList<View> arrayListK = k(wmVarJ, obj, fragment2, arrayList2, view);
        ArrayList<View> arrayListK2 = k(wmVarJ, objR, fragment, arrayList, view);
        B(arrayListK2, 4);
        Object objV = v(wmVarJ, objR, obj, objM, fragment, z);
        if (objV != null) {
            w(wmVarJ, obj, fragment2, arrayListK);
            ArrayList<String> arrayListO = wmVarJ.o(arrayList);
            wmVarJ.t(objV, objR, arrayListK2, obj, arrayListK, objM, arrayList);
            wmVarJ.c(viewGroup, objV);
            wmVarJ.x(viewGroup, arrayList2, arrayList, arrayListO, baVar);
            B(arrayListK2, 0);
            wmVarJ.z(objM, arrayList2, arrayList);
        }
    }

    public static mm p(mm mmVar, SparseArray<mm> sparseArray, int i) {
        if (mmVar != null) {
            return mmVar;
        }
        mm mmVar2 = new mm();
        sparseArray.put(i, mmVar2);
        return mmVar2;
    }

    public static String q(ba<String, String> baVar, String str) {
        int size = baVar.size();
        for (int i = 0; i < size; i++) {
            if (str.equals(baVar.m(i))) {
                return baVar.i(i);
            }
        }
        return null;
    }

    public static Object r(wm wmVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return wmVar.g(z ? fragment.C() : fragment.q());
    }

    public static Object s(wm wmVar, Fragment fragment, boolean z) {
        if (fragment == null) {
            return null;
        }
        return wmVar.g(z ? fragment.F() : fragment.s());
    }

    public static View t(ba<String, View> baVar, mm mmVar, Object obj, boolean z) {
        ArrayList<String> arrayList;
        sk skVar = mmVar.f6821a;
        if (obj == null || baVar == null || (arrayList = ((hm) skVar).f1190b) == null || arrayList.isEmpty()) {
            return null;
        }
        return baVar.get((z ? ((hm) skVar).f1190b : ((hm) skVar).f1192c).get(0));
    }

    public static Object u(wm wmVar, Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null || fragment2 == null) {
            return null;
        }
        return wmVar.A(wmVar.g(z ? fragment2.H() : fragment.G()));
    }

    public static Object v(wm wmVar, Object obj, Object obj2, Object obj3, Fragment fragment, boolean z) {
        return (obj == null || obj2 == null || fragment == null) ? true : z ? fragment.l() : fragment.k() ? wmVar.n(obj2, obj, obj3) : wmVar.m(obj2, obj, obj3);
    }

    public static void w(wm wmVar, Object obj, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment != null && obj != null && fragment.f4274b && fragment.h && fragment.r) {
            fragment.l1(true);
            wmVar.r(obj, fragment.M(), arrayList);
            og.a(fragment.f4264a, new im(arrayList));
        }
    }

    public static wm x() {
        try {
            return (wm) Class.forName("a.mr").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void y(ba<String, String> baVar, ba<String, View> baVar2) {
        for (int size = baVar.size() - 1; size >= 0; size--) {
            if (!baVar2.containsKey(baVar.m(size))) {
                baVar.k(size);
            }
        }
    }

    public static void z(wm wmVar, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object obj, ArrayList<View> arrayList2, Object obj2, ArrayList<View> arrayList3) {
        og.a(viewGroup, new jm(obj, wmVar, view, fragment, arrayList, arrayList2, arrayList3, obj2));
    }
}

package a;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
@SuppressLint({"RestrictedApi"})
public class mr extends wm {
    public static boolean B(as asVar) {
        return (wm.l(asVar.z()) && wm.l(asVar.A()) && wm.l(asVar.B())) ? false : true;
    }

    @Override // a.wm
    public Object A(Object obj) {
        if (obj == null) {
            return null;
        }
        is isVar = new is();
        isVar.e0((as) obj);
        return isVar;
    }

    @Override // a.wm
    public void a(Object obj, View view) {
        if (obj != null) {
            ((as) obj).b(view);
        }
    }

    @Override // a.wm
    public void b(Object obj, ArrayList<View> arrayList) {
        as asVar = (as) obj;
        if (asVar == null) {
            return;
        }
        int i = 0;
        if (asVar instanceof is) {
            is isVar = (is) asVar;
            int iH0 = isVar.h0();
            while (i < iH0) {
                b(isVar.g0(i), arrayList);
                i++;
            }
            return;
        }
        if (B(asVar) || !wm.l(asVar.C())) {
            return;
        }
        int size = arrayList.size();
        while (i < size) {
            asVar.b(arrayList.get(i));
            i++;
        }
    }

    @Override // a.wm
    public void c(ViewGroup viewGroup, Object obj) {
        es.a(viewGroup, (as) obj);
    }

    @Override // a.wm
    public boolean e(Object obj) {
        return obj instanceof as;
    }

    @Override // a.wm
    public Object g(Object obj) {
        if (obj != null) {
            return ((as) obj).clone();
        }
        return null;
    }

    @Override // a.wm
    public Object m(Object obj, Object obj2, Object obj3) {
        as asVar = (as) obj;
        as asVar2 = (as) obj2;
        as asVar3 = (as) obj3;
        if (asVar != null && asVar2 != null) {
            is isVar = new is();
            isVar.e0(asVar);
            isVar.e0(asVar2);
            isVar.m0(1);
            asVar = isVar;
        } else if (asVar == null) {
            asVar = asVar2 != null ? asVar2 : null;
        }
        if (asVar3 == null) {
            return asVar;
        }
        is isVar2 = new is();
        if (asVar != null) {
            isVar2.e0(asVar);
        }
        isVar2.e0(asVar3);
        return isVar2;
    }

    @Override // a.wm
    public Object n(Object obj, Object obj2, Object obj3) {
        is isVar = new is();
        if (obj != null) {
            isVar.e0((as) obj);
        }
        if (obj2 != null) {
            isVar.e0((as) obj2);
        }
        if (obj3 != null) {
            isVar.e0((as) obj3);
        }
        return isVar;
    }

    @Override // a.wm
    public void p(Object obj, View view) {
        if (obj != null) {
            ((as) obj).Q(view);
        }
    }

    @Override // a.wm
    public void q(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        as asVar = (as) obj;
        int i = 0;
        if (asVar instanceof is) {
            is isVar = (is) asVar;
            int iH0 = isVar.h0();
            while (i < iH0) {
                q(isVar.g0(i), arrayList, arrayList2);
                i++;
            }
            return;
        }
        if (B(asVar)) {
            return;
        }
        List<View> listC = asVar.C();
        if (listC.size() == arrayList.size() && listC.containsAll(arrayList)) {
            int size = arrayList2 == null ? 0 : arrayList2.size();
            while (i < size) {
                asVar.b(arrayList2.get(i));
                i++;
            }
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                asVar.Q(arrayList.get(size2));
            }
        }
    }

    @Override // a.wm
    public void r(Object obj, View view, ArrayList<View> arrayList) {
        ((as) obj).a(new jr(this, view, arrayList));
    }

    @Override // a.wm
    public void t(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        ((as) obj).a(new kr(this, obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // a.wm
    public void u(Object obj, Rect rect) {
        if (obj != null) {
            ((as) obj).V(new lr(this, rect));
        }
    }

    @Override // a.wm
    public void v(Object obj, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            ((as) obj).V(new ir(this, rect));
        }
    }

    @Override // a.wm
    public void y(Object obj, View view, ArrayList<View> arrayList) {
        is isVar = (is) obj;
        List<View> listC = isVar.C();
        listC.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            wm.d(listC, arrayList.get(i));
        }
        listC.add(view);
        arrayList.add(view);
        b(isVar, arrayList);
    }

    @Override // a.wm
    public void z(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        is isVar = (is) obj;
        if (isVar != null) {
            isVar.C().clear();
            isVar.C().addAll(arrayList2);
            q(isVar, arrayList, arrayList2);
        }
    }
}

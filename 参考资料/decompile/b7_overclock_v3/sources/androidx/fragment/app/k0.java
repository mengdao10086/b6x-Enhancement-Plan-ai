package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.core.view.u0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class k0 {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f6000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f6001b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f6002c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f6003d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f6004e;

        public a(int i10, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f6000a = i10;
            this.f6001b = arrayList;
            this.f6002c = arrayList2;
            this.f6003d = arrayList3;
            this.f6004e = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i10 = 0; i10 < this.f6000a; i10++) {
                u0.t2((View) this.f6001b.get(i10), (String) this.f6002c.get(i10));
                u0.t2((View) this.f6003d.get(i10), (String) this.f6004e.get(i10));
            }
        }
    }

    public static void d(List<View> list, View view) {
        int size = list.size();
        if (g(list, view, size)) {
            return;
        }
        if (u0.x0(view) != null) {
            list.add(view);
        }
        for (int i10 = size; i10 < list.size(); i10++) {
            View view2 = list.get(i10);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    if (!g(list, childAt, size) && u0.x0(childAt) != null) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    public static boolean g(List<View> list, View view, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (list.get(i11) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(List list) {
        return list == null || list.isEmpty();
    }

    public abstract void a(Object obj, View view);

    public abstract void b(Object obj, ArrayList<View> arrayList);

    public abstract void c(ViewGroup viewGroup, Object obj);

    public abstract boolean e(Object obj);

    public abstract Object f(Object obj);

    public void h(View view, Rect rect) {
        if (u0.O0(view)) {
            RectF rectF = new RectF();
            rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            Object parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            view.getRootView().getLocationOnScreen(new int[2]);
            rectF.offset(r1[0], r1[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract Object j(Object obj, Object obj2, Object obj3);

    public abstract Object k(Object obj, Object obj2, Object obj3);

    public ArrayList<String> l(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            View view = arrayList.get(i10);
            arrayList2.add(u0.x0(view));
            u0.t2(view, null);
        }
        return arrayList2;
    }

    public abstract void m(Object obj, View view);

    public abstract void n(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void o(Object obj, View view, ArrayList<View> arrayList);

    public abstract void p(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void q(Object obj, Rect rect);

    public abstract void r(Object obj, View view);

    public void s(@g.n0 Fragment fragment, @g.n0 Object obj, @g.n0 androidx.core.os.f fVar, @g.n0 Runnable runnable) {
        runnable.run();
    }

    public void t(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            View view2 = arrayList.get(i10);
            String strX0 = u0.x0(view2);
            arrayList4.add(strX0);
            if (strX0 != null) {
                u0.t2(view2, null);
                String str = map.get(strX0);
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    }
                    if (str.equals(arrayList3.get(i11))) {
                        u0.t2(arrayList2.get(i11), strX0);
                        break;
                    }
                    i11++;
                }
            }
        }
        androidx.core.view.n0.a(view, new a(size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public abstract void u(Object obj, View view, ArrayList<View> arrayList);

    public abstract void v(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract Object w(Object obj);
}

package androidx.fragment.app;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k0 f5980a = new j0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k0 f5981b = c();

    public static void a(Fragment fragment, Fragment fragment2, boolean z10, androidx.collection.a<String, View> aVar, boolean z11) {
        f0.k0 k0VarD2 = z10 ? fragment2.d2() : fragment.d2();
        if (k0VarD2 != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = aVar == null ? 0 : aVar.size();
            for (int i10 = 0; i10 < size; i10++) {
                arrayList2.add(aVar.k(i10));
                arrayList.add(aVar.o(i10));
            }
            if (z11) {
                k0VarD2.g(arrayList2, arrayList, null);
            } else {
                k0VarD2.f(arrayList2, arrayList, null);
            }
        }
    }

    public static String b(androidx.collection.a<String, String> aVar, String str) {
        int size = aVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (str.equals(aVar.o(i10))) {
                return aVar.k(i10);
            }
        }
        return null;
    }

    public static k0 c() {
        try {
            return (k0) androidx.transition.j.class.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static void d(@g.n0 androidx.collection.a<String, String> aVar, @g.n0 androidx.collection.a<String, View> aVar2) {
        for (int size = aVar.size() - 1; size >= 0; size--) {
            if (!aVar2.containsKey(aVar.o(size))) {
                aVar.m(size);
            }
        }
    }

    public static void e(ArrayList<View> arrayList, int i10) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i10);
        }
    }

    public static boolean f() {
        return (f5980a == null && f5981b == null) ? false : true;
    }
}

package wg;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.g;
import com.tbruyelle.rxpermissions2.RxPermissionsFragment;
import dj.o;
import g.i1;
import g.n0;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xi.e0;
import xi.f0;
import xi.z;

/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f54685b = "c";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f54686c = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @i1
    public f<RxPermissionsFragment> f54687a;

    public class a implements f<RxPermissionsFragment> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RxPermissionsFragment f54688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FragmentManager f54689b;

        public a(FragmentManager fragmentManager) {
            this.f54689b = fragmentManager;
        }

        @Override // wg.c.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public synchronized RxPermissionsFragment get() {
            if (this.f54688a == null) {
                this.f54688a = c.this.i(this.f54689b);
            }
            return this.f54688a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements f0<T, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f54691a;

        public class a implements o<List<wg.b>, e0<Boolean>> {
            public a() {
            }

            @Override // dj.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e0<Boolean> apply(List<wg.b> list) {
                if (list.isEmpty()) {
                    return z.e2();
                }
                Iterator<wg.b> it2 = list.iterator();
                while (it2.hasNext()) {
                    if (!it2.next().f54679b) {
                        return z.m3(Boolean.FALSE);
                    }
                }
                return z.m3(Boolean.TRUE);
            }
        }

        public b(String[] strArr) {
            this.f54691a = strArr;
        }

        @Override // xi.f0
        public e0<Boolean> c(z<T> zVar) {
            return c.this.p(zVar, this.f54691a).B(this.f54691a.length).l2(new a());
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: wg.c$c, reason: collision with other inner class name */
    public class C0637c<T> implements f0<T, wg.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f54694a;

        public C0637c(String[] strArr) {
            this.f54694a = strArr;
        }

        @Override // xi.f0
        public e0<wg.b> c(z<T> zVar) {
            return c.this.p(zVar, this.f54694a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class d<T> implements f0<T, wg.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f54696a;

        public class a implements o<List<wg.b>, e0<wg.b>> {
            public a() {
            }

            @Override // dj.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public e0<wg.b> apply(List<wg.b> list) {
                return list.isEmpty() ? z.e2() : z.m3(new wg.b(list));
            }
        }

        public d(String[] strArr) {
            this.f54696a = strArr;
        }

        @Override // xi.f0
        public e0<wg.b> c(z<T> zVar) {
            return c.this.p(zVar, this.f54696a).B(this.f54696a.length).l2(new a());
        }
    }

    public class e implements o<Object, z<wg.b>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f54699a;

        public e(String[] strArr) {
            this.f54699a = strArr;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public z<wg.b> apply(Object obj) {
            return c.this.t(this.f54699a);
        }
    }

    @FunctionalInterface
    public interface f<V> {
        V get();
    }

    public c(@n0 g gVar) {
        this.f54687a = h(gVar.n3());
    }

    public <T> f0<T, Boolean> d(String... strArr) {
        return new b(strArr);
    }

    public <T> f0<T, wg.b> e(String... strArr) {
        return new C0637c(strArr);
    }

    public <T> f0<T, wg.b> f(String... strArr) {
        return new d(strArr);
    }

    public final RxPermissionsFragment g(@n0 FragmentManager fragmentManager) {
        return (RxPermissionsFragment) fragmentManager.s0(f54685b);
    }

    @n0
    public final f<RxPermissionsFragment> h(@n0 FragmentManager fragmentManager) {
        return new a(fragmentManager);
    }

    public final RxPermissionsFragment i(@n0 FragmentManager fragmentManager) {
        RxPermissionsFragment rxPermissionsFragmentG = g(fragmentManager);
        if (!(rxPermissionsFragmentG == null)) {
            return rxPermissionsFragmentG;
        }
        RxPermissionsFragment rxPermissionsFragment = new RxPermissionsFragment();
        fragmentManager.u().k(rxPermissionsFragment, f54685b).s();
        return rxPermissionsFragment;
    }

    public boolean j(String str) {
        return !k() || this.f54687a.get().G5(str);
    }

    public boolean k() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public boolean l(String str) {
        return k() && this.f54687a.get().H5(str);
    }

    public void m(String[] strArr, int[] iArr) {
        this.f54687a.get().J5(strArr, iArr, new boolean[strArr.length]);
    }

    public final z<?> n(z<?> zVar, z<?> zVar2) {
        return zVar == null ? z.m3(f54686c) : z.H3(zVar, zVar2);
    }

    public final z<?> o(String... strArr) {
        for (String str : strArr) {
            if (!this.f54687a.get().E5(str)) {
                return z.e2();
            }
        }
        return z.m3(f54686c);
    }

    public final z<wg.b> p(z<?> zVar, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
        }
        return n(zVar, o(strArr)).l2(new e(strArr));
    }

    public z<Boolean> q(String... strArr) {
        return z.m3(f54686c).s0(d(strArr));
    }

    public z<wg.b> r(String... strArr) {
        return z.m3(f54686c).s0(e(strArr));
    }

    public z<wg.b> s(String... strArr) {
        return z.m3(f54686c).s0(f(strArr));
    }

    @TargetApi(23)
    public final z<wg.b> t(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            this.f54687a.get().I5("Requesting permission " + str);
            if (j(str)) {
                arrayList.add(z.m3(new wg.b(str, true, false)));
            } else if (l(str)) {
                arrayList.add(z.m3(new wg.b(str, false, false)));
            } else {
                PublishSubject<wg.b> publishSubjectF5 = this.f54687a.get().F5(str);
                if (publishSubjectF5 == null) {
                    arrayList2.add(str);
                    publishSubjectF5 = PublishSubject.o8();
                    this.f54687a.get().M5(str, publishSubjectF5);
                }
                arrayList.add(publishSubjectF5);
            }
        }
        if (!arrayList2.isEmpty()) {
            u((String[]) arrayList2.toArray(new String[arrayList2.size()]));
        }
        return z.u0(z.P2(arrayList));
    }

    @TargetApi(23)
    public void u(String[] strArr) {
        this.f54687a.get().I5("requestPermissionsFromFragment " + TextUtils.join(", ", strArr));
        this.f54687a.get().K5(strArr);
    }

    public void v(boolean z10) {
        this.f54687a.get().L5(z10);
    }

    public z<Boolean> w(Activity activity, String... strArr) {
        return !k() ? z.m3(Boolean.FALSE) : z.m3(Boolean.valueOf(x(activity, strArr)));
    }

    @TargetApi(23)
    public final boolean x(Activity activity, String... strArr) {
        for (String str : strArr) {
            if (!j(str) && !activity.shouldShowRequestPermissionRationale(str)) {
                return false;
            }
        }
        return true;
    }

    public c(@n0 Fragment fragment) {
        this.f54687a = h(fragment.U1());
    }
}

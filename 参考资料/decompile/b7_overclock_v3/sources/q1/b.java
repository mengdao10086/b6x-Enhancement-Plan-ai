package q1;

import android.os.Bundle;
import android.os.Looper;
import androidx.collection.m;
import androidx.core.util.f;
import androidx.lifecycle.a1;
import androidx.lifecycle.c1;
import androidx.lifecycle.j0;
import androidx.lifecycle.k0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y;
import androidx.lifecycle.z0;
import com.bumptech.glide.load.engine.GlideException;
import g.n0;
import g.p0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import q1.a;
import r1.c;

/* JADX INFO: loaded from: classes2.dex */
public class b extends q1.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f47089c = "LoaderManager";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f47090d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final y f47091a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final c f47092b;

    public static class a<D> extends j0<D> implements c.InterfaceC0550c<D> {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final int f47093m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @p0
        public final Bundle f47094n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        @n0
        public final r1.c<D> f47095o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public y f47096p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public C0541b<D> f47097q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public r1.c<D> f47098r;

        public a(int i10, @p0 Bundle bundle, @n0 r1.c<D> cVar, @p0 r1.c<D> cVar2) {
            this.f47093m = i10;
            this.f47094n = bundle;
            this.f47095o = cVar;
            this.f47098r = cVar2;
            cVar.u(i10, this);
        }

        @Override // r1.c.InterfaceC0550c
        public void a(@n0 r1.c<D> cVar, @p0 D d10) {
            if (b.f47090d) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onLoadComplete: ");
                sb2.append(this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                r(d10);
            } else {
                boolean z10 = b.f47090d;
                o(d10);
            }
        }

        @Override // androidx.lifecycle.LiveData
        public void m() {
            if (b.f47090d) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Starting: ");
                sb2.append(this);
            }
            this.f47095o.y();
        }

        @Override // androidx.lifecycle.LiveData
        public void n() {
            if (b.f47090d) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Stopping: ");
                sb2.append(this);
            }
            this.f47095o.z();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void p(@n0 k0<? super D> k0Var) {
            super.p(k0Var);
            this.f47096p = null;
            this.f47097q = null;
        }

        @Override // androidx.lifecycle.j0, androidx.lifecycle.LiveData
        public void r(D d10) {
            super.r(d10);
            r1.c<D> cVar = this.f47098r;
            if (cVar != null) {
                cVar.w();
                this.f47098r = null;
            }
        }

        @g.k0
        public r1.c<D> s(boolean z10) {
            if (b.f47090d) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Destroying: ");
                sb2.append(this);
            }
            this.f47095o.b();
            this.f47095o.a();
            C0541b<D> c0541b = this.f47097q;
            if (c0541b != null) {
                p(c0541b);
                if (z10) {
                    c0541b.d();
                }
            }
            this.f47095o.B(this);
            if ((c0541b == null || c0541b.c()) && !z10) {
                return this.f47095o;
            }
            this.f47095o.w();
            return this.f47098r;
        }

        public void t(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f47093m);
            printWriter.print(" mArgs=");
            printWriter.println(this.f47094n);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f47095o);
            this.f47095o.g(str + GlideException.a.f12263d, fileDescriptor, printWriter, strArr);
            if (this.f47097q != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f47097q);
                this.f47097q.a(str + GlideException.a.f12263d, printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(u().d(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(h());
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #");
            sb2.append(this.f47093m);
            sb2.append(" : ");
            f.a(this.f47095o, sb2);
            sb2.append("}}");
            return sb2.toString();
        }

        @n0
        public r1.c<D> u() {
            return this.f47095o;
        }

        public boolean v() {
            C0541b<D> c0541b;
            return (!h() || (c0541b = this.f47097q) == null || c0541b.c()) ? false : true;
        }

        public void w() {
            y yVar = this.f47096p;
            C0541b<D> c0541b = this.f47097q;
            if (yVar == null || c0541b == null) {
                return;
            }
            super.p(c0541b);
            k(yVar, c0541b);
        }

        @g.k0
        @n0
        public r1.c<D> x(@n0 y yVar, @n0 a.InterfaceC0540a<D> interfaceC0540a) {
            C0541b<D> c0541b = new C0541b<>(this.f47095o, interfaceC0540a);
            k(yVar, c0541b);
            C0541b<D> c0541b2 = this.f47097q;
            if (c0541b2 != null) {
                p(c0541b2);
            }
            this.f47096p = yVar;
            this.f47097q = c0541b;
            return this.f47095o;
        }
    }

    /* JADX INFO: renamed from: q1.b$b, reason: collision with other inner class name */
    public static class C0541b<D> implements k0<D> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final r1.c<D> f47099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public final a.InterfaceC0540a<D> f47100b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f47101c = false;

        public C0541b(@n0 r1.c<D> cVar, @n0 a.InterfaceC0540a<D> interfaceC0540a) {
            this.f47099a = cVar;
            this.f47100b = interfaceC0540a;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f47101c);
        }

        @Override // androidx.lifecycle.k0
        public void b(@p0 D d10) {
            if (b.f47090d) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  onLoadFinished in ");
                sb2.append(this.f47099a);
                sb2.append(": ");
                sb2.append(this.f47099a.d(d10));
            }
            this.f47100b.c(this.f47099a, d10);
            this.f47101c = true;
        }

        public boolean c() {
            return this.f47101c;
        }

        @g.k0
        public void d() {
            if (this.f47101c) {
                if (b.f47090d) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("  Resetting: ");
                    sb2.append(this.f47099a);
                }
                this.f47100b.b(this.f47099a);
            }
        }

        public String toString() {
            return this.f47100b.toString();
        }
    }

    public static class c extends x0 {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final z0.b f47102f = new a();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public m<a> f47103d = new m<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f47104e = false;

        public static class a implements z0.b {
            @Override // androidx.lifecycle.z0.b
            @n0
            public <T extends x0> T a(@n0 Class<T> cls) {
                return new c();
            }

            @Override // androidx.lifecycle.z0.b
            public /* synthetic */ x0 b(Class cls, p1.a aVar) {
                return a1.b(this, cls, aVar);
            }
        }

        @n0
        public static c i(c1 c1Var) {
            return (c) new z0(c1Var, f47102f).a(c.class);
        }

        @Override // androidx.lifecycle.x0
        public void e() {
            super.e();
            int iX = this.f47103d.x();
            for (int i10 = 0; i10 < iX; i10++) {
                this.f47103d.y(i10).s(true);
            }
            this.f47103d.b();
        }

        public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f47103d.x() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + wn.a.f54751a;
                for (int i10 = 0; i10 < this.f47103d.x(); i10++) {
                    a aVarY = this.f47103d.y(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f47103d.m(i10));
                    printWriter.print(": ");
                    printWriter.println(aVarY.toString());
                    aVarY.t(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void h() {
            this.f47104e = false;
        }

        public <D> a<D> j(int i10) {
            return this.f47103d.h(i10);
        }

        public boolean k() {
            int iX = this.f47103d.x();
            for (int i10 = 0; i10 < iX; i10++) {
                if (this.f47103d.y(i10).v()) {
                    return true;
                }
            }
            return false;
        }

        public boolean l() {
            return this.f47104e;
        }

        public void m() {
            int iX = this.f47103d.x();
            for (int i10 = 0; i10 < iX; i10++) {
                this.f47103d.y(i10).w();
            }
        }

        public void n(int i10, @n0 a aVar) {
            this.f47103d.n(i10, aVar);
        }

        public void o(int i10) {
            this.f47103d.q(i10);
        }

        public void q() {
            this.f47104e = true;
        }
    }

    public b(@n0 y yVar, @n0 c1 c1Var) {
        this.f47091a = yVar;
        this.f47092b = c.i(c1Var);
    }

    @Override // q1.a
    @g.k0
    public void a(int i10) {
        if (this.f47092b.l()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
        if (f47090d) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("destroyLoader in ");
            sb2.append(this);
            sb2.append(" of ");
            sb2.append(i10);
        }
        a aVarJ = this.f47092b.j(i10);
        if (aVarJ != null) {
            aVarJ.s(true);
            this.f47092b.o(i10);
        }
    }

    @Override // q1.a
    @Deprecated
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f47092b.g(str, fileDescriptor, printWriter, strArr);
    }

    @Override // q1.a
    @p0
    public <D> r1.c<D> e(int i10) {
        if (this.f47092b.l()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a<D> aVarJ = this.f47092b.j(i10);
        if (aVarJ != null) {
            return aVarJ.u();
        }
        return null;
    }

    @Override // q1.a
    public boolean f() {
        return this.f47092b.k();
    }

    @Override // q1.a
    @g.k0
    @n0
    public <D> r1.c<D> g(int i10, @p0 Bundle bundle, @n0 a.InterfaceC0540a<D> interfaceC0540a) {
        if (this.f47092b.l()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a<D> aVarJ = this.f47092b.j(i10);
        if (f47090d) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initLoader in ");
            sb2.append(this);
            sb2.append(": args=");
            sb2.append(bundle);
        }
        if (aVarJ == null) {
            return j(i10, bundle, interfaceC0540a, null);
        }
        if (f47090d) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("  Re-using existing loader ");
            sb3.append(aVarJ);
        }
        return aVarJ.x(this.f47091a, interfaceC0540a);
    }

    @Override // q1.a
    public void h() {
        this.f47092b.m();
    }

    @Override // q1.a
    @g.k0
    @n0
    public <D> r1.c<D> i(int i10, @p0 Bundle bundle, @n0 a.InterfaceC0540a<D> interfaceC0540a) {
        if (this.f47092b.l()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
        if (f47090d) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("restartLoader in ");
            sb2.append(this);
            sb2.append(": args=");
            sb2.append(bundle);
        }
        a<D> aVarJ = this.f47092b.j(i10);
        return j(i10, bundle, interfaceC0540a, aVarJ != null ? aVarJ.s(false) : null);
    }

    @g.k0
    @n0
    public final <D> r1.c<D> j(int i10, @p0 Bundle bundle, @n0 a.InterfaceC0540a<D> interfaceC0540a, @p0 r1.c<D> cVar) {
        try {
            this.f47092b.q();
            r1.c<D> cVarA = interfaceC0540a.a(i10, bundle);
            if (cVarA == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (cVarA.getClass().isMemberClass() && !Modifier.isStatic(cVarA.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + cVarA);
            }
            a aVar = new a(i10, bundle, cVarA, cVar);
            if (f47090d) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  Created new loader ");
                sb2.append(aVar);
            }
            this.f47092b.n(i10, aVar);
            this.f47092b.h();
            return aVar.x(this.f47091a, interfaceC0540a);
        } catch (Throwable th2) {
            this.f47092b.h();
            throw th2;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        f.a(this.f47091a, sb2);
        sb2.append("}}");
        return sb2.toString();
    }
}

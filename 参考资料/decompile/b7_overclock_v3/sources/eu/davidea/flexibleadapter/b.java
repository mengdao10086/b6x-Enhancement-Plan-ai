package eu.davidea.flexibleadapter;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import di.a;
import ei.h;
import g.n0;
import g.p0;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class b<T extends ei.h> extends AnimatorAdapter implements a.InterfaceC0296a {
    public static final String M0 = "b";
    public static final String N0;
    public static final String O0;
    public static final String P0;
    public static final String Q0;
    public static final String R0;
    public static final String S0;
    public static final long T0 = 150;
    public static int U0;
    public static final /* synthetic */ boolean V0 = false;
    public List<T> A;
    public boolean A0;
    public List<T> B;
    public boolean B0;
    public List<T> C;
    public T C0;
    public Set<T> D;
    public z D0;
    public List<v> E;
    public a0 E0;
    public b<T>.t F;
    public e0 F0;
    public long G;
    public y G0;
    public long H;
    public b0 H0;
    public boolean I;
    public c0 I0;
    public i.c J;
    public s J0;
    public r K;
    public x K0;
    public final int L;
    public d0 L0;
    public final int M;
    public final int N;
    public Handler O;
    public List<b<T>.f0> P;
    public List<Integer> Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public boolean U;
    public boolean V;
    public List<T> W;
    public List<T> X;
    public boolean Y;
    public boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f27245a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public di.b f27246b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public ViewGroup f27247c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public LayoutInflater f27248d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    @SuppressLint({"UseSparseArrays"})
    public HashMap<Integer, T> f27249e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public boolean f27250f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public Serializable f27251g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public Serializable f27252h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public Set<ei.f> f27253i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public boolean f27254j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public boolean f27255k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f27256l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f27257m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f27258n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f27259o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f27260p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f27261q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public boolean f27262r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f27263s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public boolean f27264t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public di.a f27265u0;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public androidx.recyclerview.widget.m f27266v0;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public int f27267w0;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public int f27268x0;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f27269y0;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public boolean f27270z0;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f27271a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ei.h f27272b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f27273c;

        public a(int i10, ei.h hVar, boolean z10) {
            this.f27271a = i10;
            this.f27272b = hVar;
            this.f27273c = z10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.J0(this.f27271a, this.f27272b) && this.f27273c) {
                b.this.k1(this.f27271a, -1);
            }
        }
    }

    public interface a0 {
        void S(int i10);
    }

    /* JADX INFO: renamed from: eu.davidea.flexibleadapter.b$b, reason: collision with other inner class name */
    public class RunnableC0314b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ei.h f27275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f27276b;

        public RunnableC0314b(ei.h hVar, boolean z10) {
            this.f27275a = hVar;
            this.f27276b = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.w3(this.f27275a, this.f27276b);
        }
    }

    public interface b0 extends w {
        void c(int i10, int i11);

        boolean d(int i10, int i11);
    }

    public class c implements Comparator<Integer> {
        public c() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }
    }

    public interface c0 extends w {
        void a(int i10, int i11);
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f27279a;

        public d(int i10) {
            this.f27279a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.x3(this.f27279a);
        }
    }

    public interface d0 {
        void a(int i10, int i11);
    }

    public class e implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f27281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f27282b;

        public e(int i10, int i11) {
            this.f27281a = i10;
            this.f27282b = i11;
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            b bVar = b.this;
            if (bVar.f27328f == null) {
                return false;
            }
            int iA = bVar.s().a();
            int iF = b.this.s().f();
            int i10 = this.f27281a;
            int i11 = this.f27282b;
            if ((i10 + i11) - iF > 0) {
                int iMin = Math.min(i10 - iA, Math.max(0, (i10 + i11) - iF));
                int iE = b.this.s().e();
                if (iE > 1) {
                    iMin = (iMin % iE) + iE;
                }
                b.this.x3(iA + iMin);
            } else if (i10 < iA) {
                b.this.x3(i10);
            }
            return true;
        }
    }

    public interface e0 {
        void m0(int i10);
    }

    public class f implements Comparator<Integer> {
        public f() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Integer num, Integer num2) {
            return num2.intValue() - num.intValue();
        }
    }

    public class f0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f27285a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f27286b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public T f27287c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public T f27288d;

        public f0(b bVar, T t10, T t11) {
            this(t10, t11, -1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int a(boolean z10) {
            if (this.f27285a < 0) {
                this.f27285a = b.this.d2(this.f27287c);
            }
            ei.h hVarG2 = b.this.g2(this.f27285a);
            if (z10 && b.this.W2(hVarG2)) {
                b bVar = b.this;
                bVar.z3(this.f27285a, bVar.O1((ei.f) hVarG2), 0);
            } else if (!b.this.Y2(hVarG2) || z10) {
                this.f27285a++;
            } else {
                this.f27285a += b.this.V1((ei.f) hVarG2, true).size() + 1;
            }
            return this.f27285a;
        }

        public String toString() {
            return "RestoreInfo[item=" + this.f27288d + ", refItem=" + this.f27287c + "]";
        }

        public f0(T t10, T t11, int i10) {
            this.f27285a = -1;
            this.f27287c = t10;
            this.f27288d = t11;
            this.f27286b = i10;
        }
    }

    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = b.this.f27328f;
            if (recyclerView != null) {
                recyclerView.K0();
            }
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ei.h f27291a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f27292b;

        public h(ei.h hVar, boolean z10) {
            this.f27291a = hVar;
            this.f27292b = z10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.S0(this.f27291a) && this.f27292b) {
                b bVar = b.this;
                bVar.F4(bVar.d2(this.f27291a));
            }
        }
    }

    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ei.h f27294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f27295b;

        public i(ei.h hVar, boolean z10) {
            this.f27294a = hVar;
            this.f27295b = z10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.Q0(this.f27294a) && this.f27295b) {
                b bVar = b.this;
                bVar.F4(bVar.d2(this.f27294a));
            }
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ei.h f27297a;

        public j(ei.h hVar) {
            this.f27297a = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            b.this.P3(this.f27297a);
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ei.h f27299a;

        public k(ei.h hVar) {
            this.f27299a = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            b.this.N3(this.f27299a);
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f27301a;

        public l(boolean z10) {
            this.f27301a = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f27301a) {
                if (b.this.j1()) {
                    b.this.f27246b0.n();
                    b.this.f27246b0 = null;
                    b.this.f27323a.d("Sticky headers disabled", new Object[0]);
                    return;
                }
                return;
            }
            if (b.this.f27246b0 == null) {
                b bVar = b.this;
                bVar.f27246b0 = new di.b(bVar, bVar.L0, bVar.f27247c0);
                b.this.f27246b0.i(b.this.f27328f);
                b.this.f27323a.d("Sticky headers enabled", new Object[0]);
            }
        }
    }

    public class m implements Runnable {
        public m() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (b.this.Y) {
                b.this.f27323a.f("Double call detected! Headers already shown OR the method showAllHeaders() was already called!", new Object[0]);
                return;
            }
            b.this.B4(false);
            b bVar = b.this;
            if (bVar.f27328f == null || bVar.s().a() != 0) {
                return;
            }
            b bVar2 = b.this;
            if (bVar2.b3(bVar2.g2(0))) {
                b bVar3 = b.this;
                if (bVar3.b3(bVar3.g2(1))) {
                    return;
                }
                b.this.f27328f.D1(0);
            }
        }
    }

    public class n implements Runnable {
        public n() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            b.this.S = true;
            for (int itemCount = (b.this.getItemCount() - b.this.X.size()) - 1; itemCount >= Math.max(0, b.this.W.size() - 1); itemCount--) {
                ei.h hVarG2 = b.this.g2(itemCount);
                if (b.this.b3(hVarG2)) {
                    b.this.J2(itemCount, (ei.i) hVarG2);
                }
            }
            b.this.Y = false;
            if (b.this.j1()) {
                b.this.f27246b0.k();
            }
            b.this.S = false;
        }
    }

    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.q3(0);
        }
    }

    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.E4();
            b bVar = b.this;
            if (bVar.J0 != null) {
                bVar.f27323a.a("onLoadMore     invoked!", new Object[0]);
                b bVar2 = b.this;
                bVar2.J0.y0(bVar2.l2(), b.this.S1());
            }
        }
    }

    public class q extends RecyclerView.i {

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b.this.j1()) {
                    b.this.f27246b0.C(true);
                }
            }
        }

        public q() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            h(b.this.x2());
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void b(int i10, int i11) {
            h(i10);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i10, int i11) {
            g(i10, i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void f(int i10, int i11) {
            h(i10);
            g(i10, -i11);
        }

        public final void g(int i10, int i11) {
            if (b.this.V) {
                b.this.b1(i10, i11);
            }
            b.this.V = true;
        }

        public final void h(int i10) {
            int iX2 = b.this.x2();
            if (iX2 < 0 || iX2 != i10) {
                return;
            }
            b.this.f27323a.a("updateStickyHeader position=%s", Integer.valueOf(iX2));
            b.this.f27328f.postDelayed(new a(), 100L);
        }

        public /* synthetic */ q(b bVar, h hVar) {
            this();
        }
    }

    public static class r<T extends ei.h> extends i.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<T> f27309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<T> f27310b;

        public final List<T> a() {
            return this.f27310b;
        }

        @Override // androidx.recyclerview.widget.i.b
        public boolean areContentsTheSame(int i10, int i11) {
            return !this.f27309a.get(i10).m(this.f27310b.get(i11));
        }

        @Override // androidx.recyclerview.widget.i.b
        public boolean areItemsTheSame(int i10, int i11) {
            return this.f27309a.get(i10).equals(this.f27310b.get(i11));
        }

        public final void b(List<T> list, List<T> list2) {
            this.f27309a = list;
            this.f27310b = list2;
        }

        @Override // androidx.recyclerview.widget.i.b
        @p0
        public Object getChangePayload(int i10, int i11) {
            return Payload.CHANGE;
        }

        @Override // androidx.recyclerview.widget.i.b
        public final int getNewListSize() {
            return this.f27310b.size();
        }

        @Override // androidx.recyclerview.widget.i.b
        public final int getOldListSize() {
            return this.f27309a.size();
        }
    }

    public interface s {
        void J(int i10);

        void y0(int i10, int i11);
    }

    @SuppressLint({"StaticFieldLeak"})
    public class t extends AsyncTask<Void, Void, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<T> f27311a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f27312b;

        public t(int i10, @p0 List<T> list) {
            this.f27312b = i10;
            this.f27311a = list == null ? new ArrayList() : new ArrayList(list);
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            b.this.G = System.currentTimeMillis();
            int i10 = this.f27312b;
            if (i10 == 1) {
                b.this.f27323a.a("doInBackground - started UPDATE", new Object[0]);
                b.this.y3(this.f27311a);
                b.this.c1(this.f27311a, Payload.CHANGE);
                b.this.f27323a.a("doInBackground - ended UPDATE", new Object[0]);
                return null;
            }
            if (i10 != 2) {
                return null;
            }
            b.this.f27323a.a("doInBackground - started FILTER", new Object[0]);
            b.this.K1(this.f27311a);
            b.this.f27323a.a("doInBackground - ended FILTER", new Object[0]);
            return null;
        }

        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r22) {
            if (b.this.J != null || b.this.E != null) {
                int i10 = this.f27312b;
                if (i10 == 1) {
                    b.this.x1(Payload.CHANGE);
                    b.this.u3();
                } else if (i10 == 2) {
                    b.this.x1(Payload.FILTER);
                    b.this.t3();
                }
            }
            b.this.F = null;
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            b.this.f27323a.d("FilterAsyncTask cancelled!", new Object[0]);
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            if (b.this.f27270z0) {
                b.this.f27323a.f("Cannot filter while endlessLoading", new Object[0]);
                cancel(true);
            }
            if (b.this.g3()) {
                b.this.f27323a.a("Removing all deleted items before filtering/updating", new Object[0]);
                this.f27311a.removeAll(b.this.R1());
                x xVar = b.this.K0;
                if (xVar != null) {
                    xVar.a(3);
                }
            }
        }
    }

    public class u implements Handler.Callback {
        public u() {
        }

        @Override // android.os.Handler.Callback
        @g.i
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1 && i10 != 2) {
                if (i10 != 8) {
                    return false;
                }
                b.this.L2();
                return true;
            }
            if (b.this.F != null) {
                b.this.F.cancel(true);
            }
            b.this.F = new t(message.what, (List) message.obj);
            b.this.F.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return true;
        }
    }

    public interface w {
        void b(RecyclerView.e0 e0Var, int i10);
    }

    public interface x {
        void a(int i10);
    }

    public interface y {
        void a(int i10);
    }

    public interface z {
        boolean M(View view, int i10);
    }

    static {
        String simpleName = b.class.getSimpleName();
        N0 = simpleName + "_parentSelected";
        O0 = simpleName + "_childSelected";
        P0 = simpleName + "_headersShown";
        Q0 = simpleName + "_stickyHeaders";
        R0 = simpleName + "_selectedLevel";
        S0 = simpleName + "_filter";
        U0 = 1000;
    }

    public b(@p0 List<T> list) {
        this(list, null);
    }

    @Override // eu.davidea.flexibleadapter.c
    public boolean A(int i10) {
        ei.h hVarG2 = g2(i10);
        return hVarG2 != null && hVarG2.k();
    }

    public int A1(T t10, boolean z10) {
        return y1(d2(t10), false, z10, false);
    }

    @n0
    public List<Integer> A2() {
        return this.Q;
    }

    public final void A3() {
        if (this.X.size() > 0) {
            this.f27323a.a("Remove all scrollable footers", new Object[0]);
            this.A.removeAll(this.X);
            notifyItemRangeRemoved(getItemCount() - this.X.size(), this.X.size());
            this.X.clear();
        }
    }

    public final void A4(boolean z10) {
        if (z10) {
            this.f27323a.d("showAllHeaders at startup", new Object[0]);
            B4(true);
        } else {
            this.f27323a.d("showAllHeaders with insert notification (in Post!)", new Object[0]);
            this.O.post(new m());
        }
    }

    public int B1() {
        return C1(this.f27258n0);
    }

    public final T B2(int i10) {
        return this.f27249e0.get(Integer.valueOf(i10));
    }

    public final void B3() {
        if (this.W.size() > 0) {
            this.f27323a.a("Remove all scrollable headers", new Object[0]);
            this.A.removeAll(this.W);
            notifyItemRangeRemoved(0, this.W.size());
            this.W.clear();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r4v0, types: [ei.h, ei.i, java.lang.Object] */
    public final void B4(boolean z10) {
        int i10 = 0;
        ?? r12 = 0;
        while (i10 < getItemCount() - this.X.size()) {
            ei.h hVarG2 = g2(i10);
            ?? F2 = f2(hVarG2);
            ?? r13 = r12;
            if (F2 != 0) {
                boolean zEquals = F2.equals(r12);
                r13 = r12;
                if (!zEquals) {
                    r13 = r12;
                    if (!W2(F2)) {
                        F2.f(true);
                        r13 = F2;
                    }
                }
            }
            if (C4(i10, hVarG2, z10)) {
                i10++;
            }
            i10++;
            r12 = r13;
        }
        this.Y = true;
    }

    public int C1(int i10) {
        int iMax = Math.max(0, this.W.size() - 1);
        int i11 = 0;
        while (iMax < getItemCount() - this.X.size()) {
            ei.h hVarG2 = g2(iMax);
            if (W2(hVarG2)) {
                ei.f fVar = (ei.f) hVarG2;
                if (fVar.l() <= i10 && y1(iMax, true, false, true) > 0) {
                    iMax += fVar.getSubItems().size();
                    i11++;
                }
            }
            iMax++;
        }
        return i11;
    }

    public boolean C2() {
        Serializable serializable = this.f27251g0;
        return serializable instanceof String ? !((String) c2(String.class)).isEmpty() : serializable != null;
    }

    public void C3() {
        D3(null);
    }

    public final boolean C4(int i10, T t10, boolean z10) {
        ei.i iVarF2 = f2(t10);
        if (iVarF2 == null || n2(t10) != null || !iVarF2.d()) {
            return false;
        }
        this.f27323a.e("Showing header position=%s header=%s", Integer.valueOf(i10), iVarF2);
        iVarF2.f(false);
        v3(i10, Collections.singletonList(iVarF2), !z10);
        return true;
    }

    @Override // eu.davidea.flexibleadapter.c
    public void D(Bundle bundle) {
        if (bundle != null) {
            boolean z10 = bundle.getBoolean(P0);
            if (!z10) {
                I2();
            } else if (!this.Y) {
                B4(true);
            }
            this.Y = z10;
            if (bundle.getBoolean(Q0) && !j1()) {
                u4(true);
            }
            super.D(bundle);
            if (this.W.size() > 0) {
                b1(0, this.W.size());
            }
            this.f27264t0 = bundle.getBoolean(N0);
            this.f27263s0 = bundle.getBoolean(O0);
            this.f27259o0 = bundle.getInt(R0);
            this.f27251g0 = bundle.getSerializable(S0);
        }
    }

    public b<T> D1() {
        e0(true);
        this.S = true;
        int iY1 = 0;
        while (iY1 < getItemCount()) {
            ei.h hVarG2 = g2(iY1);
            if (!this.Y && b3(hVarG2) && !hVarG2.d()) {
                this.Y = true;
            }
            iY1 = Y2(hVarG2) ? iY1 + y1(iY1, false, true, false) : iY1 + 1;
        }
        this.S = false;
        e0(false);
        return this;
    }

    public boolean D2(T t10) {
        return f2(t10) != null;
    }

    public void D3(@p0 Object obj) {
        I3(v(), obj);
    }

    public final void D4(List<T> list) {
        if (!this.Y || this.Z) {
            return;
        }
        this.Z = true;
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (T t10 : list) {
            ei.i iVarF2 = f2(t10);
            if (iVarF2 != null) {
                if (C4(d2(t10), t10, false)) {
                    hashSet.add(iVarF2);
                } else {
                    hashSet2.add(iVarF2);
                }
            }
        }
        hashSet2.removeAll(hashSet);
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            notifyItemChanged(d2((ei.i) it2.next()), Payload.CHANGE);
        }
        this.Z = false;
    }

    @Override // eu.davidea.flexibleadapter.c
    public void E(Bundle bundle) {
        if (bundle != null) {
            if (this.W.size() > 0) {
                b1(0, -this.W.size());
            }
            super.E(bundle);
            bundle.putBoolean(O0, this.f27263s0);
            bundle.putBoolean(N0, this.f27264t0);
            bundle.putInt(R0, this.f27259o0);
            bundle.putSerializable(S0, this.f27251g0);
            bundle.putBoolean(P0, this.Y);
            bundle.putBoolean(Q0, j1());
        }
    }

    public final boolean E1(List<T> list, ei.f fVar) {
        int iIndexOf = list.indexOf(fVar);
        if (iIndexOf < 0) {
            return false;
        }
        int i10 = iIndexOf + 1;
        return i10 < list.size() ? list.addAll(i10, fVar.getSubItems()) : list.addAll(fVar.getSubItems());
    }

    public boolean E2(Serializable serializable) {
        if (serializable instanceof String) {
            if (this.f27252h0 instanceof String) {
                return !((String) r0).equalsIgnoreCase((String) serializable);
            }
        }
        Serializable serializable2 = this.f27252h0;
        return serializable2 == null || !serializable2.equals(serializable);
    }

    public void E3(@g.f0(from = 0) int i10) {
        F3(i10, Payload.CHANGE);
    }

    public final void E4() {
        this.O.removeMessages(8);
        this.f27323a.e("onLoadMore     show progressItem", new Object[0]);
        if (this.B0) {
            S0(this.C0);
        } else {
            Q0(this.C0);
        }
    }

    public final boolean F1(T t10, List<T> list) {
        boolean z10 = false;
        if (W2(t10)) {
            ei.f fVar = (ei.f) t10;
            if (fVar.isExpanded()) {
                if (this.f27253i0 == null) {
                    this.f27253i0 = new HashSet();
                }
                this.f27253i0.add(fVar);
            }
            for (T t11 : O1(fVar)) {
                if (!(t11 instanceof ei.f) || !M1(t11, list)) {
                    t11.f(!L1(t11, c2(Serializable.class)));
                    if (!t11.d()) {
                        list.add(t11);
                    }
                }
                z10 = true;
            }
            fVar.setExpanded(z10);
        }
        return z10;
    }

    public boolean F2(T t10, ei.i iVar) {
        ei.i iVarF2 = f2(t10);
        return (iVarF2 == null || iVar == null || !iVarF2.equals(iVar)) ? false : true;
    }

    public void F3(@g.f0(from = 0) int i10, @p0 Object obj) {
        collapse(i10);
        this.f27323a.e("removeItem delegates removal to removeRange", new Object[0]);
        M3(i10, 1, obj);
    }

    public void F4(int i10) {
        RecyclerView recyclerView = this.f27328f;
        if (recyclerView != null) {
            recyclerView.postDelayed(new d(i10), 150L);
        }
    }

    public void G1() {
        if (this.C == null) {
            this.C = this.A;
        }
        I1(this.C);
    }

    public boolean G2(ei.f fVar) {
        return (fVar == null || fVar.getSubItems() == null || fVar.getSubItems().size() <= 0) ? false : true;
    }

    public void G3(@n0 T t10, @g.f0(from = 0) long j10, boolean z10) {
        this.O.postDelayed(new RunnableC0314b(t10, z10), j10);
    }

    public void G4(List<T> list, int i10, int i11) {
        if (i10 < 0 || i10 >= getItemCount() || i11 < 0 || i11 >= getItemCount()) {
            return;
        }
        this.f27323a.e("swapItems from=%s [selected? %s] to=%s [selected? %s]", Integer.valueOf(i10), Boolean.valueOf(B(i10)), Integer.valueOf(i11), Boolean.valueOf(B(i11)));
        if (i10 < i11 && W2(g2(i10)) && X2(i11)) {
            collapse(i11);
        }
        if (i10 < i11) {
            int i12 = i10;
            while (i12 < i11) {
                int i13 = i12 + 1;
                this.f27323a.e("swapItems from=%s to=%s", Integer.valueOf(i12), Integer.valueOf(i13));
                Collections.swap(list, i12, i13);
                K(i12, i13);
                i12 = i13;
            }
        } else {
            for (int i14 = i10; i14 > i11; i14--) {
                int i15 = i14 - 1;
                this.f27323a.e("swapItems from=%s to=%s", Integer.valueOf(i14), Integer.valueOf(i15));
                Collections.swap(list, i14, i15);
                K(i14, i15);
            }
        }
        notifyItemMoved(i10, i11);
        if (this.Y) {
            ei.h hVarG2 = g2(i11);
            ei.h hVarG22 = g2(i10);
            boolean z10 = hVarG22 instanceof ei.i;
            if (z10 && (hVarG2 instanceof ei.i)) {
                if (i10 < i11) {
                    ei.i iVar = (ei.i) hVarG2;
                    Iterator<ei.k> it2 = u2(iVar).iterator();
                    while (it2.hasNext()) {
                        l3(it2.next(), iVar, Payload.LINK);
                    }
                    return;
                }
                ei.i iVar2 = (ei.i) hVarG22;
                Iterator<ei.k> it3 = u2(iVar2).iterator();
                while (it3.hasNext()) {
                    l3(it3.next(), iVar2, Payload.LINK);
                }
                return;
            }
            if (z10) {
                int i16 = i10 < i11 ? i11 + 1 : i11;
                if (i10 >= i11) {
                    i11 = i10 + 1;
                }
                ei.h hVarG23 = g2(i16);
                ei.i iVarS2 = s2(i16);
                Payload payload = Payload.LINK;
                l3(hVarG23, iVarS2, payload);
                l3(g2(i11), (ei.i) hVarG22, payload);
                return;
            }
            if (hVarG2 instanceof ei.i) {
                int i17 = i10 < i11 ? i10 : i10 + 1;
                if (i10 < i11) {
                    i10 = i11 + 1;
                }
                ei.h hVarG24 = g2(i17);
                ei.i iVarS22 = s2(i17);
                Payload payload2 = Payload.LINK;
                l3(hVarG24, iVarS22, payload2);
                l3(g2(i10), (ei.i) hVarG2, payload2);
                return;
            }
            int i18 = i10 < i11 ? i11 : i10;
            if (i10 >= i11) {
                i10 = i11;
            }
            ei.h hVarG25 = g2(i18);
            ei.i iVarF2 = f2(hVarG25);
            if (iVarF2 != null) {
                ei.i iVarS23 = s2(i18);
                if (iVarS23 != null && !iVarS23.equals(iVarF2)) {
                    l3(hVarG25, iVarS23, Payload.LINK);
                }
                l3(g2(i10), iVarF2, Payload.LINK);
            }
        }
    }

    @Override // eu.davidea.flexibleadapter.c
    public void H(Integer... numArr) {
        if (u() <= 0 || numArr.length != 0) {
            super.H(numArr);
        } else {
            super.H(Integer.valueOf(getItemViewType(v().get(0).intValue())));
        }
    }

    public void H1(@g.f0(from = 0) long j10) {
        if (this.C == null) {
            this.C = this.A;
        }
        J1(this.C, j10);
    }

    public final boolean H2(int i10, List<T> list) {
        for (T t10 : list) {
            i10++;
            if (B(i10) || (Y2(t10) && H2(i10, V1((ei.f) t10, false)))) {
                return true;
            }
        }
        return false;
    }

    public void H3(@n0 List<Integer> list) {
        I3(list, Payload.REM_SUB_ITEM);
    }

    public final void H4(T t10, @p0 Object obj) {
        if (D2(t10)) {
            ei.k kVar = (ei.k) t10;
            ei.i iVarU = kVar.u();
            this.f27323a.e("Unlink header %s from %s", iVarU, kVar);
            kVar.t(null);
            if (obj != null) {
                if (!iVarU.d()) {
                    notifyItemChanged(d2(iVarU), obj);
                }
                if (t10.d()) {
                    return;
                }
                notifyItemChanged(d2(t10), obj);
            }
        }
    }

    public void I1(@n0 List<T> list) {
        this.O.removeMessages(2);
        Handler handler = this.O;
        handler.sendMessage(Message.obtain(handler, 2, list));
    }

    public void I2() {
        this.O.post(new n());
    }

    public void I3(@p0 List<Integer> list, @p0 Object obj) {
        this.f27323a.e("removeItems selectedPositions=%s payload=%s", list, obj);
        if (list == null || list.isEmpty()) {
            return;
        }
        if (list.size() > 1) {
            Collections.sort(list, new c());
            this.f27323a.e("removeItems after reverse sort selectedPositions=%s", list);
        }
        int iIntValue = list.get(0).intValue();
        this.S = true;
        int i10 = 0;
        int iIntValue2 = 0;
        for (Integer num : list) {
            if (iIntValue - i10 == num.intValue()) {
                i10++;
                iIntValue2 = num.intValue();
            } else {
                if (i10 > 0) {
                    M3(iIntValue2, i10, obj);
                }
                iIntValue = num.intValue();
                iIntValue2 = iIntValue;
                i10 = 1;
            }
            collapse(num.intValue());
        }
        this.S = false;
        if (i10 > 0) {
            M3(iIntValue2, i10, obj);
        }
    }

    @g.i
    public void I4(@p0 List<T> list) {
        J4(list, false);
    }

    public boolean J0(@g.f0(from = 0) int i10, @n0 T t10) {
        if (t10 == null) {
            this.f27323a.b("addItem No item to add!", new Object[0]);
            return false;
        }
        this.f27323a.e("addItem delegates addition to addItems!", new Object[0]);
        return O0(i10, Collections.singletonList(t10));
    }

    public void J1(@n0 List<T> list, @g.f0(from = 0) long j10) {
        this.O.removeMessages(2);
        Handler handler = this.O;
        Message messageObtain = Message.obtain(handler, 2, list);
        if (j10 <= 0) {
            j10 = 0;
        }
        handler.sendMessageDelayed(messageObtain, j10);
    }

    public final void J2(int i10, ei.i iVar) {
        if (i10 >= 0) {
            this.f27323a.e("Hiding header position=%s header=$s", Integer.valueOf(i10), iVar);
            iVar.f(true);
            this.A.remove(i10);
            notifyItemRemoved(i10);
        }
    }

    public void J3(Integer... numArr) {
        List listAsList = Arrays.asList(numArr);
        ArrayList arrayList = new ArrayList();
        int iMax = Math.max(0, this.W.size() - 1);
        for (int itemCount = (getItemCount() - this.X.size()) - 1; itemCount >= iMax; itemCount--) {
            if (listAsList.contains(Integer.valueOf(getItemViewType(itemCount)))) {
                arrayList.add(Integer.valueOf(itemCount));
            }
        }
        H3(arrayList);
    }

    @g.i
    public void J4(@p0 List<T> list, boolean z10) {
        this.C = null;
        if (list == null) {
            list = new ArrayList<>();
        }
        if (z10) {
            this.O.removeMessages(1);
            Handler handler = this.O;
            handler.sendMessage(Message.obtain(handler, 1, list));
        } else {
            ArrayList arrayList = new ArrayList(list);
            y3(arrayList);
            this.A = arrayList;
            this.f27323a.f("updateDataSet with notifyDataSetChanged!", new Object[0]);
            notifyDataSetChanged();
            u3();
        }
    }

    public boolean K0(@n0 T t10) {
        return J0(getItemCount(), t10);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0066 A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x001d, B:7:0x0025, B:8:0x0029, B:10:0x002f, B:12:0x0039, B:16:0x0041, B:24:0x005e, B:26:0x0066, B:27:0x006f, B:17:0x0045, B:19:0x004d, B:21:0x0057, B:22:0x005a), top: B:33:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void K1(@g.n0 java.util.List<T> r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            fi.c r0 = r6.f27323a     // Catch: java.lang.Throwable -> L73
            java.lang.String r1 = "filterItems with filterEntity=\"%s\""
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L73
            java.io.Serializable r4 = r6.f27251g0     // Catch: java.lang.Throwable -> L73
            r5 = 0
            r3[r5] = r4     // Catch: java.lang.Throwable -> L73
            r0.a(r1, r3)     // Catch: java.lang.Throwable -> L73
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L73
            r0.<init>()     // Catch: java.lang.Throwable -> L73
            r6.f27255k0 = r2     // Catch: java.lang.Throwable -> L73
            boolean r1 = r6.C2()     // Catch: java.lang.Throwable -> L73
            if (r1 == 0) goto L45
            java.io.Serializable r1 = r6.f27251g0     // Catch: java.lang.Throwable -> L73
            boolean r1 = r6.E2(r1)     // Catch: java.lang.Throwable -> L73
            if (r1 == 0) goto L45
            java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Throwable -> L73
        L29:
            boolean r1 = r7.hasNext()     // Catch: java.lang.Throwable -> L73
            if (r1 == 0) goto L5d
            java.lang.Object r1 = r7.next()     // Catch: java.lang.Throwable -> L73
            ei.h r1 = (ei.h) r1     // Catch: java.lang.Throwable -> L73
            eu.davidea.flexibleadapter.b<T>$t r2 = r6.F     // Catch: java.lang.Throwable -> L73
            if (r2 == 0) goto L41
            boolean r2 = r2.isCancelled()     // Catch: java.lang.Throwable -> L73
            if (r2 == 0) goto L41
            monitor-exit(r6)
            return
        L41:
            r6.M1(r1, r0)     // Catch: java.lang.Throwable -> L73
            goto L29
        L45:
            java.io.Serializable r1 = r6.f27251g0     // Catch: java.lang.Throwable -> L73
            boolean r1 = r6.E2(r1)     // Catch: java.lang.Throwable -> L73
            if (r1 == 0) goto L5d
            r6.S3(r7)     // Catch: java.lang.Throwable -> L73
            r0 = 0
            r6.f27253i0 = r0     // Catch: java.lang.Throwable -> L73
            java.util.List<T extends ei.h> r1 = r6.C     // Catch: java.lang.Throwable -> L73
            if (r1 != 0) goto L5a
            r6.U3(r7)     // Catch: java.lang.Throwable -> L73
        L5a:
            r6.C = r0     // Catch: java.lang.Throwable -> L73
            goto L5e
        L5d:
            r7 = r0
        L5e:
            java.io.Serializable r0 = r6.f27251g0     // Catch: java.lang.Throwable -> L73
            boolean r0 = r6.E2(r0)     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L6f
            java.io.Serializable r0 = r6.f27251g0     // Catch: java.lang.Throwable -> L73
            r6.f27252h0 = r0     // Catch: java.lang.Throwable -> L73
            eu.davidea.flexibleadapter.Payload r0 = eu.davidea.flexibleadapter.Payload.FILTER     // Catch: java.lang.Throwable -> L73
            r6.c1(r7, r0)     // Catch: java.lang.Throwable -> L73
        L6f:
            r6.f27255k0 = r5     // Catch: java.lang.Throwable -> L73
            monitor-exit(r6)
            return
        L73:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.davidea.flexibleadapter.b.K1(java.util.List):void");
    }

    public final void K2(T t10) {
        ei.i iVarF2 = f2(t10);
        if (iVarF2 == null || iVarF2.d()) {
            return;
        }
        J2(d2(iVarF2), iVarF2);
    }

    @g.i
    public b<T> K3(Object obj) {
        if (obj == null) {
            this.f27323a.b("No listener class to remove!", new Object[0]);
            return this;
        }
        String strE = fi.a.e(obj);
        if ((obj instanceof z) || obj == z.class) {
            this.D0 = null;
            this.f27323a.d("Removed %s as OnItemClickListener", strE);
            Iterator<gi.d> it2 = q().iterator();
            while (it2.hasNext()) {
                it2.next().h().setOnClickListener(null);
            }
        }
        if ((obj instanceof a0) || obj == a0.class) {
            this.E0 = null;
            this.f27323a.d("Removed %s as OnItemLongClickListener", strE);
            Iterator<gi.d> it3 = q().iterator();
            while (it3.hasNext()) {
                it3.next().h().setOnLongClickListener(null);
            }
        }
        if ((obj instanceof b0) || obj == b0.class) {
            this.H0 = null;
            this.f27323a.d("Removed %s as OnItemMoveListener", strE);
        }
        if ((obj instanceof c0) || obj == c0.class) {
            this.I0 = null;
            this.f27323a.d("Removed %s as OnItemSwipeListener", strE);
        }
        if ((obj instanceof x) || obj == x.class) {
            this.K0 = null;
            this.f27323a.d("Removed %s as OnDeleteCompleteListener", strE);
        }
        if ((obj instanceof d0) || obj == d0.class) {
            this.L0 = null;
            this.f27323a.d("Removed %s as OnStickyHeaderChangeListener", strE);
        }
        if ((obj instanceof e0) || obj == e0.class) {
            this.F0 = null;
            this.f27323a.d("Removed %s as OnUpdateListener", strE);
        }
        if ((obj instanceof y) || obj == y.class) {
            this.G0 = null;
            this.f27323a.d("Removed %s as OnFilterListener", strE);
        }
        return this;
    }

    public void K4(@g.f0(from = 0) int i10, @n0 T t10, @p0 Object obj) {
        if (t10 == null) {
            this.f27323a.b("updateItem No Item to update!", new Object[0]);
            return;
        }
        int itemCount = getItemCount();
        if (i10 < 0 || i10 >= itemCount) {
            this.f27323a.b("Cannot updateItem on position out of OutOfBounds!", new Object[0]);
            return;
        }
        this.A.set(i10, t10);
        this.f27323a.a("updateItem notifyItemChanged on position " + i10, new Object[0]);
        notifyItemChanged(i10, obj);
    }

    public int L0(@n0 ei.k kVar, @p0 ei.i iVar, @g.f0(from = 0) int i10) {
        this.f27323a.a("addItemToSection relativePosition=%s", Integer.valueOf(i10));
        int iD2 = d2(iVar);
        if (i10 >= 0) {
            kVar.t(iVar);
            if (iD2 < 0 || !W2(iVar)) {
                J0(iD2 + 1 + i10, kVar);
            } else {
                X0(iD2, i10, kVar, false, Payload.ADD_SUB_ITEM);
            }
        }
        return d2(kVar);
    }

    public boolean L1(T t10, Serializable serializable) {
        return (t10 instanceof ei.g) && ((ei.g) t10).a(serializable);
    }

    public final void L2() {
        if (d2(this.C0) >= 0) {
            this.f27323a.e("onLoadMore     remove progressItem", new Object[0]);
            if (this.B0) {
                P3(this.C0);
            } else {
                N3(this.C0);
            }
        }
    }

    public void L3(@g.f0(from = 0) int i10, @g.f0(from = 0) int i11) {
        M3(i10, i11, Payload.REM_SUB_ITEM);
    }

    public void L4(@n0 T t10) {
        M4(t10, null);
    }

    @Override // eu.davidea.flexibleadapter.c
    public void M(@g.f0(from = 0) int i10) {
        ei.h hVarG2 = g2(i10);
        if (hVarG2 != null && hVarG2.k()) {
            ei.f fVarX1 = X1(hVarG2);
            boolean z10 = fVarX1 != null;
            if ((W2(hVarG2) || !z10) && !this.f27263s0) {
                this.f27264t0 = true;
                if (z10) {
                    this.f27259o0 = fVarX1.l();
                }
                super.M(i10);
            } else if (z10 && (this.f27259o0 == -1 || (!this.f27264t0 && fVarX1.l() + 1 == this.f27259o0))) {
                this.f27263s0 = true;
                this.f27259o0 = fVarX1.l() + 1;
                super.M(i10);
            }
        }
        if (super.u() == 0) {
            this.f27259o0 = -1;
            this.f27263s0 = false;
            this.f27264t0 = false;
        }
    }

    public int M0(@n0 ei.k kVar, @p0 ei.i iVar, @p0 Comparator<ei.h> comparator) {
        int iL1;
        if (iVar == null || iVar.d()) {
            iL1 = l1(kVar, comparator);
        } else {
            List<ei.k> listU2 = u2(iVar);
            listU2.add(kVar);
            Collections.sort(listU2, comparator);
            iL1 = listU2.indexOf(kVar);
        }
        return L0(kVar, iVar, iL1);
    }

    public final boolean M1(T t10, List<T> list) {
        b<T>.t tVar = this.F;
        if (tVar != null && tVar.isCancelled()) {
            return false;
        }
        if (this.C != null && (i3(t10) || list.contains(t10))) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t10);
        boolean zF1 = F1(t10, arrayList);
        if (!zF1) {
            zF1 = L1(t10, c2(Serializable.class));
        }
        if (zF1) {
            ei.i iVarF2 = f2(t10);
            if (this.Y && D2(t10) && !list.contains(iVarF2)) {
                iVarF2.f(false);
                list.add(iVarF2);
            }
            list.addAll(arrayList);
        }
        t10.f(!zF1);
        return zF1;
    }

    public final void M2() {
        if (this.f27266v0 == null) {
            if (this.f27328f == null) {
                throw new IllegalStateException("RecyclerView cannot be null. Enabling LongPressDrag or Swipe must be done after the Adapter has been attached to the RecyclerView.");
            }
            if (this.f27265u0 == null) {
                this.f27265u0 = new di.a(this);
                this.f27323a.d("Initialized default ItemTouchHelperCallback", new Object[0]);
            }
            androidx.recyclerview.widget.m mVar = new androidx.recyclerview.widget.m(this.f27265u0);
            this.f27266v0 = mVar;
            mVar.j(this.f27328f);
        }
    }

    public void M3(@g.f0(from = 0) int i10, @g.f0(from = 0) int i11, @p0 Object obj) {
        int i12;
        List<T> list;
        int itemCount = getItemCount();
        this.f27323a.a("removeRange positionStart=%s itemCount=%s", Integer.valueOf(i10), Integer.valueOf(i11));
        if (i10 < 0 || (i12 = i10 + i11) > itemCount) {
            this.f27323a.b("Cannot removeRange with positionStart OutOfBounds!", new Object[0]);
            return;
        }
        if (i11 == 0 || itemCount == 0) {
            this.f27323a.f("removeRange Nothing to delete!", new Object[0]);
            return;
        }
        ei.h hVarG2 = null;
        ei.f fVarX1 = null;
        for (int i13 = i10; i13 < i12; i13++) {
            hVarG2 = g2(i10);
            if (hVarG2 != null) {
                if (!this.U) {
                    if (fVarX1 == null) {
                        fVarX1 = X1(hVarG2);
                    }
                    if (fVarX1 == null) {
                        t1(i10, hVarG2);
                    } else {
                        u1(fVarX1, hVarG2);
                    }
                }
                hVarG2.f(true);
                if (this.T && b3(hVarG2)) {
                    for (ei.k kVar : u2((ei.i) hVarG2)) {
                        kVar.t(null);
                        if (obj != null) {
                            notifyItemChanged(d2(kVar), Payload.UNLINK);
                        }
                    }
                }
                this.A.remove(i10);
                if (this.U && (list = this.C) != null) {
                    list.remove(hVarG2);
                }
                F(i13);
            }
        }
        notifyItemRangeRemoved(i10, i11);
        int iD2 = d2(f2(hVarG2));
        if (iD2 >= 0) {
            notifyItemChanged(iD2, obj);
        }
        int iD22 = d2(fVarX1);
        if (iD22 >= 0 && iD22 != iD2) {
            notifyItemChanged(iD22, obj);
        }
        if (this.F0 == null || this.S || itemCount <= 0 || getItemCount() != 0) {
            return;
        }
        this.F0.m0(l2());
    }

    public void M4(@n0 T t10, @p0 Object obj) {
        K4(d2(t10), t10, obj);
    }

    public void N0(@g.f0(from = 0) int i10, @n0 T t10, @g.f0(from = 0) long j10, boolean z10) {
        this.O.postDelayed(new a(i10, t10, z10), j10);
    }

    public final int N1(@n0 ei.h hVar) {
        int iD2 = d2(hVar);
        return iD2 > this.W.size() ? iD2 - this.W.size() : iD2;
    }

    public final void N2(@g.f0(from = 0) long j10) {
        this.f27328f.postDelayed(new g(), j10);
    }

    public final void N3(@n0 T t10) {
        if (this.X.remove(t10)) {
            this.f27323a.a("Remove scrollable footer %s", fi.a.e(t10));
            w3(t10, true);
        }
    }

    public boolean O0(@g.f0(from = 0) int i10, @n0 List<T> list) {
        if (list == null || list.isEmpty()) {
            this.f27323a.b("addItems No items to add!", new Object[0]);
            return false;
        }
        int iL2 = l2();
        if (i10 < 0) {
            this.f27323a.f("addItems Position is negative! adding items to the end", new Object[0]);
            i10 = this.W.size() + iL2;
        }
        v3(i10, list, true);
        D4(list);
        if (!this.Z && this.F0 != null && !this.S && iL2 == 0 && getItemCount() > 0) {
            this.F0.m0(l2());
        }
        return true;
    }

    @n0
    public final List<T> O1(@p0 ei.f fVar) {
        if (fVar == null || !G2(fVar)) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(fVar.getSubItems());
        if (!this.P.isEmpty()) {
            arrayList.removeAll(Q1(fVar));
        }
        return arrayList;
    }

    public boolean O2() {
        return this.I;
    }

    public final void O3(@n0 T t10, @g.f0(from = 0) long j10) {
        this.f27323a.a("Enqueued removing scrollable footer (%sms) %s", Long.valueOf(j10), fi.a.e(t10));
        this.O.postDelayed(new k(t10), j10);
    }

    @g.i
    public b<T> P0(Object obj) {
        if (obj == null) {
            this.f27323a.b("Invalid listener class: null", new Object[0]);
            return this;
        }
        this.f27323a.d("Adding listener class %s as:", fi.a.e(obj));
        if (obj instanceof z) {
            this.f27323a.d("- OnItemClickListener", new Object[0]);
            this.D0 = (z) obj;
            for (gi.d dVar : q()) {
                dVar.h().setOnClickListener(dVar);
            }
        }
        if (obj instanceof a0) {
            this.f27323a.d("- OnItemLongClickListener", new Object[0]);
            this.E0 = (a0) obj;
            for (gi.d dVar2 : q()) {
                dVar2.h().setOnLongClickListener(dVar2);
            }
        }
        if (obj instanceof b0) {
            this.f27323a.d("- OnItemMoveListener", new Object[0]);
            this.H0 = (b0) obj;
        }
        if (obj instanceof c0) {
            this.f27323a.d("- OnItemSwipeListener", new Object[0]);
            this.I0 = (c0) obj;
        }
        if (obj instanceof x) {
            this.f27323a.d("- OnDeleteCompleteListener", new Object[0]);
            this.K0 = (x) obj;
        }
        if (obj instanceof d0) {
            this.f27323a.d("- OnStickyHeaderChangeListener", new Object[0]);
            this.L0 = (d0) obj;
        }
        if (obj instanceof e0) {
            this.f27323a.d("- OnUpdateListener", new Object[0]);
            e0 e0Var = (e0) obj;
            this.F0 = e0Var;
            e0Var.m0(l2());
        }
        if (obj instanceof y) {
            this.f27323a.d("- OnFilterListener", new Object[0]);
            this.G0 = (y) obj;
        }
        return this;
    }

    @n0
    public final List<T> P1() {
        return Collections.unmodifiableList(this.A);
    }

    public boolean P2() {
        return this.f27263s0;
    }

    public final void P3(@n0 T t10) {
        if (this.W.remove(t10)) {
            this.f27323a.a("Remove scrollable header %s", fi.a.e(t10));
            w3(t10, true);
        }
    }

    public final boolean Q0(@n0 T t10) {
        if (this.X.contains(t10)) {
            this.f27323a.f("Scrollable footer %s already added", fi.a.e(t10));
            return false;
        }
        this.f27323a.a("Add scrollable footer %s", fi.a.e(t10));
        t10.v(false);
        t10.h(false);
        int size = t10 == this.C0 ? this.X.size() : 0;
        if (size <= 0 || this.X.size() <= 0) {
            this.X.add(t10);
        } else {
            this.X.add(0, t10);
        }
        v3(getItemCount() - size, Collections.singletonList(t10), true);
        return true;
    }

    @n0
    public final List<T> Q1(ei.f fVar) {
        ArrayList arrayList = new ArrayList();
        for (b<T>.f0 f0Var : this.P) {
            T t10 = f0Var.f27287c;
            if (t10 != null && t10.equals(fVar) && f0Var.f27286b >= 0) {
                arrayList.add(f0Var.f27288d);
            }
        }
        return arrayList;
    }

    public boolean Q2() {
        return this.f27264t0;
    }

    public final void Q3(@n0 T t10, @g.f0(from = 0) long j10) {
        this.f27323a.a("Enqueued removing scrollable header (%sms) %s", Long.valueOf(j10), fi.a.e(t10));
        this.O.postDelayed(new j(t10), j10);
    }

    public final void R0(@n0 T t10, @g.f0(from = 0) long j10, boolean z10) {
        this.f27323a.a("Enqueued adding scrollable footer (%sms) %s", Long.valueOf(j10), fi.a.e(t10));
        this.O.postDelayed(new i(t10, z10), j10);
    }

    @n0
    public List<T> R1() {
        ArrayList arrayList = new ArrayList();
        Iterator<b<T>.f0> it2 = this.P.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().f27288d);
        }
        return arrayList;
    }

    public boolean R2() {
        return this.f27261q0;
    }

    public void R3(ei.i iVar) {
        List<Integer> listT2 = t2(iVar);
        int iD2 = d2(iVar);
        this.f27323a.a("removeSection %s with all subItems at position=%s", fi.a.e(iVar), Integer.valueOf(iD2));
        listT2.add(Integer.valueOf(iD2));
        H3(listT2);
    }

    public final boolean S0(@n0 T t10) {
        this.f27323a.a("Add scrollable header %s", fi.a.e(t10));
        if (this.W.contains(t10)) {
            this.f27323a.f("Scrollable header %s already added", fi.a.e(t10));
            return false;
        }
        t10.v(false);
        t10.h(false);
        int size = t10 == this.C0 ? this.W.size() : 0;
        this.W.add(t10);
        e0(true);
        v3(size, Collections.singletonList(t10), true);
        e0(false);
        return true;
    }

    public int S1() {
        if (this.f27269y0 > 0) {
            return (int) Math.ceil(((double) l2()) / ((double) this.f27269y0));
        }
        return 0;
    }

    public boolean S2() {
        return this.f27260p0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List, java.util.List<T extends ei.h>] */
    /* JADX WARN: Type inference failed for: r3v3, types: [ei.h, ei.i, java.lang.Object] */
    public final void S3(List<T> list) {
        ?? F2;
        if (list == 0) {
            return;
        }
        ?? r02 = 0;
        int size = 0;
        while (size < list.size()) {
            ei.h hVar = (ei.h) list.get(size);
            hVar.f(false);
            if (W2(hVar)) {
                ei.f fVar = (ei.f) hVar;
                Set<ei.f> set = this.f27253i0;
                fVar.setExpanded(set != null && set.contains(fVar));
                if (G2(fVar)) {
                    List<ei.h> subItems = fVar.getSubItems();
                    for (ei.h hVar2 : subItems) {
                        hVar2.f(false);
                        if (hVar2 instanceof ei.f) {
                            ei.f fVar2 = (ei.f) hVar2;
                            fVar2.setExpanded(false);
                            S3(fVar2.getSubItems());
                        }
                    }
                    if (fVar.isExpanded() && this.C == null) {
                        if (size < list.size()) {
                            list.addAll(size + 1, subItems);
                        } else {
                            list.addAll(subItems);
                        }
                        size += subItems.size();
                    }
                }
            }
            if (this.Y && this.C == null && (F2 = f2(hVar)) != 0 && !F2.equals(r02) && !W2(F2)) {
                F2.f(false);
                list.add(size, F2);
                size++;
                r02 = F2;
            }
            size++;
            r02 = r02;
        }
    }

    public final void T0(@n0 T t10, @g.f0(from = 0) long j10, boolean z10) {
        this.f27323a.a("Enqueued adding scrollable header (%sms) %s", Long.valueOf(j10), fi.a.e(t10));
        this.O.postDelayed(new h(t10, z10), j10);
    }

    public int T1() {
        return this.f27269y0;
    }

    public boolean T2() {
        return getItemCount() == 0;
    }

    public void T3() {
        this.S = true;
        int itemCount = getItemCount();
        if (u() > 0) {
            n();
        }
        for (int size = this.P.size() - 1; size >= 0; size--) {
            this.V = false;
            b<T>.f0 f0Var = this.P.get(size);
            if (f0Var.f27286b >= 0) {
                this.f27323a.a("Restore SubItem %s", f0Var);
                X0(f0Var.a(true), f0Var.f27286b, f0Var.f27288d, false, Payload.UNDO);
            } else {
                this.f27323a.a("Restore Item %s", f0Var);
                J0(f0Var.a(false), f0Var.f27288d);
            }
            f0Var.f27288d.f(false);
            if (this.T && b3(f0Var.f27288d)) {
                ei.i iVar = (ei.i) f0Var.f27288d;
                Iterator<ei.k> it2 = u2(iVar).iterator();
                while (it2.hasNext()) {
                    l3(it2.next(), iVar, Payload.LINK);
                }
            }
        }
        if (this.R && !this.P.isEmpty()) {
            if (W2(this.P.get(0).f27288d) || X1(this.P.get(0).f27288d) == null) {
                this.f27264t0 = true;
            } else {
                this.f27263s0 = true;
            }
            for (b<T>.f0 f0Var2 : this.P) {
                if (f0Var2.f27288d.k()) {
                    m(d2(f0Var2.f27288d));
                }
            }
            this.f27323a.a("Selected positions after restore %s", v());
        }
        this.S = false;
        if (this.F0 != null && itemCount == 0 && getItemCount() > 0) {
            this.F0.m0(l2());
        }
        v1();
    }

    public int U0(@n0 ei.i iVar) {
        return V0(iVar, null);
    }

    public int U1() {
        return this.f27268x0;
    }

    @Deprecated
    public boolean U2(int i10) {
        return c3(i10);
    }

    public final void U3(List<T> list) {
        for (T t10 : this.W) {
            if (list.size() > 0) {
                list.add(0, t10);
            } else {
                list.add(t10);
            }
        }
        list.addAll(this.X);
    }

    @Override // eu.davidea.flexibleadapter.AnimatorAdapter
    public final boolean V(int i10) {
        return i3(g2(i10));
    }

    public int V0(@n0 ei.i iVar, @p0 Comparator<ei.h> comparator) {
        int iL1 = l1(iVar, comparator);
        J0(iL1, iVar);
        return iL1;
    }

    @n0
    public final List<T> V1(ei.f fVar, boolean z10) {
        ArrayList arrayList = new ArrayList();
        if (fVar != null && G2(fVar)) {
            for (ei.h hVar : fVar.getSubItems()) {
                if (!hVar.d()) {
                    arrayList.add(hVar);
                    if (z10 && Y2(hVar)) {
                        ei.f fVar2 = (ei.f) hVar;
                        if (fVar2.getSubItems().size() > 0) {
                            arrayList.addAll(V1(fVar2, true));
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public boolean V2() {
        return this.A0;
    }

    public void V3(@n0 List<Integer> list) {
        this.Q.addAll(list);
    }

    public boolean W0(@g.f0(from = 0) int i10, @g.f0(from = 0) int i11, @n0 T t10) {
        return X0(i10, i11, t10, false, Payload.CHANGE);
    }

    @p0
    public ei.f W1(int i10) {
        return X1(g2(i10));
    }

    public boolean W2(@p0 T t10) {
        return t10 instanceof ei.f;
    }

    public b<T> W3(boolean z10) {
        this.I = z10;
        return this;
    }

    public boolean X0(@g.f0(from = 0) int i10, @g.f0(from = 0) int i11, @n0 T t10, boolean z10, @p0 Object obj) {
        if (t10 != null) {
            return a1(i10, i11, Collections.singletonList(t10), z10, obj);
        }
        this.f27323a.b("addSubItem No items to add!", new Object[0]);
        return false;
    }

    @p0
    public ei.f X1(T t10) {
        for (T t11 : this.A) {
            if (W2(t11)) {
                ei.f fVar = (ei.f) t11;
                if (fVar.isExpanded() && G2(fVar)) {
                    for (ei.h hVar : fVar.getSubItems()) {
                        if (!hVar.d() && hVar.equals(t10)) {
                            return fVar;
                        }
                    }
                }
            }
        }
        return null;
    }

    public boolean X2(@g.f0(from = 0) int i10) {
        return Y2(g2(i10));
    }

    public b<T> X3(int i10) {
        this.f27323a.d("Set animateToLimit=%s", Integer.valueOf(i10));
        this.f27257m0 = i10;
        return this;
    }

    public final boolean Y0(@g.f0(from = 0) int i10, @g.f0(from = 0) int i11, @n0 ei.f fVar, @n0 List<T> list, boolean z10, @p0 Object obj) {
        if (z10 && !fVar.isExpanded()) {
            expand(i10);
        }
        boolean zO0 = fVar.isExpanded() ? O0(i10 + 1 + o2(fVar, i11), list) : false;
        if (obj != null && !b3(fVar)) {
            notifyItemChanged(i10, obj);
        }
        return zO0;
    }

    public final ei.f Y1(@n0 T t10) {
        for (b<T>.f0 f0Var : this.P) {
            if (f0Var.f27288d.equals(t10) && W2(f0Var.f27287c)) {
                return (ei.f) f0Var.f27287c;
            }
        }
        return null;
    }

    public boolean Y2(@p0 T t10) {
        return W2(t10) && ((ei.f) t10).isExpanded();
    }

    public b<T> Y3(boolean z10) {
        this.f27323a.d("Set autoCollapseOnExpand=%s", Boolean.valueOf(z10));
        this.f27261q0 = z10;
        return this;
    }

    public boolean Z0(@g.f0(from = 0) int i10, @g.f0(from = 0) int i11, @n0 List<T> list) {
        return a1(i10, i11, list, false, Payload.CHANGE);
    }

    public int Z1(@n0 T t10) {
        return d2(X1(t10));
    }

    public boolean Z2() {
        return this.f27255k0;
    }

    public b<T> Z3(boolean z10) {
        this.f27323a.d("Set setAutoScrollOnExpand=%s", Boolean.valueOf(z10));
        this.f27260p0 = z10;
        return this;
    }

    public boolean a1(@g.f0(from = 0) int i10, @g.f0(from = 0) int i11, @n0 List<T> list, boolean z10, @p0 Object obj) {
        ei.h hVarG2 = g2(i10);
        if (W2(hVarG2)) {
            return Y0(i10, i11, (ei.f) hVarG2, list, z10, obj);
        }
        this.f27323a.b("addSubItems Provided parentPosition doesn't belong to an Expandable item!", new Object[0]);
        return false;
    }

    @n0
    public List<T> a2() {
        ArrayList arrayList = new ArrayList();
        for (T t10 : this.A) {
            if (Y2(t10)) {
                arrayList.add(t10);
            }
        }
        return arrayList;
    }

    public final boolean a3() {
        di.a aVar = this.f27265u0;
        return aVar != null && aVar.a();
    }

    public b<T> a4(r rVar) {
        this.K = rVar;
        return this;
    }

    @Override // di.a.InterfaceC0296a
    public void b(RecyclerView.e0 e0Var, int i10) {
        b0 b0Var = this.H0;
        if (b0Var != null) {
            b0Var.b(e0Var, i10);
            return;
        }
        c0 c0Var = this.I0;
        if (c0Var != null) {
            c0Var.b(e0Var, i10);
        }
    }

    public final void b1(int i10, int i11) {
        String str;
        List<Integer> listV = v();
        if (i11 > 0) {
            Collections.sort(listV, new f());
            str = com.google.android.material.badge.a.f19590u;
        } else {
            str = "";
        }
        boolean z10 = false;
        for (Integer num : listV) {
            if (num.intValue() >= i10) {
                F(num.intValue());
                l(Math.max(num.intValue() + i11, i10));
                z10 = true;
            }
        }
        if (z10) {
            this.f27323a.e("AdjustedSelected(%s)=%s", str + i11, v());
        }
    }

    @n0
    public List<Integer> b2() {
        ArrayList arrayList = new ArrayList();
        int itemCount = (getItemCount() - this.X.size()) - 1;
        for (int iMax = Math.max(0, this.W.size() - 1); iMax < itemCount; iMax++) {
            if (Y2(g2(iMax))) {
                arrayList.add(Integer.valueOf(iMax));
            }
        }
        return arrayList;
    }

    public boolean b3(T t10) {
        return t10 != null && (t10 instanceof ei.i);
    }

    public b<T> b4(boolean z10) {
        if (!this.Y && z10) {
            A4(true);
        }
        return this;
    }

    @Override // di.a.InterfaceC0296a
    @g.i
    public boolean c(int i10, int i11) {
        G4(this.A, i10, i11);
        b0 b0Var = this.H0;
        if (b0Var == null) {
            return true;
        }
        b0Var.c(i10, i11);
        return true;
    }

    public final synchronized void c1(@p0 List<T> list, Payload payload) {
        if (this.I) {
            this.f27323a.e("Animate changes with DiffUtils! oldSize=" + getItemCount() + " newSize=" + list.size(), new Object[0]);
            if (this.K == null) {
                this.K = new r();
            }
            this.K.b(this.A, list);
            this.J = androidx.recyclerview.widget.i.b(this.K, this.f27256l0);
        } else {
            d1(list, payload);
        }
    }

    @p0
    public <F extends Serializable> F c2(Class<F> cls) {
        return cls.cast(this.f27251g0);
    }

    public boolean c3(int i10) {
        ei.h hVarG2 = g2(i10);
        return hVarG2 != null && hVarG2.isEnabled();
    }

    public b<T> c4(@g.f0(from = 0) int i10) {
        this.f27323a.d("Set endlessPageSize=%s", Integer.valueOf(i10));
        this.f27269y0 = i10;
        return this;
    }

    public int collapse(@g.f0(from = 0) int i10) {
        return collapse(i10, false);
    }

    public final synchronized void d1(@p0 List<T> list, Payload payload) {
        this.E = new ArrayList();
        if (list == null || list.size() > this.f27257m0) {
            fi.c cVar = this.f27323a;
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(getItemCount());
            objArr[1] = list != null ? Integer.valueOf(list.size()) : "0";
            objArr[2] = Integer.valueOf(this.f27257m0);
            cVar.a("NotifyDataSetChanged! oldSize=%s newSize=%s limit=%s", objArr);
            this.B = list;
            this.E.add(new v(-1, 0));
        } else {
            this.f27323a.a("Animate changes! oldSize=%s newSize=%s limit=%s", Integer.valueOf(getItemCount()), Integer.valueOf(list.size()), Integer.valueOf(this.f27257m0));
            ArrayList arrayList = new ArrayList(this.A);
            this.B = arrayList;
            g1(arrayList, list);
            e1(this.B, list);
            if (this.f27256l0) {
                f1(this.B, list);
            }
        }
        if (this.F == null) {
            x1(payload);
        }
    }

    public final int d2(ei.h hVar) {
        if (hVar != null) {
            return this.A.indexOf(hVar);
        }
        return -1;
    }

    public final boolean d3() {
        di.a aVar = this.f27265u0;
        return aVar != null && aVar.isLongPressDragEnabled();
    }

    public b<T> d4(@p0 T t10) {
        this.A0 = t10 != null;
        if (t10 != null) {
            f4(this.f27267w0);
            this.C0 = t10;
            this.f27323a.d("Set progressItem=%s", fi.a.e(t10));
            this.f27323a.d("Enabled EndlessScrolling", new Object[0]);
        } else {
            this.f27323a.d("Disabled EndlessScrolling", new Object[0]);
        }
        return this;
    }

    public final void e1(List<T> list, List<T> list2) {
        this.D = new HashSet(list);
        int i10 = 0;
        for (int i11 = 0; i11 < list2.size(); i11++) {
            b<T>.t tVar = this.F;
            if (tVar != null && tVar.isCancelled()) {
                return;
            }
            T t10 = list2.get(i11);
            if (!this.D.contains(t10)) {
                this.f27323a.e("calculateAdditions add position=%s item=%s", Integer.valueOf(i11), t10);
                if (this.f27256l0) {
                    list.add(t10);
                    this.E.add(new v(list.size(), 1));
                } else {
                    if (i11 < list.size()) {
                        list.add(i11, t10);
                    } else {
                        list.add(t10);
                    }
                    this.E.add(new v(i11, 1));
                }
                i10++;
            }
        }
        this.D = null;
        this.f27323a.a("calculateAdditions total new=%s", Integer.valueOf(i10));
    }

    @n0
    public List<ei.i> e2() {
        ArrayList arrayList = new ArrayList();
        for (T t10 : this.A) {
            if (b3(t10)) {
                arrayList.add((ei.i) t10);
            }
        }
        return arrayList;
    }

    public boolean e3() {
        return this.U;
    }

    public b<T> e4(@p0 s sVar, @n0 T t10) {
        this.f27323a.d("Set endlessScrollListener=%s", fi.a.e(sVar));
        this.J0 = sVar;
        return d4(t10);
    }

    public int expand(@g.f0(from = 0) int i10) {
        return expand(i10, false);
    }

    @Override // di.a.InterfaceC0296a
    @g.i
    public void f(int i10, int i11) {
        c0 c0Var = this.I0;
        if (c0Var != null) {
            c0Var.a(i10, i11);
        }
    }

    public final void f1(List<T> list, List<T> list2) {
        int i10 = 0;
        for (int size = list2.size() - 1; size >= 0; size--) {
            b<T>.t tVar = this.F;
            if (tVar != null && tVar.isCancelled()) {
                return;
            }
            int iIndexOf = list.indexOf(list2.get(size));
            if (iIndexOf >= 0 && iIndexOf != size) {
                this.f27323a.e("calculateMovedItems fromPosition=%s toPosition=%s", Integer.valueOf(iIndexOf), Integer.valueOf(size));
                T tRemove = list.remove(iIndexOf);
                if (size < list.size()) {
                    list.add(size, tRemove);
                } else {
                    list.add(tRemove);
                }
                this.E.add(new v(iIndexOf, size, 4));
                i10++;
            }
        }
        this.f27323a.a("calculateMovedItems total move=%s", Integer.valueOf(i10));
    }

    @p0
    public ei.i f2(T t10) {
        if (t10 == null || !(t10 instanceof ei.k)) {
            return null;
        }
        return ((ei.k) t10).u();
    }

    public boolean f3() {
        return this.f27262r0;
    }

    public b<T> f4(@g.f0(from = 1) int i10) {
        if (this.f27328f != null) {
            i10 *= s().e();
        }
        this.f27267w0 = i10;
        this.f27323a.d("Set endlessScrollThreshold=%s", Integer.valueOf(i10));
        return this;
    }

    public final void g1(List<T> list, List<T> list2) {
        Map<T, Integer> mapH1 = h1(list, list2);
        this.D = new HashSet(list2);
        int i10 = 0;
        int i11 = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            b<T>.t tVar = this.F;
            if (tVar != null && tVar.isCancelled()) {
                return;
            }
            T t10 = list.get(size);
            if (!this.D.contains(t10)) {
                this.f27323a.e("calculateRemovals remove position=%s item=%s", Integer.valueOf(size), t10);
                list.remove(size);
                this.E.add(new v(size, 3));
                i11++;
            } else if (this.f27254j0) {
                T t11 = list2.get(mapH1.get(t10).intValue());
                if (Z2() || t10.m(t11)) {
                    list.set(size, t11);
                    this.E.add(new v(size, 2));
                    i10++;
                }
            }
        }
        this.D = null;
        this.f27323a.a("calculateModifications total mod=%s", Integer.valueOf(i10));
        this.f27323a.a("calculateRemovals total out=%s", Integer.valueOf(i11));
    }

    @p0
    public T g2(int i10) {
        if (i10 < 0 || i10 >= getItemCount()) {
            return null;
        }
        return this.A.get(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean g3() {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.List<eu.davidea.flexibleadapter.b<T>$f0> r0 = r1.P     // Catch: java.lang.Throwable -> L10
            if (r0 == 0) goto Ld
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L10
            if (r0 != 0) goto Ld
            r0 = 1
            goto Le
        Ld:
            r0 = 0
        Le:
            monitor-exit(r1)
            return r0
        L10:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.davidea.flexibleadapter.b.g3():boolean");
    }

    public b<T> g4(@g.f0(from = 0) int i10) {
        this.f27323a.d("Set endlessTargetCount=%s", Integer.valueOf(i10));
        this.f27268x0 = i10;
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.A.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i10) {
        if (g2(i10) != null) {
            return r3.hashCode();
        }
        return -1L;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i10) {
        ei.h hVarG2 = g2(i10);
        if (hVarG2 == null) {
            this.f27323a.b("Item for ViewType not found! position=%s, items=%s", Integer.valueOf(i10), Integer.valueOf(getItemCount()));
            return 0;
        }
        m3(hVarG2);
        this.f27250f0 = true;
        return hVarG2.q();
    }

    @p0
    public final Map<T, Integer> h1(List<T> list, List<T> list2) {
        b<T>.t tVar;
        if (!this.f27254j0) {
            return null;
        }
        this.D = new HashSet(list);
        HashMap map = new HashMap();
        for (int i10 = 0; i10 < list2.size() && ((tVar = this.F) == null || !tVar.isCancelled()); i10++) {
            T t10 = list2.get(i10);
            if (this.D.contains(t10)) {
                map.put(t10, Integer.valueOf(i10));
            }
        }
        return map;
    }

    /* JADX WARN: Incorrect return type in method signature: <S:TT;>(ILjava/lang/Class<TS;>;)TS; */
    @p0
    public ei.h h2(int i10, Class cls) {
        return (ei.h) cls.cast(g2(i10));
    }

    public boolean h3() {
        return this.R;
    }

    public void h4(@p0 Serializable serializable) {
        if (serializable instanceof String) {
            serializable = ((String) serializable).trim().toLowerCase(Locale.getDefault());
        }
        this.f27251g0 = serializable;
    }

    public boolean i1() {
        return this.Y;
    }

    public final int i2(Integer... numArr) {
        List listAsList = Arrays.asList(numArr);
        int i10 = 0;
        for (int i11 = 0; i11 < getItemCount(); i11++) {
            if (listAsList.contains(Integer.valueOf(getItemViewType(i11)))) {
                i10++;
            }
        }
        return i10;
    }

    public final boolean i3(T t10) {
        return (t10 != null && this.W.contains(t10)) || this.X.contains(t10);
    }

    public final b<T> i4(boolean z10) {
        M2();
        this.f27323a.d("Set handleDragEnabled=%s", Boolean.valueOf(z10));
        this.f27265u0.c(z10);
        return this;
    }

    @Override // di.a.InterfaceC0296a
    public boolean j(int i10, int i11) {
        b0 b0Var;
        ei.h hVarG2 = g2(i11);
        return (this.W.contains(hVarG2) || this.X.contains(hVarG2) || ((b0Var = this.H0) != null && !b0Var.d(i10, i11))) ? false : true;
    }

    public boolean j1() {
        return this.f27246b0 != null;
    }

    public final androidx.recyclerview.widget.m j2() {
        M2();
        return this.f27266v0;
    }

    public final boolean j3() {
        di.a aVar = this.f27265u0;
        return aVar != null && aVar.isItemViewSwipeEnabled();
    }

    public b<T> j4(boolean z10) {
        this.Y = z10;
        return this;
    }

    public final void k1(int i10, int i11) {
        new Handler(Looper.getMainLooper(), new e(i10, i11)).sendMessageDelayed(Message.obtain(this.O), 150L);
    }

    public final di.a k2() {
        M2();
        return this.f27265u0;
    }

    public boolean k3() {
        return this.B0;
    }

    public final b<T> k4(di.a aVar) {
        this.f27265u0 = aVar;
        this.f27266v0 = null;
        M2();
        this.f27323a.d("Initialized custom ItemTouchHelperCallback", new Object[0]);
        return this;
    }

    public int l1(@n0 Object obj, @p0 Comparator<ei.h> comparator) {
        ei.k kVar;
        ei.i iVarU;
        if (comparator == null) {
            return 0;
        }
        if (!(obj instanceof ei.k) || (iVarU = (kVar = (ei.k) obj).u()) == null || iVarU.d()) {
            ArrayList arrayList = new ArrayList(this.A);
            if (!arrayList.contains(obj)) {
                arrayList.add(obj);
            }
            Collections.sort(arrayList, comparator);
            this.f27323a.e("Calculated position %s for item=%s", Integer.valueOf(Math.max(0, arrayList.indexOf(obj))), obj);
            return Math.max(0, arrayList.indexOf(obj));
        }
        List<ei.k> listU2 = u2(iVarU);
        listU2.add(kVar);
        Collections.sort(listU2, comparator);
        int iD2 = d2(kVar);
        int iD22 = d2(iVarU);
        int i10 = (iD2 == -1 || iD2 >= iD22) ? 1 : 0;
        int iIndexOf = listU2.indexOf(obj) + iD22 + i10;
        this.f27323a.e("Calculated finalPosition=%s sectionPosition=%s relativePosition=%s fix=%s", Integer.valueOf(iIndexOf), Integer.valueOf(iD22), Integer.valueOf(listU2.indexOf(obj)), Integer.valueOf(i10));
        return iIndexOf;
    }

    public final int l2() {
        return C2() ? getItemCount() : (getItemCount() - this.W.size()) - this.X.size();
    }

    public final void l3(T t10, ei.i iVar, @p0 Object obj) {
        if (t10 == null || !(t10 instanceof ei.k)) {
            notifyItemChanged(d2(iVar), obj);
            return;
        }
        ei.k kVar = (ei.k) t10;
        if (kVar.u() != null && !kVar.u().equals(iVar)) {
            H4(kVar, Payload.UNLINK);
        }
        if (kVar.u() != null || iVar == null) {
            return;
        }
        this.f27323a.e("Link header %s to %s", iVar, kVar);
        kVar.t(iVar);
        if (obj != null) {
            if (!iVar.d()) {
                notifyItemChanged(d2(iVar), obj);
            }
            if (t10.d()) {
                return;
            }
            notifyItemChanged(d2(t10), obj);
        }
    }

    public b<T> l4(boolean z10) {
        this.f27323a.d("Set loadingAtStartup=%s", Boolean.valueOf(z10));
        if (z10) {
            this.O.post(new o());
        }
        return this;
    }

    public void m1() {
        this.f27323a.a("clearAll views", new Object[0]);
        B3();
        A3();
        M3(0, getItemCount(), null);
    }

    public int m2() {
        return this.f27258n0;
    }

    public final void m3(@n0 T t10) {
        if (this.f27249e0.containsKey(Integer.valueOf(t10.q()))) {
            return;
        }
        this.f27249e0.put(Integer.valueOf(t10.q()), t10);
        this.f27323a.d("Mapped viewType %s from %s", Integer.valueOf(t10.q()), fi.a.e(t10));
    }

    public final b<T> m4(boolean z10) {
        M2();
        this.f27323a.d("Set longPressDragEnabled=%s", Boolean.valueOf(z10));
        this.f27265u0.e(z10);
        return this;
    }

    @Override // eu.davidea.flexibleadapter.c
    @g.i
    public void n() {
        this.f27263s0 = false;
        this.f27264t0 = false;
        super.n();
    }

    public void n1(Integer... numArr) {
        List listAsList = Arrays.asList(numArr);
        this.f27323a.a("clearAll retaining views %s", listAsList);
        ArrayList arrayList = new ArrayList();
        int itemCount = getItemCount() - this.X.size();
        for (int iMax = Math.max(0, this.W.size()); iMax < itemCount; iMax++) {
            if (!listAsList.contains(Integer.valueOf(getItemViewType(iMax)))) {
                arrayList.add(Integer.valueOf(iMax));
            }
        }
        H3(arrayList);
    }

    public final b<T>.f0 n2(T t10) {
        for (b<T>.f0 f0Var : this.P) {
            if (f0Var.f27288d.equals(t10) && f0Var.f27285a < 0) {
                return f0Var;
            }
        }
        return null;
    }

    public void n3(int i10, int i11) {
        o3(i10, i11, Payload.MOVE);
    }

    public b<T> n4(int i10) {
        this.f27323a.d("Set minCollapsibleLevel=%s", Integer.valueOf(i10));
        this.f27258n0 = i10;
        return this;
    }

    public int o1() {
        return p1(this.f27258n0);
    }

    public final int o2(@n0 ei.f fVar, int i10) {
        List subItems = fVar.getSubItems();
        int iO2 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            ei.h hVar = (ei.h) subItems.get(i11);
            if (Y2(hVar)) {
                ei.f fVar2 = (ei.f) hVar;
                iO2 += o2(fVar2, fVar2.getSubItems() != null ? fVar2.getSubItems().size() : 0);
            }
            iO2++;
        }
        return iO2;
    }

    public void o3(int i10, int i11, @p0 Object obj) {
        this.f27323a.e("moveItem fromPosition=%s toPosition=%s", Integer.valueOf(i10), Integer.valueOf(i11));
        if (B(i10)) {
            F(i10);
            m(i11);
        }
        ei.h hVarG2 = g2(i10);
        boolean zY2 = Y2(hVarG2);
        if (zY2) {
            collapse(i11);
        }
        this.A.remove(i10);
        v3(i11, Collections.singletonList(hVarG2), false);
        notifyItemMoved(i10, i11);
        if (obj != null) {
            notifyItemChanged(i11, obj);
        }
        if (this.Y) {
            C4(i11, hVarG2, false);
        }
        if (zY2) {
            expand(i11);
        }
    }

    public final b<T> o4(boolean z10) {
        this.f27323a.d("Set notifyChangeOfUnfilteredItems=%s", Boolean.valueOf(z10));
        this.f27254j0 = z10;
        return this;
    }

    @Override // eu.davidea.flexibleadapter.c, androidx.recyclerview.widget.RecyclerView.g
    @g.i
    public void onAttachedToRecyclerView(@n0 RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f27323a.e("Attached Adapter to RecyclerView", new Object[0]);
        if (this.Y && j1()) {
            this.f27246b0.i(this.f27328f);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(@n0 RecyclerView.e0 e0Var, int i10) {
        onBindViewHolder(e0Var, i10, Collections.unmodifiableList(new ArrayList()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @n0
    public RecyclerView.e0 onCreateViewHolder(@n0 ViewGroup viewGroup, int i10) {
        ei.h hVarB2 = B2(i10);
        if (hVarB2 == null || !this.f27250f0) {
            throw new IllegalStateException(String.format("ViewType instance not found for viewType %s. You should implement the AutoMap properly.", Integer.valueOf(i10)));
        }
        if (this.f27248d0 == null) {
            this.f27248d0 = LayoutInflater.from(viewGroup.getContext());
        }
        return hVarB2.i(this.f27248d0.inflate(hVarB2.c(), viewGroup, false), this);
    }

    @Override // eu.davidea.flexibleadapter.c, androidx.recyclerview.widget.RecyclerView.g
    @g.i
    public void onDetachedFromRecyclerView(@n0 RecyclerView recyclerView) {
        if (j1()) {
            this.f27246b0.n();
            this.f27246b0 = null;
        }
        super.onDetachedFromRecyclerView(recyclerView);
        this.f27323a.e("Detached Adapter from RecyclerView", new Object[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @g.i
    public void onViewAttachedToWindow(@n0 RecyclerView.e0 e0Var) {
        int adapterPosition = e0Var.getAdapterPosition();
        ei.h hVarG2 = g2(adapterPosition);
        if (hVarG2 != null) {
            hVarG2.w(this, e0Var, adapterPosition);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    @g.i
    public void onViewDetachedFromWindow(@n0 RecyclerView.e0 e0Var) {
        int adapterPosition = e0Var.getAdapterPosition();
        ei.h hVarG2 = g2(adapterPosition);
        if (hVarG2 != null) {
            hVarG2.x(this, e0Var, adapterPosition);
        }
    }

    @Override // eu.davidea.flexibleadapter.c, androidx.recyclerview.widget.RecyclerView.g
    @g.i
    public void onViewRecycled(@n0 RecyclerView.e0 e0Var) {
        super.onViewRecycled(e0Var);
        if (j1()) {
            e0Var.itemView.setVisibility(0);
        }
        int adapterPosition = e0Var.getAdapterPosition();
        ei.h hVarG2 = g2(adapterPosition);
        if (hVarG2 != null) {
            hVarG2.n(this, e0Var, adapterPosition);
        }
    }

    public int p1(int i10) {
        return z3(0, this.A, i10);
    }

    public final int p2(@n0 ei.h hVar) {
        int i10 = -1;
        for (T t10 : this.A) {
            if (t10.q() == hVar.q()) {
                i10++;
                if (t10.equals(hVar)) {
                    break;
                }
            }
        }
        return i10;
    }

    public final void p3(int i10) {
        this.f27323a.d("noMoreLoad!", new Object[0]);
        int iD2 = d2(this.C0);
        if (iD2 >= 0) {
            notifyItemChanged(iD2, Payload.NO_MORE_LOAD);
        }
        s sVar = this.J0;
        if (sVar != null) {
            sVar.J(i10);
        }
    }

    public final b<T> p4(boolean z10) {
        this.f27323a.d("Set notifyMoveOfFilteredItems=%s", Boolean.valueOf(z10));
        this.f27256l0 = z10;
        return this;
    }

    public final boolean q1(List<T> list, ei.f fVar) {
        return list.contains(fVar) && list.removeAll(fVar.getSubItems());
    }

    @n0
    public final List<T> q2() {
        return Collections.unmodifiableList(this.X);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0036 A[PHI: r0
  0x0036: PHI (r0v6 int) = (r0v5 int), (r0v11 int) binds: [B:16:0x0034, B:12:0x001f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void q3(int r6) {
        /*
            r5 = this;
            boolean r0 = r5.V2()
            if (r0 == 0) goto L9d
            boolean r0 = r5.f27270z0
            if (r0 != 0) goto L9d
            ei.h r0 = r5.g2(r6)
            T extends ei.h r1 = r5.C0
            if (r0 != r1) goto L14
            goto L9d
        L14:
            boolean r0 = r5.B0
            r1 = 0
            if (r0 == 0) goto L29
            int r0 = r5.f27267w0
            boolean r2 = r5.C2()
            if (r2 == 0) goto L22
            goto L36
        L22:
            java.util.List<T extends ei.h> r2 = r5.W
            int r2 = r2.size()
            goto L3e
        L29:
            int r0 = r5.getItemCount()
            int r2 = r5.f27267w0
            int r0 = r0 - r2
            boolean r2 = r5.C2()
            if (r2 == 0) goto L38
        L36:
            r2 = 0
            goto L3e
        L38:
            java.util.List<T extends ei.h> r2 = r5.X
            int r2 = r2.size()
        L3e:
            int r0 = r0 - r2
            boolean r2 = r5.B0
            if (r2 != 0) goto L4d
            T extends ei.h r2 = r5.C0
            int r2 = r5.d2(r2)
            if (r6 == r2) goto L55
            if (r6 < r0) goto L55
        L4d:
            boolean r2 = r5.B0
            if (r2 == 0) goto L56
            if (r6 <= 0) goto L56
            if (r6 <= r0) goto L56
        L55:
            return
        L56:
            fi.c r3 = r5.f27323a
            r4 = 6
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r4[r1] = r2
            boolean r1 = r5.f27270z0
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r2 = 1
            r4[r2] = r1
            r1 = 2
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r4[r1] = r6
            r6 = 3
            int r1 = r5.getItemCount()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4[r6] = r1
            r6 = 4
            int r1 = r5.f27267w0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r4[r6] = r1
            r6 = 5
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r4[r6] = r0
            java.lang.String r6 = "onLoadMore     topEndless=%s, loading=%s, position=%s, itemCount=%s threshold=%s, currentThreshold=%s"
            r3.e(r6, r4)
            r5.f27270z0 = r2
            android.os.Handler r6 = r5.O
            eu.davidea.flexibleadapter.b$p r0 = new eu.davidea.flexibleadapter.b$p
            r0.<init>()
            r6.post(r0)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.davidea.flexibleadapter.b.q3(int):void");
    }

    public b<T> q4(boolean z10) {
        this.f27323a.d("Set permanentDelete=%s", Boolean.valueOf(z10));
        this.U = z10;
        return this;
    }

    public void r1() {
        this.f27323a.a("confirmDeletion!", new Object[0]);
        List<T> list = this.C;
        if (list != null) {
            list.removeAll(R1());
        }
        v1();
    }

    @n0
    public final List<T> r2() {
        return Collections.unmodifiableList(this.W);
    }

    public void r3(@p0 List<T> list) {
        s3(list, 0L);
    }

    public b<T> r4(boolean z10) {
        this.f27323a.d("Set setAutoCollapseSubLevels=%s", Boolean.valueOf(z10));
        this.f27262r0 = z10;
        return this;
    }

    public boolean s1(@p0 T t10) {
        return t10 != null && this.A.contains(t10);
    }

    public ei.i s2(@g.f0(from = 0) int i10) {
        if (!this.Y) {
            return null;
        }
        while (i10 >= 0) {
            ei.h hVarG2 = g2(i10);
            if (b3(hVarG2)) {
                return (ei.i) hVarG2;
            }
            i10--;
        }
        return null;
    }

    public void s3(@p0 List<T> list, @g.f0(from = -1) long j10) {
        int i10;
        this.f27270z0 = false;
        int size = list == null ? 0 : list.size();
        int iL2 = l2() + size;
        int iD2 = d2(this.C0);
        int i11 = this.f27269y0;
        if ((i11 > 0 && size < i11) || ((i10 = this.f27268x0) > 0 && iL2 >= i10)) {
            d4(null);
        }
        if (j10 > 0 && (size == 0 || !V2())) {
            this.f27323a.e("onLoadMore     enqueued removing progressItem (%sms)", Long.valueOf(j10));
            this.O.sendEmptyMessageDelayed(8, j10);
        } else if (j10 >= 0) {
            L2();
        }
        if (size > 0) {
            this.f27323a.a("onLoadMore     performing adding %s new items on page=%s", Integer.valueOf(size), Integer.valueOf(S1()));
            if (this.B0) {
                iD2 = this.W.size();
            }
            O0(iD2, list);
        }
        if (size == 0 || !V2()) {
            p3(size);
        }
    }

    public b<T> s4(boolean z10) {
        this.f27323a.d("Set restoreSelectionOnUndo=%s", Boolean.valueOf(z10));
        this.R = z10;
        return this;
    }

    public final void t1(int i10, T t10) {
        ei.f fVarX1;
        if (Y2(t10)) {
            collapse(i10);
        }
        ei.h hVarG2 = g2(i10 - 1);
        if (hVarG2 != null && (fVarX1 = X1(hVarG2)) != null) {
            hVarG2 = fVarX1;
        }
        this.P.add(new f0(this, hVarG2, t10));
        fi.c cVar = this.f27323a;
        List<b<T>.f0> list = this.P;
        cVar.e("Recycled Item %s on position=%s", list.get(list.size() - 1), Integer.valueOf(i10));
    }

    @n0
    public List<Integer> t2(@n0 ei.i iVar) {
        ArrayList arrayList = new ArrayList();
        int iD2 = d2(iVar) + 1;
        ei.h hVarG2 = g2(iD2);
        while (F2(hVarG2, iVar)) {
            arrayList.add(Integer.valueOf(iD2));
            iD2++;
            hVarG2 = g2(iD2);
        }
        return arrayList;
    }

    @g.i
    public void t3() {
        y yVar = this.G0;
        if (yVar != null) {
            yVar.a(l2());
        }
    }

    public b<T> t4(@g.f0(from = 0) int i10) {
        this.f27245a0 = i10;
        return this;
    }

    public final void u1(ei.f fVar, T t10) {
        this.P.add(new f0(fVar, t10, V1(fVar, false).indexOf(t10)));
        fi.c cVar = this.f27323a;
        List<b<T>.f0> list = this.P;
        cVar.e("Recycled SubItem %s with Parent position=%s", list.get(list.size() - 1), Integer.valueOf(d2(fVar)));
    }

    @n0
    public List<ei.k> u2(@n0 ei.i iVar) {
        ArrayList arrayList = new ArrayList();
        int iD2 = d2(iVar) + 1;
        ei.h hVarG2 = g2(iD2);
        while (F2(hVarG2, iVar)) {
            arrayList.add((ei.k) hVarG2);
            iD2++;
            hVarG2 = g2(iD2);
        }
        return arrayList;
    }

    @g.i
    public void u3() {
        e0 e0Var = this.F0;
        if (e0Var != null) {
            e0Var.m0(l2());
        }
    }

    public b<T> u4(boolean z10) {
        return v4(z10, this.f27247c0);
    }

    public synchronized void v1() {
        this.f27323a.a("emptyBin!", new Object[0]);
        this.P.clear();
        this.Q.clear();
    }

    @n0
    public List<T> v2(@n0 T t10) {
        ei.f fVarX1 = X1(t10);
        return fVarX1 != null ? fVarX1.getSubItems() : new ArrayList();
    }

    public final void v3(int i10, List<T> list, boolean z10) {
        int itemCount = getItemCount();
        if (i10 < itemCount) {
            this.A.addAll(i10, list);
        } else {
            this.A.addAll(list);
            i10 = itemCount;
        }
        if (z10) {
            this.f27323a.a("addItems on position=%s itemCount=%s", Integer.valueOf(i10), Integer.valueOf(list.size()));
            notifyItemRangeInserted(i10, list.size());
        }
    }

    public b<T> v4(boolean z10, @p0 ViewGroup viewGroup) {
        fi.c cVar = this.f27323a;
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z10);
        objArr[1] = viewGroup != null ? " with user defined Sticky Container" : "";
        cVar.d("Set stickyHeaders=%s (in Post!)%s", objArr);
        this.f27247c0 = viewGroup;
        this.O.post(new l(z10));
        return this;
    }

    public final void w1() {
        if (j1()) {
            this.f27246b0.o();
        }
    }

    public int w2() {
        return this.f27245a0;
    }

    public final void w3(T t10, boolean z10) {
        boolean z11 = this.U;
        if (z10) {
            this.U = true;
        }
        E3(d2(t10));
        this.U = z11;
    }

    public final b<T> w4(boolean z10) {
        this.f27323a.d("Set swipeEnabled=%s", Boolean.valueOf(z10));
        M2();
        this.f27265u0.g(z10);
        return this;
    }

    public final synchronized void x1(Payload payload) {
        if (this.J != null) {
            this.f27323a.d("Dispatching notifications", new Object[0]);
            this.A = this.K.a();
            this.J.g(this);
            this.J = null;
        } else {
            this.f27323a.d("Performing %s notifications", Integer.valueOf(this.E.size()));
            this.A = this.B;
            e0(false);
            for (v vVar : this.E) {
                int i10 = vVar.f27321c;
                if (i10 == 1) {
                    notifyItemInserted(vVar.f27320b);
                } else if (i10 == 2) {
                    notifyItemChanged(vVar.f27320b, payload);
                } else if (i10 == 3) {
                    notifyItemRemoved(vVar.f27320b);
                } else if (i10 != 4) {
                    this.f27323a.f("notifyDataSetChanged!", new Object[0]);
                    notifyDataSetChanged();
                } else {
                    notifyItemMoved(vVar.f27319a, vVar.f27320b);
                }
            }
            this.B = null;
            this.E = null;
            e0(true);
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.G;
        this.H = jCurrentTimeMillis;
        this.f27323a.d("Animate changes DONE in %sms", Long.valueOf(jCurrentTimeMillis));
    }

    public final int x2() {
        if (j1()) {
            return this.f27246b0.r();
        }
        return -1;
    }

    public final void x3(int i10) {
        RecyclerView recyclerView = this.f27328f;
        if (recyclerView != null) {
            recyclerView.L1(Math.min(Math.max(0, i10), getItemCount() - 1));
        }
    }

    public void x4(boolean z10) {
        this.B0 = z10;
    }

    public final int y1(int i10, boolean z10, boolean z11, boolean z12) {
        ei.h hVarG2 = g2(i10);
        if (!W2(hVarG2)) {
            return 0;
        }
        ei.f fVar = (ei.f) hVarG2;
        if (!G2(fVar)) {
            fVar.setExpanded(false);
            this.f27323a.f("No subItems to Expand on position %s expanded %s", Integer.valueOf(i10), Boolean.valueOf(fVar.isExpanded()));
            return 0;
        }
        if (!z11 && !z10) {
            this.f27323a.e("Request to Expand on position=%s expanded=%s anyParentSelected=%s", Integer.valueOf(i10), Boolean.valueOf(fVar.isExpanded()), Boolean.valueOf(this.f27264t0));
        }
        if (!z11) {
            if (fVar.isExpanded()) {
                return 0;
            }
            if (this.f27264t0 && fVar.l() > this.f27259o0) {
                return 0;
            }
        }
        if (this.f27261q0 && !z10 && p1(this.f27258n0) > 0) {
            i10 = d2(hVarG2);
        }
        List<T> listV1 = V1(fVar, true);
        int i11 = i10 + 1;
        this.A.addAll(i11, listV1);
        int size = listV1.size();
        fVar.setExpanded(true);
        if (!z11 && this.f27260p0 && !z10) {
            k1(i10, size);
        }
        if (z12) {
            notifyItemChanged(i10, Payload.EXPANDED);
        }
        notifyItemRangeInserted(i11, size);
        if (!z11 && this.Y) {
            Iterator<T> it2 = listV1.iterator();
            int i12 = 0;
            while (it2.hasNext()) {
                i12++;
                if (C4(i10 + i12, it2.next(), false)) {
                    i12++;
                }
            }
        }
        if (!E1(this.W, fVar)) {
            E1(this.X, fVar);
        }
        fi.c cVar = this.f27323a;
        Object[] objArr = new Object[3];
        objArr[0] = z11 ? "Initially expanded" : "Expanded";
        objArr[1] = Integer.valueOf(size);
        objArr[2] = Integer.valueOf(i10);
        cVar.e("%s %s subItems on position=%s", objArr);
        return size;
    }

    public int y2(@n0 T t10) {
        if ((t10 instanceof ei.k) && D2(t10)) {
            if (!(f2(t10) instanceof ei.f)) {
                return (d2(t10) - d2(r0)) - 1;
            }
        }
        return v2(t10).indexOf(t10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r3v3, types: [ei.h, ei.i, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List, java.util.List<T extends ei.h>] */
    public final void y3(List<T> list) {
        if (this.f27254j0) {
            o();
        }
        U3(list);
        ?? r02 = 0;
        int i10 = 0;
        while (i10 < list.size()) {
            ei.h hVar = (ei.h) list.get(i10);
            if (Y2(hVar)) {
                ei.f fVar = (ei.f) hVar;
                fVar.setExpanded(true);
                List<T> listV1 = V1(fVar, false);
                if (i10 < list.size()) {
                    list.addAll(i10 + 1, listV1);
                } else {
                    list.addAll(listV1);
                }
            }
            if (!this.Y && b3(hVar) && !hVar.d()) {
                this.Y = true;
            }
            ?? F2 = f2(hVar);
            if (F2 != 0 && !F2.equals(r02) && !W2(F2)) {
                F2.f(false);
                list.add(i10, F2);
                i10++;
                r02 = F2;
            }
            i10++;
            r02 = r02;
        }
    }

    public b<T> y4(boolean z10) {
        this.f27323a.d("Set unlinkOnRemoveHeader=%s", Boolean.valueOf(z10));
        this.T = z10;
        return this;
    }

    public int z1(T t10) {
        return y1(d2(t10), false, false, true);
    }

    public long z2() {
        return this.H;
    }

    public final int z3(int i10, List<T> list, int i11) {
        int i12 = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            T t10 = list.get(size);
            if (Y2(t10) && ((ei.f) t10).l() >= i11 && collapse(i10 + size, true) > 0) {
                i12++;
            }
        }
        return i12;
    }

    public b<T> z4() {
        A4(false);
        return this;
    }

    public b(@p0 List<T> list, @p0 Object obj) {
        this(list, obj, false);
    }

    public int collapse(@g.f0(from = 0) int i10, boolean z10) {
        ei.h hVarG2 = g2(i10);
        if (!W2(hVarG2)) {
            return 0;
        }
        ei.f fVar = (ei.f) hVarG2;
        List<T> listV1 = V1(fVar, true);
        int size = listV1.size();
        this.f27323a.e("Request to Collapse on position=%s expanded=%s hasSubItemsSelected=%s", Integer.valueOf(i10), Boolean.valueOf(fVar.isExpanded()), Boolean.valueOf(H2(i10, listV1)));
        if (fVar.isExpanded() && size > 0 && (!H2(i10, listV1) || n2(hVarG2) != null)) {
            if (this.f27262r0) {
                z3(i10 + 1, listV1, fVar.l());
            }
            this.A.removeAll(listV1);
            size = listV1.size();
            fVar.setExpanded(false);
            if (z10) {
                notifyItemChanged(i10, Payload.COLLAPSED);
            }
            notifyItemRangeRemoved(i10 + 1, size);
            if (this.Y && !b3(hVarG2)) {
                Iterator<T> it2 = listV1.iterator();
                while (it2.hasNext()) {
                    K2(it2.next());
                }
            }
            if (!q1(this.W, fVar)) {
                q1(this.X, fVar);
            }
            this.f27323a.e("Collapsed %s subItems on position %s", Integer.valueOf(size), Integer.valueOf(i10));
        }
        return size;
    }

    public int expand(@g.f0(from = 0) int i10, boolean z10) {
        return y1(i10, false, false, z10);
    }

    @Override // eu.davidea.flexibleadapter.c, androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(@n0 RecyclerView.e0 e0Var, int i10, @n0 List list) {
        if (!this.f27250f0) {
            throw new IllegalStateException("AutoMap is not active, this method cannot be called. You should implement the AutoMap properly.");
        }
        super.onBindViewHolder(e0Var, i10, list);
        ei.h hVarG2 = g2(i10);
        if (hVarG2 != null) {
            e0Var.itemView.setEnabled(hVarG2.isEnabled());
            hVarG2.o(this, e0Var, i10, list);
            if (j1() && b3(hVarG2) && !this.f27330h && this.f27246b0.r() >= 0 && list.isEmpty() && s().b() - 1 == i10) {
                e0Var.itemView.setVisibility(4);
            }
        }
        q3(i10);
        P(e0Var, i10);
    }

    public static class v {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f27315d = 1;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f27316e = 2;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f27317f = 3;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f27318g = 4;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f27319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f27320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f27321c;

        public v(int i10, int i11) {
            this.f27320b = i10;
            this.f27321c = i11;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Notification{operation=");
            sb2.append(this.f27321c);
            if (this.f27321c == 4) {
                str = ", fromPosition=" + this.f27319a;
            } else {
                str = "";
            }
            sb2.append(str);
            sb2.append(", position=");
            sb2.append(this.f27320b);
            sb2.append('}');
            return sb2.toString();
        }

        public v(int i10, int i11, int i12) {
            this(i11, i12);
            this.f27319a = i10;
        }
    }

    public b(@p0 List<T> list, @p0 Object obj, boolean z10) {
        super(z10);
        this.I = false;
        this.L = 1;
        this.M = 2;
        this.N = 8;
        this.O = new Handler(Looper.getMainLooper(), new u());
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = true;
        this.V = true;
        this.Y = false;
        this.Z = false;
        this.f27249e0 = new HashMap<>();
        this.f27250f0 = false;
        h hVar = null;
        this.f27251g0 = null;
        this.f27252h0 = "";
        this.f27254j0 = true;
        this.f27255k0 = false;
        this.f27256l0 = false;
        this.f27257m0 = U0;
        this.f27258n0 = 0;
        this.f27259o0 = -1;
        this.f27260p0 = false;
        this.f27261q0 = false;
        this.f27262r0 = false;
        this.f27263s0 = false;
        this.f27264t0 = false;
        this.f27267w0 = 1;
        this.f27268x0 = 0;
        this.f27269y0 = 0;
        this.f27270z0 = false;
        this.A0 = false;
        this.B0 = false;
        if (list == null) {
            this.A = new ArrayList();
        } else {
            this.A = new ArrayList(list);
        }
        this.W = new ArrayList();
        this.X = new ArrayList();
        this.P = new ArrayList();
        this.Q = new ArrayList();
        if (obj != null) {
            P0(obj);
        }
        registerAdapterDataObserver(new q(this, hVar));
    }
}

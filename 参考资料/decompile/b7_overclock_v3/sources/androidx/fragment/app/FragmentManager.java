package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.annotation.RestrictTo;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.g0;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.d1;
import androidx.savedstate.b;
import com.bumptech.glide.load.engine.GlideException;
import f.b;
import g.c1;
import g.p0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class FragmentManager implements c0 {
    public static final String S = "android:support:fragments";
    public static final String T = "state";
    public static final String U = "result_";
    public static final String V = "state";
    public static final String W = "fragment_";
    public static boolean X = false;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final String Y = "FragmentManager";
    public static final int Z = 1;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public static final String f5717a0 = "androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE";
    public androidx.activity.result.g<Intent> D;
    public androidx.activity.result.g<IntentSenderRequest> E;
    public androidx.activity.result.g<String[]> F;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public boolean L;
    public ArrayList<androidx.fragment.app.a> M;
    public ArrayList<Boolean> N;
    public ArrayList<Fragment> O;
    public y P;
    public FragmentStrictMode.b Q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5719b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ArrayList<androidx.fragment.app.a> f5721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ArrayList<Fragment> f5722e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OnBackPressedDispatcher f5724g;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ArrayList<o> f5730m;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public androidx.fragment.app.l<?> f5739v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public androidx.fragment.app.i f5740w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Fragment f5741x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @p0
    public Fragment f5742y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<p> f5718a = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0 f5720c = new f0();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.fragment.app.o f5723f = new androidx.fragment.app.o(this);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.activity.n f5725h = new b(false);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicInteger f5726i = new AtomicInteger();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, BackStackState> f5727j = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Map<String, Bundle> f5728k = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Map<String, n> f5729l = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final androidx.fragment.app.p f5731n = new androidx.fragment.app.p(this);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final CopyOnWriteArrayList<z> f5732o = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final androidx.core.util.d<Configuration> f5733p = new androidx.core.util.d() { // from class: androidx.fragment.app.q
        @Override // androidx.core.util.d
        public final void accept(Object obj) {
            this.f6027a.f1((Configuration) obj);
        }
    };

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final androidx.core.util.d<Integer> f5734q = new androidx.core.util.d() { // from class: androidx.fragment.app.t
        @Override // androidx.core.util.d
        public final void accept(Object obj) {
            this.f6041a.g1((Integer) obj);
        }
    };

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final androidx.core.util.d<f0.q> f5735r = new androidx.core.util.d() { // from class: androidx.fragment.app.r
        @Override // androidx.core.util.d
        public final void accept(Object obj) {
            this.f6028a.h1((f0.q) obj);
        }
    };

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final androidx.core.util.d<f0.g0> f5736s = new androidx.core.util.d() { // from class: androidx.fragment.app.s
        @Override // androidx.core.util.d
        public final void accept(Object obj) {
            this.f6029a.i1((f0.g0) obj);
        }
    };

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final androidx.core.view.a0 f5737t = new c();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f5738u = -1;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public androidx.fragment.app.k f5743z = null;
    public androidx.fragment.app.k A = new d();
    public n0 B = null;
    public n0 C = new e();
    public ArrayDeque<LaunchedFragmentInfo> G = new ArrayDeque<>();
    public Runnable R = new f();

    public class a implements androidx.activity.result.a<Map<String, Boolean>> {
        public a() {
        }

        @Override // androidx.activity.result.a
        @SuppressLint({"SyntheticAccessor"})
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map<String, Boolean> map) {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map.values());
            int[] iArr = new int[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                iArr[i10] = ((Boolean) arrayList.get(i10)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.G.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No permissions were requested for ");
                sb2.append(this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f5748a;
            int i11 = launchedFragmentInfoPollFirst.f5749b;
            Fragment fragmentI = FragmentManager.this.f5720c.i(str);
            if (fragmentI != null) {
                fragmentI.e4(i11, strArr, iArr);
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Permission request result delivered for unknown Fragment ");
            sb3.append(str);
        }
    }

    public class b extends androidx.activity.n {
        public b(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.n
        public void c() {
            FragmentManager.this.S0();
        }
    }

    public class c implements androidx.core.view.a0 {
        public c() {
        }

        @Override // androidx.core.view.a0
        public boolean a(@g.n0 MenuItem menuItem) {
            return FragmentManager.this.R(menuItem);
        }

        @Override // androidx.core.view.a0
        public void b(@g.n0 Menu menu) {
            FragmentManager.this.S(menu);
        }

        @Override // androidx.core.view.a0
        public void c(@g.n0 Menu menu, @g.n0 MenuInflater menuInflater) {
            FragmentManager.this.K(menu, menuInflater);
        }

        @Override // androidx.core.view.a0
        public void d(@g.n0 Menu menu) {
            FragmentManager.this.W(menu);
        }
    }

    public class d extends androidx.fragment.app.k {
        public d() {
        }

        @Override // androidx.fragment.app.k
        @g.n0
        public Fragment a(@g.n0 ClassLoader classLoader, @g.n0 String str) {
            return FragmentManager.this.J0().b(FragmentManager.this.J0().g(), str, null);
        }
    }

    public class e implements n0 {
        public e() {
        }

        @Override // androidx.fragment.app.n0
        @g.n0
        public SpecialEffectsController a(@g.n0 ViewGroup viewGroup) {
            return new androidx.fragment.app.b(viewGroup);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentManager.this.j0(true);
        }
    }

    public class g implements z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Fragment f5756a;

        public g(Fragment fragment) {
            this.f5756a = fragment;
        }

        @Override // androidx.fragment.app.z
        public void a(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment) {
            this.f5756a.I3(fragment);
        }
    }

    public class h implements androidx.activity.result.a<ActivityResult> {
        public h() {
        }

        @Override // androidx.activity.result.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.G.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No Activities were started for result for ");
                sb2.append(this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f5748a;
            int i10 = launchedFragmentInfoPollFirst.f5749b;
            Fragment fragmentI = FragmentManager.this.f5720c.i(str);
            if (fragmentI != null) {
                fragmentI.F3(i10, activityResult.b(), activityResult.a());
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Activity result delivered for unknown Fragment ");
            sb3.append(str);
        }
    }

    public class i implements androidx.activity.result.a<ActivityResult> {
        public i() {
        }

        @Override // androidx.activity.result.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ActivityResult activityResult) {
            LaunchedFragmentInfo launchedFragmentInfoPollFirst = FragmentManager.this.G.pollFirst();
            if (launchedFragmentInfoPollFirst == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("No IntentSenders were started for ");
                sb2.append(this);
                return;
            }
            String str = launchedFragmentInfoPollFirst.f5748a;
            int i10 = launchedFragmentInfoPollFirst.f5749b;
            Fragment fragmentI = FragmentManager.this.f5720c.i(str);
            if (fragmentI != null) {
                fragmentI.F3(i10, activityResult.b(), activityResult.a());
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Intent Sender result delivered for unknown Fragment ");
            sb3.append(str);
        }
    }

    public interface j {
        @p0
        @Deprecated
        CharSequence a();

        @c1
        @Deprecated
        int c();

        @c1
        @Deprecated
        int d();

        @p0
        @Deprecated
        CharSequence e();

        int getId();

        @p0
        String getName();
    }

    public class k implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5760a;

        public k(@g.n0 String str) {
            this.f5760a = str;
        }

        @Override // androidx.fragment.app.FragmentManager.p
        public boolean b(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, @g.n0 ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.z(arrayList, arrayList2, this.f5760a);
        }
    }

    public static class l extends f.a<IntentSenderRequest, ActivityResult> {
        @Override // f.a
        @g.n0
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Intent a(@g.n0 Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            Intent intent = new Intent(b.n.f27358b);
            Intent intentA = intentSenderRequest.a();
            if (intentA != null && (bundleExtra = intentA.getBundleExtra(b.m.f27356b)) != null) {
                intent.putExtra(b.m.f27356b, bundleExtra);
                intentA.removeExtra(b.m.f27356b);
                if (intentA.getBooleanExtra(FragmentManager.f5717a0, false)) {
                    intentSenderRequest = new IntentSenderRequest.a(intentSenderRequest.g()).b(null).c(intentSenderRequest.e(), intentSenderRequest.b()).a();
                }
            }
            intent.putExtra(b.n.f27359c, intentSenderRequest);
            if (FragmentManager.W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("CreateIntent created the following intent: ");
                sb2.append(intent);
            }
            return intent;
        }

        @Override // f.a
        @g.n0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ActivityResult c(int i10, @p0 Intent intent) {
            return new ActivityResult(i10, intent);
        }
    }

    public static abstract class m {
        @Deprecated
        public void a(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @p0 Bundle bundle) {
        }

        public void b(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.n0 Context context) {
        }

        public void c(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @p0 Bundle bundle) {
        }

        public void d(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment) {
        }

        public void e(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment) {
        }

        public void f(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment) {
        }

        public void g(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.n0 Context context) {
        }

        public void h(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @p0 Bundle bundle) {
        }

        public void i(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment) {
        }

        public void j(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.n0 Bundle bundle) {
        }

        public void k(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment) {
        }

        public void l(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment) {
        }

        public void m(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment, @g.n0 View view, @p0 Bundle bundle) {
        }

        public void n(@g.n0 FragmentManager fragmentManager, @g.n0 Fragment fragment) {
        }
    }

    public static class n implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lifecycle f5762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b0 f5763b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.lifecycle.v f5764c;

        public n(@g.n0 Lifecycle lifecycle, @g.n0 b0 b0Var, @g.n0 androidx.lifecycle.v vVar) {
            this.f5762a = lifecycle;
            this.f5763b = b0Var;
            this.f5764c = vVar;
        }

        @Override // androidx.fragment.app.b0
        public void a(@g.n0 String str, @g.n0 Bundle bundle) {
            this.f5763b.a(str, bundle);
        }

        public boolean b(Lifecycle.State state) {
            return this.f5762a.b().isAtLeast(state);
        }

        public void c() {
            this.f5762a.d(this.f5764c);
        }
    }

    public interface o {
        @g.k0
        void a();
    }

    public interface p {
        boolean b(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, @g.n0 ArrayList<Boolean> arrayList2);
    }

    public class q implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5765a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5766b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f5767c;

        public q(@p0 String str, int i10, int i11) {
            this.f5765a = str;
            this.f5766b = i10;
            this.f5767c = i11;
        }

        @Override // androidx.fragment.app.FragmentManager.p
        public boolean b(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, @g.n0 ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.f5742y;
            if (fragment == null || this.f5766b >= 0 || this.f5765a != null || !fragment.U1().v1()) {
                return FragmentManager.this.z1(arrayList, arrayList2, this.f5765a, this.f5766b, this.f5767c);
            }
            return false;
        }
    }

    public class r implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5769a;

        public r(@g.n0 String str) {
            this.f5769a = str;
        }

        @Override // androidx.fragment.app.FragmentManager.p
        public boolean b(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, @g.n0 ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.K1(arrayList, arrayList2, this.f5769a);
        }
    }

    public class s implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5771a;

        public s(@g.n0 String str) {
            this.f5771a = str;
        }

        @Override // androidx.fragment.app.FragmentManager.p
        public boolean b(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, @g.n0 ArrayList<Boolean> arrayList2) {
            return FragmentManager.this.S1(arrayList, arrayList2, this.f5771a);
        }
    }

    public static int O1(int i10) {
        if (i10 == 4097) {
            return 8194;
        }
        if (i10 == 8194) {
            return 4097;
        }
        if (i10 == 8197) {
            return 4100;
        }
        if (i10 != 4099) {
            return i10 != 4100 ? 0 : 8197;
        }
        return 4099;
    }

    @p0
    public static Fragment Q0(@g.n0 View view) {
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean W0(int i10) {
        return X || Log.isLoggable("FragmentManager", i10);
    }

    @Deprecated
    public static void f0(boolean z10) {
        X = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f1(Configuration configuration) {
        if (Y0()) {
            H(configuration, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g1(Integer num) {
        if (Y0() && num.intValue() == 80) {
            N(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h1(f0.q qVar) {
        if (Y0()) {
            O(qVar.b(), false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i1(f0.g0 g0Var) {
        if (Y0()) {
            V(g0Var.b(), false);
        }
    }

    public static void l0(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, @g.n0 ArrayList<Boolean> arrayList2, int i10, int i11) {
        while (i10 < i11) {
            androidx.fragment.app.a aVar = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue()) {
                aVar.U(-1);
                aVar.a0();
            } else {
                aVar.U(1);
                aVar.Z();
            }
            i10++;
        }
    }

    @g.n0
    public static <F extends Fragment> F q0(@g.n0 View view) {
        F f10 = (F) v0(view);
        if (f10 != null) {
            return f10;
        }
        throw new IllegalStateException("View " + view + " does not have a Fragment set");
    }

    @g.n0
    public static FragmentManager u0(@g.n0 View view) {
        Fragment fragmentV0 = v0(view);
        if (fragmentV0 != null) {
            if (fragmentV0.s3()) {
                return fragmentV0.U1();
            }
            throw new IllegalStateException("The Fragment " + fragmentV0 + " that owns View " + view + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
        }
        Context context = view.getContext();
        androidx.fragment.app.g gVar = null;
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                break;
            }
            if (context instanceof androidx.fragment.app.g) {
                gVar = (androidx.fragment.app.g) context;
                break;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (gVar != null) {
            return gVar.n3();
        }
        throw new IllegalStateException("View " + view + " is not within a subclass of FragmentActivity.");
    }

    @p0
    public static Fragment v0(@g.n0 View view) {
        while (view != null) {
            Fragment fragmentQ0 = Q0(view);
            if (fragmentQ0 != null) {
                return fragmentQ0;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    public final void A() {
        androidx.fragment.app.l<?> lVar = this.f5739v;
        boolean zIsChangingConfigurations = true;
        if (lVar instanceof d1) {
            zIsChangingConfigurations = this.f5720c.q().r();
        } else if (lVar.g() instanceof Activity) {
            zIsChangingConfigurations = true ^ ((Activity) this.f5739v.g()).isChangingConfigurations();
        }
        if (zIsChangingConfigurations) {
            Iterator<BackStackState> it2 = this.f5727j.values().iterator();
            while (it2.hasNext()) {
                Iterator<String> it3 = it2.next().f5607a.iterator();
                while (it3.hasNext()) {
                    this.f5720c.q().i(it3.next());
                }
            }
        }
    }

    @g.n0
    public j A0(int i10) {
        return this.f5721d.get(i10);
    }

    public void A1(@g.n0 Bundle bundle, @g.n0 String str, @g.n0 Fragment fragment) {
        if (fragment.f5662t != this) {
            e2(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        bundle.putString(str, fragment.f5646f);
    }

    public final Set<SpecialEffectsController> B() {
        HashSet hashSet = new HashSet();
        Iterator<d0> it2 = this.f5720c.l().iterator();
        while (it2.hasNext()) {
            ViewGroup viewGroup = it2.next().k().f5665v1;
            if (viewGroup != null) {
                hashSet.add(SpecialEffectsController.o(viewGroup, O0()));
            }
        }
        return hashSet;
    }

    public int B0() {
        ArrayList<androidx.fragment.app.a> arrayList = this.f5721d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public void B1(@g.n0 m mVar, boolean z10) {
        this.f5731n.o(mVar, z10);
    }

    public final Set<SpecialEffectsController> C(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, int i10, int i11) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i10 < i11) {
            Iterator<g0.a> it2 = arrayList.get(i10).f5947c.iterator();
            while (it2.hasNext()) {
                Fragment fragment = it2.next().f5965b;
                if (fragment != null && (viewGroup = fragment.f5665v1) != null) {
                    hashSet.add(SpecialEffectsController.n(viewGroup, this));
                }
            }
            i10++;
        }
        return hashSet;
    }

    @g.n0
    public final y C0(@g.n0 Fragment fragment) {
        return this.P.l(fragment);
    }

    public void C1(@g.n0 Fragment fragment) {
        if (W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("remove: ");
            sb2.append(fragment);
            sb2.append(" nesting=");
            sb2.append(fragment.f5661s);
        }
        boolean z10 = !fragment.v3();
        if (!fragment.B || z10) {
            this.f5720c.v(fragment);
            if (X0(fragment)) {
                this.H = true;
            }
            fragment.f5655m = true;
            b2(fragment);
        }
    }

    @g.n0
    public d0 D(@g.n0 Fragment fragment) {
        d0 d0VarO = this.f5720c.o(fragment.f5646f);
        if (d0VarO != null) {
            return d0VarO;
        }
        d0 d0Var = new d0(this.f5731n, this.f5720c, fragment);
        d0Var.o(this.f5739v.g().getClassLoader());
        d0Var.u(this.f5738u);
        return d0Var;
    }

    @g.n0
    public androidx.fragment.app.i D0() {
        return this.f5740w;
    }

    public void D1(@g.n0 z zVar) {
        this.f5732o.remove(zVar);
    }

    public void E(@g.n0 Fragment fragment) {
        if (W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("detach: ");
            sb2.append(fragment);
        }
        if (fragment.B) {
            return;
        }
        fragment.B = true;
        if (fragment.f5654l) {
            if (W0(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("remove from detach: ");
                sb3.append(fragment);
            }
            this.f5720c.v(fragment);
            if (X0(fragment)) {
                this.H = true;
            }
            b2(fragment);
        }
    }

    @p0
    public Fragment E0(@g.n0 Bundle bundle, @g.n0 String str) {
        String string = bundle.getString(str);
        if (string == null) {
            return null;
        }
        Fragment fragmentO0 = o0(string);
        if (fragmentO0 == null) {
            e2(new IllegalStateException("Fragment no longer exists for key " + str + ": unique id " + string));
        }
        return fragmentO0;
    }

    public void E1(@g.n0 o oVar) {
        ArrayList<o> arrayList = this.f5730m;
        if (arrayList != null) {
            arrayList.remove(oVar);
        }
    }

    public void F() {
        this.I = false;
        this.J = false;
        this.P.u(false);
        a0(4);
    }

    public final ViewGroup F0(@g.n0 Fragment fragment) {
        ViewGroup viewGroup = fragment.f5665v1;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.f5669y > 0 && this.f5740w.d()) {
            View viewC = this.f5740w.c(fragment.f5669y);
            if (viewC instanceof ViewGroup) {
                return (ViewGroup) viewC;
            }
        }
        return null;
    }

    public final void F1(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, @g.n0 ArrayList<Boolean> arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            if (!arrayList.get(i10).f5962r) {
                if (i11 != i10) {
                    m0(arrayList, arrayList2, i11, i10);
                }
                i11 = i10 + 1;
                if (arrayList2.get(i10).booleanValue()) {
                    while (i11 < size && arrayList2.get(i11).booleanValue() && !arrayList.get(i11).f5962r) {
                        i11++;
                    }
                }
                m0(arrayList, arrayList2, i10, i11);
                i10 = i11 - 1;
            }
            i10++;
        }
        if (i11 != size) {
            m0(arrayList, arrayList2, i11, size);
        }
    }

    public void G() {
        this.I = false;
        this.J = false;
        this.P.u(false);
        a0(0);
    }

    @g.n0
    public androidx.fragment.app.k G0() {
        androidx.fragment.app.k kVar = this.f5743z;
        if (kVar != null) {
            return kVar;
        }
        Fragment fragment = this.f5741x;
        return fragment != null ? fragment.f5662t.G0() : this.A;
    }

    public void G1(@g.n0 Fragment fragment) {
        this.P.s(fragment);
    }

    public void H(@g.n0 Configuration configuration, boolean z10) {
        if (z10 && (this.f5739v instanceof h0.e0)) {
            e2(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
        }
        for (Fragment fragment : this.f5720c.p()) {
            if (fragment != null) {
                fragment.n4(configuration);
                if (z10) {
                    fragment.f5664v.H(configuration, true);
                }
            }
        }
    }

    @g.n0
    public f0 H0() {
        return this.f5720c;
    }

    public final void H1() {
        if (this.f5730m != null) {
            for (int i10 = 0; i10 < this.f5730m.size(); i10++) {
                this.f5730m.get(i10).a();
            }
        }
    }

    public boolean I(@g.n0 MenuItem menuItem) {
        if (this.f5738u < 1) {
            return false;
        }
        for (Fragment fragment : this.f5720c.p()) {
            if (fragment != null && fragment.o4(menuItem)) {
                return true;
            }
        }
        return false;
    }

    @g.n0
    public List<Fragment> I0() {
        return this.f5720c.p();
    }

    public void I1(@p0 Parcelable parcelable, @p0 x xVar) {
        if (this.f5739v instanceof d1) {
            e2(new IllegalStateException("You must use restoreSaveState when your FragmentHostCallback implements ViewModelStoreOwner"));
        }
        this.P.t(xVar);
        M1(parcelable);
    }

    public void J() {
        this.I = false;
        this.J = false;
        this.P.u(false);
        a0(1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @g.n0
    public androidx.fragment.app.l<?> J0() {
        return this.f5739v;
    }

    public void J1(@g.n0 String str) {
        h0(new r(str), false);
    }

    public boolean K(@g.n0 Menu menu, @g.n0 MenuInflater menuInflater) {
        if (this.f5738u < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z10 = false;
        for (Fragment fragment : this.f5720c.p()) {
            if (fragment != null && a1(fragment) && fragment.q4(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z10 = true;
            }
        }
        if (this.f5722e != null) {
            for (int i10 = 0; i10 < this.f5722e.size(); i10++) {
                Fragment fragment2 = this.f5722e.get(i10);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.Q3();
                }
            }
        }
        this.f5722e = arrayList;
        return z10;
    }

    @g.n0
    public LayoutInflater.Factory2 K0() {
        return this.f5723f;
    }

    public boolean K1(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, @g.n0 ArrayList<Boolean> arrayList2, @g.n0 String str) {
        boolean z10;
        BackStackState backStackStateRemove = this.f5727j.remove(str);
        if (backStackStateRemove == null) {
            return false;
        }
        HashMap map = new HashMap();
        for (androidx.fragment.app.a aVar : arrayList) {
            if (aVar.Q) {
                Iterator<g0.a> it2 = aVar.f5947c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment = it2.next().f5965b;
                    if (fragment != null) {
                        map.put(fragment.f5646f, fragment);
                    }
                }
            }
        }
        Iterator<androidx.fragment.app.a> it3 = backStackStateRemove.a(this, map).iterator();
        while (true) {
            while (it3.hasNext()) {
                z10 = it3.next().b(arrayList, arrayList2) || z10;
            }
            return z10;
        }
    }

    public void L() {
        this.K = true;
        j0(true);
        g0();
        A();
        a0(-1);
        Object obj = this.f5739v;
        if (obj instanceof h0.f0) {
            ((h0.f0) obj).b0(this.f5734q);
        }
        Object obj2 = this.f5739v;
        if (obj2 instanceof h0.e0) {
            ((h0.e0) obj2).g1(this.f5733p);
        }
        Object obj3 = this.f5739v;
        if (obj3 instanceof f0.b0) {
            ((f0.b0) obj3).L2(this.f5735r);
        }
        Object obj4 = this.f5739v;
        if (obj4 instanceof f0.d0) {
            ((f0.d0) obj4).a0(this.f5736s);
        }
        Object obj5 = this.f5739v;
        if ((obj5 instanceof androidx.core.view.t) && this.f5741x == null) {
            ((androidx.core.view.t) obj5).F(this.f5737t);
        }
        this.f5739v = null;
        this.f5740w = null;
        this.f5741x = null;
        if (this.f5724g != null) {
            this.f5725h.e();
            this.f5724g = null;
        }
        androidx.activity.result.g<Intent> gVar = this.D;
        if (gVar != null) {
            gVar.d();
            this.E.d();
            this.F.d();
        }
    }

    @g.n0
    public androidx.fragment.app.p L0() {
        return this.f5731n;
    }

    public void L1(@p0 Parcelable parcelable) {
        if (this.f5739v instanceof androidx.savedstate.d) {
            e2(new IllegalStateException("You cannot use restoreSaveState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        }
        M1(parcelable);
    }

    public void M() {
        a0(1);
    }

    @p0
    public Fragment M0() {
        return this.f5741x;
    }

    public void M1(@p0 Parcelable parcelable) {
        d0 d0Var;
        Bundle bundle;
        Bundle bundle2;
        if (parcelable == null) {
            return;
        }
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith(U) && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.f5739v.g().getClassLoader());
                this.f5728k.put(str.substring(7), bundle2);
            }
        }
        ArrayList<FragmentState> arrayList = new ArrayList<>();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith(W) && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.f5739v.g().getClassLoader());
                arrayList.add((FragmentState) bundle.getParcelable("state"));
            }
        }
        this.f5720c.y(arrayList);
        FragmentManagerState fragmentManagerState = (FragmentManagerState) bundle3.getParcelable("state");
        if (fragmentManagerState == null) {
            return;
        }
        this.f5720c.w();
        Iterator<String> it2 = fragmentManagerState.f5773a.iterator();
        while (it2.hasNext()) {
            FragmentState fragmentStateC = this.f5720c.C(it2.next(), null);
            if (fragmentStateC != null) {
                Fragment fragmentK = this.P.k(fragmentStateC.f5782b);
                if (fragmentK != null) {
                    if (W0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("restoreSaveState: re-attaching retained ");
                        sb2.append(fragmentK);
                    }
                    d0Var = new d0(this.f5731n, this.f5720c, fragmentK, fragmentStateC);
                } else {
                    d0Var = new d0(this.f5731n, this.f5720c, this.f5739v.g().getClassLoader(), G0(), fragmentStateC);
                }
                Fragment fragmentK2 = d0Var.k();
                fragmentK2.f5662t = this;
                if (W0(2)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("restoreSaveState: active (");
                    sb3.append(fragmentK2.f5646f);
                    sb3.append("): ");
                    sb3.append(fragmentK2);
                }
                d0Var.o(this.f5739v.g().getClassLoader());
                this.f5720c.s(d0Var);
                d0Var.u(this.f5738u);
            }
        }
        for (Fragment fragment : this.P.n()) {
            if (!this.f5720c.c(fragment.f5646f)) {
                if (W0(2)) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Discarding retained Fragment ");
                    sb4.append(fragment);
                    sb4.append(" that was not found in the set of active Fragments ");
                    sb4.append(fragmentManagerState.f5773a);
                }
                this.P.s(fragment);
                fragment.f5662t = this;
                d0 d0Var2 = new d0(this.f5731n, this.f5720c, fragment);
                d0Var2.u(1);
                d0Var2.m();
                fragment.f5655m = true;
                d0Var2.m();
            }
        }
        this.f5720c.x(fragmentManagerState.f5774b);
        if (fragmentManagerState.f5775c != null) {
            this.f5721d = new ArrayList<>(fragmentManagerState.f5775c.length);
            int i10 = 0;
            while (true) {
                BackStackRecordState[] backStackRecordStateArr = fragmentManagerState.f5775c;
                if (i10 >= backStackRecordStateArr.length) {
                    break;
                }
                androidx.fragment.app.a aVarB = backStackRecordStateArr[i10].b(this);
                if (W0(2)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("restoreAllState: back stack #");
                    sb5.append(i10);
                    sb5.append(" (index ");
                    sb5.append(aVarB.P);
                    sb5.append("): ");
                    sb5.append(aVarB);
                    PrintWriter printWriter = new PrintWriter(new m0("FragmentManager"));
                    aVarB.Y(GlideException.a.f12263d, printWriter, false);
                    printWriter.close();
                }
                this.f5721d.add(aVarB);
                i10++;
            }
        } else {
            this.f5721d = null;
        }
        this.f5726i.set(fragmentManagerState.f5776d);
        String str3 = fragmentManagerState.f5777e;
        if (str3 != null) {
            Fragment fragmentO0 = o0(str3);
            this.f5742y = fragmentO0;
            T(fragmentO0);
        }
        ArrayList<String> arrayList2 = fragmentManagerState.f5778f;
        if (arrayList2 != null) {
            for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                this.f5727j.put(arrayList2.get(i11), fragmentManagerState.f5779g.get(i11));
            }
        }
        this.G = new ArrayDeque<>(fragmentManagerState.f5780h);
    }

    public void N(boolean z10) {
        if (z10 && (this.f5739v instanceof h0.f0)) {
            e2(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
        }
        for (Fragment fragment : this.f5720c.p()) {
            if (fragment != null) {
                fragment.w4();
                if (z10) {
                    fragment.f5664v.N(true);
                }
            }
        }
    }

    @p0
    public Fragment N0() {
        return this.f5742y;
    }

    @Deprecated
    public x N1() {
        if (this.f5739v instanceof d1) {
            e2(new IllegalStateException("You cannot use retainNonConfig when your FragmentHostCallback implements ViewModelStoreOwner."));
        }
        return this.P.o();
    }

    public void O(boolean z10, boolean z11) {
        if (z11 && (this.f5739v instanceof f0.b0)) {
            e2(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
        }
        for (Fragment fragment : this.f5720c.p()) {
            if (fragment != null) {
                fragment.x4(z10);
                if (z11) {
                    fragment.f5664v.O(z10, true);
                }
            }
        }
    }

    @g.n0
    public n0 O0() {
        n0 n0Var = this.B;
        if (n0Var != null) {
            return n0Var;
        }
        Fragment fragment = this.f5741x;
        return fragment != null ? fragment.f5662t.O0() : this.C;
    }

    public void P(@g.n0 Fragment fragment) {
        Iterator<z> it2 = this.f5732o.iterator();
        while (it2.hasNext()) {
            it2.next().a(this, fragment);
        }
    }

    @p0
    public FragmentStrictMode.b P0() {
        return this.Q;
    }

    public Parcelable P1() {
        if (this.f5739v instanceof androidx.savedstate.d) {
            e2(new IllegalStateException("You cannot use saveAllState when your FragmentHostCallback implements SavedStateRegistryOwner."));
        }
        Bundle bundleE1 = e1();
        if (bundleE1.isEmpty()) {
            return null;
        }
        return bundleE1;
    }

    public void Q() {
        for (Fragment fragment : this.f5720c.m()) {
            if (fragment != null) {
                fragment.U3(fragment.u3());
                fragment.f5664v.Q();
            }
        }
    }

    @g.n0
    /* JADX INFO: renamed from: Q1, reason: merged with bridge method [inline-methods] */
    public Bundle e1() {
        int size;
        Bundle bundle = new Bundle();
        w0();
        g0();
        j0(true);
        this.I = true;
        this.P.u(true);
        ArrayList<String> arrayListZ = this.f5720c.z();
        ArrayList<FragmentState> arrayListN = this.f5720c.n();
        if (arrayListN.isEmpty()) {
            W0(2);
        } else {
            ArrayList<String> arrayListA = this.f5720c.A();
            BackStackRecordState[] backStackRecordStateArr = null;
            ArrayList<androidx.fragment.app.a> arrayList = this.f5721d;
            if (arrayList != null && (size = arrayList.size()) > 0) {
                backStackRecordStateArr = new BackStackRecordState[size];
                for (int i10 = 0; i10 < size; i10++) {
                    backStackRecordStateArr[i10] = new BackStackRecordState(this.f5721d.get(i10));
                    if (W0(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("saveAllState: adding back stack #");
                        sb2.append(i10);
                        sb2.append(": ");
                        sb2.append(this.f5721d.get(i10));
                    }
                }
            }
            FragmentManagerState fragmentManagerState = new FragmentManagerState();
            fragmentManagerState.f5773a = arrayListZ;
            fragmentManagerState.f5774b = arrayListA;
            fragmentManagerState.f5775c = backStackRecordStateArr;
            fragmentManagerState.f5776d = this.f5726i.get();
            Fragment fragment = this.f5742y;
            if (fragment != null) {
                fragmentManagerState.f5777e = fragment.f5646f;
            }
            fragmentManagerState.f5778f.addAll(this.f5727j.keySet());
            fragmentManagerState.f5779g.addAll(this.f5727j.values());
            fragmentManagerState.f5780h = new ArrayList<>(this.G);
            bundle.putParcelable("state", fragmentManagerState);
            for (String str : this.f5728k.keySet()) {
                bundle.putBundle(U + str, this.f5728k.get(str));
            }
            for (FragmentState fragmentState : arrayListN) {
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", fragmentState);
                bundle.putBundle(W + fragmentState.f5782b, bundle2);
            }
        }
        return bundle;
    }

    public boolean R(@g.n0 MenuItem menuItem) {
        if (this.f5738u < 1) {
            return false;
        }
        for (Fragment fragment : this.f5720c.p()) {
            if (fragment != null && fragment.y4(menuItem)) {
                return true;
            }
        }
        return false;
    }

    @g.n0
    public androidx.lifecycle.c1 R0(@g.n0 Fragment fragment) {
        return this.P.q(fragment);
    }

    public void R1(@g.n0 String str) {
        h0(new s(str), false);
    }

    public void S(@g.n0 Menu menu) {
        if (this.f5738u < 1) {
            return;
        }
        for (Fragment fragment : this.f5720c.p()) {
            if (fragment != null) {
                fragment.z4(menu);
            }
        }
    }

    public void S0() {
        j0(true);
        if (this.f5725h.d()) {
            v1();
        } else {
            this.f5724g.f();
        }
    }

    public boolean S1(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, @g.n0 ArrayList<Boolean> arrayList2, @g.n0 String str) {
        int i10;
        int iP0 = p0(str, -1, true);
        if (iP0 < 0) {
            return false;
        }
        for (int i11 = iP0; i11 < this.f5721d.size(); i11++) {
            androidx.fragment.app.a aVar = this.f5721d.get(i11);
            if (!aVar.f5962r) {
                e2(new IllegalArgumentException("saveBackStack(\"" + str + "\") included FragmentTransactions must use setReorderingAllowed(true) to ensure that the back stack can be restored as an atomic operation. Found " + aVar + " that did not use setReorderingAllowed(true)."));
            }
        }
        HashSet hashSet = new HashSet();
        for (int i12 = iP0; i12 < this.f5721d.size(); i12++) {
            androidx.fragment.app.a aVar2 = this.f5721d.get(i12);
            HashSet hashSet2 = new HashSet();
            HashSet hashSet3 = new HashSet();
            for (g0.a aVar3 : aVar2.f5947c) {
                Fragment fragment = aVar3.f5965b;
                if (fragment != null) {
                    if (!aVar3.f5966c || (i10 = aVar3.f5964a) == 1 || i10 == 2 || i10 == 8) {
                        hashSet.add(fragment);
                        hashSet2.add(fragment);
                    }
                    int i13 = aVar3.f5964a;
                    if (i13 == 1 || i13 == 2) {
                        hashSet3.add(fragment);
                    }
                }
            }
            hashSet2.removeAll(hashSet3);
            if (!hashSet2.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("saveBackStack(\"");
                sb2.append(str);
                sb2.append("\") must be self contained and not reference fragments from non-saved FragmentTransactions. Found reference to fragment");
                sb2.append(hashSet2.size() == 1 ? com.blankj.utilcode.util.i0.f11861z + hashSet2.iterator().next() : "s " + hashSet2);
                sb2.append(" in ");
                sb2.append(aVar2);
                sb2.append(" that were previously added to the FragmentManager through a separate FragmentTransaction.");
                e2(new IllegalArgumentException(sb2.toString()));
            }
        }
        ArrayDeque arrayDeque = new ArrayDeque(hashSet);
        while (!arrayDeque.isEmpty()) {
            Fragment fragment2 = (Fragment) arrayDeque.removeFirst();
            if (fragment2.C) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("saveBackStack(\"");
                sb3.append(str);
                sb3.append("\") must not contain retained fragments. Found ");
                sb3.append(hashSet.contains(fragment2) ? "direct reference to retained " : "retained child ");
                sb3.append("fragment ");
                sb3.append(fragment2);
                e2(new IllegalArgumentException(sb3.toString()));
            }
            for (Fragment fragment3 : fragment2.f5664v.z0()) {
                if (fragment3 != null) {
                    arrayDeque.addLast(fragment3);
                }
            }
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((Fragment) it2.next()).f5646f);
        }
        ArrayList arrayList4 = new ArrayList(this.f5721d.size() - iP0);
        for (int i14 = iP0; i14 < this.f5721d.size(); i14++) {
            arrayList4.add(null);
        }
        BackStackState backStackState = new BackStackState(arrayList3, arrayList4);
        for (int size = this.f5721d.size() - 1; size >= iP0; size--) {
            androidx.fragment.app.a aVarRemove = this.f5721d.remove(size);
            androidx.fragment.app.a aVar4 = new androidx.fragment.app.a(aVarRemove);
            aVar4.V();
            arrayList4.set(size - iP0, new BackStackRecordState(aVar4));
            aVarRemove.Q = true;
            arrayList.add(aVarRemove);
            arrayList2.add(Boolean.TRUE);
        }
        this.f5727j.put(str, backStackState);
        return true;
    }

    public final void T(@p0 Fragment fragment) {
        if (fragment == null || !fragment.equals(o0(fragment.f5646f))) {
            return;
        }
        fragment.D4();
    }

    public void T0(@g.n0 Fragment fragment) {
        if (W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("hide: ");
            sb2.append(fragment);
        }
        if (fragment.A) {
            return;
        }
        fragment.A = true;
        fragment.E7 = true ^ fragment.E7;
        b2(fragment);
    }

    @p0
    public Fragment.SavedState T1(@g.n0 Fragment fragment) {
        d0 d0VarO = this.f5720c.o(fragment.f5646f);
        if (d0VarO == null || !d0VarO.k().equals(fragment)) {
            e2(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        }
        return d0VarO.r();
    }

    public void U() {
        a0(5);
    }

    public void U0(@g.n0 Fragment fragment) {
        if (fragment.f5654l && X0(fragment)) {
            this.H = true;
        }
    }

    public void U1() {
        synchronized (this.f5718a) {
            boolean z10 = true;
            if (this.f5718a.size() != 1) {
                z10 = false;
            }
            if (z10) {
                this.f5739v.h().removeCallbacks(this.R);
                this.f5739v.h().post(this.R);
                g2();
            }
        }
    }

    public void V(boolean z10, boolean z11) {
        if (z11 && (this.f5739v instanceof f0.d0)) {
            e2(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
        }
        for (Fragment fragment : this.f5720c.p()) {
            if (fragment != null) {
                fragment.B4(z10);
                if (z11) {
                    fragment.f5664v.V(z10, true);
                }
            }
        }
    }

    public boolean V0() {
        return this.K;
    }

    public void V1(@g.n0 Fragment fragment, boolean z10) {
        ViewGroup viewGroupF0 = F0(fragment);
        if (viewGroupF0 == null || !(viewGroupF0 instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupF0).setDrawDisappearingViewsLast(!z10);
    }

    public boolean W(@g.n0 Menu menu) {
        boolean z10 = false;
        if (this.f5738u < 1) {
            return false;
        }
        for (Fragment fragment : this.f5720c.p()) {
            if (fragment != null && a1(fragment) && fragment.C4(menu)) {
                z10 = true;
            }
        }
        return z10;
    }

    public void W1(@g.n0 androidx.fragment.app.k kVar) {
        this.f5743z = kVar;
    }

    public void X() {
        g2();
        T(this.f5742y);
    }

    public final boolean X0(@g.n0 Fragment fragment) {
        return (fragment.f5652k0 && fragment.K0) || fragment.f5664v.v();
    }

    public void X1(@g.n0 Fragment fragment, @g.n0 Lifecycle.State state) {
        if (fragment.equals(o0(fragment.f5646f)) && (fragment.f5663u == null || fragment.f5662t == this)) {
            fragment.I7 = state;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void Y() {
        this.I = false;
        this.J = false;
        this.P.u(false);
        a0(7);
    }

    public final boolean Y0() {
        Fragment fragment = this.f5741x;
        if (fragment == null) {
            return true;
        }
        return fragment.s3() && this.f5741x.L2().Y0();
    }

    public void Y1(@p0 Fragment fragment) {
        if (fragment == null || (fragment.equals(o0(fragment.f5646f)) && (fragment.f5663u == null || fragment.f5662t == this))) {
            Fragment fragment2 = this.f5742y;
            this.f5742y = fragment;
            T(fragment2);
            T(this.f5742y);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public void Z() {
        this.I = false;
        this.J = false;
        this.P.u(false);
        a0(5);
    }

    public boolean Z0(@p0 Fragment fragment) {
        if (fragment == null) {
            return false;
        }
        return fragment.u3();
    }

    public void Z1(@g.n0 n0 n0Var) {
        this.B = n0Var;
    }

    @Override // androidx.fragment.app.c0
    public final void a(@g.n0 String str, @g.n0 Bundle bundle) {
        n nVar = this.f5729l.get(str);
        if (nVar == null || !nVar.b(Lifecycle.State.STARTED)) {
            this.f5728k.put(str, bundle);
        } else {
            nVar.a(str, bundle);
        }
        if (W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting fragment result with key ");
            sb2.append(str);
            sb2.append(" and result ");
            sb2.append(bundle);
        }
    }

    public final void a0(int i10) {
        try {
            this.f5719b = true;
            this.f5720c.d(i10);
            m1(i10, false);
            Iterator<SpecialEffectsController> it2 = B().iterator();
            while (it2.hasNext()) {
                it2.next().j();
            }
            this.f5719b = false;
            j0(true);
        } catch (Throwable th2) {
            this.f5719b = false;
            throw th2;
        }
    }

    public boolean a1(@p0 Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.x3();
    }

    public void a2(@p0 FragmentStrictMode.b bVar) {
        this.Q = bVar;
    }

    @Override // androidx.fragment.app.c0
    @SuppressLint({"SyntheticAccessor"})
    public final void b(@g.n0 final String str, @g.n0 androidx.lifecycle.y yVar, @g.n0 final b0 b0Var) {
        final Lifecycle lifecycleE = yVar.e();
        if (lifecycleE.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        androidx.lifecycle.v vVar = new androidx.lifecycle.v() { // from class: androidx.fragment.app.FragmentManager.6
            @Override // androidx.lifecycle.v
            public void c(@g.n0 androidx.lifecycle.y yVar2, @g.n0 Lifecycle.Event event) {
                Bundle bundle;
                if (event == Lifecycle.Event.ON_START && (bundle = (Bundle) FragmentManager.this.f5728k.get(str)) != null) {
                    b0Var.a(str, bundle);
                    FragmentManager.this.d(str);
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycleE.d(this);
                    FragmentManager.this.f5729l.remove(str);
                }
            }
        };
        n nVarPut = this.f5729l.put(str, new n(lifecycleE, b0Var, vVar));
        if (nVarPut != null) {
            nVarPut.c();
        }
        if (W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting FragmentResultListener with key ");
            sb2.append(str);
            sb2.append(" lifecycleOwner ");
            sb2.append(lifecycleE);
            sb2.append(" and listener ");
            sb2.append(b0Var);
        }
        lifecycleE.a(vVar);
    }

    public void b0() {
        this.J = true;
        this.P.u(true);
        a0(4);
    }

    public boolean b1(@p0 Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.f5662t;
        return fragment.equals(fragmentManager.N0()) && b1(fragmentManager.f5741x);
    }

    public final void b2(@g.n0 Fragment fragment) {
        ViewGroup viewGroupF0 = F0(fragment);
        if (viewGroupF0 == null || fragment.b2() + fragment.f2() + fragment.Q2() + fragment.S2() <= 0) {
            return;
        }
        int i10 = R.id.visible_removing_fragment_view_tag;
        if (viewGroupF0.getTag(i10) == null) {
            viewGroupF0.setTag(i10, fragment);
        }
        ((Fragment) viewGroupF0.getTag(i10)).m5(fragment.P2());
    }

    @Override // androidx.fragment.app.c0
    public final void c(@g.n0 String str) {
        n nVarRemove = this.f5729l.remove(str);
        if (nVarRemove != null) {
            nVarRemove.c();
        }
        if (W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing FragmentResultListener for key ");
            sb2.append(str);
        }
    }

    public void c0() {
        a0(2);
    }

    public boolean c1(int i10) {
        return this.f5738u >= i10;
    }

    public void c2(@g.n0 Fragment fragment) {
        if (W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("show: ");
            sb2.append(fragment);
        }
        if (fragment.A) {
            fragment.A = false;
            fragment.E7 = !fragment.E7;
        }
    }

    @Override // androidx.fragment.app.c0
    public final void d(@g.n0 String str) {
        this.f5728k.remove(str);
        if (W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Clearing fragment result with key ");
            sb2.append(str);
        }
    }

    public final void d0() {
        if (this.L) {
            this.L = false;
            d2();
        }
    }

    public boolean d1() {
        return this.I || this.J;
    }

    public final void d2() {
        Iterator<d0> it2 = this.f5720c.l().iterator();
        while (it2.hasNext()) {
            q1(it2.next());
        }
    }

    public void e0(@g.n0 String str, @p0 FileDescriptor fileDescriptor, @g.n0 PrintWriter printWriter, @p0 String[] strArr) {
        int size;
        int size2;
        String str2 = str + wn.a.f54751a;
        this.f5720c.e(str, fileDescriptor, printWriter, strArr);
        ArrayList<Fragment> arrayList = this.f5722e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i10 = 0; i10 < size2; i10++) {
                Fragment fragment = this.f5722e.get(i10);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i10);
                printWriter.print(": ");
                printWriter.println(fragment.toString());
            }
        }
        ArrayList<androidx.fragment.app.a> arrayList2 = this.f5721d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i11 = 0; i11 < size; i11++) {
                androidx.fragment.app.a aVar = this.f5721d.get(i11);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i11);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.X(str2, printWriter);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.f5726i.get());
        synchronized (this.f5718a) {
            int size3 = this.f5718a.size();
            if (size3 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i12 = 0; i12 < size3; i12++) {
                    p pVar = this.f5718a.get(i12);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i12);
                    printWriter.print(": ");
                    printWriter.println(pVar);
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f5739v);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f5740w);
        if (this.f5741x != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f5741x);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f5738u);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.I);
        printWriter.print(" mStopped=");
        printWriter.print(this.J);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.K);
        if (this.H) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.H);
        }
    }

    public final void e2(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new m0("FragmentManager"));
        androidx.fragment.app.l<?> lVar = this.f5739v;
        try {
            if (lVar != null) {
                lVar.i(GlideException.a.f12263d, null, printWriter, new String[0]);
            } else {
                e0(GlideException.a.f12263d, null, printWriter, new String[0]);
            }
            throw runtimeException;
        } catch (Exception unused) {
            throw runtimeException;
        }
    }

    public void f2(@g.n0 m mVar) {
        this.f5731n.p(mVar);
    }

    public final void g0() {
        Iterator<SpecialEffectsController> it2 = B().iterator();
        while (it2.hasNext()) {
            it2.next().j();
        }
    }

    public final void g2() {
        synchronized (this.f5718a) {
            if (this.f5718a.isEmpty()) {
                this.f5725h.g(B0() > 0 && b1(this.f5741x));
            } else {
                this.f5725h.g(true);
            }
        }
    }

    public void h0(@g.n0 p pVar, boolean z10) {
        if (!z10) {
            if (this.f5739v == null) {
                if (!this.K) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            w();
        }
        synchronized (this.f5718a) {
            if (this.f5739v == null) {
                if (!z10) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } else {
                this.f5718a.add(pVar);
                U1();
            }
        }
    }

    public final void i0(boolean z10) {
        if (this.f5719b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.f5739v == null) {
            if (!this.K) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.f5739v.h().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z10) {
            w();
        }
        if (this.M == null) {
            this.M = new ArrayList<>();
            this.N = new ArrayList<>();
        }
    }

    public boolean j0(boolean z10) {
        i0(z10);
        boolean z11 = false;
        while (x0(this.M, this.N)) {
            this.f5719b = true;
            try {
                F1(this.M, this.N);
                x();
                z11 = true;
            } catch (Throwable th2) {
                x();
                throw th2;
            }
        }
        g2();
        d0();
        this.f5720c.b();
        return z11;
    }

    public void j1(@g.n0 Fragment fragment, @g.n0 String[] strArr, int i10) {
        if (this.F == null) {
            this.f5739v.n(fragment, strArr, i10);
            return;
        }
        this.G.addLast(new LaunchedFragmentInfo(fragment.f5646f, i10));
        this.F.b(strArr);
    }

    public void k0(@g.n0 p pVar, boolean z10) {
        if (z10 && (this.f5739v == null || this.K)) {
            return;
        }
        i0(z10);
        if (pVar.b(this.M, this.N)) {
            this.f5719b = true;
            try {
                F1(this.M, this.N);
            } finally {
                x();
            }
        }
        g2();
        d0();
        this.f5720c.b();
    }

    public void k1(@g.n0 Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i10, @p0 Bundle bundle) {
        if (this.D == null) {
            this.f5739v.s(fragment, intent, i10, bundle);
            return;
        }
        this.G.addLast(new LaunchedFragmentInfo(fragment.f5646f, i10));
        if (intent != null && bundle != null) {
            intent.putExtra(b.m.f27356b, bundle);
        }
        this.D.b(intent);
    }

    public void l1(@g.n0 Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i10, @p0 Intent intent, int i11, int i12, int i13, @p0 Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2;
        if (this.E == null) {
            this.f5739v.u(fragment, intentSender, i10, intent, i11, i12, i13, bundle);
            return;
        }
        if (bundle != null) {
            if (intent == null) {
                intent2 = new Intent();
                intent2.putExtra(f5717a0, true);
            } else {
                intent2 = intent;
            }
            if (W0(2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ActivityOptions ");
                sb2.append(bundle);
                sb2.append(" were added to fillInIntent ");
                sb2.append(intent2);
                sb2.append(" for fragment ");
                sb2.append(fragment);
            }
            intent2.putExtra(b.m.f27356b, bundle);
        } else {
            intent2 = intent;
        }
        IntentSenderRequest intentSenderRequestA = new IntentSenderRequest.a(intentSender).b(intent2).c(i12, i11).a();
        this.G.addLast(new LaunchedFragmentInfo(fragment.f5646f, i10));
        if (W0(2)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Fragment ");
            sb3.append(fragment);
            sb3.append("is launching an IntentSender for result ");
        }
        this.E.b(intentSenderRequestA);
    }

    public void m(androidx.fragment.app.a aVar) {
        if (this.f5721d == null) {
            this.f5721d = new ArrayList<>();
        }
        this.f5721d.add(aVar);
    }

    public final void m0(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, @g.n0 ArrayList<Boolean> arrayList2, int i10, int i11) {
        boolean z10 = arrayList.get(i10).f5962r;
        ArrayList<Fragment> arrayList3 = this.O;
        if (arrayList3 == null) {
            this.O = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.O.addAll(this.f5720c.p());
        Fragment fragmentN0 = N0();
        boolean z11 = false;
        for (int i12 = i10; i12 < i11; i12++) {
            androidx.fragment.app.a aVar = arrayList.get(i12);
            fragmentN0 = !arrayList2.get(i12).booleanValue() ? aVar.b0(this.O, fragmentN0) : aVar.d0(this.O, fragmentN0);
            z11 = z11 || aVar.f5953i;
        }
        this.O.clear();
        if (!z10 && this.f5738u >= 1) {
            for (int i13 = i10; i13 < i11; i13++) {
                Iterator<g0.a> it2 = arrayList.get(i13).f5947c.iterator();
                while (it2.hasNext()) {
                    Fragment fragment = it2.next().f5965b;
                    if (fragment != null && fragment.f5662t != null) {
                        this.f5720c.s(D(fragment));
                    }
                }
            }
        }
        l0(arrayList, arrayList2, i10, i11);
        boolean zBooleanValue = arrayList2.get(i11 - 1).booleanValue();
        for (int i14 = i10; i14 < i11; i14++) {
            androidx.fragment.app.a aVar2 = arrayList.get(i14);
            if (zBooleanValue) {
                for (int size = aVar2.f5947c.size() - 1; size >= 0; size--) {
                    Fragment fragment2 = aVar2.f5947c.get(size).f5965b;
                    if (fragment2 != null) {
                        D(fragment2).m();
                    }
                }
            } else {
                Iterator<g0.a> it3 = aVar2.f5947c.iterator();
                while (it3.hasNext()) {
                    Fragment fragment3 = it3.next().f5965b;
                    if (fragment3 != null) {
                        D(fragment3).m();
                    }
                }
            }
        }
        m1(this.f5738u, true);
        for (SpecialEffectsController specialEffectsController : C(arrayList, i10, i11)) {
            specialEffectsController.r(zBooleanValue);
            specialEffectsController.p();
            specialEffectsController.g();
        }
        while (i10 < i11) {
            androidx.fragment.app.a aVar3 = arrayList.get(i10);
            if (arrayList2.get(i10).booleanValue() && aVar3.P >= 0) {
                aVar3.P = -1;
            }
            aVar3.c0();
            i10++;
        }
        if (z11) {
            H1();
        }
    }

    public void m1(int i10, boolean z10) {
        androidx.fragment.app.l<?> lVar;
        if (this.f5739v == null && i10 != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z10 || i10 != this.f5738u) {
            this.f5738u = i10;
            this.f5720c.u();
            d2();
            if (this.H && (lVar = this.f5739v) != null && this.f5738u == 7) {
                lVar.v();
                this.H = false;
            }
        }
    }

    public d0 n(@g.n0 Fragment fragment) {
        String str = fragment.H7;
        if (str != null) {
            FragmentStrictMode.i(fragment, str);
        }
        if (W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("add: ");
            sb2.append(fragment);
        }
        d0 d0VarD = D(fragment);
        fragment.f5662t = this;
        this.f5720c.s(d0VarD);
        if (!fragment.B) {
            this.f5720c.a(fragment);
            fragment.f5655m = false;
            if (fragment.C1 == null) {
                fragment.E7 = false;
            }
            if (X0(fragment)) {
                this.H = true;
            }
        }
        return d0VarD;
    }

    public boolean n0() {
        boolean zJ0 = j0(true);
        w0();
        return zJ0;
    }

    public void n1() {
        if (this.f5739v == null) {
            return;
        }
        this.I = false;
        this.J = false;
        this.P.u(false);
        for (Fragment fragment : this.f5720c.p()) {
            if (fragment != null) {
                fragment.D3();
            }
        }
    }

    public void o(@g.n0 z zVar) {
        this.f5732o.add(zVar);
    }

    @p0
    public Fragment o0(@g.n0 String str) {
        return this.f5720c.f(str);
    }

    public void o1(@g.n0 FragmentContainerView fragmentContainerView) {
        View view;
        for (d0 d0Var : this.f5720c.l()) {
            Fragment fragmentK = d0Var.k();
            if (fragmentK.f5669y == fragmentContainerView.getId() && (view = fragmentK.C1) != null && view.getParent() == null) {
                fragmentK.f5665v1 = fragmentContainerView;
                d0Var.b();
            }
        }
    }

    public void p(@g.n0 o oVar) {
        if (this.f5730m == null) {
            this.f5730m = new ArrayList<>();
        }
        this.f5730m.add(oVar);
    }

    public final int p0(@p0 String str, int i10, boolean z10) {
        ArrayList<androidx.fragment.app.a> arrayList = this.f5721d;
        if (arrayList == null || arrayList.isEmpty()) {
            return -1;
        }
        if (str == null && i10 < 0) {
            if (z10) {
                return 0;
            }
            return this.f5721d.size() - 1;
        }
        int size = this.f5721d.size() - 1;
        while (size >= 0) {
            androidx.fragment.app.a aVar = this.f5721d.get(size);
            if ((str != null && str.equals(aVar.getName())) || (i10 >= 0 && i10 == aVar.P)) {
                break;
            }
            size--;
        }
        if (size < 0) {
            return size;
        }
        if (!z10) {
            if (size == this.f5721d.size() - 1) {
                return -1;
            }
            return size + 1;
        }
        while (size > 0) {
            androidx.fragment.app.a aVar2 = this.f5721d.get(size - 1);
            if ((str == null || !str.equals(aVar2.getName())) && (i10 < 0 || i10 != aVar2.P)) {
                return size;
            }
            size--;
        }
        return size;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @g.n0
    @Deprecated
    public g0 p1() {
        return u();
    }

    public void q(@g.n0 Fragment fragment) {
        this.P.g(fragment);
    }

    public void q1(@g.n0 d0 d0Var) {
        Fragment fragmentK = d0Var.k();
        if (fragmentK.K1) {
            if (this.f5719b) {
                this.L = true;
            } else {
                fragmentK.K1 = false;
                d0Var.m();
            }
        }
    }

    public int r() {
        return this.f5726i.getAndIncrement();
    }

    @p0
    public Fragment r0(@g.d0 int i10) {
        return this.f5720c.g(i10);
    }

    public void r1() {
        h0(new q(null, -1, 0), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SyntheticAccessor"})
    public void s(@g.n0 androidx.fragment.app.l<?> lVar, @g.n0 androidx.fragment.app.i iVar, @p0 Fragment fragment) {
        String str;
        if (this.f5739v != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f5739v = lVar;
        this.f5740w = iVar;
        this.f5741x = fragment;
        if (fragment != null) {
            o(new g(fragment));
        } else if (lVar instanceof z) {
            o((z) lVar);
        }
        if (this.f5741x != null) {
            g2();
        }
        if (lVar instanceof androidx.activity.q) {
            androidx.activity.q qVar = (androidx.activity.q) lVar;
            OnBackPressedDispatcher onBackPressedDispatcherT = qVar.t();
            this.f5724g = onBackPressedDispatcherT;
            androidx.lifecycle.y yVar = qVar;
            if (fragment != null) {
                yVar = fragment;
            }
            onBackPressedDispatcherT.c(yVar, this.f5725h);
        }
        if (fragment != null) {
            this.P = fragment.f5662t.C0(fragment);
        } else if (lVar instanceof d1) {
            this.P = y.m(((d1) lVar).O0());
        } else {
            this.P = new y(false);
        }
        this.P.u(d1());
        this.f5720c.B(this.P);
        Object obj = this.f5739v;
        if ((obj instanceof androidx.savedstate.d) && fragment == null) {
            androidx.savedstate.b bVarL1 = ((androidx.savedstate.d) obj).l1();
            bVarL1.j(S, new b.c() { // from class: androidx.fragment.app.u
                @Override // androidx.savedstate.b.c
                public final Bundle a() {
                    return this.f6042a.e1();
                }
            });
            Bundle bundleB = bVarL1.b(S);
            if (bundleB != null) {
                M1(bundleB);
            }
        }
        Object obj2 = this.f5739v;
        if (obj2 instanceof androidx.activity.result.i) {
            ActivityResultRegistry activityResultRegistryV0 = ((androidx.activity.result.i) obj2).v0();
            if (fragment != null) {
                str = fragment.f5646f + ":";
            } else {
                str = "";
            }
            String str2 = "FragmentManager:" + str;
            this.D = activityResultRegistryV0.j(str2 + "StartActivityForResult", new b.m(), new h());
            this.E = activityResultRegistryV0.j(str2 + "StartIntentSenderForResult", new l(), new i());
            this.F = activityResultRegistryV0.j(str2 + "RequestPermissions", new b.k(), new a());
        }
        Object obj3 = this.f5739v;
        if (obj3 instanceof h0.e0) {
            ((h0.e0) obj3).N(this.f5733p);
        }
        Object obj4 = this.f5739v;
        if (obj4 instanceof h0.f0) {
            ((h0.f0) obj4).X1(this.f5734q);
        }
        Object obj5 = this.f5739v;
        if (obj5 instanceof f0.b0) {
            ((f0.b0) obj5).C0(this.f5735r);
        }
        Object obj6 = this.f5739v;
        if (obj6 instanceof f0.d0) {
            ((f0.d0) obj6).m0(this.f5736s);
        }
        Object obj7 = this.f5739v;
        if ((obj7 instanceof androidx.core.view.t) && fragment == null) {
            ((androidx.core.view.t) obj7).n2(this.f5737t);
        }
    }

    @p0
    public Fragment s0(@p0 String str) {
        return this.f5720c.h(str);
    }

    public void s1(int i10, int i11) {
        t1(i10, i11, false);
    }

    public void t(@g.n0 Fragment fragment) {
        if (W0(2)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("attach: ");
            sb2.append(fragment);
        }
        if (fragment.B) {
            fragment.B = false;
            if (fragment.f5654l) {
                return;
            }
            this.f5720c.a(fragment);
            if (W0(2)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("add from attach: ");
                sb3.append(fragment);
            }
            if (X0(fragment)) {
                this.H = true;
            }
        }
    }

    public Fragment t0(@g.n0 String str) {
        return this.f5720c.i(str);
    }

    public void t1(int i10, int i11, boolean z10) {
        if (i10 >= 0) {
            h0(new q(null, i10, i11), z10);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    @g.n0
    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("FragmentManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Fragment fragment = this.f5741x;
        if (fragment != null) {
            sb2.append(fragment.getClass().getSimpleName());
            sb2.append(zc.a.f58316d);
            sb2.append(Integer.toHexString(System.identityHashCode(this.f5741x)));
            sb2.append(zc.a.f58317e);
        } else {
            androidx.fragment.app.l<?> lVar = this.f5739v;
            if (lVar != null) {
                sb2.append(lVar.getClass().getSimpleName());
                sb2.append(zc.a.f58316d);
                sb2.append(Integer.toHexString(System.identityHashCode(this.f5739v)));
                sb2.append(zc.a.f58317e);
            } else {
                sb2.append(com.blankj.utilcode.util.i0.f11859x);
            }
        }
        sb2.append("}}");
        return sb2.toString();
    }

    @g.n0
    public g0 u() {
        return new androidx.fragment.app.a(this);
    }

    public void u1(@p0 String str, int i10) {
        h0(new q(str, -1, i10), false);
    }

    public boolean v() {
        boolean zX0 = false;
        for (Fragment fragment : this.f5720c.m()) {
            if (fragment != null) {
                zX0 = X0(fragment);
            }
            if (zX0) {
                return true;
            }
        }
        return false;
    }

    public boolean v1() {
        return y1(null, -1, 0);
    }

    public final void w() {
        if (d1()) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    public final void w0() {
        Iterator<SpecialEffectsController> it2 = B().iterator();
        while (it2.hasNext()) {
            it2.next().k();
        }
    }

    public boolean w1(int i10, int i11) {
        if (i10 >= 0) {
            return y1(null, i10, i11);
        }
        throw new IllegalArgumentException("Bad id: " + i10);
    }

    public final void x() {
        this.f5719b = false;
        this.N.clear();
        this.M.clear();
    }

    public final boolean x0(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, @g.n0 ArrayList<Boolean> arrayList2) {
        synchronized (this.f5718a) {
            if (this.f5718a.isEmpty()) {
                return false;
            }
            try {
                int size = this.f5718a.size();
                boolean zB = false;
                for (int i10 = 0; i10 < size; i10++) {
                    zB |= this.f5718a.get(i10).b(arrayList, arrayList2);
                }
                return zB;
            } finally {
                this.f5718a.clear();
                this.f5739v.h().removeCallbacks(this.R);
            }
        }
    }

    public boolean x1(@p0 String str, int i10) {
        return y1(str, -1, i10);
    }

    public void y(@g.n0 String str) {
        h0(new k(str), false);
    }

    public int y0() {
        return this.f5720c.k();
    }

    public final boolean y1(@p0 String str, int i10, int i11) {
        j0(false);
        i0(true);
        Fragment fragment = this.f5742y;
        if (fragment != null && i10 < 0 && str == null && fragment.U1().v1()) {
            return true;
        }
        boolean zZ1 = z1(this.M, this.N, str, i10, i11);
        if (zZ1) {
            this.f5719b = true;
            try {
                F1(this.M, this.N);
            } finally {
                x();
            }
        }
        g2();
        d0();
        this.f5720c.b();
        return zZ1;
    }

    public boolean z(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, @g.n0 ArrayList<Boolean> arrayList2, @g.n0 String str) {
        if (K1(arrayList, arrayList2, str)) {
            return z1(arrayList, arrayList2, str, -1, 1);
        }
        return false;
    }

    @g.n0
    public List<Fragment> z0() {
        return this.f5720c.m();
    }

    public boolean z1(@g.n0 ArrayList<androidx.fragment.app.a> arrayList, @g.n0 ArrayList<Boolean> arrayList2, @p0 String str, int i10, int i11) {
        int iP0 = p0(str, i10, (i11 & 1) != 0);
        if (iP0 < 0) {
            return false;
        }
        for (int size = this.f5721d.size() - 1; size >= iP0; size--) {
            arrayList.add(this.f5721d.remove(size));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f5748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f5749b;

        public class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public LaunchedFragmentInfo[] newArray(int i10) {
                return new LaunchedFragmentInfo[i10];
            }
        }

        public LaunchedFragmentInfo(@g.n0 String str, int i10) {
            this.f5748a = str;
            this.f5749b = i10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f5748a);
            parcel.writeInt(this.f5749b);
        }

        public LaunchedFragmentInfo(@g.n0 Parcel parcel) {
            this.f5748a = parcel.readString();
            this.f5749b = parcel.readInt();
        }
    }
}

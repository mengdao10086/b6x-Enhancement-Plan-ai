package p4;

import android.R;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.g0;
import com.bumptech.glide.c;
import com.bumptech.glide.load.resource.bitmap.u;
import com.bumptech.glide.manager.SupportRequestManagerFragment;
import g.i1;
import g.n0;
import g.p0;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class p implements Handler.Callback {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @i1
    public static final String f46376j = "com.bumptech.glide.manager";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f46377k = "RMRetriever";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f46378l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f46379m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f46380n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f46381o = "key";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final b f46382p = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile com.bumptech.glide.i f46383a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f46386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f46387e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final k f46391i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @i1
    public final Map<FragmentManager, o> f46384b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @i1
    public final Map<androidx.fragment.app.FragmentManager, SupportRequestManagerFragment> f46385c = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final androidx.collection.a<View, Fragment> f46388f = new androidx.collection.a<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final androidx.collection.a<View, android.app.Fragment> f46389g = new androidx.collection.a<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Bundle f46390h = new Bundle();

    public class a implements b {
        @Override // p4.p.b
        @n0
        public com.bumptech.glide.i a(@n0 com.bumptech.glide.b bVar, @n0 l lVar, @n0 q qVar, @n0 Context context) {
            return new com.bumptech.glide.i(bVar, lVar, qVar, context);
        }
    }

    public interface b {
        @n0
        com.bumptech.glide.i a(@n0 com.bumptech.glide.b bVar, @n0 l lVar, @n0 q qVar, @n0 Context context);
    }

    public p(@p0 b bVar, com.bumptech.glide.e eVar) {
        this.f46387e = bVar == null ? f46382p : bVar;
        this.f46386d = new Handler(Looper.getMainLooper(), this);
        this.f46391i = b(eVar);
    }

    @TargetApi(17)
    public static void a(@n0 Activity activity) {
        if (activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    public static k b(com.bumptech.glide.e eVar) {
        return (u.f12637i && u.f12636h) ? eVar.b(c.g.class) ? new i() : new j() : new g();
    }

    @p0
    public static Activity c(@n0 Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static void f(@p0 Collection<Fragment> collection, @n0 Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.k3() != null) {
                map.put(fragment.k3(), fragment);
                f(fragment.U1().I0(), map);
            }
        }
    }

    public static boolean u(Context context) {
        Activity activityC = c(context);
        return activityC == null || !activityC.isFinishing();
    }

    @TargetApi(26)
    @Deprecated
    public final void d(@n0 FragmentManager fragmentManager, @n0 androidx.collection.a<View, android.app.Fragment> aVar) {
        if (Build.VERSION.SDK_INT < 26) {
            e(fragmentManager, aVar);
            return;
        }
        for (android.app.Fragment fragment : fragmentManager.getFragments()) {
            if (fragment.getView() != null) {
                aVar.put(fragment.getView(), fragment);
                d(fragment.getChildFragmentManager(), aVar);
            }
        }
    }

    @Deprecated
    public final void e(@n0 FragmentManager fragmentManager, @n0 androidx.collection.a<View, android.app.Fragment> aVar) {
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            this.f46390h.putInt("key", i10);
            android.app.Fragment fragment = null;
            try {
                fragment = fragmentManager.getFragment(this.f46390h, "key");
            } catch (Exception unused) {
            }
            if (fragment == null) {
                return;
            }
            if (fragment.getView() != null) {
                aVar.put(fragment.getView(), fragment);
                d(fragment.getChildFragmentManager(), aVar);
            }
            i10 = i11;
        }
    }

    @p0
    @Deprecated
    public final android.app.Fragment g(@n0 View view, @n0 Activity activity) {
        this.f46389g.clear();
        d(activity.getFragmentManager(), this.f46389g);
        View viewFindViewById = activity.findViewById(R.id.content);
        android.app.Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.f46389g.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f46389g.clear();
        return fragment;
    }

    @p0
    public final Fragment h(@n0 View view, @n0 androidx.fragment.app.g gVar) {
        this.f46388f.clear();
        f(gVar.n3().I0(), this.f46388f);
        View viewFindViewById = gVar.findViewById(R.id.content);
        Fragment fragment = null;
        while (!view.equals(viewFindViewById) && (fragment = this.f46388f.get(view)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.f46388f.clear();
        return fragment;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        androidx.fragment.app.FragmentManager fragmentManager;
        androidx.fragment.app.FragmentManager fragmentManager2;
        boolean z10 = false;
        boolean z11 = true;
        boolean z12 = message.arg1 == 1;
        int i10 = message.what;
        Object objRemove = null;
        if (i10 == 1) {
            FragmentManager fragmentManager3 = (FragmentManager) message.obj;
            if (w(fragmentManager3, z12)) {
                objRemove = this.f46384b.remove(fragmentManager3);
                fragmentManager2 = fragmentManager3;
                z10 = true;
                fragmentManager = fragmentManager2;
            }
            fragmentManager = null;
        } else if (i10 != 2) {
            fragmentManager = null;
            z11 = false;
        } else {
            androidx.fragment.app.FragmentManager fragmentManager4 = (androidx.fragment.app.FragmentManager) message.obj;
            if (x(fragmentManager4, z12)) {
                objRemove = this.f46385c.remove(fragmentManager4);
                fragmentManager2 = fragmentManager4;
                z10 = true;
                fragmentManager = fragmentManager2;
            }
            fragmentManager = null;
        }
        if (Log.isLoggable(f46377k, 5) && z10 && objRemove == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Failed to remove expected request manager fragment, manager: ");
            sb2.append(fragmentManager);
        }
        return z11;
    }

    @n0
    @Deprecated
    public final com.bumptech.glide.i i(@n0 Context context, @n0 FragmentManager fragmentManager, @p0 android.app.Fragment fragment, boolean z10) {
        o oVarR = r(fragmentManager, fragment);
        com.bumptech.glide.i iVarE = oVarR.e();
        if (iVarE == null) {
            iVarE = this.f46387e.a(com.bumptech.glide.b.e(context), oVarR.c(), oVarR.f(), context);
            if (z10) {
                iVarE.b();
            }
            oVarR.k(iVarE);
        }
        return iVarE;
    }

    @n0
    public com.bumptech.glide.i j(@n0 Activity activity) {
        if (v4.o.t()) {
            return l(activity.getApplicationContext());
        }
        if (activity instanceof androidx.fragment.app.g) {
            return o((androidx.fragment.app.g) activity);
        }
        a(activity);
        this.f46391i.a(activity);
        return i(activity, activity.getFragmentManager(), null, u(activity));
    }

    @TargetApi(17)
    @n0
    @Deprecated
    public com.bumptech.glide.i k(@n0 android.app.Fragment fragment) {
        if (fragment.getActivity() == null) {
            throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
        }
        if (v4.o.t()) {
            return l(fragment.getActivity().getApplicationContext());
        }
        if (fragment.getActivity() != null) {
            this.f46391i.a(fragment.getActivity());
        }
        return i(fragment.getActivity(), fragment.getChildFragmentManager(), fragment, fragment.isVisible());
    }

    @n0
    public com.bumptech.glide.i l(@n0 Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (v4.o.u() && !(context instanceof Application)) {
            if (context instanceof androidx.fragment.app.g) {
                return o((androidx.fragment.app.g) context);
            }
            if (context instanceof Activity) {
                return j((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                    return l(contextWrapper.getBaseContext());
                }
            }
        }
        return p(context);
    }

    @n0
    public com.bumptech.glide.i m(@n0 View view) {
        if (v4.o.t()) {
            return l(view.getContext().getApplicationContext());
        }
        v4.m.d(view);
        v4.m.e(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity activityC = c(view.getContext());
        if (activityC == null) {
            return l(view.getContext().getApplicationContext());
        }
        if (!(activityC instanceof androidx.fragment.app.g)) {
            android.app.Fragment fragmentG = g(view, activityC);
            return fragmentG == null ? j(activityC) : k(fragmentG);
        }
        androidx.fragment.app.g gVar = (androidx.fragment.app.g) activityC;
        Fragment fragmentH = h(view, gVar);
        return fragmentH != null ? n(fragmentH) : o(gVar);
    }

    @n0
    public com.bumptech.glide.i n(@n0 Fragment fragment) {
        v4.m.e(fragment.X1(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (v4.o.t()) {
            return l(fragment.X1().getApplicationContext());
        }
        if (fragment.w1() != null) {
            this.f46391i.a(fragment.w1());
        }
        return v(fragment.X1(), fragment.U1(), fragment, fragment.C3());
    }

    @n0
    public com.bumptech.glide.i o(@n0 androidx.fragment.app.g gVar) {
        if (v4.o.t()) {
            return l(gVar.getApplicationContext());
        }
        a(gVar);
        this.f46391i.a(gVar);
        return v(gVar, gVar.n3(), null, u(gVar));
    }

    @n0
    public final com.bumptech.glide.i p(@n0 Context context) {
        if (this.f46383a == null) {
            synchronized (this) {
                if (this.f46383a == null) {
                    this.f46383a = this.f46387e.a(com.bumptech.glide.b.e(context.getApplicationContext()), new p4.b(), new h(), context.getApplicationContext());
                }
            }
        }
        return this.f46383a;
    }

    @n0
    @Deprecated
    public o q(Activity activity) {
        return r(activity.getFragmentManager(), null);
    }

    @n0
    public final o r(@n0 FragmentManager fragmentManager, @p0 android.app.Fragment fragment) {
        o oVar = this.f46384b.get(fragmentManager);
        if (oVar != null) {
            return oVar;
        }
        o oVar2 = (o) fragmentManager.findFragmentByTag(f46376j);
        if (oVar2 == null) {
            oVar2 = new o();
            oVar2.j(fragment);
            this.f46384b.put(fragmentManager, oVar2);
            fragmentManager.beginTransaction().add(oVar2, f46376j).commitAllowingStateLoss();
            this.f46386d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return oVar2;
    }

    @n0
    public SupportRequestManagerFragment s(androidx.fragment.app.FragmentManager fragmentManager) {
        return t(fragmentManager, null);
    }

    @n0
    public final SupportRequestManagerFragment t(@n0 androidx.fragment.app.FragmentManager fragmentManager, @p0 Fragment fragment) {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f46385c.get(fragmentManager);
        if (supportRequestManagerFragment != null) {
            return supportRequestManagerFragment;
        }
        SupportRequestManagerFragment supportRequestManagerFragment2 = (SupportRequestManagerFragment) fragmentManager.s0(f46376j);
        if (supportRequestManagerFragment2 == null) {
            supportRequestManagerFragment2 = new SupportRequestManagerFragment();
            supportRequestManagerFragment2.O5(fragment);
            this.f46385c.put(fragmentManager, supportRequestManagerFragment2);
            fragmentManager.u().k(supportRequestManagerFragment2, f46376j).r();
            this.f46386d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return supportRequestManagerFragment2;
    }

    @n0
    public final com.bumptech.glide.i v(@n0 Context context, @n0 androidx.fragment.app.FragmentManager fragmentManager, @p0 Fragment fragment, boolean z10) {
        SupportRequestManagerFragment supportRequestManagerFragmentT = t(fragmentManager, fragment);
        com.bumptech.glide.i iVarI5 = supportRequestManagerFragmentT.I5();
        if (iVarI5 == null) {
            iVarI5 = this.f46387e.a(com.bumptech.glide.b.e(context), supportRequestManagerFragmentT.G5(), supportRequestManagerFragmentT.J5(), context);
            if (z10) {
                iVarI5.b();
            }
            supportRequestManagerFragmentT.P5(iVarI5);
        }
        return iVarI5;
    }

    public final boolean w(FragmentManager fragmentManager, boolean z10) {
        o oVar = this.f46384b.get(fragmentManager);
        o oVar2 = (o) fragmentManager.findFragmentByTag(f46376j);
        if (oVar2 == oVar) {
            return true;
        }
        if (oVar2 != null && oVar2.e() != null) {
            throw new IllegalStateException("We've added two fragments with requests! Old: " + oVar2 + " New: " + oVar);
        }
        if (z10 || fragmentManager.isDestroyed()) {
            if (Log.isLoggable(f46377k, 5)) {
                fragmentManager.isDestroyed();
            }
            oVar.c().c();
            return true;
        }
        FragmentTransaction fragmentTransactionAdd = fragmentManager.beginTransaction().add(oVar, f46376j);
        if (oVar2 != null) {
            fragmentTransactionAdd.remove(oVar2);
        }
        fragmentTransactionAdd.commitAllowingStateLoss();
        this.f46386d.obtainMessage(1, 1, 0, fragmentManager).sendToTarget();
        return false;
    }

    public final boolean x(androidx.fragment.app.FragmentManager fragmentManager, boolean z10) {
        SupportRequestManagerFragment supportRequestManagerFragment = this.f46385c.get(fragmentManager);
        SupportRequestManagerFragment supportRequestManagerFragment2 = (SupportRequestManagerFragment) fragmentManager.s0(f46376j);
        if (supportRequestManagerFragment2 == supportRequestManagerFragment) {
            return true;
        }
        if (supportRequestManagerFragment2 != null && supportRequestManagerFragment2.I5() != null) {
            throw new IllegalStateException("We've added two fragments with requests! Old: " + supportRequestManagerFragment2 + " New: " + supportRequestManagerFragment);
        }
        if (z10 || fragmentManager.V0()) {
            fragmentManager.V0();
            supportRequestManagerFragment.G5().c();
            return true;
        }
        g0 g0VarK = fragmentManager.u().k(supportRequestManagerFragment, f46376j);
        if (supportRequestManagerFragment2 != null) {
            g0VarK.B(supportRequestManagerFragment2);
        }
        g0VarK.t();
        this.f46386d.obtainMessage(2, 1, 0, fragmentManager).sendToTarget();
        return false;
    }
}

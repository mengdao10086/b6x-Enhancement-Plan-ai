package p3;

import android.R;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.app.hubert.guide.lifecycle.V4ListenerFragment;
import java.lang.reflect.Field;
import java.security.InvalidParameterException;
import java.util.List;
import p3.c;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f46327p = "listener_fragment";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f46328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Fragment f46329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public androidx.fragment.app.Fragment f46330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public r3.b f46331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r3.e f46332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f46333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f46334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f46335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<com.app.hubert.guide.model.a> f46336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f46337j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p3.c f46338k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FrameLayout f46339l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public SharedPreferences f46340m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f46341n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f46342o;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f46343a;

        public a(int i10) {
            this.f46343a = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f46336i == null || b.this.f46336i.size() == 0) {
                throw new IllegalStateException("there is no guide to show!! Please add at least one Page.");
            }
            b.this.f46337j = 0;
            b.this.q();
            if (b.this.f46331d != null) {
                b.this.f46331d.b(b.this);
            }
            b.this.i();
            b.this.f46340m.edit().putInt(b.this.f46333f, this.f46343a + 1).apply();
        }
    }

    /* JADX INFO: renamed from: p3.b$b, reason: collision with other inner class name */
    public class C0521b implements c.e {
        public C0521b() {
        }

        @Override // p3.c.e
        public void a(p3.c cVar) {
            b.this.q();
        }
    }

    public class c implements c.e {
        public c() {
        }

        @Override // p3.c.e
        public void a(p3.c cVar) {
            b.this.r();
        }
    }

    public class d extends q3.b {
        public d() {
        }

        @Override // q3.b, q3.a
        public void d() {
            t3.a.f("ListenerFragment.onDestroyView");
            b.this.l();
        }
    }

    public class e extends q3.b {
        public e() {
        }

        @Override // q3.b, q3.a
        public void d() {
            t3.a.f("v4ListenerFragment.onDestroyView");
            b.this.l();
        }
    }

    public b(p3.a aVar) {
        this.f46341n = -1;
        Activity activity = aVar.f46317a;
        this.f46328a = activity;
        this.f46329b = aVar.f46318b;
        this.f46330c = aVar.f46319c;
        this.f46331d = aVar.f46324h;
        this.f46332e = aVar.f46325i;
        this.f46333f = aVar.f46320d;
        this.f46334g = aVar.f46321e;
        this.f46336i = aVar.f46326j;
        this.f46335h = aVar.f46323g;
        View viewFindViewById = aVar.f46322f;
        viewFindViewById = viewFindViewById == null ? activity.findViewById(R.id.content) : viewFindViewById;
        if (viewFindViewById instanceof FrameLayout) {
            this.f46339l = (FrameLayout) viewFindViewById;
        } else {
            FrameLayout frameLayout = new FrameLayout(this.f46328a);
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            this.f46341n = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            int i10 = this.f46341n;
            if (i10 >= 0) {
                viewGroup.addView(frameLayout, i10, viewFindViewById.getLayoutParams());
            } else {
                viewGroup.addView(frameLayout, viewFindViewById.getLayoutParams());
            }
            frameLayout.addView(viewFindViewById, new ViewGroup.LayoutParams(-1, -1));
            this.f46339l = frameLayout;
        }
        this.f46340m = this.f46328a.getSharedPreferences("NewbieGuide", 0);
    }

    public final void i() {
        Fragment fragment = this.f46329b;
        if (fragment != null) {
            j(fragment);
            FragmentManager childFragmentManager = this.f46329b.getChildFragmentManager();
            q3.c cVar = (q3.c) childFragmentManager.findFragmentByTag(f46327p);
            if (cVar == null) {
                cVar = new q3.c();
                childFragmentManager.beginTransaction().add(cVar, f46327p).commitAllowingStateLoss();
            }
            cVar.a(new d());
        }
        androidx.fragment.app.Fragment fragment2 = this.f46330c;
        if (fragment2 == null || !fragment2.s3()) {
            return;
        }
        androidx.fragment.app.FragmentManager fragmentManagerU1 = this.f46330c.U1();
        V4ListenerFragment v4ListenerFragment = (V4ListenerFragment) fragmentManagerU1.s0(f46327p);
        if (v4ListenerFragment == null) {
            v4ListenerFragment = new V4ListenerFragment();
            fragmentManagerU1.u().k(v4ListenerFragment, f46327p).r();
        }
        v4ListenerFragment.E5(new e());
    }

    public final void j(Fragment fragment) {
        try {
            Field declaredField = Fragment.class.getDeclaredField("mChildFragmentManager");
            declaredField.setAccessible(true);
            declaredField.set(fragment, null);
        } catch (IllegalAccessException e10) {
            throw new RuntimeException(e10);
        } catch (NoSuchFieldException e11) {
            throw new RuntimeException(e11);
        }
    }

    public boolean k() {
        return this.f46342o;
    }

    public void l() {
        p3.c cVar = this.f46338k;
        if (cVar != null && cVar.getParent() != null) {
            ViewGroup viewGroup = (ViewGroup) this.f46338k.getParent();
            viewGroup.removeView(this.f46338k);
            if (!(viewGroup instanceof FrameLayout)) {
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
                View childAt = viewGroup.getChildAt(0);
                viewGroup.removeAllViews();
                if (childAt != null) {
                    int i10 = this.f46341n;
                    if (i10 > 0) {
                        viewGroup2.addView(childAt, i10, viewGroup.getLayoutParams());
                    } else {
                        viewGroup2.addView(childAt, viewGroup.getLayoutParams());
                    }
                }
            }
            r3.b bVar = this.f46331d;
            if (bVar != null) {
                bVar.a(this);
            }
            this.f46338k = null;
        }
        this.f46342o = false;
    }

    public final void m() {
        Fragment fragment = this.f46329b;
        if (fragment != null) {
            FragmentManager childFragmentManager = fragment.getChildFragmentManager();
            q3.c cVar = (q3.c) childFragmentManager.findFragmentByTag(f46327p);
            if (cVar != null) {
                childFragmentManager.beginTransaction().remove(cVar).commitAllowingStateLoss();
            }
        }
        androidx.fragment.app.Fragment fragment2 = this.f46330c;
        if (fragment2 != null) {
            androidx.fragment.app.FragmentManager fragmentManagerU1 = fragment2.U1();
            V4ListenerFragment v4ListenerFragment = (V4ListenerFragment) fragmentManagerU1.s0(f46327p);
            if (v4ListenerFragment != null) {
                fragmentManagerU1.u().B(v4ListenerFragment).r();
            }
        }
    }

    public void n() {
        o(this.f46333f);
    }

    public void o(String str) {
        this.f46340m.edit().putInt(str, 0).apply();
    }

    public void p() {
        int i10 = this.f46340m.getInt(this.f46333f, 0);
        if ((this.f46334g || i10 < this.f46335h) && !this.f46342o) {
            this.f46342o = true;
            this.f46339l.post(new a(i10));
        }
    }

    public final void q() {
        p3.c cVar = new p3.c(this.f46328a, this.f46336i.get(this.f46337j), this);
        cVar.setOnGuideLayoutDismissListener(new c());
        this.f46339l.addView(cVar, new FrameLayout.LayoutParams(-1, -1));
        this.f46338k = cVar;
        r3.e eVar = this.f46332e;
        if (eVar != null) {
            eVar.a(this.f46337j);
        }
        this.f46342o = true;
    }

    public final void r() {
        if (this.f46337j < this.f46336i.size() - 1) {
            this.f46337j++;
            q();
            return;
        }
        r3.b bVar = this.f46331d;
        if (bVar != null) {
            bVar.a(this);
        }
        m();
        this.f46342o = false;
    }

    public void s(int i10) {
        if (i10 < 0 || i10 > this.f46336i.size() - 1) {
            throw new InvalidParameterException("The Guide page position is out of range. current:" + i10 + ", range: [ 0, " + this.f46336i.size() + " )");
        }
        if (this.f46337j == i10) {
            return;
        }
        this.f46337j = i10;
        p3.c cVar = this.f46338k;
        if (cVar == null) {
            q();
        } else {
            cVar.setOnGuideLayoutDismissListener(new C0521b());
            this.f46338k.h();
        }
    }

    public void t() {
        int i10 = this.f46337j - 1;
        this.f46337j = i10;
        s(i10);
    }
}

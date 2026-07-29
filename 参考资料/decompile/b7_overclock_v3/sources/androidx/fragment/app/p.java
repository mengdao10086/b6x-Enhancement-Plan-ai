package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import g.p0;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final CopyOnWriteArrayList<a> f6023a = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.n0
    public final FragmentManager f6024b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.n0
        public final FragmentManager.m f6025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f6026b;

        public a(@g.n0 FragmentManager.m mVar, boolean z10) {
            this.f6025a = mVar;
            this.f6026b = z10;
        }
    }

    public p(@g.n0 FragmentManager fragmentManager) {
        this.f6024b = fragmentManager;
    }

    public void a(@g.n0 Fragment fragment, @p0 Bundle bundle, boolean z10) {
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().a(fragment, bundle, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.a(this.f6024b, fragment, bundle);
            }
        }
    }

    public void b(@g.n0 Fragment fragment, boolean z10) {
        Context contextG = this.f6024b.J0().g();
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().b(fragment, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.b(this.f6024b, fragment, contextG);
            }
        }
    }

    public void c(@g.n0 Fragment fragment, @p0 Bundle bundle, boolean z10) {
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().c(fragment, bundle, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.c(this.f6024b, fragment, bundle);
            }
        }
    }

    public void d(@g.n0 Fragment fragment, boolean z10) {
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().d(fragment, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.d(this.f6024b, fragment);
            }
        }
    }

    public void e(@g.n0 Fragment fragment, boolean z10) {
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().e(fragment, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.e(this.f6024b, fragment);
            }
        }
    }

    public void f(@g.n0 Fragment fragment, boolean z10) {
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().f(fragment, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.f(this.f6024b, fragment);
            }
        }
    }

    public void g(@g.n0 Fragment fragment, boolean z10) {
        Context contextG = this.f6024b.J0().g();
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().g(fragment, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.g(this.f6024b, fragment, contextG);
            }
        }
    }

    public void h(@g.n0 Fragment fragment, @p0 Bundle bundle, boolean z10) {
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().h(fragment, bundle, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.h(this.f6024b, fragment, bundle);
            }
        }
    }

    public void i(@g.n0 Fragment fragment, boolean z10) {
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().i(fragment, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.i(this.f6024b, fragment);
            }
        }
    }

    public void j(@g.n0 Fragment fragment, @g.n0 Bundle bundle, boolean z10) {
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().j(fragment, bundle, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.j(this.f6024b, fragment, bundle);
            }
        }
    }

    public void k(@g.n0 Fragment fragment, boolean z10) {
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().k(fragment, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.k(this.f6024b, fragment);
            }
        }
    }

    public void l(@g.n0 Fragment fragment, boolean z10) {
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().l(fragment, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.l(this.f6024b, fragment);
            }
        }
    }

    public void m(@g.n0 Fragment fragment, @g.n0 View view, @p0 Bundle bundle, boolean z10) {
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().m(fragment, view, bundle, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.m(this.f6024b, fragment, view, bundle);
            }
        }
    }

    public void n(@g.n0 Fragment fragment, boolean z10) {
        Fragment fragmentM0 = this.f6024b.M0();
        if (fragmentM0 != null) {
            fragmentM0.L2().L0().n(fragment, true);
        }
        for (a aVar : this.f6023a) {
            if (!z10 || aVar.f6026b) {
                aVar.f6025a.n(this.f6024b, fragment);
            }
        }
    }

    public void o(@g.n0 FragmentManager.m mVar, boolean z10) {
        this.f6023a.add(new a(mVar, z10));
    }

    public void p(@g.n0 FragmentManager.m mVar) {
        synchronized (this.f6023a) {
            int i10 = 0;
            int size = this.f6023a.size();
            while (true) {
                if (i10 >= size) {
                    break;
                }
                if (this.f6023a.get(i10).f6025a == mVar) {
                    this.f6023a.remove(i10);
                    break;
                }
                i10++;
            }
        }
    }
}

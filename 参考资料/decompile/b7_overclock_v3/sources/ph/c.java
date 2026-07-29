package ph;

import android.app.Activity;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import com.zhihu.matisse.MimeType;
import com.zhihu.matisse.ui.MatisseActivity;
import g.d1;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f46674a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final th.c f46675b;

    public c(b bVar, @n0 Set<MimeType> set, boolean z10) {
        this.f46674a = bVar;
        th.c cVarA = th.c.a();
        this.f46675b = cVarA;
        cVarA.f51292a = set;
        cVarA.f51293b = z10;
        cVarA.f51296e = -1;
    }

    public c a(@n0 sh.a aVar) {
        th.c cVar = this.f46675b;
        if (cVar.f51301j == null) {
            cVar.f51301j = new ArrayList();
        }
        if (aVar == null) {
            throw new IllegalArgumentException("filter cannot be null");
        }
        this.f46675b.f51301j.add(aVar);
        return this;
    }

    public c b(boolean z10) {
        this.f46675b.f51311t = z10;
        return this;
    }

    public c c(boolean z10) {
        this.f46675b.f51302k = z10;
        return this;
    }

    public c d(th.a aVar) {
        this.f46675b.f51303l = aVar;
        return this;
    }

    public c e(boolean z10) {
        this.f46675b.f51297f = z10;
        return this;
    }

    public void f(int i10) {
        Activity activityE = this.f46674a.e();
        if (activityE == null) {
            return;
        }
        Intent intent = new Intent(activityE, (Class<?>) MatisseActivity.class);
        Fragment fragmentF = this.f46674a.f();
        if (fragmentF != null) {
            fragmentF.z5(intent, i10);
        } else {
            activityE.startActivityForResult(intent, i10);
        }
    }

    public c g(int i10) {
        this.f46675b.f51305n = i10;
        return this;
    }

    public c h(qh.a aVar) {
        this.f46675b.f51307p = aVar;
        return this;
    }

    public c i(int i10) {
        this.f46675b.f51312u = i10;
        return this;
    }

    public c j(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("maxSelectable must be greater than or equal to one");
        }
        th.c cVar = this.f46675b;
        if (cVar.f51299h > 0 || cVar.f51300i > 0) {
            throw new IllegalStateException("already set maxImageSelectable and maxVideoSelectable");
        }
        cVar.f51298g = i10;
        return this;
    }

    public c k(int i10, int i11) {
        if (i10 < 1 || i11 < 1) {
            throw new IllegalArgumentException("max selectable must be greater than or equal to one");
        }
        th.c cVar = this.f46675b;
        cVar.f51298g = -1;
        cVar.f51299h = i10;
        cVar.f51300i = i11;
        return this;
    }

    public c l(boolean z10) {
        this.f46675b.f51310s = z10;
        return this;
    }

    public c m(int i10) {
        this.f46675b.f51296e = i10;
        return this;
    }

    public c n(@p0 ai.a aVar) {
        this.f46675b.f51313v = aVar;
        return this;
    }

    @n0
    public c o(@p0 ai.c cVar) {
        this.f46675b.f51309r = cVar;
        return this;
    }

    public c p(boolean z10) {
        this.f46675b.f51314w = z10;
        return this;
    }

    public c q(boolean z10) {
        this.f46675b.f51294c = z10;
        return this;
    }

    public c r(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException("spanCount cannot be less than 1");
        }
        this.f46675b.f51304m = i10;
        return this;
    }

    public c s(@d1 int i10) {
        this.f46675b.f51295d = i10;
        return this;
    }

    public c t(float f10) {
        if (f10 <= 0.0f || f10 > 1.0f) {
            throw new IllegalArgumentException("Thumbnail scale must be between (0.0, 1.0]");
        }
        this.f46675b.f51306o = f10;
        return this;
    }
}

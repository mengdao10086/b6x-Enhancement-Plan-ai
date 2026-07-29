package l;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;
import androidx.core.view.b1;
import androidx.core.view.c1;
import androidx.core.view.d1;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Interpolator f39327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c1 f39328d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f39329e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f39326b = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final d1 f39330f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<b1> f39325a = new ArrayList<>();

    public class a extends d1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f39331a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f39332b = 0;

        public a() {
        }

        @Override // androidx.core.view.d1, androidx.core.view.c1
        public void b(View view) {
            int i10 = this.f39332b + 1;
            this.f39332b = i10;
            if (i10 == h.this.f39325a.size()) {
                c1 c1Var = h.this.f39328d;
                if (c1Var != null) {
                    c1Var.b(null);
                }
                d();
            }
        }

        @Override // androidx.core.view.d1, androidx.core.view.c1
        public void c(View view) {
            if (this.f39331a) {
                return;
            }
            this.f39331a = true;
            c1 c1Var = h.this.f39328d;
            if (c1Var != null) {
                c1Var.c(null);
            }
        }

        public void d() {
            this.f39332b = 0;
            this.f39331a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f39329e) {
            Iterator<b1> it2 = this.f39325a.iterator();
            while (it2.hasNext()) {
                it2.next().d();
            }
            this.f39329e = false;
        }
    }

    public void b() {
        this.f39329e = false;
    }

    public h c(b1 b1Var) {
        if (!this.f39329e) {
            this.f39325a.add(b1Var);
        }
        return this;
    }

    public h d(b1 b1Var, b1 b1Var2) {
        this.f39325a.add(b1Var);
        b1Var2.w(b1Var.e());
        this.f39325a.add(b1Var2);
        return this;
    }

    public h e(long j10) {
        if (!this.f39329e) {
            this.f39326b = j10;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f39329e) {
            this.f39327c = interpolator;
        }
        return this;
    }

    public h g(c1 c1Var) {
        if (!this.f39329e) {
            this.f39328d = c1Var;
        }
        return this;
    }

    public void h() {
        if (this.f39329e) {
            return;
        }
        for (b1 b1Var : this.f39325a) {
            long j10 = this.f39326b;
            if (j10 >= 0) {
                b1Var.s(j10);
            }
            Interpolator interpolator = this.f39327c;
            if (interpolator != null) {
                b1Var.t(interpolator);
            }
            if (this.f39328d != null) {
                b1Var.u(this.f39330f);
            }
            b1Var.y();
        }
        this.f39329e = true;
    }
}

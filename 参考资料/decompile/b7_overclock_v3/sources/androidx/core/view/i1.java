package androidx.core.view;

import android.annotation.SuppressLint;
import android.view.WindowInsetsAnimationController;
import com.google.common.collect.LinkedHashMultimap;

/* JADX INFO: loaded from: classes2.dex */
public final class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f4922a;

    @g.v0(30)
    public static class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WindowInsetsAnimationController f4923a;

        public a(@g.n0 WindowInsetsAnimationController windowInsetsAnimationController) {
            this.f4923a = windowInsetsAnimationController;
        }

        @Override // androidx.core.view.i1.b
        public void a(boolean z10) {
            this.f4923a.finish(z10);
        }

        @Override // androidx.core.view.i1.b
        public float b() {
            return this.f4923a.getCurrentAlpha();
        }

        @Override // androidx.core.view.i1.b
        public float c() {
            return this.f4923a.getCurrentFraction();
        }

        @Override // androidx.core.view.i1.b
        @g.n0
        public m0.i d() {
            return m0.i.g(this.f4923a.getCurrentInsets());
        }

        @Override // androidx.core.view.i1.b
        @g.n0
        public m0.i e() {
            return m0.i.g(this.f4923a.getHiddenStateInsets());
        }

        @Override // androidx.core.view.i1.b
        @g.n0
        public m0.i f() {
            return m0.i.g(this.f4923a.getShownStateInsets());
        }

        @Override // androidx.core.view.i1.b
        @SuppressLint({"WrongConstant"})
        public int g() {
            return this.f4923a.getTypes();
        }

        @Override // androidx.core.view.i1.b
        public boolean h() {
            return this.f4923a.isCancelled();
        }

        @Override // androidx.core.view.i1.b
        public boolean i() {
            return this.f4923a.isFinished();
        }

        @Override // androidx.core.view.i1.b
        public void j(@g.p0 m0.i iVar, float f10, float f11) {
            this.f4923a.setInsetsAndAlpha(iVar == null ? null : iVar.h(), f10, f11);
        }
    }

    public static class b {
        public void a(boolean z10) {
        }

        public float b() {
            return 0.0f;
        }

        @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
        public float c() {
            return 0.0f;
        }

        @g.n0
        public m0.i d() {
            return m0.i.f40558e;
        }

        @g.n0
        public m0.i e() {
            return m0.i.f40558e;
        }

        @g.n0
        public m0.i f() {
            return m0.i.f40558e;
        }

        public int g() {
            return 0;
        }

        public boolean h() {
            return true;
        }

        public boolean i() {
            return false;
        }

        public void j(@g.p0 m0.i iVar, @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f11) {
        }
    }

    @g.v0(30)
    public i1(@g.n0 WindowInsetsAnimationController windowInsetsAnimationController) {
        this.f4922a = new a(windowInsetsAnimationController);
    }

    public void a(boolean z10) {
        this.f4922a.a(z10);
    }

    public float b() {
        return this.f4922a.b();
    }

    @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR)
    public float c() {
        return this.f4922a.c();
    }

    @g.n0
    public m0.i d() {
        return this.f4922a.d();
    }

    @g.n0
    public m0.i e() {
        return this.f4922a.e();
    }

    @g.n0
    public m0.i f() {
        return this.f4922a.f();
    }

    public int g() {
        return this.f4922a.g();
    }

    public boolean h() {
        return this.f4922a.h();
    }

    public boolean i() {
        return this.f4922a.i();
    }

    public boolean j() {
        return (i() || h()) ? false : true;
    }

    public void k(@g.p0 m0.i iVar, @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10, @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f11) {
        this.f4922a.j(iVar, f10, f11);
    }
}

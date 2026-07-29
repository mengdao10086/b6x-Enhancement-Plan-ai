package vd;

import android.app.Activity;
import g.d1;
import g.n0;
import vd.g;

/* JADX INFO: loaded from: classes3.dex */
public class h {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g.f f53072d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g.e f53073e = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @d1
    public final int f53074a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final g.f f53075b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final g.e f53076c;

    public class a implements g.f {
        @Override // vd.g.f
        public boolean a(@n0 Activity activity, int i10) {
            return true;
        }
    }

    public class b implements g.e {
        @Override // vd.g.e
        public void a(@n0 Activity activity) {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @d1
        public int f53077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @n0
        public g.f f53078b = h.f53072d;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public g.e f53079c = h.f53073e;

        @n0
        public h d() {
            return new h(this, null);
        }

        @n0
        public c e(@n0 g.e eVar) {
            this.f53079c = eVar;
            return this;
        }

        @n0
        public c f(@n0 g.f fVar) {
            this.f53078b = fVar;
            return this;
        }

        @n0
        public c g(@d1 int i10) {
            this.f53077a = i10;
            return this;
        }
    }

    public /* synthetic */ h(c cVar, a aVar) {
        this(cVar);
    }

    @n0
    public g.e c() {
        return this.f53076c;
    }

    @n0
    public g.f d() {
        return this.f53075b;
    }

    @d1
    public int e() {
        return this.f53074a;
    }

    public h(c cVar) {
        this.f53074a = cVar.f53077a;
        this.f53075b = cVar.f53078b;
        this.f53076c = cVar.f53079c;
    }
}

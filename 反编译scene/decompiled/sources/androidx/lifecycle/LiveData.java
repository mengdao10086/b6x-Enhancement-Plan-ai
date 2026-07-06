package androidx.lifecycle;

import a.a9;
import a.hn;
import a.i9;
import a.kn;
import a.rn;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class LiveData<T> {
    public static final Object d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f4282a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f4284b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f4281a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i9<rn<? super T>, LiveData<T>.a> f4280a = new i9<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8206a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public volatile Object f4283b = d;
    public volatile Object c = d;
    public int b = -1;

    public class LifecycleBoundObserver extends LiveData<T>.a implements Object {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kn f8207a;
        public final /* synthetic */ LiveData b;

        public void a(kn knVar, hn.a aVar) {
            if (this.f8207a.getLifecycle().b() == hn.b.DESTROYED) {
                this.b.f(((a) this).f4285a);
            } else {
                h(j());
            }
        }

        @Override // androidx.lifecycle.LiveData.a
        public void i() {
            this.f8207a.getLifecycle().c(this);
        }

        @Override // androidx.lifecycle.LiveData.a
        public boolean j() {
            return this.f8207a.getLifecycle().b().a(hn.b.STARTED);
        }
    }

    public abstract class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f8208a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final rn<? super T> f4285a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ LiveData f4286a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4287a;

        public void h(boolean z) {
            if (z == this.f4287a) {
                return;
            }
            this.f4287a = z;
            boolean z2 = this.f4286a.f8206a == 0;
            this.f4286a.f8206a += this.f4287a ? 1 : -1;
            if (z2 && this.f4287a) {
                this.f4286a.d();
            }
            LiveData liveData = this.f4286a;
            if (liveData.f8206a == 0 && !this.f4287a) {
                liveData.e();
            }
            if (this.f4287a) {
                this.f4286a.c(this);
            }
        }

        public abstract void i();

        public abstract boolean j();
    }

    public static void a(String str) {
        if (a9.b().a()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public final void b(LiveData<T>.a aVar) {
        if (aVar.f4287a) {
            if (!aVar.j()) {
                aVar.h(false);
                return;
            }
            int i = aVar.f8208a;
            int i2 = this.b;
            if (i >= i2) {
                return;
            }
            aVar.f8208a = i2;
            aVar.f4285a.a((Object) this.f4283b);
        }
    }

    public void c(LiveData<T>.a aVar) {
        if (this.f4282a) {
            this.f4284b = true;
            return;
        }
        this.f4282a = true;
        do {
            this.f4284b = false;
            if (aVar != null) {
                b(aVar);
                aVar = null;
            } else {
                i9<rn<? super T>, LiveData<T>.a>.a aVarD = this.f4280a.d();
                while (aVarD.hasNext()) {
                    b((a) aVarD.next().getValue());
                    if (this.f4284b) {
                        break;
                    }
                }
            }
        } while (this.f4284b);
        this.f4282a = false;
    }

    public void d() {
    }

    public void e() {
    }

    public void f(rn<? super T> rnVar) {
        a("removeObserver");
        LiveData<T>.a aVarG = this.f4280a.g(rnVar);
        if (aVarG == null) {
            return;
        }
        aVarG.i();
        aVarG.h(false);
    }

    public void g(T t) {
        a("setValue");
        this.b++;
        this.f4283b = t;
        c(null);
    }
}

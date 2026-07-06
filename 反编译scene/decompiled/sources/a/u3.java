package a;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class u3 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public mh f3117a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Interpolator f3119a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3121a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7561a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nh f3118a = new t3(this);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<lh> f3120a = new ArrayList<>();

    public void a() {
        if (this.f3121a) {
            Iterator<lh> it = this.f3120a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f3121a = false;
        }
    }

    public void b() {
        this.f3121a = false;
    }

    public u3 c(lh lhVar) {
        if (!this.f3121a) {
            this.f3120a.add(lhVar);
        }
        return this;
    }

    public u3 d(lh lhVar, lh lhVar2) {
        this.f3120a.add(lhVar);
        lhVar2.h(lhVar.c());
        this.f3120a.add(lhVar2);
        return this;
    }

    public u3 e(long j) {
        if (!this.f3121a) {
            this.f7561a = j;
        }
        return this;
    }

    public u3 f(Interpolator interpolator) {
        if (!this.f3121a) {
            this.f3119a = interpolator;
        }
        return this;
    }

    public u3 g(mh mhVar) {
        if (!this.f3121a) {
            this.f3117a = mhVar;
        }
        return this;
    }

    public void h() {
        if (this.f3121a) {
            return;
        }
        for (lh lhVar : this.f3120a) {
            long j = this.f7561a;
            if (j >= 0) {
                lhVar.d(j);
            }
            Interpolator interpolator = this.f3119a;
            if (interpolator != null) {
                lhVar.e(interpolator);
            }
            if (this.f3117a != null) {
                lhVar.f(this.f3118a);
            }
            lhVar.j();
        }
        this.f3121a = true;
    }
}

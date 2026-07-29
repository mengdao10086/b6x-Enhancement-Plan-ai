package l2;

import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import androidx.work.ArrayCreatingInputMerger;
import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkInfo;
import androidx.work.impl.workers.CombineContinuationsWorker;
import androidx.work.l;
import androidx.work.m;
import androidx.work.o;
import androidx.work.u;
import androidx.work.x;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class g extends u {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f39361j = l.f("WorkContinuationImpl");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f39362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f39363b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ExistingWorkPolicy f39364c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<? extends x> f39365d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<String> f39366e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<String> f39367f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<g> f39368g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f39369h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o f39370i;

    public g(@n0 i workManagerImpl, @n0 List<? extends x> work) {
        this(workManagerImpl, null, ExistingWorkPolicy.KEEP, work, null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static boolean p(@n0 g continuation, @n0 Set<String> visited) {
        visited.addAll(continuation.j());
        Set<String> setS = s(continuation);
        Iterator<String> it2 = visited.iterator();
        while (it2.hasNext()) {
            if (setS.contains(it2.next())) {
                return true;
            }
        }
        List<g> listL = continuation.l();
        if (listL != null && !listL.isEmpty()) {
            Iterator<g> it3 = listL.iterator();
            while (it3.hasNext()) {
                if (p(it3.next(), visited)) {
                    return true;
                }
            }
        }
        visited.removeAll(continuation.j());
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @n0
    public static Set<String> s(g continuation) {
        HashSet hashSet = new HashSet();
        List<g> listL = continuation.l();
        if (listL != null && !listL.isEmpty()) {
            Iterator<g> it2 = listL.iterator();
            while (it2.hasNext()) {
                hashSet.addAll(it2.next().j());
            }
        }
        return hashSet;
    }

    @Override // androidx.work.u
    @n0
    public u b(@n0 List<u> continuations) {
        m mVarB = new m.a(CombineContinuationsWorker.class).t(ArrayCreatingInputMerger.class).b();
        ArrayList arrayList = new ArrayList(continuations.size());
        Iterator<u> it2 = continuations.iterator();
        while (it2.hasNext()) {
            arrayList.add((g) it2.next());
        }
        return new g(this.f39362a, null, ExistingWorkPolicy.KEEP, Collections.singletonList(mVarB), arrayList);
    }

    @Override // androidx.work.u
    @n0
    public o c() {
        if (this.f39369h) {
            l.c().h(f39361j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.f39366e)), new Throwable[0]);
        } else {
            v2.b bVar = new v2.b(this);
            this.f39362a.O().c(bVar);
            this.f39370i = bVar.d();
        }
        return this.f39370i;
    }

    @Override // androidx.work.u
    @n0
    public ListenableFuture<List<WorkInfo>> d() {
        v2.l<List<WorkInfo>> lVarA = v2.l.a(this.f39362a, this.f39367f);
        this.f39362a.O().c(lVarA);
        return lVarA.f();
    }

    @Override // androidx.work.u
    @n0
    public LiveData<List<WorkInfo>> e() {
        return this.f39362a.N(this.f39367f);
    }

    @Override // androidx.work.u
    @n0
    public u g(@n0 List<m> work) {
        return work.isEmpty() ? this : new g(this.f39362a, this.f39363b, ExistingWorkPolicy.KEEP, work, Collections.singletonList(this));
    }

    public List<String> h() {
        return this.f39367f;
    }

    public ExistingWorkPolicy i() {
        return this.f39364c;
    }

    @n0
    public List<String> j() {
        return this.f39366e;
    }

    @p0
    public String k() {
        return this.f39363b;
    }

    public List<g> l() {
        return this.f39368g;
    }

    @n0
    public List<? extends x> m() {
        return this.f39365d;
    }

    @n0
    public i n() {
        return this.f39362a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean o() {
        return p(this, new HashSet());
    }

    public boolean q() {
        return this.f39369h;
    }

    public void r() {
        this.f39369h = true;
    }

    public g(@n0 i workManagerImpl, @p0 String name, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 List<? extends x> work) {
        this(workManagerImpl, name, existingWorkPolicy, work, null);
    }

    public g(@n0 i workManagerImpl, @p0 String name, @n0 ExistingWorkPolicy existingWorkPolicy, @n0 List<? extends x> work, @p0 List<g> parents) {
        this.f39362a = workManagerImpl;
        this.f39363b = name;
        this.f39364c = existingWorkPolicy;
        this.f39365d = work;
        this.f39368g = parents;
        this.f39366e = new ArrayList(work.size());
        this.f39367f = new ArrayList();
        if (parents != null) {
            Iterator<g> it2 = parents.iterator();
            while (it2.hasNext()) {
                this.f39367f.addAll(it2.next().f39367f);
            }
        }
        for (int i10 = 0; i10 < work.size(); i10++) {
            String strB = work.get(i10).b();
            this.f39366e.add(strB);
            this.f39367f.add(strB);
        }
    }
}

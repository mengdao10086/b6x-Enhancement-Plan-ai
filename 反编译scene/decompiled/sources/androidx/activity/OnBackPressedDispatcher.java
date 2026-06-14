package androidx.activity;

import a.hn;
import a.in;
import a.kn;
import a.p;
import a.q;
import a.r;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Runnable f8135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayDeque<q> f3955a = new ArrayDeque<>();

    public class LifecycleOnBackPressedCancellable implements in, p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hn f8136a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public p f3956a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final q f3957a;

        public LifecycleOnBackPressedCancellable(hn hnVar, q qVar) {
            this.f8136a = hnVar;
            this.f3957a = qVar;
            hnVar.a(this);
        }

        @Override // a.in
        public void a(kn knVar, hn.a aVar) {
            if (aVar == hn.a.ON_START) {
                this.f3956a = OnBackPressedDispatcher.this.b(this.f3957a);
                return;
            }
            if (aVar != hn.a.ON_STOP) {
                if (aVar == hn.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                p pVar = this.f3956a;
                if (pVar != null) {
                    pVar.cancel();
                }
            }
        }

        @Override // a.p
        public void cancel() {
            this.f8136a.c(this);
            this.f3957a.e(this);
            p pVar = this.f3956a;
            if (pVar != null) {
                pVar.cancel();
                this.f3956a = null;
            }
        }
    }

    public OnBackPressedDispatcher(Runnable runnable) {
        this.f8135a = runnable;
    }

    public void a(kn knVar, q qVar) {
        hn lifecycle = knVar.getLifecycle();
        if (lifecycle.b() == hn.b.DESTROYED) {
            return;
        }
        qVar.a(new LifecycleOnBackPressedCancellable(lifecycle, qVar));
    }

    public p b(q qVar) {
        this.f3955a.add(qVar);
        r rVar = new r(this, qVar);
        qVar.a(rVar);
        return rVar;
    }

    public void c() {
        Iterator<q> itDescendingIterator = this.f3955a.descendingIterator();
        while (itDescendingIterator.hasNext()) {
            q next = itDescendingIterator.next();
            if (next.c()) {
                next.b();
                return;
            }
        }
        Runnable runnable = this.f8135a;
        if (runnable != null) {
            runnable.run();
        }
    }
}

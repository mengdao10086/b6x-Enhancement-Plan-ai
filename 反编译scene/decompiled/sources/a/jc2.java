package a;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jc2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f6498a = AtomicIntegerFieldUpdater.newUpdater(jc2.class, "notCompletedCount");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fe2<T>[] f1525a;
    public volatile int notCompletedCount;

    public final class a extends wf2<qf2> {
        public volatile Object _disposer;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public re2 f1526a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final tc2<List<? extends T>> f1527a;

        /* JADX WARN: Multi-variable type inference failed */
        public a(tc2<? super List<? extends T>> tc2Var, qf2 qf2Var) {
            super(qf2Var);
            this.f1527a = tc2Var;
            this._disposer = null;
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ m42 f(Throwable th) {
            v(th);
            return m42.f6769a;
        }

        @Override // a.id2
        public void v(Throwable th) {
            if (th != null) {
                Object objL = this.f1527a.l(th);
                if (objL != null) {
                    this.f1527a.o(objL);
                    jc2<T>.b bVarW = w();
                    if (bVarW != null) {
                        bVarW.b();
                        return;
                    }
                    return;
                }
                return;
            }
            if (jc2.f6498a.decrementAndGet(jc2.this) == 0) {
                tc2<List<? extends T>> tc2Var = this.f1527a;
                fe2[] fe2VarArr = jc2.this.f1525a;
                ArrayList arrayList = new ArrayList(fe2VarArr.length);
                for (fe2 fe2Var : fe2VarArr) {
                    arrayList.add(fe2Var.z());
                }
                e42 e42Var = g42.f6169a;
                g42.a(arrayList);
                tc2Var.y(arrayList);
            }
        }

        public final jc2<T>.b w() {
            return (b) this._disposer;
        }

        public final re2 x() {
            re2 re2Var = this.f1526a;
            if (re2Var != null) {
                return re2Var;
            }
            f92.m("handle");
            throw null;
        }

        public final void y(jc2<T>.b bVar) {
            this._disposer = bVar;
        }

        public final void z(re2 re2Var) {
            this.f1526a = re2Var;
        }
    }

    public final class b extends rc2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jc2<T>.a[] f6500a;

        public b(jc2 jc2Var, jc2<T>.a[] aVarArr) {
            this.f6500a = aVarArr;
        }

        @Override // a.sc2
        public void a(Throwable th) {
            b();
        }

        public final void b() {
            for (jc2<T>.a aVar : this.f6500a) {
                aVar.x().b();
            }
        }

        @Override // a.g82
        public /* bridge */ /* synthetic */ m42 f(Throwable th) {
            a(th);
            return m42.f6769a;
        }

        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f6500a + ']';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public jc2(fe2<? extends T>[] fe2VarArr) {
        this.f1525a = fe2VarArr;
        this.notCompletedCount = fe2VarArr.length;
    }

    public final Object b(b62<? super List<? extends T>> b62Var) {
        uc2 uc2Var = new uc2(q62.b(b62Var), 1);
        uc2Var.B();
        int length = this.f1525a.length;
        a[] aVarArr = new a[length];
        for (int i = 0; i < length; i++) {
            fe2 fe2Var = this.f1525a[t62.e(i).intValue()];
            fe2Var.n();
            a aVar = new a(uc2Var, fe2Var);
            aVar.z(fe2Var.k(aVar));
            aVarArr[i] = aVar;
        }
        jc2<T>.b bVar = new b(this, aVarArr);
        for (int i2 = 0; i2 < length; i2++) {
            aVarArr[i2].y(bVar);
        }
        if (uc2Var.g()) {
            bVar.b();
        } else {
            uc2Var.w(bVar);
        }
        Object objZ = uc2Var.z();
        if (objZ == r62.c()) {
            z62.c(b62Var);
        }
        return objZ;
    }
}

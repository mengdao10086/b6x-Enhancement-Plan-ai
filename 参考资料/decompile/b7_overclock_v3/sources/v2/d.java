package v2;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.h0;
import androidx.lifecycle.k0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class d {

    /* JADX INFO: Add missing generic type declarations: [In] */
    public class a<In> implements k0<In> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Out f52572a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ w2.a f52573b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f52574c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ p.a f52575d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ h0 f52576e;

        /* JADX INFO: renamed from: v2.d$a$a, reason: collision with other inner class name */
        public class RunnableC0613a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f52577a;

            public RunnableC0613a(final Object val$input) {
                this.f52577a = val$input;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v3, types: [Out, java.lang.Object] */
            @Override // java.lang.Runnable
            public void run() {
                synchronized (a.this.f52574c) {
                    ?? Apply = a.this.f52575d.apply(this.f52577a);
                    a aVar = a.this;
                    Out out = aVar.f52572a;
                    if (out == 0 && Apply != 0) {
                        aVar.f52572a = Apply;
                        aVar.f52576e.o(Apply);
                    } else if (out != 0 && !out.equals(Apply)) {
                        a aVar2 = a.this;
                        aVar2.f52572a = Apply;
                        aVar2.f52576e.o(Apply);
                    }
                }
            }
        }

        public a(final w2.a val$workTaskExecutor, final Object val$lock, final p.a val$mappingMethod, final h0 val$outputLiveData) {
            this.f52573b = val$workTaskExecutor;
            this.f52574c = val$lock;
            this.f52575d = val$mappingMethod;
            this.f52576e = val$outputLiveData;
        }

        @Override // androidx.lifecycle.k0
        public void b(@p0 final In input) {
            this.f52573b.c(new RunnableC0613a(input));
        }
    }

    public static <In, Out> LiveData<Out> a(@n0 LiveData<In> inputLiveData, @n0 final p.a<In, Out> mappingMethod, @n0 final w2.a workTaskExecutor) {
        Object obj = new Object();
        h0 h0Var = new h0();
        h0Var.s(inputLiveData, new a(workTaskExecutor, obj, mappingMethod, h0Var));
        return h0Var;
    }
}

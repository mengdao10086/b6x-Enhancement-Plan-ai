package androidx.work;

import android.os.Build;
import androidx.work.x;
import g.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class m extends x {

    public static final class a extends x.a<a, m> {
        public a(@n0 Class<? extends ListenableWorker> workerClass) {
            super(workerClass);
            this.f8767c.f51844d = OverwritingInputMerger.class.getName();
        }

        @Override // androidx.work.x.a
        @n0
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public m c() {
            if (this.f8765a && Build.VERSION.SDK_INT >= 23 && this.f8767c.f51850j.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new m(this);
        }

        @Override // androidx.work.x.a
        @n0
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public a d() {
            return this;
        }

        @n0
        public a t(@n0 Class<? extends j> inputMerger) {
            this.f8767c.f51844d = inputMerger.getName();
            return this;
        }
    }

    public m(a builder) {
        super(builder.f8766b, builder.f8767c, builder.f8768d);
    }

    @n0
    public static m e(@n0 Class<? extends ListenableWorker> workerClass) {
        return new a(workerClass).b();
    }

    @n0
    public static List<m> f(@n0 List<Class<? extends ListenableWorker>> workerClasses) {
        ArrayList arrayList = new ArrayList(workerClasses.size());
        Iterator<Class<? extends ListenableWorker>> it2 = workerClasses.iterator();
        while (it2.hasNext()) {
            arrayList.add(new a(it2.next()).b());
        }
        return arrayList;
    }
}

package i0;

import androidx.annotation.RestrictTo;
import g.j1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class f<T> {

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static class a extends f<Void> {
        @Override // i0.f
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Void a(List<e> list) {
            return null;
        }

        @Override // i0.f
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Void c() {
            return null;
        }

        @Override // i0.f
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Void d(List<String> list) {
            return null;
        }
    }

    @g.d
    public abstract T a(List<e> list);

    @j1
    public List<e> b() throws Exception {
        return new ArrayList();
    }

    @g.d
    public abstract T c();

    @g.d
    public abstract T d(List<String> list);
}

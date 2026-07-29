package p1;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.f0;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final Map<b<?>, Object> f46301a = new LinkedHashMap();

    /* JADX INFO: renamed from: p1.a$a, reason: collision with other inner class name */
    public static final class C0519a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @k
        public static final C0519a f46302b = new C0519a();

        @Override // p1.a
        @l
        public <T> T a(@k b<T> key) {
            f0.p(key, "key");
            return null;
        }
    }

    public interface b<T> {
    }

    @l
    public abstract <T> T a(@k b<T> bVar);

    @k
    public final Map<b<?>, Object> b() {
        return this.f46301a;
    }
}

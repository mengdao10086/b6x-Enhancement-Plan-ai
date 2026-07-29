package kotlinx.android.extensions;

import kotlin.jvm.internal.u;
import yt.k;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v1 kotlinx.android.extensions.CacheImplementation, still in use, count: 1, list:
  (r0v1 kotlinx.android.extensions.CacheImplementation) from 0x002c: SPUT (r0v1 kotlinx.android.extensions.CacheImplementation) (LINE:4) kotlinx.android.extensions.CacheImplementation.DEFAULT kotlinx.android.extensions.CacheImplementation
	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: loaded from: classes5.dex */
public final class CacheImplementation {
    SPARSE_ARRAY,
    HASH_MAP,
    NO_CACHE;


    @k
    private static final CacheImplementation DEFAULT = new CacheImplementation();

    @k
    public static final a Companion = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final CacheImplementation a() {
            return CacheImplementation.DEFAULT;
        }
    }

    static {
    }

    private CacheImplementation() {
    }

    public static CacheImplementation valueOf(String str) {
        return (CacheImplementation) Enum.valueOf(CacheImplementation.class, str);
    }

    public static CacheImplementation[] values() {
        return (CacheImplementation[]) $VALUES.clone();
    }
}

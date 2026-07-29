package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.text.StringsKt__StringsKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes5.dex */
@IgnoreJRERequirement
public final class m0 extends kotlin.coroutines.a implements c3<String> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final a f38908c = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f38909b;

    public static final class a implements CoroutineContext.b<m0> {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public m0(long j10) {
        super(f38908c);
        this.f38909b = j10;
    }

    public static /* synthetic */ m0 j2(m0 m0Var, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = m0Var.f38909b;
        }
        return m0Var.i2(j10);
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof m0) && this.f38909b == ((m0) obj).f38909b;
    }

    public final long h2() {
        return this.f38909b;
    }

    public int hashCode() {
        return com.flydigi.data.bean.a.a(this.f38909b);
    }

    @yt.k
    public final m0 i2(long j10) {
        return new m0(j10);
    }

    public final long k2() {
        return this.f38909b;
    }

    @Override // kotlinx.coroutines.c3
    /* JADX INFO: renamed from: l2, reason: merged with bridge method [inline-methods] */
    public void p1(@yt.k CoroutineContext coroutineContext, @yt.k String str) {
        Thread.currentThread().setName(str);
    }

    @Override // kotlinx.coroutines.c3
    @yt.k
    /* JADX INFO: renamed from: m2, reason: merged with bridge method [inline-methods] */
    public String Y1(@yt.k CoroutineContext coroutineContext) {
        String strK2;
        n0 n0Var = (n0) coroutineContext.c(n0.f38910c);
        if (n0Var == null || (strK2 = n0Var.k2()) == null) {
            strK2 = "coroutine";
        }
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        int iG3 = StringsKt__StringsKt.G3(name, CoroutineContextKt.f38231a, 0, false, 6, null);
        if (iG3 < 0) {
            iG3 = name.length();
        }
        StringBuilder sb2 = new StringBuilder(strK2.length() + iG3 + 10);
        String strSubstring = name.substring(0, iG3);
        kotlin.jvm.internal.f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb2.append(strSubstring);
        sb2.append(CoroutineContextKt.f38231a);
        sb2.append(strK2);
        sb2.append('#');
        sb2.append(this.f38909b);
        String string = sb2.toString();
        kotlin.jvm.internal.f0.o(string, "StringBuilder(capacity).…builderAction).toString()");
        threadCurrentThread.setName(string);
        return name;
    }

    @yt.k
    public String toString() {
        return "CoroutineId(" + this.f38909b + ')';
    }
}

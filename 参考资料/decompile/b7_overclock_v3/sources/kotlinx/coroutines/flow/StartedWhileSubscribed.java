package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.t0;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nSharingStarted.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SharingStarted.kt\nkotlinx/coroutines/flow/StartedWhileSubscribed\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,209:1\n1#2:210\n*E\n"})
public final class StartedWhileSubscribed implements r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f38659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f38660c;

    public StartedWhileSubscribed(long j10, long j11) {
        this.f38659b = j10;
        this.f38660c = j11;
        if (!(j10 >= 0)) {
            throw new IllegalArgumentException(("stopTimeout(" + j10 + " ms) cannot be negative").toString());
        }
        if (j11 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("replayExpiration(" + j11 + " ms) cannot be negative").toString());
    }

    @Override // kotlinx.coroutines.flow.r
    @yt.k
    public e<SharingCommand> a(@yt.k u<Integer> uVar) {
        return g.g0(g.k0(g.d2(uVar, new StartedWhileSubscribed$command$1(this, null)), new StartedWhileSubscribed$command$2(null)));
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof StartedWhileSubscribed) {
            StartedWhileSubscribed startedWhileSubscribed = (StartedWhileSubscribed) obj;
            if (this.f38659b == startedWhileSubscribed.f38659b && this.f38660c == startedWhileSubscribed.f38660c) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return (com.flydigi.data.bean.a.a(this.f38659b) * 31) + com.flydigi.data.bean.a.a(this.f38660c);
    }

    @yt.k
    public String toString() {
        List listJ = kotlin.collections.s.j(2);
        if (this.f38659b > 0) {
            listJ.add("stopTimeout=" + this.f38659b + "ms");
        }
        if (this.f38660c < Long.MAX_VALUE) {
            listJ.add("replayExpiration=" + this.f38660c + "ms");
        }
        return "SharingStarted.WhileSubscribed(" + CollectionsKt___CollectionsKt.h3(kotlin.collections.s.a(listJ), null, null, null, 0, null, null, 63, null) + ')';
    }
}

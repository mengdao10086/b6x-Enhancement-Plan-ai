package kotlinx.coroutines.internal;

/* JADX INFO: loaded from: classes5.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final String f38823a;

    public o0(@yt.k String str) {
        this.f38823a = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> T a(@yt.l Object obj) {
        if (obj == this) {
            return null;
        }
        return obj;
    }

    @yt.k
    public String toString() {
        return '<' + this.f38823a + '>';
    }
}

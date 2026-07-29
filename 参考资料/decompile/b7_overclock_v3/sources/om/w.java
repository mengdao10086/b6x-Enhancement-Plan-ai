package om;

/* JADX INFO: loaded from: classes5.dex */
public class w extends gm.t {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final w f44353f = new w(0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final w f44354g = new w(1);

    public w(int i10) {
        super(i10);
    }

    public static w V(int i10) {
        if (i10 == 0) {
            return f44353f;
        }
        if (i10 == 1) {
            return f44354g;
        }
        throw new IllegalArgumentException("unknown value: " + i10);
    }
}

package kotlin;

/* JADX INFO: loaded from: classes5.dex */
public final class d {
    @c2(markerClass = {q.class})
    @bk.f
    @v0(version = "1.5")
    public static final char a(int i10) {
        if (i10 >= 0 && i10 <= 65535) {
            return (char) i10;
        }
        throw new IllegalArgumentException("Invalid Char code: " + i10);
    }

    public static final int b(char c10) {
        return c10;
    }

    @bk.g
    @bk.f
    @v0(version = "1.5")
    @c2(markerClass = {q.class})
    public static /* synthetic */ void c(char c10) {
    }
}

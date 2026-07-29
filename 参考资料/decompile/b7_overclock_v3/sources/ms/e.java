package ms;

/* JADX INFO: loaded from: classes6.dex */
public class e extends o {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f41607h;

    public e() {
        this(11, 50, "SHA-256");
    }

    public e(int i10) {
        this(i10, "SHA-256");
    }

    public e(int i10, int i11) {
        this(i10, i11, "SHA-256");
    }

    public e(int i10, int i11, int i12) {
        this(i10, i11, i12, "SHA-256");
    }

    public e(int i10, int i11, int i12, String str) {
        super(i10, i11, i12);
        this.f41607h = str;
    }

    public e(int i10, int i11, String str) {
        super(i10, i11);
        this.f41607h = str;
    }

    public e(int i10, String str) {
        super(i10);
        this.f41607h = str;
    }

    public e(String str) {
        this(11, 50, str);
    }

    public String e() {
        return this.f41607h;
    }
}

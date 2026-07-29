package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes2.dex */
public class e extends c {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3062h;

    public e(char[] cArr) {
        super(cArr);
        this.f3062h = Float.NaN;
    }

    public static c x(char[] cArr) {
        return new e(cArr);
    }

    @Override // androidx.constraintlayout.core.parser.c
    public float g() {
        if (Float.isNaN(this.f3062h)) {
            this.f3062h = Float.parseFloat(b());
        }
        return this.f3062h;
    }

    @Override // androidx.constraintlayout.core.parser.c
    public int i() {
        if (Float.isNaN(this.f3062h)) {
            this.f3062h = Integer.parseInt(b());
        }
        return (int) this.f3062h;
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String v(int i10, int i11) {
        StringBuilder sb2 = new StringBuilder();
        a(sb2, i10);
        float fG = g();
        int i12 = (int) fG;
        if (i12 == fG) {
            sb2.append(i12);
        } else {
            sb2.append(fG);
        }
        return sb2.toString();
    }

    @Override // androidx.constraintlayout.core.parser.c
    public String w() {
        float fG = g();
        int i10 = (int) fG;
        if (i10 == fG) {
            return "" + i10;
        }
        return "" + fG;
    }

    public boolean y() {
        float fG = g();
        return ((float) ((int) fG)) == fG;
    }

    public void z(float f10) {
        this.f3062h = f10;
    }

    public e(float f10) {
        super(null);
        this.f3062h = f10;
    }
}

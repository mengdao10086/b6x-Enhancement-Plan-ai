package t;

import w.w;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f50522g = "TransitionLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f50523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f50524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f50525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f50526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f50527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f50528f;

    public a(a aVar) {
        this.f50525c = Integer.MIN_VALUE;
        this.f50526d = Float.NaN;
        this.f50527e = null;
        this.f50523a = aVar.f50523a;
        this.f50524b = aVar.f50524b;
        this.f50525c = aVar.f50525c;
        this.f50526d = aVar.f50526d;
        this.f50527e = aVar.f50527e;
        this.f50528f = aVar.f50528f;
    }

    public static int b(int i10) {
        int i11 = (i10 & (~(i10 >> 31))) - 255;
        return (i11 & (i11 >> 31)) + 255;
    }

    public static String c(int i10) {
        return "#" + ("00000000" + Integer.toHexString(i10)).substring(r2.length() - 8);
    }

    public static int p(float f10, float f11, float f12) {
        float f13 = f10 * 6.0f;
        int i10 = (int) f13;
        float f14 = f13 - i10;
        float f15 = f12 * 255.0f;
        int i11 = (int) (((1.0f - f11) * f15) + 0.5f);
        int i12 = (int) (((1.0f - (f14 * f11)) * f15) + 0.5f);
        int i13 = (int) (((1.0f - ((1.0f - f14) * f11)) * f15) + 0.5f);
        int i14 = (int) (f15 + 0.5f);
        if (i10 == 0) {
            return ((i14 << 16) + (i13 << 8) + i11) | (-16777216);
        }
        if (i10 == 1) {
            return ((i12 << 16) + (i14 << 8) + i11) | (-16777216);
        }
        if (i10 == 2) {
            return ((i11 << 16) + (i14 << 8) + i13) | (-16777216);
        }
        if (i10 == 3) {
            return ((i11 << 16) + (i12 << 8) + i14) | (-16777216);
        }
        if (i10 == 4) {
            return ((i13 << 16) + (i11 << 8) + i14) | (-16777216);
        }
        if (i10 != 5) {
            return 0;
        }
        return ((i14 << 16) + (i11 << 8) + i12) | (-16777216);
    }

    public static int s(float f10, float f11, float f12, float f13) {
        int iB = b((int) (f10 * 255.0f));
        int iB2 = b((int) (f11 * 255.0f));
        return (iB << 16) | (b((int) (f13 * 255.0f)) << 24) | (iB2 << 8) | b((int) (f12 * 255.0f));
    }

    public void a(e eVar) {
        int i10 = this.f50524b;
        switch (i10) {
            case 900:
            case 902:
            case w.b.f53680p /* 906 */:
                eVar.J(this.f50523a, i10, this.f50525c);
                break;
            case 901:
            case w.b.f53679o /* 905 */:
                eVar.I(this.f50523a, i10, this.f50526d);
                break;
            case w.b.f53677m /* 903 */:
                eVar.K(this.f50523a, i10, this.f50527e);
                break;
            case w.b.f53678n /* 904 */:
                eVar.L(this.f50523a, i10, this.f50528f);
                break;
        }
    }

    public a d() {
        return new a(this);
    }

    public boolean e(a aVar) {
        int i10;
        if (aVar == null || (i10 = this.f50524b) != aVar.f50524b) {
            return false;
        }
        switch (i10) {
            case 900:
            case w.b.f53680p /* 906 */:
                if (this.f50525c == aVar.f50525c) {
                }
                break;
            case 901:
                if (this.f50526d == aVar.f50526d) {
                }
                break;
            case 902:
                if (this.f50525c == aVar.f50525c) {
                }
                break;
            case w.b.f53677m /* 903 */:
                if (this.f50525c == aVar.f50525c) {
                }
                break;
            case w.b.f53678n /* 904 */:
                if (this.f50528f == aVar.f50528f) {
                }
                break;
            case w.b.f53679o /* 905 */:
                if (this.f50526d == aVar.f50526d) {
                }
                break;
        }
        return false;
    }

    public boolean f() {
        return this.f50528f;
    }

    public int g() {
        return this.f50525c;
    }

    public float h() {
        return this.f50526d;
    }

    public int i() {
        return this.f50525c;
    }

    public int j(float[] fArr) {
        return (b((int) (fArr[3] * 255.0f)) << 24) | (b((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (b((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | b((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f));
    }

    public String k() {
        return this.f50523a;
    }

    public String l() {
        return this.f50527e;
    }

    public int m() {
        return this.f50524b;
    }

    public float n() {
        switch (this.f50524b) {
            case 900:
                return this.f50525c;
            case 901:
                return this.f50526d;
            case 902:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case w.b.f53677m /* 903 */:
                throw new RuntimeException("Cannot interpolate String");
            case w.b.f53678n /* 904 */:
                return this.f50528f ? 1.0f : 0.0f;
            case w.b.f53679o /* 905 */:
                return this.f50526d;
            default:
                return Float.NaN;
        }
    }

    public void o(float[] fArr) {
        switch (this.f50524b) {
            case 900:
                fArr[0] = this.f50525c;
                return;
            case 901:
                fArr[0] = this.f50526d;
                return;
            case 902:
                int i10 = (this.f50525c >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i10 / 255.0f;
                return;
            case w.b.f53677m /* 903 */:
                throw new RuntimeException("Cannot interpolate String");
            case w.b.f53678n /* 904 */:
                fArr[0] = this.f50528f ? 1.0f : 0.0f;
                return;
            case w.b.f53679o /* 905 */:
                fArr[0] = this.f50526d;
                return;
            default:
                return;
        }
    }

    public boolean q() {
        int i10 = this.f50524b;
        return (i10 == 903 || i10 == 904 || i10 == 906) ? false : true;
    }

    public int r() {
        return this.f50524b != 902 ? 1 : 4;
    }

    public void t(boolean z10) {
        this.f50528f = z10;
    }

    public String toString() {
        String str = this.f50523a + ':';
        switch (this.f50524b) {
            case 900:
                return str + this.f50525c;
            case 901:
                return str + this.f50526d;
            case 902:
                return str + c(this.f50525c);
            case w.b.f53677m /* 903 */:
                return str + this.f50527e;
            case w.b.f53678n /* 904 */:
                return str + Boolean.valueOf(this.f50528f);
            case w.b.f53679o /* 905 */:
                return str + this.f50526d;
            default:
                return str + "????";
        }
    }

    public void u(float f10) {
        this.f50526d = f10;
    }

    public void v(int i10) {
        this.f50525c = i10;
    }

    public void w(e eVar, float[] fArr) {
        int i10 = this.f50524b;
        switch (i10) {
            case 900:
                eVar.J(this.f50523a, i10, (int) fArr[0]);
                return;
            case 901:
            case w.b.f53679o /* 905 */:
                eVar.I(this.f50523a, i10, fArr[0]);
                return;
            case 902:
                eVar.J(this.f50523a, this.f50524b, (b((int) (fArr[3] * 255.0f)) << 24) | (b((int) (((float) Math.pow(fArr[0], 0.45454545454545453d)) * 255.0f)) << 16) | (b((int) (((float) Math.pow(fArr[1], 0.45454545454545453d)) * 255.0f)) << 8) | b((int) (((float) Math.pow(fArr[2], 0.45454545454545453d)) * 255.0f)));
                return;
            case w.b.f53677m /* 903 */:
            case w.b.f53680p /* 906 */:
                throw new RuntimeException("unable to interpolate " + this.f50523a);
            case w.b.f53678n /* 904 */:
                eVar.L(this.f50523a, i10, fArr[0] > 0.5f);
                return;
            default:
                return;
        }
    }

    public void x(String str) {
        this.f50527e = str;
    }

    public void y(Object obj) {
        switch (this.f50524b) {
            case 900:
            case w.b.f53680p /* 906 */:
                this.f50525c = ((Integer) obj).intValue();
                break;
            case 901:
                this.f50526d = ((Float) obj).floatValue();
                break;
            case 902:
                this.f50525c = ((Integer) obj).intValue();
                break;
            case w.b.f53677m /* 903 */:
                this.f50527e = (String) obj;
                break;
            case w.b.f53678n /* 904 */:
                this.f50528f = ((Boolean) obj).booleanValue();
                break;
            case w.b.f53679o /* 905 */:
                this.f50526d = ((Float) obj).floatValue();
                break;
        }
    }

    public void z(float[] fArr) {
        switch (this.f50524b) {
            case 900:
            case w.b.f53680p /* 906 */:
                this.f50525c = (int) fArr[0];
                return;
            case 901:
            case w.b.f53679o /* 905 */:
                this.f50526d = fArr[0];
                return;
            case 902:
                this.f50525c = ((Math.round(fArr[3] * 255.0f) & 255) << 24) | ((Math.round(((float) Math.pow(fArr[0], 0.5d)) * 255.0f) & 255) << 16) | ((Math.round(((float) Math.pow(fArr[1], 0.5d)) * 255.0f) & 255) << 8) | (Math.round(((float) Math.pow(fArr[2], 0.5d)) * 255.0f) & 255);
                return;
            case w.b.f53677m /* 903 */:
                throw new RuntimeException("Cannot interpolate String");
            case w.b.f53678n /* 904 */:
                this.f50528f = ((double) fArr[0]) > 0.5d;
                return;
            default:
                return;
        }
    }

    public a(String str, int i10, String str2) {
        this.f50525c = Integer.MIN_VALUE;
        this.f50526d = Float.NaN;
        this.f50523a = str;
        this.f50524b = i10;
        this.f50527e = str2;
    }

    public a(String str, int i10, int i11) {
        this.f50525c = Integer.MIN_VALUE;
        this.f50526d = Float.NaN;
        this.f50527e = null;
        this.f50523a = str;
        this.f50524b = i10;
        if (i10 == 901) {
            this.f50526d = i11;
        } else {
            this.f50525c = i11;
        }
    }

    public a(String str, int i10, float f10) {
        this.f50525c = Integer.MIN_VALUE;
        this.f50527e = null;
        this.f50523a = str;
        this.f50524b = i10;
        this.f50526d = f10;
    }

    public a(String str, int i10, boolean z10) {
        this.f50525c = Integer.MIN_VALUE;
        this.f50526d = Float.NaN;
        this.f50527e = null;
        this.f50523a = str;
        this.f50524b = i10;
        this.f50528f = z10;
    }

    public a(String str, int i10) {
        this.f50525c = Integer.MIN_VALUE;
        this.f50526d = Float.NaN;
        this.f50527e = null;
        this.f50523a = str;
        this.f50524b = i10;
    }

    public a(String str, int i10, Object obj) {
        this.f50525c = Integer.MIN_VALUE;
        this.f50526d = Float.NaN;
        this.f50527e = null;
        this.f50523a = str;
        this.f50524b = i10;
        y(obj);
    }

    public a(a aVar, Object obj) {
        this.f50525c = Integer.MIN_VALUE;
        this.f50526d = Float.NaN;
        this.f50527e = null;
        this.f50523a = aVar.f50523a;
        this.f50524b = aVar.f50524b;
        y(obj);
    }
}

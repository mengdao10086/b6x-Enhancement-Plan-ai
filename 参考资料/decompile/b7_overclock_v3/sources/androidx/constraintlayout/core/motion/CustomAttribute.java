package androidx.constraintlayout.core.motion;

/* JADX INFO: loaded from: classes2.dex */
public class CustomAttribute {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f3032i = "TransitionLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f3033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AttributeType f3035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f3036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f3037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f3038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f3039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f3040h;

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3041a;

        static {
            int[] iArr = new int[AttributeType.values().length];
            f3041a = iArr;
            try {
                iArr[AttributeType.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3041a[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3041a[AttributeType.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3041a[AttributeType.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3041a[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3041a[AttributeType.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3041a[AttributeType.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3041a[AttributeType.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public CustomAttribute(String str, AttributeType attributeType) {
        this.f3033a = false;
        this.f3034b = str;
        this.f3035c = attributeType;
    }

    public static int a(int i10) {
        int i11 = (i10 & (~(i10 >> 31))) - 255;
        return (i11 & (i11 >> 31)) + 255;
    }

    public static int f(float f10, float f11, float f12) {
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

    public boolean b(CustomAttribute customAttribute) {
        AttributeType attributeType;
        if (customAttribute == null || (attributeType = this.f3035c) != customAttribute.f3035c) {
            return false;
        }
        switch (a.f3041a[attributeType.ordinal()]) {
            case 1:
            case 6:
                if (this.f3036d == customAttribute.f3036d) {
                }
                break;
            case 2:
                if (this.f3039g == customAttribute.f3039g) {
                }
                break;
            case 3:
                if (this.f3036d == customAttribute.f3036d) {
                }
                break;
            case 4:
            case 5:
                if (this.f3040h == customAttribute.f3040h) {
                }
                break;
            case 7:
                if (this.f3037e == customAttribute.f3037e) {
                }
                break;
            case 8:
                if (this.f3037e == customAttribute.f3037e) {
                }
                break;
        }
        return false;
    }

    public AttributeType c() {
        return this.f3035c;
    }

    public float d() {
        switch (a.f3041a[this.f3035c.ordinal()]) {
            case 2:
                return this.f3039g ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return this.f3036d;
            case 7:
                return this.f3037e;
            case 8:
                return this.f3037e;
            default:
                return Float.NaN;
        }
    }

    public void e(float[] fArr) {
        switch (a.f3041a[this.f3035c.ordinal()]) {
            case 2:
                fArr[0] = this.f3039g ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i10 = (this.f3040h >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                fArr[0] = fPow;
                fArr[1] = fPow2;
                fArr[2] = fPow3;
                fArr[3] = i10 / 255.0f;
                return;
            case 6:
                fArr[0] = this.f3036d;
                return;
            case 7:
                fArr[0] = this.f3037e;
                return;
            case 8:
                fArr[0] = this.f3037e;
                return;
            default:
                return;
        }
    }

    public boolean g() {
        int i10 = a.f3041a[this.f3035c.ordinal()];
        return (i10 == 1 || i10 == 2 || i10 == 3) ? false : true;
    }

    public int h() {
        int i10 = a.f3041a[this.f3035c.ordinal()];
        return (i10 == 4 || i10 == 5) ? 4 : 1;
    }

    public void i(int i10) {
        this.f3040h = i10;
    }

    public void j(float f10) {
        this.f3037e = f10;
    }

    public void k(int i10) {
        this.f3036d = i10;
    }

    public void l(String str) {
        this.f3038f = str;
    }

    public void m(Object obj) {
        switch (a.f3041a[this.f3035c.ordinal()]) {
            case 1:
            case 6:
                this.f3036d = ((Integer) obj).intValue();
                break;
            case 2:
                this.f3039g = ((Boolean) obj).booleanValue();
                break;
            case 3:
                this.f3038f = (String) obj;
                break;
            case 4:
            case 5:
                this.f3040h = ((Integer) obj).intValue();
                break;
            case 7:
                this.f3037e = ((Float) obj).floatValue();
                break;
            case 8:
                this.f3037e = ((Float) obj).floatValue();
                break;
        }
    }

    public void n(float[] fArr) {
        switch (a.f3041a[this.f3035c.ordinal()]) {
            case 1:
            case 6:
                this.f3036d = (int) fArr[0];
                return;
            case 2:
                this.f3039g = ((double) fArr[0]) > 0.5d;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int iF = f(fArr[0], fArr[1], fArr[2]);
                this.f3040h = iF;
                this.f3040h = (a((int) (fArr[3] * 255.0f)) << 24) | (iF & 16777215);
                return;
            case 7:
                this.f3037e = fArr[0];
                return;
            case 8:
                this.f3037e = fArr[0];
                return;
            default:
                return;
        }
    }

    public CustomAttribute(String str, AttributeType attributeType, Object obj, boolean z10) {
        this.f3034b = str;
        this.f3035c = attributeType;
        this.f3033a = z10;
        m(obj);
    }

    public CustomAttribute(CustomAttribute customAttribute, Object obj) {
        this.f3033a = false;
        this.f3034b = customAttribute.f3034b;
        this.f3035c = customAttribute.f3035c;
        m(obj);
    }
}

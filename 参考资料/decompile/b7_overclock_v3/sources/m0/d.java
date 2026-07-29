package m0;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import androidx.core.graphics.BlendModeCompat;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40522a;

        static {
            int[] iArr = new int[BlendModeCompat.values().length];
            f40522a = iArr;
            try {
                iArr[BlendModeCompat.CLEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40522a[BlendModeCompat.SRC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40522a[BlendModeCompat.DST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40522a[BlendModeCompat.SRC_OVER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40522a[BlendModeCompat.DST_OVER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f40522a[BlendModeCompat.SRC_IN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f40522a[BlendModeCompat.DST_IN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f40522a[BlendModeCompat.SRC_OUT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f40522a[BlendModeCompat.DST_OUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f40522a[BlendModeCompat.SRC_ATOP.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f40522a[BlendModeCompat.DST_ATOP.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f40522a[BlendModeCompat.XOR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f40522a[BlendModeCompat.PLUS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f40522a[BlendModeCompat.MODULATE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f40522a[BlendModeCompat.SCREEN.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f40522a[BlendModeCompat.OVERLAY.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f40522a[BlendModeCompat.DARKEN.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f40522a[BlendModeCompat.LIGHTEN.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f40522a[BlendModeCompat.COLOR_DODGE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f40522a[BlendModeCompat.COLOR_BURN.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f40522a[BlendModeCompat.HARD_LIGHT.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f40522a[BlendModeCompat.SOFT_LIGHT.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f40522a[BlendModeCompat.DIFFERENCE.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f40522a[BlendModeCompat.EXCLUSION.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f40522a[BlendModeCompat.MULTIPLY.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f40522a[BlendModeCompat.HUE.ordinal()] = 26;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f40522a[BlendModeCompat.SATURATION.ordinal()] = 27;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f40522a[BlendModeCompat.COLOR.ordinal()] = 28;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f40522a[BlendModeCompat.LUMINOSITY.ordinal()] = 29;
            } catch (NoSuchFieldError unused29) {
            }
        }
    }

    @v0(29)
    public static class b {
        @g.u
        @p0
        public static Object a(@n0 BlendModeCompat blendModeCompat) {
            switch (a.f40522a[blendModeCompat.ordinal()]) {
                case 1:
                    return BlendMode.CLEAR;
                case 2:
                    return BlendMode.SRC;
                case 3:
                    return BlendMode.DST;
                case 4:
                    return BlendMode.SRC_OVER;
                case 5:
                    return BlendMode.DST_OVER;
                case 6:
                    return BlendMode.SRC_IN;
                case 7:
                    return BlendMode.DST_IN;
                case 8:
                    return BlendMode.SRC_OUT;
                case 9:
                    return BlendMode.DST_OUT;
                case 10:
                    return BlendMode.SRC_ATOP;
                case 11:
                    return BlendMode.DST_ATOP;
                case 12:
                    return BlendMode.XOR;
                case 13:
                    return BlendMode.PLUS;
                case 14:
                    return BlendMode.MODULATE;
                case 15:
                    return BlendMode.SCREEN;
                case 16:
                    return BlendMode.OVERLAY;
                case 17:
                    return BlendMode.DARKEN;
                case 18:
                    return BlendMode.LIGHTEN;
                case 19:
                    return BlendMode.COLOR_DODGE;
                case 20:
                    return BlendMode.COLOR_BURN;
                case 21:
                    return BlendMode.HARD_LIGHT;
                case 22:
                    return BlendMode.SOFT_LIGHT;
                case 23:
                    return BlendMode.DIFFERENCE;
                case 24:
                    return BlendMode.EXCLUSION;
                case 25:
                    return BlendMode.MULTIPLY;
                case 26:
                    return BlendMode.HUE;
                case 27:
                    return BlendMode.SATURATION;
                case 28:
                    return BlendMode.COLOR;
                case 29:
                    return BlendMode.LUMINOSITY;
                default:
                    return null;
            }
        }
    }

    @p0
    public static PorterDuff.Mode a(@p0 BlendModeCompat blendModeCompat) {
        if (blendModeCompat == null) {
            return null;
        }
        switch (a.f40522a[blendModeCompat.ordinal()]) {
        }
        return null;
    }
}

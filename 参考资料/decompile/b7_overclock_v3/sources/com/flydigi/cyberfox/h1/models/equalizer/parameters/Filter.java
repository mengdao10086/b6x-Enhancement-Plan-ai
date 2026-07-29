package com.flydigi.cyberfox.h1.models.equalizer.parameters;

import m6.d;

/* JADX INFO: loaded from: classes7.dex */
public enum Filter {
    BYPASS,
    LOW_PASS_1,
    HIGH_PASS_1,
    ALL_PASS_1,
    LOW_SHELF_1,
    HIGH_SHELF_1,
    TILT_1,
    LOW_PASS_2,
    HIGH_PASS_2,
    ALL_PASS_2,
    LOW_SHELF_2,
    HIGH_SHELF_2,
    TILT_2,
    PARAMETRIC_EQUALIZER;

    private static final Filter[] values = values();

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14128a;

        static {
            int[] iArr = new int[Filter.values().length];
            f14128a = iArr;
            try {
                iArr[Filter.HIGH_PASS_1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14128a[Filter.ALL_PASS_1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14128a[Filter.LOW_PASS_1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14128a[Filter.HIGH_PASS_2.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14128a[Filter.ALL_PASS_2.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f14128a[Filter.LOW_PASS_2.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f14128a[Filter.LOW_SHELF_1.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f14128a[Filter.HIGH_SHELF_1.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f14128a[Filter.TILT_1.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f14128a[Filter.LOW_SHELF_2.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f14128a[Filter.HIGH_SHELF_2.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f14128a[Filter.TILT_2.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f14128a[Filter.BYPASS.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f14128a[Filter.PARAMETRIC_EQUALIZER.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    public static void defineParameters(Filter filter, d dVar, d dVar2, d dVar3) {
        switch (a.f14128a[filter.ordinal()]) {
            case 1:
            case 2:
            case 3:
                dVar.p(0.333d, 20000.0d);
                dVar2.q();
                dVar3.q();
                break;
            case 4:
            case 5:
            case 6:
                dVar.p(40.0d, 20000.0d);
                dVar2.q();
                dVar3.p(0.25d, 2.0d);
                break;
            case 7:
            case 8:
            case 9:
                dVar.p(20.0d, 20000.0d);
                dVar2.p(-12.0d, 12.0d);
                dVar3.q();
                break;
            case 10:
            case 11:
            case 12:
                dVar.p(40.0d, 20000.0d);
                dVar2.p(-12.0d, 12.0d);
                dVar3.p(0.25d, 2.0d);
                break;
            case 13:
                dVar.q();
                dVar2.q();
                dVar3.q();
                break;
            case 14:
                dVar.p(20.0d, 20000.0d);
                dVar2.p(-36.0d, 12.0d);
                dVar3.p(0.25d, 8.0d);
                break;
        }
    }

    public static int getSize() {
        return values.length;
    }

    public static Filter valueOf(int i10) {
        if (i10 < 0) {
            return null;
        }
        Filter[] filterArr = values;
        if (i10 >= filterArr.length) {
            return null;
        }
        return filterArr[i10];
    }
}

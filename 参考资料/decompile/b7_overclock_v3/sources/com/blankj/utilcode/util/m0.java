package com.blankj.utilcode.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes2.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal<DecimalFormat> f11936a = new a();

    public static class a extends ThreadLocal<DecimalFormat> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DecimalFormat initialValue() {
            return (DecimalFormat) NumberFormat.getInstance();
        }
    }

    public m0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static double a(float f10) {
        return new BigDecimal(String.valueOf(f10)).doubleValue();
    }

    public static String b(double d10, int i10) {
        return f(d10, false, 1, i10, true);
    }

    public static String c(double d10, int i10, int i11, boolean z10) {
        return f(d10, false, i10, i11, z10);
    }

    public static String d(double d10, int i10, boolean z10) {
        return f(d10, false, 1, i10, z10);
    }

    public static String e(double d10, boolean z10, int i10) {
        return f(d10, z10, 1, i10, true);
    }

    public static String f(double d10, boolean z10, int i10, int i11, boolean z11) {
        DecimalFormat decimalFormatN = n();
        decimalFormatN.setGroupingUsed(z10);
        decimalFormatN.setRoundingMode(z11 ? RoundingMode.HALF_UP : RoundingMode.DOWN);
        decimalFormatN.setMinimumIntegerDigits(i10);
        decimalFormatN.setMinimumFractionDigits(i11);
        decimalFormatN.setMaximumFractionDigits(i11);
        return decimalFormatN.format(d10);
    }

    public static String g(double d10, boolean z10, int i10, boolean z11) {
        return f(d10, z10, 1, i10, z11);
    }

    public static String h(float f10, int i10) {
        return l(f10, false, 1, i10, true);
    }

    public static String i(float f10, int i10, int i11, boolean z10) {
        return l(f10, false, i10, i11, z10);
    }

    public static String j(float f10, int i10, boolean z10) {
        return l(f10, false, 1, i10, z10);
    }

    public static String k(float f10, boolean z10, int i10) {
        return l(f10, z10, 1, i10, true);
    }

    public static String l(float f10, boolean z10, int i10, int i11, boolean z11) {
        return f(a(f10), z10, i10, i11, z11);
    }

    public static String m(float f10, boolean z10, int i10, boolean z11) {
        return l(f10, z10, 1, i10, z11);
    }

    public static DecimalFormat n() {
        return f11936a.get();
    }
}

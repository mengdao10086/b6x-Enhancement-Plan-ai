package com.blankj.utilcode.util;

import android.graphics.Color;
import com.google.common.collect.LinkedHashMultimap;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class t {
    public t() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static int a(@g.n int i10) {
        return h0.d.f(j1.a(), i10);
    }

    public static int b() {
        return c(true);
    }

    public static int c(boolean z10) {
        return (z10 ? ((int) (Math.random() * 256.0d)) << 24 : -16777216) | ((int) (Math.random() * 1.6777216E7d));
    }

    public static String d(@g.l int i10) {
        String hexString = Integer.toHexString(i10);
        while (hexString.length() < 6) {
            hexString = "0" + hexString;
        }
        while (hexString.length() < 8) {
            hexString = "f" + hexString;
        }
        return "#" + hexString;
    }

    public static String e(@g.l int i10) {
        String hexString = Integer.toHexString(i10 & 16777215);
        while (hexString.length() < 6) {
            hexString = "0" + hexString;
        }
        return "#" + hexString;
    }

    public static int g(@g.l int i10, @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        return (i10 & 16777215) | (((int) ((f10 * 255.0f) + 0.5f)) << 24);
    }

    public static int h(@g.l int i10, @g.f0(from = 0, to = or.a.f44396a) int i11) {
        return (i10 & 16777215) | (i11 << 24);
    }

    public static int i(@g.l int i10, @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        return (i10 & (-256)) | ((int) ((f10 * 255.0f) + 0.5f));
    }

    public static int j(@g.l int i10, @g.f0(from = 0, to = or.a.f44396a) int i11) {
        return (i10 & (-256)) | i11;
    }

    public static int k(@g.l int i10, @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        return (i10 & (-65281)) | (((int) ((f10 * 255.0f) + 0.5f)) << 8);
    }

    public static int l(@g.l int i10, @g.f0(from = 0, to = or.a.f44396a) int i11) {
        return (i10 & (-65281)) | (i11 << 8);
    }

    public static int m(@g.l int i10, @g.x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        return (i10 & (-16711681)) | (((int) ((f10 * 255.0f) + 0.5f)) << 16);
    }

    public static int n(@g.l int i10, @g.f0(from = 0, to = or.a.f44396a) int i11) {
        return (i10 & (-16711681)) | (i11 << 16);
    }

    public static int o(@g.n0 String str) {
        Objects.requireNonNull(str, "Argument 'colorString' of type String (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        return Color.parseColor(str);
    }

    public boolean f(@g.l int i10) {
        return ((((double) Color.red(i10)) * 0.299d) + (((double) Color.green(i10)) * 0.587d)) + (((double) Color.blue(i10)) * 0.114d) >= 127.5d;
    }
}

package com.blankj.utilcode.util;

import android.graphics.drawable.Drawable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;
import w.w;

/* JADX INFO: loaded from: classes2.dex */
public final class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11974a = 8192;

    public s0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean a(String str, String str2) {
        try {
            String[] list = j1.a().getAssets().list(str);
            if (list == null || list.length <= 0) {
                return l1.h1(str2, j1.a().getAssets().open(str));
            }
            boolean zA = true;
            for (String str3 : list) {
                zA &= a(str + fh.a.f28350w + str3, str2 + fh.a.f28350w + str3);
            }
            return zA;
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public static boolean b(@g.u0 int i10, String str) {
        return l1.h1(str, j1.a().getResources().openRawResource(i10));
    }

    public static int c(String str) {
        return j1.a().getResources().getIdentifier(str, "anim", j1.a().getPackageName());
    }

    public static int d(String str) {
        return j1.a().getResources().getIdentifier(str, "color", j1.a().getPackageName());
    }

    public static int e(String str) {
        return j1.a().getResources().getIdentifier(str, "dimen", j1.a().getPackageName());
    }

    public static Drawable f(@g.v int i10) {
        return h0.d.i(j1.a(), i10);
    }

    public static int g(String str) {
        return j1.a().getResources().getIdentifier(str, "drawable", j1.a().getPackageName());
    }

    public static int h(String str) {
        return j1.a().getResources().getIdentifier(str, "id", j1.a().getPackageName());
    }

    public static int i(String str) {
        return j1.a().getResources().getIdentifier(str, xc.d.f55101w, j1.a().getPackageName());
    }

    public static int j(String str) {
        return j1.a().getResources().getIdentifier(str, l.g.f39286f, j1.a().getPackageName());
    }

    public static int k(String str) {
        return j1.a().getResources().getIdentifier(str, "mipmap", j1.a().getPackageName());
    }

    public static int l(String str) {
        return j1.a().getResources().getIdentifier(str, w.b.f53669e, j1.a().getPackageName());
    }

    public static int m(String str) {
        return j1.a().getResources().getIdentifier(str, "style", j1.a().getPackageName());
    }

    public static List<String> n(String str) {
        return o(str, "");
    }

    public static List<String> o(String str, String str2) {
        try {
            return l1.o0(j1.a().getResources().getAssets().open(str), str2);
        } catch (IOException e10) {
            e10.printStackTrace();
            return Collections.emptyList();
        }
    }

    public static String p(String str) {
        return q(str, null);
    }

    public static String q(String str, String str2) {
        try {
            byte[] bArrN0 = l1.n0(j1.a().getAssets().open(str));
            if (bArrN0 == null) {
                return "";
            }
            if (l1.C0(str2)) {
                return new String(bArrN0);
            }
            try {
                return new String(bArrN0, str2);
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
                return "";
            }
        } catch (IOException e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static List<String> r(@g.u0 int i10) {
        return s(i10, "");
    }

    public static List<String> s(@g.u0 int i10, String str) {
        return l1.o0(j1.a().getResources().openRawResource(i10), str);
    }

    public static String t(@g.u0 int i10) {
        return u(i10, null);
    }

    public static String u(@g.u0 int i10, String str) {
        byte[] bArrN0 = l1.n0(j1.a().getResources().openRawResource(i10));
        if (bArrN0 == null) {
            return null;
        }
        if (l1.C0(str)) {
            return new String(bArrN0);
        }
        try {
            return new String(bArrN0, str);
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return "";
        }
    }
}

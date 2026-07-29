package com.blankj.utilcode.util;

import android.os.Build;
import android.text.Html;
import android.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* JADX INFO: loaded from: classes2.dex */
public final class y {
    public y() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static byte[] a(String str) {
        return (str == null || str.length() == 0) ? new byte[0] : Base64.decode(str, 2);
    }

    public static byte[] b(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? new byte[0] : Base64.decode(bArr, 2);
    }

    public static byte[] c(String str) {
        return d(str.getBytes());
    }

    public static byte[] d(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? new byte[0] : Base64.encode(bArr, 2);
    }

    public static String e(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? "" : Base64.encodeToString(bArr, 2);
    }

    public static String f(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String[] strArrSplit = str.split(i0.f11861z);
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArrSplit) {
            sb2.append((char) Integer.parseInt(str2, 2));
        }
        return sb2.toString();
    }

    public static String g(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (char c10 : str.toCharArray()) {
            sb2.append(Integer.toBinaryString(c10));
            sb2.append(i0.f11861z);
        }
        return sb2.deleteCharAt(sb2.length() - 1).toString();
    }

    public static CharSequence h(String str) {
        return (str == null || str.length() == 0) ? "" : Build.VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 0) : Html.fromHtml(str);
    }

    public static String i(CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int length = charSequence.length();
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = charSequence.charAt(i10);
            if (cCharAt == '\"') {
                sb2.append("&quot;");
            } else if (cCharAt == '<') {
                sb2.append("&lt;");
            } else if (cCharAt == '>') {
                sb2.append("&gt;");
            } else if (cCharAt == '&') {
                sb2.append("&amp;");
            } else if (cCharAt != '\'') {
                sb2.append(cCharAt);
            } else {
                sb2.append("&#39;");
            }
        }
        return sb2.toString();
    }

    public static String j(String str) {
        return k(str, "UTF-8");
    }

    public static String k(String str, String str2) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLDecoder.decode(str.replaceAll("%(?![0-9a-fA-F]{2})", "%25").replaceAll("\\+", "%2B"), str2);
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    public static String l(String str) {
        return m(str, "UTF-8");
    }

    public static String m(String str, String str2) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }
}

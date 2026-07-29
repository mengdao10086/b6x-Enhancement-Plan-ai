package com.blankj.utilcode.util;

import androidx.room.u2;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final androidx.collection.l<String, String> f11973a = new androidx.collection.l<>();

    public r0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static List<String> a(String str, CharSequence charSequence) {
        if (charSequence == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        Matcher matcher = Pattern.compile(str).matcher(charSequence);
        while (matcher.find()) {
            arrayList.add(matcher.group());
        }
        return arrayList;
    }

    public static String b(String str, String str2, String str3) {
        return str == null ? "" : Pattern.compile(str2).matcher(str).replaceAll(str3);
    }

    public static String c(String str, String str2, String str3) {
        return str == null ? "" : Pattern.compile(str2).matcher(str).replaceFirst(str3);
    }

    public static String[] d(String str, String str2) {
        return str == null ? new String[0] : str.split(str2);
    }

    public static boolean e(CharSequence charSequence) {
        return k(w3.d.f53875j, charSequence);
    }

    public static boolean f(CharSequence charSequence) {
        return k(w3.d.f53871f, charSequence);
    }

    public static boolean g(CharSequence charSequence) {
        return k(w3.d.f53869d, charSequence);
    }

    public static boolean h(CharSequence charSequence) {
        return k(w3.d.f53870e, charSequence);
    }

    public static boolean i(CharSequence charSequence) {
        if (!h(charSequence)) {
            return false;
        }
        int[] iArr = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] cArr = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        androidx.collection.l<String, String> lVar = f11973a;
        if (lVar.isEmpty()) {
            lVar.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "北京");
            lVar.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, "天津");
            lVar.put("13", "河北");
            lVar.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, "山西");
            lVar.put(Constants.VIA_REPORT_TYPE_WPA_STATE, "内蒙古");
            lVar.put("21", "辽宁");
            lVar.put(Constants.VIA_REPORT_TYPE_DATALINE, "吉林");
            lVar.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "黑龙江");
            lVar.put("31", "上海");
            lVar.put("32", "江苏");
            lVar.put("33", "浙江");
            lVar.put("34", "安徽");
            lVar.put("35", "福建");
            lVar.put("36", "江西");
            lVar.put("37", "山东");
            lVar.put("41", "河南");
            lVar.put(u2.f7524e, "湖北");
            lVar.put("43", "湖南");
            lVar.put("44", "广东");
            lVar.put("45", "广西");
            lVar.put("46", "海南");
            lVar.put("50", "重庆");
            lVar.put("51", "四川");
            lVar.put("52", "贵州");
            lVar.put(ko.a.f37627c, "云南");
            lVar.put("54", "西藏");
            lVar.put("61", "陕西");
            lVar.put("62", "甘肃");
            lVar.put("63", "青海");
            lVar.put("64", "宁夏");
            lVar.put("65", "新疆");
            lVar.put("71", "台湾老");
            lVar.put("81", "香港");
            lVar.put("82", "澳门");
            lVar.put("83", "台湾新");
            lVar.put("91", "国外");
        }
        if (lVar.get(charSequence.subSequence(0, 2).toString()) == null) {
            return false;
        }
        int iCharAt = 0;
        for (int i10 = 0; i10 < 17; i10++) {
            iCharAt += (charSequence.charAt(i10) - '0') * iArr[i10];
        }
        return charSequence.charAt(17) == cArr[iCharAt % 11];
    }

    public static boolean j(CharSequence charSequence) {
        return k(w3.d.f53876k, charSequence);
    }

    public static boolean k(String str, CharSequence charSequence) {
        return charSequence != null && charSequence.length() > 0 && Pattern.matches(str, charSequence);
    }

    public static boolean l(CharSequence charSequence) {
        return m(charSequence, null);
    }

    public static boolean m(CharSequence charSequence, List<String> list) {
        if (k(w3.d.f53867b, charSequence)) {
            return true;
        }
        if (list != null && charSequence != null && charSequence.length() == 11) {
            String string = charSequence.toString();
            for (char c10 : string.toCharArray()) {
                if (!Character.isDigit(c10)) {
                    return false;
                }
            }
            Iterator<String> it2 = list.iterator();
            while (it2.hasNext()) {
                if (string.startsWith(it2.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean n(CharSequence charSequence) {
        return k(w3.d.f53866a, charSequence);
    }

    public static boolean o(CharSequence charSequence) {
        return k(w3.d.f53868c, charSequence);
    }

    public static boolean p(CharSequence charSequence) {
        return k(w3.d.f53872g, charSequence);
    }

    public static boolean q(CharSequence charSequence) {
        return k(w3.d.f53874i, charSequence);
    }

    public static boolean r(CharSequence charSequence) {
        return k(w3.d.f53873h, charSequence);
    }
}

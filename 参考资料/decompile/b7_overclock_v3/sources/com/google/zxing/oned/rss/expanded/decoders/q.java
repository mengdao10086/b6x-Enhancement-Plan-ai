package com.google.zxing.oned.rss.expanded.decoders;

import android.support.v4.media.session.MediaSessionCompat;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.zxing.NotFoundException;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, a> f21498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, a> f21499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, a> f21500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<String, a> f21501d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f21502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21503b;

        public a(boolean z10, int i10) {
            this.f21502a = z10;
            this.f21503b = i10;
        }

        public static a a(int i10) {
            return new a(false, i10);
        }

        public static a b(int i10) {
            return new a(true, i10);
        }
    }

    static {
        HashMap map = new HashMap();
        f21498a = map;
        map.put(ChipTextInputComboView.b.f21060b, a.a(18));
        map.put("01", a.a(14));
        map.put("02", a.a(14));
        map.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, a.b(20));
        map.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, a.a(6));
        map.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, a.a(6));
        map.put("13", a.a(6));
        map.put(Constants.VIA_REPORT_TYPE_WPA_STATE, a.a(6));
        map.put(Constants.VIA_REPORT_TYPE_START_GROUP, a.a(6));
        map.put("20", a.a(2));
        map.put("21", a.b(20));
        map.put(Constants.VIA_REPORT_TYPE_DATALINE, a.b(29));
        map.put("30", a.b(8));
        map.put("37", a.b(8));
        for (int i10 = 90; i10 <= 99; i10++) {
            f21498a.put(String.valueOf(i10), a.b(30));
        }
        HashMap map2 = new HashMap();
        f21499b = map2;
        map2.put("240", a.b(30));
        map2.put("241", a.b(30));
        map2.put("242", a.b(6));
        map2.put("250", a.b(30));
        map2.put("251", a.b(30));
        map2.put("253", a.b(17));
        map2.put("254", a.b(20));
        map2.put("400", a.b(30));
        map2.put("401", a.b(30));
        map2.put("402", a.a(17));
        map2.put("403", a.b(30));
        map2.put("410", a.a(13));
        map2.put("411", a.a(13));
        map2.put("412", a.a(13));
        map2.put("413", a.a(13));
        map2.put("414", a.a(13));
        map2.put("420", a.b(20));
        map2.put("421", a.b(15));
        map2.put("422", a.a(3));
        map2.put("423", a.b(15));
        map2.put("424", a.a(3));
        map2.put("425", a.a(3));
        map2.put("426", a.a(3));
        f21500c = new HashMap();
        for (int i11 = 310; i11 <= 316; i11++) {
            f21500c.put(String.valueOf(i11), a.a(6));
        }
        for (int i12 = MediaSessionCompat.M; i12 <= 336; i12++) {
            f21500c.put(String.valueOf(i12), a.a(6));
        }
        for (int i13 = 340; i13 <= 357; i13++) {
            f21500c.put(String.valueOf(i13), a.a(6));
        }
        for (int i14 = 360; i14 <= 369; i14++) {
            f21500c.put(String.valueOf(i14), a.a(6));
        }
        Map<String, a> map3 = f21500c;
        map3.put("390", a.b(15));
        map3.put("391", a.b(18));
        map3.put("392", a.b(15));
        map3.put("393", a.b(18));
        map3.put("703", a.b(30));
        HashMap map4 = new HashMap();
        f21501d = map4;
        map4.put("7001", a.a(13));
        map4.put("7002", a.b(30));
        map4.put("7003", a.a(10));
        map4.put("8001", a.a(14));
        map4.put("8002", a.b(20));
        map4.put("8003", a.b(30));
        map4.put("8004", a.b(30));
        map4.put("8005", a.a(6));
        map4.put("8006", a.a(18));
        map4.put("8007", a.b(30));
        map4.put("8008", a.b(12));
        map4.put("8018", a.a(18));
        map4.put("8020", a.b(25));
        map4.put("8100", a.a(6));
        map4.put("8101", a.a(10));
        map4.put("8102", a.a(2));
        map4.put("8110", a.b(70));
        map4.put("8200", a.b(70));
    }

    public static String a(String str) throws NotFoundException {
        if (str.isEmpty()) {
            return null;
        }
        if (str.length() < 2) {
            throw NotFoundException.b();
        }
        a aVar = f21498a.get(str.substring(0, 2));
        if (aVar != null) {
            return aVar.f21502a ? c(2, aVar.f21503b, str) : b(2, aVar.f21503b, str);
        }
        if (str.length() < 3) {
            throw NotFoundException.b();
        }
        String strSubstring = str.substring(0, 3);
        a aVar2 = f21499b.get(strSubstring);
        if (aVar2 != null) {
            return aVar2.f21502a ? c(3, aVar2.f21503b, str) : b(3, aVar2.f21503b, str);
        }
        if (str.length() < 4) {
            throw NotFoundException.b();
        }
        a aVar3 = f21500c.get(strSubstring);
        if (aVar3 != null) {
            return aVar3.f21502a ? c(4, aVar3.f21503b, str) : b(4, aVar3.f21503b, str);
        }
        a aVar4 = f21501d.get(str.substring(0, 4));
        if (aVar4 != null) {
            return aVar4.f21502a ? c(4, aVar4.f21503b, str) : b(4, aVar4.f21503b, str);
        }
        throw NotFoundException.b();
    }

    public static String b(int i10, int i11, String str) throws NotFoundException {
        if (str.length() < i10) {
            throw NotFoundException.b();
        }
        String strSubstring = str.substring(0, i10);
        int i12 = i11 + i10;
        if (str.length() < i12) {
            throw NotFoundException.b();
        }
        String strSubstring2 = str.substring(i10, i12);
        String str2 = '(' + strSubstring + ')' + strSubstring2;
        String strA = a(str.substring(i12));
        if (strA == null) {
            return str2;
        }
        return str2 + strA;
    }

    public static String c(int i10, int i11, String str) throws NotFoundException {
        String strSubstring = str.substring(0, i10);
        int iMin = Math.min(str.length(), i11 + i10);
        String strSubstring2 = str.substring(i10, iMin);
        String str2 = '(' + strSubstring + ')' + strSubstring2;
        String strA = a(str.substring(iMin));
        if (strA == null) {
            return str2;
        }
        return str2 + strA;
    }
}

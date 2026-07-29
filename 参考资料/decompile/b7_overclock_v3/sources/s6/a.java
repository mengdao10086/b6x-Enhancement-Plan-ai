package s6;

import com.blankj.utilcode.util.d1;
import com.flydigi.cyberfox.R;
import g.c1;
import g.v;
import hk.m;
import java.util.Locale;
import kotlin.jvm.internal.f0;
import q9.c;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final a f49519a = new a();

    @m
    @c1
    public static final int b(@k String deviceCode) {
        f0.p(deviceCode, "deviceCode");
        String strL = d1.l(deviceCode);
        f0.o(strL, "null2Length0(deviceCode)");
        Locale locale = Locale.getDefault();
        f0.o(locale, "getDefault()");
        String lowerCase = strL.toLowerCase(locale);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != -639242794) {
            if (iHashCode != 3769) {
                if (iHashCode == 203009350 && lowerCase.equals(c.f47167d)) {
                    return R.string.device_name_cyberfox_t1;
                }
            } else if (lowerCase.equals(c.f47168e)) {
                return R.string.device_name_cyberfox_x1;
            }
        } else if (lowerCase.equals(c.f47166c)) {
            return R.string.device_name_cyberfox;
        }
        return R.string.device_name_headset;
    }

    @k
    public final String a(@k String deviceCode) {
        f0.p(deviceCode, "deviceCode");
        String strL = d1.l(deviceCode);
        f0.o(strL, "null2Length0(deviceCode)");
        Locale locale = Locale.getDefault();
        f0.o(locale, "getDefault()");
        String lowerCase = strL.toLowerCase(locale);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return f0.g(lowerCase, c.f47167d) ? q9.a.f47158c : f0.g(lowerCase, c.f47168e) ? q9.a.f47159d : q9.a.f47157b;
    }

    @v
    public final int c(@k String deviceCode) {
        f0.p(deviceCode, "deviceCode");
        String strL = d1.l(deviceCode);
        f0.o(strL, "null2Length0(deviceCode)");
        Locale locale = Locale.getDefault();
        f0.o(locale, "getDefault()");
        String lowerCase = strL.toLowerCase(locale);
        f0.o(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int iHashCode = lowerCase.hashCode();
        if (iHashCode != -639242794) {
            if (iHashCode != 3769) {
                if (iHashCode == 203009350 && lowerCase.equals(c.f47167d)) {
                    return R.drawable.device_ic_cyberfox_t1;
                }
            } else if (lowerCase.equals(c.f47168e)) {
                return R.drawable.device_ic_x1;
            }
        } else if (lowerCase.equals(c.f47166c)) {
            return R.drawable.device_ic_cyberfox;
        }
        return R.drawable.device_ic_common;
    }
}

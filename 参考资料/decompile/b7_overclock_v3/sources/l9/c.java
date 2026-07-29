package l9;

import androidx.core.util.j;
import hk.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.text.Regex;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
@t0({"SMAP\nVersionUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VersionUtils.kt\ncom/flydigi/sdk/bluetooth/util/VersionUtils\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,59:1\n37#2,2:60\n37#2,2:62\n37#2,2:64\n37#2,2:66\n*S KotlinDebug\n*F\n+ 1 VersionUtils.kt\ncom/flydigi/sdk/bluetooth/util/VersionUtils\n*L\n13#1:60,2\n14#1:62,2\n40#1:64,2\n41#1:66,2\n*E\n"})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final c f39477a = new c();

    @m
    public static final boolean a(@k String oldV, @k String newV) {
        f0.p(oldV, "oldV");
        f0.p(newV, "newV");
        try {
            String[] strArr = (String[]) new Regex("\\.").t(oldV, 0).toArray(new String[0]);
            String[] strArr2 = (String[]) new Regex("\\.").t(newV, 0).toArray(new String[0]);
            if (strArr2.length > strArr.length) {
                return true;
            }
            if (strArr2.length == strArr.length) {
                int length = strArr2.length;
                for (int i10 = 0; i10 < length; i10++) {
                    int i11 = Integer.parseInt(strArr[i10]);
                    int i12 = Integer.parseInt(strArr2[i10]);
                    if (i12 > i11) {
                        return true;
                    }
                    if (i12 < i11) {
                        return false;
                    }
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    @m
    public static final boolean b(@k String oldV, @k String newV) {
        f0.p(oldV, "oldV");
        f0.p(newV, "newV");
        if (j.a(oldV, newV)) {
            return true;
        }
        String[] strArr = (String[]) new Regex("\\.").t(oldV, 0).toArray(new String[0]);
        String[] strArr2 = (String[]) new Regex("\\.").t(newV, 0).toArray(new String[0]);
        if (strArr2.length > strArr.length) {
            return true;
        }
        if (strArr2.length == strArr.length) {
            int length = strArr2.length;
            for (int i10 = 0; i10 < length; i10++) {
                int i11 = Integer.parseInt(strArr[i10]);
                int i12 = Integer.parseInt(strArr2[i10]);
                if (i12 > i11) {
                    return true;
                }
                if (i12 < i11) {
                    return false;
                }
            }
        }
        return false;
    }
}

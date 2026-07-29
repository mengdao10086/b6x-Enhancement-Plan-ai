package com.blankj.utilcode.util;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.content.FileProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class f0 {
    public f0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Intent A(@g.p0 String str, LinkedList<String> linkedList) {
        ArrayList arrayList = new ArrayList();
        if (linkedList != null) {
            Iterator<String> it2 = linkedList.iterator();
            while (it2.hasNext()) {
                File fileP = l1.P(it2.next());
                if (fileP != null) {
                    arrayList.add(fileP);
                }
            }
        }
        return B(str, arrayList);
    }

    public static Intent B(@g.p0 String str, List<File> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<File> it2 = list.iterator();
            while (it2.hasNext()) {
                Uri uriC = l1.C(it2.next());
                if (uriC != null) {
                    arrayList.add(uriC);
                }
            }
        }
        return z(str, arrayList);
    }

    public static Intent C(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        return l(Intent.createChooser(intent, ""), true);
    }

    public static Intent D() {
        Intent intent = Build.VERSION.SDK_INT >= 26 ? new Intent("android.intent.action.ACTION_SHUTDOWN") : new Intent("com.android.internal.intent.action.REQUEST_SHUTDOWN");
        intent.putExtra("android.intent.extra.KEY_CONFIRM", false);
        return intent.addFlags(268435456);
    }

    public static Intent E(String str) {
        Intent intent = new Intent("android.intent.action.DELETE");
        intent.setData(Uri.parse("package:" + str));
        return intent.addFlags(268435456);
    }

    public static boolean F(Intent intent) {
        return j1.a().getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }

    @g.y0("android.permission.CALL_PHONE")
    public static Intent a(String str) {
        return l(new Intent("android.intent.action.CALL", Uri.parse("tel:" + str)), true);
    }

    public static Intent b(Uri uri) {
        return c(uri, false);
    }

    public static Intent c(Uri uri, boolean z10) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", uri);
        intent.addFlags(1);
        return l(intent, z10);
    }

    public static Intent d(String str, String str2) {
        return f(str, str2, null, false);
    }

    public static Intent e(String str, String str2, Bundle bundle) {
        return f(str, str2, bundle, false);
    }

    public static Intent f(String str, String str2, Bundle bundle, boolean z10) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.setComponent(new ComponentName(str, str2));
        return l(intent, z10);
    }

    public static Intent g(String str, String str2, boolean z10) {
        return f(str, str2, null, z10);
    }

    public static Intent h(String str) {
        return l(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + str)), true);
    }

    public static Intent i(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(uri, "application/vnd.android.package-archive");
        if (Build.VERSION.SDK_INT >= 24) {
            intent.setFlags(1);
        }
        return intent.addFlags(268435456);
    }

    public static Intent j(File file) {
        Uri uriF;
        if (!l1.u0(file)) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 24) {
            uriF = Uri.fromFile(file);
        } else {
            uriF = FileProvider.f(j1.a(), j1.a().getPackageName() + ".utilcode.provider", file);
        }
        return i(uriF);
    }

    public static Intent k(String str) {
        return j(l1.P(str));
    }

    public static Intent l(Intent intent, boolean z10) {
        return z10 ? intent.addFlags(268435456) : intent;
    }

    public static Intent m(String str) {
        return n(str, false);
    }

    public static Intent n(String str, boolean z10) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + str));
        return l(intent, z10);
    }

    public static Intent o(String str) {
        String strZ = l1.Z(str);
        if (l1.C0(strZ)) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.setClassName(str, strZ);
        return intent.addFlags(268435456);
    }

    public static Intent p(String str, String str2) {
        Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
        intent.putExtra("sms_body", str2);
        return l(intent, true);
    }

    public static Intent q(Uri uri) {
        return w("", uri);
    }

    public static Intent r(File file) {
        return x("", file);
    }

    public static Intent s(String str) {
        return y("", str);
    }

    public static Intent t(ArrayList<Uri> arrayList) {
        return z("", arrayList);
    }

    public static Intent u(LinkedList<String> linkedList) {
        return A("", linkedList);
    }

    public static Intent v(List<File> list) {
        return B("", list);
    }

    public static Intent w(@g.p0 String str, Uri uri) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setType("image/*");
        return l(Intent.createChooser(intent, ""), true);
    }

    public static Intent x(@g.p0 String str, File file) {
        return w(str, l1.C(file));
    }

    public static Intent y(@g.p0 String str, String str2) {
        return x(str, l1.P(str2));
    }

    public static Intent z(@g.p0 String str, ArrayList<Uri> arrayList) {
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.putExtra("android.intent.extra.TEXT", str);
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        intent.setType("image/*");
        return l(Intent.createChooser(intent, ""), true);
    }
}

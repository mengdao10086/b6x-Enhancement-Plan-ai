package a;

import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<byte[]> f5597a = new zd();

    public static List<byte[]> a(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    public static boolean b(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static List<List<byte[]>> c(be beVar, Resources resources) {
        return beVar.b() != null ? beVar.b() : hc.c(resources, beVar.c());
    }

    public static ie d(Context context, be beVar, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoE = e(context.getPackageManager(), beVar, context.getResources());
        return providerInfoE == null ? ie.a(1, null) : ie.a(0, f(context, beVar, providerInfoE.authority, cancellationSignal));
    }

    public static ProviderInfo e(PackageManager packageManager, be beVar, Resources resources) throws PackageManager.NameNotFoundException {
        String strE = beVar.e();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strE, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strE);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(beVar.f())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strE + ", but package was not " + beVar.f());
        }
        List<byte[]> listA = a(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listA, f5597a);
        List<List<byte[]>> listC = c(beVar, resources);
        for (int i = 0; i < listC.size(); i++) {
            ArrayList arrayList = new ArrayList(listC.get(i));
            Collections.sort(arrayList, f5597a);
            if (b(listA, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    public static je[] f(Context context, be beVar, String str, CancellationSignal cancellationSignal) {
        boolean z;
        int i;
        ArrayList arrayList = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
        Cursor cursorQuery = null;
        try {
            String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
            int i2 = 0;
            cursorQuery = Build.VERSION.SDK_INT > 16 ? context.getContentResolver().query(uriBuild, strArr, "query = ?", new String[]{beVar.g()}, null, cancellationSignal) : context.getContentResolver().query(uriBuild, strArr, "query = ?", new String[]{beVar.g()}, null);
            if (cursorQuery != null && cursorQuery.getCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("result_code");
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursorQuery.getColumnIndex("_id");
                int columnIndex3 = cursorQuery.getColumnIndex("file_id");
                int columnIndex4 = cursorQuery.getColumnIndex("font_ttc_index");
                int columnIndex5 = cursorQuery.getColumnIndex("font_weight");
                int columnIndex6 = cursorQuery.getColumnIndex("font_italic");
                while (cursorQuery.moveToNext()) {
                    int i3 = columnIndex != -1 ? cursorQuery.getInt(columnIndex) : i2;
                    int i4 = columnIndex4 != -1 ? cursorQuery.getInt(columnIndex4) : i2;
                    int i5 = i3;
                    Uri uriWithAppendedId = columnIndex3 == -1 ? ContentUris.withAppendedId(uriBuild, cursorQuery.getLong(columnIndex2)) : ContentUris.withAppendedId(uriBuild2, cursorQuery.getLong(columnIndex3));
                    int i6 = columnIndex5 != -1 ? cursorQuery.getInt(columnIndex5) : 400;
                    if (columnIndex6 == -1 || cursorQuery.getInt(columnIndex6) != 1) {
                        z = false;
                        i = i5;
                    } else {
                        i = i5;
                        z = true;
                    }
                    arrayList2.add(je.a(uriWithAppendedId, i4, i6, z, i));
                    i2 = 0;
                }
                arrayList = arrayList2;
            }
            return (je[]) arrayList.toArray(new je[0]);
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }
}

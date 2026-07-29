package v0;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import com.umeng.analytics.pro.ar;
import g.i1;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import v0.h;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Comparator<byte[]> f52462a = new Comparator() { // from class: v0.d
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return e.g((byte[]) obj, (byte[]) obj2);
        }
    };

    @v0(16)
    public static class a {
        @u
        public static Cursor a(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, Object obj) {
            return contentResolver.query(uri, strArr, str, strArr2, str2, (CancellationSignal) obj);
        }
    }

    public static List<byte[]> b(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    public static boolean c(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!Arrays.equals(list.get(i10), list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public static List<List<byte[]>> d(f fVar, Resources resources) {
        return fVar.b() != null ? fVar.b() : j0.f.c(resources, fVar.c());
    }

    @n0
    public static h.b e(@n0 Context context, @n0 f fVar, @p0 CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        ProviderInfo providerInfoF = f(context.getPackageManager(), fVar, context.getResources());
        return providerInfoF == null ? h.b.a(1, null) : h.b.a(0, h(context, fVar, providerInfoF.authority, cancellationSignal));
    }

    @i1
    @p0
    public static ProviderInfo f(@n0 PackageManager packageManager, @n0 f fVar, @p0 Resources resources) throws PackageManager.NameNotFoundException {
        String strF = fVar.f();
        ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(strF, 0);
        if (providerInfoResolveContentProvider == null) {
            throw new PackageManager.NameNotFoundException("No package found for authority: " + strF);
        }
        if (!providerInfoResolveContentProvider.packageName.equals(fVar.g())) {
            throw new PackageManager.NameNotFoundException("Found content provider " + strF + ", but package was not " + fVar.g());
        }
        List<byte[]> listB = b(packageManager.getPackageInfo(providerInfoResolveContentProvider.packageName, 64).signatures);
        Collections.sort(listB, f52462a);
        List<List<byte[]>> listD = d(fVar, resources);
        for (int i10 = 0; i10 < listD.size(); i10++) {
            ArrayList arrayList = new ArrayList(listD.get(i10));
            Collections.sort(arrayList, f52462a);
            if (c(listB, arrayList)) {
                return providerInfoResolveContentProvider;
            }
        }
        return null;
    }

    public static /* synthetic */ int g(byte[] bArr, byte[] bArr2) {
        int length;
        int length2;
        if (bArr.length == bArr2.length) {
            for (int i10 = 0; i10 < bArr.length; i10++) {
                if (bArr[i10] != bArr2[i10]) {
                    length = bArr[i10];
                    length2 = bArr2[i10];
                }
            }
            return 0;
        }
        length = bArr.length;
        length2 = bArr2.length;
        return length - length2;
    }

    @i1
    @n0
    public static h.c[] h(Context context, f fVar, String str, CancellationSignal cancellationSignal) {
        int i10;
        Uri uriWithAppendedId;
        int i11;
        boolean z10;
        ArrayList arrayList = new ArrayList();
        Uri uriBuild = new Uri.Builder().scheme("content").authority(str).build();
        Uri uriBuild2 = new Uri.Builder().scheme("content").authority(str).appendPath(m7.a.f40702b).build();
        Cursor cursorA = null;
        try {
            cursorA = a.a(context.getContentResolver(), uriBuild, new String[]{ar.f23316d, h.a.f52488a, h.a.f52489b, h.a.f52490c, h.a.f52491d, h.a.f52492e, h.a.f52493f}, "query = ?", new String[]{fVar.h()}, null, cancellationSignal);
            if (cursorA != null && cursorA.getCount() > 0) {
                int columnIndex = cursorA.getColumnIndex(h.a.f52493f);
                ArrayList arrayList2 = new ArrayList();
                int columnIndex2 = cursorA.getColumnIndex(ar.f23316d);
                int columnIndex3 = cursorA.getColumnIndex(h.a.f52488a);
                int columnIndex4 = cursorA.getColumnIndex(h.a.f52489b);
                int columnIndex5 = cursorA.getColumnIndex(h.a.f52491d);
                int columnIndex6 = cursorA.getColumnIndex(h.a.f52492e);
                while (cursorA.moveToNext()) {
                    int i12 = columnIndex != -1 ? cursorA.getInt(columnIndex) : 0;
                    int i13 = columnIndex4 != -1 ? cursorA.getInt(columnIndex4) : 0;
                    if (columnIndex3 == -1) {
                        i10 = i12;
                        uriWithAppendedId = ContentUris.withAppendedId(uriBuild, cursorA.getLong(columnIndex2));
                    } else {
                        i10 = i12;
                        uriWithAppendedId = ContentUris.withAppendedId(uriBuild2, cursorA.getLong(columnIndex3));
                    }
                    int i14 = columnIndex5 != -1 ? cursorA.getInt(columnIndex5) : 400;
                    if (columnIndex6 == -1 || cursorA.getInt(columnIndex6) != 1) {
                        i11 = i10;
                        z10 = false;
                    } else {
                        i11 = i10;
                        z10 = true;
                    }
                    arrayList2.add(h.c.a(uriWithAppendedId, i13, i14, z10, i11));
                }
                arrayList = arrayList2;
            }
            return (h.c[]) arrayList.toArray(new h.c[0]);
        } finally {
            if (cursorA != null) {
                cursorA.close();
            }
        }
    }
}

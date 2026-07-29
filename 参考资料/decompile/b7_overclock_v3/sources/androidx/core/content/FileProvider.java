package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import g.b0;
import g.i1;
import g.k1;
import g.n0;
import g.p0;
import g.u;
import g.v0;
import h0.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import no.nordicsemi.android.dfu.DfuBaseService;
import org.xmlpull.v1.XmlPullParserException;
import zc.f;

/* JADX INFO: loaded from: classes2.dex */
public class FileProvider extends ContentProvider {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f4596d = "android.support.FILE_PROVIDER_PATHS";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f4597e = "root-path";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f4598f = "files-path";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f4599g = "cache-path";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f4600h = "external-path";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f4601i = "external-files-path";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f4602j = "external-cache-path";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f4603k = "external-media-path";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f4604l = "name";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f4605m = "path";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f4606n = "displayName";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f4609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f4595c = {"_display_name", "_size"};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final File f4607o = new File(fh.a.f28350w);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @b0("sCache")
    public static final HashMap<String, b> f4608p = new HashMap<>();

    @v0(21)
    public static class a {
        @u
        public static File[] a(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    public interface b {
        File a(Uri uri);

        Uri b(File file);
    }

    public static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f4611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final HashMap<String, File> f4612b = new HashMap<>();

        public c(String str) {
            this.f4611a = str;
        }

        @Override // androidx.core.content.FileProvider.b
        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int iIndexOf = encodedPath.indexOf(47, 1);
            String strDecode = Uri.decode(encodedPath.substring(1, iIndexOf));
            String strDecode2 = Uri.decode(encodedPath.substring(iIndexOf + 1));
            File file = this.f4612b.get(strDecode);
            if (file == null) {
                throw new IllegalArgumentException("Unable to find configured root for " + uri);
            }
            File file2 = new File(file, strDecode2);
            try {
                File canonicalFile = file2.getCanonicalFile();
                if (canonicalFile.getPath().startsWith(file.getPath())) {
                    return canonicalFile;
                }
                throw new SecurityException("Resolved path jumped beyond configured root");
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file2);
            }
        }

        @Override // androidx.core.content.FileProvider.b
        public Uri b(File file) {
            try {
                String canonicalPath = file.getCanonicalPath();
                Map.Entry<String, File> entry = null;
                for (Map.Entry<String, File> entry2 : this.f4612b.entrySet()) {
                    String path = entry2.getValue().getPath();
                    if (canonicalPath.startsWith(path) && (entry == null || path.length() > entry.getValue().getPath().length())) {
                        entry = entry2;
                    }
                }
                if (entry == null) {
                    throw new IllegalArgumentException("Failed to find configured root that contains " + canonicalPath);
                }
                String path2 = entry.getValue().getPath();
                return new Uri.Builder().scheme("content").authority(this.f4611a).encodedPath(Uri.encode(entry.getKey()) + f.f58380j + Uri.encode(path2.endsWith(fh.a.f28350w) ? canonicalPath.substring(path2.length()) : canonicalPath.substring(path2.length() + 1), fh.a.f28350w)).build();
            } catch (IOException unused) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file);
            }
        }

        public void c(String str, File file) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Name must not be empty");
            }
            try {
                this.f4612b.put(str, file.getCanonicalFile());
            } catch (IOException e10) {
                throw new IllegalArgumentException("Failed to resolve canonical path for " + file, e10);
            }
        }
    }

    public FileProvider() {
        this.f4610b = 0;
    }

    public static File a(File file, String... strArr) {
        for (String str : strArr) {
            if (str != null) {
                file = new File(file, str);
            }
        }
        return file;
    }

    public static Object[] b(Object[] objArr, int i10) {
        Object[] objArr2 = new Object[i10];
        System.arraycopy(objArr, 0, objArr2, 0, i10);
        return objArr2;
    }

    public static String[] c(String[] strArr, int i10) {
        String[] strArr2 = new String[i10];
        System.arraycopy(strArr, 0, strArr2, 0, i10);
        return strArr2;
    }

    @i1
    public static XmlResourceParser d(Context context, String str, @p0 ProviderInfo providerInfo, int i10) {
        if (providerInfo == null) {
            throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + str);
        }
        if (providerInfo.metaData == null && i10 != 0) {
            Bundle bundle = new Bundle(1);
            providerInfo.metaData = bundle;
            bundle.putInt(f4596d, i10);
        }
        XmlResourceParser xmlResourceParserLoadXmlMetaData = providerInfo.loadXmlMetaData(context.getPackageManager(), f4596d);
        if (xmlResourceParserLoadXmlMetaData != null) {
            return xmlResourceParserLoadXmlMetaData;
        }
        throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }

    public static b e(Context context, String str, int i10) {
        b bVarI;
        HashMap<String, b> map = f4608p;
        synchronized (map) {
            bVarI = map.get(str);
            if (bVarI == null) {
                try {
                    try {
                        bVarI = i(context, str, i10);
                        map.put(str, bVarI);
                    } catch (XmlPullParserException e10) {
                        throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e10);
                    }
                } catch (IOException e11) {
                    throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", e11);
                }
            }
        }
        return bVarI;
    }

    public static Uri f(@n0 Context context, @n0 String str, @n0 File file) {
        return e(context, str, 0).b(file);
    }

    @SuppressLint({"StreamFiles"})
    @n0
    public static Uri g(@n0 Context context, @n0 String str, @n0 File file, @n0 String str2) {
        return f(context, str, file).buildUpon().appendQueryParameter(f4606n, str2).build();
    }

    public static int h(String str) {
        if (SsManifestParser.e.J.equals(str)) {
            return 268435456;
        }
        if ("w".equals(str) || "wt".equals(str)) {
            return 738197504;
        }
        if ("wa".equals(str)) {
            return 704643072;
        }
        if ("rw".equals(str)) {
            return 939524096;
        }
        if ("rwt".equals(str)) {
            return 1006632960;
        }
        throw new IllegalArgumentException("Invalid mode: " + str);
    }

    public static b i(Context context, String str, int i10) throws XmlPullParserException, IOException {
        c cVar = new c(str);
        XmlResourceParser xmlResourceParserD = d(context, str, context.getPackageManager().resolveContentProvider(str, 128), i10);
        while (true) {
            int next = xmlResourceParserD.next();
            if (next == 1) {
                return cVar;
            }
            if (next == 2) {
                String name = xmlResourceParserD.getName();
                File externalStorageDirectory = null;
                String attributeValue = xmlResourceParserD.getAttributeValue(null, "name");
                String attributeValue2 = xmlResourceParserD.getAttributeValue(null, "path");
                if (f4597e.equals(name)) {
                    externalStorageDirectory = f4607o;
                } else if (f4598f.equals(name)) {
                    externalStorageDirectory = context.getFilesDir();
                } else if (f4599g.equals(name)) {
                    externalStorageDirectory = context.getCacheDir();
                } else if (f4600h.equals(name)) {
                    externalStorageDirectory = Environment.getExternalStorageDirectory();
                } else if (f4601i.equals(name)) {
                    File[] fileArrK = d.k(context, null);
                    if (fileArrK.length > 0) {
                        externalStorageDirectory = fileArrK[0];
                    }
                } else if (f4602j.equals(name)) {
                    File[] fileArrJ = d.j(context);
                    if (fileArrJ.length > 0) {
                        externalStorageDirectory = fileArrJ[0];
                    }
                } else if (f4603k.equals(name)) {
                    File[] fileArrA = a.a(context);
                    if (fileArrA.length > 0) {
                        externalStorageDirectory = fileArrA[0];
                    }
                }
                if (externalStorageDirectory != null) {
                    cVar.c(attributeValue, a(externalStorageDirectory, attributeValue2));
                }
            }
        }
    }

    @Override // android.content.ContentProvider
    public void attachInfo(@n0 Context context, @n0 ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (providerInfo.exported) {
            throw new SecurityException("Provider must not be exported");
        }
        if (!providerInfo.grantUriPermissions) {
            throw new SecurityException("Provider must grant uri permissions");
        }
        String str = providerInfo.authority.split(";")[0];
        HashMap<String, b> map = f4608p;
        synchronized (map) {
            map.remove(str);
        }
        this.f4609a = e(context, str, this.f4610b);
    }

    @Override // android.content.ContentProvider
    public int delete(@n0 Uri uri, @p0 String str, @p0 String[] strArr) {
        return this.f4609a.a(uri).delete() ? 1 : 0;
    }

    @Override // android.content.ContentProvider
    @p0
    public String getType(@n0 Uri uri) {
        File fileA = this.f4609a.a(uri);
        int iLastIndexOf = fileA.getName().lastIndexOf(46);
        if (iLastIndexOf < 0) {
            return DfuBaseService.MIME_TYPE_OCTET_STREAM;
        }
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileA.getName().substring(iLastIndexOf + 1));
        return mimeTypeFromExtension != null ? mimeTypeFromExtension : DfuBaseService.MIME_TYPE_OCTET_STREAM;
    }

    @Override // android.content.ContentProvider
    public Uri insert(@n0 Uri uri, @n0 ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    @SuppressLint({"UnknownNullness"})
    public ParcelFileDescriptor openFile(@n0 Uri uri, @n0 String str) throws FileNotFoundException {
        return ParcelFileDescriptor.open(this.f4609a.a(uri), h(str));
    }

    @Override // android.content.ContentProvider
    @n0
    public Cursor query(@n0 Uri uri, @p0 String[] strArr, @p0 String str, @p0 String[] strArr2, @p0 String str2) {
        int i10;
        File fileA = this.f4609a.a(uri);
        String queryParameter = uri.getQueryParameter(f4606n);
        if (strArr == null) {
            strArr = f4595c;
        }
        String[] strArr3 = new String[strArr.length];
        Object[] objArr = new Object[strArr.length];
        int i11 = 0;
        for (String str3 : strArr) {
            if ("_display_name".equals(str3)) {
                strArr3[i11] = "_display_name";
                i10 = i11 + 1;
                objArr[i11] = queryParameter == null ? fileA.getName() : queryParameter;
            } else if ("_size".equals(str3)) {
                strArr3[i11] = "_size";
                i10 = i11 + 1;
                objArr[i11] = Long.valueOf(fileA.length());
            }
            i11 = i10;
        }
        String[] strArrC = c(strArr3, i11);
        Object[] objArrB = b(objArr, i11);
        MatrixCursor matrixCursor = new MatrixCursor(strArrC, 1);
        matrixCursor.addRow(objArrB);
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(@n0 Uri uri, @n0 ContentValues contentValues, @p0 String str, @p0 String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }

    public FileProvider(@k1 int i10) {
        this.f4610b = i10;
    }
}

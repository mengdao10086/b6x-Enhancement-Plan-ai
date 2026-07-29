package com.umeng.socialize.net.dplus.cache1;

import android.content.Context;
import android.os.Handler;

/* JADX INFO: loaded from: classes5.dex */
public class CacheApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f24730a = "CacheApi";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static CacheApi f24731e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Handler f24732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private CacheExector f24733c = new CacheExector(a());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f24734d;

    private CacheApi(Context context) {
        this.f24734d = context;
    }

    private String a() {
        Context context = this.f24734d;
        if (context == null) {
            return null;
        }
        return context.getFilesDir().getPath();
    }

    public static CacheApi get(Context context) {
        if (f24731e == null) {
            f24731e = new CacheApi(context);
        }
        return f24731e;
    }

    public double checkSize(String str) {
        CacheExector cacheExector = this.f24733c;
        if (cacheExector == null) {
            return 0.0d;
        }
        return cacheExector.checkSize(str);
    }

    public boolean delete(String str) {
        CacheExector cacheExector = this.f24733c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.deleteFile(str);
    }

    public IReader read(String str, Class cls) {
        CacheExector cacheExector = this.f24733c;
        if (cacheExector == null) {
            return null;
        }
        return cacheExector.readFile(str, cls);
    }

    public boolean save(String str, String str2) {
        CacheExector cacheExector = this.f24733c;
        if (cacheExector == null) {
            return false;
        }
        return cacheExector.save(str, str2);
    }
}

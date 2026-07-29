package com.tencent.mmkv;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.widget.c;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes5.dex */
public class MMKVContentProvider extends ContentProvider {
    public static final String FUNCTION_NAME = "mmkvFromAshmemID";
    public static final String KEY = "KEY";
    public static final String KEY_CRYPT = "KEY_CRYPT";
    public static final String KEY_MODE = "KEY_MODE";
    public static final String KEY_SIZE = "KEY_SIZE";
    private static Uri gUri;

    @p0
    public static Uri contentUri(Context context) {
        String strQueryAuthority;
        Uri uri = gUri;
        if (uri != null) {
            return uri;
        }
        if (context == null || (strQueryAuthority = queryAuthority(context)) == null) {
            return null;
        }
        Uri uri2 = Uri.parse("content://" + strQueryAuthority);
        gUri = uri2;
        return uri2;
    }

    public static String getProcessNameByPID(Context context, int pid) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(c.f2369r);
        if (activityManager == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == pid) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    private Bundle mmkvFromAshmemID(String ashmemID, int size, int mode, String cryptKey) throws RuntimeException {
        MMKV mmkvMmkvWithAshmemID = MMKV.mmkvWithAshmemID(getContext(), ashmemID, size, mode, cryptKey);
        ParcelableMMKV parcelableMMKV = new ParcelableMMKV(mmkvMmkvWithAshmemID);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ashmemID);
        sb2.append(" fd = ");
        sb2.append(mmkvMmkvWithAshmemID.ashmemFD());
        sb2.append(", meta fd = ");
        sb2.append(mmkvMmkvWithAshmemID.ashmemMetaFD());
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY, parcelableMMKV);
        return bundle;
    }

    private static String queryAuthority(Context context) {
        ProviderInfo providerInfo;
        try {
            ComponentName componentName = new ComponentName(context, MMKVContentProvider.class.getName());
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (providerInfo = packageManager.getProviderInfo(componentName, 0)) == null) {
                return null;
            }
            return providerInfo.authority;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    @p0
    public Bundle call(@n0 String method, @p0 String mmapID, @p0 Bundle extras) {
        if (method.equals(FUNCTION_NAME) && extras != null) {
            try {
                return mmkvFromAshmemID(mmapID, extras.getInt(KEY_SIZE), extras.getInt(KEY_MODE), extras.getString(KEY_CRYPT));
            } catch (Exception e10) {
                e10.getMessage();
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(@n0 Uri uri, @p0 String selection, @p0 String[] selectionArgs) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    @p0
    public String getType(@n0 Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @p0
    public Uri insert(@n0 Uri uri, @p0 ContentValues values) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        String strQueryAuthority;
        Context context = getContext();
        if (context == null || (strQueryAuthority = queryAuthority(context)) == null) {
            return false;
        }
        if (gUri != null) {
            return true;
        }
        gUri = Uri.parse("content://" + strQueryAuthority);
        return true;
    }

    @Override // android.content.ContentProvider
    @p0
    public Cursor query(@n0 Uri uri, @p0 String[] projection, @p0 String selection, @p0 String[] selectionArgs, @p0 String sortOrder) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }

    @Override // android.content.ContentProvider
    public int update(@n0 Uri uri, @p0 ContentValues values, @p0 String selection, @p0 String[] selectionArgs) {
        throw new UnsupportedOperationException("Not implement in MMKV");
    }
}

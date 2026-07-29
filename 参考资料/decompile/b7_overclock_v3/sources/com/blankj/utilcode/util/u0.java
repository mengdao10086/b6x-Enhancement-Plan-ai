package com.blankj.utilcode.util;

import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.format.Formatter;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class u0 {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f12006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f12007b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f12008c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f12009d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f12010e;

        public a(String str, String str2, boolean z10) {
            this.f12006a = str;
            this.f12007b = str2;
            this.f12008c = z10;
            this.f12009d = l1.S(str);
            this.f12010e = l1.R(str);
        }

        public long c() {
            return this.f12010e;
        }

        public String d() {
            return this.f12006a;
        }

        public String e() {
            return this.f12007b;
        }

        public long f() {
            return this.f12009d;
        }

        public boolean g() {
            return this.f12008c;
        }

        public String toString() {
            return "SDCardInfo {path = " + this.f12006a + ", state = " + this.f12007b + ", isRemovable = " + this.f12008c + ", totalSize = " + Formatter.formatFileSize(j1.a(), this.f12009d) + ", availableSize = " + Formatter.formatFileSize(j1.a(), this.f12010e) + '}';
        }
    }

    public u0() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static long a() {
        return l1.R(g());
    }

    public static long b() {
        return l1.S(g());
    }

    public static long c() {
        return l1.R(Environment.getDataDirectory().getAbsolutePath());
    }

    public static long d() {
        return l1.S(Environment.getDataDirectory().getAbsolutePath());
    }

    public static List<String> e() {
        ArrayList arrayList = new ArrayList();
        List<a> listF = f();
        if (listF != null && !listF.isEmpty()) {
            for (a aVar : listF) {
                String str = aVar.f12007b;
                if (str != null && "mounted".equals(str.toLowerCase())) {
                    arrayList.add(aVar.f12006a);
                }
            }
        }
        return arrayList;
    }

    public static List<a> f() {
        ArrayList arrayList = new ArrayList();
        StorageManager storageManager = (StorageManager) j1.a().getSystemService("storage");
        if (storageManager == null) {
            return arrayList;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            List<StorageVolume> storageVolumes = storageManager.getStorageVolumes();
            try {
                Method method = StorageVolume.class.getMethod("getPath", new Class[0]);
                for (StorageVolume storageVolume : storageVolumes) {
                    arrayList.add(new a((String) method.invoke(storageVolume, new Object[0]), storageVolume.getState(), storageVolume.isRemovable()));
                }
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        } else {
            try {
                Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                Method method2 = cls.getMethod("getPath", new Class[0]);
                Method method3 = cls.getMethod("isRemovable", new Class[0]);
                Method method4 = StorageManager.class.getMethod("getVolumeState", String.class);
                Object objInvoke = StorageManager.class.getMethod("getVolumeList", new Class[0]).invoke(storageManager, new Object[0]);
                int length = Array.getLength(objInvoke);
                for (int i10 = 0; i10 < length; i10++) {
                    Object obj = Array.get(objInvoke, i10);
                    String str = (String) method2.invoke(obj, new Object[0]);
                    arrayList.add(new a(str, (String) method4.invoke(storageManager, str), ((Boolean) method3.invoke(obj, new Object[0])).booleanValue()));
                }
            } catch (ClassNotFoundException e13) {
                e13.printStackTrace();
            } catch (IllegalAccessException e14) {
                e14.printStackTrace();
            } catch (NoSuchMethodException e15) {
                e15.printStackTrace();
            } catch (InvocationTargetException e16) {
                e16.printStackTrace();
            }
        }
        return arrayList;
    }

    public static String g() {
        return h() ? Environment.getExternalStorageDirectory().getAbsolutePath() : "";
    }

    public static boolean h() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}

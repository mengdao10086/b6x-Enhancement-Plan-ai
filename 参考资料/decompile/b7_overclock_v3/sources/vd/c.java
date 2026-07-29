package vd;

import android.content.Context;
import android.content.res.loader.ResourcesLoader;
import android.content.res.loader.ResourcesProvider;
import android.os.ParcelFileDescriptor;
import android.system.Os;
import g.n0;
import g.p0;
import g.v0;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@v0(30)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f52985a = "c";

    @p0
    public static ResourcesLoader a(@n0 Context context, @n0 Map<Integer, Integer> map) throws Throwable {
        FileDescriptor fileDescriptorMemfd_create;
        try {
            byte[] bArrI = d.i(context, map);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Table created, length: ");
            sb2.append(bArrI.length);
            if (bArrI.length == 0) {
                return null;
            }
            try {
                fileDescriptorMemfd_create = Os.memfd_create("temp.arsc", 0);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(fileDescriptorMemfd_create);
                    try {
                        fileOutputStream.write(bArrI);
                        ParcelFileDescriptor parcelFileDescriptorDup = ParcelFileDescriptor.dup(fileDescriptorMemfd_create);
                        try {
                            ResourcesLoader resourcesLoader = new ResourcesLoader();
                            resourcesLoader.addProvider(ResourcesProvider.loadFromTable(parcelFileDescriptorDup, null));
                            if (parcelFileDescriptorDup != null) {
                                parcelFileDescriptorDup.close();
                            }
                            fileOutputStream.close();
                            if (fileDescriptorMemfd_create != null) {
                                Os.close(fileDescriptorMemfd_create);
                            }
                            return resourcesLoader;
                        } finally {
                        }
                    } finally {
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileDescriptorMemfd_create != null) {
                        Os.close(fileDescriptorMemfd_create);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                fileDescriptorMemfd_create = null;
            }
        } catch (Exception unused) {
            return null;
        }
    }
}

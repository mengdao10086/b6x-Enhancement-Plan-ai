package com.flydigi.device_manager.ui.home.device;

import android.app.Application;
import com.flydigi.data.DataConstant;
import java.io.File;

/* JADX INFO: loaded from: classes7.dex */
public final class g0 extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g0(@yt.k Application application) {
        super(application);
        kotlin.jvm.internal.f0.p(application, "application");
    }

    @Override // com.flydigi.device_manager.ui.home.device.a
    public void m() {
        try {
            com.blankj.utilcode.util.b0.k(new File(DataConstant.DIRECTORY_PUBLIC));
            File file = new File(DataConstant.FOLDER_SERVER);
            com.blankj.utilcode.util.b0.k(file);
            f1.a serverDirectory = f1.a.h(file);
            kotlin.jvm.internal.f0.o(serverDirectory, "serverDirectory");
            i(serverDirectory);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        try {
            com.blankj.utilcode.util.b0.k(new File(e6.a.f26661c));
            File file2 = new File(DataConstant.FOLDER_SERVER_OLD);
            com.blankj.utilcode.util.b0.k(file2);
            f1.a serverDirectory2 = f1.a.h(file2);
            kotlin.jvm.internal.f0.o(serverDirectory2, "serverDirectory");
            i(serverDirectory2);
            com.blankj.utilcode.util.b0.k(new File("/sdcard/Documents/flydigi/"));
            File file3 = new File("/sdcard/Documents/flydigi/server/");
            com.blankj.utilcode.util.b0.k(file3);
            f1.a serverDirectory3 = f1.a.h(file3);
            kotlin.jvm.internal.f0.o(serverDirectory3, "serverDirectory");
            i(serverDirectory3);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        l().o(Boolean.TRUE);
    }
}

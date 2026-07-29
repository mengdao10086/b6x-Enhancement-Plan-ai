package com.blankj.utilcode.util;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class r {
    public r() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    public static void b(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException unused) {
                }
            }
        }
    }
}

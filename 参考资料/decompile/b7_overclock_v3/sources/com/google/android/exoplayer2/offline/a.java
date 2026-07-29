package com.google.android.exoplayer2.offline;

import android.net.Uri;
import com.google.android.exoplayer2.offline.DownloadRequest;
import g.p0;
import hd.u0;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f17424b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f17425c = "progressive";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f17426d = "dash";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f17427e = "hls";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f17428f = "ss";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hd.b f17429a;

    public a(File file) {
        this.f17429a = new hd.b(file);
    }

    public static String c(Uri uri, @p0 String str) {
        return str != null ? str : uri.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = 3680(0xe60, float:5.157E-42)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L38
            r1 = 103407(0x193ef, float:1.44904E-40)
            if (r0 == r1) goto L2e
            r1 = 3075986(0x2eef92, float:4.310374E-39)
            if (r0 == r1) goto L24
            r1 = 1131547531(0x43720b8b, float:242.04509)
            if (r0 == r1) goto L1a
            goto L42
        L1a:
            java.lang.String r0 = "progressive"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L42
            r4 = 3
            goto L43
        L24:
            java.lang.String r0 = "dash"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L42
            r4 = 0
            goto L43
        L2e:
            java.lang.String r0 = "hls"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L42
            r4 = 1
            goto L43
        L38:
            java.lang.String r0 = "ss"
            boolean r4 = r4.equals(r0)
            if (r4 == 0) goto L42
            r4 = 2
            goto L43
        L42:
            r4 = -1
        L43:
            if (r4 == 0) goto L52
            if (r4 == r3) goto L4f
            if (r4 == r2) goto L4c
            java.lang.String r4 = "video/x-unknown"
            return r4
        L4c:
            java.lang.String r4 = "application/vnd.ms-sstr+xml"
            return r4
        L4f:
            java.lang.String r4 = "application/x-mpegURL"
            return r4
        L52:
            java.lang.String r4 = "application/dash+xml"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.a.d(java.lang.String):java.lang.String");
    }

    public static DownloadRequest f(DataInputStream dataInputStream) throws IOException {
        byte[] bArr;
        String utf = dataInputStream.readUTF();
        int i10 = dataInputStream.readInt();
        Uri uri = Uri.parse(dataInputStream.readUTF());
        boolean z10 = dataInputStream.readBoolean();
        int i11 = dataInputStream.readInt();
        String utf2 = null;
        if (i11 != 0) {
            bArr = new byte[i11];
            dataInputStream.readFully(bArr);
        } else {
            bArr = null;
        }
        boolean z11 = true;
        boolean z12 = i10 == 0 && f17425c.equals(utf);
        ArrayList arrayList = new ArrayList();
        if (!z12) {
            int i12 = dataInputStream.readInt();
            for (int i13 = 0; i13 < i12; i13++) {
                arrayList.add(g(utf, i10, dataInputStream));
            }
        }
        if (i10 >= 2 || (!f17426d.equals(utf) && !f17427e.equals(utf) && !f17428f.equals(utf))) {
            z11 = false;
        }
        if (!z11 && dataInputStream.readBoolean()) {
            utf2 = dataInputStream.readUTF();
        }
        String strC = i10 < 3 ? c(uri, utf2) : dataInputStream.readUTF();
        if (z10) {
            throw new DownloadRequest.UnsupportedRequestException();
        }
        return new DownloadRequest.b(strC, uri).e(d(utf)).f(arrayList).b(utf2).c(bArr).a();
    }

    public static StreamKey g(String str, int i10, DataInputStream dataInputStream) throws IOException {
        int i11;
        int i12;
        int i13;
        if ((f17427e.equals(str) || f17428f.equals(str)) && i10 == 0) {
            i11 = 0;
            i12 = dataInputStream.readInt();
            i13 = dataInputStream.readInt();
        } else {
            i11 = dataInputStream.readInt();
            i12 = dataInputStream.readInt();
            i13 = dataInputStream.readInt();
        }
        return new StreamKey(i11, i12, i13);
    }

    public void a() {
        this.f17429a.a();
    }

    public boolean b() {
        return this.f17429a.c();
    }

    public DownloadRequest[] e() throws IOException {
        if (!b()) {
            return new DownloadRequest[0];
        }
        try {
            InputStream inputStreamD = this.f17429a.d();
            DataInputStream dataInputStream = new DataInputStream(inputStreamD);
            int i10 = dataInputStream.readInt();
            if (i10 > 0) {
                throw new IOException("Unsupported action file version: " + i10);
            }
            int i11 = dataInputStream.readInt();
            ArrayList arrayList = new ArrayList();
            for (int i12 = 0; i12 < i11; i12++) {
                try {
                    arrayList.add(f(dataInputStream));
                } catch (DownloadRequest.UnsupportedRequestException unused) {
                }
            }
            DownloadRequest[] downloadRequestArr = (DownloadRequest[]) arrayList.toArray(new DownloadRequest[0]);
            u0.q(inputStreamD);
            return downloadRequestArr;
        } catch (Throwable th2) {
            u0.q(null);
            throw th2;
        }
    }
}

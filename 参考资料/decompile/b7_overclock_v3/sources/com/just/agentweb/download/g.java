package com.just.agentweb.download;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bumptech.glide.load.engine.GlideException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser;
import com.google.common.net.HttpHeaders;
import com.just.agentweb.download.AgentWebDownloader;
import com.just.agentweb.download.DefaultDownloadImpl;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.UnknownFormatConversionException;
import java.util.concurrent.atomic.AtomicBoolean;
import xf.c0;

/* JADX INFO: loaded from: classes7.dex */
public class g extends AsyncTask<Void, Integer, Integer> implements AgentWebDownloader<DownloadTask>, c {
    public static final int A = 1283;
    public static final int B = 512;
    public static final SparseArray<String> C;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f21962o = g.class.getSimpleName();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f21963p = 8192;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f21964q = 7;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f21965r = 307;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f21966s = 1024;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f21967t = 1025;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f21968u = 1026;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f21969v = 1027;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f21970w = 1028;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f21971x = 1029;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f21972y = 1030;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f21973z = 1031;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile DownloadTask f21974a;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile Throwable f21982i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public f f21985l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile long f21975b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f21976c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f21977d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f21978e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f21979f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile long f21980g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile long f21981h = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f21983j = Long.MAX_VALUE;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f21984k = 10000;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public AtomicBoolean f21986m = new AtomicBoolean(false);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AtomicBoolean f21987n = new AtomicBoolean(false);

    public final class a extends RandomAccessFile {
        public a(File file) throws FileNotFoundException {
            super(file, "rw");
        }

        @Override // java.io.RandomAccessFile, java.io.DataOutput
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            super.write(bArr, i10, i11);
            g.this.f21975b += (long) i11;
            g.this.publishProgress(0);
        }
    }

    static {
        SparseArray<String> sparseArray = new SparseArray<>();
        C = sparseArray;
        sparseArray.append(1024, "Network connection error . ");
        sparseArray.append(1025, "Response code non-200 or non-206 . ");
        sparseArray.append(1026, "Insufficient memory space . ");
        sparseArray.append(1029, "Shutdown . ");
        sparseArray.append(1027, "Download time is overtime . ");
        sparseArray.append(1028, "The user canceled the download . ");
        sparseArray.append(1031, "IO Error . ");
        sparseArray.append(1283, "Service Unavailable . ");
        sparseArray.append(1030, "Too many redirects . ");
        sparseArray.append(512, "Download successful . ");
    }

    @Override // com.just.agentweb.download.c
    public void b() {
        f();
    }

    public final void f() {
        this.f21986m.set(true);
    }

    public final void g(DownloadTask downloadTask) {
    }

    public final boolean h() {
        return !this.f21974a.q0() ? com.just.agentweb.a.c(this.f21974a.N()) : com.just.agentweb.a.a(this.f21974a.N());
    }

    public final boolean i() {
        if (this.f21974a.o0() - this.f21974a.l0().length() <= com.just.agentweb.a.r()) {
            return true;
        }
        c0.a(f21962o, " 空间不足");
        return false;
    }

    @Override // com.just.agentweb.download.i
    public synchronized boolean isShutdown() {
        boolean z10;
        String str = f21962o;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("");
        sb2.append(this.f21987n.get());
        sb2.append(GlideException.a.f12263d);
        sb2.append(this.f21986m.get());
        sb2.append("  :");
        z10 = true;
        sb2.append(getStatus() == AsyncTask.Status.FINISHED);
        c0.c(str, sb2.toString());
        if (!this.f21987n.get() && !this.f21986m.get()) {
            if (getStatus() != AsyncTask.Status.FINISHED) {
                z10 = false;
            }
        }
        return z10;
    }

    public final void j() {
        Context applicationContext = this.f21974a.N().getApplicationContext();
        if (applicationContext == null || !this.f21974a.p()) {
            return;
        }
        f fVar = new f(applicationContext, this.f21974a.m0());
        this.f21985l = fVar;
        fVar.d(this.f21974a);
    }

    public final HttpURLConnection k(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(this.f21984k);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setReadTimeout(this.f21974a.b());
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/*");
        httpURLConnection.setRequestProperty(HttpHeaders.ACCEPT_ENCODING, HlsPlaylistParser.S);
        httpURLConnection.setRequestProperty(HttpHeaders.CONNECTION, "close");
        httpURLConnection.setRequestProperty(HttpHeaders.COOKIE, xf.c.f(url.toString()));
        Map<String, String> mapI = this.f21974a.R().i();
        if (mapI != null && !mapI.isEmpty()) {
            for (Map.Entry<String, String> entry : mapI.entrySet()) {
                if (!TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                    httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }
        }
        if (this.f21974a.l0().length() > 0) {
            String strQ = q();
            if (!TextUtils.isEmpty(strQ)) {
                c0.c(f21962o, "Etag:" + strQ);
                httpURLConnection.setRequestProperty(HttpHeaders.IF_MATCH, q());
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("bytes=");
            long length = this.f21974a.l0().length();
            this.f21977d = length;
            sb2.append(length);
            sb2.append("-");
            httpURLConnection.setRequestProperty(HttpHeaders.RANGE, sb2.toString());
        }
        return httpURLConnection;
    }

    public final boolean l(Integer num) {
        Throwable runtimeException;
        e eVarO = this.f21974a.O();
        if (eVarO == null) {
            c0.a(f21962o, "DownloadListener has been death");
            DefaultDownloadImpl.ExecuteTasksMap.c().d(this.f21974a.l0().getPath());
            return false;
        }
        String absolutePath = this.f21974a.l0().getAbsolutePath();
        String strM = this.f21974a.m();
        if (num.intValue() <= 200) {
            runtimeException = null;
        } else if (this.f21982i == null) {
            runtimeException = new RuntimeException("Download failed ， cause:" + C.get(num.intValue()));
        } else {
            runtimeException = this.f21982i;
        }
        return eVarO.d(absolutePath, strM, runtimeException);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b4, code lost:
    
        r2.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b9, code lost:
    
        return 1283;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int m() throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.just.agentweb.download.g.m():int");
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        int iM;
        try {
            this.f21980g = SystemClock.elapsedRealtime();
        } catch (IOException e10) {
            this.f21982i = e10;
            if (c0.d()) {
                e10.printStackTrace();
            }
            iM = 1031;
        }
        if (!i()) {
            return 1026;
        }
        if (!h()) {
            return 1024;
        }
        iM = m();
        return Integer.valueOf(iM);
    }

    @Override // com.just.agentweb.download.AgentWebDownloader
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void a(DownloadTask downloadTask) {
        p(downloadTask);
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        if (this.f21974a.O() != null) {
            this.f21974a.O().b(this.f21974a.m(), this);
        }
        b.c().a(this.f21974a.m(), this);
        j();
        f fVar = this.f21985l;
        if (fVar != null) {
            fVar.g();
        }
    }

    public final void p(DownloadTask downloadTask) {
        g(downloadTask);
        this.f21974a = downloadTask;
        this.f21976c = this.f21974a.o0();
        this.f21983j = this.f21974a.h();
        this.f21984k = this.f21974a.c();
        if (downloadTask.t()) {
            executeOnExecutor(j.b().a(), null);
        } else {
            execute(new Void[0]);
        }
    }

    public final String q() {
        String string = this.f21974a.N().getSharedPreferences(xf.c.f55208m, 0).getString(this.f21974a.l0().getName(), "-1");
        if (TextUtils.isEmpty(string) || "-1".equals(string)) {
            return null;
        }
        return string;
    }

    public final long r(HttpURLConnection httpURLConnection, String str) {
        String headerField = httpURLConnection.getHeaderField(str);
        if (headerField == null) {
            return -1L;
        }
        try {
            return Long.parseLong(headerField);
        } catch (NumberFormatException e10) {
            if (c0.d()) {
                e10.printStackTrace();
            }
            return -1L;
        }
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        boolean zL;
        DownloadTask downloadTask;
        try {
            b.c().d(this.f21974a.m());
            if (this.f21974a.O() != null) {
                this.f21974a.O().e(this.f21974a.m(), this.f21977d + this.f21975b, this.f21976c, this.f21978e);
            }
            if (this.f21974a.O() != null) {
                this.f21974a.O().c(this.f21974a.m(), this);
            }
            c0.c(f21962o, "msg:" + C.get(num.intValue()));
            zL = l(num);
        } catch (Throwable th2) {
            try {
                if (c0.d()) {
                    th2.printStackTrace();
                }
                if (this.f21974a == null) {
                    return;
                }
            } finally {
                if (this.f21974a != null) {
                    this.f21974a.L();
                }
            }
        }
        if (num.intValue() > 512) {
            f fVar = this.f21985l;
            if (fVar != null) {
                fVar.b();
            }
            if (downloadTask != null) {
                return;
            } else {
                return;
            }
        }
        if (this.f21974a.p()) {
            if (zL) {
                this.f21985l.b();
                if (this.f21974a != null) {
                    this.f21974a.L();
                    return;
                }
                return;
            }
            f fVar2 = this.f21985l;
            if (fVar2 != null) {
                fVar2.e();
            }
        }
        if (!this.f21974a.o()) {
            if (this.f21974a != null) {
                this.f21974a.L();
                return;
            }
            return;
        }
        Intent intentS = com.just.agentweb.a.s(this.f21974a.N(), this.f21974a.l0());
        if (intentS == null) {
            if (this.f21974a != null) {
                this.f21974a.L();
            }
        } else {
            if (!(this.f21974a.N() instanceof Activity)) {
                intentS.addFlags(268435456);
            }
            this.f21974a.N().startActivity(intentS);
            if (this.f21974a == null) {
                return;
            }
            this.f21974a.L();
        }
    }

    @Override // com.just.agentweb.download.i
    public synchronized AgentWebDownloader.ExtraService shutdownNow() {
        if (getStatus() == AsyncTask.Status.FINISHED) {
            c0.a(f21962o, "  Termination failed , becauce the downloader already dead !!! ");
            return null;
        }
        try {
            return this.f21974a.R();
        } finally {
            this.f21987n.set(true);
        }
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public synchronized void onProgressUpdate(Integer... numArr) {
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j10 = jElapsedRealtime - this.f21980g;
            this.f21978e = j10;
            if (j10 == 0) {
                this.f21981h = 0L;
            } else {
                this.f21981h = (this.f21975b * 1000) / this.f21978e;
            }
            if (jElapsedRealtime - this.f21979f < 800) {
                return;
            }
            this.f21979f = jElapsedRealtime;
            if (this.f21985l != null) {
                this.f21985l.f((int) (((this.f21977d + this.f21975b) / Float.valueOf(this.f21976c).floatValue()) * 100.0f));
            }
            if (this.f21974a.O() != null) {
                this.f21974a.O().e(this.f21974a.m(), this.f21977d + this.f21975b, this.f21976c, this.f21978e);
            }
        } catch (UnknownFormatConversionException e10) {
            e10.printStackTrace();
        }
    }

    public final void u(HttpURLConnection httpURLConnection) {
        String headerField = httpURLConnection.getHeaderField(HttpHeaders.ETAG);
        if (TextUtils.isEmpty(headerField)) {
            return;
        }
        c0.c(f21962o, "save etag:" + headerField);
        SharedPreferences.Editor editorEdit = this.f21974a.N().getSharedPreferences(xf.c.f55208m, 0).edit();
        editorEdit.putString(this.f21974a.l0().getName(), headerField);
        editorEdit.apply();
    }

    public final int v(InputStream inputStream, RandomAccessFile randomAccessFile, boolean z10) throws IOException {
        int i10;
        int i11;
        byte[] bArr = new byte[8192];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 8192);
        try {
            if (z10) {
                randomAccessFile.seek(randomAccessFile.length());
            } else {
                randomAccessFile.seek(0L);
                this.f21977d = 0L;
            }
            while (!this.f21986m.get() && !this.f21987n.get() && (i11 = bufferedInputStream.read(bArr, 0, 8192)) != -1) {
                randomAccessFile.write(bArr, 0, i11);
                if (SystemClock.elapsedRealtime() - this.f21980g > this.f21983j) {
                    i10 = 1027;
                    break;
                }
            }
            i10 = this.f21986m.get() ? 1028 : this.f21987n.get() ? 1029 : 512;
            return i10;
        } finally {
            com.just.agentweb.a.j(randomAccessFile);
            com.just.agentweb.a.j(bufferedInputStream);
            com.just.agentweb.a.j(inputStream);
        }
    }
}

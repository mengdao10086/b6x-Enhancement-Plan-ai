package com.just.agentweb.download;

import android.content.Context;
import com.just.agentweb.download.AgentWebDownloader;
import com.just.agentweb.download.DefaultDownloadImpl;
import g.v;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import xf.c0;

/* JADX INFO: loaded from: classes7.dex */
public class DownloadTask extends AgentWebDownloader.Extra implements Serializable {
    private DefaultDownloadImpl.ExtraServiceImpl mCloneExtraService;
    private Context mContext;
    private WeakReference<e> mDownloadWR;
    private WeakReference<DefaultDownloadImpl.ExtraServiceImpl> mExtraServiceImpl;
    private File mFile;
    private int mId;
    private AtomicBoolean mIsDestroyed = new AtomicBoolean(false);
    private String TAG = getClass().getSimpleName();

    public DownloadTask(int i10, e eVar, Context context, File file, DefaultDownloadImpl.ExtraServiceImpl extraServiceImpl) {
        this.mDownloadWR = null;
        this.mExtraServiceImpl = null;
        this.mId = i10;
        this.mContext = context;
        this.mFile = file;
        this.mDownloadWR = new WeakReference<>(eVar);
        this.mIsParallelDownload = extraServiceImpl.t();
        try {
            this.mCloneExtraService = extraServiceImpl.clone();
            this.mExtraServiceImpl = new WeakReference<>(extraServiceImpl);
        } catch (CloneNotSupportedException e10) {
            if (c0.d()) {
                e10.printStackTrace();
            }
            this.mCloneExtraService = extraServiceImpl;
        }
    }

    public void L() {
        this.mIsDestroyed.set(true);
        this.mId = -1;
        this.mUrl = null;
        this.mContext = null;
        this.mFile = null;
        this.mDownloadWR = null;
        this.mIsParallelDownload = false;
        if (this.mExtraServiceImpl.get() != null) {
            this.mExtraServiceImpl.clear();
        }
        this.mExtraServiceImpl = null;
        this.mIsDestroyed = null;
        this.mCloneExtraService = null;
    }

    public Context N() {
        return this.mContext;
    }

    public e O() {
        return this.mDownloadWR.get();
    }

    public WeakReference<e> P() {
        return this.mDownloadWR;
    }

    @v
    public int Q() {
        return this.mCloneExtraService.k() == -1 ? R.drawable.ic_file_download_black_24dp : this.mCloneExtraService.k();
    }

    public DefaultDownloadImpl.ExtraServiceImpl R() {
        return this.mExtraServiceImpl.get();
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public int b() {
        return this.mCloneExtraService.b();
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public int c() {
        return this.mCloneExtraService.c();
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public long h() {
        return this.mCloneExtraService.h();
    }

    public File l0() {
        return this.mFile;
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public String m() {
        return this.mCloneExtraService.m();
    }

    public int m0() {
        return this.mId;
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public boolean o() {
        return this.mCloneExtraService.o();
    }

    public long o0() {
        return this.mCloneExtraService.f();
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public boolean p() {
        return this.mCloneExtraService.p();
    }

    public boolean p0() {
        AtomicBoolean atomicBoolean = this.mIsDestroyed;
        return atomicBoolean == null || atomicBoolean.get();
    }

    public boolean q0() {
        return this.mCloneExtraService.q();
    }

    public void r0(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.just.agentweb.download.AgentWebDownloader.Extra
    public boolean t() {
        return this.mCloneExtraService.t();
    }

    public void t0(File file) {
        this.mFile = file;
    }
}

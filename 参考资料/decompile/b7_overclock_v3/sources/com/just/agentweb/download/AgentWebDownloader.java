package com.just.agentweb.download;

import android.util.ArrayMap;
import com.just.agentweb.download.AgentWebDownloader.Extra;
import g.v;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface AgentWebDownloader<T extends Extra> extends i {

    public static abstract class Extra implements Serializable {
        public String mContentDisposition;
        public long mContentLength;
        public Map<String, String> mHeaders;
        public String mMimetype;
        public String mUrl;
        public String mUserAgent;
        public boolean mIsForceDownload = false;
        public boolean mEnableIndicator = true;

        @v
        public int mIcon = R.drawable.ic_file_download_black_24dp;
        public boolean mIsParallelDownload = true;
        public boolean mIsOpenBreakPointDownload = true;
        public boolean mAutoOpen = false;
        public long downloadTimeOut = Long.MAX_VALUE;
        public int connectTimeOut = 10000;
        public int blockMaxTime = 600000;

        public Extra A(long j10) {
            this.downloadTimeOut = j10;
            return this;
        }

        public Extra B(boolean z10) {
            this.mEnableIndicator = z10;
            return this;
        }

        public Extra C(boolean z10) {
            this.mIsForceDownload = z10;
            return this;
        }

        public Extra D(Map<String, String> map) {
            this.mHeaders = map;
            return this;
        }

        public Extra E(@v int i10) {
            this.mIcon = i10;
            return this;
        }

        public Extra G(String str) {
            this.mMimetype = str;
            return this;
        }

        public Extra H(boolean z10) {
            this.mIsOpenBreakPointDownload = z10;
            return this;
        }

        public Extra I(boolean z10) {
            this.mIsParallelDownload = z10;
            return this;
        }

        public Extra J(String str) {
            this.mUrl = str;
            return this;
        }

        public Extra K(String str) {
            this.mUserAgent = str;
            return this;
        }

        public Extra a(String str, String str2) {
            if (this.mHeaders == null) {
                this.mHeaders = new ArrayMap();
            }
            this.mHeaders.put(str, str2);
            return this;
        }

        public int b() {
            return this.blockMaxTime;
        }

        public int c() {
            return this.connectTimeOut;
        }

        public String d() {
            return this.mContentDisposition;
        }

        public long f() {
            return this.mContentLength;
        }

        public long h() {
            return this.downloadTimeOut;
        }

        public Map<String, String> i() {
            return this.mHeaders;
        }

        public int k() {
            return this.mIcon;
        }

        public String l() {
            return this.mMimetype;
        }

        public String m() {
            return this.mUrl;
        }

        public String n() {
            return this.mUserAgent;
        }

        public boolean o() {
            return this.mAutoOpen;
        }

        public boolean p() {
            return this.mEnableIndicator;
        }

        public boolean q() {
            return this.mIsForceDownload;
        }

        public boolean r() {
            return this.mIsOpenBreakPointDownload;
        }

        public boolean t() {
            return this.mIsParallelDownload;
        }

        public Extra u(boolean z10) {
            this.mAutoOpen = z10;
            return this;
        }

        public Extra v(int i10) {
            this.blockMaxTime = i10;
            return this;
        }

        public Extra w(int i10) {
            this.connectTimeOut = i10;
            return this;
        }

        public Extra x(String str) {
            this.mContentDisposition = str;
            return this;
        }

        public Extra y(long j10) {
            this.mContentLength = j10;
            return this;
        }
    }

    public static abstract class ExtraService extends Extra {
        public abstract void L();
    }

    void a(T t10);
}

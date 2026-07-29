package com.arialyy.aria.core.download.m3u8;

import com.arialyy.aria.core.processor.IVodTsUrlConverter;
import com.arialyy.aria.util.ALog;
import com.arialyy.aria.util.CheckUtil;

/* JADX INFO: loaded from: classes2.dex */
public class M3U8VodOption extends M3U8Option<M3U8VodOption> {
    private long fileSize;
    private int jumpIndex;
    private int maxTsQueueNum;
    private IVodTsUrlConverter vodUrlConverter;

    public long getFileSize() {
        return this.fileSize;
    }

    public int getJumpIndex() {
        return this.jumpIndex;
    }

    public M3U8VodOption setFileSize(long j10) {
        if (j10 <= 0) {
            ALog.e(this.TAG, "文件长度错误");
            return this;
        }
        this.fileSize = j10;
        return this;
    }

    public M3U8VodOption setMaxTsQueueNum(int i10) {
        if (i10 < 1) {
            ALog.e(this.TAG, "同时下载的分片数量不能小于1");
            return this;
        }
        this.maxTsQueueNum = i10;
        return this;
    }

    public M3U8VodOption setPeerIndex(int i10) {
        if (i10 < 1) {
            ALog.e(this.TAG, "切片索引不能小于1");
            return this;
        }
        this.jumpIndex = i10;
        return this;
    }

    public M3U8VodOption setVodTsUrlConvert(IVodTsUrlConverter iVodTsUrlConverter) {
        CheckUtil.checkMemberClass(iVodTsUrlConverter.getClass());
        this.vodUrlConverter = iVodTsUrlConverter;
        return this;
    }
}

package no.nordicsemi.android.dfu;

import android.os.SystemClock;
import g.n0;

/* JADX INFO: loaded from: classes5.dex */
class DfuProgressInfo {
    private int bytesReceived;
    private int bytesSent;
    private int currentPart;
    private int imageSizeInBytes;
    private int initialBytesSent;
    private int lastBytesSent;
    private long lastProgressTime;
    private final ProgressListener mListener;
    private int maxObjectSizeInBytes;
    private int progress;
    private long timeStart;
    private int totalParts;

    public interface ProgressListener {
        void updateProgressNotification();
    }

    public DfuProgressInfo(@n0 final ProgressListener listener) {
        this.mListener = listener;
    }

    public void addBytesSent(final int increment) {
        setBytesSent(this.bytesSent + increment);
    }

    public int getAvailableObjectSizeIsBytes() {
        int i10 = this.imageSizeInBytes;
        int i11 = this.bytesSent;
        int i12 = this.maxObjectSizeInBytes;
        return Math.min(i10 - i11, i12 - (i11 % i12));
    }

    public float getAverageSpeed() {
        if (SystemClock.elapsedRealtime() - this.timeStart != 0) {
            return (this.bytesSent - this.initialBytesSent) / (r0 - r2);
        }
        return 0.0f;
    }

    public int getBytesReceived() {
        return this.bytesReceived;
    }

    public int getBytesSent() {
        return this.bytesSent;
    }

    public int getCurrentPart() {
        return this.currentPart;
    }

    public int getImageSizeInBytes() {
        return this.imageSizeInBytes;
    }

    public int getProgress() {
        return this.progress;
    }

    public float getSpeed() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        float f10 = jElapsedRealtime - this.timeStart != 0 ? (this.bytesSent - this.lastBytesSent) / (jElapsedRealtime - this.lastProgressTime) : 0.0f;
        this.lastProgressTime = jElapsedRealtime;
        this.lastBytesSent = this.bytesSent;
        return f10;
    }

    public int getTotalParts() {
        return this.totalParts;
    }

    public DfuProgressInfo init(final int imageSizeInBytes, final int currentPart, final int totalParts) {
        this.imageSizeInBytes = imageSizeInBytes;
        this.maxObjectSizeInBytes = Integer.MAX_VALUE;
        this.currentPart = currentPart;
        this.totalParts = totalParts;
        return this;
    }

    public boolean isComplete() {
        return this.bytesSent == this.imageSizeInBytes;
    }

    public boolean isLastPart() {
        return this.currentPart == this.totalParts;
    }

    public boolean isObjectComplete() {
        return this.bytesSent % this.maxObjectSizeInBytes == 0;
    }

    public void setBytesReceived(final int bytesReceived) {
        this.bytesReceived = bytesReceived;
    }

    public void setBytesSent(final int bytesSent) {
        if (this.timeStart == 0) {
            this.timeStart = SystemClock.elapsedRealtime();
            this.initialBytesSent = bytesSent;
        }
        this.bytesSent = bytesSent;
        this.progress = (int) ((bytesSent * 100.0f) / this.imageSizeInBytes);
        this.mListener.updateProgressNotification();
    }

    public void setMaxObjectSizeInBytes(final int bytes) {
        this.maxObjectSizeInBytes = bytes;
    }

    public void setProgress(final int progress) {
        this.progress = progress;
        this.mListener.updateProgressNotification();
    }

    public DfuProgressInfo setTotalPart(final int totalParts) {
        this.totalParts = totalParts;
        return this;
    }
}

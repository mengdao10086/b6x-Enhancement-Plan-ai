package com.arialyy.aria.util;

import ya.g;

/* JADX INFO: loaded from: classes2.dex */
public class BandwidthLimiter {
    public static int maxBandWith = 2048;
    private int bytesWillBeSentOrReceive = 0;
    private long lastPieceSentOrReceiveTick = System.nanoTime();
    private int maxRate = 1024;
    private long timeCostPerChunk = (CHUNK_LENGTH.longValue() * g.f56695j) / (((long) this.maxRate) * KB.longValue());
    private static Long KB = 1024L;
    private static Long CHUNK_LENGTH = 1024L;

    public BandwidthLimiter(int i10, int i11) {
        setMaxRate(i11 > 1 ? i10 / i11 : i10);
    }

    public synchronized void limitNextBytes() {
        limitNextBytes(1);
    }

    public synchronized void setMaxRate(int i10) throws IllegalArgumentException {
        if (i10 < 0) {
            throw new IllegalArgumentException("maxRate can not less than 0");
        }
        this.maxRate = i10;
        if (i10 == 0) {
            this.timeCostPerChunk = 0L;
        } else {
            this.timeCostPerChunk = (CHUNK_LENGTH.longValue() * g.f56695j) / (((long) this.maxRate) * KB.longValue());
        }
    }

    public synchronized void limitNextBytes(int i10) {
        this.bytesWillBeSentOrReceive += i10;
        while (!Thread.currentThread().isInterrupted() && this.bytesWillBeSentOrReceive > CHUNK_LENGTH.longValue()) {
            long jNanoTime = System.nanoTime();
            long j10 = this.timeCostPerChunk - (jNanoTime - this.lastPieceSentOrReceiveTick);
            if (j10 > 0) {
                try {
                    Thread.currentThread();
                    Thread.sleep(j10 / 1000000, (int) (j10 % 1000000));
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
            this.bytesWillBeSentOrReceive = (int) (((long) this.bytesWillBeSentOrReceive) - CHUNK_LENGTH.longValue());
            if (j10 <= 0) {
                j10 = 0;
            }
            this.lastPieceSentOrReceiveTick = jNanoTime + j10;
        }
    }
}

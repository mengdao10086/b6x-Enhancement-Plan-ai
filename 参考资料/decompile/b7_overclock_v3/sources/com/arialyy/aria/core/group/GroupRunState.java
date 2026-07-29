package com.arialyy.aria.core.group;

import com.arialyy.aria.core.listener.IDGroupListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
public final class GroupRunState {
    public IDGroupListener listener;
    private String mGroupHash;
    private long mProgress;
    private int mSubSize;
    public SimpleSubQueue queue;
    private String TAG = "GroupRunState";
    private AtomicInteger mCompleteNum = new AtomicInteger();
    private AtomicInteger mFailNum = new AtomicInteger();
    private AtomicInteger mStopNum = new AtomicInteger();
    public AtomicBoolean isRunning = new AtomicBoolean(false);
    private Set<String> mFailTemp = new HashSet();
    private Set<String> mStopTemp = new HashSet();

    public GroupRunState(String str, IDGroupListener iDGroupListener, SimpleSubQueue simpleSubQueue) {
        this.listener = iDGroupListener;
        this.queue = simpleSubQueue;
        this.mGroupHash = str;
    }

    public void countFailNum(String str) {
        this.mFailTemp.add(str);
        this.mFailNum.getAndIncrement();
    }

    public void countStopNum(String str) {
        this.mStopTemp.add(str);
        this.mStopNum.getAndIncrement();
    }

    public int getCompleteNum() {
        return this.mCompleteNum.get();
    }

    public int getFailNum() {
        return this.mFailNum.get();
    }

    public String getGroupHash() {
        return this.mGroupHash;
    }

    public long getProgress() {
        return this.mProgress;
    }

    public int getStopNum() {
        return this.mStopNum.get();
    }

    public int getSubSize() {
        return this.mSubSize;
    }

    public boolean isRunning() {
        return this.isRunning.get();
    }

    public void setRunning(boolean z10) {
        this.isRunning.set(z10);
    }

    public void setSubSize(int i10) {
        this.mSubSize = i10;
    }

    public void updateCompleteNum() {
        this.mCompleteNum.getAndIncrement();
    }

    public void updateCount(String str) {
        if (this.mFailTemp.contains(str)) {
            this.mFailTemp.remove(str);
            this.mFailNum.getAndDecrement();
        } else if (this.mStopTemp.contains(str)) {
            this.mStopTemp.remove(str);
            this.mStopNum.getAndDecrement();
        }
    }

    public void updateProgress(long j10) {
        this.mProgress = j10;
    }
}

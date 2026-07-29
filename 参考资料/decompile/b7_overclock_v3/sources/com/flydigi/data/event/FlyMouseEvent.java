package com.flydigi.data.event;

/* JADX INFO: loaded from: classes7.dex */
public class FlyMouseEvent {
    public static final int STATE_CLICK = 1;
    public boolean show;
    public int state;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f14355x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f14356y;

    public FlyMouseEvent(int x10, int y10, int state, boolean show) {
        this.f14355x = x10;
        this.f14356y = y10;
        this.state = state;
        this.show = show;
    }

    public boolean equals(Object o10) {
        if (this == o10) {
            return true;
        }
        if (o10 == null || getClass() != o10.getClass()) {
            return false;
        }
        FlyMouseEvent flyMouseEvent = (FlyMouseEvent) o10;
        return this.f14355x == flyMouseEvent.f14355x && this.f14356y == flyMouseEvent.f14356y && this.state == flyMouseEvent.state && this.show == flyMouseEvent.show;
    }

    public String toString() {
        return "FlyMouseEvent{x=" + this.f14355x + ", y=" + this.f14356y + ", state=" + this.state + ", show=" + this.show + '}';
    }
}

package com.example.waspwingtempctrl;

/**
 * 页面可见性回调（外壳切页时广播）：只有当前页收 {@code true}、其余页收 {@code false}；页序号由外壳
 * 写进 Fragment 的 arguments 后反查，页面自身不需要知道自己是第几页。
 *
 * <p>为什么需要它（ViewPager2 后生命周期不再随切页暂停/恢复），见 {@code app/逻辑说明.md} §9.1。
 */
public interface PageAware {

    /**
     * @param visible true = 本页成为当前页；false = 本页已不是当前页
     */
    void onPageVisible(boolean visible);
}

# 路线 A — 线 D / D2 `ChartView` 曲线口径清单

> 只读调研产出。对象 = 现存 WebUI 的曲线绘制口径，供移植到 Android 自绘 Canvas。
> 依据文件：`app.js`(1496) / `style.css`(250) / `index.html`(83) / `schema.js`(194) / `逻辑说明.md`(701) / `tempctrl.c`(2913) / `params.json`(1634)。
> 依据缺失/冲突 3 处：见 §15。

## 1. 双纵轴定标

**左轴**（`app.js:992,1041-1054`）
- 数据源 = 当前显示窗口中所有 `axis:'left'` 且开启的系列（默认 batt/hot/rpm 三条，见 §11）。
- 取值 getter `leftV`（`app.js:1020-1027`）：`rpm` → `d.rpm/100`（**百rpm，与 ℃ 共轴**）；`hot` → `d.hotF`（滤波值）；`batt` → `d.battF`（滤波值）；其余 → `d[key]` 原值。
- 上下限 = 窗口内数据 min/max **自适应**，每帧重算，不跨窗口记忆。
- **下限门槛键** `WEBUI_RPM_AXIS_MIN`（`app.js:813-819,1031-1037`）：仅轴计算用的 getter `leftVAxis` 在 `rpm < rpmMin` 时返回 null（按原始整数 `d.rpm` 比较，不换算）。→ 该段不参与上下限；**绘图仍走 `leftV` 原值**，故低速段会落到画布外被裁。`rpmMin<=0` = 关闭。
- 兜底（`app.js:1050-1052`）：`extent(leftSeries,leftVAxis)==null`（过滤后左轴无有效值）→ 退回 `extent(...,leftV)` 不过滤。
- 整档：`niceAxis(min,max)` → `pickAxis`（`app.js:862-889`）：档位梯子 `[1,2,3,5]` + 所有 ≥5 的 5 的整数倍；候选区间 `[span/5, span)`；只取能形成 3~5 段的档位（段数 = `ticksOf().length-1`），在合格者中取离 `span/4` 最近；无合格候选则取 `nearestLadder(span/4)`（平局取小）。上下限 `floor/ceil` 到档位，绝不裁点。
- 刻度值 `ticksOf(lo,hi,step)`（`app.js:849-857`）：非整档对齐时补 lo；末档不齐补 hi。
- 标签格式 `fmtTick`（`app.js:883-889`）：小数位 = step 字符串的小数位（≤2）；`x.0` 去尾。
- 刻度条数与刻度文字量由整档算法决定（目标 4 段，实测 3~5）。

**右轴**（`app.js:1061-1066`）
- 只有 1 条：`coldReal`（制冷），`rightV` = 原值。
- 下限**恒为 1**（硬编码 = C 端 `COLD_MIN`）。
- 上限浮动 = 窗口内 `coldReal` 峰值夹进 `[coldMapStart(), pidColdMax()]`；无有效数据 → 回落 `pidColdMax()`。
  - `coldMapStart()`（`app.js:762-772`）= `COLD_RPM_MAP` 第 1 值（clamp 0~194），`PERF_ENABLED!=='1'` 时 40。
  - `pidColdMax()`（`app.js:751-759`）= `PID_COLD_RANGE` 第 2 值（B6X 上限），未开总开关或非法时 190。
- **右轴不自算刻度、不画线**：只在左轴每条横线高度上标一个整数 = `round(1 + (R.max-1)*(v-Lmin)/(Lmax-Lmin))`，钳到 `[1,R.max]`（`app.js:1092-1106`）。左轴全关 → 右侧不标数字。

## 2. 零相位双向滤波（`app.js:905-955`）

- 参数 `WEBUI_CURVE_FILTER = "α×100 步长×100"`：α = 第1值/100（缺/负 → 0.15，**0 合法**），step = 第2值/100（缺/负 → 0.05，0 合法）。两个子级独立开关。
- **只有 hot 与 batt 两条参与**，各自独立分段（`app.js:960-963`）。outKey = `hotF` / `battF`。
- 分段：扫描样本，`v==null || v<0` → 写 `out[outKey]=null` 并结束当前段；否则入段。段末统一 `smoothSegment`。
- `smoothSegment` 两级，顺序固定：
  1. **双向 EMA**（仅 `0 < α < 0.999` 生效）：前向 `prev += α*(src[j]-prev)`（j=1..m-1，`prev` 初值 = 段首 src 值）；反向 `cur = out[m-1]`（即前向末值，末端延拓），`cur += α*(out[j]-cur)`，j=m-2..0 **就地写回 out[j]**。α=0 或 ≥0.999 → 全部原值写回（恒等，仍遍历）。
  2. **格点吸附**（仅 `step>0`；否则保留上一步结果）。
- **注意**：每段每个有效样本的 outKey 必被赋值（否则曲线整条消失）。

## 3. 最小步长格点吸附（`app.js:930-937`，在滤波之后，同函数内）

```
q   = round(out[首个]/step) * step      // 锚点对齐 step 整格
thr = step * 0.9
out[首个] = q
for j=1..m-1:
    dx = out[j] - q
    if (dx >= thr || dx <= -thr) q += step * round(dx / step)
    out[j] = q
```
- 阈值 0.9 格：> 0.5 格（否则吸附后抖动）、< 1 格（否则稳态永久差一格）。
- 关闭条件：`step <= 0`（= 配置第 2 值为 0）。

## 4. 断联按真实时长插空白（`app.js:995-1012, 1117-1123`）

- `gapDetectSec` = `WEBUI_GAP_SEC` 第1值（非有限/≤0 → 5）；`gapMaxSec` = 第2值（非有限/≤0 → 15）(`app.js:783-792`)。
- 逐样本累计：`dt = t[i]-t[i-1]; if (dt > gapDetectSec) totalGap += min(dt, gapMaxSec)`；`gap[i] = totalGap`（累计到 i）。
- `totalUnits = (n>1 ? n-1 : 0) + totalGap`。
- **x = padL + W * ((di + gap[di]) / totalUnits)** —— 时间轴 = **样本序号等距 + 断联按真实 dt 的封顶量补偿**，**不是**真实时间等比（正常段 1 行 = 1 格，与 dt 无关；时间戳只用于窗口裁剪与断联判定）。
- 断开落笔：`if (di>0 && dt > gapDetectSec) started=false;` → 下一个有效点走 `moveTo`（不连桥），空白段内不落笔（`app.js:1118,1123`）。
- 有效值：`v==null` 时 `continue`（既不断笔也不落点）。

## 5. 标签合并（`app.js:1133-1221`）

- 阈值 `MERGE_Y = gapSec('WEBUI_LABEL_MERGE_PX', 9)`（`app.js:775,1135`；非有限/负 → 9，允许小数与 0）。
- 每条系列取**最后一个有效样本**（倒序扫 `data`），x 同 §4 公式，y = `yOf(axis,v)`；y 钳制：`rpm` 系列下限到 `seamY`（= ch-ov），其余到 `padT+H`；上钳 `padT`。
- 文本 `headLabel`：unit==='°C' → `v.toFixed(1)+'°C'`；`rpm` → `Math.round(v*100)+'rpm'`；否则 `String(v)`（`coldReal` 走此支，纯整数）。
- 单标签 x：`tx = e.x+6`；`tx+w > padL+W` → `tx = e.x-6-w`；`tx<2` → 2（不再二次回退，允许与曲线重叠）。
- 合并：按 y 升序排序；`e.y - 簇首.y < MERGE_Y` 入当前簇，否则起新簇（**与簇首比较**，非与前一元素）。
- 基准 y `sideY`：簇最低点 `> padT+H` → `top-4`；否则上方空间 `(top-padT) >= (padT+H-bot)` → `top-4`；否则 `bot + 11 + 1`（LABEL_H=11）。最后 `ly` 钳到 `[padT, padT+H+11]`。
- 单元素簇：画圆点 + 标签；多元素簇：`cx = mean(x)`，`sep = measureText(' / ')`，`total = Σw + sep*(k-1)`；`tx = cx+6`，超右则 `cx-6-total`，`tx<2`→2；逐段以**各自系列色**画标签、段间画 `' / '` 色 `#888`，最后给每个元素画圆点。

## 6. 背景色 halo 描边（`app.js:1181-1196`）

- 目的：曲线穿过字形时避免同色糊在一起。
- 文字：`strokeStyle = dark ? '#171c22' : '#ffffff'`（= `.top` 的 `var(--surface)`），`lineWidth 3`，**先 `strokeText` 再 `fillText`（系列色）**。
- 圆点：`arc` r=3.2 填系列色，再以同一 halo 色 `lineWidth 1` 描边（同一 path）。
- 文字 halo 与圆点 halo 同色，均取自 `matchMedia('(prefers-color-scheme: dark)')`。
- 覆盖顺序（`app.js:1107-1129,1222`）：网格 → 左轴系列折线（按 `S.series` 过滤顺序）→ 右轴系列折线 → 最后画标注（标注压在所有曲线上）。同一轴内后画者压先画者。

## 7. 超宽整块等比缩放（`app.js:709-720`）

- 对象 = **`#ctInner`（时间窗口按钮 + 图例）这一整块**，**不含 canvas**（画布按容器宽自适应重排）。
- `avail = ctInner.parentElement.clientWidth`；`total = ctInner.offsetWidth`（未缩放自然宽）；`fitLimit = avail*0.96`（4% 余量）；`z = total>fitLimit ? max(0.5, fitLimit/total) : 1`；`transform-origin: left top`；`transform: scale(z)` 或 `'none'`。**最小 0.5，不可复位**（每次 refresh / resize / fonts.ready 重算）。
- 因是 CSS transform：线宽、字号、间距**全部同比缩放**；裁切在父级 `.chart-tools{overflow:hidden}`（`style.css:100-102`）。
- 触发点：`refreshCurve` 每 1s、`initChartUI` 的 resize / ResizeObserver / `document.fonts.ready`（`app.js:642,1340-1348`）。

## 8. 窗口档位与滚动行数

- 档位集合：`SCHEMA.chartWindowOptions = [120,180,240,360,480,720]`（`schema.js:24`，与 `params.json` `chart.windowOptionsSec` 同值）。**app.js 不读 params.json 的 chart 块**。
- 默认 360：**硬编码**（`app.js:1313-1314`），`params.json` 的 `chart.windowDefaultSec` 在 WebUI 端**无消费点**；持久化 `localStorage['b6xChartWindow']`，非法值回落 360。
- 丢弃：先按条数 `S.samples.slice(-window)`，再按时间收紧 `while (data[start].t < lastT - winSec) start++`（保留 ≥ 1 个样本，`app.js:979-991`）→ 超出窗口的旧样本整体丢弃，纵轴/曲线/标注都只看窗口内数据。
- 滚动行数上限：**C 端** `WEBUI_DATA_MAX_LINES = 720`（`tempctrl.c:320`），每 60 行压缩保留最近 720 行；WebUI 端无对应键。
- 时间轴起止随滚动变化：窗口内容整体左移，x 映射按窗口内相对序号重算（`totalUnits` 每帧重算）。
- 窗口与采样间隔：1 行 ≈ 1s（见 §9），故 720 档 = 720 行；断联时空洞由 §4 的 gap 补偿而非丢样本。

## 9. 数据文件格式（生产者 = C 端）

- 路径：`WEBUI_DATA_PATH = PRIVATE_DIR "/tempctrl_webui.data"`，`PRIVATE_DIR = /data/data/com.example.waspwingtempctrl/files`（`tempctrl.c:81,319`）。
  **冲突**：`schema.js:23` 声明 `/data/local/tmp/tempctrl_webui.data`（旧路径，与现 C 端不一致）。
- 写入点：主循环每轮首行 `write_webui_data()`（`tempctrl.c:2650-2695,2818-2819`），循环尾 `sleep(1)`（`tempctrl.c:2908`）→ **约 1s/行**（5s 控制块内 CPU zone 全量重扫可阻塞近 1s，偶有 >1s 间隔）。
- 行格式（`tempctrl.c:2665-2668`）：`%ld,%d,%d,%d,%d,%d,%d,%d\n`，逗号分隔、无表头、每行 ≤96 字节（`tempctrl.c:2676`）：

| # | 字段 | 单位 | 来源 | 哨兵 |
|---|---|---|---|---|
| 0 | epoch | Unix 秒（`(long)time(NULL)`，1s 精度） | 写入时刻 | — |
| 1 | 电池 | 0.1°C | `read_battery_temp()`（即时读，非缓存） | -1 |
| 2 | CPU | 0.1°C | `read_cpu_temp_max()` | -1 |
| 3 | 热端 | 0.1°C | status `HOT_TEMP=` | -1 |
| 4 | 冷端 | 0.1°C | status `COLD_TEMP=` | -1 |
| 5 | 实际转速 | RPM（原值，非百） | status `RPM_REAL=` | -1 |
| 6 | 实际制冷 | 制冷档位 | status `COLD_REAL=` | -1 |
| 7 | 目标制冷 | 制冷档位 | `actual_cold` | -1 |

- **哨兵 = -1**（`tempctrl.c:161,282-285,1108-1109,2806`），含义「未就绪/无效」；app.js 判 `v>=0` 有效，否则 null（`app.js:620-621`）。
- 第 7 列 WebUI **完全未消费**（`app.js:625-629` 只读到 index 6）。
- 断联即**停写**：`!app_ble_connected || !is_app_alive()` → return（`tempctrl.c:2660`），留下真实时间空洞。
- 滚动/截断：每 `WEBUI_COMPACT_EVERY=60` 行压缩一次，读全文件环形取最近 720 行、`"w"` 原地重写（不 rename）；文件最多膨胀到 780 行（`tempctrl.c:2642,2674-2694`）。fopen 失败静默不写。

## 10. 解析失败 / 缺样 / 半截行 / 哨兵（`app.js:614-632`）

- 逐行 `trim().split(',')`；**`p.length < 8` → 整行跳过**（不中断解析，不产生断点）。空行/半截行因此被丢弃。
- 每列 `parseInt`，`NaN → null`（该列 null，行仍保留）。
- `temp(v) = v>=0 ? v/10 : null`（batt/cpu/hot/cold）；`raw(v) = v>=0 ? v : null`（rpm/coldReal）。→ **哨兵 -1 变成 null = 断档**，不画点（`plot` 里 `continue`；滤波里按无效值断段）。
- 时间列 `t` 同样可为 null；`dt` 变 NaN，`NaN > gapDetectSec` 为 false → 不产生断联补偿（该行静默不参与）。
- 全文件无有效行 → `S.samples = []` → 画布显示「采样中…」（`app.js:1014-1018`）。
- **文件为空/读失败时不清空旧数据、不重绘**（`app.js:636-637`），曲线冻结在上一帧。

## 11. 曲线颜色 / 线宽 / 条数（`app.js:163-172`）

| 图例序 | key | 标签 | 颜色 | 轴 | 默认 |
|---|---|---|---|---|---|
| 1 | batt | 电池℃ | `#f44336` | 左 | 开 |
| 2 | coldReal | 制冷 | `#4caf50` | 右 | 开 |
| 3 | rpm | 风扇rpm | `#9c27b0` | 左 | 开 |
| 4 | hot | 热端℃ | `#e91e63` | 左 | 开 |
| 5 | cold | 冷端℃ | `#2196f3` | 左 | 关 |
| 6 | cpu | CPU℃ | `#ff9800` | 左 | 关 |

- 折线 `strokeStyle = s.color`，`lineWidth = 1.6`（`app.js:1114`），无填充、无平滑、无抗锯齿显式设置（Canvas2D 默认开）。
- 左轴最多 5 条（batt/rpm/hot/cold/cpu，共用 ℃ 与 百rpm），右轴恒 1 条。
- 图例色块 = 8px 圆点（`style.css:116`）；图例项 checkbox 16px。

## 12. 像素常量（轴 / 网格 / 字体 / 边距）

- canvas：CSS `#chart { width:100%; height: calc(100% + 12px) }`（`style.css:121`，**向下外扩 12px**）；JS 按 `clientWidth/clientHeight × devicePixelRatio` 设 width/height 并 `setTransform(dpr,0,0,dpr,0,0)`（`app.js:964-969`）。
- `padL=36, padR=36, padT=16, padB=4+ov`，`ov = ch - parent.clientHeight`（CSS 生效时 = 12）→ **padB=16**；`W = cw-padL-padR`，`H = ch-padT-padB`；`seamY = ch-ov`（`app.js:971-978`）。
- `yOf(axis,v) = padT + H*(1 - (v-min)/(max-min))`（`app.js:1070`）。
- 刻度文字：`10px system-ui`，`fillStyle '#888'`；左标签 `(padL-4, y+3)` textAlign right；右标签 `(padL+W+4, y+3)` textAlign left。
- 网格线：`strokeStyle 'rgba(128,128,128,0.15)'`，从 `(padL,y)` 到 `(padL+W,y)`；**lineWidth 未显式设置**（沿用上一帧残留 1 或 3，移植时定 1）。
- 轴标题：左 `'℃/百rpm'` @ `(2, padT-7)`；右 `'制冷'` @ `(padL+W+4, padT-7)`；均 `10px system-ui` `#888`。
- 空态文字：`12px system-ui`，`#888`，位置 `(padL+W/2-24, padT+H/2)`。
- 标签/圆点：字体 `10px system-ui`；halo `lineWidth 3`；圆点 r=3.2、描边 1；`LABEL_H = 11`。
- 外壳：`.top-bar` padding `6px 10px 4px`；`.chart-tools` padding `3px 10px 2px`；`.live` padding `4px 10px 0`、`font-size 11px`、`border-top 1px`、`tabular-nums`；顶部区高度 `--top-h` 默认 `36dvh`、下限 `220px`（`style.css:48,57-59,100,122-128`）。

## 13. `params.json` 键 → 口径对应表

| 键 | 驱动 | 取值/默认 | 子值映射 |
|---|---|---|---|
| `WEBUI_GAP_SEC` | §4 断联空白 | schema `[1,120]`,`[1,600]`；默认 `5 15` | 第1值=断联判定阈值秒（`app.js:1001`）；第2值=空白封顶秒（`app.js:1002`）。二者共用 `gapPair()`，非有限/≤0 各自回落 5/15 |
| `WEBUI_LABEL_MERGE_PX` | §5 标签合并 | schema `[1,40]`；默认 9 | 单值，无子值；垂直距离阈值（`app.js:1135`），亦决定簇划分（与簇首比） |
| `WEBUI_RPM_AXIS_MIN` | §1 左轴下限门槛 | schema `[0,8000]`；默认 3000 | 单值；`>0` 生效，`0`=关闭；只作用于轴 extent getter（`app.js:1031-1037`），不影响绘图 |
| `WEBUI_CURVE_FILTER` | §2 滤波 + §3 吸附 | schema `[0,100]`,`[0,100]`；默认 `15 5` | 第1值/100 = 每遍 α（`app.js:798`）；第2值/100 = 最小步长（`app.js:799`）。各子值 0 合法 = 关闭该级 |
| `chart.windowOptionsSec` | §8 档位集合 | `[120,180,240,360,480,720]` | 数组，无子值。**app.js 实际用 `schema.js:24` 的同值副本**，不读本键 |
| `chart.windowDefaultSec` | §8 默认档位 | 360 | 单值。**WebUI 无消费点**（app.js:1313 硬编码 360） |
| `chart.rollingMaxLines` | §8 滚动行数上限 | 720 | 单值。**WebUI 无消费点**；对应 C 端 `WEBUI_DATA_MAX_LINES`（`tempctrl.c:320`） |

## 14. 移植到 Android 自绘 Canvas 的差异点

1. **字体度量**：CSS 无显式行高，原实现用常量 `LABEL_H=11` 近似 10px 字体的行高；Android 用 `Paint.FontMetrics`（ascent/descent）算基线与行高，`canvas.drawText` 的 y 是**基线**（对齐原 `fillText` 语义）。textAlign right/left 需每次显式设置（原实现靠 `ctx.textAlign` 状态机，末尾复位 'left'）。
2. **没有 CSS 就得自算**：背景/接缝色 `--surface`（深 `#171c22` / 浅 `#ffffff`）需自取；`clientWidth/clientHeight` 换成 View 尺寸；`#chart` 的 12px 下外扩与 `ov` 抵消技巧需手工留白（否则纵轴刻度会变）；`.ct-inner` 的 `transform: scale` 打包缩放需自己实现（缩 canvas 之外的控件行）。
3. **路径平滑/抗锯齿**：原实现**没有任何平滑**（形状只由 C 端滤波 + 格点吸附决定），`plot` 就是逐点 `lineTo`；Android 需 `setAntiAlias(true)`，否则折点毛刺。`measureText` 用于标签宽度，需复用同一 Paint 的度量缓存。
4. **时间轴取值**：x **不要**用 `System.currentTimeMillis()`——x = 样本序号 + 断联补偿（§4）。文件时间戳只用于两处：窗口裁剪 `cutoff = lastT - windowSec`、断联判定 `dt > gapDetectSec`。原实现也没有"文件是否在更新"的活性判断（空文件时曲线冻结）。
5. **一次画 720 点的性能**：每帧上限 ≈720 点 × 最多 6 条折线 + 最多 6 个标签；原实现每 1s 全量重建 path 重绘（不是每帧）。Android 应复用 `Path`/`Paint` 对象、避免 `onDraw` 内做文件读取与字符串解析（原实现是异步读+解析后再 `drawChart()`），并按 dpr 处理像素密度。

## 15. 依据缺失 / 冲突汇总（3 条）

1. **路径冲突**：`schema.js:23` 读 `/data/local/tmp/tempctrl_webui.data`，`tempctrl.c:319` 写 `PRIVATE_DIR/tempctrl_webui.data`（= `/data/data/com.example.waspwingtempctrl/files/`）。两侧不一致。
2. **两个键在 WebUI 端无依据**：`chart.windowDefaultSec`、`chart.rollingMaxLines` 在 app.js 全文无引用（grep 确认），WebUI 侧分别由硬编码 360 与 C 端常量承担。
3. **网格线宽无明确依据**：`drawGrid` 未设置 `ctx.lineWidth`，实际值随上一帧末次设置（1 或 3）漂移，无设计口径。

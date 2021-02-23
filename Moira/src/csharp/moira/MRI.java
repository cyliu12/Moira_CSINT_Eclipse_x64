package csharp.moira;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Hashtable;
import org.athomeprojects.base.BaseCalendar;
import org.athomeprojects.base.Calculate;
import org.athomeprojects.base.ChartData;
import org.athomeprojects.base.City;
import org.athomeprojects.base.Resource;

public class MRI {
	static public final String DllID = "MRI_x64";
	static public final int SUN = ChartData.SUN; // 0
	static public final int MOON = ChartData.MOON; // 1
	static public final int VENUS = ChartData.VENUS; // 2
	static public final int JUPITER = ChartData.JUPITER; // 3
	static public final int MERCURY = ChartData.MERCURY; // 4
	static public final int MARS = ChartData.MARS; // 5
	static public final int SATURN = ChartData.SATURN; // 6
	static public final int URANUS = ChartData.URANUS;
	static public final int NEPTUNE = ChartData.NEPTUNE;
	static public final int PLUTO = ChartData.PLUTO;
	static public final int TRUE_NODE = ChartData.TRUE_NODE; // 計 10
	static public final int INV_TRUE_NODE = ChartData.INV_TRUE_NODE; // opposite of TRUE_NODE //羅 11
	static public final int PURPLE = ChartData.PURPLE; // 炁 12
	static public final int MEAN_APOG = ChartData.MEAN_APOG; // 孛
	static public final int FORTUNE = ChartData.FORTUNE;
	static public final int ASC = ChartData.ASC;
	static public final int MC = ChartData.MC;
	static public final int CHIRON = ChartData.CHIRON;
	static public final int CERES = ChartData.CERES;
	static public final int PALLAS = ChartData.PALLAS;
	static public final int JUNO = ChartData.JUNO;
	static public final int VESTA = ChartData.VESTA;
	static public final int SPEED_NORMAL = Calculate.SPEED_NORMAL; // 0
	static public final int SPEED_REVERSE = Calculate.SPEED_REVERSE; // 1 逆
	static public final int SPEED_ECLIPSE = Calculate.SPEED_ECLIPSE; // 2 蝕
	static public final int SPEED_STATIONARY = Calculate.SPEED_STATIONARY; // 3 留
	static public final int SPEED_INVISIBLE = Calculate.SPEED_INVISIBLE; // 4 伏
	static public final int SPEED_SLOW = Calculate.SPEED_SLOW; // 5 遲
	static public final int SPEED_FAST = Calculate.SPEED_FAST; // 6 速
	static public final String[] PLANET_NAMES = { "日", "月", "金", "木", "水", "火", "土", "天", "海", "冥", "計", "羅", "炁", "孛",
			"福", "升", "頂", "醫", "穀", "智", "婚", "灶" };
	static public final String[] HOUSES12 = { "戌", "酉", "申", "未", "午", "巳", "辰", "卯", "寅", "丑", "子", "亥" };
	static public final double[] HOUSES12_POS = { 0, 30, 60, 90, 120, 150, 180, 210, 240, 270, 300, 330 };
	static public final String[] MANSIONS28_LONG = { "婁金", "胃土", "昴日", "畢月", "觜火", "參水", "井木", "鬼金", "柳土", "星日", "張月",
			"翼火", "軫水", "角木", "亢金", "氐土", "房日", "心月", "尾火", "箕水", "斗木", "牛金", "女土", "虛日", "危月", "室火", "壁水", "奎木" };
	static public final String[] MANSIONS28_SHORT = { "婁", "胃", "昴", "畢", "觜", "參", "井", "鬼", "柳", "星", "張", "翼", "軫",
			"角", "亢", "氐", "房", "心", "尾", "箕", "斗", "牛", "女", "虛", "危", "室", "壁", "奎" };
	static public final double[] MANSIONS28_POS = { 15.9, 26.3, 41.1, 53.2, 69.0, 70.0, 81.8, 112.3, 115.2, 130.5,
			136.4, 151.4, 170.1, 187.2, 200.0, 208.9, 225.2, 230.6, 237.0, 255.6, 266.3, 290.1, 298.0, 308.9, 318.3,
			333.6, 349.4, 358.3 };
	static public final String[] MANSIONS28_KAH = { "角", "亢", "氐", "房", "心", "尾", "箕", "斗", "牛", "女", "虛", "危", "室",
			"壁", "奎", "婁", "胃", "昴", "畢", "觜", "參", "井", "鬼", "柳", "星", "張", "翼", "軫" };
	static public final String[] KAN_NAMES = { "甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸" };
	static public final String[] KI_NAMES = { "子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥" };
	static public final String[] KANKI60_NAMES = { "甲子", "乙丑", "丙寅", "丁卯", "戊辰", "己巳", "庚午", "辛未", "壬申", "癸酉", "甲戌",
			"乙亥", "丙子", "丁丑", "戊寅", "己卯", "庚辰", "辛巳", "壬午", "癸未", "甲申", "乙酉", "丙戌", "丁亥", "戊子", "己丑", "庚寅", "辛卯", "壬辰",
			"癸巳", "甲午", "乙未", "丙申", "丁酉", "戊戌", "己亥", "庚子", "辛丑", "壬寅", "癸卯", "甲辰", "乙巳", "丙午", "丁未", "戊申", "己酉", "庚戌",
			"辛亥", "壬子", "癸丑", "甲寅", "乙卯", "丙辰", "丁巳", "戊午", "己未", "庚申", "辛酉", "壬戌", "癸亥" };
	static public final String[] KI_HOUSE_MASTER = { "土", "土", "木", "火", "金", "水", "日", "月", "水", "金", "火", "木" };
	static public final String[] KI_HOUSE_VICE_MASTER = { "計", "計", "炁", "羅", "無", "孛", "無", "無", "孛", "無", "羅", "炁" };

	static public final String[] FATE_12CATS = { "命宮", "財帛", "兄弟", "田宅", "男女", "奴僕", "夫妻", "疾厄", "遷移", "官祿", "福德",
			"相貌" };
	static public final String[] FATE_12CATS_BWD = { "命宮", "相貌", "福德", "官祿", "遷移", "疾厄", "夫妻", "奴僕", "男女", "田宅", "兄弟",
			"財帛" };
	static public final String[] LONGLIFE12 = { "長生", "沐浴", "冠帶", "臨官", "帝旺", "衰", "病", "死", "墓", "絕", "胎", "養" };
	static public final String[] LONGLIFE12_BWD = { "長生", "養", "胎", "絕", "墓", "死", "病", "衰", "帝旺", "臨官", "冠帶", "沐浴" };
	static public final String[] SOLAR_TERM24 = { "小寒", "大寒", "立春", "雨水", "驚蟄", "春分", "清明", "穀雨", "立夏", "小滿", "芒種",
			"夏至", "小暑", "大暑", "立秋", "處暑", "白露", "秋分", "寒露", "霜降", "立冬", "小雪", "大雪", "冬至" };
	public String name, gender, country, city, zone;
	public int birth_year, birth_month, birth_day, birth_hour, birth_minute;
	public int now_year, now_month, now_day, now_hour, now_minute;
	public ChartTab chart_tab = null;
	public ChartData data = null;
	public PublicChartData result = new PublicChartData();
	public Hashtable shen_sha_table_b, shen_sha_table_n;

	public void setLocation(String countryName, String cityName, String zoneName) {
		country = countryName;
		city = cityName;
		zone = zoneName;
	}

	public void setBirthTime(int[] birth) {
		birth_year = birth[0];
		birth_month = birth[1];
		birth_day = birth[2];
		birth_hour = birth[3];
		birth_minute = birth[4];
	}

	public void setNowTime(int[] now) {
		now_year = now[0];
		now_month = now[1];
		now_day = now[2];
		now_hour = now[3];
		now_minute = now[4];
	}

	public String getCountry() {
		return chart_tab.getSpinner().getCountryName();
	}

	public String getCity() {
		return chart_tab.getSpinner().getCityName();
	}

	public String getZone() {
		return chart_tab.getSpinner().getZoneName();
	}

	public void getBirthDate(int[] date) {
		chart_tab.getBirthDate(date);
	}

	public void getNowDate(int[] date) {
		chart_tab.getNowDate(date);
	}

	/**
	 * 取得出生時間
	 * 
	 * @param lunar  Optional (default false) true則傳回陰曆
	 * @param format Optional (default 年/月/日 時:分) "date" "time" 分別代表：年/月/日 時::分
	 * @return
	 */
	public String getBirthString(boolean lunar, String format) {
		int[] date = new int[5];
		String retval = null;
		String year = null;
		chart_tab.getBirthDate(date);
		year = Integer.toString(date[0]);
		if (lunar) {
			date = result.lunar_date;
			year = result.year_names[date[0] - 1];
		}
		switch (format) {
		case "date":
			retval = year + "/" + String.format("%02d", date[1]) + "/" + String.format("%02d", date[2]);
			break;
		case "time":
			retval = String.format("%02d", date[3]) + ":" + String.format("%02d", date[4]);
			break;
		default: // datetime
			retval = year + "/" + String.format("%02d", date[1]) + "/" + String.format("%02d", date[2]) + "  "
					+ String.format("%02d", date[3]) + ":" + String.format("%02d", date[4]);
		}
		return retval;
	}

	/**
	 * {@link #getBirthString(boolean, String)}
	 * 
	 * @param lunar
	 * @return
	 */
	public String getBirthString(boolean lunar) {
		return getBirthString(lunar, "datetime");
	}

	/**
	 * {@link #getBirthString(boolean, String)}
	 * 
	 * @param lunar
	 * @return
	 */
	public String getBirthString() {
		return getBirthString(false, "datetime");
	}

	/**
	 * 取得現在時間
	 * 
	 * @param lunar  Optional (default false) true則傳回陰曆
	 * @param format Optional (default 年/月/日 時:分) "date" "time" 分別代表：年/月/日 時::分
	 * @return
	 */
	public String getNowString(boolean lunar, String format) {
		int[] date = new int[5];
		String retval = null;
		String year = null;
		chart_tab.getNowDate(date);
		year = Integer.toString(date[0]);
		if (lunar) {
			date = result.now_lunar_date;
			year = result.year_names[date[0] - 1];
		}
		switch (format) {
		case "date":
			retval = year + "/" + String.format("%02d", date[1]) + "/" + String.format("%02d", date[2]);
			break;
		case "time":
			retval = String.format("%02d", date[3]) + ":" + String.format("%02d", date[4]);
			break;
		default: // datetime
			retval = year + "/" + String.format("%02d", date[1]) + "/" + String.format("%02d", date[2]) + "  "
					+ String.format("%02d", date[3]) + ":" + String.format("%02d", date[4]);
		}
		return retval;
	}

	/**
	 * {@link #getNowString(boolean, String)}
	 * 
	 * @param lunar
	 * @return
	 */
	public String getNowString(boolean lunar) {
		return getNowString(lunar, "datetime");
	}

	/**
	 * {@link #getNowString(boolean, String)}
	 * 
	 * @param lunar
	 * @return
	 */
	public String getNowString() {
		return getNowString(false, "datetime");
	}

	/**
	 * 
	 * @param i 0~4
	 * @return Y/M/D/h/m
	 */
	public int getBirthInt(int i) {
		int[] date = new int[5];
		chart_tab.getBirthDate(date);
		return date[i];
	}

	/**
	 * 
	 * @param i 0~4
	 * @return Y/M/D/h/m
	 */
	public int getNowInt(int i) {
		int[] date = new int[5];
		chart_tab.getNowDate(date);
		return date[i];
	}

	/**
	 * 農曆
	 * 
	 * @param i 0~4
	 * @return 納音年/M/D/h/m
	 */
	public int getBirthLunarInt(int i) {
		return result.lunar_date[i];
	}

	/**
	 * 農曆
	 * 
	 * @param i 0~4
	 * @return 納音年/M/D/h/m
	 */
	public int getNowLunarInt(int i) {
		return result.now_lunar_date[i];
	}

	/**
	 * 以年神煞取星
	 * 
	 * @param shin    神煞名
	 * @param use_now Optional (Default false) 為真則取流年值
	 * @return 七政四餘
	 */
	public String getYearShinStar(String shin, boolean use_now) { // 年神
		String retval = null;
		String year_info = use_now ? Moira.mri.data.getYearInfo(false, result.now_table)
				: Moira.mri.data.getYearInfo(true, result.birth_table);
		int pos = year_info.indexOf(shin);
		if (pos > 0) {
			retval = year_info.substring(pos + 3, pos + 4);
		}
		return retval;
	}

	/**
	 * {@link #getYearShinStar(String, boolean)}
	 * 
	 * @param shin
	 * @return
	 */
	public String getYearShinStar(String shin) {
		return getYearShinStar(shin, false);
	}

	/**
	 * 取地支十二宮之神煞
	 * 
	 * @param ki      地支
	 * @param use_now Optional (Default false) 為真則取流年值
	 * @return 逗號分隔之諸神煞名
	 */
	public String getKiShinNames(String ki, boolean use_now) {
		String shin_names = use_now ? shen_sha_table_n.get(ki).toString() : shen_sha_table_b.get(ki).toString();
		return shin_names.substring(1, shin_names.length() - 1).replace(" ", "");
	}

	/**
	 * {@link #getKiShinNames(String, boolean)}
	 * 
	 * @param ki
	 * @return
	 */
	public String getKiShinNames(String ki) {
		return getKiShinNames(ki, false);
	}

	/**
	 * 以星取神煞<br>
	 * 
	 * @param star     七政四餘
	 * @param selector "year" , "year_kan" , "all_ki" , "year_ki" , "month" ,
	 *                 "not_kanki"<br>
	 *                 分別代表：年神 , 年干神 , 全支神 , 年支神 , 月神 , 非干支起。其他值代表全部神煞
	 * @param use_now  Optional(Default false 取出生盤值) true則取流年值
	 * @param cut_tail Optional(default true) 會去掉最後一個逗號
	 * @return
	 * 
	 */
	public String getStarShin(String star, String selector, boolean use_now, boolean cut_tail) {
		String year_info = use_now ? Moira.mri.data.getYearInfo(false, result.now_table)
				: Moira.mri.data.getYearInfo(true, result.birth_table);
		String year_shin = ""; // 年神有干神支神
		int pos = -1;
		for (int i = 0; i < year_info.length(); i += 1) {
			pos = year_info.indexOf(star, i);
			if (pos > 0) {
				year_shin = year_shin + year_info.substring(pos - 3, pos - 1) + ",";
				i = pos + 1;
			}
		}
		if (year_shin.contains("壽元"))
			year_shin = year_shin.substring(3);
		if (year_shin.contains("天耗"))
			year_shin = year_shin.replace("天耗", "天干耗");		
		String ki_shin = "";
		for (int i = 0; i < KI_NAMES.length; i += 1) {
			if (KI_HOUSE_MASTER[i].trim().contentEquals(star.trim()))
				ki_shin = ki_shin + getKiShinNames(KI_NAMES[i], use_now) + ",";
			if (KI_HOUSE_VICE_MASTER[i].trim().contentEquals(star.trim()))
				ki_shin = ki_shin + getKiShinNames(KI_NAMES[i], use_now) + ",";
		}
		String retval = "";
		String month_shin_names = "月廉,月殺,月符,天耗,地耗,注受,斗杓,值難";
		String[] month_shin = month_shin_names.split(",");
		switch (selector) {
		case "year":
			retval = year_shin;
			break;
		case "year_kan":
			if (year_shin.contains("祿元"))
				year_shin = year_shin.replace("祿元,", "");
			if (year_shin.contains("馬元"))
				year_shin = year_shin.replace("馬元,", "");
			if (year_shin.contains("壽元"))
				year_shin = year_shin.replace("壽元,", "");
			retval = year_shin;
			break;
		case "all_ki":
			if (ki_shin.contains("斗杓"))
				ki_shin = ki_shin.replace("斗杓,", "");
			retval = ki_shin;
			break;
		case "year_ki":
			for (int i = 0; i < month_shin.length - 1; i += 1) {
				if (ki_shin.contains(month_shin[i]))
					ki_shin = ki_shin.replace(month_shin[i] + ",", "");
			}
			retval = ki_shin;
			break;
		case "month":
			for (int i = 0; i < month_shin.length - 1; i += 1) {
				if (ki_shin.contains(month_shin[i]))
					retval = retval + month_shin[i] + ",";
			}
			break;
		case "not_kanki":
			if (year_shin.contains("壽元")) // 以納音起
				retval = retval + "壽元,";
			if (ki_shin.contains("斗杓")) // 以生時起
				retval = retval + "斗杓,";
			break;
		default:
			retval = year_shin + ki_shin;
		}
		if (cut_tail && retval.length() > 0)
			retval = retval.substring(0, retval.length() - 1);
		return retval;
	}

	/**
	 * 以星取神煞<br>
	 * {@link #getStarShin}
	 */
	public String getStarShin(String star, String selector, boolean use_now) {
		return getStarShin(star, selector, use_now, true);
	}

	/**
	 * 以星取神煞<br>
	 * {@link #getStarShin}
	 */
	public String getStarShin(String star, String selector) {
		return getStarShin(star, selector, false, true);
	}

	/**
	 * 七政四餘互換
	 * 
	 * @param P7S4
	 * @return null 如果輸入"日"、"月"、"金"
	 */
	public String getP7S4Convert(String p7s4) {
		String retval = null;
		String ki_house_master = Arrays.toString(KI_HOUSE_MASTER);
		String ki_house_vice_master = Arrays.toString(KI_HOUSE_VICE_MASTER);
		if (ki_house_master.contains(p7s4)) {
			int p = ki_house_master.indexOf(p7s4);
			retval = ki_house_vice_master.substring(p, p + 1);
		} else {
			int p = ki_house_vice_master.indexOf(p7s4);
			retval = ki_house_master.substring(p, p + 1);
		}
		if (retval.contentEquals(KI_HOUSE_VICE_MASTER[4]))
			retval = null;
		return retval;
	}

	/**
	 * 以支神取星
	 * 
	 * @param shin      神煞名
	 * @param use_now   Optional (Default false) true則取流年值
	 * @param return_s4 Optional (Default false) true則同時傳回七政與四餘
	 * @return 七政四餘
	 */
	public String getKiShinStar(String shin, boolean use_now, boolean return_s4) {
		String retval = null;
		String ki_shin = null;
		for (int i = 0; i < KI_NAMES.length; i += 1) {
			ki_shin = getKiShinNames(KI_NAMES[i], use_now);
			if (ki_shin.contains(shin.trim())) {
				retval = KI_HOUSE_MASTER[i];
				break;
			}
		}
		if (return_s4) {
			if (getP7S4Convert(retval) != null)
				retval = retval + "," + getP7S4Convert(retval);
		}
		return retval;
	}

	/**
	 * {@link #getKiShinStar(String, boolean, boolean)}
	 * 
	 * @param shin
	 * @param use_now
	 * @return
	 */
	public String getKiShinStar(String shin, boolean use_now) {
		return getKiShinStar(shin, use_now, false);
	}

	/**
	 * {@link #getKiShinStar(String, boolean)}
	 * 
	 * @param shin
	 * @return
	 */
	public String getKiShinStar(String shin) {
		return getKiShinStar(shin, false);
	}

	/**
	 * 依行星位置取日期
	 * 
	 * @param planet_no  0~6 日月金木水火土 10~13計羅炁孛
	 * @param birth_data true則使用出生盤的行星位置(應是依八字尋日期的功能)。false則使用流年盤的行星位置
	 * @param degree     目的地度數，以戌宮為始逆算。月亮移動距離若小於7度，會取到下一個月的時間，必需把backward設false才能取到最近的時間。慢星往前需要數年時會取到前一年的時間。
	 * @param country
	 * @param city
	 * @param zone
	 * @param start      起始日期 birth_data為true則應傳入出生日期
	 * @param backward   TRUE則倒退以取
	 * @return
	 */
	public int[] getDateAtPlanetPos(int planet_no, boolean birth_data, double degree, String country, String city,
			String zone, int[] start, boolean backward) {
		return data.getDateAtPlanetPos(planet_no, birth_data, degree - 30, country, city, zone, start, backward);
	}

	/**
	 * {@link #getDateAtPlanetPos(int, boolean, double, String, String, String, int[], boolean)}
	 * 
	 * @param planet_no
	 * @param birth_data
	 * @param degree
	 * @param start
	 * @param backward
	 * @return
	 */
	public int[] getDateAtPlanetPos(int planet_no, boolean birth_data, double degree, int[] start, boolean backward) {
		return data.getDateAtPlanetPos(planet_no, birth_data, degree - 30, country, city, zone, start, backward);
	}

	/**
	 * 利用getDateAtPlanetPos取得下一個交度時間，此法不適用羅計，會有很大誤差。
	 * 
	 * @param planet_no 0~6:日月金木水火土 10~13:計羅炁孛
	 * @param degree    現在位置
	 * @param start     現在時間
	 * @param dest_pos  回傳目的地位置
	 * @return
	 */
	public int[] getStellarCrossOver(int planet_no, double degree, int[] start, StringBuilder dest_pos) {
		int[] retval = new int[5];
		int[] fwd = new int[5];
		int[] fwd_turnover = new int[5];
		int[] bwd = new int[5];
		int[] bwd_turnover = new int[5];
		String[] signs = result.half_stellar_signs;
		double[] sign_pos = result.stellar_sign_pos;
		int sign_idx = -1;
		int step = 1;
		int len = signs.length;
		double last_pos = sign_pos[len - 1];
		double deg_offset = 0;
		for (int i = 0; i < len; i++) {
			double val = degree;
			double pos = sign_pos[i];
			if (pos < last_pos) {
				pos += 360.0;
				if (val < last_pos)
					val += 360.0;
			}
			if (val >= last_pos && val < pos) {
				sign_idx = (i > 0) ? (i - 1) : (len - 1);
				break;
			}
			last_pos = sign_pos[i];
		}

		// System.out.println("起躔: " + data.getPlanetPos(planet_no, sign_pos[(sign_idx)
		// % 28]));
		deg_offset = 0;
		if (planet_no >= 10 && planet_no <= 11) {
			step = 0; // 羅計方向不同
			deg_offset = -0.00005; // 突出下一宿度 -0.00005約加3分鐘。但是依行星位置取時間原本的程式就不完美，羅計會有一些誤差，無法精確得到跨度的時間。
		}

		// 宿度順數(逆時針)取一次
		if (planet_no == 1) {
			fwd = getDateAtPlanetPos(planet_no, false, sign_pos[(sign_idx - 2 + 28) % 28], start, true); // 月亮，差距7度以上才能正確取到下一個交界時間。故先移動兩個宿度
			fwd = getDateAtPlanetPos(planet_no, false, sign_pos[(sign_idx + step) % 28], fwd, false);
		} else {
			fwd = getDateAtPlanetPos(planet_no, false, (sign_pos[(sign_idx + step) % 28] + 360 + deg_offset) % 360,
					start, false);
		}
		fwd_turnover = getDateAtPlanetPos(planet_no, false, (sign_pos[(sign_idx + step) % 28] + 360 + deg_offset) % 360,
				fwd, true); // 接近交界時順取會錯過最近的時間，所以要回頭再取一次
		String dest = data.getPlanetPos(planet_no, (sign_pos[(sign_idx + step) % 28] + 360 + deg_offset) % 360);
		String dest_mansion = result.half_stellar_signs[(sign_idx + step) % 28];
		String fwd_dest = "順交" + dest_mansion + ">>" + dest;
		if (fwd_dest.contains("?") || !dest_mansion.contentEquals(dest.substring(5, 6))) // 處理偶發異常度數
			fwd_dest = "順交" + dest_mansion + ">>" + data.getPlanetPos(planet_no,
					(sign_pos[(sign_idx + step) % 28] + 360 + deg_offset + 0.0001) % 360);
		String bwd_dest = "";
		// Log.c("fwd : " + Arrays.toString(fwd));
		// Log.c("fwd_turnover: " + Arrays.toString(fwd_turnover));
		// System.out.println(fwd_dest);

		retval = getNearestTimeArray(start, fwd, fwd_turnover); // 回傳最接近的時間
		// 會逆行的星要宿度逆數(順時針)再取一次
		if (planet_no >= 2 && planet_no <= 6) {
			bwd = getDateAtPlanetPos(planet_no, false, sign_pos[(sign_idx) % 28], start, true);
			bwd_turnover = getDateAtPlanetPos(planet_no, false, sign_pos[(sign_idx) % 28], bwd, false);
			String dest_b = data.getPlanetPos(planet_no, sign_pos[(sign_idx - step + 28) % 28]);
			String dest_mansion_b = result.half_stellar_signs[(sign_idx - step + 28) % 28];

			bwd_dest = "逆交" + dest_mansion_b + ">>" + dest;
			if (bwd_dest.contains("?") || !dest_mansion_b.contentEquals(dest_b.substring(5, 6))) // 處理偶發異常度數
				bwd_dest = "逆交" + dest_mansion_b + ">>"
						+ data.getPlanetPos(planet_no, sign_pos[(sign_idx - step + 28) % 28] - 0.0001);
			// Log.c("bwd : " + Arrays.toString(bwd));
			// Log.c("bwd_turnover: " + Arrays.toString(bwd_turnover));
			// System.out.println(bwd_dest);
			retval = getNearestTimeArray(start, fwd, fwd_turnover, bwd, bwd_turnover); // 回傳最接近的時間
		}
		if (retval.equals(fwd) || retval.equals(fwd_turnover))
			dest_pos.append(fwd_dest);
		if (retval.equals(bwd) || retval.equals(bwd_turnover))
			dest_pos.append(bwd_dest);
		return retval;
	}

	/**
	 * {@link #getStellarCrossOver(int, double, int[])}
	 * 
	 * @param planet_no
	 * @param degree
	 * @param start
	 * @return
	 */
	public int[] getStellarCrossOver(int planet_no, double degree, int[] start) {
		return getStellarCrossOver(planet_no, degree, start, new StringBuilder());
	}

	/**
	 * Compare DateTime
	 * 
	 * @param dt1 int[5]
	 * @param dt2 int[5]
	 * @return =0: dt1 = dt2, <0: dt1 < dt2, >0: dt1 > dt2.
	 */
	static public int compareTimeArray(int[] dt1, int[] dt2) {
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.set(dt1[0], dt1[1] - 1, dt1[2], dt1[3], dt1[4]); // Jan = 0
		cal2.set(dt2[0], dt2[1] - 1, dt2[2], dt2[3], dt2[4]);
		return cal1.compareTo(cal2);
	}

	/**
	 * 回傳最接近base且晚於base的時間。
	 * 
	 * @param base 以int[5]表示 年月日時分秒
	 * @param dt1  以int[5]表示 年月日時分秒
	 * @param dt2  以int[5]表示 年月日時分秒
	 * @return
	 */
	static public int[] getNearestTimeArray(int[] base, int[] dt1, int[] dt2) {
		if (dt1 == null || dt2 == null) {
			base[1] = base[1] * -1;
			return base;
		}
		Calendar cal_base = Calendar.getInstance();
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal_base.set(base[0], base[1], base[2], base[3], base[4]);
		cal1.set(dt1[0], dt1[1] - 1, dt1[2], dt1[3], dt1[4]);
		cal2.set(dt2[0], dt2[1] - 1, dt2[2], dt2[3], dt2[4]);

		long t0 = cal_base.getTimeInMillis();
		long d1 = Math.abs(cal1.getTimeInMillis() - t0);
		long d2 = Math.abs(cal2.getTimeInMillis() - t0);

		return (d1 < d2) ? dt1 : dt2;
	}

	/**
	 * 回傳最接近base且晚於base的時間。
	 * 
	 * @param base int[0~4]:年月日時分
	 * @param dt1
	 * @param dt2
	 * @param dt3
	 * @param dt4
	 * @return
	 */
	static public int[] getNearestTimeArray(int[] base, int[] dt1, int[] dt2, int[] dt3, int[] dt4) {
		if (dt1 == null || dt2 == null || dt3 == null || dt4 == null) {
			base[1] = base[1] * -1;
			return base;
		}
		Calendar cal_base = Calendar.getInstance();
		Calendar cal[] = new Calendar[4];
		for (int i = 0; i < 4; i += 1) {
			cal[i] = Calendar.getInstance();
		}
		cal_base.set(base[0], base[1] - 1, base[2], base[3], base[4]);
		cal[0].set(dt1[0], dt1[1] - 1, dt1[2], dt1[3], dt1[4]);
		cal[1].set(dt2[0], dt2[1] - 1, dt2[2], dt2[3], dt2[4]);
		cal[2].set(dt3[0], dt3[1] - 1, dt3[2], dt3[3], dt3[4]);
		cal[3].set(dt4[0], dt4[1] - 1, dt4[2], dt4[3], dt4[4]);
		long d = 0;
		long d_min = Long.MAX_VALUE;
		int i_min = 0;
		long t0 = cal_base.getTimeInMillis();
		for (int i = 0; i < 4; i += 1) {
			d = cal[i].getTimeInMillis() - t0;
			if (d > 0 && d < d_min) {
				d_min = d;
				i_min = i;
			}
		}
		switch (i_min) {
		case 0:
			return dt1;
		case 1:
			return dt2;
		case 2:
			return dt3;
		case 3:
			return dt4;
		}
		return null;
	}

	/**
	 * 利用getDateAtPlanetPos取得下一個交宮時間，此法不適用羅計，會有很大誤差。
	 * 
	 * @param planet_no 0~6:日月金木水火土 10~13:計羅炁孛
	 * @param degree    現在位置
	 * @param start     現在時間
	 * @param dest_pos  回傳目的地位置
	 * @return
	 */
	public int[] getHouseCrossOver(int planet_no, double degree, int[] start, StringBuilder dest_pos) {
		int[] retval = new int[5];
		int[] fwd = new int[5];
		int[] fwd_turnover = new int[5];
		int[] bwd = new int[5];
		int[] bwd_turnover = new int[5];
		int house_idx = -1;
		int step = 1;
		int len = HOUSES12.length;
		double last_pos = HOUSES12_POS[len - 1];
		double deg_offset = 0;
		for (int i = 0; i < len; i++) {
			double val = degree;
			double pos = HOUSES12_POS[i];
			if (pos < last_pos) {
				pos += 360.0;
				if (val < last_pos)
					val += 360.0;
			}
			if (val >= last_pos && val < pos) {
				house_idx = (i > 0) ? (i - 1) : (len - 1);
				break;
			}
			last_pos = HOUSES12_POS[i];
		}

		// System.out.println("居 宮: " + data.getPlanetPos(planet_no,
		// HOUSES12_POS[(house_idx) % 12]));

		if (planet_no >= 10 && planet_no <= 11) {
			step = 0; // 羅計方向不同
			deg_offset = -0.00005; // 突出下一宿度 -0.00005約加3分鐘。但是依行星位置取時間原本的程式就不完美，羅計會有一些誤差，無法精確得到跨度的時間。
		}

		// 宿度順數(逆時針)取一次
		if (planet_no == 1) {
			fwd = getDateAtPlanetPos(planet_no, false, HOUSES12_POS[(house_idx - 1 + 12) % 12], start, true); // 月亮，差距7度以上才能正確取到下一個交界時間。故先移動兩個宿度
			fwd = getDateAtPlanetPos(planet_no, false, HOUSES12_POS[(house_idx + step) % 12], fwd, false);
		} else {
			fwd = getDateAtPlanetPos(planet_no, false, (HOUSES12_POS[(house_idx + step) % 12] + 360 + deg_offset) % 360,
					start, false); // 羅計計算不穩定，時常會有問題，回傳null，原因不明。
		}
		fwd_turnover = getDateAtPlanetPos(planet_no, false,
				(HOUSES12_POS[(house_idx + step) % 12] + 360 + deg_offset) % 360, fwd, true); // 接近交界時順取會錯過最近的時間，所以要回頭再取一次
		String dest = data.getPlanetPos(planet_no, (HOUSES12_POS[(house_idx + step) % 12] + 360 + deg_offset) % 360);
		String dest_house = HOUSES12[(house_idx + step) % 12];
		String fwd_dest = "順交" + dest + ">>" + dest_house;
		if (fwd_dest.contains("?") || !dest_house.contentEquals(dest.substring(5, 6))) // 處理偶發異常度數
			fwd_dest = "順交" + HOUSES12[(house_idx + step) % 12] + ">>"
					+ data.getPlanetPos(planet_no, (HOUSES12_POS[(house_idx + step) % 12] + 360 + deg_offset) % 360);
		String bwd_dest = "";
		// Log.c("fwd : " + Arrays.toString(fwd));
		// Log.c("fwd_turnover: " + Arrays.toString(fwd_turnover));
		// System.out.println(fwd_dest);
		retval = getNearestTimeArray(start, fwd, fwd_turnover); // 回傳最接近的時間
		// 會逆行的星要宿度逆數(順時針)再取一次
		if (planet_no >= 2 && planet_no <= 6) {
			bwd = getDateAtPlanetPos(planet_no, false, HOUSES12_POS[(house_idx) % 12], start, true);
			bwd_turnover = getDateAtPlanetPos(planet_no, false, HOUSES12_POS[(house_idx) % 12], bwd, false);
			String dest_b = data.getPlanetPos(planet_no, HOUSES12_POS[(house_idx - step + 12) % 12]);
			String dest_house_b = HOUSES12[(house_idx - step + 12) % 12];
			bwd_dest = "逆交" + dest_house_b + ">>" + dest_b;
			if (bwd_dest.contains("?") || !dest_house_b.contentEquals(dest_b.substring(5, 6))) // 處理偶發異常度數
				bwd_dest = "逆交" + dest_house_b + ">>" + data.getPlanetPos(planet_no,
						(HOUSES12_POS[(house_idx - step + 12) % 12] + 360 - 0.0001) % 360);
			// Log.c("bwd : " + Arrays.toString(bwd));
			// Log.c("bwd_turnover: " + Arrays.toString(bwd_turnover));
			// System.out.println(bwd_dest);
			retval = getNearestTimeArray(start, fwd, fwd_turnover, bwd, bwd_turnover); // 回傳最接近的時間
		}
		if (retval.equals(fwd) || retval.equals(fwd_turnover))
			dest_pos.append(fwd_dest);
		if (retval.equals(bwd) || retval.equals(bwd_turnover))
			dest_pos.append(bwd_dest);
		return retval;
	}

	/**
	 * {@link #getHouseCrossOver(int, double, int[])}
	 * 
	 * @param planet_no 0~6:日月金木水火土 10~13:計羅炁孛
	 * @param degree
	 * @param start
	 * @return
	 */
	public int[] getHouseCrossOver(int planet_no, double degree, int[] start) {
		return getHouseCrossOver(planet_no, degree, start, new StringBuilder());
	}

	/**
	 * 以datetime的內容設定cal的時間
	 * 
	 * @param cal
	 * @param datetime
	 */
	static public void setCalendar(Calendar cal, int[] datetime) {
		cal.set(datetime[0], datetime[1] - 1, datetime[2], datetime[3], datetime[4]);
	}

	/**
	 * 把cal的時間寫進datetime
	 * 
	 * @param cal
	 * @param datetime
	 */
	static public void getCalendar(Calendar cal, int[] datetime) {
		datetime[0] = cal.get(Calendar.YEAR);
		datetime[1] = cal.get(Calendar.MONTH) + 1; // Jan = 0
		datetime[2] = cal.get(Calendar.DAY_OF_MONTH);
		datetime[3] = cal.get(Calendar.HOUR_OF_DAY);
		datetime[4] = cal.get(Calendar.MINUTE);
	}

	/**
	 * 在一個區間內尋找下一個交宮或交度的時間
	 * 
	 * @param planet_no    0~6:日月金木水火土 10~13:計羅炁孛
	 * @param start        開始時間
	 * @param end          結束時間
	 * @param span_minutes 搜尋間隔
	 * @param use_mansion  為True則搜尋交度的時間。
	 * @param dest_pos     搜尋到的度數。其格式為 00角木00 00辰金00
	 * @return
	 */
	private static int[] searchCrossOver(int planet_no, int[] start, int[] end, int span_minutes, boolean use_mansion,
			StringBuilder dest_pos) {
		if (dest_pos.length() > 0)
			dest_pos.delete(0, dest_pos.length());
		int[] d = new int[5];
		String stay = null;
		String prev_stay = null;
		Calendar cal_start = Calendar.getInstance();
		Calendar cal_end = Calendar.getInstance();
		setCalendar(cal_start, start);
		setCalendar(cal_end, end);
		long diff = cal_end.getTimeInMillis() - cal_start.getTimeInMillis();
		int steps = (int) Math.ceil(diff / 60000 / span_minutes);
		for (int i = 0; i < steps; i += 1) {
			getCalendar(cal_start, d);
			Moira.mri.setNowTime(d);
			Moira.run();
			String pos = Moira.mri.data.getPlanetPos(planet_no, Moira.mri.result.now_sign_pos[planet_no]);
			if (use_mansion) {
				stay = pos.substring(5, 6);
			} else {
				stay = pos.substring(13, 14);
			}
			// Log.c(Arrays.toString(d));
			// Log.c(stay);
			if (prev_stay != null && !stay.contentEquals(prev_stay)) {
				dest_pos.append(pos);
				// Log.c(pos);
				return d;
			}
			cal_start.add(Calendar.MINUTE, span_minutes);
			prev_stay = stay;
		}
		return null;
	}

	/**
	 * 取得下一個交界的時間。同時搜尋交宮與交度，傳回最接近者。必需在Moira.dispose之後才能使用。
	 * 
	 * @param planet_no 0~6:日月金木水火土 10~13:計羅炁孛
	 * @param start     開始時間
	 * @param pos       pos[0]開始度數 pos[1]交界度數 範例 "順交申: 計: 08井木12 29申水60"
	 * @param country
	 * @param city
	 * @param zone
	 * @return
	 */
	static public int[] getCrossOver(int planet_no, int[] start, String[] pos, String country, String city,
			String zone) {
		StringBuilder mansion_dest = new StringBuilder();
		StringBuilder house_dest = new StringBuilder();
		int[] retval = new int[5];
		int[] mansion = new int[5];
		int[] house = new int[5];
		int[] end = new int[5];
		int[] birth = {1984,2,10,9,0};
		int[] now = {1984,2,10,9,0};
		String country_bak = "台灣";
		String city_bak = "台南";
		String zone_bak = "Asia/Taipei";		
		try {
			country_bak = Moira.mri.country;
			city_bak = Moira.mri.city;
			zone_bak = Moira.mri.zone;
			Moira.mri.getBirthDate(birth);
			Moira.mri.getNowDate(now);			
		} catch (Exception e) {
		
		}
		Calendar cal_start = Calendar.getInstance();
		Calendar cal_end = Calendar.getInstance();
		Moira.mri.setBirthTime(birth);
		Moira.mri.setNowTime(start);
		Moira.init();
		Moira.mri.setLocation(country, city, zone);
		Moira.run();
		pos[0] = Moira.mri.data.getPlanetPos(planet_no, Moira.mri.result.now_sign_pos[planet_no]);
		switch (planet_no) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 12:
		case 13:
			mansion = Moira.mri.getStellarCrossOver(planet_no, Moira.mri.result.now_sign_pos[planet_no], start,
					mansion_dest);
			house = Moira.mri.getHouseCrossOver(planet_no, Moira.mri.result.now_sign_pos[planet_no], start, house_dest);
			if (MRI.compareTimeArray(mansion, house) < 0) {
				retval = mansion;
				pos[1] = mansion_dest.substring(0);
			} else {
				retval = house;
				pos[1] = house_dest.substring(0);
			}
			break;
		case 10:
		case 11:
			setCalendar(cal_end, start);
			cal_end.add(Calendar.YEAR, 2); // 羅計18個月行1宮
			getCalendar(cal_end, end);
			mansion = searchCrossOver(planet_no, start, end, 43200, true, mansion_dest); // 43200是1個月
			house = searchCrossOver(planet_no, start, end, 43200, false, house_dest); // 43200是1個月
			// 以找到的日期倒退1個月為新的start
			setCalendar(cal_start, mansion);
			cal_start.add(Calendar.MONTH, -1);
			getCalendar(cal_start, start);
			mansion = searchCrossOver(planet_no, start, end, 1440, true, mansion_dest); // 1440是1天
			// 以找到的日期倒退1天為新的start
			setCalendar(cal_start, mansion);
			cal_start.add(Calendar.DAY_OF_MONTH, -1);
			getCalendar(cal_start, start);
			mansion = searchCrossOver(planet_no, start, end, 60, true, mansion_dest); // 以60分精度為最終結果
			// house步驟相同
			// 以找到的日期倒退1個月為新的start
			setCalendar(cal_start, house);
			cal_start.add(Calendar.MONTH, -1);
			getCalendar(cal_start, start);
			house = searchCrossOver(planet_no, start, end, 1440, false, house_dest); // 1440是1天
			// 以找到的日期倒退1天為新的start
			setCalendar(cal_start, house);
			cal_start.add(Calendar.DAY_OF_MONTH, -1);
			getCalendar(cal_start, start);
			house = searchCrossOver(planet_no, start, end, 60, false, house_dest); // 以60分精度為最終結果
			if (MRI.compareTimeArray(mansion, house) < 0) {
				retval = mansion;
				pos[1] = "順交" + mansion_dest.substring(5, 6) + ": " + mansion_dest.substring(0);
			} else {
				retval = house;
				pos[1] = "順交" + mansion_dest.substring(13, 14) + ": " + house_dest.substring(0);
			}
			break;
		default:
		}
		Moira.mri.setLocation(country_bak, city_bak, zone_bak);
		Moira.mri.setBirthTime(birth);
		Moira.mri.setNowTime(now);
		Moira.run();
		Moira.disposeMoira();
		return retval;
	}

	/**
	 * 回傳行星名稱
	 * 
	 * @param planet_no
	 * @return
	 */
	static public String getPlanetName(int planet_no) {
		return PLANET_NAMES[planet_no];
	}

	/**
	 * 取得行星位置，以戌宮為始的黃道360度位置
	 * 
	 * @param planet_no
	 * @param use_now   [OPTIONAL] TRUE則傳回流年行星。Default FALSE
	 * @return
	 */
	public double getPlanetPos(int planet_no, boolean use_now) {
		double retval = (use_now) ? result.now_sign_pos[planet_no] : result.birth_sign_pos[planet_no];
		return retval;
	}

	/**
	 * {@link #getPlanetPos(int, boolean)}
	 * 
	 * @param planet_no
	 * @return
	 */
	public double getPlanetPos(int planet_no) {
		return getPlanetPos(planet_no, false);
	}

	/**
	 * 取得行星位置，例 計: 08井木12 29申水60
	 * 
	 * @param planet_no
	 * @param use_now   [OPTIONAL] TRUE則傳回流年行星。Default FALSE
	 * @return
	 */
	public String getPlanetPosString(int planet_no, boolean use_now) {
		double pos = (use_now) ? result.now_sign_pos[planet_no] : result.birth_sign_pos[planet_no];
		return data.getPlanetPos(planet_no, pos);
	}

	/**
	 * {@link #getPlanetPos(int, boolean)}
	 * 
	 * @param planet_no
	 * @return
	 */
	public String getPlanetPosString(int planet_no) {
		return getPlanetPosString(planet_no, false);
	}

	/**
	 * 取得行星遲留伏逆狀態。 順 = 0; 退 = 1;蝕 = 2;留 = 3; 伏 = 4;遲 = 5;速 = 6;
	 * 
	 * @param planet_no
	 * @param use_now   [OPTIONAL] TRUE則傳回流年行星。Default FALSE
	 * @return
	 */
	public int getPlanetState(int planet_no, boolean use_now) {
		int retval = (use_now) ? result.now_sign_state[planet_no] : result.birth_sign_state[planet_no];
		return retval;
	}

	/**
	 * {@link #getPlanetState(int, boolean)}
	 * 
	 * @param planet_no
	 * @return
	 */
	public int getPlanetState(int planet_no) {
		return getPlanetState(planet_no, false);
	}

	/**
	 * 將行星狀態轉換成字串「遲留伏逆」
	 * 
	 * @param state
	 * @return
	 */
	static public String getStateString(int state) {
		switch (state) {
		case SPEED_NORMAL:
			return "";
		case SPEED_REVERSE:
			return "逆";
		case SPEED_ECLIPSE:
			return "蝕";
		case SPEED_STATIONARY:
			return "留";
		case SPEED_INVISIBLE:
			return "伏";
		case SPEED_SLOW:
			return "遲";
		case SPEED_FAST:
			return "速";
		}
		return null;
	}

	/**
	 * 取得殿垣廟樂狀態
	 * 
	 * @param planet_no
	 * @param use_now   [OPTIONAL] TRUE則傳回流年行星。Default FALSE
	 * @return
	 */
	public String getPlanetStatus(int planet_no, boolean use_now) {
		String retval = (use_now) ? result.now_sign_status[planet_no] : result.birth_sign_status[planet_no];
		return retval;
	}

	/**
	 * {@link #getPlanetStatus(int, boolean)}
	 * 
	 * @param planet_no
	 * @return
	 */
	public String getPlanetStatus(int planet_no) {
		return getPlanetStatus(planet_no, false);
	}

	/**
	 * 傳回出生盤日期西曆年當年24節氣時間，以一頁四欄共七列的方式呈現。
	 * 
	 * @param full 為TRUE則從前一個冬至到下一個小寒之間的24節氣時間。為FALSE則從前一個小寒到下一個冬至之間的24節氣時間。
	 * @return
	 */
	public String getSolarTermsPage(boolean full) {
		DecimalFormat format = new DecimalFormat("00");
		int[] date = new int[5];
		int s = full ? 0 : 1;
		int e = full ? result.solar_terms.length : 25;
		StringBuilder tab = new StringBuilder();
		for (int i = s; i < e; i++) {
			Calculate.getDateFromJulianDayUT(result.solar_terms[i], date);
			tab.append(result.season_starts[(i + 23) % 24] + ": " + format.format(date[1]) + "/"
					+ format.format(date[2]) + " " + BaseCalendar.formatDate(0.0, date, null, 0.0, false, true));
			if (((i - s) % 4) == 3)
				tab.append("\n");
			else
				tab.append("  ");
		}
		if (((e - s) % 4) != 0)
			tab.append("\n");
		return tab.toString();
	}

	/**
	 * 傳回出生盤日期西曆年當年24節氣時間。
	 * 
	 * @param full 為TRUE則從前一個冬至到下一個小寒之間的24節氣時間。為FALSE則從前一個小寒到下一個冬至之間的24節氣時間。
	 * @return 傳回int[26][5]。為TRUE則26列皆有意義。為FALSE則僅前24列有意義
	 */
	public int[][] getSolarTermsInt(boolean full) {
		int[] date = new int[5];
		int[][] retval = new int[26][5];
		int s = full ? 0 : 1;
		int e = full ? result.solar_terms.length : 25;
		for (int i = s; i < e; i++) {
			Calculate.getDateFromJulianDayUT(result.solar_terms[i], date);
			int r = (full) ? i : i - 1;
			for (int j = 0; j < 5; j += 1) {
				retval[r][j] = date[j];
			}
		}
		return retval;
	}

	/**
	 * 回傳各宮所管限度長短。第一數值為命宮所管年數，次為相貌宮，順次推去。以Scope表「限」之意
	 * 
	 * @return
	 */
	public double[] getFortuneScopes() {
		return result.limit_seq;
	}

	/**
	 * 取回當年行限黃道360度位置
	 * 
	 * @return
	 */
	public double[] getNowYearPos() {
		return result.nowYearPosition;
	}

	/**
	 * 回傳當年行限度數。例[16斗木24 12丑土42, 14斗木24 10丑土42]。行限與宿度相逆，故前例為 起12丑土42，至10丑土42。
	 * 
	 * @return
	 */
	public String[] getNowYearPosString() {
		String[] retval = new String[2];
		double[] pos = result.nowYearPosition;
		retval[0] = data.getPlanetPos(0, pos[0]).substring(3);
		retval[1] = data.getPlanetPos(0, pos[1]).substring(3);
		return retval;
	}

	/**
	 * 傳回四柱八字
	 * 
	 * @param use_now [OPTIONAL] TRUE則傳回流年八字。Default FALSE
	 * @return {年柱、月柱、日柱、時柱}
	 */
	public String[] getEightWords(boolean use_now) {
		String retval[] = new String[4];
		for (int i = 0; i < 4; i += 1) {
			retval[i] = (use_now) ? result.now_poles[i + 2] : result.birth_poles[i + 2];
		}
		return retval;
	}

	/**
	 * {@link #getEightWords(boolean)}
	 * 
	 * @return
	 */
	public String[] getEightWords() {
		return getEightWords(false);
	}

	/**
	 * 傳回子平虛支 [?,?,年，月，日，時]
	 * 
	 * @return 例：[null, null, 丑, 亥, 巳, 酉]
	 */
	public String[] getWeakHouse() {
		return result.weak_house;
	}

	/**
	 * 傳回子平實支 [?,?,年，月，日，時]
	 * 
	 * @return 例：[null, null, 未, 巳, 未, 丑]
	 */
	public String[] getSolidHouse() {
		return result.solid_house;
	}

	/**
	 * 傳回童限
	 * 
	 * @param round_to_year True則傳回年數、False則傳回日數
	 * @return
	 */
	public int getChildLimit(boolean round_to_year) {
		return data.getChildLimit(round_to_year);
	}

	/**
	 * 傳回童限
	 * 
	 * @param cur_age
	 * @param sep
	 * @return 例：童限,戌
	 */
	public String getChildLimit(int cur_age, String sep) {
		return data.getChildLimit(cur_age, sep);
	}

	/**
	 * 傳回小限
	 * 
	 * @param cur_age
	 * @param sep
	 * @return 例：小限,巳
	 */
	public String getSmallLimit(int cur_age, String sep) {
		return data.getSmallLimit(cur_age, sep);
	}

	/**
	 * 傳回月限
	 * 
	 * @param cur_age
	 * @param sep
	 * @return 例：月限,未
	 */
	public String getMonthLimit(int cur_age, String sep) {
		return data.getMonthLimit(cur_age, sep);
	}

	/**
	 * 傳回飛限
	 * 
	 * @param cur_age
	 * @param sep
	 * @param child_age_limit
	 * @return 飛限,未
	 */
	public String getFlyLimit(int cur_age, String sep, int child_age_limit) {
		return data.getFlyLimit(cur_age, sep, child_age_limit);
	}

	/**
	 * 傳回命宮
	 * 
	 * @return
	 */
	public String getHouse() {
		return data.getHouse();
	}

	/**
	 * 生於日時TRUE、夜時FALSE
	 * 
	 * @return
	 */
	public boolean getDayOrNight() {
		return data.getDayOrNight();
	}

	/**
	 * 傳回日出與月出之真太陽時間
	 * 
	 * @return [日出,月出] 例：[05:18AM, 07:10AM]
	 */
	public String[] getBirthRiseTime() {
		return Moira.mri.result.birth_rise_time;
	}

	/**
	 * 傳回日落與月落之真太陽時間
	 * 
	 * @return [日落,月落] 例：[06:42PM, 08:42PM]
	 */
	public String[] getBirthSetTime() {
		return Moira.mri.result.birth_set_time;
	}

	/**
	 * 取得流年當下年紀
	 * 
	 * @return
	 */
	public int getCurrentAge() {
		return result.current_age;
	}

	/**
	 * 取得有限數量的政餘喜格
	 * 
	 * @return
	 */
	public String getGoodPattern() {
		return result.good_pattern;
	}

	/**
	 * 取得有限數量的政餘忌格
	 * 
	 * @return
	 */
	public String getBadPattern() {
		return result.bad_pattern;
	}

	/**
	 * 取得28宿名，不含七政名
	 * 
	 * @return
	 */
	public String[] getHalfStellarSigns() {
		return result.half_stellar_signs;
	}

	/**
	 * 取得28宿名，含七政名
	 * 
	 * @return
	 */
	public String[] getStellarSigns() {
		return result.full_stellar_signs;
	}

	/**
	 * 取得國名列表。必需先執行Moira.init()
	 * 
	 * @return
	 */
	public String[] getCountryList() {
		return City.getCountryList();
	}

	/**
	 * 取得城巿列表。必需先執行Moira.init()
	 * 
	 * @param country
	 * @return
	 */
	public String[] getCityList(String country) {
		return City.getCityList(country);
	}

	/**
	 * 取得時區列表。必需先執行Moira.init()
	 * 
	 * @return
	 */
	public String[] getZoneList() {
		return City.getAllZoneNames();
	}
}

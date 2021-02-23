package csharp.moira;

import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.LinkedList;

import org.athomeprojects.base.BaseTab;
import org.athomeprojects.base.Calculate;
import org.athomeprojects.base.DataEntry;
import org.athomeprojects.base.DiagramTip;
import org.athomeprojects.base.Position;
import org.athomeprojects.base.SearchRecord;
import org.athomeprojects.swisseph.SweConst;

public class PublicChartData {
	//copy ChartData Private Properties
    public final int SUN = 0;

    public final int MOON = 1;

    public final int VENUS = 2;

    public final int JUPITER = 3;

    public final int MERCURY = 4;

    public final int MARS = 5;

    public final int SATURN = 6;

    public final int URANUS = 7;

    public final int NEPTUNE = 8;

    public final int PLUTO = 9;

    public final int TRUE_NODE = 10;

    public final int INV_TRUE_NODE = 11; // opposite of TRUE_NODE

    public final int PURPLE = 12;

    public final int MEAN_APOG = 13;

    public final int FORTUNE = 14;

    public final int ASC = 15;

    public final int MC = 16;

    public final int CHIRON = 17;

    public final int CERES = 18;

    public final int PALLAS = 19;

    public final int JUNO = 20;

    public final int VESTA = 21;

    public final int FIXSTAR_OFFSET = 10000;

    public final int CONSTELLATION_MAIN_OFFSET = 20000;

    public final int CONSTELLATION_SUB_OFFSET = 20100;

    public int[] planets = { SweConst.SE_SUN, SweConst.SE_MOON,
            SweConst.SE_VENUS, SweConst.SE_JUPITER, SweConst.SE_MERCURY,
            SweConst.SE_MARS, SweConst.SE_SATURN, SweConst.SE_URANUS,
            SweConst.SE_NEPTUNE, SweConst.SE_PLUTO, SweConst.SE_TRUE_NODE, -1,
            -1, SweConst.SE_MEAN_APOG, Calculate.SE_FORTUNE, Calculate.SE_ASC,
            Calculate.SE_MC, SweConst.SE_CHIRON, SweConst.SE_CERES,
            SweConst.SE_PALLAS, SweConst.SE_JUNO, SweConst.SE_VESTA };

    public final int CH_YEAR = 0;

    public final int CH_MONTH = 1;

    public final int YEAR_POLE = 2;

    public final int MONTH_POLE = 3;

    public final int DAY_POLE = 4;

    public final int HOUR_POLE = 5;

    public final int POLE_OVERRIDE_OFFSET = 100;

    public final int MAX_TIP_COUNT = 24;

    public final int MAX_DATA_COUNT = 48;

    public final double DEGREE = 2.0 * Math.PI / 360.0;

    public final double MIN_ADVANCE = 1.0 / (10.0 * 365.25);

    public final double MAX_ADVANCE = 10.0 / 365.25;

    public final double TINY_DEGREE = 1.0e-5;

    public final double MILLISECOND_PER_YEAR = 365.25 * 24.0 * 60.0 * 60.0
            * 1000.0;

    public final double HORIZ_ZOOM = 20.0;

    public final double HORIZ_ZOOM_GAP = 1.0;

    public final int NUM_ROW_THRESHOLD = 17;

    public Calculate cal;

    public DiagramTip tip;

    public double[] solar_terms, new_moons;

    public SearchRecord solar_eclipse, lunar_eclipse;

    public int[] lunar_date, now_lunar_date, solar_date;

    public boolean lunar_leap_month, now_lunar_leap_month, has_pos_adj;

    public boolean day_birth, day_birth_override, has_day_birth_override,
            true_north, quick_azimuth, ten_god_mode, last_year_birth;

    public int wife_pos, mountain_mode, current_age, explain_length;

    public int[] draw_size = new int[3];

    public String[] wife_signs = new String[12];

    public String[] twelve_signs = new String[12];

    public String[] full_twelve_signs = new String[12];

    public String[] now_year_seq = new String[12];

    public String[] year_star_seq = new String[10];

    public int[] year_star_map = new int[10];

    public int[] year_star_range = new int[2];

    public String lunar_calendar, explain, explain_fixstar, explain_prefix,
            explain_suffix, azimuth_speed;

    public String birth_zone, year_char, month_char, day_char, hour_char;

    public String birth_year_info, current_year_info, pick_year_info;

    public String alt_birth_year_info, alt_current_year_info,
            alt_pick_year_info;

    public int[] eight_char_override;

    public String invalid_sign, birth_sign_status_fill;

    public String[] year_names = new String[60];

    public String[] sky_pole_names = new String[10];

    public String[] ten_god_seq1 = new String[10];

    public String[] ten_god_seq2 = new String[10];

    public int[] day_pole_long_life_seq = new int[10];

    public String[] earth_pole_names = new String[12];

    public String[] long_life_signs = new String[12];

    public String[] earth_god_seq = new String[12];

    public String[] star_equ_map;

    public int[] month_sky_pole_shifts = new int[10];

    public int month_earth_pole_shift;

    public int[] day_pole_base = new int[5];

    public int[] hour_sky_pole_shifts = new int[10];

    public int hour_earth_pole_shift;

    public String[] season_starts = new String[24];

    public String[] year_signs = new String[12], cusps_name = new String[12],
            house_name = new String[12];

    public String[] year_data = new String[20];

    public String[] alt_year_data = new String[20];

    public double[] limit_seq = new double[12];

    public double[] birth_cusp = new double[13], now_cusp = new double[13];

    public double[] birth_cusp_override;

    public double[] aspects_degree, aspects_orb;

    public int[] birth_speed_color, now_speed_color, now_state_color;

    public int[] aspects_color, aspects_style;

    public String[] aspects_sign;

    public int[][] aspects_index;

    public int num_asteroids;

    public String[] signs;

    public String[] sign_prefix;

    public String[] power_key, power_index;

    public String[] alt_pole_data;

    public int alt_pole_data_offset;

    public int[] sign_computation_type;

    public int[] sign_opposite;

    public int[] sign_display, aspects_display;

    public int[] sign_display_orders;

    public int[] birth_sign_display_sort_orders;

    public int[] now_sign_display_sort_orders;

    public double[] birth_sign_pos, sign_pos_shift;

    public double[] gauquelin_sign_region, gauquelin_sign_pos;

    public double[] birth_sign_azimuth, birth_sign_alt, birth_sign_diameter;

    public boolean[] sign_rev_flip, sign_lock;

    public int[] birth_sign_state;

    public String[] birth_sign_status;

    public String[] birth_rise_time = new String[2];

    public String[] birth_set_time = new String[2];

    public boolean[] equator_rise_set = new boolean[2];

    public double[] now_sign_pos;

    public double[] now_sign_azimuth, now_sign_alt;

    public int[] now_sign_state;

    public String[] now_sign_status;

    public String[] full_zodiac = new String[12];

    public String[] chinese_zodiac_signs = new String[12];

    public String[] full_stellar_signs = new String[28];

    public String[] half_stellar_signs = new String[28];

    public String[] mountain_signs = new String[24];

    public String[] full_mountain_main_signs = new String[24];

    public String[] full_mountain_secondary_signs = new String[24];

    public String[] full_mountain_signs, fixstar_signs, fixstar_names;

    public int[] child_seq, fly_seq_ying1, fly_seq_yang1, fly_seq_ying2,
            fly_seq_yang2, fly_seq_half_shift;

    public String[] stellar_names = new String[28];	//28хо┐

    public String[] sidereal_stellar_names = new String[28];

    public String[] compass_stellar_names = new String[28];

    public double[] stellar_sign_pos = new double[28];

    public double[] compass_sign_pos = new double[28];

    public double[] fixstar_sign_pos, fixstar_sign_azimuth, fixstar_sign_alt;

    public int[] fixstar_sign_state;

    public double life_sign_pos, self_sign_pos, first_cusp_pos,
            tenth_cusp_pos, mountain_pos, mountain_offset, solar_return_pos,
            lunar_return_pos;

    public double magnetic_shift, true_north_magnetic_shift;

    public double angle_offset;

    public String magnetic_shift_message;

    public Hashtable birth_table, day_table, now_table, master_table,
            fixstar_table;

    public LinkedList good_styles, bad_styles, asteroid_list;

    public LinkedList ten_god_list, ten_god_list_org, ten_god_list_alt;

    public double[] birth_loc = new double[2], now_loc = new double[2];

    public double[] lunar_transits;

    public int[] birth_dst_date = new int[5], birth_adj_date = new int[5];

    public int[] now_dst_date = new int[5], now_adj_date = new int[5];

    public String birth_base_time, now_base_time;

    public Date now_date;

    public double now_degree, now_start_degree, now_end_degree;

    public double primary_speed, birth_ref_ut, now_ref_ut;

    public boolean use_primary_speed, equatorial_orbit;

    public String house_override;

    public String day_or_night, age_label, now_year;

    public String center_tip, birth_sign_tip, now_sign_tip;

    public String[] astro_sign_data = new String[2];

    public String astro_cusp_data, horiz_sign_data;

    public int[] astro_elemental = new int[4];

    public int[] astro_elemental_state = new int[3];

    public boolean show_now_set, show_aspects_set, show_gauquelin_set,
            show_fixstar_set, show_horiz_set;

    public boolean show_now, show_aspects, show_gauquelin, show_fixstar,
            show_compass, show_horiz, day_set, explain_star, no_color,
            dual_ring, single_wheel_mode;

    public boolean[] three_danger;

    public int time_adjust;

    public String[] birth_poles = new String[6], now_poles = new String[6];

    public String[] weak_house = new String[6], solid_house = new String[6];

    public Calendar calendar = Calendar.getInstance();

    public Calendar work_cal = Calendar.getInstance();

    public BaseTab tab, pole_tab, eval_tab;

    public DataEntry birth, now, cur_loc;
    
    public double[] nowYearPosition;
    
    public String good_pattern;
    
    public String bad_pattern;
    
}

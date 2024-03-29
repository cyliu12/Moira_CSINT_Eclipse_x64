package csharp.moira;

//
//Moira - A Chinese Astrology Charting Program
//Copyright (C) 2004-2015 At Home Projects
//
//This program is free software; you can redistribute it and/or modify
//it under the terms of the GNU General Public License as published by
//the Free Software Foundation; either version 2 of the License, or
//(at your option) any later version.
//
//This program is distributed in the hope that it will be useful,
//but WITHOUT ANY WARRANTY; without even the implied warranty of
//MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
//GNU General Public License for more details.
//
//You should have received a copy of the GNU General Public License
//along with this program; if not, write to the Free Software
//Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
//


import org.athomeprojects.base.BaseCalendar;
import org.athomeprojects.base.City;
import org.athomeprojects.base.Geomag;
import org.athomeprojects.base.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class InjLocationSpinner {
 private final int TRADITIONAL_CITY_WIDTH = 120;

 private final int SIMPLIFIED_CITY_WIDTH = 110;

 private boolean city_match = false, allow_city_match = true, layout = true,
         city_trim = false;

 private double longitude, latitude;

 //private Combo country, city, zone;
 private String country, city, zone;

 //private Combo focus, last_focus;

 //private Composite city_zone;
 private String city_zone;

 //private Text magnetic_shift;
 private String magnetic_shift;

 //private RepeatingButton up_button_1, down_button_1;

 //private RepeatingButton up_button_2, down_button_2;

 private String country_selected, city_selected;

 private int limit_width;

 public InjLocationSpinner()
 {
     /*super(parent, style);
     setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
     focus = last_focus = null;
     country = city = zone = null;
     longitude = latitude = City.INVALID;*/
 }

 public void init(String file_name)
 {
     City.loadCities(file_name);
     /*GridLayout grid_layout = new GridLayout(2, false);
     grid_layout.horizontalSpacing = grid_layout.verticalSpacing = 0;
     grid_layout.marginWidth = grid_layout.marginHeight = 0;
     setLayout(grid_layout);
     {
         country = new Combo(this, SWT.DROP_DOWN);
         country.setVisibleItemCount(20);
         country.setToolTipText(Resource.getString("tip_select_country"));
         setFields(country, City.getCountryList(), 0, null);
         country_selected = getCountryName();
         country.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
         country.addTraverseListener(new TraverseListener() {
             public void keyTraversed(TraverseEvent event)
             {
                 traverse(country, event);
             }
         });
         country.addFocusListener(this);
         country.addSelectionListener(new SelectionAdapter() {
             public void widgetSelected(SelectionEvent event)
             {
                 updateFields();
             }
         });
     }
     {
         final Composite button_holder = new Composite(this, SWT.NO_FOCUS);
         GridData grid_data = new GridData(GridData.FILL_VERTICAL);
         button_holder.setLayoutData(grid_data);
         button_holder.setLayout(new FillLayout(SWT.VERTICAL));
         up_button_1 = new RepeatingButton(button_holder, SWT.ARROW
                 | SWT.CENTER | SWT.UP | SWT.NO_FOCUS);
         up_button_1.addSelectionListener(new SelectionAdapter() {
             public void widgetSelected(SelectionEvent event)
             {
                 incrementInternal(country, 1);
             }
         });
         up_button_1.addMouseListener(new MouseAdapter() {
             public void mouseUp(MouseEvent event)
             {
                 updateFields();
             }
         });
         down_button_1 = new RepeatingButton(button_holder, SWT.ARROW
                 | SWT.CENTER | SWT.DOWN | SWT.NO_FOCUS);
         down_button_1.addSelectionListener(new SelectionAdapter() {
             public void widgetSelected(SelectionEvent event)
             {
                 incrementInternal(country, -1);
             }
         });
         down_button_1.addMouseListener(new MouseAdapter() {
             public void mouseUp(MouseEvent event)
             {
                 updateFields();
             }
         });
     }
     city_zone = new Composite(this, SWT.NONE);
     city_zone.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
     grid_layout = new GridLayout(2, true);
     grid_layout.horizontalSpacing = grid_layout.verticalSpacing = 0;
     grid_layout.marginWidth = grid_layout.marginHeight = 0;
     city_zone.setLayout(grid_layout);
     {
         city = new Combo(city_zone, SWT.DROP_DOWN);
         city.setVisibleItemCount(20);
         city.setToolTipText(Resource.getString("tip_select_city"));
         city.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
         setFields(city, City.getCityList(getCountryName()), 0, null);
         city_selected = getCityName();
         city.addTraverseListener(new TraverseListener() {
             public void keyTraversed(TraverseEvent event)
             {
                 traverse(null, event);
             }
         });
         city.addFocusListener(this);
         city.addSelectionListener(new SelectionAdapter() {
             public void widgetSelected(SelectionEvent event)
             {
                 updateFields();
             }
         });
         city.addKeyListener(new KeyAdapter() {
             public void keyReleased(KeyEvent event)
             {
                 trimCities(city, City.getCityList(getCountryName()), city
                         .getText().trim());
             }
         });
     }
     {
         zone = new Combo(city_zone, SWT.DROP_DOWN);
         zone.setVisibleItemCount(20);
         zone.setToolTipText(Resource.getString("tip_select_zone"));
         zone.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
         int[] date = new int[5];
         BaseCalendar.getCalendar(null, date);
         setFields(zone, City.getAllZoneNames(), 0, City.UNKNOWN_ZONE);
         setZone(country_selected, city_selected);
         zone.addTraverseListener(new TraverseListener() {
             public void keyTraversed(TraverseEvent event)
             {
                 traverse(null, event);
             }
         });
         zone.addFocusListener(this);
     }
     {
         final Composite button_holder = new Composite(this, SWT.NO_FOCUS);
         GridData grid_data = new GridData(GridData.FILL_VERTICAL);
         button_holder.setLayoutData(grid_data);
         button_holder.setLayout(new FillLayout(SWT.VERTICAL));
         up_button_2 = new RepeatingButton(button_holder, SWT.ARROW
                 | SWT.CENTER | SWT.UP | SWT.NO_FOCUS);
         up_button_2.addSelectionListener(new SelectionAdapter() {
             public void widgetSelected(SelectionEvent event)
             {
                 incrementInternal(last_focus, 1);
             }
         });
         up_button_2.addMouseListener(new MouseAdapter() {
             public void mouseUp(MouseEvent event)
             {
                 updateFields();
             }
         });
         down_button_2 = new RepeatingButton(button_holder, SWT.ARROW
                 | SWT.CENTER | SWT.DOWN | SWT.NO_FOCUS);
         down_button_2.addSelectionListener(new SelectionAdapter() {
             public void widgetSelected(SelectionEvent event)
             {
                 incrementInternal(last_focus, -1);
             }
         });
         down_button_2.addMouseListener(new MouseAdapter() {
             public void mouseUp(MouseEvent event)
             {
                 updateFields();
             }
         });
     }
     focus = last_focus = city;*/
 }

 public void setAllowCityMatch(boolean set)
 {
     allow_city_match = set;
 }

 //public String setMagneticShift(int[] date, Text field)
 public String setMagneticShift(int[] date, String field)
 {
     String message = null;
     magnetic_shift = field;
     if (magnetic_shift != null) {
         double degree = Geomag.getMagneticShift(date, getLongitude(),
                 getLatitude());
         message = Geomag.outOfRangeMessage();
         //magnetic_shift.setText(City.formatLongLatitude(degree, true, true, false));
         magnetic_shift = City.formatLongLatitude(degree, true, true, false);
     }
     return message;
 }

 public String getCountryName()
 {
     //return country.getItem(getSelectionIndex(country));
	 return country;
 }

 public String getCityName()
 {
     /*int index = getSelectionIndex(city);
     if (index >= 0)
         return city.getItem(index);
     else
         return city.getText();*/
	 return city;
 }

 public String getZoneName()
 {
     //return zone.getItem(getSelectionIndex(zone));
	 return zone;
 }

 public double getLongitude()
 {
     City c = City.matchCity(getCityName(), getCountryName(), false);
     if (c != null)
         return c.getLongitude();
     else
         return longitude;
 }

 public double getLatitude()
 {
     City c = City.matchCity(getCityName(), getCountryName(), false);
     if (c != null)
         return c.getLatitude();
     else
         return latitude;
 }

 public void setName(String country_val, String city_val, String zone_val)
 {
     //layout = false;
     setCountryName(country_val);
     setCityName(city_val);
     if (zone_val != null)
         setZoneName(zone_val);
     //layout = true;
     //layout();
 }

 public void setCountryName(String name)
 {
     //setComboName(country, name);
	 country = name;
 }

 public void setCityName(String name)
 {
     //setComboName(city, name);
	 city = name;
 }

 public void setZoneName(String name)
 {
     //setComboName(zone, name);
	 zone = name;
 }

 public void resetCities()
 {
     /*if (!city_trim)
         return;
     String str = city.getText().trim();
     trimCities(city, City.getCityList(getCountryName()), "");
     city.setText(str);*/
 }
 /*
 private void setComboName(Combo combo, String name)
 {
     int n = combo.getItemCount();
     for (int i = 0; i < n; i++) {
         String str = combo.getItem(i);
         if (str.equals(name)) {
             if (combo.getSelectionIndex() == i) {
                 combo.clearSelection();
                 return;
             }
             combo.select(i);
             combo.clearSelection();
             //updateFields();
             return;
         }
     }
     if (combo == city) {
         combo.deselectAll();
         combo.setText(name);
         if (parseLongLatText(combo, true))
             matchCity();
         //updateFields();
     }
 }
*/
 /*
 private boolean matchCity()
 {
     if (!allow_city_match)
         return false;
     City match = null;
     int iter;
     for (iter = 0; iter < 2; iter++) {
         match = City.matchCity(longitude, latitude,
                 (iter > 0) ? City.ANY_MATCH_ERROR_SQ : City.MATCH_ERROR_SQ);
         if (match != null)
             break;
     }
     if (match != null) {
         city_match = true;
         setComboName(country, match.getCountryName());
         if (iter == 0) {
             setComboName(city, match.getCityName());
         } else {
             city.deselectAll();
             city_selected = City.formatLongLatitude(longitude, true, true,
                     false)
                     + ", "
                     + City.formatLongLatitude(latitude, false, true, false);
             city.setText(city_selected);
         }
         city_match = false;
         return iter == 0;
     }
     return false;
 }
	*/
 /*
 protected void incrementInternal(Combo combo, int inc)
 {
     int index = combo.getSelectionIndex() + inc;
     if (index < 0)
         index = combo.getItemCount() - 1;
     else if (index >= combo.getItemCount())
         index = 0;
     combo.select(index);
     combo.clearSelection();
 }*/

 /*protected int matchSelection(Combo combo)
 {
     String key = combo.getText();
     int n = combo.getItemCount();
     for (int i = 0; i < n; i++) {
         String str = combo.getItem(i);
         if (str.equalsIgnoreCase(key))
             return i;
     }
     return -1;
 }*/
 /*
 private void setFields(Combo combo, String[] fields, int index,
         String first_entry)
 {
     combo.removeAll();
     if (first_entry != null)
         combo.add(first_entry);
     for (int i = 0; i < fields.length; i++) {
         String name = fields[i];
         if (name.length() > 0) {
             combo.add(name);
         }
     }
     combo.select(index);
     combo.clearSelection();
 }*/
 /*
 private void trimCities(Combo combo, String[] fields, String filter)
 {
     combo.remove(0, combo.getItemCount() - 1);
     int match = 0;
     for (int i = 0; i < fields.length; i++) {
         String name = fields[i];
         if (name.length() > 0 && name.indexOf(filter) >= 0) {
             match++;
         }
     }
     for (int i = 0; i < fields.length; i++) {
         String name = fields[i];
         if (name.length() > 0 && (match < 1 || name.indexOf(filter) >= 0)) {
             combo.add(name);
         }
     }
     city_trim = combo.getItemCount() < fields.length;
 }
 */
 /*
 private void traverse(Combo combo, TraverseEvent event)
 {
     switch (event.detail) {
         case SWT.TRAVERSE_ARROW_PREVIOUS:
             if (event.keyCode == SWT.ARROW_UP) {
                 event.doit = true;
                 event.detail = SWT.NONE;
                 if (combo == null) {
                     setFocusControl();
                     incrementInternal(focus, 1);
                     updateFields();
                     if (focus != null)
                         last_focus = focus;
                 } else {
                     incrementInternal(combo, 1);
                     updateFields();
                 }
             }
             break;
         case SWT.TRAVERSE_ARROW_NEXT:
             if (event.keyCode == SWT.ARROW_DOWN) {
                 event.doit = true;
                 event.detail = SWT.NONE;
                 if (combo == null) {
                     setFocusControl();
                     incrementInternal(focus, -1);
                     updateFields();
                     if (focus != null)
                         last_focus = focus;
                 } else {
                     incrementInternal(combo, -1);
                     updateFields();
                 }
             }
             break;
     }
 }
	*/
 /*
 private int getSelectionIndex(Combo combo)
 {
     int index = combo.getSelectionIndex();
     if (index < 0) {
         index = matchSelection(combo);
         if (index < 0) {
             if (combo == city) {
                 if (parseLongLatText(combo, true)) {
                     if (matchCity()) {
                         return combo.getSelectionIndex();
                     } else {
                         return -1;
                     }
                 }
             }
             index = 0;
         }
         combo.select(index);
         combo.clearSelection();
         //updateFields();
         return index;
     } else {
         return index;
     }
 }*/
 /*
 private boolean parseLongLatText(Combo combo, boolean set)
 {
     double[] long_lat = new double[2];
     if (City.parseLongLatitude(combo.getText(), long_lat)) {
         if (set) {
             longitude = long_lat[0];
             latitude = long_lat[1];
             combo.setText(City.formatLongLatitude(longitude, true, true,
                     false)
                     + ", "
                     + City.formatLongLatitude(latitude, false, true, false));
         }
         return true;
     }
     return false;
 }
 */
 /*
 private void updateFields()
 {
     if (!country_selected.equals(getCountryName())) {
         country_selected = getCountryName();
         setFields(city, City.getCityList(country_selected), 0, null);
         city_selected = getCityName();
         setZone(country_selected, city_selected);
     } else if (!city_match && !city_selected.equals(getCityName())) {
         city_selected = getCityName();
         setZone(country_selected, city_selected);
     }
     if (magnetic_shift != null) {
         double degree = Geomag.getMagneticShift(null, getLongitude(),
                 getLatitude());
         magnetic_shift.setText(City.formatLongLatitude(degree, true, true,
                 false));
     }
     if (layout)
         //layout();
 }
  */
 /*
 private void setZone(String country_name, String city_name)
 {
     if (country_name == null || city_name == null)
         return;
     City c = City.matchCity(getCityName(), getCountryName(), false);
     if (c != null) {
         int z_len = zone.getItemCount();
         for (int j = 0; j < z_len; j++) {
             String z_name = zone.getItem(j);
             if (z_name.equals(c.getZoneName())) {
                 zone.select(j);
                 zone.clearSelection();
                 break;
             }
         }
     }
 }
	*/
 /*
 protected void setFocusControl()
 {
     if (city.isFocusControl())
         focus = city;
     else if (zone.isFocusControl())
         focus = zone;
     else
         focus = null;
 }

 public void limitWidth(int width)
 {
     limit_width = width;
 }*/
/*
 public Point computeSize(int wHint, int hHint, boolean changed)
 {
     Point size = new Point(0, 0);
     Point row_1 = computeComboSize(country, 0, wHint, hHint, changed);
     Point row_2 = computeComboSize(city, 0, wHint, hHint, changed);
     if (limit_width > 0) {
         size.x = limit_width;
     } else {
         Point s = computeComboSize(zone, 0, wHint, hHint, changed);
         row_2.x += s.x;
         size.x = Math.max(row_1.x, row_2.x);
     }
     size.y = row_1.y + row_2.y;
     return size;
 }
 */
 /*
 private Point computeComboSize(Combo combo, int width, int wHint,
         int hHint, boolean changed)
 {
     Point size = combo.computeSize(wHint, hHint, changed);
     if (combo == city)
         size.x = Resource.isSimplifiedLocale() ? SIMPLIFIED_CITY_WIDTH
                 : TRADITIONAL_CITY_WIDTH;
     size.x += width;
     if ((getStyle() & SWT.BORDER) != 0) {
         int border = getBorderWidth();
         size.x += border * 2;
         size.y += border * 2 + 3;
     }
     size.y = (size.y + 1) & ~1;
     return size;
 }
*/
 /*
 public void focusGained(FocusEvent focusEvent)
 {
     setFocusControl();
     updateFields();
     if (focus != null)
         last_focus = focus;
 }

 public void focusLost(FocusEvent focusEvent)
 {
     if (!city.isFocusControl()) {
         resetCities();
     }
 }
 */
}
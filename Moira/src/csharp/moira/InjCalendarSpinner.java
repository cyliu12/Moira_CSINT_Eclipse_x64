package csharp.moira;

/*
 * CalendarSelect.java (Modified). Original Author: Sergey Prigogin
 * swtcalendar.sourceforge.net This program is free software; you can
 * redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version. This program is
 * distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details. You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */


//import java.text.DateFormatSymbols;
//import java.text.DecimalFormat;
import java.util.Calendar;

import org.athomeprojects.base.BaseCalendar;
/*import org.athomeprojects.base.Resource;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.TraverseEvent;
import org.eclipse.swt.events.TraverseListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
*/
public class InjCalendarSpinner {
	//static private final int YEAR_START = 1900;

	//static private final int YEAR_END = 2100;

	//private boolean modify;

	private Calendar calendar = Calendar.getInstance();

	//private CCombo month, year, day, hour, minute, am_pm;
	private int month, year, day, hour, minute, am_pm;
	//private CCombo focus, last_focus;

	//private DecimalFormat fill_format = new DecimalFormat("00");

	//private RepeatingButton up_button;

	//private RepeatingButton down_button;

	private int[] date_buf = new int[5];

	//public InjCalendarSpinner(Composite parent, int style) {
	public InjCalendarSpinner() {
		/*
		super(parent, style);
		setBackground(getDisplay().getSystemColor(SWT.COLOR_WHITE));
		focus = last_focus = null;
		modify = false;
		*/
	}

	public void init(boolean lunar) {
		/*
		final GridLayout grid_layout = new GridLayout();
		grid_layout.numColumns = 8;
		grid_layout.verticalSpacing = 0;
		grid_layout.marginWidth = 0;
		grid_layout.marginHeight = 0;
		grid_layout.horizontalSpacing = 0;
		setLayout(grid_layout);		
		{
			month = new CCombo(this, SWT.DROP_DOWN);
			month.setVisibleItemCount(12);
			month.setToolTipText(Resource.getString("tip_select_month"));
			DateFormatSymbols dateFormatSymbols = new DateFormatSymbols();
			String[] names = dateFormatSymbols.getShortMonths();
			for (int i = 0; i < names.length; i++) {
				String name = names[i];
				if (name.length() > 0) {
					month.add(name);
				}
			}
			final GridData grid_data = new GridData(GridData.FILL_HORIZONTAL);
			month.setLayoutData(grid_data);
			month.addTraverseListener(new TraverseListener() {
				public void keyTraversed(TraverseEvent event) {
					traverse(event);
				}
			});
			month.addFocusListener(this);
		}
		{
			day = new CCombo(this, SWT.DROP_DOWN);
			int num_day = lunar ? 30 : 31;
			day.setVisibleItemCount(num_day);
			day.setToolTipText(Resource.getString("tip_select_day"));
			for (int i = 1; i <= num_day; i++) {
				day.add(Integer.toString(i));
			}
			final GridData grid_data = new GridData(GridData.FILL_HORIZONTAL);
			day.setLayoutData(grid_data);
			day.addTraverseListener(new TraverseListener() {
				public void keyTraversed(TraverseEvent event) {
					traverse(event);
				}
			});
			day.addFocusListener(this);
		}
		{
			year = new CCombo(this, SWT.DROP_DOWN);
			year.setVisibleItemCount(20);
			year.setToolTipText(Resource.getString("tip_select_year"));
			for (int i = YEAR_START; i <= YEAR_END; i++) {
				year.add(Integer.toString(i));
			}
			final GridData grid_data = new GridData(GridData.FILL_HORIZONTAL);
			year.setLayoutData(grid_data);
			year.addTraverseListener(new TraverseListener() {
				public void keyTraversed(TraverseEvent event) {
					traverse(event);
				}
			});
			year.addFocusListener(this);
		}
		{
			hour = new CCombo(this, SWT.DROP_DOWN);
			hour.setVisibleItemCount(12);
			hour.setToolTipText(Resource.getString("tip_select_hour"));
			for (int i = 0; i < 12; i++) {
				hour.add((i == 0) ? "12" : fill_format.format(i));
			}
			final GridData grid_data = new GridData(GridData.FILL_HORIZONTAL);
			hour.setLayoutData(grid_data);
			hour.addTraverseListener(new TraverseListener() {
				public void keyTraversed(TraverseEvent event) {
					traverse(event);
				}
			});
			hour.addFocusListener(this);
		}
		{
			Label label = new Label(this, SWT.NONE);
			label.setText(":");
		}
		{
			minute = new CCombo(this, SWT.DROP_DOWN);
			minute.setVisibleItemCount(30);
			minute.setToolTipText(Resource.getString("tip_select_minute"));
			for (int i = 0; i < 60; i++) {
				minute.add(fill_format.format(i));
			}
			final GridData grid_data = new GridData(GridData.FILL_HORIZONTAL);
			minute.setLayoutData(grid_data);
			minute.addTraverseListener(new TraverseListener() {
				public void keyTraversed(TraverseEvent event) {
					traverse(event);
				}
			});
			minute.addFocusListener(this);
		}
		{
			am_pm = new CCombo(this, SWT.DROP_DOWN);
			am_pm.setToolTipText(Resource.getString("tip_select_ampm"));
			DateFormatSymbols symbol = new DateFormatSymbols();
			String[] am_pm_name = symbol.getAmPmStrings();
			am_pm.add(am_pm_name[0]);
			am_pm.add(am_pm_name[1]);
			final GridData grid_data = new GridData(GridData.FILL_HORIZONTAL);
			am_pm.setLayoutData(grid_data);
			am_pm.addTraverseListener(new TraverseListener() {
				public void keyTraversed(TraverseEvent event) {
					traverse(event);
				}
			});
			am_pm.addFocusListener(this);
		}
		{
			final Composite button_holder = new Composite(this, SWT.NO_FOCUS);
			final GridData grid_data = new GridData(
					GridData.HORIZONTAL_ALIGN_FILL | GridData.FILL_VERTICAL);
			button_holder.setLayoutData(grid_data);
			button_holder.setLayout(new FillLayout(SWT.VERTICAL));
			up_button = new RepeatingButton(button_holder, SWT.ARROW
					| SWT.CENTER | SWT.UP | SWT.NO_FOCUS);
			up_button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					incrementInternal(last_focus, 1);
				}
			});
			down_button = new RepeatingButton(button_holder, SWT.ARROW
					| SWT.CENTER | SWT.DOWN | SWT.NO_FOCUS);
			down_button.addSelectionListener(new SelectionAdapter() {
				public void widgetSelected(SelectionEvent event) {
					incrementInternal(last_focus, -1);
				}
			});
		}
		setTabList(new Control[] { month, day, year, hour, minute, am_pm });
		focus = last_focus = year;
		*/
		//modify = true;
		setDate();
		//modify = false;
	}

	public void reset() {
		calendar.setTime(Calendar.getInstance().getTime());
		setDate();
	}

	public void getCalendar(int[] date) { //把calendar的時間存進date
		getDate();
		BaseCalendar.getCalendar(calendar, date);
	}

	public void setCalendar(int[] date) { //把date的時間存進calendar
		if (date == null) {
			reset();
			return;
		}
		BaseCalendar.setTime(calendar, date);
		setDate();
	}
	/*
	protected void incrementInternal(CCombo combo, int inc) {
		if (modify || combo == null)
			return;
		modify = true;
		getDate();
		if (combo == year)
			calendar.add(Calendar.YEAR, inc);
		else if (combo == month)
			calendar.add(Calendar.MONTH, inc);
		else if (combo == day)
			calendar.add(Calendar.DAY_OF_MONTH, inc);
		else if (combo == hour)
			calendar.add(Calendar.HOUR_OF_DAY, inc);
		else if (combo == minute)
			calendar.add(Calendar.MINUTE, inc);
		else if (combo == am_pm) {
			int h = calendar.get(Calendar.HOUR_OF_DAY);
			if (h < 12)
				calendar.add(Calendar.HOUR_OF_DAY, 12);
			else
				calendar.add(Calendar.HOUR_OF_DAY, -12);
		}
		setDate();
		modify = false;
	}
	 */
	protected void getDate() { //原是從UI取得時間，再將時間存入calendar。 在沒有UI的狀況下，直接取得year等int變數的值即可
		//date_buf[0] = year.getSelectionIndex();
		date_buf[0] = year;
		//date_buf[1] = month.getSelectionIndex();
		date_buf[1] = month+1;
		//date_buf[2] = day.getSelectionIndex();
		date_buf[2] = day+1;
		//date_buf[3] = hour.getSelectionIndex();
		date_buf[3] = hour;
		//date_buf[4] = minute.getSelectionIndex();
		date_buf[4] = minute;
		//int s = am_pm.getSelectionIndex();
		int s = am_pm;
		/*
		if (date_buf[0] < 0) { //原本<0表示無選取，是使用者自行輸入時間
			String str = year.getText();
			try {
				date_buf[0] = Integer.parseInt(str);  //取得使用者輸入的時間
			} catch (NumberFormatException e) {
				date_buf[0] = Calendar.getInstance().get(Calendar.YEAR);  //輸入無效敗使用當下時間
			}			
		} else {
			date_buf[0] += YEAR_START;
		}
		if (date_buf[1] < 0)
			date_buf[1] = matchSelection(month);
		date_buf[1]++;
		if (date_buf[2] < 0)
			date_buf[2] = matchSelection(day);
		date_buf[2]++;
		if (date_buf[3] < 0)
			date_buf[3] = matchSelection(hour);
		if (date_buf[4] < 0)
			date_buf[4] = matchSelection(minute);
		if (s < 0)
			s = matchSelection(am_pm);*/
		if (s == 1)
			date_buf[3] += 12;
		BaseCalendar.setTime(calendar, date_buf); //將date_buf的時間存入calendar
	}
	/*
	protected int matchSelection(CCombo combo) {
		String key = combo.getText();
		int n = combo.getItemCount();
		for (int i = 0; i < n; i++) {
			String str = combo.getItem(i);
			if (str.equalsIgnoreCase(key))
				return i;
		}
		return 0;
	}
	*/
	protected void setDate() {
		BaseCalendar.getTime(calendar, date_buf);  //將calendar的時間存入date_buf
		/*沒有UI不需處理這一段
		if (date_buf[0] >= YEAR_START && date_buf[0] <= YEAR_END) {
			year.select(date_buf[0] - YEAR_START);			
		} else {
			year.deselectAll();
			year.setText(Integer.toString(date_buf[0]));			
		}*/
		year = date_buf[0];
		//month.select(date_buf[1] - 1);
		month = date_buf[1] - 1;
		//day.select(date_buf[2] - 1);
		day = date_buf[2] - 1;
		//minute.select(date_buf[4]);
		minute = date_buf[4];
		if (date_buf[3] >= 12) {
			date_buf[3] -= 12;
			//am_pm.select(1);
			am_pm = 1;
		} else {
			//am_pm.select(0);
			am_pm = 0;
		}
		//hour.select(date_buf[3]);
		hour = date_buf[3];
	}
	/*
	private void traverse(TraverseEvent event) {
		switch (event.detail) {
		case SWT.TRAVERSE_ARROW_PREVIOUS:
			if (event.keyCode == SWT.ARROW_UP) {
				event.doit = true;
				event.detail = SWT.NONE;
				setFocusControl();
				incrementInternal(focus, 1);
				if (focus != null)
					last_focus = focus;
			}
			break;
		case SWT.TRAVERSE_ARROW_NEXT:
			if (event.keyCode == SWT.ARROW_DOWN) {
				event.doit = true;
				event.detail = SWT.NONE;
				setFocusControl();
				incrementInternal(focus, -1);
				if (focus != null)
					last_focus = focus;
			}
			break;
		}
	}

	protected void setFocusControl() {
		if (month.isFocusControl())
			focus = month;
		else if (day.isFocusControl())
			focus = day;
		else if (year.isFocusControl())
			focus = year;
		else if (hour.isFocusControl())
			focus = hour;
		else if (minute.isFocusControl())
			focus = minute;
		else if (am_pm.isFocusControl())
			focus = am_pm;
		else
			focus = null;
	}

	public Point computeSize(int wHint, int hHint, boolean changed) {
		Point size = computeComboSize(year, 0, wHint, hHint, changed);
		Point s = computeComboSize(month, 0, wHint, hHint, changed);
		size.x += s.x;
		s = computeComboSize(day, 0, wHint, hHint, changed);
		size.x += s.x;
		s = computeComboSize(hour, 0, wHint, hHint, changed);
		size.x += s.x;
		s = computeComboSize(minute, 0, wHint, hHint, changed);
		size.x += s.x;
		s = computeComboSize(am_pm, 0, wHint, hHint, changed);
		size.x += s.x;
		return size;
	}

	protected Point computeComboSize(CCombo combo, int width, int wHint,
			int hHint, boolean changed) {
		Point size = combo.computeSize(wHint, hHint, changed);
		size.x += width;
		if ((getStyle() & SWT.BORDER) != 0) {
			int border = getBorderWidth();
			size.x += border * 2;
			size.y += border * 2 + 3;
		}
		size.y = (size.y + 1) & ~1;
		return size;
	}

	public void focusGained(FocusEvent focusEvent) {
		if (modify)
			return;
		setFocusControl();
		if (focus != null)
			last_focus = focus;
	}

	public void focusLost(FocusEvent focusEvent) {
	}
	*/
}
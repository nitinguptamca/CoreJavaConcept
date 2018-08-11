package com.immutable;

import java.util.Date;

public final class MyBean {

	private  Date date; // Immutable Date Step 1 Make Private

	public MyBean(final Date date) {
		// Immutable Date Step 2 If Set through Constructor then get a specialised (sub
		// class) Date.
		this.date = getImmutableDate(date); // THIS METHOD RETURNS AN IMMUTABLE DATE
	}

	public Date getDate() {
		return date;
	}

	// Immutable Date Step 3- Allow setting of date only once!!
	public void setDate(Date date) {
		if (this.date == null) {
			this.date = getImmutableDate(date);
		}
	}

	/*
	 * Override all Setter methods of Date class. So even if user gets reference of
	 * Date Object it is not the original date object it would be a modified date
	 * object whose all setter methods do nothing
	 */
	private Date getImmutableDate(Date date) {
		/*
		 * This is an Anonymous Inner Class that extends java.util.Date class, it
		 * overrides all the setter methods making the date object IMMUTABLE( i.e setXXX
		 * has no effect)
		 */
		date = new Date(date.getTime()) {
			private static final long serialVersionUID = 1L;

			@Override
			public void setYear(int year) {
			}

			@Override
			public void setMonth(int month) {
			}

			@Override
			public void setDate(int date) {
			}

			@Override
			public void setHours(int hours) {
			}

			@Override
			public void setMinutes(int minutes) {
			}

			@Override
			public void setSeconds(int seconds) {
			}

			@Override
			public void setTime(long time) {
			}

		};
		return date;
	}
}
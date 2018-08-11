package com.immutable;

import java.util.*;

public final class Movie {

	public Movie(String aTitle, long aReleaseDate, Collection<String> friends) {
		this.fTitle = aTitle;
		this.fReleaseDate = aReleaseDate;
		this.friends = new ArrayList(friends);
	}

	public Movie(String aTitle, Date aReleaseDate, Collection<String> friends) {
		this(aTitle, aReleaseDate.getTime(), new ArrayList(friends));
		;
	}

	/**
	 * The caller of this method decides on the presentation format of the date, if
	 * necessary.
	 */
	public long getReleaseDate() {
		return fReleaseDate;
	}

	public String getTitle() {
		return fTitle;
	}

	public Collection<String> getFriends() {
		return Collections.unmodifiableCollection(this.friends);
	}

	// ..other methods elided

	// PRIVATE
	private String fTitle;
	private long fReleaseDate;
	private final Collection<String> friends;
}

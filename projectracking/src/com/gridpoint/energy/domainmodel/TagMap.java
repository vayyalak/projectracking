package com.gridpoint.energy.domainmodel;

import java.util.HashMap;

public class TagMap<K, V> extends HashMap<K, V> {
	private static final long serialVersionUID = 1L;

	public TagMap() {
	}

	public TagMap(TagMap<K, V> that) {
		super(that);
	}
}
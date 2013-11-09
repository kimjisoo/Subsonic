/*
	This file is part of Subsonic.
	
	Subsonic is free software: you can redistribute it and/or modify
	it under the terms of the GNU General Public License as published by
	the Free Software Foundation, either version 3 of the License, or
	(at your option) any later version.
	
	Subsonic is distributed in the hope that it will be useful,
	but WITHOUT ANY WARRANTY; without even the implied warranty of
	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
	GNU General Public License for more details.
	
	You should have received a copy of the GNU General Public License
	along with Subsonic. If not, see <http://www.gnu.org/licenses/>.
	
	Copyright 2010 (C) Sindre Mehus
*/

package github.daneren2005.dsub.view;

import android.content.Context;
import android.util.Log;
import java.util.List;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import github.daneren2005.dsub.domain.Bookmark;
import github.daneren2005.dsub.domain.MusicDirectory;

public class BookmarkAdapter extends ArrayAdapter<Bookmark> {
	private final static String TAG = BookmarkAdapter.class.getSimpleName();
	
	public EntryAdapter(Context activity, List<Bookmark> bookmarks) {
		super(activity, android.R.layout.simple_list_item_1, bookmarks);
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		MusicDirectory.Entry entry = getItem(position).getEntry();
		SongView view;
		if (convertView != null) {
			view = (SongView) convertView;
		} else {
			view = new SongView(activity);
		}
		view.setObject(entry, false);
		return view;
	}
}
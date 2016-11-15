package dao;

import java.util.List;

import bean.Novel;

public interface NovelDAO {
	public Novel findNovelbyName(String name);
	public List<Novel>findNovelbyItem(String item,String condition);
	public List<Novel>findAllNovel();
	public void addNovel(Novel novel);
	public void delNovel(String name);
	}



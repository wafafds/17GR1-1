package org.news.dao;

import java.util.List;

import org.news.entity.News;

public interface NewsDao {
  
    public List<News> getAllnews();
    public List<News> getAllnewsByTID(int Tid);
    public List<News> getAllnewsByTname(String tname);
    public int getNewsCountByTID(int Tid);
    public List<News> getLatestNewsByTID(int tid, int limit);
}
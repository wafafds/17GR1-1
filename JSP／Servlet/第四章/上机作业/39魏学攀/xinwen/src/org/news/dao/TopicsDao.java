package org.news.dao;

import java.util.List;
import org.news.entity.Topic;

public interface TopicsDao {
    public List<Topic> getAllTopics();
    public int updateTopic(Topic topic);
    public Topic findTopicByName(String name);
    public int addTopic(String name);
    public int deleteTopic(int tid);
}
<%@page import="org.news.util.Page"%>
<%@page import="org.news.service.CommentsService"%>
<%@page import="org.news.service.impl.CommentsServiceImpl"%>
<%@page import="org.news.service.NewsService"%>
<%@page import="org.news.service.impl.NewsServiceImpl"%>
<%@page import="org.news.service.TopicsService"%>
<%@page import="org.news.service.impl.TopicsServiceImpl"%>
<%@page import="org.news.entity.*"%>
<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="utf-8"%>
<%
    request.setCharacterEncoding("utf-8");
    String opr = request.getParameter("opr");
    TopicsService topicService = new TopicsServiceImpl();
    NewsService newsService = new NewsServiceImpl();
    CommentsService commentsService = new CommentsServiceImpl();

    if (opr.equals("addComment")) {
        String cauthor = request.getParameter("cauthor");
        String cnid = request.getParameter("nid");
        String cip = request.getParameter("cip");
        String ccontent = request.getParameter("ccontent");
        Comment comment = new Comment();
        comment.setCnid(Integer.parseInt(cnid));
        comment.setCcontent(ccontent);
        comment.setCdate(new java.util.Date());
        comment.setCip(cip);
        comment.setCauthor(cauthor);
        try {
            commentsService.addComment(comment);
            out.print("<script type=\"text/javascript\">");
            out.print("alert(\"评论成功，点击确认返回原来页面\");");
            out.print("location.href=\"../util/news_control.jsp?opr=readNew&nid="
                    + cnid + "\";");
            out.print("</script>");
        } catch (Exception e) {
            out.print("<script type=\"text/javascript\">");
            out.print("alert(\"评论添加失败！请联系管理员查找原因！点击确认返回原来页面\");");
            out.print("location.href=\"../util/news_control.jsp?opr=readNew&nid="
                    + cnid + "\";");
            out.print("</script>");
        }
    } else if ("readNew".equals(opr)) {
        String nid = request.getParameter("nid");
        News news = newsService.findNewsByNid(Integer.parseInt(nid));
        news.setComments(commentsService.findCommentsByNid(Integer
                .parseInt(nid)));
        Map<Integer, Integer> topics = new HashMap<Integer, Integer>();
        topics.put(1, 5);
        topics.put(2, 5);
        topics.put(5, 5);
        List<List<News>> latests = newsService
                .findLatestNewsByTid(topics);
        request.setAttribute("news", news);
        request.setAttribute("list1", latests.get(0));
        request.setAttribute("list2", latests.get(1));
        request.setAttribute("list3", latests.get(2));
        request.getRequestDispatcher("/newspages/news_read.jsp")
                .forward(request, response);
    } else if ("listTitle".equals(opr)) {
        Map<Integer, Integer> topics = new HashMap<Integer, Integer>();
        topics.put(1, 5);
        topics.put(2, 5);
        topics.put(5, 5);
        List<List<News>> latests = newsService
                .findLatestNewsByTid(topics);
        List<Topic> list = topicService.findAllTopics();
        List<News> list4 = null;
        String tid = request.getParameter("tid");
        String pageIndex = request.getParameter("pageIndex");
        if (pageIndex == null
                || (pageIndex = pageIndex.trim()).length() == 0) {
            pageIndex = "1";
        }
        int currPageNo = Integer.parseInt(pageIndex);
        if (currPageNo < 1)
            currPageNo = 1;
        Page pageObj = new Page();
        pageObj.setCurrPageNo(currPageNo); 
        pageObj.setPageSize(15); // 
        if (tid == null || (tid = tid.trim()).length() == 0) {
            newsService.findPageNews(pageObj); 
            list4 = pageObj.getNewsList();
        } else
     
            list4 = newsService.findAllNewsByTid(Integer.parseInt(tid));
        request.setAttribute("list1", latests.get(0));
        request.setAttribute("list2", latests.get(1));
        request.setAttribute("list3", latests.get(2));
        request.setAttribute("list", list); 
        request.setAttribute("list4", list4);
        request.setAttribute("pageObj", pageObj);
        request.getRequestDispatcher("/index.jsp").forward(request,
                response);
    } else if ("list".equals(opr)) {
        List<News> list = newsService.findAllNews();
        session.setAttribute("list", list);
        response.sendRedirect("../newspages/admin.jsp");
    }
%>


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head><title>问卷调查</title></head>
    <body>
    <form id="regFrm" action="questionServlet" method="post">
        <table>
            <tr>
                <td>昵称:</td>
                <td><input id="username" name="username" type="text"></td>
            </tr>
            <tr>
                <td>所在城市:</td>
               <td><input id="city" name="city" type="text"></td>
            </tr>
            <tr>
                <td>您使用的开发语言:</td>
                <td>
                    <input name="languages" type="checkbox" value="Java">Java
                    <input name="languages" type="checkbox" value="C">C
                    <input name="languages" type="checkbox" value="C++">C++
                    <input name="languages" type="checkbox" value="PHP">PHP
                    <input name="languages" type="checkbox" value="ASP">ASP
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>
    </form>
    </body>
</html>


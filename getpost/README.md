# 🚀 Bài 1.1 & Bài 1.2 – Servlet doGET và doPOST

Project minh họa cách xây dựng Servlet sử dụng **doGet** và **doPost** trong Java Web (Jakarta Servlet) chạy trên **Apache Tomcat 10.1**.

---

## 📌 Bài 1.1 – Servlet doGET

### 🎯 Mục tiêu
Nhận dữ liệu từ client thông qua tham số trên URL và hiển thị lời chào.

### 🔗 URL chạy

http://localhost:8080/ViduGetPost/HelloGet


### 🧩 Servlet HelloGet.java
```java
@WebServlet("/HelloGet")
public class HelloGet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");

        if(name == null || name.isEmpty()){
            name = "bạn";
        }

        out.println("<h2>Xin chào " + name + "!</h2>");
    }
}
```
📌 Bài 1.2 – Servlet doPOST
🎯 Mục tiêu

Gửi dữ liệu từ form HTML bằng phương thức POST và hiển thị kết quả.

<form action="HelloPost" method="post">
    Họ tên: <input type="text" name="name">
    <button type="submit">Gửi</button>
</form>

@WebServlet("/HelloPost")
public class HelloPost extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");

        out.println("<h2>Xin chào " + name + " (POST)</h2>");
    }
}


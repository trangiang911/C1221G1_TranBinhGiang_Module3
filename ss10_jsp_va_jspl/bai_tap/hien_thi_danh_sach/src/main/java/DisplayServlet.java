import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "displayServlet", urlPatterns = {"/display12"})
public class DisplayServlet extends javax.servlet.http.HttpServlet {
    public List<KhachHang> listKH = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();

        listKH.add(new KhachHang("Mai Văn Hoan", "1983-08-20", "Hà Nồi", "url"));
        listKH.add(new KhachHang("Nguyễn Văn Nam", "1983-08-21", "Bắc Giang", "url"));
        listKH.add(new KhachHang("Nguyễn Thái Nam", "1983-08-22", "Nam Định", "url"));
        listKH.add(new KhachHang("Trần Đăng Khoa", "1983-08-17", "Hà Tây", "url"));
        listKH.add(new KhachHang("Nguyễn Đình Thi", "1983-08-19", "Hà Nội", "url"));
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String diaChi = request.getParameter("dia-chi");
        String avt = request.getParameter("anh");
        listKH.add(new KhachHang(name,date,diaChi,avt));
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setAttribute("name", listKH);
        request.getRequestDispatcher("/display.jsp").forward(request, response);
    }
}

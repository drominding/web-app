package Controller;

import Service.ProductService;
import vo.Product;
import vo.TbProduct;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addProduct")
public class addProducts extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try{
            req.setCharacterEncoding("utf-8");
            //获取参数
            String name = req.getParameter("name");
            //String mainID = req.getParameter("mainID");
            int mainID = Integer.parseInt(req.getParameter("mainID"));

            //保存实体参数
            TbProduct product = new TbProduct();
            product.setName(name);
            product.setCategoryMainId(mainID);

            //调用业务层，向数据库添加实体
            ProductService service = new ProductService();
            //获取添加结果
            boolean result = service.addProduct(product);
            // 将结果存储在会话中
            HttpSession session = req.getSession();
            System.out.println("存储结果为："+result);
            if (result) {
                session.setAttribute("message", "The addition was successful");
                //获取最后一个产品
                ProductService productService = new ProductService();
                List<TbProduct> productList = null;
                productList = productService.getLastProducts();
                System.out.println(productList);
                session.setAttribute("productList",productList);
            } else {
                session.setAttribute("message", "Failed to add");
            }

            if (result){
                System.out.println("The addition was successful");
            }else {
                System.out.println("Failed to add");

            }
            //显示添加数据


        } catch (Exception e) {
            e.printStackTrace();
            HttpSession session = req.getSession();
            session.setAttribute("message", "Failed to add");
        }
        resp.sendRedirect("1_ShowAllProduct.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req,resp);
    }
}

package com.example.demo2.resource;

import com.example.demo2.business.NhanVienBL;
import com.example.demo2.resource.model.Nhanvien;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.util.List;

@Path("/nhanvien")
public class NhanVienResource {
    @Inject
    private NhanVienBL nhanVienBL;


    @GET
    @Produces(MediaType.TEXT_HTML)
    public void getAllNhanVien(@Context HttpServletRequest request, @Context HttpServletResponse response) throws ServletException, IOException {
        List<Nhanvien> nhanviens = nhanVienBL.getNhanVien();
        request.setAttribute("nhanvien", nhanviens);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteNhanVien(@PathParam("id") int id) {
        nhanVienBL.deleteNhanVien(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/add")
    public Response showAddNhanVienPage() {
        return Response.ok().entity("<html><body><script>window.location.href = 'addNhanVien.jsp';</script></body></html>").build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response createNhanvien(
            @FormParam("id") Integer id,
            @FormParam("tennhanvien") String tennhanvien,
            @FormParam("email") String email,
            @FormParam("diachi") String diachi,
            @FormParam("dienthoai") Integer dienthoai,
            @FormParam("maphongban") Integer maphongban) {
        Nhanvien nv = new Nhanvien();
        nv.setId(id);
        nv.setTennhanvien(tennhanvien);
        nv.setEmail(email);
        nv.setDiachi(diachi);
        nv.setDienthoai(dienthoai);
        nhanVienBL.saveNhanvien(nv);
        return Response.status(Response.Status.CREATED).build();
    }
}

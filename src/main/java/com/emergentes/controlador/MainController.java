package com.emergentes.controlador;

import com.emergentes.modelo.Registro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();

        String opcion = (request.getParameter("op") != null) ? request.getParameter("op") : "view";

        if (ses.getAttribute("listares") == null) {
            ArrayList<Registro> listaux = new ArrayList<Registro>();
            ses.setAttribute("listares", listaux);
        }

        ArrayList<Registro> lista = (ArrayList<Registro>) ses.getAttribute("listares");
        
        Registro objres = new Registro();
        int id, pos;
        switch (opcion) {
            case "nuevo":
                request.setAttribute("regis", objres);
                request.getRequestDispatcher("registrar.jsp").forward(request, response);
                break;
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request, id);
                objres = lista.get(pos);
                request.setAttribute("regis", objres);
                request.getRequestDispatcher("registrar.jsp").forward(request, response);
                break;
            case "eliminar":
                pos = buscarIndice(request, Integer.parseInt(request.getParameter("id")));
                lista.remove(pos);
                ses.setAttribute("listares", lista);
                response.sendRedirect("index.jsp");
                break;
            case "view":
                response.sendRedirect("index.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        int primer = Integer.parseInt(request.getParameter("primer"));
        int segundo = Integer.parseInt(request.getParameter("segundo"));
        int exfinal = Integer.parseInt(request.getParameter("exfinal"));

        Registro objres = new Registro();
        objres.setId(Integer.parseInt(request.getParameter("id")));
        objres.setNombre(nombre);
        objres.setPrimer(primer);
        objres.setSegundo(segundo);
        objres.setExfinal(exfinal);

        HttpSession ses = request.getSession();
        ArrayList<Registro> lista = (ArrayList<Registro>) ses.getAttribute("listares");
        
        int idt = objres.getId();
        
        if(idt == 0){
            int ultID;
            ultID = ultimoId(request);
            objres.setId(ultID);
            lista.add(objres);
        }else{
            lista.set(buscarIndice(request, idt),objres);
        }
        ses.setAttribute("listares", lista);
        response.sendRedirect("index.jsp");
    }
    private int ultimoId(HttpServletRequest request){
        HttpSession ses = request.getSession();
        ArrayList<Registro> lista = (ArrayList<Registro>) ses.getAttribute("listares"); 
        
        int idaux = 0;
        
        for(Registro item : lista){
            idaux = item.getId();
        }
        return idaux + 1;
    }
    
    private int buscarIndice(HttpServletRequest request, int id){
        HttpSession ses = request.getSession();
        ArrayList<Registro> lista = (ArrayList<Registro>) ses.getAttribute("listares"); 
        
        int i = 0;
        if(lista.size() > 0){
            while(i < lista.size()){
                if(lista.get(i).getId() == id){
                    break;
                }else{
                    i++;
                }
            }
        }
        return i;
    }

}

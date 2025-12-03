/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import dao.UsuarioDAO;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import modelo.Usuario;

/**
 *
 * @author marce
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    private String email;
    private String password;
    private Usuario usuario;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public String login() {
        usuario = usuarioDAO.autenticar(email, password);
        
        if (usuario != null) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                    .getExternalContext().getSession(true);
            session.setAttribute("usuario", usuario);
            return "index?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                            "Error de autenticación", 
                            "Email o contraseña incorrectos"));
            return null;
        }
    }
    
    public String logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "login?faces-redirect=true";
    }
    
    public boolean isLoggedIn() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return session != null && session.getAttribute("usuario") != null;
    }
    
    public Usuario getUsuarioActual() {
        if (!isLoggedIn()) {
            return null;
        }
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        return (Usuario) session.getAttribute("usuario");
    }
    
    public void verificarSesion() {
        FacesContext context = FacesContext.getCurrentInstance();
        String viewId = context.getViewRoot().getViewId();
        
        // Si no está logueado y no está en la página de login, redirigir
        if (!isLoggedIn() && !viewId.contains("login.xhtml")) {
            try {
                context.getExternalContext()
                        .redirect(context.getExternalContext().getRequestContextPath() + "/faces/login.xhtml");
            } catch (IOException e) {
                System.out.println("Error al redirigir: " + e.getMessage());
            }
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

